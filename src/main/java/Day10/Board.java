package Day10;

import Day9.DataLine;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] inputBoard;
    char[][] supportBoard;
    int[][] distances;

    public Board(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            String line = scanner.nextLine();
            inputBoard = new char[line.length()][line.length()];
            distances = new int[line.length()][line.length()];
            supportBoard = new char[line.length()][line.length()];
            for (int j = 0; j < line.length(); j++) {
                inputBoard[j][0] = line.charAt(j);
            }
            int i = 1;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    inputBoard[j][i] = line.charAt(j);
                }
                i++;
            }
            zeroDistances();
        } catch (Exception e) {
            System.out.println(e);
        }
        countDistances();
    }

    public int task1() {
        int result = -1;
        for (int y = 0; y < inputBoard.length; y++) {
            for (int x = 0; x < inputBoard.length; x++) {
                if (distances[x][y] > result) result = distances[x][y];
            }
        }
        return result;
    }

    private void countDistances() {
        Point p1 = findStart();

        supportBoard[p1.x][p1.y] = '*';
        int currentDistance = 0;
        distances[p1.x][p1.y] = currentDistance;
        List<Point> starts = findStarts(p1);
        p1 = starts.get(0);
        Point p2 = starts.get(1);
        supportBoard[p1.x][p1.y] = '*';
        supportBoard[p2.x][p2.y] = '*';
        currentDistance++;
        distances[p1.x][p1.y] = currentDistance;
        distances[p2.x][p2.y] = currentDistance;
        do {
            currentDistance++;
            p1 = findNext(p1);
            p2 = findNext(p2);
            distances[p1.x][p1.y] = currentDistance;
            distances[p2.x][p2.y] = currentDistance;
            supportBoard[p1.x][p1.y] = '*';
            supportBoard[p2.x][p2.y] = '*';
        } while (!p1.equals(p2));
    }

    public int task2() {
        int result = 0;

//        for (int y = 0; y < inputBoard.length; y++) {
//
//            for (int x = 0; x < inputBoard.length; x++) {
//                System.out.print(supportBoard[x][y]);
//            }
//            System.out.print("\n");
//        }
        for (int y = 0; y < inputBoard.length; y++) {

            boolean inside = false;
            boolean fromTop = false;
            for (int x = 0; x < inputBoard.length; x++) {
                if (inside && supportBoard[x][y] == '.') {
                    result++;
                } else if (inputBoard[x][y] == '|' && supportBoard[x][y]=='*') {
                    inside = !inside;
                } else if (inputBoard[x][y] == 'L'&& supportBoard[x][y]=='*') {
                    fromTop = true;
                } else if (inputBoard[x][y] == 'F'&& supportBoard[x][y]=='*') {
                    fromTop = false;
                } else if (inputBoard[x][y] == '7' && fromTop && supportBoard[x][y]=='*') {
                    inside = !inside;
                } else if (inputBoard[x][y] == 'J' && !fromTop && supportBoard[x][y]=='*') {
                    inside = !inside;
                }
            }
        }
        return result;
    }

    private Point findNext(Point current) {
        List<Point> deltas = new ArrayList<>();
        char c = inputBoard[current.x][current.y];
        if (c == '|') {
            deltas.add(new Point(0, 1));
            deltas.add(new Point(0, -1));
        } else if (c == '-') {
            deltas.add(new Point(-1, 0));
            deltas.add(new Point(1, 0));
        } else if (c == 'L') {
            deltas.add(new Point(0, -1));
            deltas.add(new Point(1, 0));
        } else if (c == 'J') {
            deltas.add(new Point(0, -1));
            deltas.add(new Point(-1, 0));
        } else if (c == '7') {
            deltas.add(new Point(-1, 0));
            deltas.add(new Point(0, 1));
        } else if (c == 'F') {
            deltas.add(new Point(1, 0));
            deltas.add(new Point(0, 1));
        }

        for (Point p : deltas) {
            int newX = current.x + p.x;
            int newY = current.y + p.y;
            if (newX >= 0 && newX < inputBoard.length && newY >= 0 && newY < inputBoard.length && distances[newX][newY] == -1) {
                return (new Point(newX, newY));
            }
        }
        return null;
    }

    private List<Point> findStarts(Point current) {
        List<Point> result = new ArrayList<Point>();
        List<Point> deltas = new ArrayList<>();
        deltas.add(new Point(-1, 0));
        deltas.add(new Point(1, 0));
        deltas.add(new Point(0, 1));
        deltas.add(new Point(0, -1));

        for (Point p : deltas) {
            int newX = current.x + p.x;
            int newY = current.y + p.y;
            if (newX >= 0 && newX < inputBoard.length && newY >= 0 && newY < inputBoard.length
                    && possibleRoute(current, new Point(newX, newY))) {
                result.add(new Point(newX, newY));
            }
        }

        return result;
    }


    private boolean possibleRoute(Point current, Point check) {
        char checkChar = inputBoard[check.x][check.y];
        if (distances[check.x][check.y] != -1 || checkChar == '.') return false;

        if (current.y == check.y) {
            if (check.x < current.x) {
                if (checkChar == '-' || checkChar == 'L' || checkChar == 'F') return true;
                else return false;
            } else {
                if (checkChar == '-' || checkChar == 'J' || checkChar == '7') return true;
                else return false;
            }
        } else {
            if (check.y < current.y) {
                if (checkChar == '|' || checkChar == '7' || checkChar == 'F') return true;
                else return false;
            } else {
                if (checkChar == '|' || checkChar == 'L' || checkChar == 'J') return true;
                else return false;
            }
        }
    }

    private void zeroDistances() {
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                distances[j][i] = -1;
                supportBoard[j][i] = '.';
            }
        }
    }

    private Point findStart() {
        for (int y = 0; y < inputBoard.length; y++) {
            for (int x = 0; x < inputBoard.length; x++) {
                if (inputBoard[x][y] == 'S') return new Point(x, y);
            }

        }
        return new Point(-1, -1);
    }
}


package Day3;

import Day2.Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] board = new char[140][140];
    List<Part> parts = new ArrayList<>();


    public int task2() {
        int result = 0;
        for (int y = 0; y < 140; y++) {
            for (int x = 0; x < 140; x++) {
                if (board[x][y] == '*') {
                    List<Integer> surroundingNumbers = numbersAround(x, y);
                    if (surroundingNumbers.size() == 2) {
                        result += surroundingNumbers.get(0) * surroundingNumbers.get(1);
                    }

                }
            }
        }


        return result;
    }

    private List<Integer> numbersAround(int cogx, int cogy) {
        List<Integer> results = new ArrayList<>();
        Point p1 = new Point(cogx-1, cogy-1);
        Point p2 = new Point(cogx, cogy-1);
        Point p3 = new Point(cogx+1, cogy-1);
        Point p4 = new Point(cogx-1, cogy);
        Point p5 = new Point(cogx+1, cogy);
        Point p6 = new Point(cogx-1, cogy+1);
        Point p7 = new Point(cogx, cogy+1);
        Point p8 = new Point(cogx+1, cogy+1);
        for(Part p:parts){
            if(p.coordinates.contains(p1)||p.coordinates.contains(p2)||p.coordinates.contains(p3)
            ||p.coordinates.contains(p4)||p.coordinates.contains(p5)||p.coordinates.contains(p6)
                    ||p.coordinates.contains(p7)||p.coordinates.contains(p8))results.add(p.value);
        }
        return results;
    }

    public int task1() {
        int result = 0;
        for (Part p : parts) {
            if (p.isAPart) result += p.value;
        }
        return result;
    }

    public Board(String filePath) {
        int x = 0, y = 0;
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                for (x = 0; x < line.length(); x++) {
                    board[x][y] = line.charAt(x);
                }
                y++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        readParts();
        evaluateParts();
    }

    private void readParts() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                char c = board[x][y];
                if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                    int length = 1;
                    String s = String.valueOf(c);
                    do {
                        if (x + length <= 139) {
                            c = board[x + length][y];
                            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') {
                                s += c;
                                length++;
                            } else break;
                        } else break;
                    } while (true);
                    parts.add(new Part(new Point(x, y), length, Integer.parseInt(s)));
                    x = x + length - 1;
                }
            }
        }
    }

    public void evaluateParts() {
        for (Part p : parts) {
            for (int y = p.startPoint.y - 1; y <= p.startPoint.y + 1; y++) {
                if (y < 0 || y > 139) continue;
                for (int x = p.startPoint.x - 1; x <= p.startPoint.x + p.length; x++) {
                    if (x < 0 || x > 139) continue;
                    char c = board[x][y];
                    if (c != '.' && c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9')
                        p.isAPart = true;
                }
            }
        }
    }
}

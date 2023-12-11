package Day11;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class Space {
    List<Galaxy> galaxies = new ArrayList<>();
    List<Integer> emptyRows = new ArrayList<>();
    List<Integer> emptyColumns = new ArrayList<>();

    public Space(String filePath) {
        //read inputs to galaxies list
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            int y = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '#') {
                        galaxies.add(new Galaxy(x, y));
                    }
                }
                y++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        //discover empty rows and columns
        findEmptyColumns();
        findEmptyRows();

    }

    public void expandSpace(int expansion) {
        for (Integer i : emptyColumns) {
            for (Galaxy g : galaxies) {
                if (g.originalPosition.x > i) {
                    g.expandedPosition.x+=expansion;
                }
            }
        }
        for (Integer i : emptyRows) {
            for (Galaxy g : galaxies) {
                if (g.originalPosition.y > i) {
                    g.expandedPosition.y+=expansion;
                }
            }
        }
    }

    private void findEmptyRows() {
        int ymax = maxXmaxY().y;
        Set<Integer> existingRows = new HashSet<Integer>();

        for (Galaxy g : galaxies) {
            existingRows.add(g.originalPosition.y);
        }
        for (int y = 0; y < ymax; y++) {
            if (!existingRows.contains(y)) {
                emptyRows.add(y);
            }
        }
    }

    private void findEmptyColumns() {
        int xmax = maxXmaxY().x;
        Set<Integer> existingColumns = new HashSet<Integer>();
        for (Galaxy g : galaxies) {
            existingColumns.add(g.originalPosition.x);
        }
        for (int x = 0; x < xmax; x++) {
            if (!existingColumns.contains(x)) {
                emptyColumns.add(x);
            }
        }
    }

    private Point maxXmaxY() {
        int x = 0, y = 0;
        for (Galaxy g : galaxies) {
            if (g.originalPosition.x > x) {
                x = g.originalPosition.x;
            }
            if (g.originalPosition.y > y) {
                y = g.originalPosition.y;
            }
        }
        return new Point(x, y);
    }

    public int task1() {
        int result = 0;
        for(int g=0;g<galaxies.size();g++){
            for(int g2=g+1;g2<galaxies.size();g2++){
                result += galaxies.get(g).distanceTo(galaxies.get(g2));
            }
        }
        return result;
    }

    public long task2(){
        long result = 0;
        for(int g=0;g<galaxies.size();g++){
            for(int g2=g+1;g2<galaxies.size();g2++){
                result += galaxies.get(g).distanceTo(galaxies.get(g2));
            }
        }
        return result;
    }
}

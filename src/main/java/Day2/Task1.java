package Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    List<Game> games = new ArrayList<>();

    public Task1(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                games.add(new Game(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int task1result() {
        int result = 0;
        for (Game g : games) {
            if (g.isPossible()) result += g.number;
        }
        return result;
    }

    public int task2result() {
        int result = 0;
        for(Game g:games){
            result+=g.power();
        }
        return result;
    }
}

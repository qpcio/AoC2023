package Day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int number;
    List<Round> rounds = new ArrayList<>();

    int maxRed = 12;
    int maxGreen = 13;
    int maxBlue = 14;

    int minRed = 0;
    int minGreen = 0;
    int minBlue = 0;

    private void setMins(){
        for(Round r:rounds){
            if(r.red>minRed)minRed=r.red;
            if(r.green>minGreen)minGreen=r.green;
            if(r.blue>minBlue)minBlue=r.blue;
        }
    }

    public boolean isPossible() {
        for (Round r : rounds) {
            if (r.red > maxRed || r.green > maxGreen || r.blue > maxBlue) return false;
        }
        return true;
    }

    public int power(){
        return this.minRed*this.minGreen*this.minBlue;
    }

    public Game(String line) {
        String[] data = line.split(":");
        String[] gameNo = data[0].split(" ");
        this.number = Integer.parseInt(gameNo[1]);
        String[] roundsData = data[1].split(";");
        for (String s : roundsData) {
            rounds.add(new Round(s));
        }
        setMins();
    }


}

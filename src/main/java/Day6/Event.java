package Day6;

import java.util.ArrayList;
import java.util.List;

public class Event {
    List<Race> races = new ArrayList<>();

    public Event(){
//        races.add(new Race(52,426));
//        races.add(new Race(94,1374));
//        races.add(new Race(75,1279));
//        races.add(new Race(94,1216));
        races.add(new Race(52947594,426137412791216L));

        // TASK2
        // TEST BELOW
//        races.add(new Race(7,9));
//        races.add(new Race(15,40));
//        races.add(new Race(30,200));
//        races.add(new Race(71530,940200)) ;
    }

    public long task1(){
        long result = 1;
        for(Race r : races){
            result*=r.noOfWaysToWin();
        }
        return result;
    }

}

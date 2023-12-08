package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    String cards;
    int bid;
    int[] counts = new int[5];

    int originalValue;     // 7 - five of kind - 1 - high card


    public boolean fiveOfAKind() {
        return (cards.charAt(0) == cards.charAt(1) && cards.charAt(1) == cards.charAt(2)
                && cards.charAt(2) == cards.charAt(3) && cards.charAt(3) == cards.charAt(4));
    }

    public Hand(String inputLine) {
        String[] input = inputLine.split(" ");
        this.cards = input[0];
        this.bid = Integer.parseInt(input[1]);
        for (int i = 0; i < 5; i++) {
            char c = this.cards.charAt(i);
            counts[i] = count(c);
        }
        countOriginalValue();
        // change T -> B, J->C, Q -> D, K-> E, A -> F
        cards = cards.replace("T", "B").replace("J", "C")
                .replace("Q", "D").replace("K", "E").replace("A", "F");
    }

    public Hand(String inputLine, boolean task2){
        String[] input = inputLine.split(" ");
        this.cards = input[0];
        this.bid = Integer.parseInt(input[1]);
        for (int i = 0; i < 5; i++) {
            char c = this.cards.charAt(i);
            if(c!='J')this.counts[i] = count(c);
        }
        countOriginalValueWJokers();
        // change T -> B, J->1, Q -> D, K-> E, A -> F
        cards = cards.replace("T", "B").replace("J", "1")
                .replace("Q", "D").replace("K", "E").replace("A", "F");
    }

    private void countOriginalValue() {
        ArrayList listOfCounts = new ArrayList();
        for (int i : counts) {
            listOfCounts.add(i);
        }
        if (fiveOfAKind()) originalValue = 7;
        else if (listOfCounts.contains(4)) {
            originalValue = 6;
        } else if (listOfCounts.contains(3) && listOfCounts.contains(2)) {
            originalValue = 5;
        } else if (listOfCounts.contains(3)) {
            originalValue = 4;
        } else if (Collections.frequency(listOfCounts, 2) == 4) {
            originalValue = 3;
        } else if (listOfCounts.contains(2)) {
            originalValue = 2;
        } else {
            originalValue = 1;
        }
    }


    private void countOriginalValueWJokers(){
        ArrayList listOfCounts = new ArrayList<>();
        int jokersCount = 0;
        for(int i=0;i<5;i++){
            if(cards.charAt(i)=='J')jokersCount++;
        }
        for (int i : counts) {
            listOfCounts.add(i);
        }
        Collections.sort(listOfCounts);
        int newBest=(int) listOfCounts.get(listOfCounts.size()-1)+jokersCount;
        listOfCounts.set(listOfCounts.size()-1,newBest);
        if(newBest==3)listOfCounts.set(listOfCounts.size()-2,newBest );
        if (listOfCounts.contains(5)) originalValue = 7;
        else if (listOfCounts.contains(4)) {
            originalValue = 6;
        } else if (listOfCounts.contains(3) && listOfCounts.contains(2)) {
            originalValue = 5;
        } else if (listOfCounts.contains(3)) {
            originalValue = 4;
        } else if (Collections.frequency(listOfCounts, 2) == 4) {
            originalValue = 3;
        } else if (listOfCounts.contains(2)) {
            originalValue = 2;
        } else {
            originalValue = 1;
        }
    }



    private int count(char c) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            if (this.cards.charAt(i) == c) result++;
        }
        return result;
    }

    @Override
    public int compareTo(Hand h) {
        if (this.originalValue > h.originalValue) return 1;
        if (this.originalValue < h.originalValue) return -1;
        for (int i = 0; i < cards.length(); i++) {
            if (this.cards.charAt(i)>h.cards.charAt(i))return 1;
            if (h.cards.charAt(i)>this.cards.charAt(i))return -1;
        }
        return 0;
    }
}

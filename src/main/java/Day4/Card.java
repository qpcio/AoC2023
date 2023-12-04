package Day4;

import java.util.ArrayList;
import java.util.List;

public class Card {
    int cardNo;
    List<Integer> winningNumbers = new ArrayList<>();
    List<Integer> myNumbers = new ArrayList<>();

    int noOfInstances=1;

    public Card(String cardNo, String winning, String my) {
        this.cardNo = Integer.parseInt(cardNo.replace("Card ", "").replace(" ", ""));
        String[] wn = winning.split(" ");
        for (String s : wn) {
            if (s.length() > 0) {
                winningNumbers.add(Integer.parseInt(s));
            }
        }
        String mn[] = my.split(" ");
        for (String s : mn) {
            if (s.length() > 0) {
                myNumbers.add(Integer.parseInt(s));
            }
        }
    }

    int value(){
        int count = 0;
        for(int n:myNumbers){
            if(winningNumbers.contains(n)){
                count++;
            }
        }
        return count>0 ? (int) Math.pow(2, count - 1) : 0;
    }

    int noOfWins(){
        int result =0;
        for(int n:myNumbers){
            if(winningNumbers.contains(n))result++;
        }
        return result;
    }

    void increaseNumber(int instances){
        noOfInstances+=instances;
    }

}

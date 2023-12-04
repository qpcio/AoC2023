package Day4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scratchcards {
    List<Card> cards = new ArrayList<>();

    public Scratchcards(String filePath){
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                s = s.replace("|","z");
                String[] s1 = s.split(":");
                String[] s2 = s1[1].split("z");
                cards.add(new Card(s1[0],s2[0],s2[1]));
            }
        }    catch (Exception e){
            System.out.println(e);
        }
    }

    public int task1(){
        int result = 0;
        for(Card c:cards){
            result+=c.value();
        }
        return result;
    }

    public int task2(){
        for(int cardIndex = 0 ;cardIndex<cards.size();cardIndex++){
            int wins = cards.get(cardIndex).noOfWins();
            if(wins>0){
                for(int i=1;i<=wins;i++){
                    cards.get(cardIndex+i).increaseNumber(cards.get(cardIndex).noOfInstances);
                }
            }
        }
        int result =0;
        for(Card c:cards){
            result+=c.noOfInstances;
        }
        return result;
    }

}

package Day7;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    static List<Hand> handList = new ArrayList<Hand>();

    public Game(String filePath){
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                 handList.add(new Hand(scanner.nextLine()));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        Collections.sort(handList);

    }


    public int task1(){
        int result = 0;
        for(int i=1;i<=handList.size();i++){
              result+=i*handList.get(i-1).bid;
        }
        return result;
    }
}

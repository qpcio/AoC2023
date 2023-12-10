package Day9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oasis {
    private List<DataLine> dataLines = new ArrayList<>();

    public int task1(){
        int result = 0;
        for(DataLine dl:dataLines){
            result+=dl.extrapolate();
        }
        return result;
    }

    public int task2(){
        int result = 0;
        for(DataLine dl:dataLines){
            result+=dl.extrapolateBack();
        }
        return result;
    }

    public Oasis(String filePath){
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()){
                dataLines.add(new DataLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

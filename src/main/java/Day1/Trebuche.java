package Day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trebuche {
    private List<Integer> values = new ArrayList<>();

    private void readValues2(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                List<Integer> numbers = new ArrayList<>();
                String line = scanner.nextLine();
                int firstNumber=0, lastNumber=0;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                        firstNumber = Character.getNumericValue(c);
                        break;
                    } else {
                        String test = line.substring(0,i+1);
                        if (test.contains("one")) {
                            firstNumber = 1;
                            break;
                        } else if (test.contains("two")) {
                            firstNumber = 2;
                            break;
                        } else if (test.contains("three")) {
                            firstNumber = 3;
                            break;
                        } else if (test.contains("four")) {
                            firstNumber = 4;
                            break;
                        } else if (test.contains("five")) {
                            firstNumber = 5;
                            break;
                        } else if (test.contains("six")) {
                            firstNumber = 6;
                            break;
                        } else if (test.contains("seven")) {
                            firstNumber = 7;
                            break;
                        } else if (test.contains("eight")) {
                            firstNumber = 8;
                            break;
                        } else if (test.contains("nine")) {
                            firstNumber = 9;
                            break;
                        }

                    }
                }
                for(int i = line.length()-1; i>=0;i--){
                    char c = line.charAt(i);
                    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                        lastNumber = Character.getNumericValue(c);
                        break;
                    } else {
                        String test = line.substring(i);
                        if (test.contains("one")) {
                            lastNumber = 1;
                            break;
                        } else if (test.contains("two")) {
                            lastNumber = 2;
                            break;
                        } else if (test.contains("three")) {
                            lastNumber = 3;
                            break;
                        } else if (test.contains("four")) {
                            lastNumber = 4;
                            break;
                        } else if (test.contains("five")) {
                            lastNumber = 5;
                            break;
                        } else if (test.contains("six")) {
                            lastNumber = 6;
                            break;
                        } else if (test.contains("seven")) {
                            lastNumber = 7;
                            break;
                        } else if (test.contains("eight")) {
                            lastNumber = 8;
                            break;
                        } else if (test.contains("nine")) {
                            lastNumber = 9;
                            break;
                        }

                    }

                }



                values.add(firstNumber * 10 + lastNumber);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void readValues(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                List<Integer> numbers = new ArrayList<>();
                String line = scanner.nextLine();
                int firstNumber=0, lastNumber=0;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                        firstNumber = Character.getNumericValue(c);
                        break;
                    }
                }
                for(int i = line.length()-1; i>=0;i--){
                    char c = line.charAt(i);
                    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                        lastNumber = Character.getNumericValue(c);
                        break;
                    }
                }



                values.add(firstNumber * 10 + lastNumber);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getSum() {
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }

    public Trebuche(String filePath, int task) {
        if (task == 1){
                 this.readValues(filePath);
        } else if (task == 2) {
            this.readValues2(filePath);
        }
    }
}

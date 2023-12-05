package Day5;

public class Day5 {
    public static void main(String[] args) {
        Field field = new Field("src/main/java/Day5/input.txt");
        field.processEverything();
        System.out.println(field.task1());
    }
}

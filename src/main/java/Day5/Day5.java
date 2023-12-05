package Day5;

public class Day5 {
    public static void main(String[] args) {
        Field field = new Field("src/main/java/Day5/input.txt");
        field.processEverything();
        System.out.println("Task 1 result: "+field.task1());
        System.out.println("Task 2 result: "+field.task2());
    }
}

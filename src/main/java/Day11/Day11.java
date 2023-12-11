package Day11;

public class Day11 {
    public static void main(String[] args) {
        Space space = new Space("src/main/java/Day11/input.txt");
        space.expandSpace(1);
        System.out.println(space.task1());

        Space space2 = new Space("src/main/java/Day11/input.txt");
        space2.expandSpace(999999);
        System.out.println(space2.task2());
    }
}

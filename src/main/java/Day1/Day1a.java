package Day1;

public class Day1a {
    public static void main(String[] args) {
        Trebuche trebuche = new Trebuche("src/main/java/Day1/input.txt",1);
        System.out.println(trebuche.getSum());
        Trebuche trebuche1 = new Trebuche("src/main/java/Day1/input.txt",2);
        System.out.println(trebuche1.getSum());
    }
}

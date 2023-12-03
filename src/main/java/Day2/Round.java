package Day2;

public class Round {
    int red = 0;
    int green = 0;
    int blue = 0;

    public Round(String round) {
        round = round.substring(1);
        String rounds[] = round.split(", ");
        for (String s : rounds) {
            String[] values = s.split(" ");
            if (values[1].equals("red")) {
                red = Integer.parseInt(values[0]);
            } else if (values[1].equals("green")) {
                green = Integer.parseInt(values[0]);
            } else {
                blue = Integer.parseInt(values[0]);
            }

        }
    }
}

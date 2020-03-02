public class Game {
    public static void main(String[] args) {
        System.out.println("Args:");
        for (String arg : args) {
            System.out.println(arg);
        }


        //  Game -> 1-6
        //  java zzax.Game -s 4
        int size = 6;

        if (args.length == 2) {
            if (args[0].equals("-s")) {
                size = Integer.parseInt(args[1]);
            }
        }

        int result = (int)(Math.random() * size) + 1;
        System.out.println(result);

    }
}

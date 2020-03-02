
import org.apache.commons.cli.*;

public class Game {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("s", "style", true, "dice style");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine commandLine = parser.parse(options, args);
            if (commandLine.hasOption("s")) {
                String style = commandLine.getOptionValue("s");
                int styleInt = Integer.valueOf(style);
                System.out.println(Math.random() * styleInt);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

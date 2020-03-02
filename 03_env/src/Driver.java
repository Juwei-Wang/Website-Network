import java.util.Map;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        Set<String> varNames = map.keySet();
        for (String varName : varNames) {
            String varValue = System.getenv(varName);
            System.out.println(varName + " --- " + varValue);

        }
        System.out.println();
        System.out.println(System.getenv(""));

    }
}

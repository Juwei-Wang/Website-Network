import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Persistence {
    public static void save(List<String> todos) {
        File file = new File("data/list.txt");
        String data = String.join("\n", todos);
        try {
            FileUtils.writeStringToFile(file, data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
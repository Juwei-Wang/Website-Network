import org.apache.commons.io.FileUtils;

import java.io.File;

public class FlieUtilsDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("data/note.txt");

        FileUtils.writeStringToFile(file,"Hello","UTF-8");

        byte[] bytes = FileUtils.readFileToByteArray(file);


    }
}

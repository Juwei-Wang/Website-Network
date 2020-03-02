import org.apache.commons.io.FileUtils;

import java.io.File;

public class Deserialization {
    public static void main(String[] args) throws Exception  {
        new Deserialization().run();
    }

    public void run() throws Exception {
        String encodedString = FileUtils.readFileToString(new File("data/chat.txt"), "UTF-8");
        Chat chat = ChatCoder.decode(encodedString);
        System.out.println("");
    }
}
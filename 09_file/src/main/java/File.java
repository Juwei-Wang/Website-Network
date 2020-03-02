import com.google.common.base.Splitter;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileUtilsDemo {
    public static void main(String[] args) throws Exception {
        new FileUtilsDemo().run();
    }

    public void run() throws Exception{
        File file = new File("data/note.txt");

        FileUtils.writeStringToFile(file, "hello", "UTF-8", true);
        // string @ memory -> byte[] @ memory -> byte[] @ disk

        printBytes(file);


        File utf8File = new File("data/utf8.txt");
        FileUtils.writeStringToFile(utf8File, "赵哲", "UTF-8");
        printBytes(utf8File);

        File gbkFile = new File("data/gbk.txt");
        FileUtils.writeStringToFile(gbkFile, "赵哲", "GBK");
        printBytes(gbkFile);
    }

    private void printBytes(File file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        System.out.println(Arrays.toString(bytes));

        String hex = Hex.encodeHexString(bytes);
        Iterable<String> parts = Splitter.fixedLength(2).split(hex);
        String hexSeparated = String.join(" ", parts);
        System.out.println(hexSeparated);
    }
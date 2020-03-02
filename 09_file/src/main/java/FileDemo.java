
import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File sourceCodePath = new File("src");
        boolean exists = sourceCodePath.exists();
        System.out.println(exists);

        File absoluteFile = sourceCodePath.getAbsoluteFile();
        System.out.println(absoluteFile.getPath());

        //  创建一个 data 的文件夹 在项目下
        File dataFolder = new File("data");
        dataFolder.mkdir(); // mkdirs

        //  创建一个空文件叫 note.txt 在 data 下
        File noteFile = new File("data/note.txt");

        try {
            noteFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //  找出 src/com 下 都有哪些文件
        File comFolder = new File("src/com");
        File[] files = comFolder.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

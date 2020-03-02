import org.apache.commons.io.FileUtils;

import java.io.File;

public class Serialization {
    public static void main(String[] args) throws Exception  {
        new Serialization().run();
    }

    public void run() throws Exception {
        Chat chat = new Chat();
        chat.getMessages().add(new Message(1, "ZZAX"));
        chat.getMessages().add(new Message(2, "真棒"));
        chat.getMessages().add(new Message(3, "！！！！"));

        String encodedChat = ChatCoder.encode(chat);
        FileUtils.writeStringToFile(new File("data/chat.txt"), encodedChat, "UTF-8");
    }
}

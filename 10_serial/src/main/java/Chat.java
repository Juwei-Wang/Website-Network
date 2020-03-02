import java.util.LinkedList;

public class Chat {
    private LinkedList<Message> messages = new LinkedList<Message>();

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void setMessages(LinkedList<Message> messages) {
        this.messages = messages;
    }
}
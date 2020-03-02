import java.util.LinkedList;

public class ChatCoder {
    public static String encode(Chat chat) {
        LinkedList<Message> messages = chat.getMessages();
        StringBuilder builder = new StringBuilder();
        for (Message message : messages) {
            String encodedMessage = String.format("%d|%s", message.getId(),  message.getContent());
            builder.append(encodedMessage);
            builder.append("\n");
        }
        return builder.toString();
    }

    public static Chat decode(String encodedChat) {
        Chat chat = new Chat();
        String[] lines = encodedChat.split("\n");
        for (String encodedMessage : lines) {
            if (encodedMessage.trim().equals("")) {
                continue;
            }
            String[] parts = encodedMessage.split("\\|");
            Message message = new Message();
            message.setId(Long.parseLong(parts[0]));
            message.setContent(parts[1]);
            chat.getMessages().add(message);
        }
        return chat;
    }
}

package email;

@FunctionalInterface
public interface EmailSender {

    void send(String to, String text);

}
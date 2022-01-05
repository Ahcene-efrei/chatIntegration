package fr.efrei.notcensuredchat;

public class MessageService {
    public Message cleanMessage(Message message) {
        message.censureMessage();
        return message;
    }
}

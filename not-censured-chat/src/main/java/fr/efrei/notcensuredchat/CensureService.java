package fr.efrei.notcensuredchat;

public class CensureService {
    public Message censureMessage(Message message) {
        message.censureMessage();
        return message;
    }
}

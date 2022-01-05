package fr.efrei.notcensuredchat;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageService {
    ArrayList<String> badWords = new ArrayList<String>(Arrays.asList("fuck"));

    public Message cleanMessage(Message msg){
        Message newMsg = new Message();
        newMsg.setAuthor(msg.getAuthor());
        newMsg.setDate(msg.getDate());
        String newContent = filterContent(msg.getContent());
        newMsg.setContent(newContent);
        return newMsg;
    }

    private String filterContent(String content){
        return "esaias";
    }
}

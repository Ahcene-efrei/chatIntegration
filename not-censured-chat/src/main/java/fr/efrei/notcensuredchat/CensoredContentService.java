package fr.efrei.notcensuredchat;

public class CensoredContentService {

    public CensoredContent toCensoredContent(Message msg){
        CensoredContent censored = new CensoredContent(msg.getAuthor(),msg.getDate(), msg.getFoundBadWords());
        return censored;
    }
}

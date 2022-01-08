package fr.efrei.notcensuredchat;

import java.util.ArrayList;

public class CensoredContent {
    private String author;
    private String date;
    private ArrayList<String> badWords = new ArrayList<>();

    public CensoredContent(String author, String date, ArrayList<String> badWords){
        this.author = author;
        this.date = date;
        this.badWords = badWords;
    }

    @Override
    public String toString() {
        if(badWords.size() > 0){
            String buffer = "(";
            buffer +=String.join(", ", badWords);
            buffer +=")";
            return "["+this.author+"] : " + buffer;
        }

        return "CensoredContent{" +
                "author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", badWords=" + badWords +
                '}';

    }
}

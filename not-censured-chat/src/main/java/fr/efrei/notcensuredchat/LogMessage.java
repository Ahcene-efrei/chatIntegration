package fr.efrei.notcensuredchat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogMessage {
    private String author;
    private String content;
    private String date;

    @Override
    public String toString() {
        return date + " : "+ content +" ("+ author + ").";
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void censureMessage() {
        ArrayList<String> badWords = new ArrayList<>(List.of("fuck"));

        boolean found = false;

        for (String badWord : badWords) {
            if (content.contains(badWord)) {
                found = true;
                break;
            }
        }

        if (!found) return;

        StringBuilder censuredContent = new StringBuilder();

        for (String word : content.split("\\s+")) {
            for (String badWord : badWords) {
                censuredContent.append(" ");

                if (word.contains(badWord)) {
                    censuredContent.append("*".repeat(word.length()));
                } else {
                    censuredContent.append(word);
                }
            }
        }

        content = censuredContent.toString();
    }
}

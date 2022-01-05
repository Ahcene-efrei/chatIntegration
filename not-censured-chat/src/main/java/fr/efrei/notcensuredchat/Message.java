package fr.efrei.notcensuredchat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
    private String author;
    private String content;
    private Date date;

    @Override
    public String toString() {
        return "ESAIAAAAAAAAAAAAAAAAAAAAAAAAAAS { author='" + author + "', content='" + content + "', date='" + date + "'}";
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return formatter.format(date);
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
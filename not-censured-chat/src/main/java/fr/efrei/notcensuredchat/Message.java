package fr.efrei.notcensuredchat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
    private String author;
    private String content;
    private Date date;
    private Boolean containBadWord = false;
    private ArrayList<String> foundBadWords = new ArrayList<>();



    @Override
    public String toString() {
        return " author='" + author + "', content='" + content + "', date='" + date + "'}";
    }

    public Boolean getContainBadWord() {
        return containBadWord;
    }

    public ArrayList<String> getFoundBadWords() {
        return foundBadWords;
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
        this.containBadWord = found;
        if (!found) return;

        StringBuilder censuredContent = new StringBuilder();

        for (String word : content.split("\\s+")) {
            for (String badWord : badWords) {
                censuredContent.append(" ");

                if (word.contains(badWord)) {
                    this.foundBadWords.add(word);
                    censuredContent.append("*".repeat(word.length()));
                } else {
                    censuredContent.append(word);
                }
            }
        }

        content = censuredContent.toString();
    }
}
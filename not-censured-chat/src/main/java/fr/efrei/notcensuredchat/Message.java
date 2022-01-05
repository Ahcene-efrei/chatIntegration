package fr.efrei.notcensuredchat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
    private final ArrayList<String> badWords = new ArrayList<>(List.of("fuck"));

    private String author;
    private String content;
    private Date date;

    @Override
    public String toString() {
        return "{ author='" + author + "', content='" + content + "', date='" + date + "'}";
    }

    public void censureMessage() {
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
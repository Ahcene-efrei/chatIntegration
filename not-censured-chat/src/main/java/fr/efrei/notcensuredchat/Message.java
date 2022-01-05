package fr.efrei.notcensuredchat;

import java.util.Date;

public class Message {
    private String author;
    private String content;
    private Date date;

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    @Override
    public String toString() {
        return "Tset :Message{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
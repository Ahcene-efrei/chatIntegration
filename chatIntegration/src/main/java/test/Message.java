package test;

import java.util.Date;

public class Message {
    private String author;
    private String receiver;
    private String content;
    private Date date;

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getReceiver() {return receiver;}
    public void setReceiver(String receiver) {this.receiver = receiver;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    @Override
    public String toString() {
        return "Tset :Message{" +
                "author='" + author + '\'' +
                ", receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}

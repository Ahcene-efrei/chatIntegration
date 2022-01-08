package fr.efrei.notcensuredchat;

public class LogService {

    public LogMessage convertToLog(Message msg){
        LogMessage log = new LogMessage();
        log.setAuthor(msg.getAuthor());
        log.setContent(msg.getContent());
        log.setDate(msg.getDate());
        return log;
    }
}

package not.censured.chat;

public class MessageService {
    String[] badWords = {
            "conard",
            "fuck",
            "fdp",
            "batard",
            "encule",
            "enculé",
            "pd",
            "pute",
            "salope",
            "saloppe",
            "nique",
            "niquer",
            "baise",
            "baiser",
            "couille",
            "couilles",
            "salaud",
            "gueule",
            "bite"
    };

    public Message cleanMessage(Message message) {
        String cleanedContent = filterContent(message.getContent());
        message.setContent(cleanedContent);
        return message;
    }

    private String filterContent(String content) {
        StringBuilder filteredContent = new StringBuilder();
        for (String word : content.split(" ")) {
            for (String badWord : badWords) {
                filteredContent.append(" ");
                if (word.contains(badWord)) {
                    filteredContent.append("*".repeat(word.length()));
                } else {
                    filteredContent.append(word);
                }
            }
        }
        return filteredContent.toString();
    }
}

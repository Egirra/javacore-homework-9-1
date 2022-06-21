package homework;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCats {
    private final String id; //уникальный идентификатор записи
    private final String text; //сообщение
    private final String type; //тип животного
    private final String user; //имя пользователя
    private final int upvotes; //голоса

    public RequestCats(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Cats Facts:" +
                "\n id: " + id +
                "\n text: " + text +
                "\n type: " + type +
                "\n user: " + user +
                "\n upvotes: " +upvotes;
    }
}

package online.selfexpansion.commitment.model;

import java.sql.Time;

public class ToxicList {
    private String uid;
    private String heading;
    private String content;
    private String author;
    private Time create_time;

    public String getUid() {
        return uid;
    }

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Time getCreate_time() {
        return create_time;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreate_time(Time create_time) {
        this.create_time = create_time;
    }
}

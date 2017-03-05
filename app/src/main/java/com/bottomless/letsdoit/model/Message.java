package com.bottomless.letsdoit.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Map;

/**
 * Created by Valentin on 04.03.2017.
 */
@IgnoreExtraProperties
public class Message {
    String text;
    String username;
    String tag;
    Map<String ,String> time;
    Long timeFromServer;

    public Long getTimeFromServer() {
        return timeFromServer;
    }

    public void setTimeFromServer(Long timeFromServer) {
        this.timeFromServer = timeFromServer;
    }

    public Message(){}
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String ,String> getTime() {
        return time;
    }

    public void setTime(Map<String ,String> time) {
        this.time = time;
    }

    public Message(String text, String username, String tag, Map<String ,String> time) {

        this.text = text;
        this.username = username;
        this.tag = tag;
        this.time = time;
    }
}

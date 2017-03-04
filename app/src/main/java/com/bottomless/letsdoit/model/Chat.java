package com.bottomless.letsdoit.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Valentin on 04.03.2017.
 */
@IgnoreExtraProperties
public class Chat {
    String title;
    String lastMessage;


    public Chat(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Chat(String title, String lastMessage) {

        this.title = title;
        this.lastMessage = lastMessage;
    }
}

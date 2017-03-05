package com.bottomless.letsdoit.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

/**
 * Created by Valentin on 04.03.2017.
 */
@IgnoreExtraProperties
public class Chat {
    String title;
    String lastMessage;
    ArrayList<String> member;
    String  admin;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Chat(String title, String lastMessage, ArrayList<String> member, String admin) {
        this.title = title;
        this.lastMessage = lastMessage;
        this.member = member;
        this.admin = admin;
    }

    public ArrayList<String> getMember() {

        return member;
    }

    public void setMember(ArrayList<String> member) {
        this.member = member;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

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

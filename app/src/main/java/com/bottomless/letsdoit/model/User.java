package com.bottomless.letsdoit.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Valentin on 04.03.2017.
 */
@IgnoreExtraProperties
public class User {
   String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

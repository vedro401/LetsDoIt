package com.bottomless.letsdoit;

import com.bottomless.letsdoit.model.Chat;
import com.bottomless.letsdoit.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 04.03.2017.
 */

public class API {
    public static List<Chat> getChatsOfUser(User user){
        ArrayList<Chat> res = new ArrayList<Chat>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("chats");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    System.out.println(d.toString());
                    Chat c = d.getValue(Chat.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return res;
    }
}

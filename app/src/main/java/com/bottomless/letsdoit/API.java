package com.bottomless.letsdoit;

import android.support.annotation.NonNull;

import com.bottomless.letsdoit.model.Chat;
import com.bottomless.letsdoit.model.Message;
import com.bottomless.letsdoit.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static String addNewChat(String username){
        final DatabaseReference mSimpleFirechatDatabaseReference = FirebaseDatabase.getInstance().getReference();
        final String chatKey =  mSimpleFirechatDatabaseReference.child("chats").push().getKey();
        mSimpleFirechatDatabaseReference.child("chats").child(chatKey).setValue(new Chat("New chat","lasr",null,username));
        mSimpleFirechatDatabaseReference.child("chatsWithMessages").child(chatKey).setValue("messages");
        return chatKey;
    }

    public static void addMessageToChat(String username, String text,String chatKey,String tag){
        final DatabaseReference mSimpleFirechatDatabaseReference = FirebaseDatabase.getInstance().getReference().child("chatsWithMessages")
                .child(chatKey).child("messages");
        final String messageKey =  mSimpleFirechatDatabaseReference.push().getKey();
        mSimpleFirechatDatabaseReference.child(messageKey).setValue(new Message(text,username,tag, ServerValue.TIMESTAMP));
    }


}

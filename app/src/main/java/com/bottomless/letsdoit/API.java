package com.bottomless.letsdoit;

import com.bottomless.letsdoit.model.Chat;
import com.bottomless.letsdoit.model.Message;
import com.bottomless.letsdoit.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 04.03.2017.
 */

public class API {

    public static void addMemberToChat(String chatKey,String user){
        Task<Void> mSimpleFirechatDatabaseReference = FirebaseDatabase.getInstance().getReference()
                .child("chats")
                .child(chatKey).child("members")
                .push()
                .setValue(user);
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

    public static ArrayList<Message> getMessagesFromChat(String chatKey){
        final ArrayList<Message> res = new ArrayList<Message>();
        DatabaseReference messagesDatabaseReference = FirebaseDatabase.getInstance().getReference().child("chatsWithMessages").child(chatKey);
        messagesDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    res.add(d.getValue(Message.class));
                    System.out.println(d.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return res;
    }

}

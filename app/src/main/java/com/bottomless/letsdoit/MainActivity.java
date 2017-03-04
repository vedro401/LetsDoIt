package com.bottomless.letsdoit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottomless.letsdoit.model.Chat;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView chatList;
    ChatAdapter chatAdater;
    String currentUser;
    String currentChat,anotherUser;
    private DatabaseReference mSimpleFirechatDatabaseReference;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        currentUser = "nickname";
        anotherUser = "anotherUser";
        currentChat = "-KeP_OOoPKQ9Eyq6SlGj";
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //
        mLinearLayoutManager = new LinearLayoutManager(this);
        mSimpleFirechatDatabaseReference = FirebaseDatabase.getInstance().getReference("chats");

        chatList = (RecyclerView) findViewById(R.id.chatList);
        final ArrayList<Chat> chats = new ArrayList<>();
        chatAdater = new ChatAdapter();
        chatAdater.setChats(chats);
        chatList.setLayoutManager(mLinearLayoutManager);
        chatList.setAdapter(chatAdater);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("chats");
        System.out.println("Start");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Check chats");
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    System.out.println(d.toString());
                    Chat c = d.getValue(Chat.class);
                    DataSnapshot s = d.child("members");
                    System.out.println(s.toString());
                    ArrayList<String> mems = new ArrayList<String>();
                    for (DataSnapshot s1: s.getChildren()){
                        System.out.println(s1.toString());
                        mems.add(s1.child("name").getValue(String.class));
                    }
                    c.setMember(mems);
                    if (c.getAdmin().equals(currentUser)||c.getMember().contains(currentUser))
                    chats.add(c);
                    chatAdater.notifyDataSetChanged();
                }
                System.out.println("End");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static class ChatHolder extends RecyclerView.ViewHolder {
        CircleImageView avatarImage;
        TextView name;
        TextView lastMsg;
        public ChatHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            avatarImage = (CircleImageView) itemView.findViewById(R.id.chatAvatar);
            name = (TextView) itemView.findViewById(R.id.chatTitle);
            lastMsg = (TextView) itemView.findViewById(R.id.lastMessage);
        }
    }

    class ChatAdapter extends RecyclerView.Adapter<ChatHolder>{
        ArrayList<Chat> chats;

        public ArrayList<Chat> getChats() {
            return chats;
        }

        public void setChats(ArrayList<Chat> chats) {
            this.chats = chats;
        }

        @Override

        public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
            ChatHolder bankExchangeHolder = new ChatHolder(v);
            return bankExchangeHolder;
        }

        @Override
        public void onBindViewHolder(ChatHolder holder, int position) {
            holder.lastMsg.setText(chats.get(position).getLastMessage());
            holder.name.setText(chats.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return chats.size();
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

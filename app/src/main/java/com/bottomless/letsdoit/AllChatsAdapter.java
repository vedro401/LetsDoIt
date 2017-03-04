package com.bottomless.letsdoit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bottomless.letsdoit.model.Chat;
import com.bottomless.letsdoit.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by someone on 04.03.17.
 */
public class AllChatsAdapter  extends RecyclerView.Adapter<AllChatsAdapter.ViewHolder> {
    private List<Chat> chats = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.chatLastMessage.setText(chat.getLastMessage());
        holder.chatTitle.setText(chat.getTitle());
    }
    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chatTitle;
        public TextView chatLastMessage;

        public ViewHolder(View v) {
            super(v);
            chatTitle = (TextView) v.findViewById(R.id.chatTitle);
            chatLastMessage = (TextView) v.findViewById(R.id.lastMessage);
        }

    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}

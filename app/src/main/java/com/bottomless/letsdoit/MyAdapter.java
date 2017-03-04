package com.bottomless.letsdoit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by someone on 04.03.17.
 */
public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//    private List<> posts;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_element, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chatAva;
        public TextView chatMessage;

        public ViewHolder(View v) {
            super(v);
            chatAva = (TextView) v.findViewById(R.id.chat_element_ava);
            chatAva = (TextView) v.findViewById(R.id.chat_element_message);
        }

    }
}

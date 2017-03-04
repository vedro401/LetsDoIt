package com.bottomless.letsdoit;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bottomless.letsdoit.model.Chat;

import java.util.ArrayList;

/**
 * Created by someone on 04.03.17.
 */
public class AllChatsFragment extends Fragment{
    Context context;
    private RecyclerView mRecyclerView;
    private AllChatsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_chats_fragment,
                container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<Chat> chats = new ArrayList<>();
        mAdapter = new AllChatsAdapter();
        ArrayList<Chat> testArray = new ArrayList<>();
        testArray.add(new Chat("Title", "message"));
        mAdapter.setChats(testArray);
        mRecyclerView.setAdapter(mAdapter);
        System.out.println("Get chats");
        API.getAllChats("nickname", mAdapter);

    }





}

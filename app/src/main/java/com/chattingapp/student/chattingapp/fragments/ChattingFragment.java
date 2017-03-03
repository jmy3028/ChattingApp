package com.chattingapp.student.chattingapp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.test.espresso.core.deps.guava.eventbus.Subscribe;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chattingapp.student.chattingapp.Adapter.ChattingAdapter;
import com.chattingapp.student.chattingapp.Model.ChatClient;
import com.chattingapp.student.chattingapp.Model.ChattingModel;
import com.chattingapp.student.chattingapp.R;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-02-16.
 */

public class ChattingFragment extends Fragment {

    private List<ChattingModel> mChattingList = new ArrayList<>();
    private ChattingAdapter mAdapter;
    private ChatClient mChatClient;
    private Socket mSocket;
    private Handler mHandler;


    public ChattingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chatting, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = (ListView) view.findViewById(R.id.frame_list);

        mAdapter = new ChattingAdapter(mChattingList);

        listView.setAdapter(mAdapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mChatClient = new ChatClient(mSocket);
                mChatClient.connect();
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mChatClient.close();
    }

    @Subscribe
    @WorkerThread
    protected void onReceive(final ChattingModel chattingModel) {

        mHandler = new Handler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mChattingList.add(chattingModel);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}

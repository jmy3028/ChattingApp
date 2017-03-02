package com.chattingapp.student.chattingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chattingapp.student.chattingapp.Adapter.ChattingAdapter;
import com.chattingapp.student.chattingapp.Model.ChattingModel;
import com.chattingapp.student.chattingapp.R;
import com.chattingapp.student.chattingapp.server.ReceiverThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-02-16.
 */

public class ChattingFragment extends Fragment {

    private List<ChattingModel> mChattingList = new ArrayList<>();
    private ChattingAdapter mAdapter;
    private ReceiverThread receiverThread;

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
    }

    public void sendMessage(String strMsg) {
        mChattingList.add(new ChattingModel(strMsg));
        mAdapter.notifyDataSetChanged();
    }
}
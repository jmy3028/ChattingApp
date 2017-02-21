package com.chattingapp.student.chattingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.chattingapp.student.chattingapp.R;

/**
 * Created by USER on 2017-02-16.
 */

public class ChattingFragment extends Fragment {

    private TextView mText;
    private Context mConText;

    private ListView mChatList;

    public ChattingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChatList = (ListView) view.findViewById(R.id.frame_list);

        mText = new TextView(mConText);
    }
}

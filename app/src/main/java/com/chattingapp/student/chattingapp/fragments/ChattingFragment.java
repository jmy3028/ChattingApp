package com.chattingapp.student.chattingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.chattingapp.student.chattingapp.Adapter.ChattingAdapter;
import com.chattingapp.student.chattingapp.Model.ChattingModel;
import com.chattingapp.student.chattingapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-02-16.
 */

public class ChattingFragment extends Fragment implements View.OnClickListener {

    private EditText mChatEditText;
    private ListView mChatList;
    private ChattingAdapter chattingAdapter;

    private List<ChattingModel> chattingList;

    public ChattingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chatting,container,false);
        message();
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mChatList = (ListView) view.findViewById(R.id.chatting_list);
        mChatEditText = (EditText) view.findViewById(R.id.chatting_edit_text);

        Bundle bundle = getArguments();
        chattingList = (List<ChattingModel>) bundle.getSerializable("chattingList");

        mChatList.setAdapter(chattingAdapter);

        view.findViewById(R.id.send_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_button :
        }
    }
}

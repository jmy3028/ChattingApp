package com.chattingapp.student.chattingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.chattingapp.student.chattingapp.Model.ChatClient;
import com.chattingapp.student.chattingapp.fragments.ChattingFragment;

public class NewChattingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    private ChattingFragment chattingFragment;
    private ChatClient mChatClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chatting);

        mEditText = (EditText) findViewById(R.id.chatting_edit_text);

        findViewById(R.id.send_button).setOnClickListener(this);

        chattingFragment = (ChattingFragment) getSupportFragmentManager()
                .findFragmentById(R.id.chatting_fragment);

    }

    @Override
    public void onClick(View v) {
        mChatClient.sendMessage(mEditText.getText().toString());
        mEditText.setText("");
    }
}


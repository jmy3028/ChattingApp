package com.chattingapp.student.chattingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.chattingapp.student.chattingapp.fragments.ChattingFragment;

public class NewChattingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;

    private ChattingFragment mChattingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chatting);

        mEditText = (EditText) findViewById(R.id.chatting_edit_text);
        findViewById(R.id.send_button).setOnClickListener(this);

        mChattingFragment = (ChattingFragment) getSupportFragmentManager().findFragmentById(R.id.chatting_fragment);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_button:
                String strMsg = mEditText.getText().toString();
                mChattingFragment.sendMessage(strMsg);
        }
    }
}

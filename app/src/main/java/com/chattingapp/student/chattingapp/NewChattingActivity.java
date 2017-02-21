package com.chattingapp.student.chattingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewChattingActivity extends AppCompatActivity {
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chatting);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_button:
        }
    }
}

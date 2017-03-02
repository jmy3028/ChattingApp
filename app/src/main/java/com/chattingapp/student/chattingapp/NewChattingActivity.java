package com.chattingapp.student.chattingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.chattingapp.student.chattingapp.fragments.ChattingFragment;
import com.chattingapp.student.chattingapp.server.ReceiverThread;
import com.chattingapp.student.chattingapp.server.SenderThread;

import java.io.IOException;
import java.net.Socket;

public class NewChattingActivity extends AppCompatActivity implements View.OnClickListener, ReceiverThread.OnReceiveListener {

    private ReceiverThread receiverThread;
    private SenderThread mThread1;
    private Socket mSocket = null;
    private EditText mEditText;
    private ChattingFragment mChattingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chatting);

        mEditText = (EditText) findViewById(R.id.chatting_edit_text);
        findViewById(R.id.send_button).setOnClickListener(this);

        mChattingFragment = (ChattingFragment) getSupportFragmentManager().findFragmentById(R.id.chatting_fragment);

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 일단은 테스트 용으로 본인의 아이피를 입력해서 진행하겠습니다.
                try {
                    mSocket = new Socket("192.168.0.10", 7777);
                    // 두번째 파라메터 로는 본인의 닉네임을 적어줍니다.
                    mThread1 = new SenderThread(mSocket, "정민영");
                    receiverThread = new ReceiverThread(mSocket);

                    receiverThread.setOnReceiveListener(NewChattingActivity.this);

                    mThread1.start();
                    receiverThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onClick(View view) {
        String strMsg = mEditText.getText().toString();
        switch (view.getId()) {
            case R.id.send_button:
                if (strMsg.equals("")) {
                    break;
                }
                mThread1.sendMessage(strMsg);
                mEditText.setText("");
        }
    }

    @Override
    public void onReceive(String message) {

    }
}



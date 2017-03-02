package com.chattingapp.student.chattingapp.server;

import android.util.Log;

import com.chattingapp.student.chattingapp.fragments.ChattingFragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Student on 2017-02-28.
 */

public class ReceiverThread extends Thread {

    private ChattingFragment mFragment;

    public interface OnReceiveListener {
        void onReceive(String message);
    }

    OnReceiveListener mListener;

    public void setOnReceiveListener(OnReceiveListener listener) {
        mListener = listener;
    }

    Socket socket;

    public ReceiverThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Log.d("receiver", "run: ");
            while (true) {
                String str = reader.readLine();

                if (mListener != null) {
                    mListener.onReceive(str);
                    mFragment.sendMessage(str);
                }

            }

        } catch (Exception e) {
            Log.e("chat", "run: " + e.getMessage());
        }
    }
}

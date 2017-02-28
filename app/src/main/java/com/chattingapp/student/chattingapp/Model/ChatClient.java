package com.chattingapp.student.chattingapp.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by user on 2017-02-27.
 */

public class ChatClient extends Thread {
    private Socket mSocket;

    BufferedReader mIn;

    public ChatClient(Socket socket) {
        this.mSocket = socket;
    }

    @Override
    public void run() {
        try {
            mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            while (true) {
                String str = mIn.readLine();
                if (str == null)
                    break;
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

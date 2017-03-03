package com.chattingapp.student.chattingapp.Model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by user on 2017-02-27.
 */

public class ChatClient {
    private final static String SERVER_HOST = "192.168.0.40";
    private final static int SERVER_PORT = 7777;
    private Socket mSocket;

    private DataOutputStream dataOutputStream;

    public ChatClient(Socket socket) {
        this.mSocket = socket;
    }

    public void connect() {
        try {
            mSocket = new Socket(SERVER_HOST, SERVER_PORT);
            ReceiverThread receiverThread = new ReceiverThread();

            SenderThread senderThread = new SenderThread();
            senderThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        ChattingModel chattingModel = new ChattingModel(msg);

        Gson gson = new Gson();

        try {
            dataOutputStream.writeUTF(gson.toJson(chattingModel));
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class ReceiverThread extends Thread {

        private DataInputStream dataInputStream;

        @Override
        public void run() {

            try {
                dataInputStream = new DataInputStream(mSocket.getInputStream());
            } catch (Exception e) {
                Log.e("chat", "run: " + e.getMessage());
            }


            while (dataInputStream != null) {
                try {
                    String json = dataInputStream.readUTF();

                    try {
                        ChattingModel chattingModel = new Gson().fromJson(json, ChattingModel.class);
                        Log.d("read", chattingModel.toString());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    mSocket = null;
                }
            }
        }
    }

    class SenderThread extends Thread {

        @Override
        public void run() {
            Scanner in = new Scanner(System.in);

            while (true) {
                String msg = in.nextLine();

                ChattingModel chattingModel = new ChattingModel(msg);

                Gson gson = new Gson();

                try {
                    dataOutputStream.writeUTF(gson.toJson(chattingModel));
                    dataOutputStream.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}


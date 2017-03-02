package com.chattingapp.student.chattingapp.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Student on 2017-02-28.
 */

public class SenderThread extends Thread {
    Socket socket;
    String name;
    private PrintWriter mWriter;

    public SenderThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                mWriter.println(message);
                mWriter.flush();
            }
        }).start();
    }

    @Override
    public void run() {

        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            mWriter = new PrintWriter(socket.getOutputStream());

            // 제일 먼저 서버로 대화명을 송신합니다.
            mWriter.println(name);
            mWriter.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}

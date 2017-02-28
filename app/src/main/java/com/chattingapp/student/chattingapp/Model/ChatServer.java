package com.chattingapp.student.chattingapp.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by user on 2017-02-27.
 */

public class ChatServer extends Thread implements Runnable {
    private static final String SERVER_IP = "";
    private static final int PORT = 5555;

    private Socket mSocket;

    private BufferedReader mIn;
    private PrintWriter mOut;

    public ChatServer(Socket socket) {
        this.mSocket = socket;
    }


    @Override
    public void run() {
        try {
            mSocket = new Socket(SERVER_IP, PORT);

            mIn = new BufferedReader(new InputStreamReader(System.in));
            mOut = new PrintWriter(mSocket.getOutputStream());
            while (true) {
                String str = mIn.readLine();
                if (str.equals("bye"))
                    break;
                mOut.println(str);
                mOut.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

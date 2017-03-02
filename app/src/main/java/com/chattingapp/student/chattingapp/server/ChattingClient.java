package com.chattingapp.student.chattingapp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Student on 2017-02-28.
 */

public class ChattingClient extends Thread {

    Socket socket;

    public ChattingClient(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true){
                String str = reader.readLine();
                if(str == null){
                    break;
                }
                System.out.println("수신>" + str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

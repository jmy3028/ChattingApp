package com.chattingapp.student.chattingapp.Model;

/**
 * Created by user on 2017-02-16.
 */

public class ChattingModel {
    String masg;

    public ChattingModel(String masg) {
        this.masg = masg;
    }

    public String getMasg() {
        return masg;
    }

    public void setMasg(String masg) {
        this.masg = masg;
    }

    @Override
    public String toString() {
        return "ChattingModel{" +
                "masg='" + masg + '\'' +
                '}';
    }
}

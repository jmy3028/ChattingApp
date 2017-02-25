package com.chattingapp.student.chattingapp.Model;

/**
 * Created by user on 2017-02-16.
 */

public class ChattingModel {
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChattingModel{" +
                "masg='" + masg + '\'' +
                '}';
    }
}

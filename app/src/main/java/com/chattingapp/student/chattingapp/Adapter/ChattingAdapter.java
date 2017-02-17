package com.chattingapp.student.chattingapp.Adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chattingapp.student.chattingapp.Model.ChattingModel;
import com.chattingapp.student.chattingapp.R;

import java.util.List;

/**
 * Created by user on 2017-02-16.
 */

public class ChattingAdapter extends BaseAdapter {

    private List<ChattingModel> chattingList;

    public ChattingAdapter(List<ChattingModel> chattingData) {
        this.chattingList = chattingData;
    }

    @Override
    public int getCount() {
        return chattingList.size();
    }

    @Override
    public Object getItem(int position) {
        return chattingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chatting, parent, false);

            TextView chattingTextView = (TextView) convertView.findViewById(R.id.chatting_text);

            viewHolder.chattingTextView = chattingTextView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChattingModel chattingModel = chattingList.get(position);

        viewHolder.chattingTextView.setText(chattingModel.getMasg());
        viewHolder.chattingTextView.setGravity(Gravity.RIGHT);

        return convertView;
    }

    private static class ViewHolder {
        TextView chattingTextView;
    }
}

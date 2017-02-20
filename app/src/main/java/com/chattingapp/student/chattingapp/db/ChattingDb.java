package com.chattingapp.student.chattingapp.db;

import android.provider.BaseColumns;

/**
 * Created by Student on 2017-02-20.
 */

public final class ChattingDb {

    private ChattingDb() {}


    public static class ChattingEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

}
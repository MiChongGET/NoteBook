package com.example.administrator.notebook.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(Context context) {
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT DEFAULT NULL," +
                "content TEXT DEFAULT " +
                "前[CreatedTime] TimeStamp NOT NULL DEFAULT (datetime('now','localtime')\"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

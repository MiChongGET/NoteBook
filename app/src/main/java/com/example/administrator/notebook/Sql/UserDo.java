package com.example.administrator.notebook.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class UserDo {

    private MySQLite mySQLite = null;
    private SQLiteDatabase sqLiteDatabase;

    public UserDo(Context context) {
        mySQLite =new MySQLite(context);
    }


    //数据库的具体操作



    //读数据库
    public   List<UserData> readSql() {
        sqLiteDatabase = mySQLite.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("user",null,null,null,null,null,"id desc");

        return convertToTree(cursor);
    }
    //获取日记的个数
    public  Long getCount(){
        sqLiteDatabase = mySQLite.getReadableDatabase();
        String sql = "select count(*) from user";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        sqLiteDatabase.close();

        return count;
    }


    private  List<UserData> convertToTree(Cursor cursor) {
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        List<UserData> mTreeList = new ArrayList<>();
        for (int i = 0; i < resultCounts; i++) {
            UserData tree = new UserData();
            tree.setId(cursor.getInt(0));
            tree.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            tree.setContent(cursor.getString(cursor.getColumnIndex("content")));
            tree.setTime(cursor.getString(cursor.getColumnIndex("time")));

            mTreeList.add(tree);
            cursor.moveToNext();
        }
        return mTreeList;
    }


    //删除数据库
    public  void deletSql() {

    }

    //添加内容
    public  void addSql(String title,String content,String time) {
        sqLiteDatabase =  mySQLite.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("title",title);
        c.put("content",content);
        c.put("time",time);
        sqLiteDatabase.insert("user",null,c);
        sqLiteDatabase.close();
    }

    //更新数据库内容
    public  void updateSql() {

    }


}

package com.example.administrator.notebook.Sql;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public  interface  UserInterface {

    //读取数据库获取日记
    public abstract void readSql();

    //删除日记
    public abstract void deletSql();

    //添加日记
    public abstract void addSql();

    //修改日记
    public abstract void updateSql();

}

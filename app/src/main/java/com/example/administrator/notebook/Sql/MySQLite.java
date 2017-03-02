package com.example.administrator.notebook.Sql;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class MySQLite implements SQLData {
    @Override
    public String getSQLTypeName() throws SQLException {

        return null;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {

    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {

    }
}

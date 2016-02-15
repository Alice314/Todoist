package com.wusui.todoist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by fg on 2016/2/12.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "Create table user ("
            +"id integer primary key autoincrement,"
            +"context text"
            +"date text"
            +"priority integer"
            +"deadline text";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_USER);
        Toast.makeText(mContext,"添加成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

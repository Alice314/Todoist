package com.wusui.todoist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.bignerdranch.android.multiselector.MultiSelector;
import com.bignerdranch.android.multiselector.SingleSelector;
import com.bignerdranch.android.multiselector.SwappingHolder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
* Created by fg on 2016/2/13.
 *  */
public class FirstActivity extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
    private List<String>mDatas;
    private DataAdapter mAdapter;
    private EditText editText;
    private TextView textView;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private GregorianCalendar date;
    private String priority;


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initData();
        editText = (EditText)findViewById(R.id.edit_view);
        textView = (TextView)findViewById(R.id.text_view);

        dbHelper = new MyDatabaseHelper(this,"User.db",null,4);
        db = dbHelper.getWritableDatabase();

        initToolBar();
        initView();


    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new DataAdapter(FirstActivity.this, mDatas));


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                date = new GregorianCalendar();
                int year = date.get(Calendar.YEAR);
                int today = date.get(Calendar.DAY_OF_MONTH);
                int month = date.get(Calendar.MONTH);

                String now = year + "年" + month + "月" + today;

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
                db.execSQL("INSERT INTO User(content) VALUES(?)", new Object[]{editText.getText().toString()});
                db.execSQL("INSERT INTO User(date) VALUES(?)", new Object[]{now});
                db.execSQL("INSERT INTO User(priority) VALUES(?)", new Object[]{priority});

                mDatas.add(editText.getText().toString());
                mDatas.add(now);
                mDatas.add(priority);

                mAdapter.notifyDataSetChanged();
            }
        });
        try {
            Cursor cursor = db.rawQuery("select * from user", null);
            if (cursor.moveToFirst()) {
                do {
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    mDatas.add(content);
                    String now = cursor.getString(cursor.getColumnIndex("date"));
                    mDatas.add(now);
                    String priority = cursor.getString(cursor.getColumnIndex("priority"));
                    mDatas.add(priority);
                }
                while (cursor.moveToNext());
            }cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        mAdapter.notifyDataSetChanged();
    }


    public void initToolBar(){
        Toolbar firstToolBar = (Toolbar)findViewById(R.id.first_toolbar);

        setSupportActionBar(firstToolBar);
       firstToolBar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_jiantou));

        firstToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }

    protected void initData(){
        mDatas = new ArrayList<>();

    }

    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        if (id == R.id.action_more){
            Intent intent1 = new Intent(FirstActivity.this,SecondActivity.class);
            startActivity(intent1);
        }
        return super.onOptionsItemSelected(menuItem);

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("four");
                    priority = returnedData;
                }
                break;
            default:
        }
    }
}


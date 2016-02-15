package com.wusui.todoist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by fg on 2016/2/13.
 */
public class FirstActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initToolBar();
    }
    public void initToolBar(){
        Toolbar firstToolBar = (Toolbar)findViewById(R.id.first_toolbar);
        firstToolBar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_jiantou));
        setSupportActionBar(firstToolBar);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        if (id == R.mipmap.ic_jiantou){
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}

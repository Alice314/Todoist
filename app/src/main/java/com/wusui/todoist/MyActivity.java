package com.wusui.todoist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fg on 2016/1/30.
 */
public class MyActivity extends AppCompatActivity {
    private String[]mTitles;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initToolbar();
    }
    public void initToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        myToolbar.setTitle("今天");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);

//        myToolbar.setNavigationIcon(R.mipmap.ic5);

        myToolbar.setOnMenuItemClickListener(onMenuItemClick);


//        mTitles = getResources().getStringArray(R.array.myarray);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,myToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }


    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener(){
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()){
                case R.id.action_search:
                    msg += "Click search";
                    break;
                case R.id.action_inform:
                    msg += "Click inform";
                    break;
            }
            if (!msg.equals("")){
                Toast.makeText(MyActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.mipmap.ic5) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}





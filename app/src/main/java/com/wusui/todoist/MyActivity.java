package com.wusui.todoist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by fg on 2016/1/30.
 */
public class MyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MyActivity.this,FirstActivity.class);
                startActivity(intent4






























                );
            }
        });

    }
    public void initToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        myToolbar.setTitle("今天");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);
//Set a {@link android.widget.Toolbar Toolbar} to act as the {@link android.support.v7.app.ActionBar} for this Activity window.


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,myToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//Inflate the menu; this adds items to the action bar if it is present.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_notify) { //noinspection SimplifiableIfStatement
            return true;
        }


        return super.onOptionsItemSelected(item);
    }// Handle action bar item clicks here. The action bar will

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.nav_shoujianxiang:
                Intent intent = new Intent(MyActivity.this,FirstItemActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_jin:
                Intent intent1 = new Intent(MyActivity.this,SecondItemActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_seven:
                Intent intent2 = new Intent(MyActivity.this,ThirdItemActivity.class);
                startActivity(intent2);
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
}





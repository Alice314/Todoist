package com.wusui.todoist;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by fg on 2016/2/13.
 */
public class ThirdItemActivity extends MainActivity {
    public void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        myToolbar.setTitle("未来7天");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);
//Set a {@link android.widget.Toolbar Toolbar} to act as the {@link android.support.v7.app.ActionBar} for this Activity window.


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,myToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view_left);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.nav_shoujianxiang:
                Intent intent = new Intent(ThirdItemActivity.this,FirstItemActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_jin:
                Intent intent1 = new Intent(ThirdItemActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_seven:
                Intent intent2 = new Intent(ThirdItemActivity.this,ThirdItemActivity.class);
                startActivity(intent2);

        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

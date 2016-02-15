package com.wusui.todoist;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

/**
 * Created by fg on 2016/2/13.
 */
public class FirstItemActivity extends MyActivity {
    public void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        myToolbar.setTitle("ghsrrtv");
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);
//Set a {@link android.widget.Toolbar Toolbar} to act as the {@link android.support.v7.app.ActionBar} for this Activity window.

    }
}
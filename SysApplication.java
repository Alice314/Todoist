package com.wusui.todoist;
import android.content.Intent;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import java.util.LinkedList;
import java.util.List;
import android.content.DialogInterface;
/**
 * Created by fg on 2016/2/18.
 */
public class SysApplication extends Application {
    private List<AppCompatActivity> mList = new LinkedList<>();
    private static SysApplication instance;

    private SysApplication() {
    }
    public synchronized static SysApplication getInstance() {
        if (null == instance) {
            instance = new SysApplication();
        }
        return instance;
    }
    // add Activity
    public void addActivity(AppCompatActivity activity) {
        mList.add(activity);
    }

    public void exit() {
        try {
            for (AppCompatActivity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}

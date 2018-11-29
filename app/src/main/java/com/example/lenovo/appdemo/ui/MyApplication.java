package com.example.lenovo.appdemo.ui;

import android.app.Application;
import android.content.Context;

/**
 * Created by LSH on 2018/11/29.
 * description：全局Application
 */
public class MyApplication extends Application {

    private volatile static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getApplication() {
        return context;
    }
}

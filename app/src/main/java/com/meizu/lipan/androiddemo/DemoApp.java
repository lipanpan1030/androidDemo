package com.meizu.lipan.androiddemo;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by lipan on 18-5-28.
 */

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
}

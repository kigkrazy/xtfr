package com.reizx.xtfr.app;

import android.app.Application;

/**
 * Created by kig on 2017/11/13.
 */

public class XtfrApp extends Application {
    private static XtfrApp appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public static XtfrApp getInstance() {
        return appInstance;
    }
}

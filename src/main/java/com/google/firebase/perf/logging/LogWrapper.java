/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.firebase.perf.logging;

import android.util.Log;

public class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    private LogWrapper() {
    }

    public static LogWrapper getInstance() {
        Class<LogWrapper> clazz = LogWrapper.class;
        synchronized (clazz) {
            LogWrapper logWrapper = instance;
            if (logWrapper == null) {
                instance = logWrapper = new LogWrapper();
            }
            logWrapper = instance;
            return logWrapper;
        }
    }

    public void d(String string2) {
        Log.d((String)LOG_TAG, (String)string2);
    }

    public void e(String string2) {
        Log.e((String)LOG_TAG, (String)string2);
    }

    public void i(String string2) {
        Log.i((String)LOG_TAG, (String)string2);
    }

    public void v(String string2) {
        Log.v((String)LOG_TAG, (String)string2);
    }

    public void w(String string2) {
        Log.w((String)LOG_TAG, (String)string2);
    }
}


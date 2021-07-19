/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.kwai.opensdk.sdk.utils;

import android.util.Log;

public class LogUtil {
    public static final int LOG_LEVEL_ALL = 5;
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 4;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_NONE = 0;
    public static final int LOG_LEVEL_WARN = 3;
    private static int mLogLevel;

    public static void d(String string2, String string3) {
        int n10;
        int n11 = LogUtil.getLogLevel();
        if (n11 >= (n10 = 1)) {
            Log.d((String)string2, (String)string3);
        }
    }

    public static void e(String string2, String string3) {
        int n10;
        int n11 = LogUtil.getLogLevel();
        if (n11 >= (n10 = 4)) {
            Log.e((String)string2, (String)string3);
        }
    }

    public static int getLogLevel() {
        return mLogLevel;
    }

    public static void i(String string2, String string3) {
        int n10;
        int n11 = LogUtil.getLogLevel();
        if (n11 >= (n10 = 2)) {
            Log.i((String)string2, (String)string3);
        }
    }

    public static void setLogLevel(int n10) {
        mLogLevel = n10;
    }

    public static void v(String string2, String string3) {
        int n10;
        int n11 = LogUtil.getLogLevel();
        if (n11 >= (n10 = 5)) {
            Log.v((String)string2, (String)string3);
        }
    }

    public static void w(String string2, String string3) {
        int n10;
        int n11 = LogUtil.getLogLevel();
        if (n11 >= (n10 = 3)) {
            Log.w((String)string2, (String)string3);
        }
    }
}


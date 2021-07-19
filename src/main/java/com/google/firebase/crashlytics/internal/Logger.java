/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    public static final Logger DEFAULT_LOGGER;
    public static final String TAG = "FirebaseCrashlytics";
    private int logLevel;
    private final String tag;

    static {
        Logger logger;
        DEFAULT_LOGGER = logger = new Logger(TAG);
    }

    public Logger(String string2) {
        this.tag = string2;
        this.logLevel = 4;
    }

    private boolean canLog(int n10) {
        String string2;
        int n11 = this.logLevel;
        n10 = n11 > n10 && (n10 = (int)(Log.isLoggable((String)(string2 = this.tag), (int)n10) ? 1 : 0)) == 0 ? 0 : 1;
        return n10 != 0;
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    public void d(String string2) {
        this.d(string2, null);
    }

    public void d(String string2, Throwable throwable) {
        boolean bl2 = this.canLog(3);
        if (bl2) {
            String string3 = this.tag;
            Log.d((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void e(String string2) {
        this.e(string2, null);
    }

    public void e(String string2, Throwable throwable) {
        boolean bl2 = this.canLog(6);
        if (bl2) {
            String string3 = this.tag;
            Log.e((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void i(String string2) {
        this.i(string2, null);
    }

    public void i(String string2, Throwable throwable) {
        boolean bl2 = this.canLog(4);
        if (bl2) {
            String string3 = this.tag;
            Log.i((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void log(int n10, String string2) {
        this.log(n10, string2, false);
    }

    public void log(int n10, String string2, boolean bl2) {
        if (bl2 || (bl2 = this.canLog(n10))) {
            String string3 = this.tag;
            Log.println((int)n10, (String)string3, (String)string2);
        }
    }

    public void v(String string2) {
        this.v(string2, null);
    }

    public void v(String string2, Throwable throwable) {
        boolean bl2 = this.canLog(2);
        if (bl2) {
            String string3 = this.tag;
            Log.v((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void w(String string2) {
        this.w(string2, null);
    }

    public void w(String string2, Throwable throwable) {
        boolean bl2 = this.canLog(5);
        if (bl2) {
            String string3 = this.tag;
            Log.w((String)string3, (String)string2, (Throwable)throwable);
        }
    }
}


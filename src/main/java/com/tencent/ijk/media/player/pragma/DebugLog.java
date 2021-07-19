/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.ijk.media.player.pragma;

import android.util.Log;
import java.util.Locale;

public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    public static void d(String string2, String string3) {
        Log.d((String)string2, (String)string3);
    }

    public static void d(String string2, String string3, Throwable throwable) {
        Log.d((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void dfmt(String string2, String string3, Object ... objectArray) {
        string3 = String.format(Locale.US, string3, objectArray);
        Log.d((String)string2, (String)string3);
    }

    public static void e(String string2, String string3) {
        Log.e((String)string2, (String)string3);
    }

    public static void e(String string2, String string3, Throwable throwable) {
        Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void efmt(String string2, String string3, Object ... objectArray) {
        string3 = String.format(Locale.US, string3, objectArray);
        Log.e((String)string2, (String)string3);
    }

    public static void i(String string2, String string3) {
        Log.i((String)string2, (String)string3);
    }

    public static void i(String string2, String string3, Throwable throwable) {
        Log.i((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void ifmt(String string2, String string3, Object ... objectArray) {
        string3 = String.format(Locale.US, string3, objectArray);
        Log.i((String)string2, (String)string3);
    }

    public static void printCause(Throwable throwable) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null) {
            throwable = throwable2;
        }
        DebugLog.printStackTrace(throwable);
    }

    public static void printStackTrace(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void v(String string2, String string3) {
        Log.v((String)string2, (String)string3);
    }

    public static void v(String string2, String string3, Throwable throwable) {
        Log.v((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void vfmt(String string2, String string3, Object ... objectArray) {
        string3 = String.format(Locale.US, string3, objectArray);
        Log.v((String)string2, (String)string3);
    }

    public static void w(String string2, String string3) {
        Log.w((String)string2, (String)string3);
    }

    public static void w(String string2, String string3, Throwable throwable) {
        Log.w((String)string2, (String)string3, (Throwable)throwable);
    }

    public static void wfmt(String string2, String string3, Object ... objectArray) {
        string3 = String.format(Locale.US, string3, objectArray);
        Log.w((String)string2, (String)string3);
    }
}


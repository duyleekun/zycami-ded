/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;

public class QLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final String ERR_KEY = "qq_error|";
    public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
    public static final String TAG_REPORTLEVEL_COLORUSER = "W";
    public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
    public static final String TAG_REPORTLEVEL_USER = "E";
    public static final int USR = 1;
    public static String sBuildNumber = "";

    public static void d(String string2, int n10, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String string4 = QLog.getReportLevel(n10);
        stringBuilder.append(string4);
        stringBuilder.append("]");
        stringBuilder.append(string3);
        string4 = stringBuilder.toString();
        TXCLog.d(string2, string4);
    }

    public static void d(String string2, int n10, String string3, Throwable serializable) {
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("[");
        String string4 = QLog.getReportLevel(n10);
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append("]");
        ((StringBuilder)serializable).append(string3);
        string4 = ((StringBuilder)serializable).toString();
        TXCLog.d(string2, string4);
    }

    public static void dumpCacheToFile() {
    }

    public static void e(String string2, int n10, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String string4 = QLog.getReportLevel(n10);
        stringBuilder.append(string4);
        stringBuilder.append("]");
        stringBuilder.append(string3);
        string4 = stringBuilder.toString();
        TXCLog.e(string2, string4);
    }

    public static void e(String string2, int n10, String string3, Throwable throwable) {
        QLog.e(string2, n10, string3);
    }

    public static String getReportLevel(int n10) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                return TAG_REPORTLEVEL_USER;
            }
            return TAG_REPORTLEVEL_DEVELOPER;
        }
        return TAG_REPORTLEVEL_COLORUSER;
    }

    public static String getStackTraceString(Throwable throwable) {
        return Log.getStackTraceString((Throwable)throwable);
    }

    public static void i(String string2, int n10, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String string4 = QLog.getReportLevel(n10);
        stringBuilder.append(string4);
        stringBuilder.append("]");
        stringBuilder.append(string3);
        string4 = stringBuilder.toString();
        TXCLog.i(string2, string4);
    }

    public static void i(String string2, int n10, String string3, Throwable serializable) {
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("[");
        String string4 = QLog.getReportLevel(n10);
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append("]");
        ((StringBuilder)serializable).append(string3);
        string4 = ((StringBuilder)serializable).toString();
        TXCLog.i(string2, string4);
    }

    public static void init(Context context) {
    }

    public static boolean isColorLevel() {
        return true;
    }

    public static boolean isDevelopLevel() {
        return true;
    }

    public static void p(String string2, String string3) {
    }

    public static void w(String string2, int n10, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String string4 = QLog.getReportLevel(n10);
        stringBuilder.append(string4);
        stringBuilder.append("]");
        stringBuilder.append(string3);
        string4 = stringBuilder.toString();
        TXCLog.w(string2, string4);
    }

    public static void w(String string2, int n10, String string3, Throwable serializable) {
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("[");
        String string4 = QLog.getReportLevel(n10);
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append("]");
        ((StringBuilder)serializable).append(string3);
        string4 = ((StringBuilder)serializable).toString();
        TXCLog.w(string2, string4);
    }
}


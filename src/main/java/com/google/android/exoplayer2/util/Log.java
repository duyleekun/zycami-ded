/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;

public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private Log() {
    }

    private static String appendThrowableString(String string2, Throwable object) {
        int n10 = TextUtils.isEmpty((CharSequence)(object = Log.getThrowableString((Throwable)object)));
        if (n10 == 0) {
            string2 = String.valueOf(string2);
            String string3 = "\n  ";
            object = ((String)object).replace("\n", string3);
            String string4 = String.valueOf(string2);
            n10 = string4.length() + 4;
            int n11 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += n11);
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            stringBuilder.append((String)object);
            char c10 = '\n';
            stringBuilder.append(c10);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static void d(String string2, String string3) {
        int n10 = logLevel;
        if (n10 == 0) {
            android.util.Log.d((String)string2, (String)string3);
        }
    }

    public static void d(String string2, String string3, Throwable throwable) {
        string3 = Log.appendThrowableString(string3, throwable);
        Log.d(string2, string3);
    }

    public static void e(String string2, String string3) {
        int n10 = logLevel;
        int n11 = 3;
        if (n10 <= n11) {
            android.util.Log.e((String)string2, (String)string3);
        }
    }

    public static void e(String string2, String string3, Throwable throwable) {
        string3 = Log.appendThrowableString(string3, throwable);
        Log.e(string2, string3);
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public static String getThrowableString(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        boolean bl2 = Log.isCausedByUnknownHostException(throwable);
        if (bl2) {
            return "UnknownHostException (no network)";
        }
        bl2 = logStackTraces;
        if (!bl2) {
            return throwable.getMessage();
        }
        return android.util.Log.getStackTraceString((Throwable)throwable).trim().replace("\t", "    ");
    }

    public static void i(String string2, String string3) {
        int n10 = logLevel;
        int n11 = 1;
        if (n10 <= n11) {
            android.util.Log.i((String)string2, (String)string3);
        }
    }

    public static void i(String string2, String string3, Throwable throwable) {
        string3 = Log.appendThrowableString(string3, throwable);
        Log.i(string2, string3);
    }

    private static boolean isCausedByUnknownHostException(Throwable throwable) {
        while (throwable != null) {
            boolean bl2 = throwable instanceof UnknownHostException;
            if (bl2) {
                return true;
            }
            throwable = throwable.getCause();
        }
        return false;
    }

    public static void setLogLevel(int n10) {
        logLevel = n10;
    }

    public static void setLogStackTraces(boolean bl2) {
        logStackTraces = bl2;
    }

    public static void w(String string2, String string3) {
        int n10 = logLevel;
        int n11 = 2;
        if (n10 <= n11) {
            android.util.Log.w((String)string2, (String)string3);
        }
    }

    public static void w(String string2, String string3, Throwable throwable) {
        string3 = Log.appendThrowableString(string3, throwable);
        Log.w(string2, string3);
    }

    public boolean getLogStackTraces() {
        return logStackTraces;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.camera.core;

import android.os.Build;
import android.util.Log;

public final class Logger {
    public static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    public static void d(String string2, String string3) {
        Logger.d(string2, string3, null);
    }

    public static void d(String string2, String string3, Throwable throwable) {
        boolean bl2 = Logger.isDebugEnabled(string2);
        if (bl2) {
            string2 = Logger.truncateTag(string2);
            Log.d((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void e(String string2, String string3) {
        Logger.e(string2, string3, null);
    }

    public static void e(String string2, String string3, Throwable throwable) {
        boolean bl2 = Logger.isErrorEnabled(string2);
        if (bl2) {
            string2 = Logger.truncateTag(string2);
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void i(String string2, String string3) {
        Logger.i(string2, string3, null);
    }

    public static void i(String string2, String string3, Throwable throwable) {
        boolean bl2 = Logger.isInfoEnabled(string2);
        if (bl2) {
            string2 = Logger.truncateTag(string2);
            Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static boolean isDebugEnabled(String string2) {
        boolean bl2;
        int n10 = sMinLogLevel;
        int n11 = 3;
        if (n10 > n11 && !(bl2 = Log.isLoggable((String)(string2 = Logger.truncateTag(string2)), (int)n11))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isErrorEnabled(String string2) {
        boolean bl2;
        int n10 = sMinLogLevel;
        int n11 = 6;
        if (n10 > n11 && !(bl2 = Log.isLoggable((String)(string2 = Logger.truncateTag(string2)), (int)n11))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isInfoEnabled(String string2) {
        boolean bl2;
        int n10 = sMinLogLevel;
        int n11 = 4;
        if (n10 > n11 && !(bl2 = Log.isLoggable((String)(string2 = Logger.truncateTag(string2)), (int)n11))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isWarnEnabled(String string2) {
        boolean bl2;
        int n10 = sMinLogLevel;
        int n11 = 5;
        if (n10 > n11 && !(bl2 = Log.isLoggable((String)(string2 = Logger.truncateTag(string2)), (int)n11))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static void setMinLogLevel(int n10) {
        sMinLogLevel = n10;
    }

    private static String truncateTag(String string2) {
        int n10;
        int n11 = 23;
        int n12 = string2.length();
        if (n11 < n12 && (n12 = Build.VERSION.SDK_INT) < (n10 = 24)) {
            n12 = 0;
            string2 = string2.substring(0, n11);
        }
        return string2;
    }

    public static void w(String string2, String string3) {
        Logger.w(string2, string3, null);
    }

    public static void w(String string2, String string3, Throwable throwable) {
        boolean bl2 = Logger.isWarnEnabled(string2);
        if (bl2) {
            string2 = Logger.truncateTag(string2);
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}


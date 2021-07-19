/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.alibaba.sdk.android.oss.common;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils;

public class OSSLog {
    private static final String TAG = "OSS-Android-SDK";
    private static boolean enableLog = false;

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    private static void log2Local(String string2, boolean bl2) {
        if (bl2) {
            OSSLogToFileUtils oSSLogToFileUtils = OSSLogToFileUtils.getInstance();
            oSSLogToFileUtils.write(string2);
        }
    }

    public static void logDebug(String string2) {
        OSSLog.logDebug(TAG, string2);
    }

    public static void logDebug(String string2, String string3) {
        OSSLog.logDebug(string2, string3, true);
    }

    public static void logDebug(String string2, String string3, boolean bl2) {
        boolean bl3 = enableLog;
        if (bl3) {
            String string4 = "[Debug]: ".concat(string3);
            Log.d((String)string2, (String)string4);
            OSSLog.log2Local(string3, bl2);
        }
    }

    public static void logDebug(String string2, boolean bl2) {
        OSSLog.logDebug(TAG, string2, bl2);
    }

    public static void logError(String string2) {
        OSSLog.logError(TAG, string2);
    }

    public static void logError(String string2, String string3) {
        OSSLog.logDebug(string2, string3, true);
    }

    public static void logError(String string2, String string3, boolean bl2) {
        boolean bl3 = enableLog;
        if (bl3) {
            String string4 = "[Error]: ".concat(string3);
            Log.d((String)string2, (String)string4);
            OSSLog.log2Local(string3, bl2);
        }
    }

    public static void logError(String string2, boolean bl2) {
        OSSLog.logError(TAG, string2, bl2);
    }

    public static void logInfo(String string2) {
        OSSLog.logInfo(string2, true);
    }

    public static void logInfo(String string2, boolean bl2) {
        boolean bl3 = enableLog;
        if (bl3) {
            String string3 = "[INFO]: ".concat(string2);
            String string4 = TAG;
            Log.i((String)string4, (String)string3);
            OSSLog.log2Local(string2, bl2);
        }
    }

    public static void logThrowable2Local(Throwable throwable) {
        boolean bl2 = enableLog;
        if (bl2) {
            OSSLogToFileUtils oSSLogToFileUtils = OSSLogToFileUtils.getInstance();
            oSSLogToFileUtils.write(throwable);
        }
    }

    public static void logVerbose(String string2) {
        OSSLog.logVerbose(string2, true);
    }

    public static void logVerbose(String string2, boolean bl2) {
        boolean bl3 = enableLog;
        if (bl3) {
            String string3 = "[Verbose]: ".concat(string2);
            String string4 = TAG;
            Log.v((String)string4, (String)string3);
            OSSLog.log2Local(string2, bl2);
        }
    }

    public static void logWarn(String string2) {
        OSSLog.logWarn(string2, true);
    }

    public static void logWarn(String string2, boolean bl2) {
        boolean bl3 = enableLog;
        if (bl3) {
            String string3 = "[Warn]: ".concat(string2);
            String string4 = TAG;
            Log.w((String)string4, (String)string3);
            OSSLog.log2Local(string2, bl2);
        }
    }
}


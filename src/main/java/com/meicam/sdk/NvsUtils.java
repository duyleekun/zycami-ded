/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.meicam.sdk;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

public class NvsUtils {
    private static final String TAG = "Meicam";
    private static boolean sNeedCheck = true;

    public static boolean checkFunctionInMainThread() {
        int n10 = sNeedCheck;
        int n11 = 1;
        if (n10 == 0) {
            return n11 != 0;
        }
        n10 = NvsUtils.isMainThread();
        if (n10 != 0) {
            return n11 != 0;
        }
        n10 = 4;
        CharSequence charSequence = NvsUtils.getMethodName(n10);
        n11 = TextUtils.isEmpty((CharSequence)charSequence);
        if (n11 != 0) {
            return false;
        }
        n11 = 5;
        String string2 = NvsUtils.getMethodName(n11);
        CharSequence charSequence2 = new StringBuilder();
        String string3 = "Main Thread Checker:\"";
        charSequence2.append(string3);
        charSequence2.append((String)charSequence);
        charSequence2.append("\" API called on a background thread.");
        charSequence = charSequence2.toString();
        charSequence2 = TAG;
        Log.w((String)charSequence2, (String)charSequence);
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 == 0) {
            charSequence = new StringBuilder();
            string3 = "Invoking method: \"";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = "\".";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.w((String)charSequence2, (String)charSequence);
        }
        return false;
    }

    public static String getMethodName(int n10) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        int n11 = stackTraceElementArray.length;
        if (n11 > n10 && n10 >= 0) {
            return stackTraceElementArray[n10].getMethodName();
        }
        return null;
    }

    public static boolean isMainThread() {
        boolean bl2;
        Thread thread;
        Thread thread2 = Looper.getMainLooper().getThread();
        if (thread2 == (thread = Thread.currentThread())) {
            bl2 = true;
        } else {
            bl2 = false;
            thread2 = null;
        }
        return bl2;
    }

    public static void setCheckEnable(boolean bl2) {
        sNeedCheck = bl2;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package cn.leancloud.util;

import android.os.Looper;

public class AndroidUtil {
    public static boolean isMainThread() {
        boolean bl2;
        Looper looper;
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = Looper.getMainLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            looper2 = null;
        }
        return bl2;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.huawei.hms.framework.common;

import android.os.SystemClock;

public class Utils {
    public static long getCurrentTime(boolean bl2) {
        if (bl2) {
            return SystemClock.elapsedRealtime();
        }
        return System.currentTimeMillis();
    }
}


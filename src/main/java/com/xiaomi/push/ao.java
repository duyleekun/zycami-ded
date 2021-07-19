/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.xiaomi.push;

import android.os.Looper;

public class ao {
    public static void a() {
        Thread thread;
        Object object = Looper.getMainLooper().getThread();
        if (object != (thread = Thread.currentThread())) {
            return;
        }
        object = new RuntimeException("can't do this on ui thread");
        throw object;
    }
}


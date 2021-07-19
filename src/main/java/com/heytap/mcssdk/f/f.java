/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.heytap.mcssdk.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f {
    private static final ExecutorService a;
    private static Handler b;

    static {
        Handler handler;
        a = Executors.newSingleThreadExecutor();
        Looper looper = Looper.getMainLooper();
        b = handler = new Handler(looper);
    }

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        b.post(runnable);
    }
}


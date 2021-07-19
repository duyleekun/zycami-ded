/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class u {
    public static final Object a;
    public static ThreadPoolExecutor b;

    static {
        Object object;
        a = object = new Object();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        b = object = new ThreadPoolExecutor(1, 50, 60, timeUnit, linkedBlockingQueue);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ThreadPoolExecutor a() {
        Object object = a;
        synchronized (object) {
            return b;
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.g;

import com.huawei.updatesdk.b.g.c$a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {
    public static final ThreadPoolExecutor a;
    public static final ThreadPoolExecutor b;

    static {
        ThreadPoolExecutor threadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        c$a c$a = new c$a("UpdateSDK-ServerTask");
        int n10 = 2;
        a = threadPoolExecutor = new ThreadPoolExecutor(2, n10, (long)10, timeUnit, linkedBlockingQueue, c$a);
        linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        c$a = new c$a("UpdateSDK-CheckTask");
        b = threadPoolExecutor = new ThreadPoolExecutor(0, n10, (long)5, timeUnit, linkedBlockingQueue, c$a);
    }
}


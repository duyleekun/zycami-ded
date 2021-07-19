/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class t {
    private static volatile t b;
    private static final int c;
    private static final int d;
    private static final int e;
    private static final ThreadFactory f;
    private static final BlockingQueue g;
    private ThreadPoolExecutor a;

    static {
        int n10;
        c = n10 = Runtime.getRuntime().availableProcessors();
        int n11 = Math.min(n10 + -1, 4);
        int n12 = 2;
        d = Math.max(n12, n11);
        e = n10 * n12 + 1;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        f = linkedBlockingQueue;
        g = linkedBlockingQueue = new LinkedBlockingQueue(128);
    }

    private t() {
        ThreadPoolExecutor threadPoolExecutor;
        int n10 = d;
        int n11 = e;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue blockingQueue = g;
        ThreadFactory threadFactory = f;
        this.a = threadPoolExecutor = new ThreadPoolExecutor(n10, n11, (long)30, timeUnit, (BlockingQueue<Runnable>)blockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static t a() {
        Object object = b;
        if (object != null) return b;
        object = t.class;
        synchronized (object) {
            t t10 = b;
            if (t10 != null) return b;
            b = t10 = new t();
            return b;
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            ThreadPoolExecutor threadPoolExecutor = this.a;
            try {
                threadPoolExecutor.execute(runnable);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}


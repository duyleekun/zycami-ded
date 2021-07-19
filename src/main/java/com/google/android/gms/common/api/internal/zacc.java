/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zacc {
    private static final ExecutorService zahw;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        NumberedThreadFactory numberedThreadFactory = new NumberedThreadFactory("GAC_Transform");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 4, (long)60, timeUnit, linkedBlockingQueue, numberedThreadFactory);
        zahw = threadPoolExecutor;
    }

    public static ExecutorService zabb() {
        return zahw;
    }
}


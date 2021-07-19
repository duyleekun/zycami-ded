/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SequentialDownLoadThreadPool {
    private static volatile SequentialDownLoadThreadPool instance;
    private int mCorePoolSize = 1;
    private volatile ThreadPoolExecutor mExecutor;
    private long mKeepAliveTime;
    private int mMaximumPoolSize;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SequentialDownLoadThreadPool() {
        long l10;
        int n10;
        this.mMaximumPoolSize = n10 = -1 >>> 1;
        this.mKeepAliveTime = l10 = 3000L;
        Object object = this.mExecutor;
        if (object != null) return;
        object = SequentialDownLoadThreadPool.class;
        synchronized (object) {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) return;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>();
            ThreadFactory threadFactory = Executors.defaultThreadFactory();
            ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
            int n11 = this.mCorePoolSize;
            int n12 = this.mMaximumPoolSize;
            long l11 = this.mKeepAliveTime;
            this.mExecutor = threadPoolExecutor = new ThreadPoolExecutor(n11, n12, l11, timeUnit, linkedBlockingDeque, threadFactory, abortPolicy);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SequentialDownLoadThreadPool getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = SequentialDownLoadThreadPool.class;
        synchronized (object) {
            SequentialDownLoadThreadPool sequentialDownLoadThreadPool = instance;
            if (sequentialDownLoadThreadPool != null) return instance;
            instance = sequentialDownLoadThreadPool = new SequentialDownLoadThreadPool();
            return instance;
        }
    }

    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    public void remove(Runnable runnable) {
        this.mExecutor.remove(runnable);
    }

    public Future submit(Runnable runnable) {
        return this.mExecutor.submit(runnable);
    }
}


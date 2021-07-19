/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.LogThreadPoolManager$1;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager$2;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager$3;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogThreadPoolManager {
    private static final int PERIOD_TASK_QOS = 1000;
    private static final int SIZE_CACHE_QUEUE = 200;
    private static final int SIZE_CORE_POOL = 1;
    private static final int SIZE_MAX_POOL = 1;
    private static final int SIZE_WORK_QUEUE = 500;
    private static final int TIME_KEEP_ALIVE = 5000;
    private static LogThreadPoolManager sThreadPoolManager;
    private final Runnable mAccessBufferThread;
    private final RejectedExecutionHandler mHandler;
    public final ScheduledFuture mTaskHandler;
    private final Queue mTaskQueue;
    private final ThreadPoolExecutor mThreadPool;
    private final ScheduledExecutorService scheduler;

    static {
        LogThreadPoolManager logThreadPoolManager;
        sThreadPoolManager = logThreadPoolManager = new LogThreadPoolManager();
    }

    private LogThreadPoolManager() {
        ThreadPoolExecutor threadPoolExecutor;
        ScheduledFuture scheduledFuture = new ScheduledFuture();
        this.mTaskQueue = scheduledFuture;
        LogThreadPoolManager$1 logThreadPoolManager$1 = new LogThreadPoolManager$1(this);
        this.mHandler = logThreadPoolManager$1;
        scheduledFuture = Executors.newScheduledThreadPool(1);
        this.scheduler = scheduledFuture;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Object object = new Object(500);
        LogThreadPoolManager$2 logThreadPoolManager$2 = new LogThreadPoolManager$2(this);
        this.mThreadPool = threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5000L, timeUnit, (BlockingQueue<Runnable>)object, logThreadPoolManager$2, logThreadPoolManager$1);
        LogThreadPoolManager$3 logThreadPoolManager$3 = new LogThreadPoolManager$3(this);
        this.mAccessBufferThread = logThreadPoolManager$3;
        object = timeUnit;
        this.mTaskHandler = scheduledFuture = scheduledFuture.scheduleAtFixedRate(logThreadPoolManager$3, 0L, 1000L, timeUnit);
    }

    public static /* synthetic */ Queue access$000(LogThreadPoolManager logThreadPoolManager) {
        return logThreadPoolManager.mTaskQueue;
    }

    public static /* synthetic */ boolean access$100(LogThreadPoolManager logThreadPoolManager) {
        return logThreadPoolManager.hasMoreAcquire();
    }

    public static /* synthetic */ ThreadPoolExecutor access$200(LogThreadPoolManager logThreadPoolManager) {
        return logThreadPoolManager.mThreadPool;
    }

    private boolean hasMoreAcquire() {
        return this.mTaskQueue.isEmpty() ^ true;
    }

    public static LogThreadPoolManager newInstance() {
        LogThreadPoolManager logThreadPoolManager = sThreadPoolManager;
        if (logThreadPoolManager == null) {
            sThreadPoolManager = logThreadPoolManager = new LogThreadPoolManager();
        }
        return sThreadPoolManager;
    }

    public void addExecuteTask(Runnable runnable) {
        if (runnable != null) {
            ThreadPoolExecutor threadPoolExecutor = this.mThreadPool;
            threadPoolExecutor.execute(runnable);
        }
    }
}


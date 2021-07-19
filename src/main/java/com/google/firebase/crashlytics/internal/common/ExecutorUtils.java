/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.ExecutorUtils$1;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils$2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
    private static final long DEFAULT_TERMINATION_TIMEOUT = 2L;

    private ExecutorUtils() {
    }

    private static void addDelayedShutdownHook(String string2, ExecutorService executorService) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ExecutorUtils.addDelayedShutdownHook(string2, executorService, 2, timeUnit);
    }

    private static void addDelayedShutdownHook(String string2, ExecutorService object, long l10, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        ExecutorUtils$2 executorUtils$2 = new ExecutorUtils$2(string2, (ExecutorService)object, l10, timeUnit);
        object = new StringBuilder();
        ((StringBuilder)object).append("Crashlytics Shutdown Hook for ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        Thread thread = new Thread((Runnable)executorUtils$2, string2);
        runtime.addShutdownHook(thread);
    }

    public static ExecutorService buildSingleThreadExecutorService(String string2) {
        Object object = ExecutorUtils.getNamedThreadFactory(string2);
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        object = ExecutorUtils.newSingleThreadExecutor((ThreadFactory)object, discardPolicy);
        ExecutorUtils.addDelayedShutdownHook(string2, (ExecutorService)object);
        return object;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String string2) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(ExecutorUtils.getNamedThreadFactory(string2));
        ExecutorUtils.addDelayedShutdownHook(string2, scheduledExecutorService);
        return scheduledExecutorService;
    }

    public static ThreadFactory getNamedThreadFactory(String string2) {
        AtomicLong atomicLong = new AtomicLong(1L);
        ExecutorUtils$1 executorUtils$1 = new ExecutorUtils$1(string2, atomicLong);
        return executorUtils$1;
    }

    private static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, threadFactory, rejectedExecutionHandler);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}


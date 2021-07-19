/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors$Application$1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MoreExecutors$Application {
    public final void addDelayedShutdownHook(ExecutorService object, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull((Object)timeUnit);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("DelayedShutdownHook-for-");
        charSequence.append(object);
        charSequence = charSequence.toString();
        MoreExecutors$Application$1 moreExecutors$Application$1 = new MoreExecutors$Application$1(this, (ExecutorService)object, l10, timeUnit);
        object = MoreExecutors.newThread((String)charSequence, moreExecutors$Application$1);
        this.addShutdownHook((Thread)object);
    }

    public void addShutdownHook(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }

    public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return this.getExitingExecutorService(threadPoolExecutor, 120, timeUnit);
    }

    public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long l10, TimeUnit timeUnit) {
        MoreExecutors.access$000(threadPoolExecutor);
        ExecutorService executorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.addDelayedShutdownHook(threadPoolExecutor, l10, timeUnit);
        return executorService;
    }

    public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return this.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120, timeUnit);
    }

    public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long l10, TimeUnit timeUnit) {
        MoreExecutors.access$000(scheduledThreadPoolExecutor);
        ScheduledExecutorService scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        this.addDelayedShutdownHook(scheduledThreadPoolExecutor, l10, timeUnit);
        return scheduledExecutorService;
    }
}


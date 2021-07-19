/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.ExecutorsEnhance$FinalizableDelegatedExecutorService;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsEnhance {
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(1, 1, 0L, timeUnit, (BlockingQueue)linkedBlockingQueue, threadFactory);
        ExecutorsEnhance$FinalizableDelegatedExecutorService executorsEnhance$FinalizableDelegatedExecutorService = new ExecutorsEnhance$FinalizableDelegatedExecutorService(threadPoolExcutorEnhance);
        return executorsEnhance$FinalizableDelegatedExecutorService;
    }
}


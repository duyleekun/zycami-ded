/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.ExecutorsEnhance;
import com.huawei.hms.framework.common.ExecutorsUtils$1;
import com.huawei.hms.framework.common.ScheduledThreadPoolExecutorEnhance;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsUtils {
    private static final String THREADNAME_HEADER = "NetworkKit_";

    public static ThreadFactory createThreadFactory(String object) {
        Object object2;
        boolean bl2;
        if (object != null && !(bl2 = ((String)(object2 = ((String)object).trim())).isEmpty())) {
            object2 = new ExecutorsUtils$1((String)object);
            return object2;
        }
        object = new NullPointerException("ThreadName is empty");
        throw object;
    }

    public static ExecutorService newCachedThreadPool(String object) {
        ThreadFactory threadFactory = ExecutorsUtils.createThreadFactory((String)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        object = new ThreadPoolExcutorEnhance(0, -1 >>> 1, (long)60, timeUnit, (BlockingQueue)synchronousQueue, threadFactory);
        return object;
    }

    public static ExecutorService newFixedThreadPool(int n10, String object) {
        ThreadFactory threadFactory = ExecutorsUtils.createThreadFactory((String)object);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        object = new ThreadPoolExcutorEnhance(n10, n10, 0L, timeUnit, (BlockingQueue)linkedBlockingQueue, threadFactory);
        return object;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int n10, String object) {
        object = ExecutorsUtils.createThreadFactory((String)object);
        ScheduledThreadPoolExecutorEnhance scheduledThreadPoolExecutorEnhance = new ScheduledThreadPoolExecutorEnhance(n10, (ThreadFactory)object);
        return scheduledThreadPoolExecutorEnhance;
    }

    public static ExecutorService newSingleThreadExecutor(String string2) {
        return ExecutorsEnhance.newSingleThreadExecutor(ExecutorsUtils.createThreadFactory(string2));
    }
}


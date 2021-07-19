/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder$1
implements ThreadFactory {
    public final /* synthetic */ ThreadFactory val$backingThreadFactory;
    public final /* synthetic */ AtomicLong val$count;
    public final /* synthetic */ Boolean val$daemon;
    public final /* synthetic */ String val$nameFormat;
    public final /* synthetic */ Integer val$priority;
    public final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

    public ThreadFactoryBuilder$1(ThreadFactory threadFactory, String string2, AtomicLong atomicLong, Boolean bl2, Integer n10, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$backingThreadFactory = threadFactory;
        this.val$nameFormat = string2;
        this.val$count = atomicLong;
        this.val$daemon = bl2;
        this.val$priority = n10;
        this.val$uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    public Thread newThread(Runnable runnable) {
        runnable = this.val$backingThreadFactory.newThread(runnable);
        Object object = this.val$nameFormat;
        if (object != null) {
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            long l10 = this.val$count.getAndIncrement();
            Long l11 = l10;
            objectArray[0] = l11;
            object = ThreadFactoryBuilder.access$000((String)object, objectArray);
            ((Thread)runnable).setName((String)object);
        }
        if ((object = this.val$daemon) != null) {
            boolean n10 = (Boolean)object;
            ((Thread)runnable).setDaemon(n10);
        }
        if ((object = this.val$priority) != null) {
            int n10 = (Integer)object;
            ((Thread)runnable).setPriority(n10);
        }
        if ((object = this.val$uncaughtExceptionHandler) != null) {
            ((Thread)runnable).setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
        }
        return runnable;
    }
}


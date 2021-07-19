/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder$1;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder {
    private ThreadFactory backingThreadFactory = null;
    private Boolean daemon = null;
    private String nameFormat = null;
    private Integer priority = null;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;

    public static /* synthetic */ String access$000(String string2, Object[] objectArray) {
        return ThreadFactoryBuilder.format(string2, objectArray);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder object) {
        String string2 = ((ThreadFactoryBuilder)object).nameFormat;
        Boolean bl2 = ((ThreadFactoryBuilder)object).daemon;
        Integer n10 = ((ThreadFactoryBuilder)object).priority;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = ((ThreadFactoryBuilder)object).uncaughtExceptionHandler;
        object = ((ThreadFactoryBuilder)object).backingThreadFactory;
        if (object == null) {
            object = Executors.defaultThreadFactory();
        }
        Object object2 = object;
        if (string2 != null) {
            long l10 = 0L;
            object = new AtomicLong(l10);
        } else {
            object = null;
        }
        Object object3 = object;
        object = new ThreadFactoryBuilder$1((ThreadFactory)object2, string2, (AtomicLong)object3, bl2, n10, uncaughtExceptionHandler);
        return object;
    }

    private static String format(String string2, Object ... objectArray) {
        return String.format(Locale.ROOT, string2, objectArray);
    }

    public ThreadFactory build() {
        return ThreadFactoryBuilder.doBuild(this);
    }

    public ThreadFactoryBuilder setDaemon(boolean bl2) {
        Boolean bl3;
        this.daemon = bl3 = Boolean.valueOf(bl2);
        return this;
    }

    public ThreadFactoryBuilder setNameFormat(String string2) {
        Object[] objectArray = new Object[1];
        Integer n10 = 0;
        objectArray[0] = n10;
        ThreadFactoryBuilder.format(string2, objectArray);
        this.nameFormat = string2;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int n10) {
        Integer n11;
        int n12 = 0;
        int n13 = 1;
        int n14 = n10 >= n13 ? n13 : 0;
        String string2 = "Thread priority (%s) must be >= %s";
        Preconditions.checkArgument(n14 != 0, string2, n10, n13);
        n14 = 10;
        if (n10 <= n14) {
            n12 = n13;
        }
        Preconditions.checkArgument(n12 != 0, "Thread priority (%s) must be <= %s", n10, n14);
        this.priority = n11 = Integer.valueOf(n10);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.backingThreadFactory = threadFactory = (ThreadFactory)Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }
}


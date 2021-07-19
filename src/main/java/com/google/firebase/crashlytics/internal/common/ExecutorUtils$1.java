/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.ExecutorUtils$1$1;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class ExecutorUtils$1
implements ThreadFactory {
    public final /* synthetic */ AtomicLong val$count;
    public final /* synthetic */ String val$threadNameTemplate;

    public ExecutorUtils$1(String string2, AtomicLong atomicLong) {
        this.val$threadNameTemplate = string2;
        this.val$count = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Object object = Executors.defaultThreadFactory();
        Object object2 = new ExecutorUtils$1$1(this, runnable);
        runnable = object.newThread((Runnable)object2);
        object = new StringBuilder();
        object2 = this.val$threadNameTemplate;
        ((StringBuilder)object).append((String)object2);
        long l10 = this.val$count.getAndIncrement();
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        ((Thread)runnable).setName((String)object);
        return runnable;
    }
}


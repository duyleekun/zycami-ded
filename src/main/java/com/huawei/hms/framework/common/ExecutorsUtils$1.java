/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExecutorsUtils$1
implements ThreadFactory {
    private final AtomicInteger threadNumbers;
    public final /* synthetic */ String val$threadName;

    public ExecutorsUtils$1(String object) {
        this.val$threadName = object;
        this.threadNumbers = object = new AtomicInteger(0);
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("NetworkKit_");
        String string2 = this.val$threadName;
        charSequence.append(string2);
        charSequence.append("_");
        int n10 = this.threadNumbers.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


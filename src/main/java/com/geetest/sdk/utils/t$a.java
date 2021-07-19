/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class t$a
implements ThreadFactory {
    private final AtomicInteger a;

    public t$a() {
        AtomicInteger atomicInteger;
        this.a = atomicInteger = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("SenseBotTask #");
        int n10 = this.a.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


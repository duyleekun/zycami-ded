/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class c$a
implements ThreadFactory {
    private final AtomicInteger a;
    private String b;

    public c$a(String string2) {
        AtomicInteger atomicInteger;
        this.a = atomicInteger = new AtomicInteger();
        this.b = string2;
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        String string2 = this.b;
        charSequence.append(string2);
        charSequence.append("#");
        int n10 = this.a.incrementAndGet();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


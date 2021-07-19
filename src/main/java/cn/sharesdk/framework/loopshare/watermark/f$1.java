/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.loopshare.watermark;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class f$1
implements ThreadFactory {
    private final AtomicInteger a;

    public f$1() {
        AtomicInteger atomicInteger;
        this.a = atomicInteger = new AtomicInteger();
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("myThreadPool thread:");
        int n10 = this.a.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ModernAsyncTask$1
implements ThreadFactory {
    private final AtomicInteger mCount;

    public ModernAsyncTask$1() {
        AtomicInteger atomicInteger;
        this.mCount = atomicInteger = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ModernAsyncTask #");
        int n10 = this.mCount.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


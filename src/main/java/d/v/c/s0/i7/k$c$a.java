/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.i7;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class k$c$a
implements ThreadFactory {
    private final AtomicInteger a;

    public k$c$a() {
        AtomicInteger atomicInteger;
        this.a = atomicInteger = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("AsyncLayoutInflatePlus #");
        int n10 = this.a.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}


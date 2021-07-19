/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.RxThreadFactory$a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory
extends AtomicLong
implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    public RxThreadFactory(String string2) {
        this(string2, 5, false);
    }

    public RxThreadFactory(String string2, int n10) {
        this(string2, n10, false);
    }

    public RxThreadFactory(String string2, int n10, boolean bl2) {
        this.prefix = string2;
        this.priority = n10;
        this.nonBlocking = bl2;
    }

    public Thread newThread(Runnable runnable) {
        Object object = this.prefix;
        CharSequence charSequence = new StringBuilder((String)object);
        charSequence.append('-');
        long l10 = this.incrementAndGet();
        charSequence.append(l10);
        charSequence = charSequence.toString();
        boolean bl2 = this.nonBlocking;
        object = bl2 ? new RxThreadFactory$a(runnable, (String)charSequence) : new Thread(runnable, (String)charSequence);
        int n10 = this.priority;
        ((Thread)object).setPriority(n10);
        ((Thread)object).setDaemon(true);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        String string2 = this.prefix;
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


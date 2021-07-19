/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

public final class ParallelReduceFull$SlotPair
extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    public Object first;
    public final AtomicInteger releaseIndex;
    public Object second;

    public ParallelReduceFull$SlotPair() {
        AtomicInteger atomicInteger;
        this.releaseIndex = atomicInteger = new AtomicInteger();
    }

    public boolean releaseSlot() {
        int n10;
        AtomicInteger atomicInteger = this.releaseIndex;
        int n11 = atomicInteger.incrementAndGet();
        if (n11 == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            atomicInteger = null;
        }
        return n11 != 0;
    }

    public int tryAcquireSlot() {
        int n10;
        int n11;
        do {
            if ((n10 = this.get()) >= (n11 = 2)) {
                return -1;
            }
            n11 = n10 + 1;
        } while ((n11 = (int)(this.compareAndSet(n10, n11) ? 1 : 0)) == 0);
        return n10;
    }
}


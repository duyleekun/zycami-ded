/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.w0.i.b;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public final class ParallelFromPublisher$ParallelDispatcher$a
implements e {
    public final int a;
    public final int b;
    public final /* synthetic */ ParallelFromPublisher$ParallelDispatcher c;

    public ParallelFromPublisher$ParallelDispatcher$a(ParallelFromPublisher$ParallelDispatcher parallelDispatcher, int n10, int n11) {
        this.c = parallelDispatcher;
        this.a = n10;
        this.b = n11;
    }

    public void cancel() {
        ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = this.c;
        AtomicLongArray atomicLongArray = parallelFromPublisher$ParallelDispatcher.requests;
        int n10 = this.b;
        int n11 = this.a + n10;
        long l10 = 0L;
        long l11 = 1L;
        if ((n10 = (int)(atomicLongArray.compareAndSet(n11, l10, l11) ? 1 : 0)) != 0) {
            parallelFromPublisher$ParallelDispatcher = this.c;
            int n12 = this.b;
            n12 += n12;
            parallelFromPublisher$ParallelDispatcher.cancel(n12);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            int n10;
            long l11;
            long l12;
            int n11;
            int n12;
            AtomicLongArray atomicLongArray = this.c.requests;
            do {
                long l13;
                n12 = this.a;
                l12 = atomicLongArray.get(n12);
                long l14 = l12 - (l13 = Long.MAX_VALUE);
                if ((n12 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) continue;
                return;
            } while ((n12 = (int)(atomicLongArray.compareAndSet(n11 = this.a, l12, l11 = e.a.w0.i.b.c(l12, l10)) ? 1 : 0)) == 0);
            AtomicInteger atomicInteger = this.c.subscriberCount;
            int n13 = atomicInteger.get();
            if (n13 == (n10 = this.b)) {
                atomicInteger = this.c;
                ((ParallelFromPublisher$ParallelDispatcher)atomicInteger).drain();
            }
        }
    }
}


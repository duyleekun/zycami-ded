/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ParallelJoin$JoinSubscriptionBase
extends AtomicInteger
implements e {
    private static final long serialVersionUID = 3100232009247827843L;
    public volatile boolean cancelled;
    public final AtomicInteger done;
    public final d downstream;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final ParallelJoin$JoinInnerSubscriber[] subscribers;

    public ParallelJoin$JoinSubscriptionBase(d parallelJoin$JoinInnerSubscriberArray, int n10, int n11) {
        Serializable serializable;
        this.errors = serializable = new AtomicThrowable();
        this.requested = serializable;
        super();
        this.done = serializable;
        this.downstream = parallelJoin$JoinInnerSubscriberArray;
        parallelJoin$JoinInnerSubscriberArray = new ParallelJoin$JoinInnerSubscriber[n10];
        serializable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            ParallelJoin$JoinInnerSubscriber parallelJoin$JoinInnerSubscriber;
            parallelJoin$JoinInnerSubscriberArray[i10] = parallelJoin$JoinInnerSubscriber = new ParallelJoin$JoinInnerSubscriber(this, n11);
        }
        this.subscribers = parallelJoin$JoinInnerSubscriberArray;
        this.done.lazySet(n10);
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.cancelAll();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                this.cleanup();
            }
        }
    }

    public void cancelAll() {
        for (ParallelJoin$JoinInnerSubscriber parallelJoin$JoinInnerSubscriber : this.subscribers) {
            parallelJoin$JoinInnerSubscriber.cancel();
        }
    }

    public void cleanup() {
        for (ParallelJoin$JoinInnerSubscriber parallelJoin$JoinInnerSubscriber : this.subscribers) {
            parallelJoin$JoinInnerSubscriber.queue = null;
        }
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable var1);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber var1, Object var2);

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}


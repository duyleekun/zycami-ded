/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.o;
import e.a.w0.c.n;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ParallelJoin$JoinInnerSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = 8410034718427740355L;
    public final int limit;
    public final ParallelJoin$JoinSubscriptionBase parent;
    public final int prefetch;
    public long produced;
    public volatile n queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase parallelJoin$JoinSubscriptionBase, int n10) {
        this.parent = parallelJoin$JoinSubscriptionBase;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public n getQueue() {
        n n10 = this.queue;
        if (n10 == null) {
            int n11 = this.prefetch;
            this.queue = n10 = new SpscArrayQueue(n11);
        }
        return n10;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.onError(throwable);
    }

    public void onNext(Object object) {
        this.parent.onNext(this, object);
    }

    public void onSubscribe(e e10) {
        long l10 = this.prefetch;
        SubscriptionHelper.setOnce(this, e10, l10);
    }

    public void request(long l10) {
        long l11 = this.produced + l10;
        long l12 = l11 - (l10 = (long)this.limit);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            this.produced = l10 = 0L;
            e e10 = (e)this.get();
            e10.request(l11);
        } else {
            this.produced = l11;
        }
    }

    public void requestOne() {
        long l10 = this.produced + 1L;
        long l11 = this.limit;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.produced = l11 = 0L;
            e e10 = (e)this.get();
            e10.request(l10);
        } else {
            this.produced = l10;
        }
    }
}


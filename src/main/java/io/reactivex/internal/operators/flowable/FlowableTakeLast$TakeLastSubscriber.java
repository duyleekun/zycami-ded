/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableTakeLast$TakeLastSubscriber
extends ArrayDeque
implements o,
e {
    private static final long serialVersionUID = 7240042530241604978L;
    public volatile boolean cancelled;
    public final int count;
    public volatile boolean done;
    public final d downstream;
    public final AtomicLong requested;
    public e upstream;
    public final AtomicInteger wip;

    public FlowableTakeLast$TakeLastSubscriber(d d10, int n10) {
        Number number;
        this.requested = number = new AtomicLong();
        this.wip = number;
        this.downstream = d10;
        this.count = n10;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public void drain() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            AtomicInteger atomicInteger;
            int n11;
            object = this.downstream;
            AtomicLong atomicLong = this.requested;
            long l10 = atomicLong.get();
            do {
                long l11;
                long l12;
                long l13;
                if ((n11 = this.cancelled) != 0) {
                    return;
                }
                n11 = this.done;
                if (n11 == 0) continue;
                long l14 = l13 = 0L;
                while ((l12 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) != false) {
                    l12 = (long)this.cancelled;
                    if (l12 != false) {
                        return;
                    }
                    Object e10 = this.poll();
                    if (e10 == null) {
                        object.onComplete();
                        return;
                    }
                    object.onNext(e10);
                    long l15 = 1L;
                    l14 += l15;
                }
                n11 = (int)(l14 == l13 ? 0 : (l14 < l13 ? -1 : 1));
                if (n11 == 0 || (n11 = (int)((l11 = l10 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) == 0) continue;
                atomicLong = this.requested;
                long l16 = -l14;
                l10 = atomicLong.addAndGet(l16);
            } while ((n11 = (atomicInteger = this.wip).decrementAndGet()) != 0);
        }
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.count;
        int n11 = this.size();
        if (n10 == n11) {
            this.poll();
        }
        this.offer(object);
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}


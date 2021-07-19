/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableZip$ZipCoordinator;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableZip$ZipSubscriber
extends AtomicReference
implements e.a.o,
e {
    private static final long serialVersionUID = -4627193790118206028L;
    public volatile boolean done;
    public final int limit;
    public final FlowableZip$ZipCoordinator parent;
    public final int prefetch;
    public long produced;
    public o queue;
    public int sourceMode;

    public FlowableZip$ZipSubscriber(FlowableZip$ZipCoordinator flowableZip$ZipCoordinator, int n10) {
        this.parent = flowableZip$ZipCoordinator;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.parent.error(this, throwable);
    }

    public void onNext(Object object) {
        int n10 = this.sourceMode;
        int n11 = 2;
        if (n10 != n11) {
            o o10 = this.queue;
            o10.offer(object);
        }
        this.parent.drain();
    }

    public void onSubscribe(e e10) {
        int n10 = SubscriptionHelper.setOnce(this, e10);
        if (n10 != 0) {
            int n11;
            Object object;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n12;
                object = e10;
                object = (l)e10;
                n11 = object.requestFusion(7);
                if (n11 == (n12 = 1)) {
                    this.sourceMode = n11;
                    this.queue = object;
                    this.done = n12;
                    this.parent.drain();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n11;
                    this.queue = object;
                    long l10 = this.prefetch;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.prefetch;
            this.queue = object = new SpscArrayQueue(n11);
            n10 = this.prefetch;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public void request(long l10) {
        int n10 = this.sourceMode;
        int n11 = 1;
        if (n10 != n11) {
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
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual$a;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSequenceEqual$EqualSubscriber
extends AtomicReference
implements e.a.o {
    private static final long serialVersionUID = 4804128302091633067L;
    public volatile boolean done;
    public final int limit;
    public final FlowableSequenceEqual$a parent;
    public final int prefetch;
    public long produced;
    public volatile o queue;
    public int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(FlowableSequenceEqual$a flowableSequenceEqual$a, int n10) {
        this.parent = flowableSequenceEqual$a;
        int n11 = n10 >> 2;
        this.limit = n11 = n10 - n11;
        this.prefetch = n10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        o o10 = this.queue;
        if (o10 != null) {
            o10.clear();
        }
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.sourceMode;
        if (n10 == 0 && !(bl2 = (o10 = this.queue).offer(object))) {
            object = new MissingBackpressureException();
            this.onError((Throwable)object);
            return;
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
                n11 = object.requestFusion(3);
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

    public void request() {
        int n10 = this.sourceMode;
        int n11 = 1;
        if (n10 != n11) {
            long l10 = this.produced + 1L;
            long l11 = this.limit;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) {
                this.produced = l11 = 0L;
                e e10 = (e)this.get();
                e10.request(l10);
            } else {
                this.produced = l10;
            }
        }
    }
}


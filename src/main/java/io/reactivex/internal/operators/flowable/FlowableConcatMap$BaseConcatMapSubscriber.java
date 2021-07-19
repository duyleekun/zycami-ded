/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapInner;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$b;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FlowableConcatMap$BaseConcatMapSubscriber
extends AtomicInteger
implements e.a.o,
FlowableConcatMap$b,
e {
    private static final long serialVersionUID = -3511336836796789179L;
    public volatile boolean active;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final AtomicThrowable errors;
    public final FlowableConcatMap$ConcatMapInner inner;
    public final int limit;
    public final e.a.v0.o mapper;
    public final int prefetch;
    public o queue;
    public int sourceMode;
    public e upstream;

    public FlowableConcatMap$BaseConcatMapSubscriber(e.a.v0.o object, int n10) {
        this.mapper = object;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
        this.inner = object = new FlowableConcatMap$ConcatMapInner(this);
        this.errors = object = new AtomicThrowable();
    }

    public abstract void drain();

    public final void innerComplete() {
        this.active = false;
        this.drain();
    }

    public final void onComplete() {
        this.done = true;
        this.drain();
    }

    public final void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.sourceMode;
        int n11 = 2;
        if (n10 != n11 && !(bl2 = (o10 = this.queue).offer(object))) {
            this.upstream.cancel();
            object = new IllegalStateException("Queue full?!");
            this.onError((Throwable)object);
            return;
        }
        this.drain();
    }

    public final void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            int n11;
            this.upstream = e10;
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
                    this.subscribeActual();
                    this.drain();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n11;
                    this.queue = object;
                    this.subscribeActual();
                    long l10 = this.prefetch;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.prefetch;
            this.queue = object = new SpscArrayQueue(n11);
            this.subscribeActual();
            n10 = this.prefetch;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public abstract void subscribeActual();
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.v0.c;
import e.a.w0.c.n;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableScanSeed$ScanSeedSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -1776795561228106469L;
    public final c accumulator;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final n queue;
    public final AtomicLong requested;
    public e upstream;
    public Object value;

    public FlowableScanSeed$ScanSeedSubscriber(d object, c c10, Object object2, int n10) {
        this.downstream = object;
        this.accumulator = c10;
        this.value = object2;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n11 = n10 - n11;
        this.queue = object = new SpscArrayQueue(n10);
        object.offer(object2);
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        this.cancelled = true;
        Object object = this.upstream;
        object.cancel();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.queue;
            object.clear();
        }
    }

    public void drain() {
        int n10;
        FlowableScanSeed$ScanSeedSubscriber flowableScanSeed$ScanSeedSubscriber = this;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        d d10 = this.downstream;
        n n12 = this.queue;
        int n13 = this.limit;
        int n14 = this.consumed;
        int n15 = n10 = 1;
        do {
            boolean bl2;
            long l10;
            long l11;
            Serializable serializable = flowableScanSeed$ScanSeedSubscriber.requested;
            long l12 = serializable.get();
            long l13 = l11 = 0L;
            while ((l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) != false) {
                Object object;
                boolean bl3 = flowableScanSeed$ScanSeedSubscriber.cancelled;
                if (bl3) {
                    n12.clear();
                    return;
                }
                bl3 = flowableScanSeed$ScanSeedSubscriber.done;
                if (bl3 && (object = flowableScanSeed$ScanSeedSubscriber.error) != null) {
                    n12.clear();
                    d10.onError((Throwable)object);
                    return;
                }
                object = n12.poll();
                int n16 = object == null ? n10 : 0;
                if (bl3 && n16 != 0) {
                    d10.onComplete();
                    return;
                }
                if (n16 != 0) break;
                d10.onNext(object);
                long l14 = 1L;
                l13 += l14;
                if (++n14 != n13) continue;
                e e10 = flowableScanSeed$ScanSeedSubscriber.upstream;
                l14 = n13;
                e10.request(l14);
                n14 = 0;
                e10 = null;
            }
            if (l10 == false && (bl2 = flowableScanSeed$ScanSeedSubscriber.done)) {
                serializable = flowableScanSeed$ScanSeedSubscriber.error;
                if (serializable != null) {
                    n12.clear();
                    d10.onError((Throwable)serializable);
                    return;
                }
                bl2 = n12.isEmpty();
                if (bl2) {
                    d10.onComplete();
                    return;
                }
            }
            if (bl2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) {
                serializable = flowableScanSeed$ScanSeedSubscriber.requested;
                b.e(serializable, l13);
            }
            flowableScanSeed$ScanSeedSubscriber.consumed = n14;
            n15 = -n15;
        } while ((n15 = flowableScanSeed$ScanSeedSubscriber.addAndGet(n15)) != 0);
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        c c10;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object2 = this.value;
        try {
            c10 = this.accumulator;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = c10.apply(object2, object);
        object2 = "The accumulator returned a null value";
        this.value = object = e.a.w0.b.a.g(object, (String)object2);
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch + -1;
            long l10 = n10;
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


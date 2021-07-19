/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0$c;
import e.a.t0.a;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableObserveOn$ObserveOnSubscriber
extends FlowableObserveOn$BaseObserveOnSubscriber
implements e.a.o {
    private static final long serialVersionUID = -4547113800637756442L;
    public final d downstream;

    public FlowableObserveOn$ObserveOnSubscriber(d d10, h0$c h0$c, boolean bl2, int n10) {
        super(h0$c, bl2, n10);
        this.downstream = d10;
    }

    public void onSubscribe(e e10) {
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
                    this.sourceMode = n12;
                    this.queue = object;
                    this.done = n12;
                    this.downstream.onSubscribe(this);
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n12;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    long l10 = this.prefetch;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.prefetch;
            this.queue = object = new SpscArrayQueue(n11);
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public Object poll() {
        int n10;
        int n11;
        Object object = this.queue.poll();
        if (object != null && (n11 = this.sourceMode) != (n10 = 1)) {
            long l10 = this.produced + 1L;
            long l11 = this.limit;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                this.produced = l11 = 0L;
                e e10 = this.upstream;
                e10.request(l10);
            } else {
                this.produced = l10;
            }
        }
        return object;
    }

    public void runAsync() {
        int n10;
        d d10 = this.downstream;
        o o10 = this.queue;
        long l10 = this.produced;
        int n11 = n10 = 1;
        while (true) {
            int n12;
            Object object;
            AtomicLong atomicLong = this.requested;
            long l11 = atomicLong.get();
            while ((object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) != false) {
                long l12;
                boolean bl2 = this.done;
                try {
                    Object object2 = o10.poll();
                    int n13 = object2 == null ? n10 : 0;
                    bl2 = this.checkTerminated(bl2, n13 != 0, d10);
                    if (bl2) {
                        return;
                    }
                    if (n13 != 0) break;
                    d10.onNext(object2);
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    this.cancelled = n10;
                    this.upstream.cancel();
                    o10.clear();
                    d10.onError(throwable);
                    this.worker.dispose();
                    return;
                }
                long l13 = this.limit;
                if ((object = (l12 = ++l10 - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) continue;
                l13 = Long.MAX_VALUE;
                long l14 = l11 - l13;
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object != false) {
                    atomicLong = this.requested;
                    long l15 = -l10;
                    l11 = atomicLong.addAndGet(l15);
                }
                e e10 = this.upstream;
                e10.request(l10);
                l10 = 0L;
            }
            if (object == false) {
                n12 = this.done;
                boolean bl3 = o10.isEmpty();
                if ((n12 = (int)(this.checkTerminated(n12 != 0, bl3, d10) ? 1 : 0)) != 0) {
                    return;
                }
            }
            if (n11 == (n12 = this.get())) {
                this.produced = l10;
                n11 = -n11;
                if ((n11 = this.addAndGet(n11)) != 0) continue;
                return;
            }
            n11 = n12;
        }
    }

    public void runBackfused() {
        int n10;
        int n11 = n10 = 1;
        do {
            boolean bl2;
            if (bl2 = this.cancelled) {
                return;
            }
            bl2 = this.done;
            d d10 = this.downstream;
            d10.onNext(null);
            if (bl2) {
                this.cancelled = n10;
                Object object = this.error;
                if (object != null) {
                    d d11 = this.downstream;
                    d11.onError((Throwable)object);
                } else {
                    object = this.downstream;
                    object.onComplete();
                }
                this.worker.dispose();
                return;
            }
            n11 = -n11;
        } while ((n11 = this.addAndGet(n11)) != 0);
    }

    public void runSync() {
        int n10;
        d d10 = this.downstream;
        o o10 = this.queue;
        long l10 = this.produced;
        int n11 = n10 = 1;
        while (true) {
            long l11;
            AtomicLong atomicLong = this.requested;
            long l12 = atomicLong.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                try {
                    Object object = o10.poll();
                    boolean bl2 = this.cancelled;
                    if (bl2) {
                        return;
                    }
                    if (object == null) {
                        this.cancelled = n10;
                        d10.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    d10.onNext(object);
                    long l13 = 1L;
                    l10 += l13;
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    this.cancelled = n10;
                    this.upstream.cancel();
                    d10.onError(throwable);
                    this.worker.dispose();
                    return;
                }
            }
            int n12 = this.cancelled;
            if (n12 != 0) {
                return;
            }
            n12 = o10.isEmpty();
            if (n12 != 0) {
                this.cancelled = n10;
                d10.onComplete();
                this.worker.dispose();
                return;
            }
            n12 = this.get();
            if (n11 == n12) {
                this.produced = l10;
                n11 = -n11;
                if ((n11 = this.addAndGet(n11)) != 0) continue;
                return;
            }
            n11 = n12;
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0$c;
import e.a.w0.c.a;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableObserveOn$ObserveOnConditionalSubscriber
extends FlowableObserveOn$BaseObserveOnSubscriber {
    private static final long serialVersionUID = 644624475404284533L;
    public long consumed;
    public final a downstream;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(a a10, h0$c h0$c, boolean bl2, int n10) {
        super(h0$c, bl2, n10);
        this.downstream = a10;
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
            long l10 = this.consumed + 1L;
            long l11 = this.limit;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                this.consumed = l11 = 0L;
                e e10 = this.upstream;
                e10.request(l10);
            } else {
                this.consumed = l10;
            }
        }
        return object;
    }

    public void runAsync() {
        int n10;
        a a10 = this.downstream;
        o o10 = this.queue;
        long l10 = this.produced;
        long l11 = this.consumed;
        int n11 = n10 = 1;
        while (true) {
            int n12;
            long l12;
            AtomicLong atomicLong = this.requested;
            long l13 = atomicLong.get();
            while ((l12 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) != false) {
                long l14;
                long l15;
                Object object;
                boolean bl2 = this.done;
                try {
                    object = o10.poll();
                    int n13 = object == null ? n10 : 0;
                    bl2 = this.checkTerminated(bl2, n13 != 0, a10);
                    if (bl2) {
                        return;
                    }
                    if (n13 != 0) break;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.cancelled = n10;
                    this.upstream.cancel();
                    o10.clear();
                    a10.onError(throwable);
                    this.worker.dispose();
                    return;
                }
                l12 = (long)a10.tryOnNext(object);
                long l16 = 1L;
                if (l12 != false) {
                    l10 += l16;
                }
                if ((l12 = (l15 = (l11 += l16) - (l14 = (long)this.limit)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) continue;
                e e10 = this.upstream;
                e10.request(l11);
                l11 = 0L;
            }
            if (l12 == false) {
                n12 = this.done;
                boolean bl3 = o10.isEmpty();
                if ((n12 = this.checkTerminated(n12 != 0, bl3, a10)) != 0) {
                    return;
                }
            }
            if (n11 == (n12 = this.get())) {
                this.produced = l10;
                this.consumed = l11;
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
            a a10 = this.downstream;
            a10.onNext(null);
            if (bl2) {
                this.cancelled = n10;
                Object object = this.error;
                if (object != null) {
                    a a11 = this.downstream;
                    a11.onError((Throwable)object);
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
        a a10 = this.downstream;
        o o10 = this.queue;
        long l10 = this.produced;
        int n11 = n10 = 1;
        while (true) {
            long l11;
            AtomicLong atomicLong = this.requested;
            long l12 = atomicLong.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                Object object;
                block8: {
                    try {
                        object = o10.poll();
                        boolean bl2 = this.cancelled;
                        if (bl2) {
                            return;
                        }
                        if (object != null) break block8;
                        this.cancelled = n10;
                        a10.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.cancelled = n10;
                        this.upstream.cancel();
                        a10.onError(throwable);
                        this.worker.dispose();
                        return;
                    }
                }
                l11 = (long)a10.tryOnNext(object);
                if (l11 == false) continue;
                long l13 = 1L;
                l10 += l13;
            }
            int n12 = this.cancelled;
            if (n12 != 0) {
                return;
            }
            n12 = o10.isEmpty();
            if (n12 != 0) {
                this.cancelled = n10;
                a10.onComplete();
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


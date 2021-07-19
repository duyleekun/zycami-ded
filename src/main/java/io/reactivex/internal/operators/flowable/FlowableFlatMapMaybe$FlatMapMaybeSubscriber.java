/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.t;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableFlatMapMaybe$FlatMapMaybeSubscriber
extends AtomicInteger
implements e.a.o,
e {
    private static final long serialVersionUID = 8600231336733376951L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final d downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public final int maxConcurrency;
    public final AtomicReference queue;
    public final AtomicLong requested;
    public final e.a.s0.a set;
    public e upstream;

    public FlowableFlatMapMaybe$FlatMapMaybeSubscriber(d atomicReference, o o10, boolean bl2, int n10) {
        this.downstream = atomicReference;
        this.mapper = o10;
        this.delayErrors = bl2;
        this.maxConcurrency = n10;
        atomicReference = new AtomicReference();
        this.requested = atomicReference;
        atomicReference = new AtomicReference();
        this.set = atomicReference;
        atomicReference = new AtomicReference();
        this.errors = atomicReference;
        atomicReference = new AtomicReference(1);
        this.active = atomicReference;
        this.queue = atomicReference = new AtomicReference();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
        e.a.w0.f.a a10 = (e.a.w0.f.a)this.queue.get();
        if (a10 != null) {
            a10.clear();
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        int n10;
        FlowableFlatMapMaybe$FlatMapMaybeSubscriber flowableFlatMapMaybe$FlatMapMaybeSubscriber = this;
        d d10 = this.downstream;
        Serializable serializable = this.active;
        AtomicReference atomicReference = this.queue;
        int n11 = n10 = 1;
        do {
            int n12;
            int n13;
            int n14;
            long l10;
            long l11;
            Object object = flowableFlatMapMaybe$FlatMapMaybeSubscriber.requested;
            long l12 = ((AtomicLong)object).get();
            long l13 = l11 = 0L;
            while (true) {
                Throwable throwable;
                l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                n14 = 0;
                if (l10 == false) break;
                int n15 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.cancelled;
                if (n15 != 0) {
                    this.clear();
                    return;
                }
                n15 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.delayErrors;
                if (n15 == 0 && (throwable = (Throwable)flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.get()) != null) {
                    serializable = flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.terminate();
                    this.clear();
                    d10.onError((Throwable)serializable);
                    return;
                }
                n15 = serializable.get();
                if (n15 == 0) {
                    n15 = n10;
                } else {
                    n15 = 0;
                    throwable = null;
                }
                Object object2 = (e.a.w0.f.a)atomicReference.get();
                object2 = object2 != null ? ((e.a.w0.f.a)object2).poll() : null;
                int n16 = object2 == null ? n10 : 0;
                if (n15 != 0 && n16 != 0) {
                    serializable = flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.terminate();
                    if (serializable != null) {
                        d10.onError((Throwable)serializable);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
                if (n16 != 0) break;
                d10.onNext(object2);
                long l14 = 1L;
                l13 += l14;
            }
            if (l10 == false) {
                n13 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.cancelled;
                if (n13 != 0) {
                    this.clear();
                    return;
                }
                n13 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.delayErrors;
                if (n13 == 0 && (object = (Throwable)flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.get()) != null) {
                    serializable = flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.terminate();
                    this.clear();
                    d10.onError((Throwable)serializable);
                    return;
                }
                n13 = serializable.get();
                if (n13 == 0) {
                    n13 = n10;
                } else {
                    n13 = 0;
                    object = null;
                }
                e.a.w0.f.a a10 = (e.a.w0.f.a)atomicReference.get();
                if (a10 == null || (n12 = (int)(a10.isEmpty() ? 1 : 0)) != 0) {
                    n14 = n10;
                }
                if (n13 != 0 && n14 != 0) {
                    serializable = flowableFlatMapMaybe$FlatMapMaybeSubscriber.errors.terminate();
                    if (serializable != null) {
                        d10.onError((Throwable)serializable);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
            }
            if ((n13 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) != 0) {
                object = flowableFlatMapMaybe$FlatMapMaybeSubscriber.requested;
                b.e((AtomicLong)object, l13);
                n13 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.maxConcurrency;
                n12 = -1 >>> 1;
                if (n13 != n12) {
                    object = flowableFlatMapMaybe$FlatMapMaybeSubscriber.upstream;
                    object.request(l13);
                }
            }
            n11 = -n11;
        } while ((n11 = flowableFlatMapMaybe$FlatMapMaybeSubscriber.addAndGet(n11)) != 0);
    }

    public e.a.w0.f.a getOrCreateQueue() {
        e.a.w0.f.a a10;
        AtomicReference atomicReference;
        int n10;
        do {
            if ((a10 = (e.a.w0.f.a)this.queue.get()) != null) {
                return a10;
            }
            n10 = j.f0();
        } while ((n10 = (int)((atomicReference = this.queue).compareAndSet(null, a10 = new e.a.w0.f.a(n10)) ? 1 : 0)) == 0);
        return a10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver object) {
        Object object2 = this.set;
        ((e.a.s0.a)object2).c((e.a.s0.b)object);
        int n10 = this.get();
        long l10 = 1L;
        int n11 = -1 >>> 1;
        if (n10 == 0) {
            n10 = 0;
            object = null;
            int n12 = 1;
            int n13 = this.compareAndSet(0, n12);
            if (n13 != 0) {
                AtomicInteger atomicInteger = this.active;
                n13 = atomicInteger.decrementAndGet();
                if (n13 == 0) {
                    n10 = n12;
                }
                e.a.w0.f.a a10 = (e.a.w0.f.a)this.queue.get();
                if (n10 != 0 && (a10 == null || (n10 = (int)(a10.isEmpty() ? 1 : 0)) != 0)) {
                    object = this.errors.terminate();
                    if (object != null) {
                        object2 = this.downstream;
                        object2.onError((Throwable)object);
                        return;
                    }
                    object = this.downstream;
                    object.onComplete();
                    return;
                }
                n10 = this.maxConcurrency;
                if (n10 != n11) {
                    object = this.upstream;
                    object.request(l10);
                }
                if ((n10 = this.decrementAndGet()) == 0) {
                    return;
                }
                this.drainLoop();
                return;
            }
        }
        object = this.active;
        ((AtomicInteger)object).decrementAndGet();
        n10 = this.maxConcurrency;
        if (n10 != n11) {
            object = this.upstream;
            object.request(l10);
        }
        this.drain();
    }

    public void innerError(FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver object, Throwable throwable) {
        e.a.s0.a a10 = this.set;
        a10.c((e.a.s0.b)object);
        object = this.errors;
        boolean n10 = ((AtomicThrowable)object).addThrowable(throwable);
        if (n10) {
            boolean bl2 = this.delayErrors;
            if (!bl2) {
                this.upstream.cancel();
                object = this.set;
                ((e.a.s0.a)object).dispose();
            } else {
                int n11 = this.maxConcurrency;
                int n12 = -1 >>> 1;
                if (n11 != n12) {
                    object = this.upstream;
                    long l10 = 1L;
                    object.request(l10);
                }
            }
            object = this.active;
            ((AtomicInteger)object).decrementAndGet();
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver var1_1, Object var2_2) {
        var3_3 = this.set;
        var3_3.c((e.a.s0.b)var1_1);
        var4_4 = this.get();
        if (var4_4 != 0) ** GOTO lbl-1000
        var4_4 = 0;
        var1_1 = null;
        var5_5 = 1;
        var6_6 = this.compareAndSet(0, var5_5);
        if (var6_6 != 0) {
            var7_7 = this.active;
            var6_6 = var7_7.decrementAndGet();
            if (var6_6 == 0) {
                var4_4 = var5_5;
            }
            if ((var5_5 = (int)((cfr_temp_0 = (var8_8 = (var3_3 = this.requested).get()) - (var10_9 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                var3_3 = this.downstream;
                var3_3.onNext(var2_2);
                var2_2 = (e.a.w0.f.a)this.queue.get();
                if (var4_4 != 0 && (var2_2 == null || (var4_4 = (int)var2_2.isEmpty()) != 0)) {
                    var1_1 = this.errors.terminate();
                    if (var1_1 != null) {
                        var2_2 = this.downstream;
                        var2_2.onError((Throwable)var1_1);
                        return;
                    }
                    var1_1 = this.downstream;
                    var1_1.onComplete();
                    return;
                }
                var1_1 = this.requested;
                var8_8 = 1L;
                b.e((AtomicLong)var1_1, var8_8);
                var4_4 = this.maxConcurrency;
                var12_10 = -1 >>> 1;
                if (var4_4 != var12_10) {
                    var1_1 = this.upstream;
                    var1_1.request(var8_8);
                }
            } else {
                var1_1 = this.getOrCreateQueue();
                synchronized (var1_1) {
                    var1_1.offer(var2_2);
                }
            }
            if ((var4_4 = this.decrementAndGet()) == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = this.getOrCreateQueue();
            synchronized (var1_1) {
                var1_1.offer(var2_2);
            }
            var1_1 = this.active;
            var1_1.decrementAndGet();
            var4_4 = this.getAndIncrement();
            if (var4_4 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onComplete() {
        this.active.decrementAndGet();
        this.drain();
    }

    public void onError(Throwable object) {
        this.active.decrementAndGet();
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)object);
        if (bl2) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                object = this.set;
                ((e.a.s0.a)object).dispose();
            }
            this.drain();
        } else {
            e.a.a1.a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        e.a.s0.a a10;
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null MaybeSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (w)object;
        this.active.getAndIncrement();
        object2 = new FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver(this);
        boolean bl2 = this.cancelled;
        if (!bl2 && (bl2 = (a10 = this.set).b((e.a.s0.b)object2))) {
            object.g((t)object2);
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.maxConcurrency;
            int n11 = -1 >>> 1;
            if (n10 == n11) {
                long l10 = Long.MAX_VALUE;
                e10.request(l10);
            } else {
                long l11 = n10;
                e10.request(l11);
            }
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


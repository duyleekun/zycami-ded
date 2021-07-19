/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.o;
import e.a.w0.d.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager$ConcatMapEagerMainObserver
extends AtomicInteger
implements g0,
b,
j {
    private static final long serialVersionUID = 8080567949447303262L;
    public int activeCount;
    public volatile boolean cancelled;
    public InnerQueuedObserver current;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final ErrorMode errorMode;
    public final e.a.v0.o mapper;
    public final int maxConcurrency;
    public final ArrayDeque observers;
    public final int prefetch;
    public o queue;
    public int sourceMode;
    public b upstream;

    public ObservableConcatMapEager$ConcatMapEagerMainObserver(g0 arrayDeque, e.a.v0.o o10, int n10, int n11, ErrorMode errorMode) {
        this.downstream = arrayDeque;
        this.mapper = o10;
        this.maxConcurrency = n10;
        this.prefetch = n11;
        this.errorMode = errorMode;
        arrayDeque = new ArrayDeque();
        this.error = arrayDeque;
        this.observers = arrayDeque = new ArrayDeque();
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        this.cancelled = true;
        this.upstream.dispose();
        this.drainAndDispose();
    }

    public void disposeAll() {
        InnerQueuedObserver innerQueuedObserver = this.current;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while ((innerQueuedObserver = (InnerQueuedObserver)this.observers.poll()) != null) {
            innerQueuedObserver.dispose();
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drain() {
        var1_1 = this.getAndIncrement();
        if (var1_1 != 0) {
            return;
        }
        var2_2 = this.queue;
        var3_3 /* !! */  = this.observers;
        var4_5 = this.downstream;
        var5_6 = this.errorMode;
        var7_8 = var6_7 = 1;
        while (true) lbl-1000:
        // 5 sources

        {
            for (var8_9 = this.activeCount; var8_9 != (var9_10 = this.maxConcurrency); ++var8_9) {
                var9_10 = (int)this.cancelled;
                if (var9_10 != 0) {
                    var2_2.clear();
                    this.disposeAll();
                    return;
                }
                var10_11 /* !! */  = ErrorMode.IMMEDIATE;
                if (var5_6 == var10_11 /* !! */  && (var10_11 /* !! */  = (Throwable)this.error.get()) != null) {
                    var2_2.clear();
                    this.disposeAll();
                    var2_2 = this.error.terminate();
                    var4_5.onError((Throwable)var2_2);
                    return;
                }
                try {
                    var10_11 /* !! */  = var2_2.poll();
                    if (var10_11 /* !! */  == null) break;
                }
                catch (Throwable var3_4) {
                    e.a.t0.a.b(var3_4);
                    this.upstream.dispose();
                    var2_2.clear();
                    this.disposeAll();
                    this.error.addThrowable(var3_4);
                    var2_2 = this.error.terminate();
                    var4_5.onError((Throwable)var2_2);
                    return;
                }
                var11_12 = this.mapper;
                var10_11 /* !! */  = var11_12.apply((Object)var10_11 /* !! */ );
                var11_12 = "The mapper returned a null ObservableSource";
                var10_11 /* !! */  = e.a.w0.b.a.g((Object)var10_11 /* !! */ , (String)var11_12);
                var10_11 /* !! */  = (e0)var10_11 /* !! */ ;
                var12_13 = this.prefetch;
                var11_12 = new InnerQueuedObserver(this, var12_13);
                var3_3 /* !! */ .offer(var11_12);
                var10_11 /* !! */ .subscribe((g0)var11_12);
            }
            this.activeCount = var8_9;
            var8_9 = (int)this.cancelled;
            if (var8_9 != 0) {
                var2_2.clear();
                this.disposeAll();
                return;
            }
            var13_14 /* !! */  = ErrorMode.IMMEDIATE;
            if (var5_6 == var13_14 /* !! */  && (var13_14 /* !! */  = (Throwable)this.error.get()) != null) {
                var2_2.clear();
                this.disposeAll();
                var2_2 = this.error.terminate();
                var4_5.onError((Throwable)var2_2);
                return;
            }
            var13_14 /* !! */  = this.current;
            var9_10 = 0;
            var10_11 /* !! */  = null;
            if (var13_14 /* !! */  == null) {
                var13_14 /* !! */  = ErrorMode.BOUNDARY;
                if (var5_6 == var13_14 /* !! */  && (var13_14 /* !! */  = (Throwable)this.error.get()) != null) {
                    var2_2.clear();
                    this.disposeAll();
                    var2_2 = this.error.terminate();
                    var4_5.onError((Throwable)var2_2);
                    return;
                }
                var8_9 = (int)this.done;
                var11_12 = (InnerQueuedObserver)var3_3 /* !! */ .poll();
                var12_13 = var11_12 == null ? var6_7 : 0;
                if (var8_9 != 0 && var12_13 != 0) {
                    var3_3 /* !! */  = (Throwable)this.error.get();
                    if (var3_3 /* !! */  != null) {
                        var2_2.clear();
                        this.disposeAll();
                        var2_2 = this.error.terminate();
                        var4_5.onError((Throwable)var2_2);
                    } else {
                        var4_5.onComplete();
                    }
                    return;
                }
                if (var12_13 == 0) {
                    this.current = var11_12;
                }
                var13_14 /* !! */  = var11_12;
            }
            if (var13_14 /* !! */  != null) {
                var11_12 = var13_14 /* !! */ .queue();
                while (true) {
                    if ((var12_13 = this.cancelled) != 0) {
                        var2_2.clear();
                        this.disposeAll();
                        return;
                    }
                    var12_13 = var13_14 /* !! */ .isDone();
                    var14_16 /* !! */  = ErrorMode.IMMEDIATE;
                    if (var5_6 == var14_16 /* !! */  && (var14_16 /* !! */  = (Throwable)this.error.get()) != null) {
                        var2_2.clear();
                        this.disposeAll();
                        var2_2 = this.error.terminate();
                        var4_5.onError((Throwable)var2_2);
                        return;
                    }
                    var14_16 /* !! */  = null;
                    try {
                        var15_17 = var11_12.poll();
                        var16_18 = var15_17 == null ? var6_7 : 0;
                        if (var12_13 != 0 && var16_18 != 0) {
                            this.current = null;
                            this.activeCount = var8_9 = this.activeCount - var6_7;
                            ** continue;
                        }
                        if (var16_18 != 0) break;
                        var4_5.onNext(var15_17);
                    }
                    catch (Throwable var13_15) {
                        e.a.t0.a.b(var13_15);
                        var10_11 /* !! */  = this.error;
                        var10_11 /* !! */ .addThrowable(var13_15);
                        this.current = null;
                        this.activeCount = var8_9 = this.activeCount - var6_7;
                        ** continue;
                    }
                }
            }
            var7_8 = -var7_8;
            if ((var7_8 = this.addAndGet(var7_8)) == 0) break;
        }
    }

    public void drainAndDispose() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            do {
                o o10 = this.queue;
                o10.clear();
                this.disposeAll();
            } while ((n10 = this.decrementAndGet()) != 0);
        }
    }

    public void innerComplete(InnerQueuedObserver innerQueuedObserver) {
        innerQueuedObserver.setDone();
        this.drain();
    }

    public void innerError(InnerQueuedObserver innerQueuedObserver, Throwable object) {
        Object object2 = this.error;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            if (object == object2) {
                object = this.upstream;
                object.dispose();
            }
            innerQueuedObserver.setDone();
            this.drain();
        } else {
            a.Y(object);
        }
    }

    public void innerNext(InnerQueuedObserver innerQueuedObserver, Object object) {
        innerQueuedObserver.queue().offer(object);
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        int n10 = this.sourceMode;
        if (n10 == 0) {
            o o10 = this.queue;
            o10.offer(object);
        }
        this.drain();
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        int n10 = DisposableHelper.validate(b10, (b)object);
        if (n10 != 0) {
            this.upstream = object;
            n10 = object instanceof e.a.w0.c.j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (e.a.w0.c.j)object).requestFusion(3);
                if (n10 == (n11 = 1)) {
                    this.sourceMode = n10;
                    this.queue = object;
                    this.done = n11;
                    this.downstream.onSubscribe(this);
                    this.drain();
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.sourceMode = n10;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            n10 = this.prefetch;
            this.queue = object = new e.a.w0.f.a(n10);
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}


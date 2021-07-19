/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapSingle$FlatMapSingleObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 8600231336733376951L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public final AtomicReference queue;
    public final e.a.s0.a set;
    public b upstream;

    public ObservableFlatMapSingle$FlatMapSingleObserver(g0 atomicReference, o o10, boolean bl2) {
        this.downstream = atomicReference;
        this.mapper = o10;
        this.delayErrors = bl2;
        atomicReference = new AtomicReference();
        this.set = atomicReference;
        atomicReference = new AtomicReference();
        this.errors = atomicReference;
        atomicReference = new AtomicReference(1);
        this.active = atomicReference;
        this.queue = atomicReference = new AtomicReference();
    }

    public void clear() {
        e.a.w0.f.a a10 = (e.a.w0.f.a)this.queue.get();
        if (a10 != null) {
            a10.clear();
        }
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        int n10;
        g0 g02 = this.downstream;
        Serializable serializable = this.active;
        AtomicReference atomicReference = this.queue;
        int n11 = n10 = 1;
        while (true) {
            Throwable throwable;
            int n12;
            if ((n12 = this.cancelled) != 0) {
                this.clear();
                return;
            }
            n12 = this.delayErrors;
            if (n12 == 0 && (throwable = (Throwable)this.errors.get()) != null) {
                serializable = this.errors.terminate();
                this.clear();
                g02.onError((Throwable)serializable);
                return;
            }
            n12 = serializable.get();
            int n13 = 0;
            if (n12 == 0) {
                n12 = n10;
            } else {
                n12 = 0;
                throwable = null;
            }
            Object object = (e.a.w0.f.a)atomicReference.get();
            object = object != null ? ((e.a.w0.f.a)object).poll() : null;
            if (object == null) {
                n13 = n10;
            }
            if (n12 != 0 && n13 != 0) {
                serializable = this.errors.terminate();
                if (serializable != null) {
                    g02.onError((Throwable)serializable);
                } else {
                    g02.onComplete();
                }
                return;
            }
            if (n13 != 0) {
                n11 = -n11;
                if ((n11 = this.addAndGet(n11)) != 0) continue;
                return;
            }
            g02.onNext(object);
        }
    }

    public e.a.w0.f.a getOrCreateQueue() {
        e.a.w0.f.a a10;
        AtomicReference atomicReference;
        int n10;
        do {
            if ((a10 = (e.a.w0.f.a)this.queue.get()) != null) {
                return a10;
            }
            n10 = z.b0();
        } while ((n10 = (int)((atomicReference = this.queue).compareAndSet(null, a10 = new e.a.w0.f.a(n10)) ? 1 : 0)) == 0);
        return a10;
    }

    public void innerError(ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver object, Throwable throwable) {
        e.a.s0.a a10 = this.set;
        a10.c((b)object);
        object = this.errors;
        boolean bl2 = ((AtomicThrowable)object).addThrowable(throwable);
        if (bl2) {
            bl2 = this.delayErrors;
            if (!bl2) {
                this.upstream.dispose();
                object = this.set;
                ((e.a.s0.a)object).dispose();
            }
            object = this.active;
            ((AtomicInteger)object).decrementAndGet();
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerSuccess(ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver var1_1, Object var2_2) {
        var3_3 = this.set;
        var3_3.c((b)var1_1);
        var4_4 = this.get();
        if (var4_4 != 0) ** GOTO lbl-1000
        var4_4 = 0;
        var1_1 = null;
        var5_5 = 1;
        var6_6 = this.compareAndSet(0, var5_5);
        if (var6_6) {
            var7_7 = this.downstream;
            var7_7.onNext(var2_2);
            var2_2 = this.active;
            var8_8 = var2_2.decrementAndGet();
            if (var8_8 == 0) {
                var4_4 = var5_5;
            }
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
            var4_4 = this.decrementAndGet();
            if (var4_4 == 0) {
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

    public boolean isDisposed() {
        return this.cancelled;
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
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        e.a.s0.a a10;
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null SingleSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (o0)object;
        this.active.getAndIncrement();
        object2 = new ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver(this);
        boolean bl2 = this.cancelled;
        if (!bl2 && (bl2 = (a10 = this.set).b((b)object2))) {
            object.f((l0)object2);
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}


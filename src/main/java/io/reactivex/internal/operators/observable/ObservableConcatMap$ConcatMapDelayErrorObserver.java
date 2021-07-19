/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMap$ConcatMapDelayErrorObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = -6951100001833242599L;
    public volatile boolean active;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final e.a.v0.o mapper;
    public final ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver observer;
    public o queue;
    public int sourceMode;
    public final boolean tillTheEnd;
    public b upstream;

    public ObservableConcatMap$ConcatMapDelayErrorObserver(g0 g02, e.a.v0.o object, int n10, boolean bl2) {
        this.downstream = g02;
        this.mapper = object;
        this.bufferSize = n10;
        this.tillTheEnd = bl2;
        this.error = object = new AtomicThrowable();
        this.observer = object = new ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver(g02, this);
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        while (true) {
            int n11;
            block14: {
                if ((n11 = this.active) == 0) {
                    Object object3;
                    Object object2;
                    n11 = this.cancelled;
                    if (n11 != 0) {
                        object.clear();
                        return;
                    }
                    n11 = (int)(this.tillTheEnd ? 1 : 0);
                    boolean bl2 = true;
                    if (n11 == 0 && (object2 = (Throwable)atomicThrowable.get()) != null) {
                        object.clear();
                        this.cancelled = bl2;
                        object = atomicThrowable.terminate();
                        g02.onError((Throwable)object);
                        return;
                    }
                    n11 = (int)(this.done ? 1 : 0);
                    try {
                        object3 = object.poll();
                        boolean bl3 = object3 == null ? bl2 : false;
                        if (n11 != 0 && bl3) {
                            this.cancelled = bl2;
                            object = atomicThrowable.terminate();
                            if (object != null) {
                                g02.onError((Throwable)object);
                                return;
                            }
                            g02.onComplete();
                            return;
                        }
                        if (bl3) break block14;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.cancelled = bl2;
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(throwable);
                        Throwable throwable2 = atomicThrowable.terminate();
                        g02.onError(throwable2);
                        return;
                    }
                    try {
                        object2 = this.mapper;
                        object2 = object2.apply(object3);
                        object3 = "The mapper returned a null ObservableSource";
                        object2 = e.a.w0.b.a.g(object2, (String)object3);
                        object2 = (e0)object2;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.cancelled = bl2;
                        this.upstream.dispose();
                        object.clear();
                        atomicThrowable.addThrowable(throwable);
                        object = atomicThrowable.terminate();
                        g02.onError((Throwable)object);
                        return;
                    }
                    boolean bl4 = object2 instanceof Callable;
                    if (bl4) {
                        try {
                            object2 = (Callable)object2;
                            if ((object2 = object2.call()) == null || (bl2 = this.cancelled)) continue;
                            g02.onNext(object2);
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            atomicThrowable.addThrowable(throwable);
                        }
                        continue;
                    }
                    this.active = bl2;
                    ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver observableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver = this.observer;
                    object2.subscribe(observableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver);
                }
            }
            if ((n11 = this.decrementAndGet()) == 0) break;
        }
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
            n10 = object instanceof j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (j)object).requestFusion(3);
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
            n10 = this.bufferSize;
            this.queue = object = new e.a.w0.f.a(n10);
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}


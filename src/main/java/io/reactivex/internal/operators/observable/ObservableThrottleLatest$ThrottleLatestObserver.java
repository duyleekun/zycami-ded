/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleLatest$ThrottleLatestObserver
extends AtomicInteger
implements g0,
b,
Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final g0 downstream;
    public final boolean emitLast;
    public Throwable error;
    public final AtomicReference latest;
    public final long timeout;
    public volatile boolean timerFired;
    public boolean timerRunning;
    public final TimeUnit unit;
    public b upstream;
    public final h0$c worker;

    public ObservableThrottleLatest$ThrottleLatestObserver(g0 atomicReference, long l10, TimeUnit timeUnit, h0$c h0$c, boolean bl2) {
        this.downstream = atomicReference;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
        this.emitLast = bl2;
        this.latest = atomicReference = new AtomicReference();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        Object object = this.worker;
        object.dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.latest;
            ((AtomicReference)object).lazySet(null);
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        Serializable serializable = this.latest;
        g0 g02 = this.downstream;
        int n12 = n10 = 1;
        while (true) {
            TimeUnit timeUnit;
            block15: {
                block14: {
                    boolean bl2;
                    block13: {
                        int n13;
                        Throwable throwable;
                        if (bl2 = this.cancelled) {
                            ((AtomicReference)serializable).lazySet(null);
                            return;
                        }
                        bl2 = this.done;
                        if (bl2 && (throwable = this.error) != null) {
                            ((AtomicReference)serializable).lazySet(null);
                            serializable = this.error;
                            g02.onError((Throwable)serializable);
                            this.worker.dispose();
                            return;
                        }
                        throwable = ((AtomicReference)serializable).get();
                        timeUnit = null;
                        if (throwable == null) {
                            n13 = n10;
                        } else {
                            n13 = 0;
                            throwable = null;
                        }
                        if (bl2) {
                            serializable = ((AtomicReference)serializable).getAndSet(null);
                            if (n13 == 0 && (n10 = this.emitLast) != 0) {
                                g02.onNext(serializable);
                            }
                            g02.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (n13 == 0) break block13;
                        bl2 = this.timerFired;
                        if (bl2) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                        break block14;
                    }
                    bl2 = this.timerRunning;
                    if (!bl2 || (bl2 = this.timerFired)) break block15;
                }
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            h0$c h0$c = ((AtomicReference)serializable).getAndSet(null);
            g02.onNext(h0$c);
            this.timerFired = false;
            this.timerRunning = n10;
            h0$c = this.worker;
            long l10 = this.timeout;
            timeUnit = this.unit;
            h0$c.c(this, l10, timeUnit);
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
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        this.latest.set(object);
        this.drain();
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

    public void run() {
        this.timerFired = true;
        this.drain();
    }
}


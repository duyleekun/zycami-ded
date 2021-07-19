/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ObservableSampleTimed$SampleTimedObserver
extends AtomicReference
implements g0,
b,
Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    public final g0 downstream;
    public final long period;
    public final h0 scheduler;
    public final AtomicReference timer;
    public final TimeUnit unit;
    public b upstream;

    public ObservableSampleTimed$SampleTimedObserver(g0 g02, long l10, TimeUnit timeUnit, h0 h02) {
        AtomicReference atomicReference;
        this.timer = atomicReference = new AtomicReference();
        this.downstream = g02;
        this.period = l10;
        this.unit = timeUnit;
        this.scheduler = h02;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void dispose() {
        this.cancelTimer();
        this.upstream.dispose();
    }

    public void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 != null) {
            g0 g02 = this.downstream;
            g02.onNext(var1_1);
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.cancelTimer();
        this.complete();
    }

    public void onError(Throwable throwable) {
        this.cancelTimer();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.lazySet(object);
    }

    public void onSubscribe(b b10) {
        Object object = this.upstream;
        boolean bl2 = DisposableHelper.validate((b)object, b10);
        if (bl2) {
            this.upstream = b10;
            this.downstream.onSubscribe(this);
            object = this.scheduler;
            long l10 = this.period;
            TimeUnit timeUnit = this.unit;
            b10 = ((h0)object).g(this, l10, l10, timeUnit);
            object = this.timer;
            DisposableHelper.replace((AtomicReference)object, b10);
        }
    }
}


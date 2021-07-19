/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$a;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$b;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed$TimeoutFallbackObserver
extends AtomicReference
implements g0,
b,
ObservableTimeoutTimed$b {
    private static final long serialVersionUID = 3764492702657003550L;
    public final g0 downstream;
    public e0 fallback;
    public final AtomicLong index;
    public final SequentialDisposable task;
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference upstream;
    public final h0$c worker;

    public ObservableTimeoutTimed$TimeoutFallbackObserver(g0 atomicReference, long l10, TimeUnit timeUnit, h0$c h0$c, e0 e02) {
        this.downstream = atomicReference;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
        this.fallback = e02;
        atomicReference = new AtomicReference();
        this.task = atomicReference;
        atomicReference = new AtomicReference();
        this.index = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object).getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.task.dispose();
            this.downstream.onComplete();
            object = this.worker;
            object.dispose();
        }
    }

    public void onError(Throwable object) {
        Object object2 = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object2).getAndSet(l10);
        long l12 = l11 - l10;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            this.task.dispose();
            object2 = this.downstream;
            object2.onError((Throwable)object);
            object = this.worker;
            object.dispose();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        long l10;
        AtomicLong atomicLong;
        boolean bl2;
        long l11;
        Object object2 = this.index;
        long l12 = ((AtomicLong)object2).get();
        long l13 = l12 - (l11 = Long.MAX_VALUE);
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false && (bl2 = (atomicLong = this.index).compareAndSet(l12, l10 = 1L + l12))) {
            ((b)this.task.get()).dispose();
            object2 = this.downstream;
            object2.onNext(object);
            this.startTimeout(l10);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void onTimeout(long l10) {
        Object object = this.index;
        long l11 = Long.MAX_VALUE;
        boolean bl2 = ((AtomicLong)object).compareAndSet(l10, l11);
        if (bl2) {
            DisposableHelper.dispose(this.upstream);
            Object object2 = this.fallback;
            this.fallback = null;
            object = this.downstream;
            ObservableTimeoutTimed$a observableTimeoutTimed$a = new ObservableTimeoutTimed$a((g0)object, this);
            object2.subscribe(observableTimeoutTimed$a);
            object2 = this.worker;
            object2.dispose();
        }
    }

    public void startTimeout(long l10) {
        SequentialDisposable sequentialDisposable = this.task;
        h0$c h0$c = this.worker;
        ObservableTimeoutTimed$c observableTimeoutTimed$c = new ObservableTimeoutTimed$c(l10, this);
        l10 = this.timeout;
        TimeUnit timeUnit = this.unit;
        b b10 = h0$c.c(observableTimeoutTimed$c, l10, timeUnit);
        sequentialDisposable.replace(b10);
    }
}


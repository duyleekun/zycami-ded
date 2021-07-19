/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutConsumer;
import io.reactivex.internal.operators.observable.ObservableTimeout$a;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout$TimeoutFallbackObserver
extends AtomicReference
implements g0,
b,
ObservableTimeout$a {
    private static final long serialVersionUID = -7508389464265974549L;
    public final g0 downstream;
    public e0 fallback;
    public final AtomicLong index;
    public final o itemTimeoutIndicator;
    public final SequentialDisposable task;
    public final AtomicReference upstream;

    public ObservableTimeout$TimeoutFallbackObserver(g0 atomicReference, o o10, e0 e02) {
        this.downstream = atomicReference;
        this.itemTimeoutIndicator = o10;
        atomicReference = new AtomicReference();
        this.task = atomicReference;
        this.fallback = e02;
        atomicReference = new AtomicReference();
        this.index = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Serializable serializable = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)serializable).getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            this.downstream.onComplete();
            serializable = this.task;
            ((SequentialDisposable)serializable).dispose();
        }
    }

    public void onError(Throwable serializable) {
        Object object = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object).getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.task.dispose();
            object = this.downstream;
            object.onError((Throwable)serializable);
            serializable = this.task;
            ((SequentialDisposable)serializable).dispose();
        } else {
            a.Y((Throwable)serializable);
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
            object2 = (b)this.task.get();
            if (object2 != null) {
                object2.dispose();
            }
            object2 = this.downstream;
            object2.onNext(object);
            object2 = this.itemTimeoutIndicator;
            object = object2.apply(object);
            object2 = "The itemTimeoutIndicator returned a null ObservableSource.";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                object = (e0)object;
                object2 = new ObservableTimeout$TimeoutConsumer(l10, this);
                SequentialDisposable sequentialDisposable = this.task;
                boolean bl3 = sequentialDisposable.replace((b)object2);
                if (bl3) {
                    object.subscribe((g0)object2);
                }
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((b)this.upstream.get()).dispose();
                this.index.getAndSet(l11);
                object2 = this.downstream;
                object2.onError(throwable);
            }
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
            e0 e02 = this.fallback;
            this.fallback = null;
            object = this.downstream;
            ObservableTimeoutTimed$a observableTimeoutTimed$a = new ObservableTimeoutTimed$a((g0)object, this);
            e02.subscribe(observableTimeoutTimed$a);
        }
    }

    public void onTimeoutError(long l10, Throwable throwable) {
        AtomicLong atomicLong = this.index;
        long l11 = Long.MAX_VALUE;
        boolean bl2 = atomicLong.compareAndSet(l10, l11);
        if (bl2) {
            DisposableHelper.dispose(this);
            g0 g02 = this.downstream;
            g02.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void startFirstTimeout(e0 e02) {
        long l10;
        ObservableTimeout$TimeoutConsumer observableTimeout$TimeoutConsumer;
        SequentialDisposable sequentialDisposable;
        boolean bl2;
        if (e02 != null && (bl2 = (sequentialDisposable = this.task).replace(observableTimeout$TimeoutConsumer = new ObservableTimeout$TimeoutConsumer(l10 = 0L, this)))) {
            e02.subscribe(observableTimeout$TimeoutConsumer);
        }
    }
}


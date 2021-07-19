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
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout$TimeoutObserver
extends AtomicLong
implements g0,
b,
ObservableTimeout$a {
    private static final long serialVersionUID = 3764492702657003550L;
    public final g0 downstream;
    public final o itemTimeoutIndicator;
    public final SequentialDisposable task;
    public final AtomicReference upstream;

    public ObservableTimeout$TimeoutObserver(g0 atomicReference, o o10) {
        this.downstream = atomicReference;
        this.itemTimeoutIndicator = o10;
        atomicReference = new AtomicReference();
        this.task = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    public void onComplete() {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            g0 g02 = this.downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            g0 g02 = this.downstream;
            g02.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        long l10;
        boolean bl2;
        long l11;
        long l12 = this.get();
        long l13 = l12 - (l11 = Long.MAX_VALUE);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false && (bl2 = this.compareAndSet(l12, l10 = 1L + l12))) {
            Object object3 = (b)this.task.get();
            if (object3 != null) {
                object3.dispose();
            }
            object3 = this.downstream;
            object3.onNext(object);
            object3 = this.itemTimeoutIndicator;
            object = object3.apply(object);
            object3 = "The itemTimeoutIndicator returned a null ObservableSource.";
            object = e.a.w0.b.a.g(object, (String)object3);
            try {
                object = (e0)object;
                object3 = new ObservableTimeout$TimeoutConsumer(l10, this);
                SequentialDisposable sequentialDisposable = this.task;
                boolean bl3 = sequentialDisposable.replace((b)object3);
                if (bl3) {
                    object.subscribe((g0)object3);
                }
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((b)this.upstream.get()).dispose();
                this.getAndSet(l11);
                object3 = this.downstream;
                object3.onError(throwable);
            }
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void onTimeout(long l10) {
        long l11 = Long.MAX_VALUE;
        boolean bl2 = this.compareAndSet(l10, l11);
        if (bl2) {
            DisposableHelper.dispose(this.upstream);
            g0 g02 = this.downstream;
            TimeoutException timeoutException = new TimeoutException();
            g02.onError(timeoutException);
        }
    }

    public void onTimeoutError(long l10, Throwable throwable) {
        long l11 = Long.MAX_VALUE;
        boolean bl2 = this.compareAndSet(l10, l11);
        if (bl2) {
            DisposableHelper.dispose(this.upstream);
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


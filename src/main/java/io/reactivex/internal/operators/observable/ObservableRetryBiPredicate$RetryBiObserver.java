/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate$RetryBiObserver
extends AtomicInteger
implements g0 {
    private static final long serialVersionUID = -7098360935104053232L;
    public final g0 downstream;
    public final d predicate;
    public int retries;
    public final e0 source;
    public final SequentialDisposable upstream;

    public ObservableRetryBiPredicate$RetryBiObserver(g0 g02, d d10, SequentialDisposable sequentialDisposable, e0 e02) {
        this.downstream = g02;
        this.upstream = sequentialDisposable;
        this.source = e02;
        this.predicate = d10;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        d d10;
        int n10 = 1;
        try {
            d10 = this.predicate;
        }
        catch (Throwable throwable2) {
            a.b(throwable2);
            object = this.downstream;
            Throwable[] throwableArray = new Throwable[2];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            object.onError(compositeException);
            return;
        }
        int n11 = this.retries + n10;
        this.retries = n11;
        object = n11;
        n10 = (int)(d10.a(object, throwable) ? 1 : 0);
        if (n10 == 0) {
            this.downstream.onError(throwable);
            return;
        }
        this.subscribeNext();
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.upstream.replace(b10);
    }

    public void subscribeNext() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 1;
            do {
                Object object;
                boolean bl2;
                if (bl2 = ((SequentialDisposable)(object = this.upstream)).isDisposed()) {
                    return;
                }
                object = this.source;
                object.subscribe(this);
                n10 = -n10;
            } while ((n10 = this.addAndGet(n10)) != 0);
        }
    }
}


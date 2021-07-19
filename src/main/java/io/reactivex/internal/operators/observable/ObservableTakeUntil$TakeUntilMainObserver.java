/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver$OtherObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil$TakeUntilMainObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 1418547743690811973L;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final ObservableTakeUntil$TakeUntilMainObserver$OtherObserver otherObserver;
    public final AtomicReference upstream;

    public ObservableTakeUntil$TakeUntilMainObserver(g0 atomicReference) {
        this.downstream = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
        this.otherObserver = atomicReference = new ObservableTakeUntil$TakeUntilMainObserver$OtherObserver(this);
        this.error = atomicReference;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.otherObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.otherObserver);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.a(g02, this, atomicThrowable);
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.otherObserver);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }

    public void onNext(Object object) {
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.e(g02, object, this, atomicThrowable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.a(g02, this, atomicThrowable);
    }

    public void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }
}


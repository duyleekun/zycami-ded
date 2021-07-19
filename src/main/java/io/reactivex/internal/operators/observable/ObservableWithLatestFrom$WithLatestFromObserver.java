/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom$WithLatestFromObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -312246233408980075L;
    public final c combiner;
    public final g0 downstream;
    public final AtomicReference other;
    public final AtomicReference upstream;

    public ObservableWithLatestFrom$WithLatestFromObserver(g0 g02, c c10) {
        AtomicReference atomicReference;
        this.upstream = atomicReference = new AtomicReference();
        this.other = atomicReference = new AtomicReference();
        this.downstream = g02;
        this.combiner = c10;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2 = this.get();
        if (object2 != null) {
            c c10 = this.combiner;
            object = c10.apply(object, object2);
            object2 = "The combiner returned a null value";
            try {
                object = a.g(object, object2);
                object2 = this.downstream;
                object2.onNext(object);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.dispose();
                object2 = this.downstream;
                object2.onError(throwable);
            }
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(throwable);
    }

    public boolean setOther(b b10) {
        return DisposableHelper.setOnce(this.other, b10);
    }
}


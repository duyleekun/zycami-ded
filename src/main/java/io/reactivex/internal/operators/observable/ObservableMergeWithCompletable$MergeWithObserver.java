/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable$MergeWithObserver$OtherObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable$MergeWithObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = -4592979584110982903L;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final AtomicReference mainDisposable;
    public volatile boolean mainDone;
    public volatile boolean otherDone;
    public final ObservableMergeWithCompletable$MergeWithObserver$OtherObserver otherObserver;

    public ObservableMergeWithCompletable$MergeWithObserver(g0 atomicReference) {
        this.downstream = atomicReference;
        this.mainDisposable = atomicReference = new AtomicReference();
        this.otherObserver = atomicReference = new ObservableMergeWithCompletable$MergeWithObserver$OtherObserver(this);
        this.error = atomicReference;
    }

    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        boolean bl2 = this.otherDone;
        if (bl2) {
            g0 g02 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.a(g02, this, atomicThrowable);
        }
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
        DisposableHelper.setOnce(this.mainDisposable, b10);
    }

    public void otherComplete() {
        this.otherDone = true;
        boolean bl2 = this.mainDone;
        if (bl2) {
            g0 g02 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.a(g02, this, atomicThrowable);
        }
    }

    public void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.mainDisposable);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }
}


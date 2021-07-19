/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestFromObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFromMany$WithLatestInnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final ObservableWithLatestFromMany$WithLatestFromObserver parent;

    public ObservableWithLatestFromMany$WithLatestInnerObserver(ObservableWithLatestFromMany$WithLatestFromObserver observableWithLatestFromMany$WithLatestFromObserver, int n10) {
        this.parent = observableWithLatestFromMany$WithLatestFromObserver;
        this.index = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        ObservableWithLatestFromMany$WithLatestFromObserver observableWithLatestFromMany$WithLatestFromObserver = this.parent;
        int n10 = this.index;
        boolean bl2 = this.hasValue;
        observableWithLatestFromMany$WithLatestFromObserver.innerComplete(n10, bl2);
    }

    public void onError(Throwable throwable) {
        ObservableWithLatestFromMany$WithLatestFromObserver observableWithLatestFromMany$WithLatestFromObserver = this.parent;
        int n10 = this.index;
        observableWithLatestFromMany$WithLatestFromObserver.innerError(n10, throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.hasValue;
        if (!bl2) {
            this.hasValue = bl2 = true;
        }
        ObservableWithLatestFromMany$WithLatestFromObserver observableWithLatestFromMany$WithLatestFromObserver = this.parent;
        int n10 = this.index;
        observableWithLatestFromMany$WithLatestFromObserver.innerNext(n10, object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


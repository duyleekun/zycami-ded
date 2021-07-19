/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable$SingleToObservableObserver
extends DeferredScalarDisposable
implements l0 {
    private static final long serialVersionUID = 3786543492451018833L;
    public b upstream;

    public SingleToObservable$SingleToObservableObserver(g0 g02) {
        super(g02);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onError(Throwable throwable) {
        this.error(throwable);
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

    public void onSuccess(Object object) {
        this.complete(object);
    }
}


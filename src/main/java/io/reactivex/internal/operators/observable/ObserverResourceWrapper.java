/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -8612022020200669122L;
    public final g0 downstream;
    public final AtomicReference upstream;

    public ObserverResourceWrapper(g0 g02) {
        AtomicReference atomicReference;
        this.upstream = atomicReference = new AtomicReference();
        this.downstream = g02;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.upstream.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        this.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        AtomicReference atomicReference = this.upstream;
        boolean bl2 = DisposableHelper.setOnce(atomicReference, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void setResource(b b10) {
        DisposableHelper.set(this, b10);
    }
}


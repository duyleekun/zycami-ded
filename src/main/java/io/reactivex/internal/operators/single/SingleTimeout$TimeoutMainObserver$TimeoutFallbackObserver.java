/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = 2071387740092105509L;
    public final l0 downstream;

    public SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver(l0 l02) {
        this.downstream = l02;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }
}


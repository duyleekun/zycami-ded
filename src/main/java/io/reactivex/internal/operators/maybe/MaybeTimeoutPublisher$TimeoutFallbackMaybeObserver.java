/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = 8663801314800248617L;
    public final t downstream;

    public MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver(t t10) {
        this.downstream = t10;
    }

    public void onComplete() {
        this.downstream.onComplete();
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


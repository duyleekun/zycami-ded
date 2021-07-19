/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver$a
implements t {
    public final t a;
    public final AtomicReference b;

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver$a(t t10, AtomicReference atomicReference) {
        this.a = t10;
        this.b = atomicReference;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.b, b10);
    }

    public void onSuccess(Object object) {
        this.a.onSuccess(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeoutTimed$a
implements g0 {
    public final g0 a;
    public final AtomicReference b;

    public ObservableTimeoutTimed$a(g0 g02, AtomicReference atomicReference) {
        this.a = g02;
        this.b = atomicReference;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this.b, b10);
    }
}


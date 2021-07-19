/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$a
implements l0 {
    public final l0 a;
    public final AtomicReference b;

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$a(l0 l02, AtomicReference atomicReference) {
        this.a = l02;
        this.b = atomicReference;
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


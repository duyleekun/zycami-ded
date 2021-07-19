/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle$a
implements l0 {
    public final AtomicReference a;
    public final l0 b;

    public MaybeFlatMapSingle$a(AtomicReference atomicReference, l0 l02) {
        this.a = atomicReference;
        this.b = l02;
    }

    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this.a, b10);
    }

    public void onSuccess(Object object) {
        this.b.onSuccess(object);
    }
}


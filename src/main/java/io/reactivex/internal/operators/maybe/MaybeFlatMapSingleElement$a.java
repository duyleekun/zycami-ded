/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingleElement$a
implements l0 {
    public final AtomicReference a;
    public final t b;

    public MaybeFlatMapSingleElement$a(AtomicReference atomicReference, t t10) {
        this.a = atomicReference;
        this.b = t10;
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


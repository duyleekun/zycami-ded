/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver;

public final class MaybeFlatten$FlatMapMaybeObserver$a
implements t {
    public final /* synthetic */ MaybeFlatten$FlatMapMaybeObserver a;

    public MaybeFlatten$FlatMapMaybeObserver$a(MaybeFlatten$FlatMapMaybeObserver flatMapMaybeObserver) {
        this.a = flatMapMaybeObserver;
    }

    public void onComplete() {
        this.a.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.downstream.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.a, b10);
    }

    public void onSuccess(Object object) {
        this.a.downstream.onSuccess(object);
    }
}


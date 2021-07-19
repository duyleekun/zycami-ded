/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$FlatMapMaybeObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe$FlatMapMaybeObserver$InnerObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -502562646270949838L;
    public final /* synthetic */ ObservableFlatMapMaybe$FlatMapMaybeObserver this$0;

    public ObservableFlatMapMaybe$FlatMapMaybeObserver$InnerObserver(ObservableFlatMapMaybe$FlatMapMaybeObserver flatMapMaybeObserver) {
        this.this$0 = flatMapMaybeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.this$0.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.this$0.innerSuccess(this, object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = 8606673141535671828L;
    public final /* synthetic */ ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver this$0;

    public ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver flatMapCompletableMainObserver) {
        this.this$0 = flatMapCompletableMainObserver;
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
}


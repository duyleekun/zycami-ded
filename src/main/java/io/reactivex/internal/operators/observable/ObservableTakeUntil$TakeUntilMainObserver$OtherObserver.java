/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil$TakeUntilMainObserver$OtherObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = -8693423678067375039L;
    public final /* synthetic */ ObservableTakeUntil$TakeUntilMainObserver this$0;

    public ObservableTakeUntil$TakeUntilMainObserver$OtherObserver(ObservableTakeUntil$TakeUntilMainObserver takeUntilMainObserver) {
        this.this$0 = takeUntilMainObserver;
    }

    public void onComplete() {
        this.this$0.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.this$0.otherError(throwable);
    }

    public void onNext(Object object) {
        DisposableHelper.dispose(this);
        this.this$0.otherComplete();
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


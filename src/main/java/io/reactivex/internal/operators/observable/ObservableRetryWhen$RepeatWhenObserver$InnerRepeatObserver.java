/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = 3254781284376480842L;
    public final /* synthetic */ ObservableRetryWhen$RepeatWhenObserver this$0;

    public ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver(ObservableRetryWhen$RepeatWhenObserver repeatWhenObserver) {
        this.this$0 = repeatWhenObserver;
    }

    public void onComplete() {
        this.this$0.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(throwable);
    }

    public void onNext(Object object) {
        this.this$0.innerNext();
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


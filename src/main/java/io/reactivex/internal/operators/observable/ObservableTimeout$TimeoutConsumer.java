/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTimeout$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout$TimeoutConsumer
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final ObservableTimeout$a parent;

    public ObservableTimeout$TimeoutConsumer(long l10, ObservableTimeout$a a10) {
        this.idx = l10;
        this.parent = a10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        DisposableHelper disposableHelper;
        Object object = this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            this.lazySet(disposableHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeout(l10);
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper;
        Object object = this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            this.lazySet(disposableHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeoutError(l10, throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        DisposableHelper disposableHelper;
        object = (b)this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED)) {
            object.dispose();
            this.lazySet(disposableHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeout(l10);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


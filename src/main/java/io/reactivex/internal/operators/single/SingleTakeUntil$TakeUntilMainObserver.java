/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilOtherSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTakeUntil$TakeUntilMainObserver
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = -622603812305745221L;
    public final l0 downstream;
    public final SingleTakeUntil$TakeUntilOtherSubscriber other;

    public SingleTakeUntil$TakeUntilMainObserver(l0 object) {
        this.downstream = object;
        this.other = object = new SingleTakeUntil$TakeUntilOtherSubscriber(this);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.other.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onError(Throwable throwable) {
        this.other.dispose();
        b b10 = (b)this.get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 != disposableHelper && (b10 = (b)this.getAndSet(disposableHelper)) != disposableHelper) {
            this.downstream.onError(throwable);
            return;
        }
        a.Y(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.other.dispose();
        Object object2 = DisposableHelper.DISPOSED;
        b b10 = this.getAndSet(object2);
        if (b10 != object2) {
            object2 = this.downstream;
            object2.onSuccess(object);
        }
    }

    public void otherError(Throwable throwable) {
        DisposableHelper disposableHelper;
        b b10 = (b)this.get();
        if (b10 != (disposableHelper = DisposableHelper.DISPOSED) && (b10 = (b)this.getAndSet(disposableHelper)) != disposableHelper) {
            if (b10 != null) {
                b10.dispose();
            }
            this.downstream.onError(throwable);
            return;
        }
        a.Y(throwable);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -2187421758664251153L;
    public final t downstream;
    public final MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver other;

    public MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver(t t10) {
        this.downstream = t10;
        super(this);
        this.other = t10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        Object object = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object);
        if (disposableHelper != object) {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        Object object = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object);
        if (disposableHelper != object) {
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        DisposableHelper.dispose(this.other);
        Object object2 = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object2);
        if (disposableHelper != object2) {
            object2 = this.downstream;
            object2.onSuccess(object);
        }
    }

    public void otherComplete() {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            t t10 = this.downstream;
            t10.onComplete();
        }
    }

    public void otherError(Throwable throwable) {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            t t10 = this.downstream;
            t10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }
}


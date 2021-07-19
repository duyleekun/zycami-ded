/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualCoordinator;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle$EqualObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = -3031974433025990931L;
    public final MaybeEqualSingle$EqualCoordinator parent;
    public Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator maybeEqualSingle$EqualCoordinator) {
        this.parent = maybeEqualSingle$EqualCoordinator;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.done();
    }

    public void onError(Throwable throwable) {
        this.parent.error(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.value = object;
        this.parent.done();
    }
}


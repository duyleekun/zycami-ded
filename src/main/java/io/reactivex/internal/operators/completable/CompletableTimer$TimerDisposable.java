/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer$TimerDisposable
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = 3167244060586201109L;
    public final d downstream;

    public CompletableTimer$TimerDisposable(d d10) {
        this.downstream = d10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void run() {
        this.downstream.onComplete();
    }

    public void setFuture(b b10) {
        DisposableHelper.replace(this, b10);
    }
}


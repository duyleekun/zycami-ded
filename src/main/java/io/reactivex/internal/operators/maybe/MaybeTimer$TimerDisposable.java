/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer$TimerDisposable
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    public final t downstream;

    public MaybeTimer$TimerDisposable(t t10) {
        this.downstream = t10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void run() {
        t t10 = this.downstream;
        Long l10 = 0L;
        t10.onSuccess(l10);
    }

    public void setFuture(b b10) {
        DisposableHelper.replace(this, b10);
    }
}


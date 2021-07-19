/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer$TimerDisposable
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = 8465401857522493082L;
    public final l0 downstream;

    public SingleTimer$TimerDisposable(l0 l02) {
        this.downstream = l02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void run() {
        l0 l02 = this.downstream;
        Long l10 = 0L;
        l02.onSuccess(l10);
    }

    public void setFuture(b b10) {
        DisposableHelper.replace(this, b10);
    }
}


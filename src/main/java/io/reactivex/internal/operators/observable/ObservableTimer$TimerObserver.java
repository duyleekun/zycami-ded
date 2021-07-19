/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer$TimerObserver
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public final g0 downstream;

    public ObservableTimer$TimerObserver(g0 g02) {
        this.downstream = g02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void run() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.downstream;
            long l10 = 0L;
            Long l11 = l10;
            object.onNext(l11);
            object = EmptyDisposable.INSTANCE;
            this.lazySet(object);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void setResource(b b10) {
        DisposableHelper.trySet(this, b10);
    }
}


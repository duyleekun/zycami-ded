/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval$IntervalObserver
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    public long count;
    public final g0 downstream;

    public ObservableInterval$IntervalObserver(g0 g02) {
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
        Object object;
        Object object2 = this.get();
        if (object2 != (object = DisposableHelper.DISPOSED)) {
            long l10;
            object2 = this.downstream;
            long l11 = this.count;
            this.count = l10 = 1L + l11;
            object = l11;
            object2.onNext(object);
        }
    }

    public void setResource(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


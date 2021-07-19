/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange$IntervalRangeObserver
extends AtomicReference
implements b,
Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    public long count;
    public final g0 downstream;
    public final long end;

    public ObservableIntervalRange$IntervalRangeObserver(g0 g02, long l10, long l11) {
        this.downstream = g02;
        this.count = l10;
        this.end = l11;
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
            long l10 = this.count;
            g0 g02 = this.downstream;
            Long l11 = l10;
            g02.onNext(l11);
            long l12 = this.end;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 == false) {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
                return;
            }
            l12 = 1L;
            this.count = l10 += l12;
        }
    }

    public void setResource(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}


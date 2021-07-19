/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn$ObserveOnCompletableObserver
extends AtomicReference
implements d,
b,
Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    public final d downstream;
    public Throwable error;
    public final h0 scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(d d10, h0 h02) {
        this.downstream = d10;
        this.scheduler = h02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        b b10 = this.scheduler.e(this);
        DisposableHelper.replace(this, b10);
    }

    public void onError(Throwable object) {
        this.error = object;
        object = this.scheduler.e(this);
        DisposableHelper.replace(this, (b)object);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void run() {
        Object object = this.error;
        if (object != null) {
            this.error = null;
            d d10 = this.downstream;
            d10.onError((Throwable)object);
        } else {
            object = this.downstream;
            object.onComplete();
        }
    }
}


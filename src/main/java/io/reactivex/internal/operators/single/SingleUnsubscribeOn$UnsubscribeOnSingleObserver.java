/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn$UnsubscribeOnSingleObserver
extends AtomicReference
implements l0,
b,
Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    public final l0 downstream;
    public b ds;
    public final h0 scheduler;

    public SingleUnsubscribeOn$UnsubscribeOnSingleObserver(l0 l02, h0 h02) {
        this.downstream = l02;
        this.scheduler = h02;
    }

    public void dispose() {
        Object object = DisposableHelper.DISPOSED;
        b b10 = this.getAndSet(object);
        if (b10 != object) {
            this.ds = b10;
            object = this.scheduler;
            ((h0)object).e(this);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }

    public void run() {
        this.ds.dispose();
    }
}


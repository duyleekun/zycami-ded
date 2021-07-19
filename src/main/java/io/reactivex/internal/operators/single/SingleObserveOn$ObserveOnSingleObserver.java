/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn$ObserveOnSingleObserver
extends AtomicReference
implements l0,
b,
Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    public final l0 downstream;
    public Throwable error;
    public final h0 scheduler;
    public Object value;

    public SingleObserveOn$ObserveOnSingleObserver(l0 l02, h0 h02) {
        this.downstream = l02;
        this.scheduler = h02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
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

    public void onSuccess(Object object) {
        this.value = object;
        object = this.scheduler.e(this);
        DisposableHelper.replace(this, (b)object);
    }

    public void run() {
        Object object = this.error;
        if (object != null) {
            l0 l02 = this.downstream;
            l02.onError((Throwable)object);
        } else {
            object = this.downstream;
            Object object2 = this.value;
            object.onSuccess(object2);
        }
    }
}


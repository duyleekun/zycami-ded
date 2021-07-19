/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn$ObserveOnMaybeObserver
extends AtomicReference
implements t,
b,
Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    public final t downstream;
    public Throwable error;
    public final h0 scheduler;
    public Object value;

    public MaybeObserveOn$ObserveOnMaybeObserver(t t10, h0 h02) {
        this.downstream = t10;
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

    public void onSuccess(Object object) {
        this.value = object;
        object = this.scheduler.e(this);
        DisposableHelper.replace(this, (b)object);
    }

    public void run() {
        Object object = this.error;
        t t10 = null;
        if (object != null) {
            this.error = null;
            t10 = this.downstream;
            t10.onError((Throwable)object);
        } else {
            object = this.value;
            if (object != null) {
                this.value = null;
                t10 = this.downstream;
                t10.onSuccess(object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }
}


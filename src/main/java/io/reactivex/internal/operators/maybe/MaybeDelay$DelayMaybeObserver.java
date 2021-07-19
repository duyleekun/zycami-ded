/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay$DelayMaybeObserver
extends AtomicReference
implements t,
b,
Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    public final long delay;
    public final t downstream;
    public Throwable error;
    public final h0 scheduler;
    public final TimeUnit unit;
    public Object value;

    public MaybeDelay$DelayMaybeObserver(t t10, long l10, TimeUnit timeUnit, h0 h02) {
        this.downstream = t10;
        this.delay = l10;
        this.unit = timeUnit;
        this.scheduler = h02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.schedule();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.schedule();
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
        this.schedule();
    }

    public void run() {
        Object object = this.error;
        if (object != null) {
            t t10 = this.downstream;
            t10.onError((Throwable)object);
        } else {
            object = this.value;
            if (object != null) {
                t t11 = this.downstream;
                t11.onSuccess(object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void schedule() {
        Object object = this.scheduler;
        long l10 = this.delay;
        TimeUnit timeUnit = this.unit;
        object = ((h0)object).f(this, l10, timeUnit);
        DisposableHelper.replace(this, (b)object);
    }
}


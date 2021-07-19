/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay$Delay
extends AtomicReference
implements d,
Runnable,
b {
    private static final long serialVersionUID = 465972761105851022L;
    public final long delay;
    public final boolean delayError;
    public final d downstream;
    public Throwable error;
    public final h0 scheduler;
    public final TimeUnit unit;

    public CompletableDelay$Delay(d d10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        this.downstream = d10;
        this.delay = l10;
        this.unit = timeUnit;
        this.scheduler = h02;
        this.delayError = bl2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object = this.scheduler;
        long l10 = this.delay;
        TimeUnit timeUnit = this.unit;
        object = ((h0)object).f(this, l10, timeUnit);
        DisposableHelper.replace(this, (b)object);
    }

    public void onError(Throwable object) {
        this.error = object;
        object = this.scheduler;
        boolean bl2 = this.delayError;
        long l10 = bl2 ? this.delay : 0L;
        TimeUnit timeUnit = this.unit;
        object = ((h0)object).f(this, l10, timeUnit);
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
        d d10 = null;
        this.error = null;
        if (object != null) {
            d10 = this.downstream;
            d10.onError((Throwable)object);
        } else {
            object = this.downstream;
            object.onComplete();
        }
    }
}


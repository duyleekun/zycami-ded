/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed$DebounceTimedObserver
extends AtomicReference
implements g0,
b,
Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    public boolean done;
    public final g0 downstream;
    public volatile boolean gate;
    public final long timeout;
    public final TimeUnit unit;
    public b upstream;
    public final h0$c worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(g0 g02, long l10, TimeUnit timeUnit, h0$c h0$c) {
        this.downstream = g02;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
    }

    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            this.downstream.onComplete();
            h0$c h0$c = this.worker;
            h0$c.dispose();
        }
    }

    public void onError(Throwable object) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y((Throwable)object);
        } else {
            this.done = bl2 = true;
            g0 g02 = this.downstream;
            g02.onError((Throwable)object);
            object = this.worker;
            object.dispose();
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.gate;
        if (!bl2 && !(bl2 = this.done)) {
            this.gate = bl2 = true;
            g0 g02 = this.downstream;
            g02.onNext(object);
            object = (b)this.get();
            if (object != null) {
                object.dispose();
            }
            object = this.worker;
            long l10 = this.timeout;
            TimeUnit timeUnit = this.unit;
            object = ((h0$c)object).c(this, l10, timeUnit);
            DisposableHelper.replace(this, (b)object);
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void run() {
        this.gate = false;
    }
}


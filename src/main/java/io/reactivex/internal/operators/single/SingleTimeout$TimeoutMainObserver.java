/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout$TimeoutMainObserver
extends AtomicReference
implements l0,
Runnable,
b {
    private static final long serialVersionUID = 37497744973048446L;
    public final l0 downstream;
    public final SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver fallback;
    public o0 other;
    public final AtomicReference task;
    public final long timeout;
    public final TimeUnit unit;

    public SingleTimeout$TimeoutMainObserver(l0 l02, o0 object, long l10, TimeUnit timeUnit) {
        AtomicReference atomicReference;
        this.downstream = l02;
        this.other = object;
        this.timeout = l10;
        this.unit = timeUnit;
        this.task = atomicReference = new AtomicReference();
        if (object != null) {
            this.fallback = object = new SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver(l02);
        } else {
            l02 = null;
            this.fallback = null;
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver singleTimeout$TimeoutMainObserver$TimeoutFallbackObserver = this.fallback;
        if (singleTimeout$TimeoutMainObserver$TimeoutFallbackObserver != null) {
            DisposableHelper.dispose(singleTimeout$TimeoutMainObserver$TimeoutFallbackObserver);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onError(Throwable throwable) {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object object = (b)this.get();
        if (object != (disposableHelper = DisposableHelper.DISPOSED) && (bl2 = this.compareAndSet(object, disposableHelper))) {
            DisposableHelper.dispose(this.task);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object object2 = (b)this.get();
        if (object2 != (disposableHelper = DisposableHelper.DISPOSED) && (bl2 = this.compareAndSet(object2, disposableHelper))) {
            DisposableHelper.dispose(this.task);
            object2 = this.downstream;
            object2.onSuccess(object);
        }
    }

    public void run() {
        boolean bl2;
        Object object;
        Object object2 = (b)this.get();
        if (object2 != (object = DisposableHelper.DISPOSED) && (bl2 = this.compareAndSet(object2, object))) {
            if (object2 != null) {
                object2.dispose();
            }
            if ((object2 = this.other) == null) {
                object2 = this.downstream;
                long l10 = this.timeout;
                TimeUnit timeUnit = this.unit;
                String string2 = ExceptionHelper.e(l10, timeUnit);
                object = new TimeoutException(string2);
                object2.onError((Throwable)object);
            } else {
                bl2 = false;
                this.other = null;
                object = this.fallback;
                object2.f((l0)object);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDoFinally$DoFinallyObserver
extends AtomicInteger
implements l0,
b {
    private static final long serialVersionUID = 4109457741734051389L;
    public final l0 downstream;
    public final a onFinally;
    public b upstream;

    public SingleDoFinally$DoFinallyObserver(l0 l02, a a10) {
        this.downstream = l02;
        this.onFinally = a10;
    }

    public void dispose() {
        this.upstream.dispose();
        this.runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
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

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
        this.runFinally();
    }

    public void runFinally() {
        a a10 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            a10 = this.onFinally;
            try {
                a10.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose$DoOnDisposeObserver
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = -8583764624474935784L;
    public final l0 downstream;
    public b upstream;

    public SingleDoOnDispose$DoOnDisposeObserver(l0 l02, a a10) {
        this.downstream = l02;
        this.lazySet(a10);
    }

    public void dispose() {
        Object object = this.getAndSet(null);
        if (object != null) {
            try {
                object.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
            object = this.upstream;
            object.dispose();
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
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
    }
}


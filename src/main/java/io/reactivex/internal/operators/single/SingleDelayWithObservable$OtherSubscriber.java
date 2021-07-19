/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.d.o;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable$OtherSubscriber
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -8565274649390031272L;
    public boolean done;
    public final l0 downstream;
    public final o0 source;

    public SingleDelayWithObservable$OtherSubscriber(l0 l02, o0 o02) {
        this.downstream = l02;
        this.source = o02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        o0 o02 = this.source;
        l0 l02 = this.downstream;
        o o10 = new o(this, l02);
        o02.f(o10);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        ((b)this.get()).dispose();
        this.onComplete();
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.set(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}


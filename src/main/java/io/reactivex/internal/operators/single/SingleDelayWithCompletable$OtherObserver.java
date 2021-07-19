/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.d;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.d.o;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithCompletable$OtherObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = -8565274649390031272L;
    public final l0 downstream;
    public final o0 source;

    public SingleDelayWithCompletable$OtherObserver(l0 l02, o0 o02) {
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
        o0 o02 = this.source;
        l0 l02 = this.downstream;
        o o10 = new o(this, l02);
        o02.f(o10);
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
}


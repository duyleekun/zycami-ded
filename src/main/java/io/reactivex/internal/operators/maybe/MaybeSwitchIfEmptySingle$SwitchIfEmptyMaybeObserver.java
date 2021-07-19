/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 4603919676453758899L;
    public final l0 downstream;
    public final o0 other;

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(l0 l02, o0 o02) {
        this.downstream = l02;
        this.other = o02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object;
        Object object2 = (b)this.get();
        if (object2 != (object = DisposableHelper.DISPOSED)) {
            object = null;
            boolean bl2 = this.compareAndSet(object2, null);
            if (bl2) {
                object2 = this.other;
                l0 l02 = this.downstream;
                object = new MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$a(l02, this);
                object2.f((l0)object);
            }
        }
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

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }
}


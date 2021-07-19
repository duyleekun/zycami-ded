/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -2223459372976438024L;
    public final t downstream;
    public final w other;

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(t t10, w w10) {
        this.downstream = t10;
        this.other = w10;
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
                t t10 = this.downstream;
                object = new MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver$a(t10, this);
                object2.g((t)object);
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


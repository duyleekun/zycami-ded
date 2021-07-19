/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.d;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable$OtherObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = 703409937383992161L;
    public final t downstream;
    public final w source;

    public MaybeDelayWithCompletable$OtherObserver(t t10, w w10) {
        this.downstream = t10;
        this.source = w10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        w w10 = this.source;
        t t10 = this.downstream;
        MaybeDelayWithCompletable$a maybeDelayWithCompletable$a = new MaybeDelayWithCompletable$a(this, t10);
        w10.g(maybeDelayWithCompletable$a);
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


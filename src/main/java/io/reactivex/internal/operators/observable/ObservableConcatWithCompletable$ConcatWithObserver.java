/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable$ConcatWithObserver
extends AtomicReference
implements g0,
d,
b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final g0 downstream;
    public boolean inCompletable;
    public g other;

    public ObservableConcatWithCompletable$ConcatWithObserver(g0 g02, g g10) {
        this.downstream = g02;
        this.other = g10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.inCompletable;
        if (bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        } else {
            this.inCompletable = true;
            bl2 = false;
            Object var2_3 = null;
            DisposableHelper.replace(this, null);
            g g10 = this.other;
            this.other = null;
            g10.f(this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2 && !(bl2 = this.inCompletable)) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}


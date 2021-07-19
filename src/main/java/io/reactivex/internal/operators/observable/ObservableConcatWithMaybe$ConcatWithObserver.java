/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe$ConcatWithObserver
extends AtomicReference
implements g0,
t,
b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final g0 downstream;
    public boolean inMaybe;
    public w other;

    public ObservableConcatWithMaybe$ConcatWithObserver(g0 g02, w w10) {
        this.downstream = g02;
        this.other = w10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.inMaybe;
        if (bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        } else {
            this.inMaybe = true;
            bl2 = false;
            Object var2_3 = null;
            DisposableHelper.replace(this, null);
            w w10 = this.other;
            this.other = null;
            w10.g(this);
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
        if (bl2 && !(bl2 = this.inMaybe)) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.downstream.onNext(object);
        this.downstream.onComplete();
    }
}


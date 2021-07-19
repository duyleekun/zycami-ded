/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle$ConcatWithObserver
extends AtomicReference
implements g0,
l0,
b {
    private static final long serialVersionUID = -1953724749712440952L;
    public final g0 downstream;
    public boolean inSingle;
    public o0 other;

    public ObservableConcatWithSingle$ConcatWithObserver(g0 g02, o0 o02) {
        this.downstream = g02;
        this.other = o02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.inSingle = true;
        DisposableHelper.replace(this, null);
        o0 o02 = this.other;
        this.other = null;
        o02.f(this);
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2 && !(bl2 = this.inSingle)) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.downstream.onNext(object);
        this.downstream.onComplete();
    }
}


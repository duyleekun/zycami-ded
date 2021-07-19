/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.e0;
import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapObservable$FlatMapObserver
extends AtomicReference
implements g0,
l0,
b {
    private static final long serialVersionUID = -8948264376121066672L;
    public final g0 downstream;
    public final o mapper;

    public SingleFlatMapObservable$FlatMapObserver(g0 g02, o o10) {
        this.downstream = g02;
        this.mapper = o10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null Publisher";
        object = a.g(object, (String)object2);
        ((e0)object).subscribe(this);
    }
}


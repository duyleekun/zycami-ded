/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = -2897979525538174559L;
    public final t downstream;
    public final c resultSelector;
    public Object value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(t t10, c c10) {
        this.downstream = t10;
        this.resultSelector = c10;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        Object object2 = this.value;
        c c10 = null;
        this.value = null;
        try {
            c10 = this.resultSelector;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        object = c10.apply(object2, object);
        object2 = "The resultSelector returned a null value";
        object = a.g(object, (String)object2);
        this.downstream.onSuccess(object);
    }
}


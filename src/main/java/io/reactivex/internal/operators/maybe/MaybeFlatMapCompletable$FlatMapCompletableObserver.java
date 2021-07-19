/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable$FlatMapCompletableObserver
extends AtomicReference
implements t,
d,
b {
    private static final long serialVersionUID = -2177128922851101253L;
    public final d downstream;
    public final o mapper;

    public MaybeFlatMapCompletable$FlatMapCompletableObserver(d d10, o o10) {
        this.downstream = d10;
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
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null CompletableSource";
        object = a.g(object, (String)object2);
        object = (g)object;
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            object.f(this);
        }
    }
}


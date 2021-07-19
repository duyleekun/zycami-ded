/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingleElement$FlatMapMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 4827726964688405508L;
    public final t downstream;
    public final o mapper;

    public MaybeFlatMapSingleElement$FlatMapMaybeObserver(t t10, o o10) {
        this.downstream = t10;
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

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
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
        object2 = "The mapper returned a null SingleSource";
        object = a.g(object, (String)object2);
        object = (o0)object;
        t t10 = this.downstream;
        object2 = new MaybeFlatMapSingleElement$a(this, t10);
        object.f((l0)object2);
    }
}


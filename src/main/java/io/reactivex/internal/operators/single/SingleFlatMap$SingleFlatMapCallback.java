/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleFlatMap$SingleFlatMapCallback$a;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap$SingleFlatMapCallback
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = 3258103020495908596L;
    public final l0 downstream;
    public final o mapper;

    public SingleFlatMap$SingleFlatMapCallback(l0 l02, o o10) {
        this.downstream = l02;
        this.mapper = o10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
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
            this.downstream.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The single returned by the mapper is null";
        object = a.g(object, (String)object2);
        object = (o0)object;
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            l0 l02 = this.downstream;
            object2 = new SingleFlatMap$SingleFlatMapCallback$a(this, l02);
            object.f((l0)object2);
        }
    }
}


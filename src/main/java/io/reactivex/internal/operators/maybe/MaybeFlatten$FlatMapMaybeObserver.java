/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten$FlatMapMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 4375739915521278546L;
    public final t downstream;
    public final o mapper;
    public b upstream;

    public MaybeFlatten$FlatMapMaybeObserver(t t10, o o10) {
        this.downstream = t10;
        this.mapper = o10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
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
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Exception exception) {
            e.a.t0.a.b(exception);
            this.downstream.onError(exception);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null MaybeSource";
        object = a.g(object, (String)object2);
        object = (w)object;
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            object2 = new MaybeFlatten$FlatMapMaybeObserver$a(this);
            object.g((t)object2);
        }
    }
}


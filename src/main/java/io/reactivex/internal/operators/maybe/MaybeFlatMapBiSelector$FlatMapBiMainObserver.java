/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.v0.c;
import e.a.v0.o;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector$FlatMapBiMainObserver
implements t,
b {
    public final o a;
    public final MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver b;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver(t t10, o o10, c c10) {
        MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver maybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver;
        this.b = maybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver = new MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(t10, c10);
        this.a = o10;
    }

    public void dispose() {
        DisposableHelper.dispose(this.b);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.b.get());
    }

    public void onComplete() {
        this.b.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.downstream.onError(throwable);
    }

    public void onSubscribe(b object) {
        MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver maybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver = this.b;
        boolean bl2 = DisposableHelper.setOnce(maybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver, (b)object);
        if (bl2) {
            object = this.b.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.b.downstream.onError(throwable);
            return;
        }
        object2 = object2.apply(object);
        Object object3 = "The mapper returned a null MaybeSource";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (w)object2;
        object3 = this.b;
        boolean bl2 = DisposableHelper.replace((AtomicReference)object3, null);
        if (bl2) {
            object3 = this.b;
            ((MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver)object3).value = object;
            object2.g((t)object3);
        }
    }
}


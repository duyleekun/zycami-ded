/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.d.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext$ResumeMainSingleObserver
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = -5314538511045349925L;
    public final l0 downstream;
    public final e.a.v0.o nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(l0 l02, e.a.v0.o o10) {
        this.downstream = l02;
        this.nextFunction = o10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        try {
            object3 = this.nextFunction;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.downstream;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            object2.onError(compositeException);
            return;
        }
        object3 = object3.apply(object);
        object2 = "The nextFunction returned a null SingleSource.";
        object3 = a.g(object3, (String)object2);
        object3 = (o0)object3;
        object2 = this.downstream;
        object = new o(this, (l0)object2);
        object3.f((l0)object);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }
}


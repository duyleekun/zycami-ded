/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext$ResumeNextObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = 5018523762564524046L;
    public final d downstream;
    public final o errorMapper;
    public boolean once;

    public CompletableResumeNext$ResumeNextObserver(d d10, o o10) {
        this.downstream = d10;
        this.errorMapper = o10;
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
        Object object;
        Object object2;
        int n10 = (int)(this.once ? 1 : 0);
        if (n10 != 0) {
            this.downstream.onError(throwable);
            return;
        }
        n10 = 1;
        this.once = n10;
        try {
            object2 = this.errorMapper;
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            object = this.downstream;
            Throwable[] throwableArray = new Throwable[2];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            object.onError(compositeException);
            return;
        }
        object2 = object2.apply(throwable);
        object = "The errorMapper returned a null CompletableSource";
        object2 = a.g(object2, (String)object);
        ((g)object2).f(this);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }
}


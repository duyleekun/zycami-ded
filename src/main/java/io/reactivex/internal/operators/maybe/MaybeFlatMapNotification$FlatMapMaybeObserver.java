/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification$FlatMapMaybeObserver$a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification$FlatMapMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 4375739915521278546L;
    public final t downstream;
    public final Callable onCompleteSupplier;
    public final o onErrorMapper;
    public final o onSuccessMapper;
    public b upstream;

    public MaybeFlatMapNotification$FlatMapMaybeObserver(t t10, o o10, o o11, Callable callable) {
        this.downstream = t10;
        this.onSuccessMapper = o10;
        this.onErrorMapper = o11;
        this.onCompleteSupplier = callable;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object;
        try {
            object = this.onCompleteSupplier;
        }
        catch (Exception exception) {
            e.a.t0.a.b(exception);
            this.downstream.onError(exception);
            return;
        }
        object = object.call();
        Object object2 = "The onCompleteSupplier returned a null MaybeSource";
        object = a.g(object, (String)object2);
        object = (w)object;
        object2 = new MaybeFlatMapNotification$FlatMapMaybeObserver$a(this);
        object.g((t)object2);
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        try {
            object3 = this.onErrorMapper;
        }
        catch (Exception exception) {
            e.a.t0.a.b(exception);
            object2 = this.downstream;
            Throwable[] throwableArray = new Throwable[]{object, exception};
            CompositeException compositeException = new CompositeException(throwableArray);
            object2.onError(compositeException);
            return;
        }
        object3 = object3.apply(object);
        object2 = "The onErrorMapper returned a null MaybeSource";
        object3 = a.g(object3, (String)object2);
        object3 = (w)object3;
        object = new MaybeFlatMapNotification$FlatMapMaybeObserver$a(this);
        object3.g((t)object);
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
            object2 = this.onSuccessMapper;
        }
        catch (Exception exception) {
            e.a.t0.a.b(exception);
            this.downstream.onError(exception);
            return;
        }
        object = object2.apply(object);
        object2 = "The onSuccessMapper returned a null MaybeSource";
        object = a.g(object, (String)object2);
        object = (w)object;
        object2 = new MaybeFlatMapNotification$FlatMapMaybeObserver$a(this);
        object.g((t)object2);
    }
}


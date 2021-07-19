/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

public final class y0$a
implements g0,
b {
    public final g0 a;
    public final o b;
    public final o c;
    public final Callable d;
    public b e;

    public y0$a(g0 g02, o o10, o o11, Callable callable) {
        this.a = g02;
        this.b = o10;
        this.c = o11;
        this.d = callable;
    }

    public void dispose() {
        this.e.dispose();
    }

    public boolean isDisposed() {
        return this.e.isDisposed();
    }

    public void onComplete() {
        Object object;
        try {
            object = this.d;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object = object.call();
        String string2 = "The onComplete ObservableSource returned is null";
        object = e.a.w0.b.a.g(object, string2);
        object = (e0)object;
        this.a.onNext(object);
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        Object object2;
        try {
            object2 = this.c;
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            object = this.a;
            Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
            CompositeException compositeException = new CompositeException(throwableArray);
            object.onError(compositeException);
            return;
        }
        object2 = object2.apply(throwable);
        object = "The onError ObservableSource returned is null";
        object2 = e.a.w0.b.a.g(object2, (String)object);
        object2 = (e0)object2;
        this.a.onNext(object2);
        this.a.onComplete();
    }

    public void onNext(Object object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The onNext ObservableSource returned is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (e0)object;
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.e;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}


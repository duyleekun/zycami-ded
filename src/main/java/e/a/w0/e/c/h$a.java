/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.t;
import e.a.t0.a;
import e.a.v0.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

public final class h$a
implements t,
e.a.s0.b {
    public final t a;
    public final b b;
    public e.a.s0.b c;

    public h$a(t t10, b b10) {
        this.a = t10;
        this.b = b10;
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.c = object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object.accept(null, null);
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object = DisposableHelper.DISPOSED;
        this.c = object;
        object = this.b;
        CompositeException compositeException = null;
        try {
            object.accept(null, throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            compositeException = new CompositeException(throwableArray);
            throwable = compositeException;
        }
        this.a.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b object) {
        e.a.s0.b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (e.a.s0.b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        Object object2 = DisposableHelper.DISPOSED;
        this.c = object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object2.accept(object, null);
        this.a.onSuccess(object);
    }
}


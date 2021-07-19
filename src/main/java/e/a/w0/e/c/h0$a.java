/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.w0.e.c.h0;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class h0$a
implements t,
b {
    public final t a;
    public final h0 b;
    public b c;

    public h0$a(t t10, h0 h02) {
        this.a = t10;
        this.b = h02;
    }

    public void a() {
        Object object = this.b;
        object = ((h0)object).f;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void b(Throwable throwable) {
        Object object = this.b;
        object = ((h0)object).d;
        try {
            object.accept(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            throwable = compositeException;
        }
        this.c = object = DisposableHelper.DISPOSED;
        this.a.onError(throwable);
        this.a();
    }

    public void dispose() {
        Object object = this.b;
        object = ((h0)object).g;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
        this.c.dispose();
        this.c = object = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        Object object = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (object == disposableHelper) {
            return;
        }
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.b(throwable);
            return;
        }
        object = ((h0)object).e;
        object.run();
        this.c = disposableHelper;
        this.a.onComplete();
        this.a();
    }

    public void onError(Throwable throwable) {
        b b10 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 == disposableHelper) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.b(throwable);
    }

    public void onSubscribe(b object) {
        Object object2 = this.c;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            object2 = this.b;
            object2 = ((h0)object2).b;
            try {
                object2.accept(object);
                this.c = object;
                object = this.a;
                object.onSubscribe(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object.dispose();
                object = DisposableHelper.DISPOSED;
                this.c = object;
                object = this.a;
                EmptyDisposable.error(throwable, (t)object);
            }
        }
    }

    public void onSuccess(Object object) {
        Object object2 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (object2 == disposableHelper) {
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.b(throwable);
            return;
        }
        object2 = ((h0)object2).c;
        object2.accept(object);
        this.c = disposableHelper;
        this.a.onSuccess(object);
        this.a();
    }
}


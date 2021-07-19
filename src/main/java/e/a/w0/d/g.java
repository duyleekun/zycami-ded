/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class g
implements g0,
b {
    public final g0 a;
    public final e.a.v0.g b;
    public final a c;
    public b d;

    public g(g0 g02, e.a.v0.g g10, a a10) {
        this.a = g02;
        this.b = g10;
        this.c = a10;
    }

    public void dispose() {
        b b10 = this.d;
        Object object = DisposableHelper.DISPOSED;
        if (b10 != object) {
            this.d = object;
            object = this.c;
            try {
                object.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
            b10.dispose();
        }
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        Object object = this.d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (object != disposableHelper) {
            this.d = disposableHelper;
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (object != disposableHelper) {
            this.d = disposableHelper;
            object = this.a;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object.dispose();
            object = DisposableHelper.DISPOSED;
            this.d = object;
            object = this.a;
            EmptyDisposable.error(throwable, (g0)object);
            return;
        }
        object2.accept(object);
        object2 = this.d;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}


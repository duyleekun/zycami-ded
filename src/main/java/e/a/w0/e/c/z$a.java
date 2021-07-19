/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class z$a
implements t,
b {
    public final l0 a;
    public b b;

    public z$a(l0 l02) {
        this.a = l02;
    }

    public void dispose() {
        this.b.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.b = object;
        object = this.a;
        Boolean bl2 = Boolean.TRUE;
        object.onSuccess(bl2);
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
        this.a.onError(throwable);
    }

    public void onSubscribe(b object) {
        b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.b = object = DisposableHelper.DISPOSED;
        object = this.a;
        Boolean bl2 = Boolean.FALSE;
        object.onSuccess(bl2);
    }
}


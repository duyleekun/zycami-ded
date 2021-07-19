/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class u$a
implements l0,
b {
    public final t a;
    public b b;

    public u$a(t t10) {
        this.a = t10;
    }

    public void dispose() {
        this.b.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
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
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
        this.a.onSuccess(object);
    }
}


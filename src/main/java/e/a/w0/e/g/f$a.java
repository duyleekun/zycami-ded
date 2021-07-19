/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class f$a
implements l0,
b {
    public l0 a;
    public b b;

    public f$a(l0 l02) {
        this.a = l02;
    }

    public void dispose() {
        this.a = null;
        this.b.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onError(Throwable throwable) {
        Object object = DisposableHelper.DISPOSED;
        this.b = object;
        object = this.a;
        if (object != null) {
            this.a = null;
            object.onError(throwable);
        }
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
        Object object2 = DisposableHelper.DISPOSED;
        this.b = object2;
        object2 = this.a;
        if (object2 != null) {
            this.a = null;
            object2.onSuccess(object);
        }
    }
}


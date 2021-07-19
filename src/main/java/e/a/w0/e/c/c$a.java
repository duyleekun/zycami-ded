/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class c$a
implements t,
b {
    public final l0 a;
    public final Object b;
    public b c;

    public c$a(l0 l02, Object object) {
        this.a = l02;
        this.b = object;
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
        object = this.a;
        Boolean bl2 = Boolean.FALSE;
        object.onSuccess(bl2);
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.onError(throwable);
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        Object object2 = DisposableHelper.DISPOSED;
        this.c = object2;
        object2 = this.a;
        Object object3 = this.b;
        object = e.a.w0.b.a.c(object, object3);
        object2.onSuccess(object);
    }
}


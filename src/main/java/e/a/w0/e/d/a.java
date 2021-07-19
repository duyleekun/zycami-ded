/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.d;

import e.a.d;
import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.y;
import io.reactivex.internal.disposables.DisposableHelper;

public final class a
implements l0,
t,
d,
b {
    public final l0 a;
    public b b;

    public a(l0 l02) {
        this.a = l02;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        l0 l02 = this.a;
        y y10 = y.a();
        l02.onSuccess(y10);
    }

    public void onError(Throwable object) {
        l0 l02 = this.a;
        object = y.b((Throwable)object);
        l02.onSuccess(object);
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
        l0 l02 = this.a;
        object = y.c(object);
        l02.onSuccess(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class u0$a
implements g0,
b {
    public final t a;
    public b b;
    public Object c;

    public u0$a(t t10) {
        this.a = t10;
    }

    public void dispose() {
        this.b.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
    }

    public boolean isDisposed() {
        boolean bl2;
        b b10 = this.b;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 == disposableHelper) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.b = object;
        object = this.c;
        if (object != null) {
            this.c = null;
            t t10 = this.a;
            t10.onSuccess(object);
        } else {
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
        this.c = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.c = object;
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
}


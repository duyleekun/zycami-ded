/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class y$a
implements t,
b {
    public final t a;
    public b b;

    public y$a(t t10) {
        this.a = t10;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        t t10 = this.a;
        Boolean bl2 = Boolean.TRUE;
        t10.onSuccess(bl2);
    }

    public void onError(Throwable throwable) {
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
        object = this.a;
        Boolean bl2 = Boolean.FALSE;
        object.onSuccess(bl2);
    }
}


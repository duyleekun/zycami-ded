/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.t0.a;
import e.a.v0.r;
import io.reactivex.internal.disposables.DisposableHelper;

public final class n$a
implements l0,
b {
    public final t a;
    public final r b;
    public b c;

    public n$a(t t10, r r10) {
        this.a = t10;
        this.b = r10;
    }

    public void dispose() {
        b b10 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        b10.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onError(Throwable throwable) {
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
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        boolean bl2 = object2.test(object);
        if (bl2) {
            object2 = this.a;
            object2.onSuccess(object);
        } else {
            object = this.a;
            object.onComplete();
        }
    }
}


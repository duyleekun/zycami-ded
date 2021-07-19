/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class c0$a
implements t,
b {
    public final t a;
    public final o b;
    public b c;

    public c0$a(t t10, o o10) {
        this.a = t10;
        this.b = o10;
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

    public void onComplete() {
        this.a.onComplete();
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
        object = object2.apply(object);
        object2 = "The mapper returned a null item";
        object = e.a.w0.b.a.g(object, (String)object2);
        this.a.onSuccess(object);
    }
}


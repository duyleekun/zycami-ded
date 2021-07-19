/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.y;
import io.reactivex.internal.disposables.DisposableHelper;

public final class z0$a
implements g0,
b {
    public final g0 a;
    public b b;

    public z0$a(g0 g02) {
        this.a = g02;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        y y10 = y.a();
        this.a.onNext(y10);
        this.a.onComplete();
    }

    public void onError(Throwable object) {
        object = y.b((Throwable)object);
        this.a.onNext(object);
        this.a.onComplete();
    }

    public void onNext(Object object) {
        g0 g02 = this.a;
        object = y.c(object);
        g02.onNext(object);
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


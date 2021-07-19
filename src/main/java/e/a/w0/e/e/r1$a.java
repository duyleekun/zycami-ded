/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class r1$a
implements g0,
b {
    public final g0 a;
    public b b;
    public Object c;

    public r1$a(g0 g02) {
        this.a = g02;
    }

    public void a() {
        Object object = this.c;
        if (object != null) {
            this.c = null;
            g0 g02 = this.a;
            g02.onNext(object);
        }
        this.a.onComplete();
    }

    public void dispose() {
        this.c = null;
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        this.a();
    }

    public void onError(Throwable throwable) {
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


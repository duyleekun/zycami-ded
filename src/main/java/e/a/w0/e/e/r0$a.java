/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;

public final class r0$a
implements g0,
b {
    public final g0 a;
    public b b;

    public r0$a(g0 g02) {
        this.a = g02;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(b b10) {
        this.b = b10;
        this.a.onSubscribe(this);
    }
}


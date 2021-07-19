/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.g0;
import e.a.s0.b;

public final class k$a
implements g0 {
    public final d a;

    public k$a(d d10) {
        this.a = d10;
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
        this.a.onSubscribe(b10);
    }
}


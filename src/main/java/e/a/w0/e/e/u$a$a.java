/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.u$a;

public final class u$a$a
implements g0 {
    public final /* synthetic */ u$a a;

    public u$a$a(u$a a10) {
        this.a = a10;
    }

    public void onComplete() {
        this.a.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.b.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.b.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.a.a.update(b10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.g0;
import e.a.s0.b;
import i.g.d;
import i.g.e;

public final class g0$a
implements g0,
e {
    public final d a;
    public b b;

    public g0$a(d d10) {
        this.a = d10;
    }

    public void cancel() {
        this.b.dispose();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.b = b10;
        this.a.onSubscribe(this);
    }

    public void request(long l10) {
    }
}


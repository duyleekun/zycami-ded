/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.l0;
import e.a.s0.b;

public final class n$a
implements l0 {
    public final d a;

    public n$a(d d10) {
        this.a = d10;
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }

    public void onSuccess(Object object) {
        this.a.onComplete();
    }
}


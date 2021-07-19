/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.e.e.l$b;
import e.a.y0.d;

public final class l$a
extends d {
    public final l$b b;

    public l$a(l$b b10) {
        this.b = b10;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        this.b.k();
    }
}


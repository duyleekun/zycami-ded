/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.e.e.x1$c;
import e.a.y0.d;

public final class x1$b
extends d {
    public final x1$c b;

    public x1$b(x1$c x1$c) {
        this.b = x1$c;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.m(throwable);
    }

    public void onNext(Object object) {
        this.b.o(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import e.a.b0;
import e.a.y0.e;

public final class o$c
extends e {
    public final /* synthetic */ b0 b;

    public o$c(b0 b02) {
        this.b = b02;
    }

    public void onError(Throwable throwable) {
        this.b.tryOnError(throwable);
    }

    public void onSuccess(Object object) {
        this.b.onNext(object);
        this.b.onComplete();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import e.a.b0;
import e.a.y0.d;

public final class o$b
extends d {
    public final /* synthetic */ b0 b;

    public o$b(b0 b02) {
        this.b = b02;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.tryOnError(throwable);
    }

    public void onNext(Object object) {
        this.b.onNext(object);
    }
}


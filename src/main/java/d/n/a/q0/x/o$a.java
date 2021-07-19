/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import e.a.k0;
import e.a.y0.e;

public final class o$a
extends e {
    public final /* synthetic */ k0 b;

    public o$a(k0 k02) {
        this.b = k02;
    }

    public void onError(Throwable throwable) {
        this.b.tryOnError(throwable);
    }

    public void onSuccess(Object object) {
        this.b.onSuccess(object);
    }
}


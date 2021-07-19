/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.s0.b;
import e.a.s0.c;
import e.a.t;

public final class k
extends q {
    public final Throwable a;

    public k(Throwable throwable) {
        this.a = throwable;
    }

    public void t1(t t10) {
        Object object = c.a();
        t10.onSubscribe((b)object);
        object = this.a;
        t10.onError((Throwable)object);
    }
}


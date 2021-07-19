/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.s0.b;
import e.a.s0.c;
import e.a.t;
import e.a.w0.c.m;

public final class a0
extends q
implements m {
    public final Object a;

    public a0(Object object) {
        this.a = object;
    }

    public Object call() {
        return this.a;
    }

    public void t1(t t10) {
        Object object = c.a();
        t10.onSubscribe((b)object);
        object = this.a;
        t10.onSuccess(object);
    }
}


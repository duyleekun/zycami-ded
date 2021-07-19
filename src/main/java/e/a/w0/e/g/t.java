/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.s0.b;
import e.a.s0.c;

public final class t
extends i0 {
    public final Object a;

    public t(Object object) {
        this.a = object;
    }

    public void e1(l0 l02) {
        Object object = c.a();
        l02.onSubscribe((b)object);
        object = this.a;
        l02.onSuccess(object);
    }
}


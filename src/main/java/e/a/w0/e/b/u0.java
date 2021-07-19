/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.i0;
import e.a.l0;
import e.a.w0.e.b.u0$a;
import i.g.c;

public final class u0
extends i0 {
    public final c a;
    public final Object b;
    public final e.a.v0.c c;

    public u0(c c10, Object object, e.a.v0.c c11) {
        this.a = c10;
        this.b = object;
        this.c = c11;
    }

    public void e1(l0 l02) {
        c c10 = this.a;
        e.a.v0.c c11 = this.c;
        Object object = this.b;
        u0$a u0$a = new u0$a(l02, c11, object);
        c10.subscribe(u0$a);
    }
}


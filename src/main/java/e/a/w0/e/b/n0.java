/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.i0;
import e.a.l0;
import e.a.w0.e.b.n0$a;
import i.g.c;

public final class n0
extends i0 {
    public final c a;
    public final Object b;

    public n0(c c10, Object object) {
        this.a = c10;
        this.b = object;
    }

    public void e1(l0 l02) {
        c c10 = this.a;
        Object object = this.b;
        n0$a n0$a = new n0$a(l02, object);
        c10.subscribe(n0$a);
    }
}


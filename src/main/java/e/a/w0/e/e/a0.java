/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.g;
import e.a.w0.e.e.a;
import e.a.w0.e.e.a0$a;

public final class a0
extends a {
    public final g b;
    public final g c;
    public final e.a.v0.a d;
    public final e.a.v0.a e;

    public a0(e0 e02, g g10, g g11, e.a.v0.a a10, e.a.v0.a a11) {
        super(e02);
        this.b = g10;
        this.c = g11;
        this.d = a10;
        this.e = a11;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        g g10 = this.b;
        g g11 = this.c;
        e.a.v0.a a10 = this.d;
        e.a.v0.a a11 = this.e;
        a0$a a0$a = new a0$a(g02, g10, g11, a10, a11);
        e02.subscribe(a0$a);
    }
}


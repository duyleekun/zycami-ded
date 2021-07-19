/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.x1$c;
import e.a.y0.l;

public final class x1
extends a {
    public final e0 b;
    public final o c;
    public final int d;

    public x1(e0 e02, e0 e03, o o10, int n10) {
        super(e02);
        this.b = e03;
        this.c = o10;
        this.d = n10;
    }

    public void K5(g0 object) {
        e0 e02 = this.a;
        l l10 = new l((g0)object);
        object = this.b;
        o o10 = this.c;
        int n10 = this.d;
        x1$c x1$c = new x1$c(l10, (e0)object, o10, n10);
        e02.subscribe(x1$c);
    }
}


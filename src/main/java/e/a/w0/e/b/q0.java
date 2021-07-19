/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.p0$b;
import i.g.c;
import i.g.d;

public final class q0
extends j {
    public final c b;
    public final o c;

    public q0(c c10, o o10) {
        this.b = c10;
        this.c = o10;
    }

    public void m6(d d10) {
        c c10 = this.b;
        o o10 = this.c;
        p0$b p0$b = new p0$b(d10, o10);
        c10.subscribe(p0$b);
    }
}


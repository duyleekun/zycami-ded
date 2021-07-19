/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.w0.e.e.p1$a;

public final class p1
extends a {
    public final e0 b;

    public p1(e0 e02, e0 e03) {
        super(e02);
        this.b = e03;
    }

    public void K5(g0 g02) {
        Object object = this.b;
        p1$a p1$a = new p1$a(g02, (e0)object);
        object = p1$a.c;
        g02.onSubscribe((b)object);
        this.a.subscribe(p1$a);
    }
}


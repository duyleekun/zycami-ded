/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.e.b.a;
import e.a.w0.e.b.d1$a;
import i.g.c;
import i.g.d;
import i.g.e;

public final class d1
extends a {
    public final c c;

    public d1(j j10, c c10) {
        super(j10);
        this.c = c10;
    }

    public void m6(d d10) {
        Object object = this.c;
        d1$a d1$a = new d1$a(d10, (c)object);
        object = d1$a.c;
        d10.onSubscribe((e)object);
        this.b.l6(d1$a);
    }
}


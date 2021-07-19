/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.b1$a;

public final class b1
extends a {
    public final o b;
    public final boolean c;

    public b1(e0 e02, o o10, boolean bl2) {
        super(e02);
        this.b = o10;
        this.c = bl2;
    }

    public void K5(g0 g02) {
        Object object = this.b;
        boolean bl2 = this.c;
        b1$a b1$a = new b1$a(g02, (o)object, bl2);
        object = b1$a.d;
        g02.onSubscribe((b)object);
        this.a.subscribe(b1$a);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import d.k.a.a$a;
import d.k.a.a$e;
import e.a.j;
import i.g.d;

public final class a$b
extends j {
    private final j b;
    private final a$a c;

    public a$b(j j10, a$a a$a) {
        this.b = j10;
        this.c = a$a;
    }

    public void m6(d d10) {
        j j10 = this.b;
        a$a a$a = this.c;
        a$e a$e = new a$e(d10, a$a);
        j10.subscribe(a$e);
    }
}


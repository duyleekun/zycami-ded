/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.u0.a;
import i.g.d;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
extends j {
    public final a b;
    public final int c;
    public final e.a.v0.g d;
    public final AtomicInteger e;

    public g(a object, int n10, e.a.v0.g g10) {
        this.b = object;
        this.c = n10;
        this.d = g10;
        this.e = object = new AtomicInteger();
    }

    public void m6(d object) {
        Object object2 = this.b;
        ((j)object2).subscribe((d)object);
        object = this.e;
        int n10 = ((AtomicInteger)object).incrementAndGet();
        int n11 = this.c;
        if (n10 == n11) {
            object = this.b;
            object2 = this.d;
            ((a)object).O8((e.a.v0.g)object2);
        }
    }
}


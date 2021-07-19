/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.o;
import e.a.w0.e.f.g$a;
import e.a.w0.e.f.g$b;
import e.a.z0.a;
import i.g.d;
import i.g.e;

public final class g
extends a {
    public final a a;
    public final o b;

    public g(a a10, o o10) {
        this.a = a10;
        this.b = o10;
    }

    public int G() {
        return this.a.G();
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        d[] dArray2 = new d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            e e10;
            o o10;
            d d10 = dArray[i10];
            boolean bl2 = d10 instanceof e.a.w0.c.a;
            if (bl2) {
                d10 = (e.a.w0.c.a)d10;
                o10 = this.b;
                e10 = new g$a((e.a.w0.c.a)d10, o10);
                dArray2[i10] = e10;
                continue;
            }
            o10 = this.b;
            e10 = new g$b(d10, o10);
            dArray2[i10] = e10;
        }
        this.a.a(dArray2);
    }
}


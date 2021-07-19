/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.r;
import e.a.w0.e.f.c$a;
import e.a.w0.e.f.c$b;
import e.a.w0.e.f.c$c;
import e.a.z0.a;
import i.g.d;

public final class c
extends a {
    public final a a;
    public final r b;

    public c(a a10, r r10) {
        this.a = a10;
        this.b = r10;
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
            c$a c$a;
            r r10;
            d d10 = dArray[i10];
            boolean bl2 = d10 instanceof e.a.w0.c.a;
            if (bl2) {
                d10 = (e.a.w0.c.a)d10;
                r10 = this.b;
                c$a = new c$b((e.a.w0.c.a)d10, r10);
                dArray2[i10] = c$a;
                continue;
            }
            r10 = this.b;
            c$a = new c$c(d10, r10);
            dArray2[i10] = c$a;
        }
        this.a.a(dArray2);
    }
}


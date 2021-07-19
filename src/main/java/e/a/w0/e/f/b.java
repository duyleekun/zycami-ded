/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.c;
import e.a.v0.g;
import e.a.w0.e.f.b$b;
import e.a.w0.e.f.b$c;
import e.a.z0.a;
import i.g.d;
import i.g.e;

public final class b
extends a {
    public final a a;
    public final g b;
    public final c c;

    public b(a a10, g g10, c c10) {
        this.a = a10;
        this.b = g10;
        this.c = c10;
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
            c c10;
            g g10;
            d d10 = dArray[i10];
            boolean bl2 = d10 instanceof e.a.w0.c.a;
            if (bl2) {
                d10 = (e.a.w0.c.a)d10;
                g10 = this.b;
                c10 = this.c;
                e10 = new b$b((e.a.w0.c.a)d10, g10, c10);
                dArray2[i10] = e10;
                continue;
            }
            g10 = this.b;
            c10 = this.c;
            e10 = new b$c(d10, g10, c10);
            dArray2[i10] = e10;
        }
        this.a.a(dArray2);
    }
}


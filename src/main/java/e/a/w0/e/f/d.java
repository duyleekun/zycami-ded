/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.c;
import e.a.v0.r;
import e.a.w0.e.f.d$b;
import e.a.w0.e.f.d$c;
import e.a.w0.e.f.d$d;
import e.a.z0.a;

public final class d
extends a {
    public final a a;
    public final r b;
    public final c c;

    public d(a a10, r r10, c c10) {
        this.a = a10;
        this.b = r10;
        this.c = c10;
    }

    public int G() {
        return this.a.G();
    }

    public void a(i.g.d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        i.g.d[] dArray2 = new i.g.d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            d$b d$b;
            c c10;
            r r10;
            i.g.d d10 = dArray[i10];
            boolean bl2 = d10 instanceof e.a.w0.c.a;
            if (bl2) {
                d10 = (e.a.w0.c.a)d10;
                r10 = this.b;
                c10 = this.c;
                d$b = new d$c((e.a.w0.c.a)d10, r10, c10);
                dArray2[i10] = d$b;
                continue;
            }
            r10 = this.b;
            c10 = this.c;
            d$b = new d$d(d10, r10, c10);
            dArray2[i10] = d$b;
        }
        this.a.a(dArray2);
    }
}


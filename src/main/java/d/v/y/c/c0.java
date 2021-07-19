/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.p;
import d.v.y.c.s1.a;
import d.v.y.c.s1.b;
import d.v.y.c.s1.g.d;

public class c0
extends p {
    public c0(a a10) {
        d d10 = new d();
        super(d10, a10);
        ((b)this.g()).o(25);
    }

    public byte[] h(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = 4;
        byArray = d.v.y.d.a.e(byArray, n11, n10 -= n11);
        byte[][] byArrayArray = new byte[][]{byArray2};
        int n12 = d.v.y.d.d.a(d.v.y.d.a.a(byArray, byArrayArray));
        boolean bl2 = ((a)this.f()).b();
        return d.v.y.d.b.r(n12, 2, bl2);
    }
}


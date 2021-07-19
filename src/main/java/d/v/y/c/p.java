/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.a;
import d.v.y.c.s1.b;
import d.v.y.d.d;

public abstract class p
extends a {
    public p(b b10, d.v.y.c.s1.a a10) {
        super(b10, a10);
        ((b)this.g()).l(false);
        ((b)this.g()).d(6);
        ((d.v.y.c.s1.a)this.f()).c(false);
    }

    public byte[] h(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = 4;
        byArray = d.v.y.d.a.e(byArray, n11, n10 -= n11);
        byte[][] byArrayArray = new byte[][]{byArray2};
        int n12 = d.a(d.v.y.d.a.a(byArray, byArrayArray));
        boolean bl2 = ((d.v.y.c.s1.a)this.f()).b();
        return d.v.y.d.b.r(n12, 2, bl2);
    }
}


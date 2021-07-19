/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.a;
import d.v.y.c.t1.b;
import d.v.y.d.d;

public class w0
extends a {
    public w0() {
        b b10 = new b();
        d.v.y.c.t1.a a10 = new d.v.y.c.t1.a();
        super(b10, a10);
    }

    public byte[] h(byte[] byArray, byte[] byArray2) {
        byte[][] byArrayArray = new byte[][]{byArray2};
        int n10 = d.a(d.v.y.d.a.a(byArray, byArrayArray));
        boolean bl2 = ((d.v.y.c.t1.a)this.f()).b();
        return d.v.y.d.b.r(n10, 2, bl2);
    }

    public int n() {
        return ((b)this.g()).f();
    }

    public int o() {
        return ((d.v.y.c.t1.a)this.f()).d();
    }

    public void p(int n10) {
        ((b)this.g()).i(n10);
    }

    public void q(int n10) {
        ((d.v.y.c.t1.a)this.f()).e(n10);
    }
}


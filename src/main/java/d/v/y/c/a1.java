/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.a;
import d.v.y.c.u1.b;
import d.v.y.d.d;

public class a1
extends a {
    public a1(d.v.y.c.u1.a a10) {
        b b10 = new b();
        super(b10, a10);
    }

    public byte[] a() {
        byte[] byArray = ((d.v.y.c.u1.a)this.f()).a();
        int n10 = d.a(byArray);
        ((b)this.g()).r(n10);
        Object object = (b)this.g();
        int n11 = byArray.length;
        ((b)object).b(n11);
        object = ((b)this.g()).a();
        byte[][] byArrayArray = new byte[][]{byArray};
        return d.v.y.d.a.a((byte[])object, byArrayArray);
    }

    public byte[] h(byte[] byArray, byte[] byArray2) {
        int n10 = d.a(byArray2);
        boolean bl2 = ((d.v.y.c.u1.a)this.f()).b();
        return d.v.y.d.b.r(n10, 2, bl2);
    }

    public int n() {
        return ((b)this.g()).j();
    }

    public boolean o() {
        return ((b)this.g()).l();
    }

    public void p(boolean bl2) {
        ((b)this.g()).t(bl2);
    }

    public boolean parseFrom(byte[] byArray) {
        return super.parseFrom(byArray);
    }

    public void q(int n10) {
        ((b)this.g()).v(n10);
    }
}


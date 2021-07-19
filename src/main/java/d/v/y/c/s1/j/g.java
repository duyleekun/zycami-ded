/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.a;
import d.v.y.d.b;

public class g
extends a {
    private int b;
    private short c;

    public byte[] a() {
        int n10 = this.b;
        boolean bl2 = this.b();
        return d.v.y.d.b.r(n10, 4, bl2);
    }

    public void clear() {
        this.b = 0;
    }

    public short d() {
        return this.c;
    }

    public void e(int n10) {
        this.b = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        byte bl2 = byArray.length;
        int n10 = 0;
        byte bl3 = 2;
        if (bl2 >= bl3) {
            bl2 = byArray[0];
            n10 = 1;
            short s10 = byArray[n10];
            boolean bl4 = this.b();
            this.c = s10 = d.v.y.d.b.y(bl2, (byte)s10, bl4);
        }
        return n10 != 0;
    }
}


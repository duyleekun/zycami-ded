/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.b;

public class p
extends b {
    public p() {
        this.n((byte)1);
        this.o(0);
    }

    public boolean parseFrom(byte[] byArray) {
        byte by2 = super.parseFrom(byArray);
        byte by3 = 1;
        if (by2 == 0 || (by2 = this.h()) != by3) {
            by3 = 0;
        }
        return by3 != 0;
    }
}


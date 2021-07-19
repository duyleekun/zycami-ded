/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.b;

public class r
extends b {
    public r() {
        this.n((byte)2);
    }

    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n11 = super.parseFrom(byArray);
        if (n11 != 0 && (n11 = this.h()) == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            byArray = null;
        }
        return n11 != 0;
    }
}


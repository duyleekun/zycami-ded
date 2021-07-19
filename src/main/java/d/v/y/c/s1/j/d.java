/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.b;

public class d
extends b {
    public d() {
        this.n((byte)7);
        this.o(0);
    }

    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n11 = super.parseFrom(byArray);
        if (n11 != 0 && (n11 = this.h()) == (n10 = 7)) {
            n11 = 1;
        } else {
            n11 = 0;
            byArray = null;
        }
        return n11 != 0;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.l;

public class b
extends d.v.y.c.s1.b {
    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n11 = super.parseFrom(byArray);
        if (n11 != 0 && (n11 = this.i()) == (n10 = 21)) {
            n11 = 1;
        } else {
            n11 = 0;
            byArray = null;
        }
        return n11 != 0;
    }
}


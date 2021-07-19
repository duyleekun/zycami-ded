/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.f0.l;

import d.v.b.c0.b;

public class g
extends b {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;

    public g() {
        Integer n10 = 0;
        Integer n11 = 4;
        super(n10, n10, n11);
    }

    public boolean o() {
        int n10;
        int n11;
        Integer n12 = (Integer)this.a;
        int n13 = n12;
        if (n13 != (n11 = 1) && (n13 = (n12 = (Integer)this.a).intValue()) != (n10 = 2)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void p(Integer n10) {
        super.set(n10);
    }
}


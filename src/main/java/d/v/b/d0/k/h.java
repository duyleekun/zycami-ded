/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.d0.k;

import d.v.b.c0.b;

public class h
extends b {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;

    public h() {
        Integer n10 = 0;
        Integer n11 = 3;
        super(n10, n10, n11);
    }

    public void o(Integer n10) {
        int n11 = n10;
        int n12 = (Integer)this.c;
        n10 = n11 % n12;
        super.set(n10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.e;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class g
extends a {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;

    public g() {
        Integer n10 = 3;
        this.a = n10;
    }

    public boolean n() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 4)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean o() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean p() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 2)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean q() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 3)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public void r(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set photo status =");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.c;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class c
extends a {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 5;

    public c() {
        Integer n10 = 1;
        this.a = n10;
    }

    public boolean n() {
        int n10 = 1;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 != n12) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean o() {
        Integer n10 = (Integer)this.a;
        int n11 = n10;
        if (!n11) {
            n11 = 1;
        } else {
            n11 = 0;
            n10 = null;
        }
        return n11 != 0;
    }

    public boolean p() {
        int n10 = 5;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean q() {
        int n10 = 2;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean r() {
        int n10 = 3;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public void s(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("device set integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


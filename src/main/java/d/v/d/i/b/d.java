/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.b;

import d.v.d.i.a.a;

public class d
extends a {
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;

    public d() {
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
        if (n12 == (n10 = 3)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
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

    public void q(Integer n10) {
        Object object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            return;
        }
        super.set(n10);
    }
}


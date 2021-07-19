/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class u
extends a {
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    public static final int k = 5;

    public u() {
        Integer n10 = 4;
        this.a = n10;
    }

    public boolean n() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 5)) {
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

    public boolean q() {
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

    public void r(Integer n10) {
        int n11;
        Object object = this.a;
        int n12 = n10.equals(object);
        if (n12 != 0) {
            return;
        }
        n12 = n10;
        if (n12 == (n11 = 3) && (n12 = ((Integer)(object = (Integer)this.a)).intValue()) != (n11 = 2)) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("set preview status integer=");
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        super.set(n10);
    }
}


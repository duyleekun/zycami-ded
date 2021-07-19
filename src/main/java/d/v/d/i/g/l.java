/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.g;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class l
extends a {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 4;
    public static final int k = 5;
    public static final int l = 6;

    public l() {
        Integer n10 = 5;
        this.a = n10;
    }

    public boolean n() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 6)) {
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
        if (n12 == (n10 = 4)) {
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
        if (n12 == (n10 = 2)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean r() {
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

    public void s(Integer n10) {
        Object object = new StringBuilder();
        String string2 = "record status set integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value ,return");
            return;
        }
        super.set(n10);
    }
}


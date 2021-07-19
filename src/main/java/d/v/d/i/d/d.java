/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.d;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class d
extends a {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;

    public d() {
        Integer n10 = 0;
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

    public void o(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("live record set integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


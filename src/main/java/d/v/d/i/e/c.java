/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.e;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class c
extends a {
    public static final int h = 1;
    public static final int i = 2;

    public c() {
        Integer n10 = 2;
        this.a = n10;
    }

    public boolean n() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public void o(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set mirror integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


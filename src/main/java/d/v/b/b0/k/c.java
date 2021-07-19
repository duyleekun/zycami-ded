/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.b0.k;

import d.v.b.c0.b;
import d.v.d.h.f;

public class c
extends b {
    public c() {
        Integer n10 = 0;
        Integer n11 = d.v.b0.c.e.c.a().size();
        super(n10, n10, n11);
    }

    public void o(Integer n10) {
        Object object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is not change , return");
            return;
        }
        super.set(n10);
    }
}


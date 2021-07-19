/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.d0.k;

import d.v.b.c0.b;
import d.v.d.h.f;

public class l
extends b {
    public l() {
        Integer n10 = 0;
        Integer n11 = 99;
        super(n10, n10, n11);
    }

    public void o(Integer n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("mask value set integer=");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",mT=");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            return;
        }
        super.set(n10);
    }

    public void p(Integer n10, Integer n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mask value min=");
        stringBuilder.append(n10);
        stringBuilder.append(",max=");
        stringBuilder.append(n11);
        d.v.d.h.f.a(stringBuilder.toString());
        super.c(n10, n11);
        this.d();
    }
}


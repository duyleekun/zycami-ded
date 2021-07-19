/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class e
extends a {
    public e() {
        Integer n10 = 0;
        this.a = n10;
        this.c = n10;
        this.b = n10;
    }

    public void n(Integer n10) {
        Object object = new StringBuilder();
        String string2 = "ae set value=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value , return");
            return;
        }
        super.set(n10);
    }
}


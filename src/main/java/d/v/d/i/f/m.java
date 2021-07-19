/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class m
extends a {
    public m() {
        Integer n10 = 100;
        this.a = n10;
        this.c = n10;
        n10 = 200;
        this.b = n10;
    }

    public void n(Integer n10) {
        Object object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value , return");
            return;
        }
        super.set(n10);
    }
}


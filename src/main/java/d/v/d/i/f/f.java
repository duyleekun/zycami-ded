/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.i.a.a;

public class f
extends a {
    public f() {
        Float f10 = Float.valueOf(0.0f);
        this.a = f10;
        this.c = f10;
        this.b = f10;
    }

    public void n(Float f10) {
        Object object = this.a;
        boolean bl2 = f10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value , return");
            return;
        }
        super.set(f10);
    }
}


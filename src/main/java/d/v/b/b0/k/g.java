/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.b0.k;

import d.v.b.c0.b;
import d.v.d.h.f;

public class g
extends b {
    public g() {
        Float f10 = Float.valueOf(0.0f);
        Float f11 = Float.valueOf(1.0f);
        super(f10, f10, f11);
    }

    public void o(Float f10) {
        Object object = new StringBuilder();
        String string2 = "skin set aFloat=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = f10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is not change , return");
            return;
        }
        super.set(f10);
    }
}


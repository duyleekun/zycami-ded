/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.g;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class e
extends a {
    public static final double h = 30.0;

    public e() {
        Double d10 = 30.0;
        this.a = d10;
    }

    public void n(Double d10) {
        Object object = new StringBuilder();
        String string2 = "set Record capture aDouble=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(d10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = d10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value ,return");
            return;
        }
        super.set(d10);
    }
}


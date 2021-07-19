/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;

public class r
extends a {
    public r() {
        Long l10 = 1000L;
        this.a = l10;
    }

    public void n(Long l10) {
        Object object = this.a;
        boolean bl2 = l10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value , return");
            return;
        }
        super.set(l10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.d0.k;

import d.v.b.c0.b;
import d.v.d.h.f;

public class j
extends b {
    public j() {
        Float f10 = Float.valueOf(1.0f);
        super(f10);
    }

    public void o(Float f10) {
        boolean bl2 = this.j();
        if (!bl2) {
            d.v.d.h.f.a("current is not support");
            return;
        }
        super.set(f10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.b0.k;

import d.v.b.c0.b;
import d.v.d.h.f;

public class h
extends b {
    public h(boolean bl2) {
        Boolean bl3 = bl2;
        super(bl3);
    }

    public boolean o() {
        return (Boolean)this.a;
    }

    public void p(Boolean bl2) {
        Object object = this.a;
        boolean bl3 = bl2.equals(object);
        if (bl3) {
            d.v.d.h.f.a("current is not change , return");
            return;
        }
        super.set(bl2);
    }
}


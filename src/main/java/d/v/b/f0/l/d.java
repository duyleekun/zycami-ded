/*
 * Decompiled with CFR 0.151.
 */
package d.v.b.f0.l;

import d.v.b.c0.b;
import d.v.d.h.f;

public class d
extends b {
    public static final int i = 0;
    public static final int j = 90;
    public static final int k = 180;
    public static final int l = 270;

    public d() {
        Integer n10 = 0;
        super(n10);
    }

    public boolean o() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != (n10 = 90) && (n12 = (n11 = (Integer)this.a).intValue()) != (n10 = 270)) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = 1;
        }
        return n12 != 0;
    }

    public boolean p() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != 0 && (n12 = (n11 = (Integer)this.a).intValue()) != (n10 = 180)) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = 1;
        }
        return n12 != 0;
    }

    public void q(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set TextureOrientation integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


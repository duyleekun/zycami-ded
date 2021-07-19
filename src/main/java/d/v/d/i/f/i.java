/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;
import java.io.Serializable;
import java.util.List;

public class i
extends a {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private final List h;

    public i() {
        Serializable serializable = 0;
        this.a = serializable;
        this.h = serializable;
    }

    public List n() {
        return this.h;
    }

    public boolean o() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 2)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public boolean p() {
        Integer n10 = (Integer)this.a;
        int n11 = n10;
        if (!n11) {
            n11 = 1;
        } else {
            n11 = 0;
            n10 = null;
        }
        return n11 != 0;
    }

    public boolean q() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean r() {
        int n10;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        if (n12 == (n10 = 3)) {
            n12 = 1;
        } else {
            n12 = 0;
            n11 = null;
        }
        return n12 != 0;
    }

    public void s(Integer n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("set flash integer =");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",mT=");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is sample flash ,return");
            return;
        }
        object = this.h;
        object2 = this.a;
        bl2 = object.contains(object2);
        if (!bl2) {
            d.v.d.h.f.a("current is invalid value ,return");
            return;
        }
        super.set(n10);
    }

    public void t(List list) {
        this.h.clear();
        this.h.addAll(list);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;
import java.io.Serializable;
import java.util.List;

public class j
extends a {
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 6;
    private final List h;

    public j() {
        Serializable serializable = 1;
        this.a = serializable;
        this.h = serializable;
    }

    public List n() {
        return this.h;
    }

    public void o(Integer n10) {
        Object object = new StringBuilder();
        String string2 = "set focus integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("focus set same,return");
            return;
        }
        super.set(n10);
    }

    public void p(List list) {
        this.h.clear();
        this.h.addAll(list);
    }
}


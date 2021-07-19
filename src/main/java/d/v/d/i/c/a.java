/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.c;

import d.v.d.h.f;

public class a
extends d.v.d.i.a.a {
    public a() {
        Integer n10 = 0;
        this.a = n10;
    }

    public void n(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("device orientation set integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.f;

import d.v.d.h.f;
import d.v.d.i.a.a;
import java.util.ArrayList;
import java.util.List;

public class h
extends a {
    public h() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.m(false);
    }

    public void m(boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set face trigger =");
        stringBuilder.append(bl2);
        d.v.d.h.f.a(stringBuilder.toString());
        super.m(bl2);
    }

    public void n(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set faces=");
        int n10 = list.size();
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        ((List)this.a).clear();
        ((List)this.a).addAll(list);
        this.d();
    }
}


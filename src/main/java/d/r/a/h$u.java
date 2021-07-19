/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;
import java.util.ArrayList;

public final class h$u
extends h$t {
    public ArrayList e = null;
    public ArrayList f = null;

    public h$u(int n10) {
        super(n10);
    }

    public final void d(g g10) {
        super.d(g10);
        ArrayList arrayList = this.e;
        g10.g("content", arrayList);
        arrayList = this.f;
        g10.g("error_msg", arrayList);
    }

    public final void e(g object) {
        ArrayList arrayList;
        super.e((g)object);
        this.e = arrayList = ((g)object).j("content");
        this.f = object = ((g)object).j("error_msg");
    }

    public final String toString() {
        return "OnSetTagsCommand";
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;
import java.util.ArrayList;

public final class h$n
extends h$t {
    public ArrayList e;

    public h$n() {
        super(8);
    }

    public final void d(g g10) {
        super.d(g10);
        ArrayList arrayList = this.e;
        g10.g("tags_list", arrayList);
    }

    public final void e(g object) {
        super.e((g)object);
        this.e = object = ((g)object).j("tags_list");
    }

    public final String toString() {
        return "OnListTagCommand";
    }
}


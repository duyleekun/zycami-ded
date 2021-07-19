/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$d;
import java.util.ArrayList;

public final class h$a0
extends h$d {
    private ArrayList i;

    /*
     * WARNING - void declaration
     */
    public h$a0(boolean bl2, String string2, ArrayList arrayList) {
        void var3_6;
        void var2_5;
        void var1_4;
        if (bl2) {
            int n10 = 2004;
        } else {
            int n11 = 2005;
        }
        super((int)var1_4, (String)var2_5);
        this.i = var3_6;
    }

    public final void d(g g10) {
        super.d(g10);
        ArrayList arrayList = this.i;
        g10.e("tags", arrayList);
    }

    public final void e(g object) {
        super.e((g)object);
        this.i = object = ((g)object).j("tags");
    }

    public final String toString() {
        return "TagCommand";
    }
}


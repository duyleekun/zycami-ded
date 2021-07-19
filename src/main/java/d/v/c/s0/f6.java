/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.core.util.Pair;
import androidx.core.util.Supplier;
import d.v.c.s0.w6;
import e.a.v0.g;

public final class f6
implements g {
    public final /* synthetic */ w6 a;
    public final /* synthetic */ Supplier b;
    public final /* synthetic */ Supplier c;

    public /* synthetic */ f6(w6 w62, Supplier supplier, Supplier supplier2) {
        this.a = w62;
        this.b = supplier;
        this.c = supplier2;
    }

    public final void accept(Object object) {
        w6 w62 = this.a;
        Supplier supplier = this.b;
        Supplier supplier2 = this.c;
        object = (Pair)object;
        w62.x(supplier, supplier2, (Pair)object);
    }
}


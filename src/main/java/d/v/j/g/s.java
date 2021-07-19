/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import d.v.j.g.c0;
import e.a.v0.o;
import java.util.function.Supplier;

public final class s
implements o {
    public final /* synthetic */ Supplier a;

    public /* synthetic */ s(Supplier supplier) {
        this.a = supplier;
    }

    public final Object apply(Object object) {
        Supplier supplier = this.a;
        object = (Boolean)object;
        return c0.f(supplier, (Boolean)object);
    }
}


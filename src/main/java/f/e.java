/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c;
import f.h2.t.f0;
import f.h2.t.u;

public abstract class e {
    private e() {
    }

    public /* synthetic */ e(u u10) {
        this();
    }

    public abstract Object a(Object var1, f.b2.c var2);

    public abstract Object b(c var1, Object var2, f.b2.c var3);

    public final Void c(c object, Object object2) {
        f0.p(object, "$this$invoke");
        object = new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
        throw object;
    }
}


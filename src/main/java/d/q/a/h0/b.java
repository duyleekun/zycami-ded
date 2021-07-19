/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.h0;

import d.q.a.h0.g;
import e.a.v0.r;
import java.util.Comparator;

public final class b
implements r {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Comparator comparator, Object object) {
        this.a = comparator;
        this.b = object;
    }

    public final boolean test(Object object) {
        Comparator comparator = this.a;
        Object object2 = this.b;
        return g.a(comparator, object2, object);
    }
}


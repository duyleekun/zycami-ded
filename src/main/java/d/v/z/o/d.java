/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.o;

import d.v.z.o.i;
import java.util.function.Predicate;

public final class d
implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int n10) {
        this.a = n10;
    }

    public final boolean test(Object object) {
        int n10 = this.a;
        object = (Enum)object;
        return i.g(n10, (Enum)object);
    }
}


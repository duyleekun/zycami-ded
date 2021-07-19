/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import d.v.g.g.d1;
import java.util.function.Predicate;

public final class l
implements Predicate {
    public final /* synthetic */ d1 a;

    public /* synthetic */ l(d1 d12) {
        this.a = d12;
    }

    public final boolean test(Object object) {
        d1 d12 = this.a;
        object = (String)object;
        return d12.l((String)object);
    }
}


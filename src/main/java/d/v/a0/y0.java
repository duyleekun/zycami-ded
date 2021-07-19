/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.k1;
import java.util.function.Predicate;

public final class y0
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ y0(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (String)object;
        return k1.d(string2, (String)object);
    }
}


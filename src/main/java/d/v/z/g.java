/*
 * Decompiled with CFR 0.151.
 */
package d.v.z;

import d.v.z.i$a;
import d.v.z.j;
import java.util.function.Predicate;

public final class g
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ g(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (i$a)object;
        return j.e(string2, (i$a)object);
    }
}


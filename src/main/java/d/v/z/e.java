/*
 * Decompiled with CFR 0.151.
 */
package d.v.z;

import d.v.z.j;
import java.util.function.Predicate;

public final class e
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ e(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (String)object;
        return j.k(string2, (String)object);
    }
}


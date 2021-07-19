/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import d.v.c.n1.j2;
import java.util.function.Predicate;

public final class n1
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ n1(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (String)object;
        return j2.b0(string2, (String)object);
    }
}


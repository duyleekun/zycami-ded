/*
 * Decompiled with CFR 0.151.
 */
package d.v.z;

import d.v.z.i$a$a;
import d.v.z.j;
import java.util.function.Predicate;

public final class c
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ c(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (i$a$a)object;
        return j.h(string2, (i$a$a)object);
    }
}


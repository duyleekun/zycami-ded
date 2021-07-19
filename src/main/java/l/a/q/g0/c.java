/*
 * Decompiled with CFR 0.151.
 */
package l.a.q.g0;

import java.util.function.Predicate;
import l.a.q.g0.p;

public final class c
implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ c(String string2) {
        this.a = string2;
    }

    public final boolean test(Object object) {
        String string2 = this.a;
        object = (String)object;
        return p.l(string2, (String)object);
    }
}


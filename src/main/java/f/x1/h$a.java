/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.u;
import java.util.Collection;
import java.util.Set;

public final class h$a {
    private h$a() {
    }

    public /* synthetic */ h$a(u u10) {
        this();
    }

    public final boolean a(Set set, Set set2) {
        f0.p(set, "c");
        String string2 = "other";
        f0.p(set2, string2);
        int n10 = set.size();
        int n11 = set2.size();
        if (n10 != n11) {
            return false;
        }
        return set.containsAll(set2);
    }

    public final int b(Collection object) {
        int n10;
        f0.p(object, "c");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            if (e10 != null) {
                n10 = e10.hashCode();
            } else {
                n10 = 0;
                e10 = null;
            }
            n11 += n10;
        }
        return n11;
    }
}


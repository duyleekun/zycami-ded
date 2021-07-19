/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.k0;
import f.x1.v;
import java.util.Iterator;

public class w
extends v {
    public static final void g0(Iterator iterator2, l l10) {
        boolean bl2;
        f0.p(iterator2, "$this$forEach");
        String string2 = "operation";
        f0.p(l10, string2);
        while (bl2 = iterator2.hasNext()) {
            string2 = iterator2.next();
            l10.invoke(string2);
        }
    }

    private static final Iterator h0(Iterator iterator2) {
        f0.p(iterator2, "$this$iterator");
        return iterator2;
    }

    public static final Iterator i0(Iterator iterator2) {
        f0.p(iterator2, "$this$withIndex");
        k0 k02 = new k0(iterator2);
        return k02;
    }
}


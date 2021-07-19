/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.m1;
import f.n2.m;
import f.y0;

public class y {
    public static final int a(m object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            y0 y02 = (y0)object.next();
            n10 = c1.h(y02.Y() & 0xFF);
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final int b(m object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            c1 c12 = (c1)object.next();
            n10 = c12.a0();
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final long c(m object) {
        boolean bl2;
        String string2 = "$this$sum";
        f0.p(object, string2);
        object = object.iterator();
        long l10 = 0L;
        while (bl2 = object.hasNext()) {
            g1 g12 = (g1)object.next();
            long l11 = g12.a0();
            l10 = g1.h(l10 + l11);
        }
        return l10;
    }

    public static final int d(m object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            m1 m12 = (m1)object.next();
            n10 = m12.Y();
            char c10 = (char)-1;
            n10 = c1.h(n10 & c10);
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }
}


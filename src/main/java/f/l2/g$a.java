/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.l2.g;

public final class g$a {
    public static boolean a(g object, Comparable comparable) {
        int n10;
        f0.p(comparable, "value");
        Comparable comparable2 = object.getStart();
        int n11 = comparable.compareTo(comparable2);
        if (n11 >= 0 && (n10 = comparable.compareTo(object = object.c())) <= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public static boolean b(g object) {
        Comparable comparable = object.getStart();
        int n10 = comparable.compareTo(object = object.c());
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }
}


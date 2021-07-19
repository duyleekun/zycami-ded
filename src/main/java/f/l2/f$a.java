/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.l2.f;

public final class f$a {
    public static boolean a(f f10, Comparable comparable) {
        boolean bl2;
        f0.p(comparable, "value");
        Comparable comparable2 = f10.getStart();
        boolean bl3 = f10.b(comparable2, comparable);
        if (bl3 && (bl2 = f10.b(comparable, comparable2 = f10.c()))) {
            bl2 = true;
        } else {
            bl2 = false;
            f10 = null;
        }
        return bl2;
    }

    public static boolean b(f f10) {
        Comparable comparable = f10.getStart();
        Comparable comparable2 = f10.c();
        return f10.b(comparable, comparable2) ^ true;
    }
}


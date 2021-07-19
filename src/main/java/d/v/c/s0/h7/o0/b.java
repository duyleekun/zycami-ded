/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import java.io.File;
import java.util.function.Predicate;

public final class b
implements Predicate {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final boolean test(Object object) {
        return ((File)object).exists();
    }
}


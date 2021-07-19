/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import java.io.File;
import java.util.function.Predicate;

public final class t0
implements Predicate {
    public static final /* synthetic */ t0 a;

    static {
        t0 t02;
        a = t02 = new t0();
    }

    public final boolean test(Object object) {
        return ((File)object).isDirectory();
    }
}


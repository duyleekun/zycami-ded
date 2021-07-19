/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import java.io.File;
import java.util.function.Function;

public final class u0
implements Function {
    public static final /* synthetic */ u0 a;

    static {
        u0 u02;
        a = u02 = new u0();
    }

    public final Object apply(Object object) {
        return ((File)object).getParentFile();
    }
}


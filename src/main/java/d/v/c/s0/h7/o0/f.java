/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import java.util.function.ToLongFunction;

public final class f
implements ToLongFunction {
    public static final /* synthetic */ f a;

    static {
        f f10;
        a = f10 = new f();
    }

    public final long applyAsLong(Object object) {
        return Long.parseLong((String)object);
    }
}


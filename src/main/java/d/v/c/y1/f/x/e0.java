/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import java.util.function.BinaryOperator;

public final class e0
implements BinaryOperator {
    public static final /* synthetic */ e0 a;

    static {
        e0 e02;
        a = e02 = new e0();
    }

    public final Object apply(Object object, Object object2) {
        long l10 = (Long)object;
        long l11 = (Long)object2;
        return Long.sum(l10, l11);
    }
}


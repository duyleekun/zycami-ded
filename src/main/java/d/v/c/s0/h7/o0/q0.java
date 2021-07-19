/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import d.v.c.s0.h7.o0.w0;
import java.util.Comparator;
import java.util.Map;

public final class q0
implements Comparator {
    public static final /* synthetic */ q0 a;

    static {
        q0 q02;
        a = q02 = new q0();
    }

    public final int compare(Object object, Object object2) {
        object = (Map.Entry)object;
        object2 = (Map.Entry)object2;
        return w0.c0((Map.Entry)object, (Map.Entry)object2);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import f.y1.c;
import java.util.Comparator;

public class d
extends c {
    public static final Object p0(Object object, Object object2, Object object3, Comparator comparator) {
        f0.p(comparator, "comparator");
        object2 = d.q0(object2, object3, comparator);
        return d.q0(object, object2, comparator);
    }

    public static final Object q0(Object object, Object object2, Comparator comparator) {
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = comparator.compare(object, object2);
        if (n10 < 0) {
            object = object2;
        }
        return object;
    }

    public static final Object r0(Object object, Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "other");
        String string2 = "comparator";
        f0.p(comparator, string2);
        for (Object object2 : objectArray) {
            int n10 = comparator.compare(object, object2);
            if (n10 >= 0) continue;
            object = object2;
        }
        return object;
    }

    public static final Object s0(Object object, Object object2, Object object3, Comparator comparator) {
        f0.p(comparator, "comparator");
        object2 = d.t0(object2, object3, comparator);
        return d.t0(object, object2, comparator);
    }

    public static final Object t0(Object object, Object object2, Comparator comparator) {
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = comparator.compare(object, object2);
        if (n10 > 0) {
            object = object2;
        }
        return object;
    }

    public static final Object u0(Object object, Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "other");
        String string2 = "comparator";
        f0.p(comparator, string2);
        for (Object object2 : objectArray) {
            int n10 = comparator.compare(object, object2);
            if (n10 <= 0) continue;
            object = object2;
        }
        return object;
    }
}


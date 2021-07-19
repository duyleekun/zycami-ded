/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.p;
import f.h2.t.f0;
import f.x1.w;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.NotImplementedError;

public class x
extends w {
    private static final void j0(List list, Object object) {
        Collections.fill(list, object);
    }

    private static final void k0(List list) {
        Collections.shuffle(list);
    }

    private static final void l0(List list, Random random) {
        Collections.shuffle(list, random);
    }

    public static final void m0(List list) {
        String string2 = "$this$sort";
        f0.p(list, string2);
        int n10 = list.size();
        int n11 = 1;
        if (n10 > n11) {
            Collections.sort(list);
        }
    }

    private static final void n0(List object, Comparator comparator) {
        object = new NotImplementedError(null, 1, null);
        throw object;
    }

    private static final void o0(List object, p p10) {
        object = new NotImplementedError(null, 1, null);
        throw object;
    }

    public static final void p0(List list, Comparator comparator) {
        f0.p(list, "$this$sortWith");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = list.size();
        int n11 = 1;
        if (n10 > n11) {
            Collections.sort(list, comparator);
        }
    }
}


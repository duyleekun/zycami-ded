/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.g1;
import f.h1;
import f.h2.s.l;

public final class i1 {
    private static final long[] a(int n10, l l10) {
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11;
            Comparable<Integer> comparable = i10;
            comparable = (g1)l10.invoke(comparable);
            lArray[i10] = l11 = ((g1)comparable).a0();
        }
        return h1.f(lArray);
    }

    private static final long[] b(long ... lArray) {
        return lArray;
    }
}


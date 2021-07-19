/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.d1;
import f.h2.s.l;

public final class e1 {
    private static final int[] a(int n10, l l10) {
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Comparable<Integer> comparable = i10;
            comparable = (c1)l10.invoke(comparable);
            nArray[i10] = n11 = ((c1)comparable).a0();
        }
        return d1.f(nArray);
    }

    private static final int[] b(int ... nArray) {
        return nArray;
    }
}


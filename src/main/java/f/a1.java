/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.l;
import f.y0;
import f.z0;

public final class a1 {
    private static final byte[] a(int n10, l l10) {
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            Comparable<Integer> comparable = i10;
            comparable = (y0)l10.invoke(comparable);
            byArray[i10] = by2 = ((y0)comparable).Y();
        }
        return z0.f(byArray);
    }

    private static final byte[] b(byte ... byArray) {
        return byArray;
    }
}


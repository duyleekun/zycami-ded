/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.l;
import f.m1;
import f.n1;

public final class o1 {
    private static final short[] a(int n10, l l10) {
        short[] sArray = new short[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10;
            Comparable<Integer> comparable = i10;
            comparable = (m1)l10.invoke(comparable);
            sArray[i10] = s10 = ((m1)comparable).Y();
        }
        return n1.f(sArray);
    }

    private static final short[] b(short ... sArray) {
        return sArray;
    }
}


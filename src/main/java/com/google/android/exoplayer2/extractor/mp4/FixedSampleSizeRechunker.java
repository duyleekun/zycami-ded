/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results;
import com.google.android.exoplayer2.util.Util;

public final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    private FixedSampleSizeRechunker() {
    }

    public static FixedSampleSizeRechunker$Results rechunk(int n10, long[] lArray, int[] nArray, long l10) {
        long l11;
        int n11;
        int n12;
        Object object = nArray;
        int n13 = 8192 / n10;
        int n14 = nArray.length;
        int n15 = 0;
        int n16 = 0;
        for (n12 = 0; n12 < n14; ++n12) {
            n11 = Util.ceilDivide(object[n12], n13);
            n16 += n11;
        }
        long[] lArray2 = new long[n16];
        int[] nArray2 = new int[n16];
        long[] lArray3 = new long[n16];
        int[] nArray3 = new int[n16];
        n14 = 0;
        n12 = 0;
        int n17 = 0;
        while (n15 < (n16 = ((int[])object).length)) {
            n16 = object[n15];
            l11 = lArray[n15];
            while (n16 > 0) {
                long l12;
                int n18;
                n11 = Math.min(n13, n16);
                lArray2[n12] = l11;
                nArray2[n12] = n18 = n10 * n11;
                n18 = nArray2[n12];
                n17 = Math.max(n17, n18);
                lArray3[n12] = l12 = (long)n14 * l10;
                nArray3[n12] = 1;
                n18 = nArray2[n12];
                l12 = n18;
                l11 += l12;
                n14 += n11;
                n16 -= n11;
                ++n12;
            }
            ++n15;
        }
        long l13 = n14;
        l11 = l10 * l13;
        object = new FixedSampleSizeRechunker$Results;
        object(lArray2, nArray2, n17, lArray3, nArray3, l11, null);
        return object;
    }
}


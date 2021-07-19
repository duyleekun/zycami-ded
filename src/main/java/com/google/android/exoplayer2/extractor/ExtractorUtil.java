/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorInput;

public final class ExtractorUtil {
    private ExtractorUtil() {
    }

    public static int peekToLength(ExtractorInput extractorInput, byte[] byArray, int n10, int n11) {
        int n12;
        int n13;
        for (n12 = 0; n12 < n11; n12 += n13) {
            n13 = n10 + n12;
            int n14 = n11 - n12;
            if ((n13 = extractorInput.peek(byArray, n13, n14)) == (n14 = -1)) break;
        }
        return n12;
    }
}


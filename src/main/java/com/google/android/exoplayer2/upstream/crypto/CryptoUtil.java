/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.crypto;

public final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(String string2) {
        int n10;
        long l10 = 0L;
        if (string2 == null) {
            return l10;
        }
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            long l11 = string2.charAt(i10);
            l10 ^= l11;
            n10 = 1;
            l11 = l10 << n10;
            long l12 = l10 << 4;
            l11 += l12;
            l12 = l10 << 5;
            l11 += l12;
            l12 = l10 << 7;
            l11 += l12;
            l12 = l10 << 8;
            l11 += l12;
            int n11 = 40;
            l12 = l10 << n11;
            l10 += (l11 += l12);
        }
        return l10;
    }
}


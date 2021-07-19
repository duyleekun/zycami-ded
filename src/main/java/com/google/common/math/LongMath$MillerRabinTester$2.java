/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LongMath$MillerRabinTester;
import com.google.common.primitives.UnsignedLongs;

public final class LongMath$MillerRabinTester$2
extends LongMath$MillerRabinTester {
    private long plusMod(long l10, long l11, long l12) {
        long l13 = l12 - l11;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        l10 += l11;
        if (l14 >= 0) {
            l10 -= l12;
        }
        return l10;
    }

    private long times2ToThe32Mod(long l10, long l11) {
        int n10;
        int n11 = 32;
        do {
            n10 = Long.numberOfLeadingZeros(l10);
            n10 = Math.min(n11, n10);
            l10 = UnsignedLongs.remainder(l10 << n10, l11);
        } while ((n11 -= n10) > 0);
        return l10;
    }

    public long mulMod(long l10, long l11, long l12) {
        long l13 = l12;
        int n10 = 32;
        long l14 = l10 >>> n10;
        long l15 = l11 >>> n10;
        long l16 = 0xFFFFFFFFL;
        long l17 = l10 & l16;
        l16 = l11 & l16;
        long l18 = l14 * l15;
        l18 = this.times2ToThe32Mod(l18, l12);
        long l19 = 0L;
        long l20 = (l18 += (l14 *= l16)) - l19;
        n10 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
        if (n10 < 0) {
            l18 = UnsignedLongs.remainder(l18, l12);
        }
        l14 = this.times2ToThe32Mod(l18 += (l15 *= l17), l13);
        l15 = UnsignedLongs.remainder(l17 * l16, l13);
        l13 = l12;
        return this.plusMod(l14, l15, l12);
    }

    public long squareMod(long l10, long l11) {
        int n10 = 32;
        long l12 = l10 >>> n10;
        long l13 = l12 * l12;
        l13 = this.times2ToThe32Mod(l13, l11);
        long l14 = 0L;
        long l15 = (l12 = l12 * (l10 &= 0xFFFFFFFFL) * (long)2) - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            l12 = UnsignedLongs.remainder(l12, l11);
        }
        long l16 = this.times2ToThe32Mod(l13 += l12, l11);
        long l17 = UnsignedLongs.remainder(l10 * l10, l11);
        return this.plusMod(l16, l17, l11);
    }
}


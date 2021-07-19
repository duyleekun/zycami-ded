/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

public final class DoubleUtils {
    public static final int EXPONENT_BIAS = 1023;
    public static final long EXPONENT_MASK = 0x7FF0000000000000L;
    public static final long IMPLICIT_BIT = 0x10000000000000L;
    public static final long ONE_BITS = 0x3FF0000000000000L;
    public static final int SIGNIFICAND_BITS = 52;
    public static final long SIGNIFICAND_MASK = 0xFFFFFFFFFFFFFL;
    public static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    public static double bigToDouble(BigInteger bigInteger) {
        int n10;
        long l10;
        BigInteger bigInteger2 = bigInteger.abs();
        int n11 = bigInteger2.bitLength();
        int n12 = 1;
        int n13 = 63;
        if ((n11 -= n12) < n13) {
            return bigInteger.longValue();
        }
        n13 = 1023;
        if (n11 > n13) {
            return (double)bigInteger.signum() * (1.0 / 0.0);
        }
        int n14 = n11 + -52 - n12;
        BigInteger bigInteger3 = bigInteger2.shiftRight(n14);
        long l11 = bigInteger3.longValue();
        long l12 = l11 >> n12 & 0xFFFFFFFFFFFFFL;
        long l13 = 1L;
        long l14 = 0L;
        long l15 = (l11 &= l13) - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false || (object = (l10 = (l11 = l12 & l13) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false && (n10 = bigInteger2.getLowestSetBit()) >= n14) {
            n12 = 0;
        }
        if (n12 != 0) {
            l12 += l13;
        }
        long l16 = ((long)(n11 + n13) << 52) + l12;
        long l17 = (long)bigInteger.signum() & Long.MIN_VALUE;
        return Double.longBitsToDouble(l16 | l17);
    }

    public static double ensureNonNegative(double d10) {
        Preconditions.checkArgument(Double.isNaN(d10) ^ true);
        return Math.max(d10, 0.0);
    }

    public static long getSignificand(double d10) {
        int n10 = DoubleUtils.isFinite(d10);
        String string2 = "not a normal value";
        Preconditions.checkArgument(n10 != 0, string2);
        n10 = Math.getExponent(d10);
        long l10 = Double.doubleToRawLongBits(d10);
        long l11 = 0xFFFFFFFFFFFFFL;
        l10 &= l11;
        int n11 = -1023;
        if (n10 == n11) {
            n10 = 1;
            l10 <<= n10;
        } else {
            long l12 = 0x10000000000000L;
            l10 |= l12;
        }
        return l10;
    }

    public static boolean isFinite(double d10) {
        int n10;
        int n11 = Math.getExponent(d10);
        n11 = n11 <= (n10 = 1023) ? 1 : 0;
        return n11 != 0;
    }

    public static boolean isNormal(double d10) {
        int n10;
        int n11 = Math.getExponent(d10);
        n11 = n11 >= (n10 = -1022) ? 1 : 0;
        return n11 != 0;
    }

    public static double nextDown(double d10) {
        return -Math.nextUp(-d10);
    }

    public static double scaleNormalize(double d10) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d10) & 0xFFFFFFFFFFFFFL | 0x3FF0000000000000L);
    }
}


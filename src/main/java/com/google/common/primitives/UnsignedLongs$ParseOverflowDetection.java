/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedLongs;
import java.math.BigInteger;

public final class UnsignedLongs$ParseOverflowDetection {
    public static final int[] maxSafeDigits;
    public static final long[] maxValueDivs;
    public static final int[] maxValueMods;

    static {
        int n10 = 37;
        maxValueDivs = new long[n10];
        maxValueMods = new int[n10];
        maxSafeDigits = new int[n10];
        String string2 = "10000000000000000";
        int n11 = 16;
        BigInteger bigInteger = new BigInteger(string2, n11);
        for (int i10 = 2; i10 <= (n11 = 36); ++i10) {
            long l10;
            Object[] objectArray = maxValueDivs;
            long l11 = i10;
            long l12 = -1;
            objectArray[i10] = l10 = UnsignedLongs.divide(l12, l11);
            objectArray = maxValueMods;
            l11 = UnsignedLongs.remainder(l12, l11);
            int n12 = (int)l11;
            objectArray[i10] = n12;
            objectArray = maxSafeDigits;
            String string3 = bigInteger.toString(i10);
            n12 = string3.length() + -1;
            objectArray[i10] = n12;
        }
    }

    private UnsignedLongs$ParseOverflowDetection() {
    }

    public static boolean overflowInParse(long l10, int n10, int n11) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 >= 0) {
            long[] lArray = maxValueDivs;
            long l13 = lArray[n11];
            long l14 = l10 - l13;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object < 0) {
                return false;
            }
            long l15 = lArray[n11];
            long l16 = l10 - l15;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 > 0) {
                return bl2;
            }
            int[] nArray = maxValueMods;
            object2 = nArray[n11];
            if (n10 <= object2) {
                bl2 = false;
            }
        }
        return bl2;
    }
}


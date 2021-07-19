/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester$1;
import com.google.common.math.LongMath$MillerRabinTester$2;

public abstract class LongMath$MillerRabinTester
extends Enum {
    private static final /* synthetic */ LongMath$MillerRabinTester[] $VALUES;
    public static final /* enum */ LongMath$MillerRabinTester LARGE;
    public static final /* enum */ LongMath$MillerRabinTester SMALL;

    static {
        LongMath$MillerRabinTester$1 longMath$MillerRabinTester$1 = new LongMath$MillerRabinTester$1();
        SMALL = longMath$MillerRabinTester$1;
        int n10 = 1;
        LongMath$MillerRabinTester$2 longMath$MillerRabinTester$2 = new LongMath$MillerRabinTester$2();
        LARGE = longMath$MillerRabinTester$2;
        LongMath$MillerRabinTester[] longMath$MillerRabinTesterArray = new LongMath$MillerRabinTester[2];
        longMath$MillerRabinTesterArray[0] = longMath$MillerRabinTester$1;
        longMath$MillerRabinTesterArray[n10] = longMath$MillerRabinTester$2;
        $VALUES = longMath$MillerRabinTesterArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LongMath$MillerRabinTester() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ LongMath$MillerRabinTester(LongMath$1 longMath$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    private long powMod(long l10, long l11, long l12) {
        long l13;
        long l14;
        Object object;
        long l15;
        long l16 = l15 = 1L;
        while ((object = (l14 = l11 - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            long l17 = l11 & l15;
            long l18 = l17 - l13;
            object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object != false) {
                l13 = l10;
                l17 = l12;
                l16 = this.mulMod(l16, l10, l12);
            }
            l10 = this.squareMod(l10, l12);
            object = 1;
            l11 >>= object;
        }
        return l16;
    }

    public static boolean test(long l10, long l11) {
        long l12 = 3037000499L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        LongMath$MillerRabinTester longMath$MillerRabinTester = object <= 0 ? SMALL : LARGE;
        return longMath$MillerRabinTester.testWitness(l10, l11);
    }

    private boolean testWitness(long l10, long l11) {
        long l12;
        long l13 = l11;
        long l14 = 1L;
        long l15 = l11 - l14;
        int n10 = Long.numberOfTrailingZeros(l15);
        long l16 = l15 >> n10;
        long l17 = l10 % l11;
        long l18 = 0L;
        long l19 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        int n11 = 1;
        if (l19 == false) {
            return n11 != 0;
        }
        l18 = l11;
        long l20 = this.powMod(l17, l16, l11);
        long l21 = l20 - l14;
        Object object = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object == false) {
            return n11 != 0;
        }
        object = 0;
        int n12 = 0;
        while ((l12 = l20 == l15 ? 0 : (l20 < l15 ? -1 : 1)) != false) {
            if ((n12 += n11) == n10) {
                return false;
            }
            l20 = this.squareMod(l20, l13);
        }
        return n11 != 0;
    }

    public static LongMath$MillerRabinTester valueOf(String string2) {
        return Enum.valueOf(LongMath$MillerRabinTester.class, string2);
    }

    public static LongMath$MillerRabinTester[] values() {
        return (LongMath$MillerRabinTester[])$VALUES.clone();
    }

    public abstract long mulMod(long var1, long var3, long var5);

    public abstract long squareMod(long var1, long var3);
}


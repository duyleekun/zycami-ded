/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester;
import com.google.common.math.MathPreconditions;
import java.math.RoundingMode;

public final class LongMath {
    public static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    public static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    public static final long MAX_SIGNED_POWER_OF_TWO = 0x4000000000000000L;
    private static final int SIEVE_30 = -545925251;
    public static final int[] biggestBinomials;
    public static final int[] biggestSimpleBinomials;
    public static final long[] factorials;
    public static final long[] halfPowersOf10;
    public static final byte[] maxLog10ForLeadingZeros;
    private static final long[][] millerRabinBaseSets;
    public static final long[] powersOf10;

    static {
        long[] lArray;
        long[] lArray2;
        Object object;
        Object[] objectArray;
        byte[] byArray = objectArray = new byte[64];
        byte[] byArray2 = objectArray;
        byArray[0] = 19;
        byArray2[1] = 18;
        byArray[2] = 18;
        byArray2[3] = 18;
        byArray[4] = 18;
        byArray2[5] = 17;
        byArray[6] = 17;
        byArray2[7] = 17;
        byArray[8] = 16;
        byArray2[9] = 16;
        byArray[10] = 16;
        byArray2[11] = 15;
        byArray[12] = 15;
        byArray2[13] = 15;
        byArray[14] = 15;
        byArray2[15] = 14;
        byArray[16] = 14;
        byArray2[17] = 14;
        byArray[18] = 13;
        byArray2[19] = 13;
        byArray[20] = 13;
        byArray2[21] = 12;
        byArray[22] = 12;
        byArray2[23] = 12;
        byArray[24] = 12;
        byArray2[25] = 11;
        byArray[26] = 11;
        byArray2[27] = 11;
        byArray[28] = 10;
        byArray2[29] = 10;
        byArray[30] = 10;
        byArray2[31] = 9;
        byArray[32] = 9;
        byArray2[33] = 9;
        byArray[34] = 9;
        byArray2[35] = 8;
        byArray[36] = 8;
        byArray2[37] = 8;
        byArray[38] = 7;
        byArray2[39] = 7;
        byArray[40] = 7;
        byArray2[41] = 6;
        byArray[42] = 6;
        byArray2[43] = 6;
        byArray[44] = 6;
        byArray2[45] = 5;
        byArray[46] = 5;
        byArray2[47] = 5;
        byArray[48] = 4;
        byArray2[49] = 4;
        byArray[50] = 4;
        byArray2[51] = 3;
        byArray[52] = 3;
        byArray2[53] = 3;
        byArray[54] = 3;
        byArray2[55] = 2;
        byArray[56] = 2;
        byArray2[57] = 2;
        byArray[58] = 1;
        byArray2[59] = 1;
        byArray[60] = 1;
        byArray2[61] = 0;
        byArray[62] = 0;
        byArray2[63] = 0;
        maxLog10ForLeadingZeros = objectArray;
        int n10 = 19;
        long[] lArray3 = object = new long[n10];
        long[] lArray4 = object;
        lArray3[0] = 1L;
        lArray4[1] = 10;
        lArray3[2] = 100;
        lArray4[3] = 1000L;
        lArray3[4] = 10000L;
        lArray4[5] = 100000L;
        lArray3[6] = 1000000L;
        lArray4[7] = 10000000L;
        lArray3[8] = 100000000L;
        lArray4[9] = 1000000000L;
        lArray3[10] = 10000000000L;
        lArray4[11] = 100000000000L;
        lArray3[12] = 1000000000000L;
        lArray4[13] = 10000000000000L;
        lArray3[14] = 100000000000000L;
        lArray4[15] = 1000000000000000L;
        lArray3[16] = 10000000000000000L;
        lArray4[17] = 100000000000000000L;
        lArray4[18] = 1000000000000000000L;
        powersOf10 = object;
        Object[] objectArray2 = objectArray = (Object[])new long[n10];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = (byte)3;
        objectArray3[1] = (byte)31;
        objectArray2[2] = (byte)316L;
        objectArray3[3] = (byte)3162L;
        objectArray2[4] = (byte)31622L;
        objectArray3[5] = (byte)316227L;
        objectArray2[6] = (byte)3162277L;
        objectArray3[7] = (byte)31622776L;
        objectArray2[8] = (byte)316227766L;
        objectArray3[9] = (byte)3162277660L;
        objectArray2[10] = (byte)31622776601L;
        objectArray3[11] = (byte)316227766016L;
        objectArray2[12] = (byte)3162277660168L;
        objectArray3[13] = (byte)31622776601683L;
        objectArray2[14] = (byte)316227766016837L;
        objectArray3[15] = (byte)3162277660168379L;
        objectArray2[16] = (byte)31622776601683793L;
        objectArray3[17] = (byte)316227766016837933L;
        objectArray3[18] = (byte)3162277660168379331L;
        halfPowersOf10 = objectArray;
        Object[] objectArray4 = objectArray = (Object[])new long[21];
        Object[] objectArray5 = objectArray;
        objectArray4[0] = (byte)1L;
        objectArray5[1] = (byte)1L;
        objectArray4[2] = (byte)2;
        objectArray5[3] = (byte)6;
        objectArray4[4] = (byte)24;
        objectArray5[5] = (byte)120;
        objectArray4[6] = (byte)720L;
        objectArray5[7] = (byte)5040L;
        objectArray4[8] = (byte)40320L;
        objectArray5[9] = (byte)362880L;
        objectArray4[10] = (byte)3628800L;
        objectArray5[11] = (byte)39916800L;
        objectArray4[12] = (byte)479001600L;
        objectArray5[13] = (byte)6227020800L;
        objectArray4[14] = (byte)87178291200L;
        objectArray5[15] = (byte)1307674368000L;
        objectArray4[16] = (byte)20922789888000L;
        objectArray5[17] = (byte)355687428096000L;
        objectArray4[18] = (byte)6402373705728000L;
        objectArray5[19] = (byte)121645100408832000L;
        objectArray5[20] = (byte)2432902008176640000L;
        factorials = objectArray;
        Object[] objectArray6 = objectArray = (Object[])new int[34];
        Object[] objectArray7 = objectArray;
        objectArray6[0] = -1 >>> 1;
        objectArray7[1] = -1 >>> 1;
        objectArray6[2] = -1 >>> 1;
        objectArray7[3] = 3810779;
        objectArray6[4] = 121977;
        objectArray7[5] = 16175;
        objectArray6[6] = 4337;
        objectArray7[7] = 1733;
        objectArray6[8] = 887;
        objectArray7[9] = 534;
        objectArray6[10] = 361;
        objectArray7[11] = 265;
        objectArray6[12] = 206;
        objectArray7[13] = 169;
        objectArray6[14] = 143;
        objectArray7[15] = 125;
        objectArray6[16] = 111;
        objectArray7[17] = 101;
        objectArray6[18] = 94;
        objectArray7[19] = 88;
        objectArray6[20] = 83;
        objectArray7[21] = 79;
        objectArray6[22] = 76;
        objectArray7[23] = 74;
        objectArray6[24] = 72;
        objectArray7[25] = 70;
        objectArray6[26] = 69;
        objectArray7[27] = 68;
        objectArray6[28] = 67;
        objectArray7[29] = 67;
        objectArray6[30] = 66;
        objectArray7[31] = 66;
        objectArray6[32] = 66;
        objectArray7[33] = 66;
        biggestBinomials = objectArray;
        Object[] objectArray8 = objectArray = (Object[])new int[31];
        Object[] objectArray9 = objectArray;
        objectArray8[0] = -1 >>> 1;
        objectArray9[1] = -1 >>> 1;
        objectArray8[2] = -1 >>> 1;
        objectArray9[3] = 2642246;
        objectArray8[4] = 86251;
        objectArray9[5] = 11724;
        objectArray8[6] = 3218;
        objectArray9[7] = 1313;
        objectArray8[8] = 684;
        objectArray9[9] = 419;
        objectArray8[10] = 287;
        objectArray9[11] = 214;
        objectArray8[12] = 169;
        objectArray9[13] = 139;
        objectArray8[14] = 119;
        objectArray9[15] = 105;
        objectArray8[16] = 95;
        objectArray9[17] = 87;
        objectArray8[18] = 81;
        objectArray9[19] = 76;
        objectArray8[20] = 73;
        objectArray9[21] = 70;
        objectArray8[22] = 68;
        objectArray9[23] = 66;
        objectArray8[24] = 64;
        objectArray9[25] = 63;
        objectArray8[26] = 62;
        objectArray9[27] = 62;
        objectArray8[28] = 61;
        objectArray9[29] = 61;
        objectArray9[30] = 61;
        biggestSimpleBinomials = objectArray;
        n10 = 7;
        object = new long[n10][];
        int n11 = 2;
        long[] lArray5 = new long[n11];
        lArray5[0] = 291830L;
        lArray5[1] = 126401071349994536L;
        object[0] = (long)lArray5;
        int n12 = 3;
        long[] lArray6 = lArray2 = new long[n12];
        lArray2[0] = 885594168L;
        lArray6[1] = 725270293939359937L;
        lArray6[2] = 3569819667048198375L;
        object[1] = (long)lArray2;
        int n13 = 4;
        long[] lArray7 = lArray = new long[n13];
        long[] lArray8 = lArray;
        lArray7[0] = 273919523040L;
        lArray8[1] = 15;
        lArray7[2] = 7363882082L;
        lArray8[3] = 992620450144556L;
        object[n11] = (long)lArray;
        n11 = 5;
        long[] lArray9 = lArray = new long[n11];
        long[] lArray10 = lArray;
        lArray9[0] = 47636622961200L;
        lArray10[1] = 2;
        lArray9[2] = 2570940L;
        lArray10[3] = 211991001L;
        lArray10[4] = 3749873356L;
        object[n12] = (long)lArray;
        n12 = 6;
        long[] lArray11 = lArray = new long[n12];
        long[] lArray12 = lArray;
        lArray11[0] = 7999252175582850L;
        lArray12[1] = 2;
        lArray11[2] = 4130806001517L;
        lArray12[3] = 149795463772692060L;
        lArray11[4] = 186635894390467037L;
        lArray12[5] = 3967304179347715805L;
        object[n13] = (long)lArray;
        Object[] objectArray10 = objectArray = (Object[])new long[n10];
        Object[] objectArray11 = objectArray;
        objectArray10[0] = (byte)585226005592931976L;
        objectArray11[1] = (byte)2;
        objectArray10[2] = (byte)123635709730000L;
        objectArray11[3] = (byte)9233062284813009L;
        objectArray10[4] = (byte)43835965440333360L;
        objectArray11[5] = (byte)761179012939631437L;
        objectArray11[6] = (byte)1263739024124850375L;
        object[n11] = (long)objectArray;
        Object[] objectArray12 = objectArray = (Object[])new long[8];
        Object[] objectArray13 = objectArray;
        objectArray12[0] = (byte)Long.MAX_VALUE;
        objectArray13[1] = (byte)2;
        objectArray12[2] = (byte)325L;
        objectArray13[3] = (byte)9375L;
        objectArray12[4] = (byte)28178L;
        objectArray13[5] = (byte)450775L;
        objectArray12[6] = (byte)9780504L;
        objectArray13[7] = (byte)1795265022L;
        object[n12] = (long)objectArray;
        millerRabinBaseSets = (long[][])object;
    }

    private LongMath() {
    }

    public static long binomial(int n10, int n11) {
        MathPreconditions.checkNonNegative("n", n10);
        Object object = "k";
        MathPreconditions.checkNonNegative((String)object, n11);
        Object object2 = 1;
        int n12 = n11 <= n10 ? object2 : 0;
        String string2 = "k (%s) > n (%s)";
        Preconditions.checkArgument(n12 != 0, string2, n11, n10);
        n12 = n10 >> 1;
        if (n11 > n12) {
            n11 = n10 - n11;
        }
        long l10 = 1L;
        if (n11 != 0) {
            if (n11 != object2) {
                object = factorials;
                int n13 = ((Object)object).length;
                if (n10 < n13) {
                    l10 = (long)object[n10];
                    reference var9_8 = object[n11];
                    Object object3 = object[n10 -= n11];
                    return l10 / (var9_8 *= object3);
                }
                object = biggestBinomials;
                n13 = ((Object)object).length;
                if (n11 < n13 && n10 <= (object2 = (Object)object[n11])) {
                    int n14;
                    object = biggestSimpleBinomials;
                    n13 = ((Object)object).length;
                    if (n11 < n13 && n10 <= (object2 = (Object)object[n11])) {
                        object2 = n10 + -1;
                        l10 = n10;
                        for (n14 = 2; n14 <= n11; ++n14) {
                            long l11 = object2;
                            l10 *= l11;
                            l11 = n14;
                            l10 /= l11;
                            object2 += -1;
                        }
                        return l10;
                    }
                    long l12 = n10;
                    object = RoundingMode.CEILING;
                    object2 = LongMath.log2(l12, (RoundingMode)((Object)object));
                    n10 += -1;
                    Object object4 = object2;
                    int n15 = n14;
                    long l13 = l12;
                    l12 = l10;
                    while (n15 <= n11) {
                        Object object5 = 63;
                        if ((object4 += object2) < object5) {
                            long l14 = n10;
                            l13 *= l14;
                            l14 = n15;
                            l12 *= l14;
                        } else {
                            l10 = LongMath.multiplyFraction(l10, l13, l12);
                            l13 = n10;
                            l12 = n15;
                            object4 = object2;
                        }
                        ++n15;
                        n10 += -1;
                    }
                    return LongMath.multiplyFraction(l10, l13, l12);
                }
                return Long.MAX_VALUE;
            }
            return n10;
        }
        return l10;
    }

    public static long ceilingPowerOfTwo(long l10) {
        Object object = "x";
        MathPreconditions.checkPositive((String)object, l10);
        long l11 = 0x4000000000000000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 <= 0) {
            l11 = 1L;
            int n10 = -Long.numberOfLeadingZeros(l10 - l11);
            return l11 << n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ceilingPowerOfTwo(");
        stringBuilder.append(l10);
        stringBuilder.append(") is not representable as a long");
        String string2 = stringBuilder.toString();
        object = new ArithmeticException(string2);
        throw object;
    }

    public static long checkedAdd(long l10, long l11) {
        long l12 = l10 + l11;
        long l13 = l10 ^ l11;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n10 = 1;
        l15 = l15 < 0 ? (long)n10 : (long)0;
        long l16 = l10 ^ l12;
        long l17 = l16 - l14;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object < 0) {
            n10 = 0;
        }
        MathPreconditions.checkNoOverflow((l15 | n10) != 0, "checkedAdd", l10, l11);
        return l12;
    }

    public static long checkedMultiply(long l10, long l11) {
        int n10;
        long l12;
        int n11 = Long.numberOfLeadingZeros(l10);
        int n12 = Long.numberOfLeadingZeros(l10 ^ (long)-1);
        n11 += n12;
        n12 = Long.numberOfLeadingZeros(l11);
        n11 += n12;
        long l13 = l11 ^ (long)-1;
        n12 = Long.numberOfLeadingZeros(l13);
        if ((n11 += n12) > (n12 = 65)) {
            return l10 * l11;
        }
        n12 = 64;
        int n13 = 1;
        int n14 = n11 >= n12 ? n13 : 0;
        String string2 = "checkedMultiply";
        MathPreconditions.checkNoOverflow(n14 != 0, string2, l10, l11);
        long l14 = 0L;
        n11 = (int)(l10 == l14 ? 0 : (l10 < l14 ? -1 : 1));
        n12 = n11 >= 0 ? n13 : 0;
        long l15 = Long.MIN_VALUE;
        n14 = (int)(l11 == l15 ? 0 : (l11 < l15 ? -1 : 1));
        n14 = n14 != 0 ? n13 : 0;
        boolean bl2 = n12 | n14;
        String string3 = "checkedMultiply";
        MathPreconditions.checkNoOverflow(bl2, string3, l10, l11);
        l15 = l10 * l11;
        if (n11 != 0 && (n11 = (int)((l12 = (l14 = l15 / l10) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            n10 = 0;
            string3 = null;
        } else {
            n10 = n13;
        }
        MathPreconditions.checkNoOverflow(n10 != 0, "checkedMultiply", l10, l11);
        return l15;
    }

    public static long checkedPow(long l10, int n10) {
        Object object = "exponent";
        MathPreconditions.checkNonNegative((String)object, n10);
        long l11 = -2;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = null;
        int n11 = 1;
        if (l12 >= 0) {
            l12 = n11;
        } else {
            l12 = 0;
            object = null;
        }
        long l13 = 2;
        Object object2 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        object2 = object2 <= 0 ? (Object)n11 : (Object)0;
        l12 = l12 & object2;
        l13 = 1L;
        if (l12 != false) {
            l12 = (int)l10;
            object2 = -2;
            long l14 = -1;
            if (l12 != object2) {
                object2 = -1;
                if (l12 != object2) {
                    if (l12 != false) {
                        if (l12 != n11) {
                            object2 = 2;
                            if (l12 == object2) {
                                l12 = 63;
                                if (n10 < l12) {
                                    l12 = n11;
                                } else {
                                    l12 = 0;
                                    object = null;
                                }
                                long l15 = n10;
                                long l16 = l10;
                                MathPreconditions.checkNoOverflow((boolean)l12, "checkedPow", l10, l15);
                                return l13 << n10;
                            }
                            object = new AssertionError();
                            throw object;
                        }
                        return l13;
                    }
                    if (n10 != 0) {
                        l13 = 0L;
                    }
                    return l13;
                }
                l12 = n10 & 1;
                if (l12 != false) {
                    l13 = l14;
                }
                return l13;
            }
            l12 = 64;
            if (n10 < l12) {
                l12 = n11;
            } else {
                l12 = 0;
                object = null;
            }
            long l17 = n10;
            string2 = "checkedPow";
            long l18 = l10;
            MathPreconditions.checkNoOverflow((boolean)l12, string2, l10, l17);
            l12 = n10 & 1;
            l11 = l12 == false ? l13 << n10 : l14 << n10;
            return l11;
        }
        long l19 = l10;
        int n12 = n10;
        while (n12 != 0) {
            if (n12 != n11) {
                l12 = n12 & 1;
                if (l12 != false) {
                    l13 = LongMath.checkedMultiply(l13, l19);
                }
                long l20 = l13;
                l12 = n12 >> 1;
                if (l12 > 0) {
                    long l21;
                    long l22 = -3037000499L;
                    long l23 = l22 - l19;
                    object2 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
                    object2 = object2 <= 0 && (object2 = (l21 = l19 - (l22 = 3037000499L)) == 0L ? 0 : (l21 < 0L ? -1 : 1)) <= 0 ? (Object)n11 : (Object)0;
                    long l24 = l12;
                    String string3 = "checkedPow";
                    l13 = l19;
                    MathPreconditions.checkNoOverflow((boolean)object2, string3, l19, l24);
                    l19 *= l19;
                }
                n12 = (int)l12;
                l13 = l20;
                continue;
            }
            return LongMath.checkedMultiply(l13, l19);
        }
        return l13;
    }

    public static long checkedSubtract(long l10, long l11) {
        long l12 = l10 - l11;
        long l13 = l10 ^ l11;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n10 = 1;
        l15 = l15 >= 0 ? (long)n10 : (long)0;
        long l16 = l10 ^ l12;
        long l17 = l16 - l14;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object < 0) {
            n10 = 0;
        }
        MathPreconditions.checkNoOverflow((l15 | n10) != 0, "checkedSubtract", l10, l11);
        return l12;
    }

    /*
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     */
    public static long divide(long l10, long l11, RoundingMode roundingMode) {
        Preconditions.checkNotNull((Object)roundingMode);
        long l12 = l10 / l11;
        long l13 = l11 * l12;
        l13 = l10 - l13;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (l15 == false) {
            return l12;
        }
        l10 = (l10 ^ l11) >> 63;
        int n10 = (int)l10;
        int n11 = 1;
        n10 |= n11;
        int[] nArray = LongMath$1.$SwitchMap$java$math$RoundingMode;
        int n12 = roundingMode.ordinal();
        int n13 = nArray[n12];
        n12 = 0;
        int n14 = 0;
        block8: do {
            switch (n14 == 0 ? n13 : n14) {
                default: {
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                case 6: 
                case 7: 
                case 8: {
                    l13 = Math.abs(l13);
                    l11 = Math.abs(l11) - l13;
                    long l16 = (l13 -= l11) - l14;
                    long l17 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (l17 == false) {
                        int n15;
                        RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                        if (roundingMode == roundingMode2) {
                            l17 = n11;
                        } else {
                            l17 = 0;
                            roundingMode2 = null;
                        }
                        RoundingMode roundingMode3 = RoundingMode.HALF_EVEN;
                        if (roundingMode == roundingMode3) {
                            n15 = n11;
                        } else {
                            n15 = 0;
                            roundingMode3 = null;
                        }
                        l13 = 1L & l12;
                        long l18 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                        if (l18 == false) {
                            n11 = 0;
                        }
                        n11 = n11 & n15 | l17;
                        break;
                    }
                    n14 = 2;
                    if (l17 <= 0) continue block8;
                    break;
                }
                case 5: {
                    n14 = 2;
                    if (n10 <= 0) continue block8;
                    break;
                }
                case 3: {
                    n14 = 2;
                    if (n10 >= 0) continue block8;
                    break;
                }
                case 1: {
                    if (l15 != false) {
                        n11 = 0;
                    }
                    MathPreconditions.checkRoundingUnnecessary(n11 != 0);
                }
                case 2: {
                    n11 = 0;
                    break;
                }
                case 4: 
            }
            break;
        } while (true);
        if (n11 != 0) {
            l10 = n10;
            l12 += l10;
        }
        return l12;
    }

    public static long factorial(int n10) {
        MathPreconditions.checkNonNegative("n", n10);
        long[] lArray = factorials;
        int n11 = lArray.length;
        long l10 = n10 < n11 ? lArray[n10] : Long.MAX_VALUE;
        return l10;
    }

    public static boolean fitsInInt(long l10) {
        int n10 = (int)l10;
        long l11 = n10;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static long floorPowerOfTwo(long l10) {
        MathPreconditions.checkPositive("x", l10);
        int n10 = Long.numberOfLeadingZeros(l10);
        n10 = 63 - n10;
        return 1L << n10;
    }

    public static long gcd(long l10, long l11) {
        MathPreconditions.checkNonNegative("a", l10);
        String string2 = "b";
        MathPreconditions.checkNonNegative(string2, l11);
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 == false) {
            return l11;
        }
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object == false) {
            return l10;
        }
        object = Long.numberOfTrailingZeros(l10);
        l10 >>= object;
        int n10 = Long.numberOfTrailingZeros(l11);
        l11 >>= n10;
        while ((l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) != false) {
            long l14 = (l10 -= l11) >> 63 & l10;
            l10 = l10 - l14 - l14;
            l11 += l14;
            l13 = Long.numberOfTrailingZeros(l10);
            l10 >>= l13;
        }
        int n11 = Math.min((int)object, n10);
        return l10 << n11;
    }

    public static boolean isPowerOfTwo(long l10) {
        long l11;
        long l12;
        long l13;
        long l14 = 0L;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        int n10 = 1;
        l15 = l15 > 0 ? (long)n10 : (long)0;
        if ((l13 = (l12 = (l10 &= (l11 = l10 - 1L)) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            n10 = 0;
        }
        return (l15 & n10) != 0;
    }

    public static boolean isPrime(long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18;
        long l19 = 2;
        long l20 = l10 - l19;
        Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        if (object < 0) {
            MathPreconditions.checkNonNegative("n", l10);
            return false;
        }
        int n10 = 1;
        if (object != false && (object = (l18 = l10 - (l17 = (long)3)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != false && (object = (l16 = l10 - (l17 = (long)5)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false && (object = (l15 = l10 - (l17 = (long)7)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false && (object = (l14 = l10 - (l13 = (long)11)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (object = (l12 = l10 - (l11 = (long)13)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            long l21;
            long l22;
            long l23 = l10 % (long)30;
            int n11 = (int)l23;
            object = 0xDF75D77D & (n11 = n10 << n11);
            if (object != false) {
                return false;
            }
            l23 = 0L;
            long l24 = (l17 = l10 % l17) - l23;
            object = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
            if (object != false && (object = (l22 = (l17 = l10 % l13) - l23) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false && (object = (l21 = (l17 = l10 % l11) - l23) == 0L ? 0 : (l21 < 0L ? -1 : 1)) != false) {
                l17 = 289L;
                long l25 = l10 - l17;
                object = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
                if (object < 0) {
                    return n10 != 0;
                }
                long[][] lArray = millerRabinBaseSets;
                int n12 = lArray.length;
                for (int i10 = 0; i10 < n12; ++i10) {
                    long[] lArray2 = lArray[i10];
                    long l26 = lArray2[0];
                    long l27 = l10 - l26;
                    Object object2 = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
                    if (object2 > 0) continue;
                    for (object = (Object)n10; object < (n12 = lArray2.length); ++object) {
                        l17 = lArray2[object];
                        n12 = (int)(LongMath$MillerRabinTester.test(l17, l10) ? 1 : 0);
                        if (n12 != 0) continue;
                        return false;
                    }
                    return n10 != 0;
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            return false;
        }
        return n10 != 0;
    }

    public static int lessThanBranchFree(long l10, long l11) {
        return (int)((l10 - l11 ^ (long)-1 ^ (long)-1) >>> 63);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int log10(long l10, RoundingMode object) {
        String string2 = "x";
        MathPreconditions.checkPositive(string2, l10);
        int n10 = LongMath.log10Floor(l10);
        long l11 = powersOf10[n10];
        int[] nArray = LongMath$1.$SwitchMap$java$math$RoundingMode;
        int n11 = ((Enum)object).ordinal();
        n11 = nArray[n11];
        switch (n11) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                long[] lArray = halfPowersOf10;
                long l12 = lArray[n10];
                int n12 = LongMath.lessThanBranchFree(l12, l10);
                return n10 + n12;
            }
            case 4: 
            case 5: {
                int n12 = LongMath.lessThanBranchFree(l11, l10);
                return n10 + n12;
            }
            case 1: {
                long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l13 == false) {
                    l13 = 1;
                } else {
                    l13 = 0;
                    Object var9_9 = null;
                }
                MathPreconditions.checkRoundingUnnecessary((boolean)l13);
            }
            case 2: 
            case 3: 
        }
        return n10;
    }

    public static int log10Floor(long l10) {
        byte[] byArray = maxLog10ForLeadingZeros;
        int n10 = Long.numberOfLeadingZeros(l10);
        byte by2 = byArray[n10];
        long l11 = powersOf10[by2];
        int n11 = LongMath.lessThanBranchFree(l10, l11);
        return by2 - n11;
    }

    public static int log2(long l10, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", l10);
        int[] nArray = LongMath$1.$SwitchMap$java$math$RoundingMode;
        int n10 = roundingMode.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                AssertionError assertionError = new AssertionError((Object)"impossible");
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                n10 = Long.numberOfLeadingZeros(l10);
                long l11 = -5402926248376769404L >>> n10;
                n10 = 63 - n10;
                int n11 = LongMath.lessThanBranchFree(l11, l10);
                return n10 + n11;
            }
            case 4: 
            case 5: {
                int n12 = Long.numberOfLeadingZeros(l10 - 1L);
                return 64 - n12;
            }
            case 1: {
                n10 = (int)(LongMath.isPowerOfTwo(l10) ? 1 : 0);
                MathPreconditions.checkRoundingUnnecessary(n10 != 0);
            }
            case 2: 
            case 3: 
        }
        int n13 = Long.numberOfLeadingZeros(l10);
        return 63 - n13;
    }

    public static long mean(long l10, long l11) {
        long l12 = l10 & l11;
        l10 = (l10 ^ l11) >> 1;
        return l12 + l10;
    }

    public static int mod(long l10, int n10) {
        long l11 = n10;
        return (int)LongMath.mod(l10, l11);
    }

    public static long mod(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            long l14 = (l10 %= l11) - l12;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 < 0) {
                l10 += l11;
            }
            return l10;
        }
        ArithmeticException arithmeticException = new ArithmeticException("Modulus must be positive");
        throw arithmeticException;
    }

    public static long multiplyFraction(long l10, long l11, long l12) {
        long l13 = 1L;
        long l14 = l10 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return l11 / l12;
        }
        l13 = LongMath.gcd(l10, l12);
        return (l10 /= l13) * (l11 /= (l12 /= l13));
    }

    public static long pow(long l10, int n10) {
        double d10;
        long l11;
        String string2 = "exponent";
        MathPreconditions.checkNonNegative(string2, n10);
        long l12 = -2;
        Object object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        int n11 = 1;
        long l13 = 1L;
        double d11 = Double.MIN_VALUE;
        if (object <= 0) {
            l11 = 2;
            d10 = 1.0E-323;
            object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object <= 0) {
                int n12 = (int)l10;
                int n13 = -2;
                object = 64;
                l11 = 0L;
                d10 = 0.0;
                if (n12 != n13) {
                    n13 = -1;
                    if (n12 != n13) {
                        if (n12 != 0) {
                            if (n12 != n11) {
                                n13 = 2;
                                if (n12 == n13) {
                                    if (n10 < object) {
                                        l11 = l13 << n10;
                                    }
                                    return l11;
                                }
                                AssertionError assertionError = new AssertionError();
                                throw assertionError;
                            }
                            return l13;
                        }
                        if (n10 != 0) {
                            l13 = l11;
                            d11 = d10;
                        }
                        return l13;
                    }
                    n12 = n10 & 1;
                    if (n12 != 0) {
                        l13 = -1;
                        d11 = 0.0 / 0.0;
                    }
                    return l13;
                }
                if (n10 < object) {
                    n12 = n10 & 1;
                    l10 = n12 == 0 ? l13 << n10 : -(l13 << n10);
                    return l10;
                }
                return l11;
            }
        }
        l11 = l13;
        d10 = d11;
        while (n10 != 0) {
            if (n10 != n11) {
                object = n10 & 1;
                long l14 = object == false ? l13 : l10;
                l11 *= l14;
                l10 *= l10;
                n10 >>= 1;
                continue;
            }
            l11 *= l10;
            break;
        }
        return l11;
    }

    public static long saturatedAdd(long l10, long l11) {
        long l12 = l10 + l11;
        long l13 = 0L;
        long l14 = (l11 ^= l10) - l13;
        long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        int n10 = 1;
        l15 = l15 < 0 ? (long)n10 : (long)0;
        long l16 = (l10 ^= l12) - l13;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object < 0) {
            n10 = 0;
        }
        object = l15 | n10;
        if (object != false) {
            return l12;
        }
        return (l12 >>> 63 ^ 1L) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long l10, long l11) {
        long l12;
        long l13;
        int n10 = Long.numberOfLeadingZeros(l10);
        int n11 = Long.numberOfLeadingZeros(l10 ^ (long)-1);
        n10 += n11;
        n11 = Long.numberOfLeadingZeros(l11);
        n10 += n11;
        long l14 = l11 ^ (long)-1;
        n11 = Long.numberOfLeadingZeros(l14);
        if ((n10 += n11) > (n11 = 65)) {
            return l10 * l11;
        }
        l14 = Long.MAX_VALUE;
        long l15 = ((l10 ^ l11) >>> 63) + l14;
        n11 = 64;
        int n12 = 1;
        n10 = n10 < n11 ? n12 : 0;
        long l16 = 0L;
        n11 = (int)(l10 == l16 ? 0 : (l10 < l16 ? -1 : 1));
        int n13 = n11 < 0 ? n12 : 0;
        long l17 = Long.MIN_VALUE;
        long l18 = l11 - l17;
        Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object != false) {
            n12 = 0;
        }
        if ((n10 |= (n12 &= n13)) != 0) {
            return l15;
        }
        long l19 = l10 * l11;
        if (n11 != 0 && (l13 = (l12 = (l10 = l19 / l10) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            return l15;
        }
        return l19;
    }

    public static long saturatedPow(long l10, int n10) {
        String string2 = "exponent";
        MathPreconditions.checkNonNegative(string2, n10);
        long l11 = -2;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n11 = 1;
        if (object >= 0) {
            object = n11;
        } else {
            object = 0;
            string2 = null;
        }
        long l12 = 2;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        l13 = l13 <= 0 ? (long)n11 : (long)0;
        object = object & l13;
        l13 = 63;
        long l14 = Long.MAX_VALUE;
        long l15 = 1L;
        if (object != false) {
            int n12 = (int)l10;
            int n13 = -2;
            l11 = -1;
            if (n12 != n13) {
                n13 = -1;
                if (n12 != n13) {
                    if (n12 != 0) {
                        if (n12 != n11) {
                            n13 = 2;
                            if (n12 == n13) {
                                if (n10 >= l13) {
                                    return l14;
                                }
                                return l15 << n10;
                            }
                            AssertionError assertionError = new AssertionError();
                            throw assertionError;
                        }
                        return l15;
                    }
                    if (n10 != 0) {
                        l15 = 0L;
                    }
                    return l15;
                }
                n12 = n10 & 1;
                if (n12 != 0) {
                    l15 = l11;
                }
                return l15;
            }
            n12 = 64;
            if (n10 >= n12) {
                return (long)(n10 & 1) + l14;
            }
            n12 = n10 & 1;
            l10 = n12 == 0 ? l15 << n10 : l11 << n10;
            return l10;
        }
        long l16 = l10 >>> l13;
        object = n10 & 1;
        long l17 = object;
        l16 = (l16 & l17) + l14;
        while (n10 != 0) {
            if (n10 != n11) {
                object = n10 & 1;
                if (object != false) {
                    l15 = l12 = LongMath.saturatedMultiply(l15, l10);
                }
                if ((n10 >>= 1) <= 0) continue;
                l12 = -3037000499L;
                long l18 = l12 - l10;
                object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object > 0) {
                    object = n11;
                } else {
                    object = 0;
                    string2 = null;
                }
                l12 = 3037000499L;
                l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                l13 = l13 > 0 ? (long)n11 : (long)0;
                object = object | l13;
                if (object != false) {
                    return l16;
                }
                l10 *= l10;
                continue;
            }
            return LongMath.saturatedMultiply(l15, l10);
        }
        return l15;
    }

    public static long saturatedSubtract(long l10, long l11) {
        long l12 = l10 - l11;
        long l13 = 0L;
        long l14 = (l11 ^= l10) - l13;
        long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        int n10 = 1;
        l15 = l15 >= 0 ? (long)n10 : (long)0;
        long l16 = (l10 ^= l12) - l13;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object < 0) {
            n10 = 0;
        }
        object = l15 | n10;
        if (object != false) {
            return l12;
        }
        return (l12 >>> 63 ^ 1L) + Long.MAX_VALUE;
    }

    public static long sqrt(long l10, RoundingMode roundingMode) {
        String string2 = "x";
        MathPreconditions.checkNonNegative(string2, l10);
        boolean bl2 = LongMath.fitsInInt(l10);
        if (bl2) {
            return IntMath.sqrt((int)l10, roundingMode);
        }
        double d10 = Math.sqrt(l10);
        long l11 = (long)d10;
        long l12 = l11 * l11;
        int[] nArray = LongMath$1.$SwitchMap$java$math$RoundingMode;
        int n10 = roundingMode.ordinal();
        n10 = nArray[n10];
        long l13 = 1L;
        boolean bl3 = true;
        switch (n10) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                n10 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
                if (n10 >= 0) {
                    bl3 = false;
                }
                l12 = (long)bl3;
                l10 = LongMath.lessThanBranchFree((l11 -= l12) * l11 + l11, l10);
                return l11 + l10;
            }
            case 4: 
            case 5: {
                long l14 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (l14 > 0) {
                    l11 += l13;
                }
                return l11;
            }
            case 2: 
            case 3: {
                long l15 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (l15 < 0) {
                    l11 -= l13;
                }
                return l11;
            }
            case 1: 
        }
        long l16 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (l16 != false) {
            bl3 = false;
        }
        MathPreconditions.checkRoundingUnnecessary(bl3);
        return l11;
    }
}


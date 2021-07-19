/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath$1;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public final class IntMath {
    public static final int FLOOR_SQRT_MAX_INT = 46340;
    public static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    public static final int MAX_SIGNED_POWER_OF_TWO = 0x40000000;
    public static int[] biggestBinomials;
    private static final int[] factorials;
    public static final int[] halfPowersOf10;
    public static final byte[] maxLog10ForLeadingZeros;
    public static final int[] powersOf10;

    static {
        int[] nArray;
        Object[] objectArray;
        byte[] byArray = objectArray = new byte[33];
        byte[] byArray2 = objectArray;
        byArray[0] = 9;
        byArray2[1] = 9;
        byArray[2] = 9;
        byArray2[3] = 8;
        byArray[4] = 8;
        byArray2[5] = 8;
        byArray[6] = 7;
        byArray2[7] = 7;
        byArray[8] = 7;
        byArray2[9] = 6;
        byArray[10] = 6;
        byArray2[11] = 6;
        byArray[12] = 6;
        byArray2[13] = 5;
        byArray[14] = 5;
        byArray2[15] = 5;
        byArray[16] = 4;
        byArray2[17] = 4;
        byArray[18] = 4;
        byArray2[19] = 3;
        byArray[20] = 3;
        byArray2[21] = 3;
        byArray[22] = 3;
        byArray2[23] = 2;
        byArray[24] = 2;
        byArray2[25] = 2;
        byArray[26] = 1;
        byArray2[27] = 1;
        byArray[28] = 1;
        byArray2[29] = 0;
        byArray[30] = 0;
        byArray2[31] = 0;
        byArray2[32] = 0;
        maxLog10ForLeadingZeros = objectArray;
        int n10 = 10;
        int[] nArray2 = nArray = new int[n10];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 10;
        nArray2[2] = 100;
        nArray3[3] = 1000;
        nArray2[4] = 10000;
        nArray3[5] = 100000;
        nArray2[6] = 1000000;
        nArray3[7] = 10000000;
        nArray2[8] = 100000000;
        nArray3[9] = 1000000000;
        powersOf10 = nArray;
        Object[] objectArray2 = objectArray = (Object[])new int[n10];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = 3;
        objectArray3[1] = 31;
        objectArray2[2] = 316;
        objectArray3[3] = 3162;
        objectArray2[4] = 31622;
        objectArray3[5] = 316227;
        objectArray2[6] = 3162277;
        objectArray3[7] = 31622776;
        objectArray2[8] = 316227766;
        objectArray3[9] = -1 >>> 1;
        halfPowersOf10 = objectArray;
        Object[] objectArray4 = objectArray = (Object[])new int[13];
        Object[] objectArray5 = objectArray;
        objectArray4[0] = 1;
        objectArray5[1] = 1;
        objectArray4[2] = 2;
        objectArray5[3] = 6;
        objectArray4[4] = 24;
        objectArray5[5] = 120;
        objectArray4[6] = 720;
        objectArray5[7] = 5040;
        objectArray4[8] = 40320;
        objectArray5[9] = 362880;
        objectArray4[10] = 3628800;
        objectArray5[11] = 39916800;
        objectArray5[12] = 479001600;
        factorials = objectArray;
        Object[] objectArray6 = objectArray = (Object[])new int[17];
        Object[] objectArray7 = objectArray;
        objectArray6[0] = -1 >>> 1;
        objectArray7[1] = -1 >>> 1;
        objectArray6[2] = 65536;
        objectArray7[3] = 2345;
        objectArray6[4] = 477;
        objectArray7[5] = 193;
        objectArray6[6] = 110;
        objectArray7[7] = 75;
        objectArray6[8] = 58;
        objectArray7[9] = 49;
        objectArray6[10] = 43;
        objectArray7[11] = 39;
        objectArray6[12] = 37;
        objectArray7[13] = 35;
        objectArray6[14] = 34;
        objectArray7[15] = 34;
        objectArray7[16] = 33;
        biggestBinomials = objectArray;
    }

    private IntMath() {
    }

    public static int binomial(int n10, int n11) {
        int n12;
        int[] nArray;
        int n13;
        MathPreconditions.checkNonNegative("n", n10);
        MathPreconditions.checkNonNegative("k", n11);
        int n14 = 0;
        int n15 = 1;
        if (n11 <= n10) {
            n13 = n15;
        } else {
            n13 = 0;
            nArray = null;
        }
        String string2 = "k (%s) > n (%s)";
        Preconditions.checkArgument(n13 != 0, string2, n11, n10);
        n13 = n10 >> 1;
        if (n11 > n13) {
            n11 = n10 - n11;
        }
        if (n11 < (n12 = (nArray = biggestBinomials).length) && n10 <= (n13 = nArray[n11])) {
            if (n11 != 0) {
                if (n11 != n15) {
                    long l10 = 1L;
                    while (n14 < n11) {
                        n12 = n10 - n14;
                        long l11 = n12;
                        l10 *= l11;
                        l11 = ++n14;
                        l10 /= l11;
                    }
                    n10 = (int)l10;
                }
                return n10;
            }
            return n15;
        }
        return -1 >>> 1;
    }

    public static int ceilingPowerOfTwo(int n10) {
        Object object = "x";
        MathPreconditions.checkPositive((String)object, n10);
        int n11 = 0x40000000;
        if (n10 <= n11) {
            n11 = 1;
            n10 = -Integer.numberOfLeadingZeros(n10 - n11);
            return n11 << n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ceilingPowerOfTwo(");
        stringBuilder.append(n10);
        stringBuilder.append(") not representable as an int");
        String string2 = stringBuilder.toString();
        object = new ArithmeticException(string2);
        throw object;
    }

    public static int checkedAdd(int n10, int n11) {
        int n12;
        long l10;
        long l11;
        long l12;
        long l13 = n10;
        long l14 = n11;
        l12 = (l12 = (l11 = (l13 += l14) - (l10 = (long)(n12 = (int)l13))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false ? (long)1 : (long)0;
        MathPreconditions.checkNoOverflow((boolean)l12, "checkedAdd", n10, n11);
        return n12;
    }

    public static int checkedMultiply(int n10, int n11) {
        int n12;
        long l10;
        long l11;
        long l12;
        long l13 = n10;
        long l14 = n11;
        l12 = (l12 = (l11 = (l13 *= l14) - (l10 = (long)(n12 = (int)l13))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false ? (long)1 : (long)0;
        MathPreconditions.checkNoOverflow((boolean)l12, "checkedMultiply", n10, n11);
        return n12;
    }

    public static int checkedPow(int n10, int n11) {
        String string2 = "exponent";
        MathPreconditions.checkNonNegative(string2, n11);
        int n12 = -2;
        String string3 = "checkedPow";
        int n13 = -1;
        int n14 = 0;
        int n15 = 1;
        if (n10 != n12) {
            if (n10 != n13) {
                if (n10 != 0) {
                    if (n10 != n15) {
                        n12 = 2;
                        if (n10 != n12) {
                            n12 = n15;
                            while (n11 != 0) {
                                if (n11 != n15) {
                                    n13 = n11 & 1;
                                    if (n13 != 0) {
                                        n12 = IntMath.checkedMultiply(n12, n10);
                                    }
                                    if ((n11 >>= 1) <= 0) continue;
                                    n13 = -46340;
                                    n13 = n13 <= n10 ? n15 : 0;
                                    int n16 = 46340;
                                    n16 = n10 <= n16 ? n15 : 0;
                                    MathPreconditions.checkNoOverflow((n13 &= n16) != 0, string3, n10, n11);
                                    n10 *= n10;
                                    continue;
                                }
                                return IntMath.checkedMultiply(n12, n10);
                            }
                            return n12;
                        }
                        n12 = 31;
                        if (n11 < n12) {
                            n14 = n15;
                        }
                        MathPreconditions.checkNoOverflow(n14 != 0, string3, n10, n11);
                        return n15 << n11;
                    }
                    return n15;
                }
                if (n11 == 0) {
                    n14 = n15;
                }
                return n14;
            }
            n10 = n11 & 1;
            if (n10 == 0) {
                n13 = n15;
            }
            return n13;
        }
        n12 = 32;
        if (n11 < n12) {
            n14 = n15;
        }
        MathPreconditions.checkNoOverflow(n14 != 0, string3, n10, n11);
        n10 = n11 & 1;
        n10 = n10 == 0 ? n15 << n11 : n13 << n11;
        return n10;
    }

    public static int checkedSubtract(int n10, int n11) {
        int n12;
        long l10;
        long l11;
        long l12;
        long l13 = n10;
        long l14 = n11;
        l12 = (l12 = (l11 = (l13 -= l14) - (l10 = (long)(n12 = (int)l13))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false ? (long)1 : (long)0;
        MathPreconditions.checkNoOverflow((boolean)l12, "checkedSubtract", n10, n11);
        return n12;
    }

    /*
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     */
    public static int divide(int n10, int n11, RoundingMode roundingMode) {
        Preconditions.checkNotNull((Object)roundingMode);
        if (n11 == 0) {
            ArithmeticException arithmeticException = new ArithmeticException("/ by zero");
            throw arithmeticException;
        }
        int n12 = n10 / n11;
        int n13 = n11 * n12;
        if ((n13 = n10 - n13) == 0) {
            return n12;
        }
        n10 = (n10 ^ n11) >> 31;
        int n14 = 1;
        n10 |= n14;
        int[] nArray = IntMath$1.$SwitchMap$java$math$RoundingMode;
        int n15 = roundingMode.ordinal();
        int n16 = nArray[n15];
        n15 = 0;
        int n17 = 0;
        block8: do {
            switch (n17 == 0 ? n16 : n17) {
                default: {
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                case 6: 
                case 7: 
                case 8: {
                    n13 = Math.abs(n13);
                    n11 = Math.abs(n11) - n13;
                    if ((n13 -= n11) == 0) {
                        RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                        if (roundingMode == roundingMode2) break;
                        roundingMode2 = RoundingMode.HALF_EVEN;
                        if (roundingMode == roundingMode2) {
                            n11 = n14;
                        } else {
                            n11 = 0;
                            roundingMode2 = null;
                        }
                        int n18 = n12 & 1;
                        if (n18 != 0) {
                            n18 = n14;
                        } else {
                            n18 = 0;
                            roundingMode = null;
                        }
                        n17 = 2;
                        if ((n11 &= n18) == 0) continue block8;
                        break;
                    }
                    n17 = 2;
                    if (n13 <= 0) continue block8;
                    break;
                }
                case 5: {
                    n17 = 2;
                    if (n10 <= 0) continue block8;
                    break;
                }
                case 3: {
                    n17 = 2;
                    if (n10 >= 0) continue block8;
                    break;
                }
                case 1: {
                    if (n13 != 0) {
                        n14 = 0;
                    }
                    MathPreconditions.checkRoundingUnnecessary(n14 != 0);
                }
                case 2: {
                    n14 = 0;
                    break;
                }
                case 4: 
            }
            break;
        } while (true);
        if (n14 != 0) {
            n12 += n10;
        }
        return n12;
    }

    public static int factorial(int n10) {
        MathPreconditions.checkNonNegative("n", n10);
        int[] nArray = factorials;
        int n11 = nArray.length;
        n10 = n10 < n11 ? nArray[n10] : -1 >>> 1;
        return n10;
    }

    public static int floorPowerOfTwo(int n10) {
        MathPreconditions.checkPositive("x", n10);
        return Integer.highestOneBit(n10);
    }

    public static int gcd(int n10, int n11) {
        MathPreconditions.checkNonNegative("a", n10);
        String string2 = "b";
        MathPreconditions.checkNonNegative(string2, n11);
        if (n10 == 0) {
            return n11;
        }
        if (n11 == 0) {
            return n10;
        }
        int n12 = Integer.numberOfTrailingZeros(n10);
        n10 >>= n12;
        int n13 = Integer.numberOfTrailingZeros(n11);
        n11 >>= n13;
        while (n10 != n11) {
            int n14 = (n10 -= n11) >> 31 & n10;
            n10 = n10 - n14 - n14;
            n11 += n14;
            n14 = Integer.numberOfTrailingZeros(n10);
            n10 >>= n14;
        }
        n11 = Math.min(n12, n13);
        return n10 << n11;
    }

    public static boolean isPowerOfTwo(int n10) {
        int n11;
        boolean bl2 = false;
        boolean bl3 = true;
        boolean bl4 = n10 > 0 ? bl3 : false;
        if ((n10 &= (n11 = n10 + -1)) == 0) {
            bl2 = bl3;
        }
        return bl4 & bl2;
    }

    public static boolean isPrime(int n10) {
        return LongMath.isPrime(n10);
    }

    public static int lessThanBranchFree(int n10, int n11) {
        return ~(~(n10 - n11)) >>> 31;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int log10(int n10, RoundingMode object) {
        String string2 = "x";
        MathPreconditions.checkPositive(string2, n10);
        int n11 = IntMath.log10Floor(n10);
        int[] nArray = powersOf10;
        int n12 = nArray[n11];
        int[] nArray2 = IntMath$1.$SwitchMap$java$math$RoundingMode;
        int n14 = ((Enum)object).ordinal();
        n14 = nArray2[n14];
        switch (n14) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                int[] nArray3 = halfPowersOf10;
                int n15 = nArray3[n11];
                n10 = IntMath.lessThanBranchFree(n15, n10);
                return n11 + n10;
            }
            case 4: 
            case 5: {
                n10 = IntMath.lessThanBranchFree(n12, n10);
                return n11 + n10;
            }
            case 1: {
                if (n10 == n12) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    Object var8_12 = null;
                }
                MathPreconditions.checkRoundingUnnecessary(n10 != 0);
            }
            case 2: 
            case 3: 
        }
        return n11;
    }

    private static int log10Floor(int n10) {
        byte[] byArray = maxLog10ForLeadingZeros;
        int n11 = Integer.numberOfLeadingZeros(n10);
        byte by2 = byArray[n11];
        n11 = powersOf10[by2];
        n10 = IntMath.lessThanBranchFree(n10, n11);
        return by2 - n10;
    }

    public static int log2(int n10, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n10);
        int[] nArray = IntMath$1.$SwitchMap$java$math$RoundingMode;
        int n11 = roundingMode.ordinal();
        n11 = nArray[n11];
        switch (n11) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                n11 = Integer.numberOfLeadingZeros(n10);
                int n12 = -1257966797 >>> n11;
                n11 = 31 - n11;
                n10 = IntMath.lessThanBranchFree(n12, n10);
                return n11 + n10;
            }
            case 4: 
            case 5: {
                n10 = Integer.numberOfLeadingZeros(n10 + -1);
                return 32 - n10;
            }
            case 1: {
                n11 = (int)(IntMath.isPowerOfTwo(n10) ? 1 : 0);
                MathPreconditions.checkRoundingUnnecessary(n11 != 0);
            }
            case 2: 
            case 3: 
        }
        n10 = Integer.numberOfLeadingZeros(n10);
        return 31 - n10;
    }

    public static int mean(int n10, int n11) {
        int n12 = n10 & n11;
        n10 = (n10 ^ n11) >> 1;
        return n12 + n10;
    }

    public static int mod(int n10, int n11) {
        if (n11 > 0) {
            if ((n10 %= n11) < 0) {
                n10 += n11;
            }
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Modulus ");
        stringBuilder.append(n11);
        stringBuilder.append(" must be > 0");
        String string2 = stringBuilder.toString();
        ArithmeticException arithmeticException = new ArithmeticException(string2);
        throw arithmeticException;
    }

    public static int pow(int n10, int n11) {
        String string2 = "exponent";
        MathPreconditions.checkNonNegative(string2, n11);
        int n12 = -2;
        float f10 = 0.0f / 0.0f;
        int n13 = 32;
        int n14 = 0;
        int n15 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 != n12) {
            n12 = -1;
            f10 = 0.0f / 0.0f;
            if (n10 != n12) {
                if (n10 != 0) {
                    if (n10 != n15) {
                        n12 = 2;
                        f10 = 2.8E-45f;
                        if (n10 != n12) {
                            n12 = n15;
                            f10 = f11;
                            while (n11 != 0) {
                                if (n11 != n15) {
                                    n13 = n11 & 1;
                                    n13 = n13 == 0 ? n15 : n10;
                                    n12 *= n13;
                                    n10 *= n10;
                                    n11 >>= 1;
                                    continue;
                                }
                                return n10 * n12;
                            }
                            return n12;
                        }
                        if (n11 < n13) {
                            n14 = n15 << n11;
                        }
                        return n14;
                    }
                    return n15;
                }
                if (n11 == 0) {
                    n14 = n15;
                }
                return n14;
            }
            n10 = n11 & 1;
            if (n10 != 0) {
                n15 = n12;
                f11 = f10;
            }
            return n15;
        }
        if (n11 < n13) {
            n10 = n11 & 1;
            n10 = n10 == 0 ? n15 << n11 : -(n15 << n11);
            return n10;
        }
        return 0;
    }

    public static int saturatedAdd(int n10, int n11) {
        long l10 = n10;
        long l11 = n11;
        return Ints.saturatedCast(l10 + l11);
    }

    public static int saturatedMultiply(int n10, int n11) {
        long l10 = n10;
        long l11 = n11;
        return Ints.saturatedCast(l10 * l11);
    }

    public static int saturatedPow(int n10, int n11) {
        String string2 = "exponent";
        MathPreconditions.checkNonNegative(string2, n11);
        int n12 = -2;
        int n13 = -1 >>> 1;
        int n14 = -1;
        int n15 = 1;
        if (n10 != n12) {
            if (n10 != n14) {
                n12 = 0;
                string2 = null;
                if (n10 != 0) {
                    if (n10 != n15) {
                        n14 = 2;
                        if (n10 != n14) {
                            n14 = n10 >>> 31;
                            int n16 = n11 & 1;
                            n14 = (n14 & n16) + n13;
                            n13 = n15;
                            while (n11 != 0) {
                                if (n11 != n15) {
                                    n16 = n11 & 1;
                                    if (n16 != 0) {
                                        n13 = IntMath.saturatedMultiply(n13, n10);
                                    }
                                    if ((n11 >>= 1) <= 0) continue;
                                    n16 = -46340;
                                    n16 = n16 > n10 ? n15 : 0;
                                    int n17 = 46340;
                                    if ((n16 |= (n17 = n10 > n17 ? n15 : 0)) != 0) {
                                        return n14;
                                    }
                                    n10 *= n10;
                                    continue;
                                }
                                return IntMath.saturatedMultiply(n13, n10);
                            }
                            return n13;
                        }
                        n10 = 31;
                        if (n11 >= n10) {
                            return n13;
                        }
                        return n15 << n11;
                    }
                    return n15;
                }
                if (n11 != 0) {
                    n15 = 0;
                }
                return n15;
            }
            n10 = n11 & 1;
            if (n10 == 0) {
                n14 = n15;
            }
            return n14;
        }
        n10 = 32;
        if (n11 >= n10) {
            return (n11 & 1) + n13;
        }
        n10 = n11 & 1;
        n10 = n10 == 0 ? n15 << n11 : n14 << n11;
        return n10;
    }

    public static int saturatedSubtract(int n10, int n11) {
        long l10 = n10;
        long l11 = n11;
        return Ints.saturatedCast(l10 - l11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int sqrt(int n10, RoundingMode roundingMode) {
        String string2 = "x";
        MathPreconditions.checkNonNegative(string2, n10);
        int n11 = IntMath.sqrtFloor(n10);
        int[] nArray = IntMath$1.$SwitchMap$java$math$RoundingMode;
        int n12 = roundingMode.ordinal();
        n12 = nArray[n12];
        switch (n12) {
            default: {
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            case 6: 
            case 7: 
            case 8: {
                n12 = n11 * n11 + n11;
                n10 = IntMath.lessThanBranchFree(n12, n10);
                return n11 + n10;
            }
            case 4: 
            case 5: {
                n12 = n11 * n11;
                n10 = IntMath.lessThanBranchFree(n12, n10);
                return n11 + n10;
            }
            case 1: {
                n12 = n11 * n11;
                if (n12 == n10) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    Object var6_7 = null;
                }
                MathPreconditions.checkRoundingUnnecessary(n10 != 0);
            }
            case 2: 
            case 3: 
        }
        return n11;
    }

    private static int sqrtFloor(int n10) {
        return (int)Math.sqrt(n10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath$1;
import com.google.common.math.DoubleUtils;
import com.google.common.math.MathPreconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

public final class DoubleMath {
    private static final double LN_2 = 0.0;
    public static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18;
    public static final double[] everySixteenthFactorial;

    static {
        double[] dArray;
        LN_2 = Math.log(2.0);
        double[] dArray2 = dArray = new double[11];
        double[] dArray3 = dArray;
        dArray2[0] = 1.0;
        dArray3[1] = 2.0922789888E13;
        dArray2[2] = 2.631308369336935E35;
        dArray3[3] = 1.2413915592536073E61;
        dArray2[4] = 1.2688693218588417E89;
        dArray3[5] = 7.156945704626381E118;
        dArray2[6] = 9.916779348709496E149;
        dArray3[7] = 1.974506857221074E182;
        dArray2[8] = 3.856204823625804E215;
        dArray3[9] = 5.5502938327393044E249;
        dArray3[10] = 4.7147236359920616E284;
        everySixteenthFactorial = dArray;
    }

    private DoubleMath() {
    }

    private static double checkFinite(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return d10;
    }

    public static double factorial(int n10) {
        double d10;
        String string2 = "n";
        MathPreconditions.checkNonNegative(string2, n10);
        int n11 = 170;
        if (n10 > n11) {
            return 1.0 / 0.0;
        }
        double d11 = 1.0;
        int n12 = n10 & 0xFFFFFFF0;
        while (++n12 <= n10) {
            d10 = n12;
            d11 *= d10;
        }
        double[] dArray = everySixteenthFactorial;
        d10 = dArray[n10 >>= 4];
        return d11 * d10;
    }

    public static int fuzzyCompare(double d10, double d11, double d12) {
        Object object = DoubleMath.fuzzyEquals(d10, d11, d12);
        if (object != 0) {
            return 0;
        }
        object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        if (object < 0) {
            return -1;
        }
        object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object > 0) {
            return 1;
        }
        boolean bl2 = Double.isNaN(d10);
        boolean bl3 = Double.isNaN(d11);
        return Booleans.compare(bl2, bl3);
    }

    public static boolean fuzzyEquals(double d10, double d11, double d12) {
        boolean bl2;
        String string2 = "tolerance";
        MathPreconditions.checkNonNegative(string2, d12);
        double d13 = d10 - d11;
        double d14 = 1.0;
        d13 = Math.copySign(d13, d14);
        double d15 = d13 == d12 ? 0 : (d13 < d12 ? -1 : 1);
        bl2 = d15 <= 0 || (d15 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1)) == false || (bl2 = Double.isNaN(d10)) && (bl2 = Double.isNaN(d11));
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isMathematicalInteger(double d10) {
        int n10;
        boolean bl2 = DoubleUtils.isFinite(d10);
        if (!bl2) return 0 != 0;
        long l10 = 0L;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object == false) return 1 != 0;
        l10 = DoubleUtils.getSignificand(d10);
        int n12 = Long.numberOfTrailingZeros(l10);
        n12 = 52 - n12;
        if (n12 > (n10 = Math.getExponent(d10))) return 0 != 0;
        return 1 != 0;
    }

    public static boolean isPowerOfTwo(double d10) {
        double d11 = 0.0;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        boolean bl2 = false;
        if (d12 > 0 && (d12 = (double)DoubleUtils.isFinite(d10)) != false) {
            long l10 = DoubleUtils.getSignificand(d10);
            long l11 = l10 - 1L;
            long l12 = (l10 &= l11) - (l11 = 0L);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static double log2(double d10) {
        d10 = Math.log(d10);
        double d11 = LN_2;
        return d10 / d11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static int log2(double var0, RoundingMode var2_1) {
        var3_2 = 0.0;
        var5_3 = var0 == var3_2 ? 0 : (var0 > var3_2 ? 1 : -1);
        var6_4 = false;
        var7_5 = true;
        var5_3 = var5_3 > 0 && (var5_3 = (double)DoubleUtils.isFinite(var0)) != false ? (double)var7_5 : (double)false;
        var8_6 = "x must be positive and finite";
        Preconditions.checkArgument((boolean)var5_3, var8_6);
        var5_3 = Math.getExponent(var0);
        var9_7 = DoubleUtils.isNormal(var0);
        if (!var9_7) {
            return DoubleMath.log2(var0 * 1.0, var2_1) + -52;
        }
        var8_6 = DoubleMath$1.$SwitchMap$java$math$RoundingMode;
        var10_8 /* !! */  = var2_1.ordinal();
        var10_8 /* !! */  = (int)var8_6[var10_8 /* !! */ ];
        switch (var10_8 /* !! */ ) {
            default: {
                var11_9 = new AssertionError();
                throw var11_9;
            }
            case 6: 
            case 7: 
            case 8: {
                var0 = DoubleUtils.scaleNormalize(var0);
                var0 *= var0;
                var12_10 = 2.0;
                var14_11 = var0 == var12_10 ? 0 : (var0 > var12_10 ? 1 : -1);
                if (var14_11 <= 0) break;
                var6_4 = var7_5;
                break;
            }
            case 5: {
                if (var5_3 >= 0) {
                    var6_4 = var7_5;
                }
                var14_12 = DoubleMath.isPowerOfTwo(var0);
                ** GOTO lbl36
            }
            case 4: {
                if (var5_3 < 0) {
                    var6_4 = var7_5;
                }
                var14_12 = DoubleMath.isPowerOfTwo(var0);
lbl36:
                // 2 sources

                var6_4 &= (var14_12 ^= var7_5);
                break;
            }
            case 3: {
                var14_13 = DoubleMath.isPowerOfTwo(var0);
                var6_4 = var14_13 ^ true;
                break;
            }
            case 1: {
                var14_14 = DoubleMath.isPowerOfTwo(var0);
                MathPreconditions.checkRoundingUnnecessary(var14_14);
            }
            case 2: 
        }
        if (var6_4) {
            ++var5_3;
        }
        return (int)var5_3;
    }

    public static double mean(Iterable iterable) {
        return DoubleMath.mean(iterable.iterator());
    }

    public static double mean(Iterator iterator2) {
        boolean bl2;
        long l10;
        boolean bl3 = iterator2.hasNext();
        String string2 = "Cannot take mean of 0 values";
        Preconditions.checkArgument(bl3, string2);
        Number number = (Number)iterator2.next();
        double d10 = DoubleMath.checkFinite(number.doubleValue());
        long l11 = l10 = 1L;
        while (bl2 = iterator2.hasNext()) {
            Number number2 = (Number)iterator2.next();
            double d11 = DoubleMath.checkFinite(number2.doubleValue());
            d11 -= d10;
            double d12 = l11 += l10;
            d10 += (d11 /= d12);
        }
        return d10;
    }

    public static double mean(double ... dArray) {
        int n10;
        long l10;
        int n11;
        int n12 = dArray.length;
        n12 = n12 > 0 ? n11 : 0;
        String string2 = "Cannot take mean of 0 values";
        Preconditions.checkArgument(n12 != 0, string2);
        double d10 = DoubleMath.checkFinite(dArray[0]);
        long l11 = l10 = 1L;
        for (n11 = 1; n11 < (n10 = dArray.length); ++n11) {
            DoubleMath.checkFinite(dArray[n11]);
            double d11 = dArray[n11] - d10;
            double d12 = l11 += l10;
            d10 += (d11 /= d12);
        }
        return d10;
    }

    public static double mean(int ... nArray) {
        int n10 = nArray.length;
        n10 = n10 > 0 ? 1 : 0;
        String string2 = "Cannot take mean of 0 values";
        Preconditions.checkArgument(n10 != 0, string2);
        long l10 = 0L;
        double d10 = 0.0;
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            long l11 = n10;
            l10 += l11;
        }
        double d11 = l10;
        d10 = nArray.length;
        return d11 / d10;
    }

    public static double mean(long ... lArray) {
        int n10;
        long l10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        String string2 = "Cannot take mean of 0 values";
        Preconditions.checkArgument(n12 != 0, string2);
        long l11 = lArray[0];
        double d10 = l11;
        long l12 = l10 = 1L;
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l13 = lArray[n11];
            double d11 = (double)l13 - d10;
            double d12 = l12 += l10;
            d10 += (d11 /= d12);
        }
        return d10;
    }

    public static double roundIntermediate(double d10, RoundingMode roundingMode) {
        boolean bl2 = DoubleUtils.isFinite(d10);
        if (bl2) {
            int[] nArray = DoubleMath$1.$SwitchMap$java$math$RoundingMode;
            int n10 = roundingMode.ordinal();
            n10 = nArray[n10];
            long l10 = 1L;
            double d11 = Double.MIN_VALUE;
            double d12 = 0.5;
            double d13 = 0.0;
            switch (n10) {
                default: {
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                case 8: {
                    d11 = Math.rint(d10);
                    d13 = Math.abs(d10 - d11);
                    n10 = (int)(d13 == d12 ? 0 : (d13 > d12 ? 1 : -1));
                    if (n10 == 0) {
                        return d10;
                    }
                    return d11;
                }
                case 7: {
                    d11 = Math.rint(d10);
                    d13 = Math.abs(d10 - d11);
                    n10 = (int)(d13 == d12 ? 0 : (d13 > d12 ? 1 : -1));
                    if (n10 == 0) {
                        d11 = Math.copySign(d12, d10);
                        return d10 + d11;
                    }
                    return d11;
                }
                case 6: {
                    return Math.rint(d10);
                }
                case 5: {
                    n10 = (int)(DoubleMath.isMathematicalInteger(d10) ? 1 : 0);
                    if (n10 != 0) {
                        return d10;
                    }
                    l10 = (long)d10;
                    Object object = d10 == d13 ? 0 : (d10 > d13 ? 1 : -1);
                    object = object > 0 ? (Object)true : (Object)-1;
                    long l11 = (long)object;
                    d10 = l10 += l11;
                }
                case 4: {
                    return d10;
                }
                case 3: {
                    n10 = (int)(d10 == d13 ? 0 : (d10 < d13 ? -1 : 1));
                    if (n10 > 0 && (n10 = (int)(DoubleMath.isMathematicalInteger(d10) ? 1 : 0)) == 0) {
                        long l12 = (long)d10 + l10;
                        d10 = l12;
                    }
                    return d10;
                }
                case 2: {
                    n10 = (int)(d10 == d13 ? 0 : (d10 > d13 ? 1 : -1));
                    if (n10 < 0 && (n10 = (int)(DoubleMath.isMathematicalInteger(d10) ? 1 : 0)) == 0) {
                        long l13 = (long)d10 - l10;
                        d10 = l13;
                    }
                    return d10;
                }
                case 1: 
            }
            MathPreconditions.checkRoundingUnnecessary(DoubleMath.isMathematicalInteger(d10));
            return d10;
        }
        ArithmeticException arithmeticException = new ArithmeticException("input is infinite or NaN");
        throw arithmeticException;
    }

    public static BigInteger roundToBigInteger(double d10, RoundingMode object) {
        BigInteger bigInteger;
        d10 = DoubleMath.roundIntermediate(d10, (RoundingMode)((Object)object));
        double d11 = -9.223372036854776E18 - d10;
        double d12 = 1.0;
        double d13 = d11 == d12 ? 0 : (d11 < d12 ? -1 : 1);
        int n10 = 1;
        if (d13 < 0) {
            d13 = n10;
        } else {
            d13 = 0.0;
            object = null;
        }
        d12 = 9.223372036854776E18;
        double d14 = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        if (d14 >= 0) {
            n10 = 0;
            bigInteger = null;
        }
        d13 = d13 & n10;
        if (d13 != false) {
            return BigInteger.valueOf((long)d10);
        }
        d13 = Math.getExponent(d10);
        bigInteger = BigInteger.valueOf(DoubleUtils.getSignificand(d10));
        object = bigInteger.shiftLeft((int)(d13 += -52));
        d11 = 0.0;
        double d15 = d10 - d11;
        Object object2 = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object2 < 0) {
            object = ((BigInteger)object).negate();
        }
        return object;
    }

    public static int roundToInt(double d10, RoundingMode roundingMode) {
        double d11 = DoubleMath.roundIntermediate(d10, roundingMode);
        double d12 = -2.147483649E9;
        double d13 = d11 == d12 ? 0 : (d11 > d12 ? 1 : -1);
        int n10 = 1;
        d13 = d13 > 0 ? (double)n10 : 0.0;
        double d14 = 2.147483648E9;
        double d15 = d11 - d14;
        Object object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object >= 0) {
            n10 = 0;
        }
        MathPreconditions.checkInRangeForRoundingInputs((d13 & n10) != 0, d10, roundingMode);
        return (int)d11;
    }

    public static long roundToLong(double d10, RoundingMode roundingMode) {
        double d11 = DoubleMath.roundIntermediate(d10, roundingMode);
        double d12 = -9.223372036854776E18 - d11;
        double d13 = 1.0;
        double d14 = d12 == d13 ? 0 : (d12 < d13 ? -1 : 1);
        int n10 = 1;
        d14 = d14 < 0 ? (double)n10 : 0.0;
        double d15 = 9.223372036854776E18;
        double d16 = d11 - d15;
        Object object = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
        if (object >= 0) {
            n10 = 0;
        }
        MathPreconditions.checkInRangeForRoundingInputs((d14 & n10) != 0, d10, roundingMode);
        return (long)d11;
    }
}


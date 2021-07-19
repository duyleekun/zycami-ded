/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.BigIntegerMath$1;
import com.google.common.math.DoubleMath;
import com.google.common.math.DoubleUtils;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class BigIntegerMath {
    private static final double LN_10 = 0.0;
    private static final double LN_2 = 0.0;
    public static final BigInteger SQRT2_PRECOMPUTED_BITS;
    public static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    static {
        BigInteger bigInteger;
        SQRT2_PRECOMPUTED_BITS = bigInteger = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
        LN_10 = Math.log(10.0);
        LN_2 = Math.log(2.0);
    }

    private BigIntegerMath() {
    }

    public static BigInteger binomial(int n10, int n11) {
        int n12;
        Object object;
        int n13;
        MathPreconditions.checkNonNegative("n", n10);
        String string2 = "k";
        MathPreconditions.checkNonNegative(string2, n11);
        int n14 = 1;
        if (n11 <= n10) {
            n13 = n14;
        } else {
            n13 = 0;
            object = null;
        }
        Object object2 = "k (%s) > n (%s)";
        Preconditions.checkArgument(n13 != 0, (String)object2, n11, n10);
        n13 = n10 >> 1;
        if (n11 > n13) {
            n11 = n10 - n11;
        }
        if (n11 < (n12 = ((int[])(object = LongMath.biggestBinomials)).length) && n10 <= (n13 = object[n11])) {
            return BigInteger.valueOf(LongMath.binomial(n10, n11));
        }
        object = BigInteger.ONE;
        long l10 = n10;
        long l11 = 1L;
        RoundingMode roundingMode = RoundingMode.CEILING;
        int n15 = LongMath.log2(l10, roundingMode);
        block0: while (true) {
            int n16 = n15;
            while (n14 < n11) {
                int n17 = n10 - n14;
                ++n14;
                int n18 = 63;
                if ((n16 += n15) >= n18) {
                    object2 = BigInteger.valueOf(l10);
                    object = ((BigInteger)object).multiply((BigInteger)object2);
                    object2 = BigInteger.valueOf(l11);
                    object = ((BigInteger)object).divide((BigInteger)object2);
                    l10 = n17;
                    l11 = n14;
                    continue block0;
                }
                long l12 = n17;
                l10 *= l12;
                l12 = n14;
                l11 *= l12;
            }
            break;
        }
        BigInteger bigInteger = BigInteger.valueOf(l10);
        bigInteger = ((BigInteger)object).multiply(bigInteger);
        BigInteger bigInteger2 = BigInteger.valueOf(l11);
        return bigInteger.divide(bigInteger2);
    }

    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ZERO;
        RoundingMode roundingMode = RoundingMode.CEILING;
        int n10 = BigIntegerMath.log2(bigInteger, roundingMode);
        return bigInteger2.setBit(n10);
    }

    public static BigInteger divide(BigInteger number, BigInteger bigInteger, RoundingMode roundingMode) {
        BigDecimal bigDecimal = new BigDecimal((BigInteger)number);
        number = new BigDecimal(bigInteger);
        return bigDecimal.divide((BigDecimal)number, 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int n10) {
        long l10;
        long l11;
        Object object;
        int n11 = n10;
        MathPreconditions.checkNonNegative("n", n10);
        long[] lArray = LongMath.factorials;
        int n12 = lArray.length;
        if (n10 < n12) {
            return BigInteger.valueOf(lArray[n10]);
        }
        RoundingMode roundingMode = RoundingMode.CEILING;
        n12 = IntMath.log2(n10, roundingMode) * n10;
        Object object2 = RoundingMode.CEILING;
        int n13 = 64;
        n12 = IntMath.divide(n12, n13, (RoundingMode)((Object)object2));
        object2 = new ArrayList(n12);
        n12 = lArray.length;
        int n14 = n12 + -1;
        long l12 = lArray[n14];
        int n15 = Long.numberOfTrailingZeros(l12);
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        int n16 = LongMath.log2(l12 >>= n15, roundingMode2);
        int n17 = 1;
        n16 += n17;
        long l13 = n12;
        roundingMode = RoundingMode.FLOOR;
        n12 = LongMath.log2(l13, roundingMode) + n17;
        int n18 = n12 + -1;
        n18 = n17 << n18;
        while ((object = (l11 = l13 - (l10 = (long)n11)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            long l14 = n18;
            l10 = l13 & l14;
            long l15 = 0L;
            long l16 = l10 - l15;
            object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object != false) {
                n18 <<= 1;
                ++n12;
            }
            object = Long.numberOfTrailingZeros(l13);
            l14 = l13 >> object;
            n15 += object;
            if ((object = (Object)(n12 - object + n16)) >= n13) {
                BigInteger bigInteger = BigInteger.valueOf(l12);
                ((ArrayList)object2).add(bigInteger);
                l12 = 1L;
            }
            roundingMode2 = RoundingMode.FLOOR;
            n16 = LongMath.log2(l12 *= l14, roundingMode2) + n17;
            l10 = 1L;
            l13 += l10;
        }
        l10 = 1L;
        long l17 = l12 - l10;
        n11 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
        if (n11 > 0) {
            BigInteger bigInteger = BigInteger.valueOf(l12);
            ((ArrayList)object2).add(bigInteger);
        }
        return BigIntegerMath.listProduct((List)object2).shiftLeft(n15);
    }

    public static boolean fitsInLong(BigInteger bigInteger) {
        int n10;
        int n11 = bigInteger.bitLength();
        if (n11 <= (n10 = 63)) {
            n11 = 1;
        } else {
            n11 = 0;
            bigInteger = null;
        }
        return n11 != 0;
    }

    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ZERO;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        int n10 = BigIntegerMath.log2(bigInteger, roundingMode);
        return bigInteger2.setBit(n10);
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        int n10;
        Preconditions.checkNotNull(bigInteger);
        int n11 = bigInteger.signum();
        int n12 = 1;
        if (n11 <= 0 || (n11 = bigInteger.getLowestSetBit()) != (n10 = bigInteger.bitLength() - n12)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static BigInteger listProduct(List list) {
        int n10 = list.size();
        return BigIntegerMath.listProduct(list, 0, n10);
    }

    public static BigInteger listProduct(List object, int n10, int n11) {
        int n12 = n11 - n10;
        if (n12 != 0) {
            int n13 = 1;
            if (n12 != n13) {
                int n14 = 2;
                if (n12 != n14) {
                    int n15 = 3;
                    if (n12 != n15) {
                        n12 = n11 + n10 >>> n13;
                        BigInteger bigInteger = BigIntegerMath.listProduct((List)object, n10, n12);
                        object = BigIntegerMath.listProduct((List)object, n12, n11);
                        return bigInteger.multiply((BigInteger)object);
                    }
                    BigInteger bigInteger = (BigInteger)object.get(n10);
                    n12 = n10 + 1;
                    BigInteger bigInteger2 = (BigInteger)object.get(n12);
                    bigInteger = bigInteger.multiply(bigInteger2);
                    object = (BigInteger)object.get(n10 += n14);
                    return bigInteger.multiply((BigInteger)object);
                }
                BigInteger bigInteger = (BigInteger)object.get(n10);
                object = (BigInteger)object.get(n10 += n13);
                return bigInteger.multiply((BigInteger)object);
            }
            return (BigInteger)object.get(n10);
        }
        return BigInteger.ONE;
    }

    public static int log10(BigInteger object, RoundingMode object2) {
        Object object3;
        Object object4 = "x";
        MathPreconditions.checkPositive(object4, (BigInteger)object);
        int n10 = BigIntegerMath.fitsInLong((BigInteger)object);
        if (n10 != 0) {
            return LongMath.log10(((BigInteger)object).longValue(), (RoundingMode)((Object)object2));
        }
        object4 = RoundingMode.FLOOR;
        double d10 = BigIntegerMath.log2((BigInteger)object, (RoundingMode)((Object)object4));
        double d11 = LN_2;
        d10 *= d11;
        d11 = LN_10;
        n10 = (int)(d10 /= d11);
        Object object5 = BigInteger.TEN.pow(n10);
        int n11 = ((BigInteger)object5).compareTo((BigInteger)object);
        if (n11 > 0) {
            BigInteger bigInteger;
            do {
                n10 += -1;
            } while ((n11 = ((BigInteger)(object5 = ((BigInteger)object5).divide(bigInteger = BigInteger.TEN))).compareTo((BigInteger)object)) > 0);
        } else {
            object3 = BigInteger.TEN.multiply((BigInteger)object5);
            int n12 = ((BigInteger)object3).compareTo((BigInteger)object);
            int n13 = n11;
            n11 = n12;
            while (n11 <= 0) {
                ++n10;
                object5 = BigInteger.TEN.multiply((BigInteger)object3);
                n13 = ((BigInteger)object5).compareTo((BigInteger)object);
                Object object6 = object3;
                object3 = object5;
                object5 = object6;
                int n14 = n13;
                n13 = n11;
                n11 = n14;
            }
            n11 = n13;
        }
        object3 = BigIntegerMath$1.$SwitchMap$java$math$RoundingMode;
        Object object7 = ((Enum)object2).ordinal();
        object7 = object3[object7];
        switch (object7) {
            default: {
                object = new AssertionError();
                throw object;
            }
            case 6: 
            case 7: 
            case 8: {
                object7 = 2;
                object = ((BigInteger)object).pow((int)object7);
                object2 = ((BigInteger)object5).pow((int)object7);
                object5 = BigInteger.TEN;
                object2 = ((BigInteger)object2).multiply((BigInteger)object5);
                int n15 = ((BigInteger)object).compareTo((BigInteger)object2);
                if (n15 > 0) {
                    ++n10;
                }
                return n10;
            }
            case 4: 
            case 5: {
                boolean bl2 = ((BigInteger)object5).equals(object);
                if (!bl2) {
                    ++n10;
                }
                return n10;
            }
            case 1: {
                boolean bl3;
                if (n11 == 0) {
                    bl3 = true;
                } else {
                    bl3 = false;
                    object = null;
                }
                MathPreconditions.checkRoundingUnnecessary(bl3);
            }
            case 2: 
            case 3: 
        }
        return n10;
    }

    public static int log2(BigInteger object, RoundingMode object2) {
        BigInteger bigInteger = (BigInteger)Preconditions.checkNotNull(object);
        MathPreconditions.checkPositive("x", bigInteger);
        int n10 = ((BigInteger)object).bitLength() + -1;
        int[] nArray = BigIntegerMath$1.$SwitchMap$java$math$RoundingMode;
        int n11 = ((Enum)object2).ordinal();
        n11 = nArray[n11];
        switch (n11) {
            default: {
                object = new AssertionError();
                throw object;
            }
            case 6: 
            case 7: 
            case 8: {
                n11 = 256;
                if (n10 < n11) {
                    object2 = SQRT2_PRECOMPUTED_BITS;
                    int n12 = 256 - n10;
                    int n13 = ((BigInteger)object).compareTo((BigInteger)(object2 = ((BigInteger)object2).shiftRight(n12)));
                    if (n13 <= 0) {
                        return n10;
                    }
                    return n10 + 1;
                }
                int n14 = ((BigInteger)(object = ((BigInteger)object).pow(2))).bitLength() + -1;
                if (n14 >= (n11 = n10 * 2 + 1)) {
                    ++n10;
                }
                return n10;
            }
            case 4: 
            case 5: {
                boolean bl2 = BigIntegerMath.isPowerOfTwo((BigInteger)object);
                if (!bl2) {
                    ++n10;
                }
                return n10;
            }
            case 1: {
                boolean bl3 = BigIntegerMath.isPowerOfTwo((BigInteger)object);
                MathPreconditions.checkRoundingUnnecessary(bl3);
            }
            case 2: 
            case 3: 
        }
        return n10;
    }

    public static BigInteger sqrt(BigInteger object, RoundingMode object2) {
        Object object3 = "x";
        MathPreconditions.checkNonNegative((String)object3, (BigInteger)object);
        boolean bl2 = BigIntegerMath.fitsInLong((BigInteger)object);
        if (bl2) {
            return BigInteger.valueOf(LongMath.sqrt(((BigInteger)object).longValue(), (RoundingMode)((Object)object2)));
        }
        object3 = BigIntegerMath.sqrtFloor((BigInteger)object);
        int[] nArray = BigIntegerMath$1.$SwitchMap$java$math$RoundingMode;
        int n10 = ((Enum)object2).ordinal();
        n10 = nArray[n10];
        int n11 = 2;
        switch (n10) {
            default: {
                object = new AssertionError();
                throw object;
            }
            case 6: 
            case 7: 
            case 8: {
                object2 = ((BigInteger)object3).pow(n11).add((BigInteger)object3);
                int n12 = ((BigInteger)object2).compareTo((BigInteger)object);
                if (n12 < 0) {
                    object = BigInteger.ONE;
                    object3 = ((BigInteger)object3).add((BigInteger)object);
                }
                return object3;
            }
            case 4: 
            case 5: {
                boolean bl3;
                n10 = ((BigInteger)object3).intValue();
                n10 *= n10;
                int n13 = ((BigInteger)object).intValue();
                if (n10 == n13 && (bl3 = ((BigInteger)(object2 = ((BigInteger)object3).pow(n11))).equals(object))) {
                    bl3 = true;
                } else {
                    bl3 = false;
                    object = null;
                }
                if (!bl3) {
                    object = BigInteger.ONE;
                    object3 = ((BigInteger)object3).add((BigInteger)object);
                }
                return object3;
            }
            case 1: {
                object2 = ((BigInteger)object3).pow(n11);
                boolean bl4 = ((BigInteger)object2).equals(object);
                MathPreconditions.checkRoundingUnnecessary(bl4);
            }
            case 2: 
            case 3: 
        }
        return object3;
    }

    private static BigInteger sqrtApproxWithDoubles(BigInteger object) {
        double d10 = Math.sqrt(DoubleUtils.bigToDouble(object));
        object = RoundingMode.HALF_EVEN;
        return DoubleMath.roundToBigInteger(d10, (RoundingMode)((Object)object));
    }

    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        Object object;
        Object object2 = RoundingMode.FLOOR;
        int n10 = BigIntegerMath.log2(bigInteger, (RoundingMode)((Object)object2));
        int n11 = 1;
        int n12 = 1023;
        if (n10 < n12) {
            object2 = BigIntegerMath.sqrtApproxWithDoubles(bigInteger);
        } else {
            n10 = n10 + -52 & 0xFFFFFFFE;
            object = BigIntegerMath.sqrtApproxWithDoubles(bigInteger.shiftRight(n10));
            object2 = ((BigInteger)object).shiftLeft(n10 >>= n11);
        }
        object = bigInteger.divide((BigInteger)object2);
        object = ((BigInteger)object2).add((BigInteger)object).shiftRight(n11);
        boolean n13 = ((BigInteger)object2).equals(object);
        if (n13) {
            return object2;
        }
        while (true) {
            object2 = bigInteger.divide((BigInteger)object);
            int n14 = ((BigInteger)(object2 = ((BigInteger)object).add((BigInteger)object2).shiftRight(n11))).compareTo((BigInteger)object);
            if (n14 >= 0) {
                return object;
            }
            object = object2;
        }
    }
}


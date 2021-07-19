/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import java.math.BigInteger;
import java.math.RoundingMode;

public final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRangeForRoundingInputs(boolean bl2, double d10, RoundingMode roundingMode) {
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rounded value is out of range for input ");
        stringBuilder.append(d10);
        stringBuilder.append(" and rounding mode ");
        stringBuilder.append((Object)roundingMode);
        String string2 = stringBuilder.toString();
        ArithmeticException arithmeticException = new ArithmeticException(string2);
        throw arithmeticException;
    }

    public static void checkNoOverflow(boolean bl2, String string2, int n10, int n11) {
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("overflow: ");
        stringBuilder.append(string2);
        stringBuilder.append("(");
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        stringBuilder.append(n11);
        stringBuilder.append(")");
        string2 = stringBuilder.toString();
        ArithmeticException arithmeticException = new ArithmeticException(string2);
        throw arithmeticException;
    }

    public static void checkNoOverflow(boolean bl2, String string2, long l10, long l11) {
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("overflow: ");
        stringBuilder.append(string2);
        stringBuilder.append("(");
        stringBuilder.append(l10);
        stringBuilder.append(", ");
        stringBuilder.append(l11);
        stringBuilder.append(")");
        string2 = stringBuilder.toString();
        ArithmeticException arithmeticException = new ArithmeticException(string2);
        throw arithmeticException;
    }

    public static double checkNonNegative(String string2, double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object >= 0) {
            return d10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(d10);
        stringBuilder.append(") must be >= 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int checkNonNegative(String string2, int n10) {
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(n10);
        stringBuilder.append(") must be >= 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static long checkNonNegative(String string2, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return l10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(l10);
        stringBuilder.append(") must be >= 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static BigInteger checkNonNegative(String string2, BigInteger bigInteger) {
        int n10 = bigInteger.signum();
        if (n10 >= 0) {
            return bigInteger;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(bigInteger);
        stringBuilder.append(") must be >= 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int checkPositive(String string2, int n10) {
        if (n10 > 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(n10);
        stringBuilder.append(") must be > 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static long checkPositive(String string2, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return l10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(l10);
        stringBuilder.append(") must be > 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static BigInteger checkPositive(String string2, BigInteger bigInteger) {
        int n10 = bigInteger.signum();
        if (n10 > 0) {
            return bigInteger;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(bigInteger);
        stringBuilder.append(") must be > 0");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static void checkRoundingUnnecessary(boolean bl2) {
        if (bl2) {
            return;
        }
        ArithmeticException arithmeticException = new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        throw arithmeticException;
    }
}


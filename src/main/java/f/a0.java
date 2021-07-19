/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class a0 {
    private static final BigDecimal a(BigDecimal bigDecimal) {
        f0.p(bigDecimal, "$this$dec");
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        bigDecimal = bigDecimal.subtract(bigDecimal2);
        f0.o(bigDecimal, "this.subtract(BigDecimal.ONE)");
        return bigDecimal;
    }

    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        f0.p(bigDecimal, "$this$div");
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;
        bigDecimal = bigDecimal.divide(bigDecimal2, roundingMode);
        f0.o(bigDecimal, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimal;
    }

    private static final BigDecimal c(BigDecimal bigDecimal) {
        f0.p(bigDecimal, "$this$inc");
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        bigDecimal = bigDecimal.add(bigDecimal2);
        f0.o(bigDecimal, "this.add(BigDecimal.ONE)");
        return bigDecimal;
    }

    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        f0.p(bigDecimal, "$this$minus");
        bigDecimal = bigDecimal.subtract(bigDecimal2);
        f0.o(bigDecimal, "this.subtract(other)");
        return bigDecimal;
    }

    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        f0.p(bigDecimal, "$this$plus");
        bigDecimal = bigDecimal.add(bigDecimal2);
        f0.o(bigDecimal, "this.add(other)");
        return bigDecimal;
    }

    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        f0.p(bigDecimal, "$this$rem");
        bigDecimal = bigDecimal.remainder(bigDecimal2);
        f0.o(bigDecimal, "this.remainder(other)");
        return bigDecimal;
    }

    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        f0.p(bigDecimal, "$this$times");
        bigDecimal = bigDecimal.multiply(bigDecimal2);
        f0.o(bigDecimal, "this.multiply(other)");
        return bigDecimal;
    }

    private static final BigDecimal h(double d10) {
        String string2 = String.valueOf(d10);
        BigDecimal bigDecimal = new BigDecimal(string2);
        return bigDecimal;
    }

    private static final BigDecimal i(double d10, MathContext mathContext) {
        String string2 = String.valueOf(d10);
        BigDecimal bigDecimal = new BigDecimal(string2, mathContext);
        return bigDecimal;
    }

    private static final BigDecimal j(float f10) {
        String string2 = String.valueOf(f10);
        BigDecimal bigDecimal = new BigDecimal(string2);
        return bigDecimal;
    }

    private static final BigDecimal k(float f10, MathContext mathContext) {
        String string2 = String.valueOf(f10);
        BigDecimal bigDecimal = new BigDecimal(string2, mathContext);
        return bigDecimal;
    }

    private static final BigDecimal l(int n10) {
        BigDecimal bigDecimal = BigDecimal.valueOf(n10);
        f0.o(bigDecimal, "BigDecimal.valueOf(this.toLong())");
        return bigDecimal;
    }

    private static final BigDecimal m(int n10, MathContext mathContext) {
        BigDecimal bigDecimal = new BigDecimal(n10, mathContext);
        return bigDecimal;
    }

    private static final BigDecimal n(long l10) {
        BigDecimal bigDecimal = BigDecimal.valueOf(l10);
        f0.o(bigDecimal, "BigDecimal.valueOf(this)");
        return bigDecimal;
    }

    private static final BigDecimal o(long l10, MathContext mathContext) {
        BigDecimal bigDecimal = new BigDecimal(l10, mathContext);
        return bigDecimal;
    }

    private static final BigDecimal p(BigDecimal bigDecimal) {
        f0.p(bigDecimal, "$this$unaryMinus");
        bigDecimal = bigDecimal.negate();
        f0.o(bigDecimal, "this.negate()");
        return bigDecimal;
    }
}


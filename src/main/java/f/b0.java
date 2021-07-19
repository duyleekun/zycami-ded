/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.a0;
import f.h2.t.f0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class b0
extends a0 {
    private static final BigInteger A(BigInteger bigInteger, int n10) {
        bigInteger = bigInteger.shiftRight(n10);
        f0.o(bigInteger, "this.shiftRight(n)");
        return bigInteger;
    }

    private static final BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
        f0.p(bigInteger, "$this$times");
        bigInteger = bigInteger.multiply(bigInteger2);
        f0.o(bigInteger, "this.multiply(other)");
        return bigInteger;
    }

    private static final BigDecimal C(BigInteger bigInteger) {
        BigDecimal bigDecimal = new BigDecimal(bigInteger);
        return bigDecimal;
    }

    private static final BigDecimal D(BigInteger bigInteger, int n10, MathContext mathContext) {
        BigDecimal bigDecimal = new BigDecimal(bigInteger, n10, mathContext);
        return bigDecimal;
    }

    public static /* synthetic */ BigDecimal E(BigInteger bigInteger, int n10, MathContext mathContext, int n11, Object object) {
        Object object2;
        int n12 = n11 & 1;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            object2 = "MathContext.UNLIMITED";
            f0.o(mathContext, (String)object2);
        }
        object2 = new BigDecimal(bigInteger, n10, mathContext);
        return object2;
    }

    private static final BigInteger F(int n10) {
        BigInteger bigInteger = BigInteger.valueOf(n10);
        f0.o(bigInteger, "BigInteger.valueOf(this.toLong())");
        return bigInteger;
    }

    private static final BigInteger G(long l10) {
        BigInteger bigInteger = BigInteger.valueOf(l10);
        f0.o(bigInteger, "BigInteger.valueOf(this)");
        return bigInteger;
    }

    private static final BigInteger H(BigInteger bigInteger) {
        f0.p(bigInteger, "$this$unaryMinus");
        bigInteger = bigInteger.negate();
        f0.o(bigInteger, "this.negate()");
        return bigInteger;
    }

    private static final BigInteger I(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.xor(bigInteger2);
        f0.o(bigInteger, "this.xor(other)");
        return bigInteger;
    }

    private static final BigInteger q(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.and(bigInteger2);
        f0.o(bigInteger, "this.and(other)");
        return bigInteger;
    }

    private static final BigInteger r(BigInteger bigInteger) {
        f0.p(bigInteger, "$this$dec");
        BigInteger bigInteger2 = BigInteger.ONE;
        bigInteger = bigInteger.subtract(bigInteger2);
        f0.o(bigInteger, "this.subtract(BigInteger.ONE)");
        return bigInteger;
    }

    private static final BigInteger s(BigInteger bigInteger, BigInteger bigInteger2) {
        f0.p(bigInteger, "$this$div");
        bigInteger = bigInteger.divide(bigInteger2);
        f0.o(bigInteger, "this.divide(other)");
        return bigInteger;
    }

    private static final BigInteger t(BigInteger bigInteger) {
        f0.p(bigInteger, "$this$inc");
        BigInteger bigInteger2 = BigInteger.ONE;
        bigInteger = bigInteger.add(bigInteger2);
        f0.o(bigInteger, "this.add(BigInteger.ONE)");
        return bigInteger;
    }

    private static final BigInteger u(BigInteger bigInteger) {
        bigInteger = bigInteger.not();
        f0.o(bigInteger, "this.not()");
        return bigInteger;
    }

    private static final BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
        f0.p(bigInteger, "$this$minus");
        bigInteger = bigInteger.subtract(bigInteger2);
        f0.o(bigInteger, "this.subtract(other)");
        return bigInteger;
    }

    private static final BigInteger w(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.or(bigInteger2);
        f0.o(bigInteger, "this.or(other)");
        return bigInteger;
    }

    private static final BigInteger x(BigInteger bigInteger, BigInteger bigInteger2) {
        f0.p(bigInteger, "$this$plus");
        bigInteger = bigInteger.add(bigInteger2);
        f0.o(bigInteger, "this.add(other)");
        return bigInteger;
    }

    private static final BigInteger y(BigInteger bigInteger, BigInteger bigInteger2) {
        f0.p(bigInteger, "$this$rem");
        bigInteger = bigInteger.remainder(bigInteger2);
        f0.o(bigInteger, "this.remainder(other)");
        return bigInteger;
    }

    private static final BigInteger z(BigInteger bigInteger, int n10) {
        bigInteger = bigInteger.shiftLeft(n10);
        f0.o(bigInteger, "this.shiftLeft(n)");
        return bigInteger;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package f.x1.q1;

import f.c1;
import f.d1;
import f.g1;
import f.h1;
import f.h2.s.l;
import f.h2.t.f0;
import f.m1;
import f.n1;
import f.s1;
import f.x1.c;
import f.x1.c$a;
import f.x1.q1.b$a;
import f.x1.q1.b$b;
import f.x1.q1.b$c;
import f.x1.q1.b$d;
import f.y0;
import f.z0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class b {
    public static final List a(int[] nArray) {
        f0.p(nArray, "$this$asList");
        b$a b$a = new b$a(nArray);
        return b$a;
    }

    public static final List b(byte[] byArray) {
        f0.p(byArray, "$this$asList");
        b$c b$c = new b$c(byArray);
        return b$c;
    }

    public static final List c(long[] lArray) {
        f0.p(lArray, "$this$asList");
        b$b b$b = new b$b(lArray);
        return b$b;
    }

    public static final List d(short[] sArray) {
        f0.p(sArray, "$this$asList");
        b$d b$d = new b$d(sArray);
        return b$d;
    }

    public static final int e(int[] nArray, int n10, int n11, int n12) {
        f0.p(nArray, "$this$binarySearch");
        c$a c$a = c.a;
        int n13 = d1.n(nArray);
        c$a.d(n11, n12, n13);
        n12 += -1;
        while (n11 <= n12) {
            int n14 = n11 + n12 >>> 1;
            n13 = s1.c(nArray[n14], n10);
            if (n13 < 0) {
                n11 = ++n14;
                continue;
            }
            if (n13 > 0) {
                n12 = n14 += -1;
                continue;
            }
            return n14;
        }
        return -(n11 + 1);
    }

    public static /* synthetic */ int f(int[] nArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n11 = 0;
        }
        if ((n13 &= 4) != 0) {
            n12 = d1.n(nArray);
        }
        return b.e(nArray, n10, n11, n12);
    }

    public static final int g(short[] sArray, short s10, int n10, int n11) {
        f0.p(sArray, "$this$binarySearch");
        c$a c$a = c.a;
        int n12 = n1.n(sArray);
        c$a.d(n10, n11, n12);
        int n13 = -1;
        s10 = (short)(s10 & n13);
        n11 += -1;
        while (n10 <= n11) {
            n13 = n10 + n11 >>> 1;
            n12 = s1.c(sArray[n13], s10);
            if (n12 < 0) {
                n10 = ++n13;
                continue;
            }
            if (n12 > 0) {
                n11 = n13 += -1;
                continue;
            }
            return n13;
        }
        return -(n10 + 1);
    }

    public static /* synthetic */ int h(short[] sArray, short s10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = n1.n(sArray);
        }
        return b.g(sArray, s10, n10, n11);
    }

    public static final int i(long[] lArray, long l10, int n10, int n11) {
        f0.p(lArray, "$this$binarySearch");
        c$a c$a = c.a;
        int n12 = h1.n(lArray);
        c$a.d(n10, n11, n12);
        n11 += -1;
        while (n10 <= n11) {
            int n13 = n10 + n11 >>> 1;
            long l11 = lArray[n13];
            n12 = s1.g(l11, l10);
            if (n12 < 0) {
                n10 = ++n13;
                continue;
            }
            if (n12 > 0) {
                n11 = n13 += -1;
                continue;
            }
            return n13;
        }
        return -(n10 + 1);
    }

    public static /* synthetic */ int j(long[] lArray, long l10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = h1.n(lArray);
        }
        return b.i(lArray, l10, n10, n11);
    }

    public static final int k(byte[] byArray, byte by2, int n10, int n11) {
        f0.p(byArray, "$this$binarySearch");
        c$a c$a = c.a;
        int n12 = z0.n(byArray);
        c$a.d(n10, n11, n12);
        by2 = (byte)(by2 & 0xFF);
        n11 += -1;
        while (n10 <= n11) {
            int n13 = n10 + n11 >>> 1;
            n12 = s1.c(byArray[n13], by2);
            if (n12 < 0) {
                n10 = ++n13;
                continue;
            }
            if (n12 > 0) {
                n11 = n13 += -1;
                continue;
            }
            return n13;
        }
        return -(n10 + 1);
    }

    public static /* synthetic */ int l(byte[] byArray, byte by2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = z0.n(byArray);
        }
        return b.k(byArray, by2, n10, n11);
    }

    private static final byte m(byte[] byArray, int n10) {
        return z0.l(byArray, n10);
    }

    private static final short n(short[] sArray, int n10) {
        return n1.l(sArray, n10);
    }

    private static final int o(int[] nArray, int n10) {
        return d1.l(nArray, n10);
    }

    private static final long p(long[] lArray, int n10) {
        return h1.l(lArray, n10);
    }

    private static final BigDecimal q(byte[] byArray, l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final BigDecimal r(int[] nArray, l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final BigDecimal s(long[] lArray, l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (long l12 : lArray) {
            Object object = g1.b(l12);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final BigDecimal t(short[] sArray, l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final BigInteger u(byte[] byArray, l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final BigInteger v(int[] nArray, l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final BigInteger w(long[] lArray, l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (long l12 : lArray) {
            Object object = g1.b(l12);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final BigInteger x(short[] sArray, l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }
}


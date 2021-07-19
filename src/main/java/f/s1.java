/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.q2.b;

public final class s1 {
    /*
     * Enabled aggressive block sorting
     */
    public static final int a(double d10) {
        Object object = Double.isNaN(d10);
        int n10 = -1;
        if (object != 0) return 0;
        double d11 = s1.f(0);
        double d12 = d10 - d11;
        object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object <= 0) {
            return 0;
        }
        double d13 = s1.f(n10);
        double d14 = d10 - d13;
        object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object >= 0) {
            return n10;
        }
        object = -1 >>> 1;
        double d15 = object;
        double d16 = d10 - d15;
        Object object2 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            int n11 = (int)d10;
            return c1.h(n11);
        }
        int n12 = c1.h((int)(d10 -= d15));
        int n13 = c1.h(object);
        return c1.h(n12 += n13);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final long b(double d10) {
        Object object = Double.isNaN(d10);
        long l10 = -1;
        long l11 = 0L;
        double d11 = 0.0;
        if (object != 0) return l11;
        double d12 = s1.j(l11);
        double d13 = d10 - d12;
        object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object <= 0) {
            return l11;
        }
        d11 = s1.j(l10);
        double d14 = d10 - d11;
        object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object >= 0) {
            return l10;
        }
        long l12 = Long.MAX_VALUE;
        double d15 = l12;
        double d16 = d10 - d15;
        object = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
        if (object < 0) {
            long l13 = (long)d10;
            return g1.h(l13);
        }
        long l14 = g1.h((long)(d10 -= 9.223372036854776E18));
        l12 = Long.MIN_VALUE;
        d15 = -0.0;
        return g1.h(l14 += l12);
    }

    public static final int c(int n10, int n11) {
        int n12 = -1 << -1;
        return f0.t(n10 ^= n12, n11 ^= n12);
    }

    public static final int d(int n10, int n11) {
        long l10 = n10;
        long l11 = 0xFFFFFFFFL;
        long l12 = (long)n11 & l11;
        return c1.h((int)((l10 &= l11) / l12));
    }

    public static final int e(int n10, int n11) {
        long l10 = n10;
        long l11 = 0xFFFFFFFFL;
        long l12 = (long)n11 & l11;
        return c1.h((int)((l10 &= l11) % l12));
    }

    public static final double f(int n10) {
        double d10 = -1 >>> 1 & n10;
        double d11 = n10 >>> 31 << 30;
        double d12 = 2;
        return d10 + (d11 *= d12);
    }

    public static final int g(long l10, long l11) {
        long l12 = Long.MIN_VALUE;
        long l13 = (l10 ^= l12) - (l11 ^= l12);
        return (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
    }

    public static final long h(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            int n10 = s1.g(l10, l11);
            l10 = n10 < 0 ? g1.h(l12) : g1.h(1L);
            return l10;
        }
        Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object2 >= 0) {
            return g1.h(l10 / l11);
        }
        object2 = 1;
        long l14 = (l10 >>> object2) / l11 << object2;
        long l15 = l14 * l11;
        int n11 = s1.g(l10 = g1.h(l10 - l15), l11 = g1.h(l11));
        if (n11 < 0) {
            object2 = 0;
        }
        l10 = object2;
        return g1.h(l14 + l10);
    }

    public static final long i(long l10, long l11) {
        long l12;
        long l13 = 0L;
        long l14 = l11 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            int n10 = s1.g(l10, l11);
            if (n10 >= 0) {
                l10 = g1.h(l10 - l11);
            }
            return l10;
        }
        object = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (object >= 0) {
            return g1.h(l10 % l11);
        }
        object = 1;
        long l15 = (l10 >>> object) / l11;
        long l16 = (l15 << object) * l11;
        object = s1.g(l16 = g1.h(l10 -= l16), l12 = g1.h(l11));
        if (object < 0) {
            l11 = l13;
        }
        return g1.h(l10 - l11);
    }

    public static final double j(long l10) {
        double d10 = l10 >>> 11;
        double d11 = 2048;
        double d12 = l10 & 0x7FFL;
        return (d10 *= d11) + d12;
    }

    public static final String k(long l10) {
        return s1.l(l10, 10);
    }

    public static final String l(long l10, int n10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = "java.lang.Long.toString(this, checkRadix(radix))";
        if (l12 >= 0) {
            n10 = b.a(n10);
            String string3 = Long.toString(l10, n10);
            f0.o(string3, string2);
            return string3;
        }
        l12 = 1;
        long l13 = l10 >>> l12;
        long l14 = n10;
        long l15 = (l13 = l13 / l14 << l12) * l14;
        long l16 = (l10 -= l15) - l14;
        if ((l12 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0) {
            l10 -= l14;
            l14 = 1L;
            l13 += l14;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = b.a(n10);
        String string4 = Long.toString(l13, n11);
        f0.o(string4, string2);
        stringBuilder.append(string4);
        n10 = b.a(n10);
        String string5 = Long.toString(l10, n10);
        f0.o(string5, string2);
        stringBuilder.append(string5);
        return stringBuilder.toString();
    }
}


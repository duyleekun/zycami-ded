/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import f.s1;

public class i {
    public static final short a(short s10, short s11) {
        int n10 = -1;
        int n11 = s10 & n10;
        n10 &= s11;
        if ((n10 = f0.t(n11, n10)) < 0) {
            s10 = s11;
        }
        return s10;
    }

    public static final int b(int n10, int n11) {
        int n12 = s1.c(n10, n11);
        if (n12 < 0) {
            n10 = n11;
        }
        return n10;
    }

    public static final byte c(byte by2, byte by3) {
        int n10 = by2 & 0xFF;
        int n11 = by3 & 0xFF;
        if ((n10 = f0.t(n10, n11)) < 0) {
            by2 = by3;
        }
        return by2;
    }

    public static final int d(int n10, int ... nArray) {
        String string2 = "other";
        f0.p(nArray, string2);
        for (int n11 : nArray) {
            n10 = i.b(n10, n11);
        }
        return n10;
    }

    public static final long e(long l10, long ... lArray) {
        String string2 = "other";
        f0.p(lArray, string2);
        for (long l11 : lArray) {
            l10 = i.j(l10, l11);
        }
        return l10;
    }

    private static final short f(short s10, short s11, short s12) {
        s11 = i.a(s11, s12);
        return i.a(s10, s11);
    }

    private static final int g(int n10, int n11, int n12) {
        n11 = i.b(n11, n12);
        return i.b(n10, n11);
    }

    public static final byte h(byte by2, byte ... byArray) {
        String string2 = "other";
        f0.p(byArray, string2);
        for (byte by3 : byArray) {
            by2 = i.c(by2, by3);
        }
        return by2;
    }

    private static final byte i(byte by2, byte by3, byte by4) {
        by3 = i.c(by3, by4);
        return i.c(by2, by3);
    }

    public static final long j(long l10, long l11) {
        int n10 = s1.g(l10, l11);
        if (n10 < 0) {
            l10 = l11;
        }
        return l10;
    }

    private static final long k(long l10, long l11, long l12) {
        l11 = i.j(l11, l12);
        return i.j(l10, l11);
    }

    public static final short l(short s10, short ... sArray) {
        String string2 = "other";
        f0.p(sArray, string2);
        for (short s11 : sArray) {
            s10 = i.a(s10, s11);
        }
        return s10;
    }

    public static final short m(short s10, short s11) {
        int n10 = -1;
        int n11 = s10 & n10;
        n10 &= s11;
        if ((n10 = f0.t(n11, n10)) > 0) {
            s10 = s11;
        }
        return s10;
    }

    public static final int n(int n10, int n11) {
        int n12 = s1.c(n10, n11);
        if (n12 > 0) {
            n10 = n11;
        }
        return n10;
    }

    public static final byte o(byte by2, byte by3) {
        int n10 = by2 & 0xFF;
        int n11 = by3 & 0xFF;
        if ((n10 = f0.t(n10, n11)) > 0) {
            by2 = by3;
        }
        return by2;
    }

    public static final int p(int n10, int ... nArray) {
        String string2 = "other";
        f0.p(nArray, string2);
        for (int n11 : nArray) {
            n10 = i.n(n10, n11);
        }
        return n10;
    }

    public static final long q(long l10, long ... lArray) {
        String string2 = "other";
        f0.p(lArray, string2);
        for (long l11 : lArray) {
            l10 = i.v(l10, l11);
        }
        return l10;
    }

    private static final short r(short s10, short s11, short s12) {
        s11 = i.m(s11, s12);
        return i.m(s10, s11);
    }

    private static final int s(int n10, int n11, int n12) {
        n11 = i.n(n11, n12);
        return i.n(n10, n11);
    }

    public static final byte t(byte by2, byte ... byArray) {
        String string2 = "other";
        f0.p(byArray, string2);
        for (byte by3 : byArray) {
            by2 = i.o(by2, by3);
        }
        return by2;
    }

    private static final byte u(byte by2, byte by3, byte by4) {
        by3 = i.o(by3, by4);
        return i.o(by2, by3);
    }

    public static final long v(long l10, long l11) {
        int n10 = s1.g(l10, l11);
        if (n10 > 0) {
            l10 = l11;
        }
        return l10;
    }

    private static final long w(long l10, long l11, long l12) {
        l11 = i.v(l11, l12);
        return i.v(l10, l11);
    }

    public static final short x(short s10, short ... sArray) {
        String string2 = "other";
        f0.p(sArray, string2);
        for (short s11 : sArray) {
            s10 = i.m(s10, s11);
        }
        return s10;
    }
}


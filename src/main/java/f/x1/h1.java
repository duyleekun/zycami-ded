/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.d1;
import f.h2.t.f0;
import f.n1;
import f.s1;
import f.z0;

public final class h1 {
    private static final int a(long[] lArray, int n10, int n11) {
        int n12 = (n10 + n11) / 2;
        long l10 = f.h1.l(lArray, n12);
        while (n10 <= n11) {
            long l11;
            int n13;
            while ((n13 = s1.g(l11 = f.h1.l(lArray, n10), l10)) < 0) {
                ++n10;
            }
            while ((n13 = s1.g(l11 = f.h1.l(lArray, n11), l10)) > 0) {
                n11 += -1;
            }
            if (n10 > n11) continue;
            l11 = f.h1.l(lArray, n10);
            long l12 = f.h1.l(lArray, n11);
            f.h1.t(lArray, n10, l12);
            f.h1.t(lArray, n11, l11);
            ++n10;
            n11 += -1;
        }
        return n10;
    }

    private static final int b(byte[] byArray, int n10, int n11) {
        int n12 = (n10 + n11) / 2;
        n12 = z0.l(byArray, n12);
        while (n10 <= n11) {
            int n13;
            byte by2;
            while (true) {
                by2 = z0.l(byArray, n10) & 0xFF;
                n13 = n12 & 0xFF;
                if ((by2 = f0.t(by2, n13)) >= 0) break;
                ++n10;
            }
            while ((by2 = f0.t(z0.l(byArray, n11) & 0xFF, n13)) > 0) {
                n11 += -1;
            }
            if (n10 > n11) continue;
            by2 = z0.l(byArray, n10);
            n13 = z0.l(byArray, n11);
            z0.t(byArray, n10, (byte)n13);
            z0.t(byArray, n11, by2);
            ++n10;
            n11 += -1;
        }
        return n10;
    }

    private static final int c(short[] sArray, int n10, int n11) {
        int n12 = (n10 + n11) / 2;
        n12 = n1.l(sArray, n12);
        while (n10 <= n11) {
            int n13;
            short s10;
            short s11;
            while (true) {
                s11 = n1.l(sArray, n10);
                s10 = (short)-1;
                s11 &= s10;
                n13 = n12 & s10;
                if ((s11 = f0.t(s11, n13)) >= 0) break;
                ++n10;
            }
            while ((s11 = f0.t(n1.l(sArray, n11) & s10, n13)) > 0) {
                n11 += -1;
            }
            if (n10 > n11) continue;
            s11 = n1.l(sArray, n10);
            s10 = n1.l(sArray, n11);
            n1.t(sArray, n10, s10);
            n1.t(sArray, n11, s11);
            ++n10;
            n11 += -1;
        }
        return n10;
    }

    private static final int d(int[] nArray, int n10, int n11) {
        int n12 = (n10 + n11) / 2;
        n12 = d1.l(nArray, n12);
        while (n10 <= n11) {
            int n13;
            while ((n13 = s1.c(d1.l(nArray, n10), n12)) < 0) {
                ++n10;
            }
            while ((n13 = s1.c(d1.l(nArray, n11), n12)) > 0) {
                n11 += -1;
            }
            if (n10 > n11) continue;
            n13 = d1.l(nArray, n10);
            int n14 = d1.l(nArray, n11);
            d1.t(nArray, n10, n14);
            d1.t(nArray, n11, n13);
            ++n10;
            n11 += -1;
        }
        return n10;
    }

    private static final void e(long[] lArray, int n10, int n11) {
        int n12 = h1.a(lArray, n10, n11);
        int n13 = n12 + -1;
        if (n10 < n13) {
            h1.e(lArray, n10, n13);
        }
        if (n12 < n11) {
            h1.e(lArray, n12, n11);
        }
    }

    private static final void f(byte[] byArray, int n10, int n11) {
        int n12 = h1.b(byArray, n10, n11);
        int n13 = n12 + -1;
        if (n10 < n13) {
            h1.f(byArray, n10, n13);
        }
        if (n12 < n11) {
            h1.f(byArray, n12, n11);
        }
    }

    private static final void g(short[] sArray, int n10, int n11) {
        int n12 = h1.c(sArray, n10, n11);
        int n13 = n12 + -1;
        if (n10 < n13) {
            h1.g(sArray, n10, n13);
        }
        if (n12 < n11) {
            h1.g(sArray, n12, n11);
        }
    }

    private static final void h(int[] nArray, int n10, int n11) {
        int n12 = h1.d(nArray, n10, n11);
        int n13 = n12 + -1;
        if (n10 < n13) {
            h1.h(nArray, n10, n13);
        }
        if (n12 < n11) {
            h1.h(nArray, n12, n11);
        }
    }

    public static final void i(long[] lArray, int n10, int n11) {
        f0.p(lArray, "array");
        h1.e(lArray, n10, n11 += -1);
    }

    public static final void j(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "array");
        h1.f(byArray, n10, n11 += -1);
    }

    public static final void k(short[] sArray, int n10, int n11) {
        f0.p(sArray, "array");
        h1.g(sArray, n10, n11 += -1);
    }

    public static final void l(int[] nArray, int n10, int n11) {
        f0.p(nArray, "array");
        h1.h(nArray, n10, n11 += -1);
    }
}


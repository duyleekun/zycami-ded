/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

import f.c1;
import f.g1;
import f.s1;

public final class p {
    private static final int a(int n10, int n11, int n12) {
        n10 = s1.e(n10, n12);
        n11 = s1.e(n11, n12);
        int n13 = s1.c(n10, n11);
        n10 = c1.h(n10 - n11);
        if (n13 < 0) {
            n10 = c1.h(n10 + n12);
        }
        return n10;
    }

    private static final long b(long l10, long l11, long l12) {
        l10 = s1.i(l10, l12);
        l11 = s1.i(l11, l12);
        int n10 = s1.g(l10, l11);
        l10 = g1.h(l10 - l11);
        if (n10 < 0) {
            l10 = g1.h(l10 + l12);
        }
        return l10;
    }

    public static final long c(long l10, long l11, long l12) {
        block8: {
            block7: {
                Object object;
                long l13;
                block6: {
                    l13 = 0L;
                    long l14 = l12 - l13;
                    object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object <= 0) break block6;
                    object = s1.g(l10, l11);
                    if (object < 0) {
                        long l15 = g1.h(l12);
                        l10 = p.b(l11, l10, l15);
                        l11 = g1.h(l11 - l10);
                    }
                    break block7;
                }
                if (object >= 0) break block8;
                object = s1.g(l10, l11);
                if (object > 0) {
                    l12 = -l12;
                    long l16 = g1.h(l12);
                    l13 = l10;
                    l10 = p.b(l10, l11, l16);
                    l11 = g1.h(l11 + l10);
                }
            }
            return l11;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }

    public static final int d(int n10, int n11, int n12) {
        block8: {
            block7: {
                block6: {
                    if (n12 <= 0) break block6;
                    int n13 = s1.c(n10, n11);
                    if (n13 < 0) {
                        n12 = c1.h(n12);
                        n10 = p.a(n11, n10, n12);
                        n11 = c1.h(n11 - n10);
                    }
                    break block7;
                }
                if (n12 >= 0) break block8;
                int n14 = s1.c(n10, n11);
                if (n14 > 0) {
                    n12 = c1.h(-n12);
                    n10 = p.a(n10, n11, n12);
                    n11 = c1.h(n11 + n10);
                }
            }
            return n11;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }
}


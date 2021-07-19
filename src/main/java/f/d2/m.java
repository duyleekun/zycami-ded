/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

public final class m {
    private static final int a(int n10, int n11, int n12) {
        n10 = m.e(n10, n12);
        n11 = m.e(n11, n12);
        return m.e(n10 - n11, n12);
    }

    private static final long b(long l10, long l11, long l12) {
        l10 = m.f(l10, l12);
        l11 = m.f(l11, l12);
        return m.f(l10 - l11, l12);
    }

    public static final int c(int n10, int n11, int n12) {
        block8: {
            block7: {
                block6: {
                    if (n12 <= 0) break block6;
                    if (n10 < n11) {
                        n10 = m.a(n11, n10, n12);
                        n11 -= n10;
                    }
                    break block7;
                }
                if (n12 >= 0) break block8;
                if (n10 > n11) {
                    n12 = -n12;
                    n10 = m.a(n10, n11, n12);
                    n11 += n10;
                }
            }
            return n11;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }

    public static final long d(long l10, long l11, long l12) {
        block8: {
            block7: {
                Object object;
                block6: {
                    long l13 = 0L;
                    long l14 = l12 - l13;
                    object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object <= 0) break block6;
                    object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (object < 0) {
                        l13 = l11;
                        l10 = m.b(l11, l10, l12);
                        l11 -= l10;
                    }
                    break block7;
                }
                if (object >= 0) break block8;
                object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (object > 0) {
                    long l15 = -l12;
                    l10 = m.b(l10, l11, l15);
                    l11 += l10;
                }
            }
            return l11;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step is zero.");
        throw illegalArgumentException;
    }

    private static final int e(int n10, int n11) {
        if ((n10 %= n11) < 0) {
            n10 += n11;
        }
        return n10;
    }

    private static final long f(long l10, long l11) {
        long l12 = 0L;
        long l13 = (l10 %= l11) - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            l10 += l11;
        }
        return l10;
    }
}


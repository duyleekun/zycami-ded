/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.g1$a;
import f.l2.w;
import f.m1;
import f.s1;
import f.y0;

public final class g1
implements Comparable {
    public static final long b = 0L;
    public static final long c = 255L;
    public static final int d = 8;
    public static final int e = 64;
    public static final g1$a f;
    private final long a;

    static {
        g1$a g1$a;
        f = g1$a = new g1$a(null);
    }

    private /* synthetic */ g1(long l10) {
        this.a = l10;
    }

    private static final long A(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return g1.h(l10 + l11);
    }

    private static final long B(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return g1.h(l10 + l11);
    }

    private static final w C(long l10, long l11) {
        w w10 = new w(l10, l11, null);
        return w10;
    }

    private static final long D(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return s1.i(l10, l11);
    }

    private static final long F(long l10, long l11) {
        return s1.i(l10, l11);
    }

    private static final long G(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return s1.i(l10, l11);
    }

    private static final long H(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return s1.i(l10, l11);
    }

    private static final long I(long l10, int n10) {
        return g1.h(l10 << n10);
    }

    private static final long J(long l10, int n10) {
        return g1.h(l10 >>> n10);
    }

    private static final long K(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return g1.h(l10 * l11);
    }

    private static final long L(long l10, long l11) {
        return g1.h(l10 * l11);
    }

    private static final long M(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return g1.h(l10 * l11);
    }

    private static final long N(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return g1.h(l10 * l11);
    }

    private static final byte P(long l10) {
        return (byte)l10;
    }

    private static final double Q(long l10) {
        return s1.j(l10);
    }

    private static final float R(long l10) {
        return (float)s1.j(l10);
    }

    private static final int S(long l10) {
        return (int)l10;
    }

    private static final long T(long l10) {
        return l10;
    }

    private static final short U(long l10) {
        return (short)l10;
    }

    public static String V(long l10) {
        return s1.k(l10);
    }

    private static final byte W(long l10) {
        return y0.h((byte)l10);
    }

    private static final int X(long l10) {
        return c1.h((int)l10);
    }

    private static final long Y(long l10) {
        return l10;
    }

    private static final short Z(long l10) {
        return m1.h((short)l10);
    }

    private static final long a(long l10, long l11) {
        return g1.h(l10 & l11);
    }

    public static final /* synthetic */ g1 b(long l10) {
        g1 g12 = new g1(l10);
        return g12;
    }

    private static final long b0(long l10, long l11) {
        return g1.h(l10 ^ l11);
    }

    private static final int c(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return s1.g(l10, l11);
    }

    private int d(long l10) {
        return g1.e(this.a, l10);
    }

    private static int e(long l10, long l11) {
        return s1.g(l10, l11);
    }

    private static final int f(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return s1.g(l10, l11);
    }

    private static final int g(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return s1.g(l10, l11);
    }

    public static long h(long l10) {
        return l10;
    }

    private static final long i(long l10) {
        return g1.h(l10 + (long)-1);
    }

    private static final long j(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return s1.h(l10, l11);
    }

    private static final long k(long l10, long l11) {
        return s1.h(l10, l11);
    }

    private static final long l(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return s1.h(l10, l11);
    }

    private static final long m(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return s1.h(l10, l11);
    }

    public static boolean n(long l10, Object object) {
        long l11;
        long l12;
        long l13;
        boolean bl2 = object instanceof g1;
        return bl2 && (l13 = (l12 = l10 - (l11 = ((g1)(object = (g1)object)).a0())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false;
    }

    public static final boolean o(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static /* synthetic */ void p() {
    }

    public static int q(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    private static final long r(long l10) {
        return g1.h(l10 + 1L);
    }

    private static final long s(long l10) {
        return g1.h(l10 ^ (long)-1);
    }

    private static final long t(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return g1.h(l10 - l11);
    }

    private static final long u(long l10, long l11) {
        return g1.h(l10 - l11);
    }

    private static final long v(long l10, int n10) {
        long l11 = g1.h((long)n10 & 0xFFFFFFFFL);
        return g1.h(l10 - l11);
    }

    private static final long w(long l10, short s10) {
        long l11 = g1.h((long)s10 & (long)((char)-1));
        return g1.h(l10 - l11);
    }

    private static final long x(long l10, long l11) {
        return g1.h(l10 | l11);
    }

    private static final long y(long l10, byte by2) {
        long l11 = g1.h((long)by2 & 0xFFL);
        return g1.h(l10 + l11);
    }

    private static final long z(long l10, long l11) {
        return g1.h(l10 + l11);
    }

    public final /* synthetic */ long a0() {
        return this.a;
    }

    public boolean equals(Object object) {
        return g1.n(this.a, object);
    }

    public int hashCode() {
        return g1.q(this.a);
    }

    public String toString() {
        return g1.V(this.a);
    }
}


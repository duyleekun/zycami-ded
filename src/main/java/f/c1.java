/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1$a;
import f.g1;
import f.l2.t;
import f.m1;
import f.s1;
import f.y0;

public final class c1
implements Comparable {
    public static final int b = 0;
    public static final int c = 255;
    public static final int d = 4;
    public static final int e = 32;
    public static final c1$a f;
    private final int a;

    static {
        c1$a c1$a;
        f = c1$a = new c1$a(null);
    }

    private /* synthetic */ c1(int n10) {
        this.a = n10;
    }

    private static final int A(int n10, int n11) {
        return c1.h(n10 + n11);
    }

    private static final int B(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(n10 + s10);
    }

    private static final t C(int n10, int n11) {
        t t10 = new t(n10, n11, null);
        return t10;
    }

    private static final int D(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return s1.e(n10, by2);
    }

    private static final long F(int n10, long l10) {
        return s1.i(g1.h((long)n10 & 0xFFFFFFFFL), l10);
    }

    private static final int G(int n10, int n11) {
        return s1.e(n10, n11);
    }

    private static final int H(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return s1.e(n10, s10);
    }

    private static final int I(int n10, int n11) {
        return c1.h(n10 << n11);
    }

    private static final int J(int n10, int n11) {
        return c1.h(n10 >>> n11);
    }

    private static final int K(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(n10 * by2);
    }

    private static final long L(int n10, long l10) {
        return g1.h(g1.h((long)n10 & 0xFFFFFFFFL) * l10);
    }

    private static final int M(int n10, int n11) {
        return c1.h(n10 * n11);
    }

    private static final int N(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(n10 * s10);
    }

    private static final byte P(int n10) {
        return (byte)n10;
    }

    private static final double Q(int n10) {
        return s1.f(n10);
    }

    private static final float R(int n10) {
        return (float)s1.f(n10);
    }

    private static final int S(int n10) {
        return n10;
    }

    private static final long T(int n10) {
        return (long)n10 & 0xFFFFFFFFL;
    }

    private static final short U(int n10) {
        return (short)n10;
    }

    public static String V(int n10) {
        return String.valueOf((long)n10 & 0xFFFFFFFFL);
    }

    private static final byte W(int n10) {
        return y0.h((byte)n10);
    }

    private static final int X(int n10) {
        return n10;
    }

    private static final long Y(int n10) {
        return g1.h((long)n10 & 0xFFFFFFFFL);
    }

    private static final short Z(int n10) {
        return m1.h((short)n10);
    }

    private static final int a(int n10, int n11) {
        return c1.h(n10 & n11);
    }

    public static final /* synthetic */ c1 b(int n10) {
        c1 c12 = new c1(n10);
        return c12;
    }

    private static final int b0(int n10, int n11) {
        return c1.h(n10 ^ n11);
    }

    private static final int c(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return s1.c(n10, by2);
    }

    private static final int d(int n10, long l10) {
        return s1.g(g1.h((long)n10 & 0xFFFFFFFFL), l10);
    }

    private int e(int n10) {
        return c1.f(this.a, n10);
    }

    private static int f(int n10, int n11) {
        return s1.c(n10, n11);
    }

    private static final int g(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return s1.c(n10, s10);
    }

    public static int h(int n10) {
        return n10;
    }

    private static final int i(int n10) {
        return c1.h(n10 + -1);
    }

    private static final int j(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return s1.d(n10, by2);
    }

    private static final long k(int n10, long l10) {
        return s1.h(g1.h((long)n10 & 0xFFFFFFFFL), l10);
    }

    private static final int l(int n10, int n11) {
        return s1.d(n10, n11);
    }

    private static final int m(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return s1.d(n10, s10);
    }

    public static boolean n(int n10, Object object) {
        int n11;
        boolean bl2 = object instanceof c1;
        return bl2 && n10 == (n11 = ((c1)(object = (c1)object)).a0());
    }

    public static final boolean o(int n10, int n11) {
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ void p() {
    }

    public static int q(int n10) {
        return n10;
    }

    private static final int r(int n10) {
        return c1.h(n10 + 1);
    }

    private static final int s(int n10) {
        return c1.h(~n10);
    }

    private static final int t(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(n10 - by2);
    }

    private static final long u(int n10, long l10) {
        return g1.h(g1.h((long)n10 & 0xFFFFFFFFL) - l10);
    }

    private static final int v(int n10, int n11) {
        return c1.h(n10 - n11);
    }

    private static final int w(int n10, short s10) {
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(n10 - s10);
    }

    private static final int x(int n10, int n11) {
        return c1.h(n10 | n11);
    }

    private static final int y(int n10, byte by2) {
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(n10 + by2);
    }

    private static final long z(int n10, long l10) {
        return g1.h(g1.h((long)n10 & 0xFFFFFFFFL) + l10);
    }

    public final /* synthetic */ int a0() {
        return this.a;
    }

    public boolean equals(Object object) {
        return c1.n(this.a, object);
    }

    public int hashCode() {
        return c1.q(this.a);
    }

    public String toString() {
        return c1.V(this.a);
    }
}


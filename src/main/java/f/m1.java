/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.l2.t;
import f.m1$a;
import f.s1;
import f.y0;

public final class m1
implements Comparable {
    public static final short b = 0;
    public static final short c = 255;
    public static final int d = 2;
    public static final int e = 16;
    public static final m1$a f;
    private final short a;

    static {
        m1$a m1$a;
        f = m1$a = new m1$a(null);
    }

    private /* synthetic */ m1(short s10) {
        this.a = s10;
    }

    private static final int A(short s10, int n10) {
        return c1.h(c1.h(s10 & (char)-1) + n10);
    }

    private static final int B(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return c1.h(s10 + s11);
    }

    private static final t C(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        t t10 = new t(s10, s11, null);
        return t10;
    }

    private static final int D(short s10, byte by2) {
        s10 = (short)c1.h(s10 & (char)-1);
        by2 = (byte)c1.h(by2 & 0xFF);
        return s1.e(s10, by2);
    }

    private static final long F(short s10, long l10) {
        return s1.i(g1.h((long)s10 & (long)((char)-1)), l10);
    }

    private static final int G(short s10, int n10) {
        return s1.e(c1.h(s10 & (char)-1), n10);
    }

    private static final int H(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return s1.e(s10, s11);
    }

    private static final int I(short s10, byte by2) {
        s10 = (short)c1.h(s10 & (char)-1);
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(s10 * by2);
    }

    private static final long J(short s10, long l10) {
        return g1.h(g1.h((long)s10 & (long)((char)-1)) * l10);
    }

    private static final int K(short s10, int n10) {
        return c1.h(c1.h(s10 & (char)-1) * n10);
    }

    private static final int L(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return c1.h(s10 * s11);
    }

    private static final byte M(short s10) {
        return (byte)s10;
    }

    private static final double N(short s10) {
        return s10 & (char)-1;
    }

    private static final float P(short s10) {
        return s10 & (char)-1;
    }

    private static final int Q(short s10) {
        return s10 & (char)-1;
    }

    private static final long R(short s10) {
        return (long)s10 & (long)((char)-1);
    }

    private static final short S(short s10) {
        return s10;
    }

    public static String T(short s10) {
        return String.valueOf(s10 & (char)-1);
    }

    private static final byte U(short s10) {
        return y0.h((byte)s10);
    }

    private static final int V(short s10) {
        return c1.h(s10 & (char)-1);
    }

    private static final long W(short s10) {
        return g1.h((long)s10 & (long)((char)-1));
    }

    private static final short X(short s10) {
        return s10;
    }

    private static final short Z(short s10, short s11) {
        return m1.h((short)(s10 ^ s11));
    }

    private static final short a(short s10, short s11) {
        return m1.h((short)(s10 & s11));
    }

    public static final /* synthetic */ m1 b(short s10) {
        m1 m12 = new m1(s10);
        return m12;
    }

    private static final int c(short s10, byte by2) {
        s10 = (short)(s10 & (char)-1);
        by2 = (byte)(by2 & 0xFF);
        return f0.t(s10, by2);
    }

    private static final int d(short s10, long l10) {
        return s1.g(g1.h((long)s10 & (long)((char)-1)), l10);
    }

    private static final int e(short s10, int n10) {
        return s1.c(c1.h(s10 & (char)-1), n10);
    }

    private int f(short s10) {
        return m1.g(this.a, s10);
    }

    private static int g(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)(s10 & c10);
        s11 = (short)(s11 & c10);
        return f0.t(s10, s11);
    }

    public static short h(short s10) {
        return s10;
    }

    private static final short i(short s10) {
        return m1.h((short)(s10 + -1));
    }

    private static final int j(short s10, byte by2) {
        s10 = (short)c1.h(s10 & (char)-1);
        by2 = (byte)c1.h(by2 & 0xFF);
        return s1.d(s10, by2);
    }

    private static final long k(short s10, long l10) {
        return s1.h(g1.h((long)s10 & (long)((char)-1)), l10);
    }

    private static final int l(short s10, int n10) {
        return s1.d(c1.h(s10 & (char)-1), n10);
    }

    private static final int m(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return s1.d(s10, s11);
    }

    public static boolean n(short s10, Object object) {
        short s11;
        boolean bl2 = object instanceof m1;
        return bl2 && s10 == (s11 = ((m1)(object = (m1)object)).Y());
    }

    public static final boolean o(short s10, short s11) {
        s10 = s10 == s11 ? (short)1 : 0;
        return s10 != 0;
    }

    public static /* synthetic */ void p() {
    }

    public static int q(short s10) {
        return s10;
    }

    private static final short r(short s10) {
        return m1.h((short)(s10 + 1));
    }

    private static final short s(short s10) {
        return m1.h(~s10);
    }

    private static final int t(short s10, byte by2) {
        s10 = (short)c1.h(s10 & (char)-1);
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(s10 - by2);
    }

    private static final long u(short s10, long l10) {
        return g1.h(g1.h((long)s10 & (long)((char)-1)) - l10);
    }

    private static final int v(short s10, int n10) {
        return c1.h(c1.h(s10 & (char)-1) - n10);
    }

    private static final int w(short s10, short s11) {
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return c1.h(s10 - s11);
    }

    private static final short x(short s10, short s11) {
        return m1.h((short)(s10 | s11));
    }

    private static final int y(short s10, byte by2) {
        s10 = (short)c1.h(s10 & (char)-1);
        by2 = (byte)c1.h(by2 & 0xFF);
        return c1.h(s10 + by2);
    }

    private static final long z(short s10, long l10) {
        return g1.h(g1.h((long)s10 & (long)((char)-1)) + l10);
    }

    public final /* synthetic */ short Y() {
        return this.a;
    }

    public boolean equals(Object object) {
        return m1.n(this.a, object);
    }

    public int hashCode() {
        return m1.q(this.a);
    }

    public String toString() {
        return m1.T(this.a);
    }
}


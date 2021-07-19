/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.l2.t;
import f.m1;
import f.s1;
import f.y0$a;

public final class y0
implements Comparable {
    public static final byte b = 0;
    public static final byte c = -1;
    public static final int d = 1;
    public static final int e = 8;
    public static final y0$a f;
    private final byte a;

    static {
        y0$a y0$a;
        f = y0$a = new y0$a(null);
    }

    private /* synthetic */ y0(byte by2) {
        this.a = by2;
    }

    private static final int A(byte by2, int n10) {
        return c1.h(c1.h(by2 & 0xFF) + n10);
    }

    private static final int B(byte by2, short s10) {
        by2 = (byte)c1.h(by2 & 0xFF);
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(by2 + s10);
    }

    private static final t C(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        t t10 = new t(by2, by3, null);
        return t10;
    }

    private static final int D(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return s1.e(by2, by3);
    }

    private static final long F(byte by2, long l10) {
        return s1.i(g1.h((long)by2 & 0xFFL), l10);
    }

    private static final int G(byte by2, int n10) {
        return s1.e(c1.h(by2 & 0xFF), n10);
    }

    private static final int H(byte by2, short s10) {
        by2 = (byte)c1.h(by2 & 0xFF);
        s10 = (short)c1.h(s10 & (char)-1);
        return s1.e(by2, s10);
    }

    private static final int I(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return c1.h(by2 * by3);
    }

    private static final long J(byte by2, long l10) {
        return g1.h(g1.h((long)by2 & 0xFFL) * l10);
    }

    private static final int K(byte by2, int n10) {
        return c1.h(c1.h(by2 & 0xFF) * n10);
    }

    private static final int L(byte by2, short s10) {
        by2 = (byte)c1.h(by2 & 0xFF);
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(by2 * s10);
    }

    private static final byte M(byte by2) {
        return by2;
    }

    private static final double N(byte by2) {
        return by2 & 0xFF;
    }

    private static final float P(byte by2) {
        return by2 & 0xFF;
    }

    private static final int Q(byte by2) {
        return by2 & 0xFF;
    }

    private static final long R(byte by2) {
        return (long)by2 & 0xFFL;
    }

    private static final short S(byte by2) {
        return (short)((short)by2 & 0xFF);
    }

    public static String T(byte by2) {
        return String.valueOf(by2 & 0xFF);
    }

    private static final byte U(byte by2) {
        return by2;
    }

    private static final int V(byte by2) {
        return c1.h(by2 & 0xFF);
    }

    private static final long W(byte by2) {
        return g1.h((long)by2 & 0xFFL);
    }

    private static final short X(byte by2) {
        return m1.h((short)((short)by2 & 0xFF));
    }

    private static final byte Z(byte by2, byte by3) {
        return y0.h((byte)(by2 ^ by3));
    }

    private static final byte a(byte by2, byte by3) {
        return y0.h((byte)(by2 & by3));
    }

    public static final /* synthetic */ y0 b(byte by2) {
        y0 y02 = new y0(by2);
        return y02;
    }

    private int c(byte by2) {
        return y0.d(this.a, by2);
    }

    private static int d(byte by2, byte by3) {
        by2 = (byte)(by2 & 0xFF);
        by3 = (byte)(by3 & 0xFF);
        return f0.t(by2, by3);
    }

    private static final int e(byte by2, long l10) {
        return s1.g(g1.h((long)by2 & 0xFFL), l10);
    }

    private static final int f(byte by2, int n10) {
        return s1.c(c1.h(by2 & 0xFF), n10);
    }

    private static final int g(byte by2, short s10) {
        by2 = (byte)(by2 & 0xFF);
        s10 = (short)(s10 & (char)-1);
        return f0.t(by2, s10);
    }

    public static byte h(byte by2) {
        return by2;
    }

    private static final byte i(byte by2) {
        return y0.h((byte)(by2 + -1));
    }

    private static final int j(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return s1.d(by2, by3);
    }

    private static final long k(byte by2, long l10) {
        return s1.h(g1.h((long)by2 & 0xFFL), l10);
    }

    private static final int l(byte by2, int n10) {
        return s1.d(c1.h(by2 & 0xFF), n10);
    }

    private static final int m(byte by2, short s10) {
        by2 = (byte)c1.h(by2 & 0xFF);
        s10 = (short)c1.h(s10 & (char)-1);
        return s1.d(by2, s10);
    }

    public static boolean n(byte by2, Object object) {
        byte by3;
        boolean bl2 = object instanceof y0;
        return bl2 && by2 == (by3 = ((y0)(object = (y0)object)).Y());
    }

    public static final boolean o(byte by2, byte by3) {
        by2 = by2 == by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    public static /* synthetic */ void p() {
    }

    public static int q(byte by2) {
        return by2;
    }

    private static final byte r(byte by2) {
        return y0.h((byte)(by2 + 1));
    }

    private static final byte s(byte by2) {
        return y0.h(~by2);
    }

    private static final int t(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return c1.h(by2 - by3);
    }

    private static final long u(byte by2, long l10) {
        return g1.h(g1.h((long)by2 & 0xFFL) - l10);
    }

    private static final int v(byte by2, int n10) {
        return c1.h(c1.h(by2 & 0xFF) - n10);
    }

    private static final int w(byte by2, short s10) {
        by2 = (byte)c1.h(by2 & 0xFF);
        s10 = (short)c1.h(s10 & (char)-1);
        return c1.h(by2 - s10);
    }

    private static final byte x(byte by2, byte by3) {
        return y0.h((byte)(by2 | by3));
    }

    private static final int y(byte by2, byte by3) {
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return c1.h(by2 + by3);
    }

    private static final long z(byte by2, long l10) {
        return g1.h(g1.h((long)by2 & 0xFFL) + l10);
    }

    public final /* synthetic */ byte Y() {
        return this.a;
    }

    public boolean equals(Object object) {
        return y0.n(this.a, object);
    }

    public int hashCode() {
        return y0.q(this.a);
    }

    public String toString() {
        return y0.T(this.a);
    }
}


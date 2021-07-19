/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import f.y1.b;

public class c
extends b {
    private static final byte A(byte by2, byte by3, byte by4) {
        by3 = (byte)Math.max(by3, by4);
        return (byte)Math.max(by2, by3);
    }

    public static final byte B(byte by2, byte ... byArray) {
        String string2 = "other";
        f0.p(byArray, string2);
        for (byte by3 : byArray) {
            by2 = (byte)Math.max(by2, by3);
        }
        return by2;
    }

    private static final double C(double d10, double d11) {
        return Math.max(d10, d11);
    }

    private static final double D(double d10, double d11, double d12) {
        d11 = Math.max(d11, d12);
        return Math.max(d10, d11);
    }

    public static final double E(double d10, double ... dArray) {
        String string2 = "other";
        f0.p(dArray, string2);
        for (double d11 : dArray) {
            d10 = Math.max(d10, d11);
        }
        return d10;
    }

    private static final float F(float f10, float f11) {
        return Math.max(f10, f11);
    }

    private static final float G(float f10, float f11, float f12) {
        f11 = Math.max(f11, f12);
        return Math.max(f10, f11);
    }

    public static final float H(float f10, float ... fArray) {
        String string2 = "other";
        f0.p(fArray, string2);
        for (float f11 : fArray) {
            f10 = Math.max(f10, f11);
        }
        return f10;
    }

    private static final int I(int n10, int n11) {
        return Math.max(n10, n11);
    }

    private static final int J(int n10, int n11, int n12) {
        n11 = Math.max(n11, n12);
        return Math.max(n10, n11);
    }

    public static final int K(int n10, int ... nArray) {
        String string2 = "other";
        f0.p(nArray, string2);
        for (int n11 : nArray) {
            n10 = Math.max(n10, n11);
        }
        return n10;
    }

    private static final long L(long l10, long l11) {
        return Math.max(l10, l11);
    }

    private static final long M(long l10, long l11, long l12) {
        l11 = Math.max(l11, l12);
        return Math.max(l10, l11);
    }

    public static final long N(long l10, long ... lArray) {
        String string2 = "other";
        f0.p(lArray, string2);
        for (long l11 : lArray) {
            l10 = Math.max(l10, l11);
        }
        return l10;
    }

    public static final Comparable O(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "a");
        String string2 = "b";
        f0.p(comparable2, string2);
        int n10 = comparable.compareTo(comparable2);
        if (n10 < 0) {
            comparable = comparable2;
        }
        return comparable;
    }

    public static final Comparable P(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        f0.p(comparable, "a");
        f0.p(comparable2, "b");
        f0.p(comparable3, "c");
        comparable2 = c.O(comparable2, comparable3);
        return c.O(comparable, comparable2);
    }

    public static final Comparable Q(Comparable comparable, Comparable ... comparableArray) {
        f0.p(comparable, "a");
        String string2 = "other";
        f0.p(comparableArray, string2);
        for (Comparable comparable2 : comparableArray) {
            comparable = c.O(comparable, comparable2);
        }
        return comparable;
    }

    private static final short R(short s10, short s11) {
        return (short)Math.max(s10, s11);
    }

    private static final short S(short s10, short s11, short s12) {
        s11 = (short)Math.max(s11, s12);
        return (short)Math.max(s10, s11);
    }

    public static final short T(short s10, short ... sArray) {
        String string2 = "other";
        f0.p(sArray, string2);
        for (short s11 : sArray) {
            s10 = (short)Math.max(s10, s11);
        }
        return s10;
    }

    private static final byte U(byte by2, byte by3) {
        return (byte)Math.min(by2, by3);
    }

    private static final byte V(byte by2, byte by3, byte by4) {
        by3 = (byte)Math.min(by3, by4);
        return (byte)Math.min(by2, by3);
    }

    public static final byte W(byte by2, byte ... byArray) {
        String string2 = "other";
        f0.p(byArray, string2);
        for (byte by3 : byArray) {
            by2 = (byte)Math.min(by2, by3);
        }
        return by2;
    }

    private static final double X(double d10, double d11) {
        return Math.min(d10, d11);
    }

    private static final double Y(double d10, double d11, double d12) {
        d11 = Math.min(d11, d12);
        return Math.min(d10, d11);
    }

    public static final double Z(double d10, double ... dArray) {
        String string2 = "other";
        f0.p(dArray, string2);
        for (double d11 : dArray) {
            d10 = Math.min(d10, d11);
        }
        return d10;
    }

    private static final float a0(float f10, float f11) {
        return Math.min(f10, f11);
    }

    private static final float b0(float f10, float f11, float f12) {
        f11 = Math.min(f11, f12);
        return Math.min(f10, f11);
    }

    public static final float c0(float f10, float ... fArray) {
        String string2 = "other";
        f0.p(fArray, string2);
        for (float f11 : fArray) {
            f10 = Math.min(f10, f11);
        }
        return f10;
    }

    private static final int d0(int n10, int n11) {
        return Math.min(n10, n11);
    }

    private static final int e0(int n10, int n11, int n12) {
        n11 = Math.min(n11, n12);
        return Math.min(n10, n11);
    }

    public static final int f0(int n10, int ... nArray) {
        String string2 = "other";
        f0.p(nArray, string2);
        for (int n11 : nArray) {
            n10 = Math.min(n10, n11);
        }
        return n10;
    }

    private static final long g0(long l10, long l11) {
        return Math.min(l10, l11);
    }

    private static final long h0(long l10, long l11, long l12) {
        l11 = Math.min(l11, l12);
        return Math.min(l10, l11);
    }

    public static final long i0(long l10, long ... lArray) {
        String string2 = "other";
        f0.p(lArray, string2);
        for (long l11 : lArray) {
            l10 = Math.min(l10, l11);
        }
        return l10;
    }

    public static final Comparable j0(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "a");
        String string2 = "b";
        f0.p(comparable2, string2);
        int n10 = comparable.compareTo(comparable2);
        if (n10 > 0) {
            comparable = comparable2;
        }
        return comparable;
    }

    public static final Comparable k0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        f0.p(comparable, "a");
        f0.p(comparable2, "b");
        f0.p(comparable3, "c");
        comparable2 = c.j0(comparable2, comparable3);
        return c.j0(comparable, comparable2);
    }

    public static final Comparable l0(Comparable comparable, Comparable ... comparableArray) {
        f0.p(comparable, "a");
        String string2 = "other";
        f0.p(comparableArray, string2);
        for (Comparable comparable2 : comparableArray) {
            comparable = c.j0(comparable, comparable2);
        }
        return comparable;
    }

    private static final short m0(short s10, short s11) {
        return (short)Math.min(s10, s11);
    }

    private static final short n0(short s10, short s11, short s12) {
        s11 = (short)Math.min(s11, s12);
        return (short)Math.min(s10, s11);
    }

    public static final short o0(short s10, short ... sArray) {
        String string2 = "other";
        f0.p(sArray, string2);
        for (short s11 : sArray) {
            s10 = (short)Math.min(s10, s11);
        }
        return s10;
    }

    private static final byte z(byte by2, byte by3) {
        return (byte)Math.max(by2, by3);
    }
}


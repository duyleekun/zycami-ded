/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.b0;
import f.h2.t.v;
import f.h2.t.y;

public class c0
extends b0 {
    private static final int J(int n10) {
        return Integer.numberOfLeadingZeros(n10);
    }

    private static final int K(long l10) {
        return Long.numberOfLeadingZeros(l10);
    }

    private static final int L(int n10) {
        return Integer.bitCount(n10);
    }

    private static final int M(long l10) {
        return Long.bitCount(l10);
    }

    private static final int N(int n10) {
        return Integer.numberOfTrailingZeros(n10);
    }

    private static final int O(long l10) {
        return Long.numberOfTrailingZeros(l10);
    }

    private static final double P(v v10, long l10) {
        return Double.longBitsToDouble(l10);
    }

    private static final float Q(y y10, int n10) {
        return Float.intBitsToFloat(n10);
    }

    private static final boolean R(double d10) {
        boolean bl2;
        boolean bl3 = Double.isInfinite(d10);
        bl2 = !bl3 && !(bl2 = Double.isNaN(d10));
        return bl2;
    }

    private static final boolean S(float f10) {
        boolean bl2;
        boolean bl3 = Float.isInfinite(f10);
        if (!bl3 && !(bl2 = Float.isNaN(f10))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    private static final boolean T(double d10) {
        return Double.isInfinite(d10);
    }

    private static final boolean U(float f10) {
        return Float.isInfinite(f10);
    }

    private static final boolean V(double d10) {
        return Double.isNaN(d10);
    }

    private static final boolean W(float f10) {
        return Float.isNaN(f10);
    }

    private static final int X(int n10, int n11) {
        return Integer.rotateLeft(n10, n11);
    }

    private static final long Y(long l10, int n10) {
        return Long.rotateLeft(l10, n10);
    }

    private static final int Z(int n10, int n11) {
        return Integer.rotateRight(n10, n11);
    }

    private static final long a0(long l10, int n10) {
        return Long.rotateRight(l10, n10);
    }

    private static final int b0(int n10) {
        return Integer.highestOneBit(n10);
    }

    private static final long c0(long l10) {
        return Long.highestOneBit(l10);
    }

    private static final int d0(int n10) {
        return Integer.lowestOneBit(n10);
    }

    private static final long e0(long l10) {
        return Long.lowestOneBit(l10);
    }

    private static final int f0(float f10) {
        return Float.floatToIntBits(f10);
    }

    private static final long g0(double d10) {
        return Double.doubleToLongBits(d10);
    }

    private static final int h0(float f10) {
        return Float.floatToRawIntBits(f10);
    }

    private static final long i0(double d10) {
        return Double.doubleToRawLongBits(d10);
    }
}


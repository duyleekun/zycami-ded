/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.d0;
import f.g1;
import f.m1;
import f.y0;

public final class l1 {
    private static final int A(int n10) {
        return c1.h(Integer.lowestOneBit(n10));
    }

    private static final short B(short s10) {
        return m1.h((short)Integer.lowestOneBit(s10 & (char)-1));
    }

    private static final int a(byte by2) {
        return Integer.numberOfLeadingZeros(by2 & 0xFF) + -24;
    }

    private static final int b(long l10) {
        return Long.numberOfLeadingZeros(l10);
    }

    private static final int c(int n10) {
        return Integer.numberOfLeadingZeros(n10);
    }

    private static final int d(short s10) {
        return Integer.numberOfLeadingZeros(s10 & (char)-1) + -16;
    }

    private static final int e(byte by2) {
        return Integer.bitCount(c1.h(by2 & 0xFF));
    }

    private static final int f(long l10) {
        return Long.bitCount(l10);
    }

    private static final int g(int n10) {
        return Integer.bitCount(n10);
    }

    private static final int h(short s10) {
        return Integer.bitCount(c1.h(s10 & (char)-1));
    }

    private static final int i(byte by2) {
        return Integer.numberOfTrailingZeros(by2 | 0x100);
    }

    private static final int j(long l10) {
        return Long.numberOfTrailingZeros(l10);
    }

    private static final int k(int n10) {
        return Integer.numberOfTrailingZeros(n10);
    }

    private static final int l(short s10) {
        return Integer.numberOfTrailingZeros(s10 | 0x10000);
    }

    private static final long m(long l10, int n10) {
        return g1.h(Long.rotateLeft(l10, n10));
    }

    private static final byte n(byte by2, int n10) {
        return y0.h(d0.p0(by2, n10));
    }

    private static final int o(int n10, int n11) {
        return c1.h(Integer.rotateLeft(n10, n11));
    }

    private static final short p(short s10, int n10) {
        return m1.h(d0.q0(s10, n10));
    }

    private static final long q(long l10, int n10) {
        return g1.h(Long.rotateRight(l10, n10));
    }

    private static final byte r(byte by2, int n10) {
        return y0.h(d0.r0(by2, n10));
    }

    private static final int s(int n10, int n11) {
        return c1.h(Integer.rotateRight(n10, n11));
    }

    private static final short t(short s10, int n10) {
        return m1.h(d0.s0(s10, n10));
    }

    private static final byte u(byte by2) {
        return y0.h((byte)Integer.highestOneBit(by2 & 0xFF));
    }

    private static final long v(long l10) {
        return g1.h(Long.highestOneBit(l10));
    }

    private static final int w(int n10) {
        return c1.h(Integer.highestOneBit(n10));
    }

    private static final short x(short s10) {
        return m1.h((short)Integer.highestOneBit(s10 & (char)-1));
    }

    private static final byte y(byte by2) {
        return y0.h((byte)Integer.lowestOneBit(by2 & 0xFF));
    }

    private static final long z(long l10) {
        return g1.h(Long.lowestOneBit(l10));
    }
}


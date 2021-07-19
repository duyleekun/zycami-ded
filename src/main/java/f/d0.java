/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c0;

public class d0
extends c0 {
    private static final int j0(byte by2) {
        return Integer.numberOfLeadingZeros(by2 & 0xFF) + -24;
    }

    private static final int k0(short s10) {
        return Integer.numberOfLeadingZeros(s10 & (char)-1) + -16;
    }

    private static final int l0(byte by2) {
        return Integer.bitCount(by2 & 0xFF);
    }

    private static final int m0(short s10) {
        return Integer.bitCount(s10 & (char)-1);
    }

    private static final int n0(byte by2) {
        return Integer.numberOfTrailingZeros(by2 | 0x100);
    }

    private static final int o0(short s10) {
        return Integer.numberOfTrailingZeros(s10 | 0x10000);
    }

    public static final byte p0(byte by2, int n10) {
        int n11 = by2 << (n10 &= 7);
        by2 = (byte)(by2 & 0xFF);
        n10 = 8 - n10;
        return (byte)(by2 >>> n10 | n11);
    }

    public static final short q0(short s10, int n10) {
        int n11 = s10 << (n10 &= 0xF);
        s10 = (short)(s10 & (char)-1);
        n10 = 16 - n10;
        return (short)(s10 >>> n10 | n11);
    }

    public static final byte r0(byte by2, int n10) {
        int n11 = 8 - (n10 &= 7);
        n11 = by2 << n11;
        return (byte)((by2 & 0xFF) >>> n10 | n11);
    }

    public static final short s0(short s10, int n10) {
        int n11 = 16 - (n10 &= 0xF);
        n11 = s10 << n11;
        return (short)((s10 & (char)-1) >>> n10 | n11);
    }

    private static final byte t0(byte by2) {
        return (byte)Integer.highestOneBit(by2 & 0xFF);
    }

    private static final short u0(short s10) {
        return (short)Integer.highestOneBit(s10 & (char)-1);
    }

    private static final byte v0(byte by2) {
        return (byte)Integer.lowestOneBit(by2);
    }

    private static final short w0(short s10) {
        return (short)Integer.lowestOneBit(s10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import java.util.Arrays;

public final class Longs$AsciiDigits {
    private static final byte[] asciiDigits;

    static {
        int n10;
        int n11;
        int n12 = 128;
        byte[] byArray = new byte[n12];
        Arrays.fill(byArray, (byte)-1);
        int n13 = 0;
        for (n11 = 0; n11 <= (n10 = 9); ++n11) {
            byte by2;
            n10 = n11 + 48;
            byArray[n10] = by2 = (byte)n11;
        }
        while (n13 <= (n11 = 26)) {
            n11 = n13 + 65;
            byArray[n11] = n10 = (int)((byte)(n13 + 10));
            n11 = n13 + 97;
            byArray[n11] = n10;
            ++n13;
        }
        asciiDigits = byArray;
    }

    private Longs$AsciiDigits() {
    }

    public static int digit(char c10) {
        char c11 = '\u0080';
        if (c10 < c11) {
            byte[] byArray = asciiDigits;
            c10 = byArray[c10];
        } else {
            c10 = (char)-1;
        }
        return c10;
    }
}


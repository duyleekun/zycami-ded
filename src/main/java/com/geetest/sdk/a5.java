/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public class a5 {
    private static char[] a;
    private static byte[] b;

    static {
        int n10;
        char[] cArray;
        int n11;
        int n12;
        int n13 = 64;
        a = new char[n13];
        int n14 = 0;
        int n15 = 0;
        Object[] objectArray = null;
        for (n12 = 65; n12 <= (n11 = 90); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        for (n12 = 97; n12 <= (n11 = 122); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        for (n12 = 48; n12 <= (n11 = 57); n12 = (int)((char)(n12 + 1))) {
            cArray = a;
            n10 = n15 + 1;
            cArray[n15] = n12;
            n15 = n10;
        }
        Object[] objectArray2 = a;
        n11 = n15 + 1;
        objectArray2[n15] = n10 = 40;
        objectArray2[n11] = n15 = 41;
        b = new byte[128];
        objectArray2 = null;
        for (n12 = 0; n12 < (n11 = (objectArray = b).length); ++n12) {
            objectArray[n12] = n11 = -1;
        }
        while (n14 < n13) {
            objectArray2 = b;
            objectArray = a;
            n15 = objectArray[n14];
            objectArray2[n15] = n11 = (int)((byte)n14);
            ++n14;
        }
    }

    public static char[] a(byte[] byArray) {
        int n10 = byArray.length;
        return a5.a(byArray, n10);
    }

    public static char[] a(byte[] byArray, int n10) {
        int n11 = (n10 * 4 + 2) / 3;
        int n12 = (n10 + 2) / 3 * 4;
        char[] cArray = new char[n12];
        int n13 = 0;
        int n14 = 0;
        while (n13 < n10) {
            int n15;
            int n16;
            int n17;
            int n18 = n13 + 1;
            n13 = byArray[n13] & 0xFF;
            if (n18 < n10) {
                n17 = n18 + 1;
                n18 = byArray[n18] & 0xFF;
                n16 = n17;
                n17 = n18;
                n18 = n16;
            } else {
                n17 = 0;
            }
            if (n18 < n10) {
                n15 = n18 + 1;
                n18 = byArray[n18] & 0xFF;
                n16 = n15;
                n15 = n18;
                n18 = n16;
            } else {
                n15 = 0;
            }
            int n19 = (n13 & 0x60) >>> 1;
            int n20 = n13 & 0xF;
            n19 |= n20;
            n20 = (n13 & 0x80) >>> 2;
            n13 = n13 & 0x10 | n20;
            n20 = (n17 & 0x80) >>> 4;
            n13 |= n20;
            n20 = (n17 & 0x30) >>> 3;
            n13 |= n20;
            n20 = (n17 & 4) >>> 2;
            n13 |= n20;
            n20 = (n17 & 0x40) >>> 1;
            int n21 = (n17 & 8) << 1;
            n17 = (n17 & 3) << 2 | (n20 |= n21);
            n20 = (n15 & 0x10) >>> 3;
            n17 |= n20;
            n20 = (n15 & 4) >>> 2;
            n17 |= n20;
            n20 = (n15 & 0xE0) >>> 2;
            n21 = (n15 & 8) >> 1;
            n15 = n15 & 3 | (n20 |= n21);
            n20 = n14 + 1;
            char[] cArray2 = a;
            cArray[n14] = n19 = cArray2[n19];
            n14 = n20 + 1;
            cArray[n20] = n13 = cArray2[n13];
            n13 = 46;
            n17 = n14 < n11 ? cArray2[n17] : n13;
            cArray[n14] = n17;
            if (++n14 < n11) {
                n13 = cArray2[n15];
            }
            cArray[n14] = n13;
            ++n14;
            n13 = n18;
        }
        return cArray;
    }
}


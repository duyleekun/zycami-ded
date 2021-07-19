/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public class n {
    private static final char[] a;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        a = cArray;
    }

    public static String a(byte[] byArray) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            char[] cArray = a;
            int n11 = byArray[i10] >> 4 & 0xF;
            n11 = cArray[n11];
            stringBuilder.append((char)n11);
            n11 = byArray[i10] & 0xF;
            n10 = cArray[n11];
            stringBuilder.append((char)n10);
        }
        return stringBuilder.toString();
    }
}


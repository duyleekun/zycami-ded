/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.lbsapi.auth;

public class b$a {
    public static String a(byte[] byArray) {
        char c10;
        char[] cArray;
        int n10 = 16;
        char[] cArray2 = cArray = new char[n10];
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
        int n11 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n11);
        for (n11 = 0; n11 < (c10 = byArray.length); ++n11) {
            char c10 = (byArray[n11] & 0xF0) >> 4;
            c10 = cArray[c10];
            stringBuilder.append(c10);
            char c10 = byArray[n11] & 0xF;
            c10 = cArray[c10];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }
}


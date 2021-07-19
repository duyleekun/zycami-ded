/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

public final class HEX {
    public static final char[] a;
    public static final char[] b;

    static {
        char[] cArray;
        char[] cArray2;
        int n10 = 16;
        char[] cArray3 = cArray2 = new char[n10];
        char[] cArray4 = cArray2;
        cArray3[0] = 48;
        cArray4[1] = 49;
        cArray3[2] = 50;
        cArray4[3] = 51;
        cArray3[4] = 52;
        cArray4[5] = 53;
        cArray3[6] = 54;
        cArray4[7] = 55;
        cArray3[8] = 56;
        cArray4[9] = 57;
        cArray3[10] = 97;
        cArray4[11] = 98;
        cArray3[12] = 99;
        cArray4[13] = 100;
        cArray3[14] = 101;
        cArray4[15] = 102;
        a = cArray2;
        char[] cArray5 = cArray = new char[n10];
        char[] cArray6 = cArray;
        cArray5[0] = 48;
        cArray6[1] = 49;
        cArray5[2] = 50;
        cArray6[3] = 51;
        cArray5[4] = 52;
        cArray6[5] = 53;
        cArray5[6] = 54;
        cArray6[7] = 55;
        cArray5[8] = 56;
        cArray6[9] = 57;
        cArray5[10] = 65;
        cArray6[11] = 66;
        cArray5[12] = 67;
        cArray6[13] = 68;
        cArray5[14] = 69;
        cArray6[15] = 70;
        b = cArray;
    }

    public static char[] a(byte[] byArray, char[] cArray) {
        int n10 = byArray.length;
        int n11 = n10 << 1;
        char[] cArray2 = new char[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13 = n12 + 1;
            int n14 = (byArray[i10] & 0xF0) >>> 4;
            cArray2[n12] = n14 = cArray[n14];
            n12 = n13 + 1;
            n14 = byArray[i10] & 0xF;
            cArray2[n13] = n14 = cArray[n14];
        }
        return cArray2;
    }

    public static char[] encodeHex(byte[] byArray) {
        return HEX.encodeHex(byArray, false);
    }

    public static char[] encodeHex(byte[] byArray, boolean bl2) {
        char[] cArray = bl2 ? b : a;
        return HEX.a(byArray, cArray);
    }

    public static String encodeHexString(byte[] objectArray, boolean bl2) {
        objectArray = HEX.encodeHex(objectArray, bl2);
        String string2 = new String((char[])objectArray);
        return string2;
    }
}


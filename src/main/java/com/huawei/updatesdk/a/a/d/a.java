/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d;

public class a {
    private static char[] a;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[65];
        char[] cArray3 = cArray;
        cArray2[0] = 65;
        cArray3[1] = 66;
        cArray2[2] = 67;
        cArray3[3] = 68;
        cArray2[4] = 69;
        cArray3[5] = 70;
        cArray2[6] = 71;
        cArray3[7] = 72;
        cArray2[8] = 73;
        cArray3[9] = 74;
        cArray2[10] = 75;
        cArray3[11] = 76;
        cArray2[12] = 77;
        cArray3[13] = 78;
        cArray2[14] = 79;
        cArray3[15] = 80;
        cArray2[16] = 81;
        cArray3[17] = 82;
        cArray2[18] = 83;
        cArray3[19] = 84;
        cArray2[20] = 85;
        cArray3[21] = 86;
        cArray2[22] = 87;
        cArray3[23] = 88;
        cArray2[24] = 89;
        cArray3[25] = 90;
        cArray2[26] = 97;
        cArray3[27] = 98;
        cArray2[28] = 99;
        cArray3[29] = 100;
        cArray2[30] = 101;
        cArray3[31] = 102;
        cArray2[32] = 103;
        cArray3[33] = 104;
        cArray2[34] = 105;
        cArray3[35] = 106;
        cArray2[36] = 107;
        cArray3[37] = 108;
        cArray2[38] = 109;
        cArray3[39] = 110;
        cArray2[40] = 111;
        cArray3[41] = 112;
        cArray2[42] = 113;
        cArray3[43] = 114;
        cArray2[44] = 115;
        cArray3[45] = 116;
        cArray2[46] = 117;
        cArray3[47] = 118;
        cArray2[48] = 119;
        cArray3[49] = 120;
        cArray2[50] = 121;
        cArray3[51] = 122;
        cArray2[52] = 48;
        cArray3[53] = 49;
        cArray2[54] = 50;
        cArray3[55] = 51;
        cArray2[56] = 52;
        cArray3[57] = 53;
        cArray2[58] = 54;
        cArray3[59] = 55;
        cArray2[60] = 56;
        cArray3[61] = 57;
        cArray2[62] = 43;
        cArray3[63] = 47;
        cArray3[64] = 61;
        a = cArray;
    }

    public static String a(byte[] byArray) {
        int n10 = byArray.length;
        return com.huawei.updatesdk.a.a.d.a.a(byArray, n10);
    }

    public static String a(byte[] byArray, int n10) {
        int n11 = (n10 + 2) / 3 * 4;
        char[] cArray = new char[n11];
        int n12 = 0;
        int n13 = 0;
        while (n12 < n10) {
            int n14 = (byArray[n12] & 0xFF) << 8;
            int n15 = n12 + 1;
            int n16 = 1;
            if (n15 < n10) {
                n15 = byArray[n15] & 0xFF;
                n14 |= n15;
                n15 = n16;
            } else {
                n15 = 0;
            }
            n14 <<= 8;
            int n17 = n12 + 2;
            if (n17 < n10) {
                n17 = byArray[n17] & 0xFF;
                n14 |= n17;
            } else {
                n16 = 0;
            }
            n17 = n13 + 3;
            char[] cArray2 = a;
            int n18 = 64;
            float f10 = 9.0E-44f;
            n16 = n16 != 0 ? n14 & 0x3F : n18;
            cArray[n17] = n16 = cArray2[n16];
            n14 >>= 6;
            n16 = n13 + 2;
            if (n15 != 0) {
                n18 = n14 & 0x3F;
            }
            cArray[n16] = n15 = cArray2[n18];
            n15 = n13 + 1;
            n16 = (n14 >>= 6) & 0x3F;
            cArray[n15] = n16 = cArray2[n16];
            n14 >>= 6;
            n15 = n13 + 0;
            n14 &= 0x3F;
            cArray[n15] = n14 = cArray2[n14];
            n12 += 3;
            n13 += 4;
        }
        return String.valueOf(cArray);
    }
}


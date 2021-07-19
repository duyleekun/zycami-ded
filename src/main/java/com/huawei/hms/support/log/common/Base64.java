/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.log.common;

public final class Base64 {
    public static final char[] a;
    public static final byte[] b;

    static {
        Object[] objectArray;
        char[] cArray = objectArray = new char[65];
        char[] cArray2 = objectArray;
        cArray[0] = 65;
        cArray2[1] = 66;
        cArray[2] = 67;
        cArray2[3] = 68;
        cArray[4] = 69;
        cArray2[5] = 70;
        cArray[6] = 71;
        cArray2[7] = 72;
        cArray[8] = 73;
        cArray2[9] = 74;
        cArray[10] = 75;
        cArray2[11] = 76;
        cArray[12] = 77;
        cArray2[13] = 78;
        cArray[14] = 79;
        cArray2[15] = 80;
        cArray[16] = 81;
        cArray2[17] = 82;
        cArray[18] = 83;
        cArray2[19] = 84;
        cArray[20] = 85;
        cArray2[21] = 86;
        cArray[22] = 87;
        cArray2[23] = 88;
        cArray[24] = 89;
        cArray2[25] = 90;
        cArray[26] = 97;
        cArray2[27] = 98;
        cArray[28] = 99;
        cArray2[29] = 100;
        cArray[30] = 101;
        cArray2[31] = 102;
        cArray[32] = 103;
        cArray2[33] = 104;
        cArray[34] = 105;
        cArray2[35] = 106;
        cArray[36] = 107;
        cArray2[37] = 108;
        cArray[38] = 109;
        cArray2[39] = 110;
        cArray[40] = 111;
        cArray2[41] = 112;
        cArray[42] = 113;
        cArray2[43] = 114;
        cArray[44] = 115;
        cArray2[45] = 116;
        cArray[46] = 117;
        cArray2[47] = 118;
        cArray[48] = 119;
        cArray2[49] = 120;
        cArray[50] = 121;
        cArray2[51] = 122;
        cArray[52] = 48;
        cArray2[53] = 49;
        cArray[54] = 50;
        cArray2[55] = 51;
        cArray[56] = 52;
        cArray2[57] = 53;
        cArray[58] = 54;
        cArray2[59] = 55;
        cArray[60] = 56;
        cArray2[61] = 57;
        cArray[62] = 43;
        cArray2[63] = 47;
        cArray2[64] = 61;
        a = objectArray;
        Object[] objectArray2 = objectArray = (Object[])new byte[256];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = -1;
        objectArray3[1] = -1;
        objectArray2[2] = -1;
        objectArray3[3] = -1;
        objectArray2[4] = -1;
        objectArray3[5] = -1;
        objectArray2[6] = -1;
        objectArray3[7] = -1;
        objectArray2[8] = -1;
        objectArray3[9] = -1;
        objectArray2[10] = -1;
        objectArray3[11] = -1;
        objectArray2[12] = -1;
        objectArray3[13] = -1;
        objectArray2[14] = -1;
        objectArray3[15] = -1;
        objectArray2[16] = -1;
        objectArray3[17] = -1;
        objectArray2[18] = -1;
        objectArray3[19] = -1;
        objectArray2[20] = -1;
        objectArray3[21] = -1;
        objectArray2[22] = -1;
        objectArray3[23] = -1;
        objectArray2[24] = -1;
        objectArray3[25] = -1;
        objectArray2[26] = -1;
        objectArray3[27] = -1;
        objectArray2[28] = -1;
        objectArray3[29] = -1;
        objectArray2[30] = -1;
        objectArray3[31] = -1;
        objectArray2[32] = -1;
        objectArray3[33] = -1;
        objectArray2[34] = -1;
        objectArray3[35] = -1;
        objectArray2[36] = -1;
        objectArray3[37] = -1;
        objectArray2[38] = -1;
        objectArray3[39] = -1;
        objectArray2[40] = -1;
        objectArray3[41] = -1;
        objectArray2[42] = -1;
        objectArray3[43] = 62;
        objectArray2[44] = -1;
        objectArray3[45] = -1;
        objectArray2[46] = -1;
        objectArray3[47] = 63;
        objectArray2[48] = 52;
        objectArray3[49] = 53;
        objectArray2[50] = 54;
        objectArray3[51] = 55;
        objectArray2[52] = 56;
        objectArray3[53] = 57;
        objectArray2[54] = 58;
        objectArray3[55] = 59;
        objectArray2[56] = 60;
        objectArray3[57] = 61;
        objectArray2[58] = -1;
        objectArray3[59] = -1;
        objectArray2[60] = -1;
        objectArray3[61] = -1;
        objectArray2[62] = -1;
        objectArray3[63] = -1;
        objectArray2[64] = -1;
        objectArray3[65] = '\u0000';
        objectArray2[66] = '\u0001';
        objectArray3[67] = 2;
        objectArray2[68] = 3;
        objectArray3[69] = 4;
        objectArray2[70] = 5;
        objectArray3[71] = 6;
        objectArray2[72] = 7;
        objectArray3[73] = 8;
        objectArray2[74] = 9;
        objectArray3[75] = 10;
        objectArray2[76] = 11;
        objectArray3[77] = 12;
        objectArray2[78] = 13;
        objectArray3[79] = 14;
        objectArray2[80] = 15;
        objectArray3[81] = 16;
        objectArray2[82] = 17;
        objectArray3[83] = 18;
        objectArray2[84] = 19;
        objectArray3[85] = 20;
        objectArray2[86] = 21;
        objectArray3[87] = 22;
        objectArray2[88] = 23;
        objectArray3[89] = 24;
        objectArray2[90] = 25;
        objectArray3[91] = -1;
        objectArray2[92] = -1;
        objectArray3[93] = -1;
        objectArray2[94] = -1;
        objectArray3[95] = -1;
        objectArray2[96] = -1;
        objectArray3[97] = 26;
        objectArray2[98] = 27;
        objectArray3[99] = 28;
        objectArray2[100] = 29;
        objectArray3[101] = 30;
        objectArray2[102] = 31;
        objectArray3[103] = 32;
        objectArray2[104] = 33;
        objectArray3[105] = 34;
        objectArray2[106] = 35;
        objectArray3[107] = 36;
        objectArray2[108] = 37;
        objectArray3[109] = 38;
        objectArray2[110] = 39;
        objectArray3[111] = 40;
        objectArray2[112] = 41;
        objectArray3[113] = 42;
        objectArray2[114] = 43;
        objectArray3[115] = 44;
        objectArray2[116] = 45;
        objectArray3[117] = 46;
        objectArray2[118] = 47;
        objectArray3[119] = 48;
        objectArray2[120] = 49;
        objectArray3[121] = 50;
        objectArray2[122] = 51;
        objectArray3[123] = -1;
        objectArray2[124] = -1;
        objectArray3[125] = -1;
        objectArray2[126] = -1;
        objectArray3[127] = -1;
        objectArray2[128] = -1;
        objectArray3[129] = -1;
        objectArray2[130] = -1;
        objectArray3[131] = -1;
        objectArray2[132] = -1;
        objectArray3[133] = -1;
        objectArray2[134] = -1;
        objectArray3[135] = -1;
        objectArray2[136] = -1;
        objectArray3[137] = -1;
        objectArray2[138] = -1;
        objectArray3[139] = -1;
        objectArray2[140] = -1;
        objectArray3[141] = -1;
        objectArray2[142] = -1;
        objectArray3[143] = -1;
        objectArray2[144] = -1;
        objectArray3[145] = -1;
        objectArray2[146] = -1;
        objectArray3[147] = -1;
        objectArray2[148] = -1;
        objectArray3[149] = -1;
        objectArray2[150] = -1;
        objectArray3[151] = -1;
        objectArray2[152] = -1;
        objectArray3[153] = -1;
        objectArray2[154] = -1;
        objectArray3[155] = -1;
        objectArray2[156] = -1;
        objectArray3[157] = -1;
        objectArray2[158] = -1;
        objectArray3[159] = -1;
        objectArray2[160] = -1;
        objectArray3[161] = -1;
        objectArray2[162] = -1;
        objectArray3[163] = -1;
        objectArray2[164] = -1;
        objectArray3[165] = -1;
        objectArray2[166] = -1;
        objectArray3[167] = -1;
        objectArray2[168] = -1;
        objectArray3[169] = -1;
        objectArray2[170] = -1;
        objectArray3[171] = -1;
        objectArray2[172] = -1;
        objectArray3[173] = -1;
        objectArray2[174] = -1;
        objectArray3[175] = -1;
        objectArray2[176] = -1;
        objectArray3[177] = -1;
        objectArray2[178] = -1;
        objectArray3[179] = -1;
        objectArray2[180] = -1;
        objectArray3[181] = -1;
        objectArray2[182] = -1;
        objectArray3[183] = -1;
        objectArray2[184] = -1;
        objectArray3[185] = -1;
        objectArray2[186] = -1;
        objectArray3[187] = -1;
        objectArray2[188] = -1;
        objectArray3[189] = -1;
        objectArray2[190] = -1;
        objectArray3[191] = -1;
        objectArray2[192] = -1;
        objectArray3[193] = -1;
        objectArray2[194] = -1;
        objectArray3[195] = -1;
        objectArray2[196] = -1;
        objectArray3[197] = -1;
        objectArray2[198] = -1;
        objectArray3[199] = -1;
        objectArray2[200] = -1;
        objectArray3[201] = -1;
        objectArray2[202] = -1;
        objectArray3[203] = -1;
        objectArray2[204] = -1;
        objectArray3[205] = -1;
        objectArray2[206] = -1;
        objectArray3[207] = -1;
        objectArray2[208] = -1;
        objectArray3[209] = -1;
        objectArray2[210] = -1;
        objectArray3[211] = -1;
        objectArray2[212] = -1;
        objectArray3[213] = -1;
        objectArray2[214] = -1;
        objectArray3[215] = -1;
        objectArray2[216] = -1;
        objectArray3[217] = -1;
        objectArray2[218] = -1;
        objectArray3[219] = -1;
        objectArray2[220] = -1;
        objectArray3[221] = -1;
        objectArray2[222] = -1;
        objectArray3[223] = -1;
        objectArray2[224] = -1;
        objectArray3[225] = -1;
        objectArray2[226] = -1;
        objectArray3[227] = -1;
        objectArray2[228] = -1;
        objectArray3[229] = -1;
        objectArray2[230] = -1;
        objectArray3[231] = -1;
        objectArray2[232] = -1;
        objectArray3[233] = -1;
        objectArray2[234] = -1;
        objectArray3[235] = -1;
        objectArray2[236] = -1;
        objectArray3[237] = -1;
        objectArray2[238] = -1;
        objectArray3[239] = -1;
        objectArray2[240] = -1;
        objectArray3[241] = -1;
        objectArray2[242] = -1;
        objectArray3[243] = -1;
        objectArray2[244] = -1;
        objectArray3[245] = -1;
        objectArray2[246] = -1;
        objectArray3[247] = -1;
        objectArray2[248] = -1;
        objectArray3[249] = -1;
        objectArray2[250] = -1;
        objectArray3[251] = -1;
        objectArray2[252] = -1;
        objectArray3[253] = -1;
        objectArray2[254] = -1;
        objectArray3[255] = -1;
        b = (byte[])objectArray;
    }

    public static int a(String string2) {
        int n10;
        int n11 = string2.length();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            byte[] byArray;
            int n12;
            n10 = string2.charAt(i10);
            if (n10 <= (n12 = 255) && (n10 = (byArray = b)[n10]) >= 0) continue;
            n11 += -1;
        }
        return n11;
    }

    public static byte[] decode(String string2) {
        int n10;
        int n11 = Base64.a(string2);
        int n12 = n11 / 4;
        int n13 = 3;
        n12 *= n13;
        if ((n11 %= 4) == n13) {
            n12 += 2;
        }
        if (n11 == (n13 = 2)) {
            ++n12;
        }
        byte[] byArray = new byte[n12];
        n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            int n17;
            n10 = string2.charAt(i10);
            if (n10 > (n17 = 255)) {
                n10 = -1;
            } else {
                byte[] byArray2 = b;
                n10 = byArray2[n10];
            }
            if (n10 < 0) continue;
            n15 <<= 6;
            n15 |= n10;
            n10 = 8;
            if ((n16 += 6) < n10) continue;
            n10 = n14 + 1;
            int n18 = n15 >> (n16 += -8);
            byArray[n14] = n17 = (int)((byte)(n17 & n18));
            n14 = n10;
        }
        if (n14 != n12) {
            return new byte[0];
        }
        return byArray;
    }

    public static String encode(byte[] byArray) {
        int n10 = byArray.length;
        return Base64.encode(byArray, n10);
    }

    public static String encode(byte[] object, int n10) {
        int n11 = (n10 + 2) / 3 * 4;
        char[] cArray = new char[n11];
        int n12 = 0;
        int n13 = 0;
        while (n12 < n10) {
            int n14 = (object[n12] & 0xFF) << 8;
            int n15 = n12 + 1;
            int n16 = 1;
            if (n15 < n10) {
                n15 = object[n15] & 0xFF;
                n14 |= n15;
                n15 = n16;
            } else {
                n15 = 0;
            }
            n14 <<= 8;
            int n17 = n12 + 2;
            if (n17 < n10) {
                n17 = object[n17] & 0xFF;
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
        object = new String;
        object(cArray);
        return object;
    }
}


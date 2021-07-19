/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.android.bbalbs.common.a;

public final class b {
    private static final byte[] a;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[64];
        byte[] byArray3 = byArray;
        byArray2[0] = 65;
        byArray3[1] = 66;
        byArray2[2] = 67;
        byArray3[3] = 68;
        byArray2[4] = 69;
        byArray3[5] = 70;
        byArray2[6] = 71;
        byArray3[7] = 72;
        byArray2[8] = 73;
        byArray3[9] = 74;
        byArray2[10] = 75;
        byArray3[11] = 76;
        byArray2[12] = 77;
        byArray3[13] = 78;
        byArray2[14] = 79;
        byArray3[15] = 80;
        byArray2[16] = 81;
        byArray3[17] = 82;
        byArray2[18] = 83;
        byArray3[19] = 84;
        byArray2[20] = 85;
        byArray3[21] = 86;
        byArray2[22] = 87;
        byArray3[23] = 88;
        byArray2[24] = 89;
        byArray3[25] = 90;
        byArray2[26] = 97;
        byArray3[27] = 98;
        byArray2[28] = 99;
        byArray3[29] = 100;
        byArray2[30] = 101;
        byArray3[31] = 102;
        byArray2[32] = 103;
        byArray3[33] = 104;
        byArray2[34] = 105;
        byArray3[35] = 106;
        byArray2[36] = 107;
        byArray3[37] = 108;
        byArray2[38] = 109;
        byArray3[39] = 110;
        byArray2[40] = 111;
        byArray3[41] = 112;
        byArray2[42] = 113;
        byArray3[43] = 114;
        byArray2[44] = 115;
        byArray3[45] = 116;
        byArray2[46] = 117;
        byArray3[47] = 118;
        byArray2[48] = 119;
        byArray3[49] = 120;
        byArray2[50] = 121;
        byArray3[51] = 122;
        byArray2[52] = 48;
        byArray3[53] = 49;
        byArray2[54] = 50;
        byArray3[55] = 51;
        byArray2[56] = 52;
        byArray3[57] = 53;
        byArray2[58] = 54;
        byArray3[59] = 55;
        byArray2[60] = 56;
        byArray3[61] = 57;
        byArray2[62] = 43;
        byArray3[63] = 47;
        a = byArray;
    }

    public static String a(byte[] object, String string2) {
        int n10;
        byte[] byArray;
        int n11;
        int n12;
        int n13 = ((byte[])object).length * 4 / 3;
        int n14 = n13 / 76 + 3;
        byte[] byArray2 = new byte[n13 += n14];
        n14 = ((byte[])object).length;
        int n15 = ((byte[])object).length % 3;
        n14 -= n15;
        n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        while (true) {
            n12 = 2;
            if (n16 >= n14) break;
            n11 = n17 + 1;
            byArray = a;
            n10 = (object[n16] & 0xFF) >> n12;
            byArray2[n17] = n10 = byArray[n10];
            n17 = n11 + 1;
            n10 = (object[n16] & 3) << 4;
            int n19 = n16 + 1;
            int n20 = (object[n19] & 0xFF) >> 4;
            n10 |= n20;
            byArray2[n11] = n10 = byArray[n10];
            n11 = n17 + 1;
            n12 = (object[n19] & 0xF) << 2;
            n10 = n16 + 2;
            n19 = (object[n10] & 0xFF) >> 6;
            n12 |= n19;
            byArray2[n17] = n12 = byArray[n12];
            n17 = n11 + 1;
            n12 = object[n10] & 0x3F;
            byArray2[n11] = n12 = byArray[n12];
            n12 = (n17 - n18) % 76;
            if (n12 == 0 && n17 != 0) {
                n12 = n17 + 1;
                byArray2[n17] = n11 = 10;
                ++n18;
                n17 = n12;
            }
            n16 += 3;
        }
        n16 = ((byte[])object).length % 3;
        n18 = 61;
        n11 = 1;
        if (n16 != n11) {
            if (n16 == n12) {
                n16 = n17 + 1;
                byArray = a;
                n10 = (object[n14] & 0xFF) >> n12;
                byArray2[n17] = n10 = byArray[n10];
                n17 = n16 + 1;
                n10 = (object[n14] & 3) << 4;
                n14 += n11;
                n11 = (object[n14] & 0xFF) >> 4 | n10;
                byArray2[n16] = n11 = byArray[n11];
                n16 = n17 + 1;
                int n21 = (object[n14] & 0xF) << n12;
                byArray2[n17] = n21 = byArray[n21];
                n17 = n16 + 1;
                byArray2[n16] = n18;
            }
        } else {
            n16 = n17 + 1;
            byte[] byArray3 = a;
            int n22 = object[n14] & 0xFF;
            n12 = n22 >> 2;
            byArray2[n17] = n12 = byArray3[n12];
            n17 = n16 + 1;
            int n23 = (object[n14] & 3) << 4;
            byArray2[n16] = n23 = byArray3[n23];
            n23 = n17 + 1;
            byArray2[n17] = n18;
            n17 = n23 + 1;
            byArray2[n23] = n18;
        }
        object = new String;
        object(byArray2, 0, n17, string2);
        return object;
    }

    public static byte[] a(byte[] byArray) {
        int n10 = byArray.length;
        return b.a(byArray, n10);
    }

    public static byte[] a(byte[] byArray, int n10) {
        int n11 = n10 / 4;
        int n12 = 3;
        if ((n11 *= n12) == 0) {
            return new byte[0];
        }
        byte[] byArray2 = new byte[n11];
        int n13 = n10;
        int n14 = 0;
        while (true) {
            int n15;
            int n16;
            int n17;
            int n18 = n13 + -1;
            int n19 = 10;
            if ((n18 = byArray[n18]) != n19 && n18 != (n17 = 13) && n18 != (n16 = 32) && n18 != (n15 = 9)) {
                int n20 = 61;
                if (n18 == n20) {
                    ++n14;
                } else {
                    int n21;
                    int n22;
                    n18 = 0;
                    n20 = 0;
                    int n23 = 0;
                    int n24 = 0;
                    while (true) {
                        n22 = 65280;
                        n21 = 0xFF0000;
                        if (n18 >= n13) break;
                        int n25 = byArray[n18];
                        if (n25 != n19 && n25 != n17 && n25 != n16 && n25 != n15) {
                            n19 = 65;
                            if (n25 >= n19 && n25 <= (n19 = 90)) {
                                n25 += -65;
                            } else {
                                n19 = 97;
                                if (n25 >= n19 && n25 <= (n19 = 122)) {
                                    n25 += -71;
                                } else {
                                    n19 = 48;
                                    if (n25 >= n19 && n25 <= (n19 = 57)) {
                                        n25 += 4;
                                    } else {
                                        n19 = 43;
                                        if (n25 == n19) {
                                            n25 = 62;
                                        } else {
                                            n19 = 47;
                                            if (n25 != n19) {
                                                return null;
                                            }
                                            n25 = 63;
                                        }
                                    }
                                }
                            }
                            n19 = n20 << 6;
                            n20 = (byte)n25 | n19;
                            n19 = n24 % 4;
                            if (n19 == n12) {
                                n19 = n23 + 1;
                                byArray2[n23] = n21 = (int)((byte)((n21 & n20) >> 16));
                                n23 = n19 + 1;
                                byArray2[n19] = n22 = (int)((byte)((n22 & n20) >> 8));
                                n19 = n23 + 1;
                                byArray2[n23] = n22 = (int)((byte)(n20 & 0xFF));
                                n23 = n19;
                            }
                            ++n24;
                        }
                        ++n18;
                        n19 = 10;
                    }
                    if (n14 > 0) {
                        n12 = n14 * 6;
                        n12 = n20 << n12;
                        n13 = n23 + 1;
                        byArray2[n23] = n18 = (int)((byte)((n12 & n21) >> 16));
                        n18 = 1;
                        if (n14 == n18) {
                            n23 = n13 + 1;
                            byArray2[n13] = n12 = (int)((byte)((n12 & n22) >> 8));
                        } else {
                            n23 = n13;
                        }
                    }
                    byte[] byArray3 = new byte[n23];
                    System.arraycopy(byArray2, 0, byArray3, 0, n23);
                    return byArray3;
                }
            }
            n13 += -1;
        }
    }
}


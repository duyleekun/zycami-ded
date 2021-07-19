/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import cn.leancloud.codec.Base64$Coder;

public class Base64$Encoder
extends Base64$Coder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] ENCODE;
    private static final byte[] ENCODE_WEBSAFE;
    public static final int LINE_GROUPS = 19;
    private final byte[] alphabet;
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] tail;
    public int tailLen;

    static {
        byte[] byArray;
        byte[] byArray2;
        int n10 = 64;
        byte[] byArray3 = byArray2 = new byte[n10];
        byte[] byArray4 = byArray2;
        byArray3[0] = 65;
        byArray4[1] = 66;
        byArray3[2] = 67;
        byArray4[3] = 68;
        byArray3[4] = 69;
        byArray4[5] = 70;
        byArray3[6] = 71;
        byArray4[7] = 72;
        byArray3[8] = 73;
        byArray4[9] = 74;
        byArray3[10] = 75;
        byArray4[11] = 76;
        byArray3[12] = 77;
        byArray4[13] = 78;
        byArray3[14] = 79;
        byArray4[15] = 80;
        byArray3[16] = 81;
        byArray4[17] = 82;
        byArray3[18] = 83;
        byArray4[19] = 84;
        byArray3[20] = 85;
        byArray4[21] = 86;
        byArray3[22] = 87;
        byArray4[23] = 88;
        byArray3[24] = 89;
        byArray4[25] = 90;
        byArray3[26] = 97;
        byArray4[27] = 98;
        byArray3[28] = 99;
        byArray4[29] = 100;
        byArray3[30] = 101;
        byArray4[31] = 102;
        byArray3[32] = 103;
        byArray4[33] = 104;
        byArray3[34] = 105;
        byArray4[35] = 106;
        byArray3[36] = 107;
        byArray4[37] = 108;
        byArray3[38] = 109;
        byArray4[39] = 110;
        byArray3[40] = 111;
        byArray4[41] = 112;
        byArray3[42] = 113;
        byArray4[43] = 114;
        byArray3[44] = 115;
        byArray4[45] = 116;
        byArray3[46] = 117;
        byArray4[47] = 118;
        byArray3[48] = 119;
        byArray4[49] = 120;
        byArray3[50] = 121;
        byArray4[51] = 122;
        byArray3[52] = 48;
        byArray4[53] = 49;
        byArray3[54] = 50;
        byArray4[55] = 51;
        byArray3[56] = 52;
        byArray4[57] = 53;
        byArray3[58] = 54;
        byArray4[59] = 55;
        byArray3[60] = 56;
        byArray4[61] = 57;
        byArray3[62] = 43;
        byArray4[63] = 47;
        ENCODE = byArray2;
        byte[] byArray5 = byArray = new byte[n10];
        byte[] byArray6 = byArray;
        byArray5[0] = 65;
        byArray6[1] = 66;
        byArray5[2] = 67;
        byArray6[3] = 68;
        byArray5[4] = 69;
        byArray6[5] = 70;
        byArray5[6] = 71;
        byArray6[7] = 72;
        byArray5[8] = 73;
        byArray6[9] = 74;
        byArray5[10] = 75;
        byArray6[11] = 76;
        byArray5[12] = 77;
        byArray6[13] = 78;
        byArray5[14] = 79;
        byArray6[15] = 80;
        byArray5[16] = 81;
        byArray6[17] = 82;
        byArray5[18] = 83;
        byArray6[19] = 84;
        byArray5[20] = 85;
        byArray6[21] = 86;
        byArray5[22] = 87;
        byArray6[23] = 88;
        byArray5[24] = 89;
        byArray6[25] = 90;
        byArray5[26] = 97;
        byArray6[27] = 98;
        byArray5[28] = 99;
        byArray6[29] = 100;
        byArray5[30] = 101;
        byArray6[31] = 102;
        byArray5[32] = 103;
        byArray6[33] = 104;
        byArray5[34] = 105;
        byArray6[35] = 106;
        byArray5[36] = 107;
        byArray6[37] = 108;
        byArray5[38] = 109;
        byArray6[39] = 110;
        byArray5[40] = 111;
        byArray6[41] = 112;
        byArray5[42] = 113;
        byArray6[43] = 114;
        byArray5[44] = 115;
        byArray6[45] = 116;
        byArray5[46] = 117;
        byArray6[47] = 118;
        byArray5[48] = 119;
        byArray6[49] = 120;
        byArray5[50] = 121;
        byArray6[51] = 122;
        byArray5[52] = 48;
        byArray6[53] = 49;
        byArray5[54] = 50;
        byArray6[55] = 51;
        byArray5[56] = 52;
        byArray6[57] = 53;
        byArray5[58] = 54;
        byArray6[59] = 55;
        byArray5[60] = 56;
        byArray6[61] = 57;
        byArray5[62] = 45;
        byArray6[63] = 95;
        ENCODE_WEBSAFE = byArray;
    }

    public Base64$Encoder(int n10, byte[] byArray) {
        this.output = byArray;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 == 0) {
            n11 = n12;
        } else {
            n11 = 0;
            byArray = null;
        }
        this.do_padding = n11;
        n11 = n10 & 2;
        if (n11 == 0) {
            n11 = n12;
        } else {
            n11 = 0;
            byArray = null;
        }
        this.do_newline = n11;
        int n13 = n10 & 4;
        if (n13 == 0) {
            n12 = 0;
        }
        this.do_cr = n12;
        byte[] byArray2 = (n10 &= 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
        this.alphabet = byArray2;
        n10 = 2;
        byArray2 = new byte[n10];
        this.tail = byArray2;
        this.tailLen = 0;
        n10 = n11 != 0 ? 19 : -1;
        this.count = n10;
    }

    public int maxOutputSize(int n10) {
        return n10 * 8 / 5 + 10;
    }

    /*
     * Unable to fully structure code
     */
    public boolean process(byte[] var1_1, int var2_2, int var3_3, boolean var4_4) {
        block37: {
            block36: {
                var5_5 = this;
                var6_6 = this.alphabet;
                var7_7 = this.output;
                var8_8 = this.count;
                var9_9 = var3_3 + var2_2;
                var10_10 = this.tailLen;
                var11_11 = -1;
                var12_12 = 0;
                var13_13 = 2;
                var14_14 = 1;
                var15_15 = 1.4E-45f;
                if (var10_10 == var14_14) break block36;
                if (var10_10 != var13_13 || (var10_10 = var2_2 + 1) > var9_9) ** GOTO lbl-1000
                var16_16 = this.tail;
                var17_17 = (var16_16[0] & 255) << 16;
                var18_18 = (var16_16[var14_14] & 255) << 8 | var17_17;
                var17_17 = var1_1[var2_2] & 255;
                var18_18 |= var17_17;
                this.tailLen = 0;
                var17_17 = var10_10;
                break block37;
            }
            var10_10 = var2_2 + 2;
            if (var10_10 <= var9_9) {
                var19_19 = this.tail;
                var10_10 = (var19_19[0] & 255) << 16;
                var18_18 = var2_2 + 1;
                var17_17 = (var1_1[var2_2] & 255) << 8;
                var10_10 |= var17_17;
                var17_17 = var18_18 + 1;
                var18_18 = var1_1[var18_18] & 255 | var10_10;
                this.tailLen = 0;
            } else lbl-1000:
            // 2 sources

            {
                var17_17 = var2_2;
                var18_18 = var11_11;
            }
        }
        var20_20 = 4;
        var21_21 = 5.6E-45f;
        var22_22 = 13;
        var23_23 = 10;
        if (var18_18 != var11_11) {
            var11_11 = var18_18 >> 18 & 63;
            var7_7[0] = var11_11 = var6_6[var11_11];
            var11_11 = var18_18 >> 12 & 63;
            var7_7[var14_14] = var11_11 = var6_6[var11_11];
            var11_11 = var18_18 >> 6 & 63;
            var7_7[var13_13] = var11_11 = var6_6[var11_11];
            var11_11 = var18_18 & 63;
            var11_11 = var6_6[var11_11];
            var18_18 = 3;
            var7_7[var18_18] = var11_11;
            if ((var8_8 += -1) == 0) {
                var8_8 = (int)var5_5.do_cr;
                if (var8_8 != 0) {
                    var8_8 = 5;
                    var7_7[var20_20] = var22_22;
                } else {
                    var8_8 = var20_20;
                }
                var11_11 = var8_8 + 1;
                var7_7[var8_8] = var23_23;
lbl61:
                // 2 sources

                while (true) {
                    var8_8 = 19;
                    break;
                }
            } else {
                var11_11 = var20_20;
            }
        } else {
            var11_11 = 0;
        }
        while ((var18_18 = var17_17 + 3) <= var9_9) {
            var24_24 = (var1_1[var17_17] & 255) << 16;
            var25_25 = var17_17 + 1;
            var10_10 = (var1_1[var25_25] & 255) << 8 | var24_24;
            var17_17 += 2;
            var17_17 = var1_1[var17_17] & 255;
            var10_10 |= var17_17;
            var17_17 = var10_10 >> 18 & 63;
            var7_7[var11_11] = var17_17 = var6_6[var17_17];
            var17_17 = var11_11 + 1;
            var24_24 = var10_10 >> 12 & 63;
            var7_7[var17_17] = var24_24 = var6_6[var24_24];
            var17_17 = var11_11 + 2;
            var24_24 = var10_10 >> 6 & 63;
            var7_7[var17_17] = var24_24 = var6_6[var24_24];
            var17_17 = var11_11 + 3;
            var10_10 &= 63;
            var7_7[var17_17] = var10_10 = var6_6[var10_10];
            var11_11 += 4;
            if ((var8_8 += -1) == 0) {
                var8_8 = (int)var5_5.do_cr;
                if (var8_8 != 0) {
                    var8_8 = var11_11 + 1;
                    var7_7[var11_11] = var22_22;
                    var11_11 = var8_8;
                }
                var8_8 = var11_11 + 1;
                var7_7[var11_11] = var23_23;
                var11_11 = var8_8;
                var17_17 = var18_18;
                ** continue;
            }
            var17_17 = var18_18;
        }
        if (var4_4) {
            var10_10 = var5_5.tailLen;
            var18_18 = var17_17 - var10_10;
            var24_24 = var9_9 + -1;
            var25_25 = 61;
            if (var18_18 == var24_24) {
                if (var10_10 > 0) {
                    var26_26 = var5_5.tail;
                    var9_9 = var26_26[0];
                    var12_12 = var14_14;
                } else {
                    var9_9 = var1_1[var17_17];
                }
                var9_9 = (var9_9 & 255) << var20_20;
                var5_5.tailLen = var10_10 -= var12_12;
                var10_10 = var11_11 + 1;
                var12_12 = var9_9 >> 6 & 63;
                var7_7[var11_11] = var12_12 = var6_6[var12_12];
                var11_11 = var10_10 + 1;
                var7_7[var10_10] = var27_28 = var6_6[var9_9 &= 63];
                var27_28 = (int)var5_5.do_padding;
                if (var27_28 != 0) {
                    var27_28 = var11_11 + 1;
                    var7_7[var11_11] = var25_25;
                    var11_11 = var27_28 + 1;
                    var7_7[var27_28] = var25_25;
                }
                if ((var27_28 = (int)var5_5.do_newline) != 0) {
                    var27_28 = (int)var5_5.do_cr;
                    if (var27_28 != 0) {
                        var27_28 = var11_11 + 1;
                        var7_7[var11_11] = var22_22;
                        var11_11 = var27_28;
                    }
                    var27_28 = var11_11 + 1;
                    var7_7[var11_11] = var23_23;
lbl132:
                    // 2 sources

                    while (true) {
                        var11_11 = var27_28;
                        break;
                    }
                }
            } else {
                var18_18 = var17_17 - var10_10;
                if (var18_18 == (var9_9 -= var13_13)) {
                    if (var10_10 > var14_14) {
                        var26_27 = var5_5.tail;
                        var9_9 = var26_27[0];
                        var12_12 = var14_14;
                    } else {
                        var9_9 = var17_17 + 1;
                        var18_18 = var1_1[var17_17];
                        var17_17 = var9_9;
                        var9_9 = var18_18;
                    }
                    var9_9 = (var9_9 & 255) << var23_23;
                    if (var10_10 > 0) {
                        var16_16 = var5_5.tail;
                        var17_17 = var12_12 + 1;
                        var12_12 = var16_16[var12_12];
                    } else {
                        var18_18 = var1_1[var17_17];
                        var17_17 = var12_12;
                        var12_12 = var18_18;
                    }
                    var12_12 = (var12_12 & 255) << var13_13;
                    var9_9 |= var12_12;
                    var5_5.tailLen = var10_10 -= var17_17;
                    var10_10 = var11_11 + 1;
                    var12_12 = var9_9 >> 12 & 63;
                    var7_7[var11_11] = var12_12 = var6_6[var12_12];
                    var11_11 = var10_10 + 1;
                    var12_12 = var9_9 >> 6 & 63;
                    var7_7[var10_10] = var12_12 = var6_6[var12_12];
                    var10_10 = var11_11 + 1;
                    var7_7[var11_11] = var27_29 = var6_6[var9_9 &= 63];
                    var27_29 = (int)var5_5.do_padding;
                    if (var27_29 != 0) {
                        var27_29 = var10_10 + 1;
                        var7_7[var10_10] = var25_25;
                        var10_10 = var27_29;
                    }
                    if ((var27_29 = (int)var5_5.do_newline) != 0) {
                        var27_29 = (int)var5_5.do_cr;
                        if (var27_29 != 0) {
                            var27_29 = var10_10 + 1;
                            var7_7[var10_10] = var22_22;
                            var10_10 = var27_29;
                        }
                        var27_29 = var10_10 + 1;
                        var7_7[var10_10] = var23_23;
                        var10_10 = var27_29;
                    }
                    var11_11 = var10_10;
                } else {
                    var27_28 = var5_5.do_newline;
                    if (var27_28 != 0 && var11_11 > 0 && var8_8 != (var27_28 = 19)) {
                        var27_28 = (int)var5_5.do_cr;
                        if (var27_28 != 0) {
                            var27_28 = var11_11 + 1;
                            var7_7[var11_11] = var22_22;
                            var11_11 = var27_28;
                        }
                        var27_28 = var11_11 + 1;
                        var7_7[var11_11] = var23_23;
                        ** continue;
                    }
                }
            }
        } else {
            var27_30 = var9_9 + -1;
            if (var17_17 == var27_30) {
                var6_6 = var5_5.tail;
                var28_31 = var5_5.tailLen;
                var5_5.tailLen = var9_9 = var28_31 + 1;
                var6_6[var28_31] = var9_9 = var1_1[var17_17];
            } else if (var17_17 == (var9_9 -= var13_13)) {
                var6_6 = var5_5.tail;
                var28_32 = var5_5.tailLen;
                var5_5.tailLen = var9_9 = var28_32 + 1;
                var6_6[var28_32] = var10_10 = var1_1[var17_17];
                var5_5.tailLen = var28_32 = var9_9 + 1;
                var6_6[var9_9] = var28_32 = var1_1[var17_17 += var14_14];
            }
        }
        var5_5.op = var11_11;
        var5_5.count = var8_8;
        return (boolean)var14_14;
    }
}


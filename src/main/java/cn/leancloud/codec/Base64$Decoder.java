/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import cn.leancloud.codec.Base64$Coder;

public class Base64$Decoder
extends Base64$Coder {
    private static final int[] DECODE;
    private static final int[] DECODE_WEBSAFE;
    private static final int EQUALS = 254;
    private static final int SKIP = 255;
    private final int[] alphabet;
    private int state;
    private int value;

    static {
        int[] nArray;
        int[] nArray2;
        int n10 = 256;
        int[] nArray3 = nArray2 = new int[n10];
        int[] nArray4 = nArray2;
        nArray3[0] = -1;
        nArray4[1] = -1;
        nArray3[2] = -1;
        nArray4[3] = -1;
        nArray3[4] = -1;
        nArray4[5] = -1;
        nArray3[6] = -1;
        nArray4[7] = -1;
        nArray3[8] = -1;
        nArray4[9] = -1;
        nArray3[10] = -1;
        nArray4[11] = -1;
        nArray3[12] = -1;
        nArray4[13] = -1;
        nArray3[14] = -1;
        nArray4[15] = -1;
        nArray3[16] = -1;
        nArray4[17] = -1;
        nArray3[18] = -1;
        nArray4[19] = -1;
        nArray3[20] = -1;
        nArray4[21] = -1;
        nArray3[22] = -1;
        nArray4[23] = -1;
        nArray3[24] = -1;
        nArray4[25] = -1;
        nArray3[26] = -1;
        nArray4[27] = -1;
        nArray3[28] = -1;
        nArray4[29] = -1;
        nArray3[30] = -1;
        nArray4[31] = -1;
        nArray3[32] = -1;
        nArray4[33] = -1;
        nArray3[34] = -1;
        nArray4[35] = -1;
        nArray3[36] = -1;
        nArray4[37] = -1;
        nArray3[38] = -1;
        nArray4[39] = -1;
        nArray3[40] = -1;
        nArray4[41] = -1;
        nArray3[42] = -1;
        nArray4[43] = 62;
        nArray3[44] = -1;
        nArray4[45] = -1;
        nArray3[46] = -1;
        nArray4[47] = 63;
        nArray3[48] = 52;
        nArray4[49] = 53;
        nArray3[50] = 54;
        nArray4[51] = 55;
        nArray3[52] = 56;
        nArray4[53] = 57;
        nArray3[54] = 58;
        nArray4[55] = 59;
        nArray3[56] = 60;
        nArray4[57] = 61;
        nArray3[58] = -1;
        nArray4[59] = -1;
        nArray3[60] = -1;
        nArray4[61] = -2;
        nArray3[62] = -1;
        nArray4[63] = -1;
        nArray3[64] = -1;
        nArray4[65] = 0;
        nArray3[66] = 1;
        nArray4[67] = 2;
        nArray3[68] = 3;
        nArray4[69] = 4;
        nArray3[70] = 5;
        nArray4[71] = 6;
        nArray3[72] = 7;
        nArray4[73] = 8;
        nArray3[74] = 9;
        nArray4[75] = 10;
        nArray3[76] = 11;
        nArray4[77] = 12;
        nArray3[78] = 13;
        nArray4[79] = 14;
        nArray3[80] = 15;
        nArray4[81] = 16;
        nArray3[82] = 17;
        nArray4[83] = 18;
        nArray3[84] = 19;
        nArray4[85] = 20;
        nArray3[86] = 21;
        nArray4[87] = 22;
        nArray3[88] = 23;
        nArray4[89] = 24;
        nArray3[90] = 25;
        nArray4[91] = -1;
        nArray3[92] = -1;
        nArray4[93] = -1;
        nArray3[94] = -1;
        nArray4[95] = -1;
        nArray3[96] = -1;
        nArray4[97] = 26;
        nArray3[98] = 27;
        nArray4[99] = 28;
        nArray3[100] = 29;
        nArray4[101] = 30;
        nArray3[102] = 31;
        nArray4[103] = 32;
        nArray3[104] = 33;
        nArray4[105] = 34;
        nArray3[106] = 35;
        nArray4[107] = 36;
        nArray3[108] = 37;
        nArray4[109] = 38;
        nArray3[110] = 39;
        nArray4[111] = 40;
        nArray3[112] = 41;
        nArray4[113] = 42;
        nArray3[114] = 43;
        nArray4[115] = 44;
        nArray3[116] = 45;
        nArray4[117] = 46;
        nArray3[118] = 47;
        nArray4[119] = 48;
        nArray3[120] = 49;
        nArray4[121] = 50;
        nArray3[122] = 51;
        nArray4[123] = -1;
        nArray3[124] = -1;
        nArray4[125] = -1;
        nArray3[126] = -1;
        nArray4[127] = -1;
        nArray3[128] = -1;
        nArray4[129] = -1;
        nArray3[130] = -1;
        nArray4[131] = -1;
        nArray3[132] = -1;
        nArray4[133] = -1;
        nArray3[134] = -1;
        nArray4[135] = -1;
        nArray3[136] = -1;
        nArray4[137] = -1;
        nArray3[138] = -1;
        nArray4[139] = -1;
        nArray3[140] = -1;
        nArray4[141] = -1;
        nArray3[142] = -1;
        nArray4[143] = -1;
        nArray3[144] = -1;
        nArray4[145] = -1;
        nArray3[146] = -1;
        nArray4[147] = -1;
        nArray3[148] = -1;
        nArray4[149] = -1;
        nArray3[150] = -1;
        nArray4[151] = -1;
        nArray3[152] = -1;
        nArray4[153] = -1;
        nArray3[154] = -1;
        nArray4[155] = -1;
        nArray3[156] = -1;
        nArray4[157] = -1;
        nArray3[158] = -1;
        nArray4[159] = -1;
        nArray3[160] = -1;
        nArray4[161] = -1;
        nArray3[162] = -1;
        nArray4[163] = -1;
        nArray3[164] = -1;
        nArray4[165] = -1;
        nArray3[166] = -1;
        nArray4[167] = -1;
        nArray3[168] = -1;
        nArray4[169] = -1;
        nArray3[170] = -1;
        nArray4[171] = -1;
        nArray3[172] = -1;
        nArray4[173] = -1;
        nArray3[174] = -1;
        nArray4[175] = -1;
        nArray3[176] = -1;
        nArray4[177] = -1;
        nArray3[178] = -1;
        nArray4[179] = -1;
        nArray3[180] = -1;
        nArray4[181] = -1;
        nArray3[182] = -1;
        nArray4[183] = -1;
        nArray3[184] = -1;
        nArray4[185] = -1;
        nArray3[186] = -1;
        nArray4[187] = -1;
        nArray3[188] = -1;
        nArray4[189] = -1;
        nArray3[190] = -1;
        nArray4[191] = -1;
        nArray3[192] = -1;
        nArray4[193] = -1;
        nArray3[194] = -1;
        nArray4[195] = -1;
        nArray3[196] = -1;
        nArray4[197] = -1;
        nArray3[198] = -1;
        nArray4[199] = -1;
        nArray3[200] = -1;
        nArray4[201] = -1;
        nArray3[202] = -1;
        nArray4[203] = -1;
        nArray3[204] = -1;
        nArray4[205] = -1;
        nArray3[206] = -1;
        nArray4[207] = -1;
        nArray3[208] = -1;
        nArray4[209] = -1;
        nArray3[210] = -1;
        nArray4[211] = -1;
        nArray3[212] = -1;
        nArray4[213] = -1;
        nArray3[214] = -1;
        nArray4[215] = -1;
        nArray3[216] = -1;
        nArray4[217] = -1;
        nArray3[218] = -1;
        nArray4[219] = -1;
        nArray3[220] = -1;
        nArray4[221] = -1;
        nArray3[222] = -1;
        nArray4[223] = -1;
        nArray3[224] = -1;
        nArray4[225] = -1;
        nArray3[226] = -1;
        nArray4[227] = -1;
        nArray3[228] = -1;
        nArray4[229] = -1;
        nArray3[230] = -1;
        nArray4[231] = -1;
        nArray3[232] = -1;
        nArray4[233] = -1;
        nArray3[234] = -1;
        nArray4[235] = -1;
        nArray3[236] = -1;
        nArray4[237] = -1;
        nArray3[238] = -1;
        nArray4[239] = -1;
        nArray3[240] = -1;
        nArray4[241] = -1;
        nArray3[242] = -1;
        nArray4[243] = -1;
        nArray3[244] = -1;
        nArray4[245] = -1;
        nArray3[246] = -1;
        nArray4[247] = -1;
        nArray3[248] = -1;
        nArray4[249] = -1;
        nArray3[250] = -1;
        nArray4[251] = -1;
        nArray3[252] = -1;
        nArray4[253] = -1;
        nArray3[254] = -1;
        nArray4[255] = -1;
        DECODE = nArray2;
        int[] nArray5 = nArray = new int[n10];
        int[] nArray6 = nArray;
        nArray5[0] = -1;
        nArray6[1] = -1;
        nArray5[2] = -1;
        nArray6[3] = -1;
        nArray5[4] = -1;
        nArray6[5] = -1;
        nArray5[6] = -1;
        nArray6[7] = -1;
        nArray5[8] = -1;
        nArray6[9] = -1;
        nArray5[10] = -1;
        nArray6[11] = -1;
        nArray5[12] = -1;
        nArray6[13] = -1;
        nArray5[14] = -1;
        nArray6[15] = -1;
        nArray5[16] = -1;
        nArray6[17] = -1;
        nArray5[18] = -1;
        nArray6[19] = -1;
        nArray5[20] = -1;
        nArray6[21] = -1;
        nArray5[22] = -1;
        nArray6[23] = -1;
        nArray5[24] = -1;
        nArray6[25] = -1;
        nArray5[26] = -1;
        nArray6[27] = -1;
        nArray5[28] = -1;
        nArray6[29] = -1;
        nArray5[30] = -1;
        nArray6[31] = -1;
        nArray5[32] = -1;
        nArray6[33] = -1;
        nArray5[34] = -1;
        nArray6[35] = -1;
        nArray5[36] = -1;
        nArray6[37] = -1;
        nArray5[38] = -1;
        nArray6[39] = -1;
        nArray5[40] = -1;
        nArray6[41] = -1;
        nArray5[42] = -1;
        nArray6[43] = -1;
        nArray5[44] = -1;
        nArray6[45] = 62;
        nArray5[46] = -1;
        nArray6[47] = -1;
        nArray5[48] = 52;
        nArray6[49] = 53;
        nArray5[50] = 54;
        nArray6[51] = 55;
        nArray5[52] = 56;
        nArray6[53] = 57;
        nArray5[54] = 58;
        nArray6[55] = 59;
        nArray5[56] = 60;
        nArray6[57] = 61;
        nArray5[58] = -1;
        nArray6[59] = -1;
        nArray5[60] = -1;
        nArray6[61] = -2;
        nArray5[62] = -1;
        nArray6[63] = -1;
        nArray5[64] = -1;
        nArray6[65] = 0;
        nArray5[66] = 1;
        nArray6[67] = 2;
        nArray5[68] = 3;
        nArray6[69] = 4;
        nArray5[70] = 5;
        nArray6[71] = 6;
        nArray5[72] = 7;
        nArray6[73] = 8;
        nArray5[74] = 9;
        nArray6[75] = 10;
        nArray5[76] = 11;
        nArray6[77] = 12;
        nArray5[78] = 13;
        nArray6[79] = 14;
        nArray5[80] = 15;
        nArray6[81] = 16;
        nArray5[82] = 17;
        nArray6[83] = 18;
        nArray5[84] = 19;
        nArray6[85] = 20;
        nArray5[86] = 21;
        nArray6[87] = 22;
        nArray5[88] = 23;
        nArray6[89] = 24;
        nArray5[90] = 25;
        nArray6[91] = -1;
        nArray5[92] = -1;
        nArray6[93] = -1;
        nArray5[94] = -1;
        nArray6[95] = 63;
        nArray5[96] = -1;
        nArray6[97] = 26;
        nArray5[98] = 27;
        nArray6[99] = 28;
        nArray5[100] = 29;
        nArray6[101] = 30;
        nArray5[102] = 31;
        nArray6[103] = 32;
        nArray5[104] = 33;
        nArray6[105] = 34;
        nArray5[106] = 35;
        nArray6[107] = 36;
        nArray5[108] = 37;
        nArray6[109] = 38;
        nArray5[110] = 39;
        nArray6[111] = 40;
        nArray5[112] = 41;
        nArray6[113] = 42;
        nArray5[114] = 43;
        nArray6[115] = 44;
        nArray5[116] = 45;
        nArray6[117] = 46;
        nArray5[118] = 47;
        nArray6[119] = 48;
        nArray5[120] = 49;
        nArray6[121] = 50;
        nArray5[122] = 51;
        nArray6[123] = -1;
        nArray5[124] = -1;
        nArray6[125] = -1;
        nArray5[126] = -1;
        nArray6[127] = -1;
        nArray5[128] = -1;
        nArray6[129] = -1;
        nArray5[130] = -1;
        nArray6[131] = -1;
        nArray5[132] = -1;
        nArray6[133] = -1;
        nArray5[134] = -1;
        nArray6[135] = -1;
        nArray5[136] = -1;
        nArray6[137] = -1;
        nArray5[138] = -1;
        nArray6[139] = -1;
        nArray5[140] = -1;
        nArray6[141] = -1;
        nArray5[142] = -1;
        nArray6[143] = -1;
        nArray5[144] = -1;
        nArray6[145] = -1;
        nArray5[146] = -1;
        nArray6[147] = -1;
        nArray5[148] = -1;
        nArray6[149] = -1;
        nArray5[150] = -1;
        nArray6[151] = -1;
        nArray5[152] = -1;
        nArray6[153] = -1;
        nArray5[154] = -1;
        nArray6[155] = -1;
        nArray5[156] = -1;
        nArray6[157] = -1;
        nArray5[158] = -1;
        nArray6[159] = -1;
        nArray5[160] = -1;
        nArray6[161] = -1;
        nArray5[162] = -1;
        nArray6[163] = -1;
        nArray5[164] = -1;
        nArray6[165] = -1;
        nArray5[166] = -1;
        nArray6[167] = -1;
        nArray5[168] = -1;
        nArray6[169] = -1;
        nArray5[170] = -1;
        nArray6[171] = -1;
        nArray5[172] = -1;
        nArray6[173] = -1;
        nArray5[174] = -1;
        nArray6[175] = -1;
        nArray5[176] = -1;
        nArray6[177] = -1;
        nArray5[178] = -1;
        nArray6[179] = -1;
        nArray5[180] = -1;
        nArray6[181] = -1;
        nArray5[182] = -1;
        nArray6[183] = -1;
        nArray5[184] = -1;
        nArray6[185] = -1;
        nArray5[186] = -1;
        nArray6[187] = -1;
        nArray5[188] = -1;
        nArray6[189] = -1;
        nArray5[190] = -1;
        nArray6[191] = -1;
        nArray5[192] = -1;
        nArray6[193] = -1;
        nArray5[194] = -1;
        nArray6[195] = -1;
        nArray5[196] = -1;
        nArray6[197] = -1;
        nArray5[198] = -1;
        nArray6[199] = -1;
        nArray5[200] = -1;
        nArray6[201] = -1;
        nArray5[202] = -1;
        nArray6[203] = -1;
        nArray5[204] = -1;
        nArray6[205] = -1;
        nArray5[206] = -1;
        nArray6[207] = -1;
        nArray5[208] = -1;
        nArray6[209] = -1;
        nArray5[210] = -1;
        nArray6[211] = -1;
        nArray5[212] = -1;
        nArray6[213] = -1;
        nArray5[214] = -1;
        nArray6[215] = -1;
        nArray5[216] = -1;
        nArray6[217] = -1;
        nArray5[218] = -1;
        nArray6[219] = -1;
        nArray5[220] = -1;
        nArray6[221] = -1;
        nArray5[222] = -1;
        nArray6[223] = -1;
        nArray5[224] = -1;
        nArray6[225] = -1;
        nArray5[226] = -1;
        nArray6[227] = -1;
        nArray5[228] = -1;
        nArray6[229] = -1;
        nArray5[230] = -1;
        nArray6[231] = -1;
        nArray5[232] = -1;
        nArray6[233] = -1;
        nArray5[234] = -1;
        nArray6[235] = -1;
        nArray5[236] = -1;
        nArray6[237] = -1;
        nArray5[238] = -1;
        nArray6[239] = -1;
        nArray5[240] = -1;
        nArray6[241] = -1;
        nArray5[242] = -1;
        nArray6[243] = -1;
        nArray5[244] = -1;
        nArray6[245] = -1;
        nArray5[246] = -1;
        nArray6[247] = -1;
        nArray5[248] = -1;
        nArray6[249] = -1;
        nArray5[250] = -1;
        nArray6[251] = -1;
        nArray5[252] = -1;
        nArray6[253] = -1;
        nArray5[254] = -1;
        nArray6[255] = -1;
        DECODE_WEBSAFE = nArray;
    }

    public Base64$Decoder(int n10, byte[] byArray) {
        this.output = byArray;
        int[] nArray = (n10 &= 8) == 0 ? DECODE : DECODE_WEBSAFE;
        this.alphabet = nArray;
        this.state = 0;
        this.value = 0;
    }

    public int maxOutputSize(int n10) {
        return n10 * 3 / 4 + 10;
    }

    /*
     * Unable to fully structure code
     */
    public boolean process(byte[] var1_1, int var2_2, int var3_3, boolean var4_4) {
        block33: {
            block36: {
                block34: {
                    block35: {
                        var5_5 = this;
                        var6_6 = this.state;
                        var7_7 = 0;
                        var8_8 = 6;
                        if (var6_6 == var8_8) {
                            return false;
                        }
                        var9_9 = var3_3 + var2_2;
                        var10_10 = this.value;
                        var11_11 = this.output;
                        var12_12 = this.alphabet;
                        var13_13 = 0;
                        var14_14 = var10_10;
                        var10_10 = var6_6;
                        var6_6 = var2_2;
                        while (true) {
                            block30: {
                                block27: {
                                    block32: {
                                        block31: {
                                            block28: {
                                                block29: {
                                                    var15_15 = 3;
                                                    var16_16 = 4;
                                                    var17_17 = 2;
                                                    var18_18 = 1;
                                                    if (var6_6 >= var9_9) break;
                                                    if (var10_10 == 0) {
                                                        while ((var19_19 = var6_6 + 4) <= var9_9) {
                                                            var14_14 = var1_1[var6_6] & 255;
                                                            var14_14 = var12_12[var14_14] << 18;
                                                            var20_20 = var6_6 + 1;
                                                            var20_20 = var1_1[var20_20] & 255;
                                                            var20_20 = var12_12[var20_20] << 12;
                                                            var14_14 |= var20_20;
                                                            var20_20 = var6_6 + 2;
                                                            var20_20 = var1_1[var20_20] & 255;
                                                            var20_20 = var12_12[var20_20] << var8_8;
                                                            var14_14 |= var20_20;
                                                            var20_20 = var6_6 + 3;
                                                            var20_20 = var1_1[var20_20] & 255;
                                                            if ((var14_14 |= (var20_20 = var12_12[var20_20])) < 0) break;
                                                            var6_6 = var13_13 + 2;
                                                            var11_11[var6_6] = var20_20 = (int)((byte)var14_14);
                                                            var6_6 = var13_13 + 1;
                                                            var11_11[var6_6] = var20_20 = (int)((byte)(var14_14 >> 8));
                                                            var11_11[var13_13] = var6_6 = (int)((byte)(var14_14 >> 16));
                                                            var13_13 += 3;
                                                            var6_6 = var19_19;
                                                        }
                                                        if (var6_6 >= var9_9) break;
                                                    }
                                                    var19_19 = var6_6 + 1;
                                                    var6_6 = var1_1[var6_6] & 255;
                                                    var6_6 = var12_12[var6_6];
                                                    var20_20 = 5;
                                                    var7_7 = (byte)-1;
                                                    if (var10_10 == 0) break block27;
                                                    if (var10_10 == var18_18) break block28;
                                                    var18_18 = -2;
                                                    if (var10_10 == var17_17) break block29;
                                                    if (var10_10 != var15_15) {
                                                        if (var10_10 != var16_16) {
                                                            if (var10_10 == var20_20 && var6_6 != var7_7) {
                                                                var5_5.state = var8_8;
lbl58:
                                                                // 2 sources

                                                                return false;
                                                            }
                                                        } else {
                                                            var15_15 = 0;
                                                            if (var6_6 == var18_18) {
                                                                ++var10_10;
                                                            } else if (var6_6 != var7_7) {
                                                                var5_5.state = var8_8;
                                                                return false;
                                                            }
                                                        }
                                                    } else if (var6_6 >= 0) {
                                                        var7_7 = (byte)(var14_14 << 6);
                                                        var6_6 |= var7_7;
                                                        var7_7 = (byte)(var13_13 + 2);
                                                        var11_11[var7_7] = var10_10 = (int)((byte)var6_6);
                                                        var7_7 = (byte)(var13_13 + 1);
                                                        var11_11[var7_7] = var10_10 = (int)((byte)(var6_6 >> 8));
                                                        var11_11[var13_13] = var7_7 = (byte)(var6_6 >> 16);
                                                        var13_13 += 3;
                                                        var14_14 = var6_6;
                                                        var10_10 = 0;
                                                    } else if (var6_6 == var18_18) {
                                                        var6_6 = var13_13 + 1;
                                                        var11_11[var6_6] = var7_7 = (byte)(var14_14 >> 2);
                                                        var11_11[var13_13] = var6_6 = (int)((byte)(var14_14 >> 10));
                                                        var13_13 += 2;
                                                        var10_10 = var20_20;
                                                    } else if (var6_6 != var7_7) {
                                                        var5_5.state = var8_8;
lbl90:
                                                        // 3 sources

                                                        return false;
                                                    }
                                                    break block30;
                                                }
                                                if (var6_6 >= 0) break block31;
                                                if (var6_6 == var18_18) {
                                                    var6_6 = var13_13 + 1;
                                                    var11_11[var13_13] = var7_7 = (byte)(var14_14 >> 4);
                                                    var13_13 = var6_6;
                                                    var10_10 = var16_16;
                                                } else if (var6_6 != var7_7) {
                                                    var5_5.state = var8_8;
                                                    ** continue;
                                                }
                                                break block30;
                                            }
                                            var15_15 = 0;
                                            if (var6_6 < 0) break block32;
                                        }
                                        var7_7 = (byte)(var14_14 << 6);
                                        var6_6 |= var7_7;
                                        ** GOTO lbl-1000
                                    }
                                    if (var6_6 != var7_7) {
                                        var5_5.state = var8_8;
                                        return false;
                                    }
                                    break block30;
                                }
                                var15_15 = 0;
                                if (var6_6 >= 0) lbl-1000:
                                // 2 sources

                                {
                                    ++var10_10;
                                    var14_14 = var6_6;
                                } else if (var6_6 != var7_7) {
                                    var5_5.state = var8_8;
                                    return false;
                                }
                            }
                            var6_6 = var19_19;
                            var7_7 = 0;
                        }
                        if (!var4_4) {
                            var5_5.state = var10_10;
                            var5_5.value = var14_14;
                            var5_5.op = var13_13;
                            return (boolean)var18_18;
                        }
                        if (var10_10 == var18_18) break block33;
                        if (var10_10 == var17_17) break block34;
                        if (var10_10 == var15_15) break block35;
                        if (var10_10 != var16_16) break block36;
                        var5_5.state = var8_8;
                        ** GOTO lbl90
                    }
                    var6_6 = var13_13 + 1;
                    var11_11[var13_13] = var7_7 = (byte)(var14_14 >> 10);
                    var13_13 = var6_6 + 1;
                    var11_11[var6_6] = var7_7 = (byte)(var14_14 >> 2);
                    break block36;
                }
                var6_6 = var13_13 + 1;
                var11_11[var13_13] = var7_7 = (byte)(var14_14 >> 4);
                var13_13 = var6_6;
            }
            var5_5.state = var10_10;
            var5_5.op = var13_13;
            return (boolean)var18_18;
        }
        var5_5.state = var8_8;
        ** while (true)
    }
}


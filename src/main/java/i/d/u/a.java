/*
 * Decompiled with CFR 0.151.
 */
package i.d.u;

import i.d.u.a$a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

public class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;
    private static final int g = 76;
    private static final byte h = 61;
    private static final byte i = 10;
    private static final String j = "US-ASCII";
    private static final byte k = -5;
    private static final byte[] l;
    private static final byte[] m;
    private static final byte[] n;
    private static final byte[] o;
    private static final byte[] p;
    private static final byte[] q;
    public static final /* synthetic */ boolean r;

    static {
        byte[] byArray;
        byte[] byArray2;
        byte[] byArray3;
        int n10 = 64;
        byte[] byArray4 = byArray3 = new byte[n10];
        byte[] byArray5 = byArray3;
        byArray4[0] = 65;
        byArray5[1] = 66;
        byArray4[2] = 67;
        byArray5[3] = 68;
        byArray4[4] = 69;
        byArray5[5] = 70;
        byArray4[6] = 71;
        byArray5[7] = 72;
        byArray4[8] = 73;
        byArray5[9] = 74;
        byArray4[10] = 75;
        byArray5[11] = 76;
        byArray4[12] = 77;
        byArray5[13] = 78;
        byArray4[14] = 79;
        byArray5[15] = 80;
        byArray4[16] = 81;
        byArray5[17] = 82;
        byArray4[18] = 83;
        byArray5[19] = 84;
        byArray4[20] = 85;
        byArray5[21] = 86;
        byArray4[22] = 87;
        byArray5[23] = 88;
        byArray4[24] = 89;
        byArray5[25] = 90;
        byArray4[26] = 97;
        byArray5[27] = 98;
        byArray4[28] = 99;
        byArray5[29] = 100;
        byArray4[30] = 101;
        byArray5[31] = 102;
        byArray4[32] = 103;
        byArray5[33] = 104;
        byArray4[34] = 105;
        byArray5[35] = 106;
        byArray4[36] = 107;
        byArray5[37] = 108;
        byArray4[38] = 109;
        byArray5[39] = 110;
        byArray4[40] = 111;
        byArray5[41] = 112;
        byArray4[42] = 113;
        byArray5[43] = 114;
        byArray4[44] = 115;
        byArray5[45] = 116;
        byArray4[46] = 117;
        byArray5[47] = 118;
        byArray4[48] = 119;
        byArray5[49] = 120;
        byArray4[50] = 121;
        byArray5[51] = 122;
        byArray4[52] = 48;
        byArray5[53] = 49;
        byArray4[54] = 50;
        byArray5[55] = 51;
        byArray4[56] = 52;
        byArray5[57] = 53;
        byArray4[58] = 54;
        byArray5[59] = 55;
        byArray4[60] = 56;
        byArray5[61] = 57;
        byArray4[62] = 43;
        byArray5[63] = 47;
        l = byArray3;
        int n11 = 256;
        byte[] byArray6 = byArray2 = new byte[n11];
        byte[] byArray7 = byArray2;
        byArray6[0] = -9;
        byArray7[1] = -9;
        byArray6[2] = -9;
        byArray7[3] = -9;
        byArray6[4] = -9;
        byArray7[5] = -9;
        byArray6[6] = -9;
        byArray7[7] = -9;
        byArray6[8] = -9;
        byArray7[9] = -5;
        byArray6[10] = -5;
        byArray7[11] = -9;
        byArray6[12] = -9;
        byArray7[13] = -5;
        byArray6[14] = -9;
        byArray7[15] = -9;
        byArray6[16] = -9;
        byArray7[17] = -9;
        byArray6[18] = -9;
        byArray7[19] = -9;
        byArray6[20] = -9;
        byArray7[21] = -9;
        byArray6[22] = -9;
        byArray7[23] = -9;
        byArray6[24] = -9;
        byArray7[25] = -9;
        byArray6[26] = -9;
        byArray7[27] = -9;
        byArray6[28] = -9;
        byArray7[29] = -9;
        byArray6[30] = -9;
        byArray7[31] = -9;
        byArray6[32] = -5;
        byArray7[33] = -9;
        byArray6[34] = -9;
        byArray7[35] = -9;
        byArray6[36] = -9;
        byArray7[37] = -9;
        byArray6[38] = -9;
        byArray7[39] = -9;
        byArray6[40] = -9;
        byArray7[41] = -9;
        byArray6[42] = -9;
        byArray7[43] = 62;
        byArray6[44] = -9;
        byArray7[45] = -9;
        byArray6[46] = -9;
        byArray7[47] = 63;
        byArray6[48] = 52;
        byArray7[49] = 53;
        byArray6[50] = 54;
        byArray7[51] = 55;
        byArray6[52] = 56;
        byArray7[53] = 57;
        byArray6[54] = 58;
        byArray7[55] = 59;
        byArray6[56] = 60;
        byArray7[57] = 61;
        byArray6[58] = -9;
        byArray7[59] = -9;
        byArray6[60] = -9;
        byArray7[61] = -1;
        byArray6[62] = -9;
        byArray7[63] = -9;
        byArray6[64] = -9;
        byArray7[65] = 0;
        byArray6[66] = 1;
        byArray7[67] = 2;
        byArray6[68] = 3;
        byArray7[69] = 4;
        byArray6[70] = 5;
        byArray7[71] = 6;
        byArray6[72] = 7;
        byArray7[73] = 8;
        byArray6[74] = 9;
        byArray7[75] = 10;
        byArray6[76] = 11;
        byArray7[77] = 12;
        byArray6[78] = 13;
        byArray7[79] = 14;
        byArray6[80] = 15;
        byArray7[81] = 16;
        byArray6[82] = 17;
        byArray7[83] = 18;
        byArray6[84] = 19;
        byArray7[85] = 20;
        byArray6[86] = 21;
        byArray7[87] = 22;
        byArray6[88] = 23;
        byArray7[89] = 24;
        byArray6[90] = 25;
        byArray7[91] = -9;
        byArray6[92] = -9;
        byArray7[93] = -9;
        byArray6[94] = -9;
        byArray7[95] = -9;
        byArray6[96] = -9;
        byArray7[97] = 26;
        byArray6[98] = 27;
        byArray7[99] = 28;
        byArray6[100] = 29;
        byArray7[101] = 30;
        byArray6[102] = 31;
        byArray7[103] = 32;
        byArray6[104] = 33;
        byArray7[105] = 34;
        byArray6[106] = 35;
        byArray7[107] = 36;
        byArray6[108] = 37;
        byArray7[109] = 38;
        byArray6[110] = 39;
        byArray7[111] = 40;
        byArray6[112] = 41;
        byArray7[113] = 42;
        byArray6[114] = 43;
        byArray7[115] = 44;
        byArray6[116] = 45;
        byArray7[117] = 46;
        byArray6[118] = 47;
        byArray7[119] = 48;
        byArray6[120] = 49;
        byArray7[121] = 50;
        byArray6[122] = 51;
        byArray7[123] = -9;
        byArray6[124] = -9;
        byArray7[125] = -9;
        byArray6[126] = -9;
        byArray7[127] = -9;
        byArray6[128] = -9;
        byArray7[129] = -9;
        byArray6[130] = -9;
        byArray7[131] = -9;
        byArray6[132] = -9;
        byArray7[133] = -9;
        byArray6[134] = -9;
        byArray7[135] = -9;
        byArray6[136] = -9;
        byArray7[137] = -9;
        byArray6[138] = -9;
        byArray7[139] = -9;
        byArray6[140] = -9;
        byArray7[141] = -9;
        byArray6[142] = -9;
        byArray7[143] = -9;
        byArray6[144] = -9;
        byArray7[145] = -9;
        byArray6[146] = -9;
        byArray7[147] = -9;
        byArray6[148] = -9;
        byArray7[149] = -9;
        byArray6[150] = -9;
        byArray7[151] = -9;
        byArray6[152] = -9;
        byArray7[153] = -9;
        byArray6[154] = -9;
        byArray7[155] = -9;
        byArray6[156] = -9;
        byArray7[157] = -9;
        byArray6[158] = -9;
        byArray7[159] = -9;
        byArray6[160] = -9;
        byArray7[161] = -9;
        byArray6[162] = -9;
        byArray7[163] = -9;
        byArray6[164] = -9;
        byArray7[165] = -9;
        byArray6[166] = -9;
        byArray7[167] = -9;
        byArray6[168] = -9;
        byArray7[169] = -9;
        byArray6[170] = -9;
        byArray7[171] = -9;
        byArray6[172] = -9;
        byArray7[173] = -9;
        byArray6[174] = -9;
        byArray7[175] = -9;
        byArray6[176] = -9;
        byArray7[177] = -9;
        byArray6[178] = -9;
        byArray7[179] = -9;
        byArray6[180] = -9;
        byArray7[181] = -9;
        byArray6[182] = -9;
        byArray7[183] = -9;
        byArray6[184] = -9;
        byArray7[185] = -9;
        byArray6[186] = -9;
        byArray7[187] = -9;
        byArray6[188] = -9;
        byArray7[189] = -9;
        byArray6[190] = -9;
        byArray7[191] = -9;
        byArray6[192] = -9;
        byArray7[193] = -9;
        byArray6[194] = -9;
        byArray7[195] = -9;
        byArray6[196] = -9;
        byArray7[197] = -9;
        byArray6[198] = -9;
        byArray7[199] = -9;
        byArray6[200] = -9;
        byArray7[201] = -9;
        byArray6[202] = -9;
        byArray7[203] = -9;
        byArray6[204] = -9;
        byArray7[205] = -9;
        byArray6[206] = -9;
        byArray7[207] = -9;
        byArray6[208] = -9;
        byArray7[209] = -9;
        byArray6[210] = -9;
        byArray7[211] = -9;
        byArray6[212] = -9;
        byArray7[213] = -9;
        byArray6[214] = -9;
        byArray7[215] = -9;
        byArray6[216] = -9;
        byArray7[217] = -9;
        byArray6[218] = -9;
        byArray7[219] = -9;
        byArray6[220] = -9;
        byArray7[221] = -9;
        byArray6[222] = -9;
        byArray7[223] = -9;
        byArray6[224] = -9;
        byArray7[225] = -9;
        byArray6[226] = -9;
        byArray7[227] = -9;
        byArray6[228] = -9;
        byArray7[229] = -9;
        byArray6[230] = -9;
        byArray7[231] = -9;
        byArray6[232] = -9;
        byArray7[233] = -9;
        byArray6[234] = -9;
        byArray7[235] = -9;
        byArray6[236] = -9;
        byArray7[237] = -9;
        byArray6[238] = -9;
        byArray7[239] = -9;
        byArray6[240] = -9;
        byArray7[241] = -9;
        byArray6[242] = -9;
        byArray7[243] = -9;
        byArray6[244] = -9;
        byArray7[245] = -9;
        byArray6[246] = -9;
        byArray7[247] = -9;
        byArray6[248] = -9;
        byArray7[249] = -9;
        byArray6[250] = -9;
        byArray7[251] = -9;
        byArray6[252] = -9;
        byArray7[253] = -9;
        byArray6[254] = -9;
        byArray7[255] = -9;
        m = byArray2;
        byte[] byArray8 = byArray2 = new byte[n10];
        byte[] byArray9 = byArray2;
        byArray8[0] = 65;
        byArray9[1] = 66;
        byArray8[2] = 67;
        byArray9[3] = 68;
        byArray8[4] = 69;
        byArray9[5] = 70;
        byArray8[6] = 71;
        byArray9[7] = 72;
        byArray8[8] = 73;
        byArray9[9] = 74;
        byArray8[10] = 75;
        byArray9[11] = 76;
        byArray8[12] = 77;
        byArray9[13] = 78;
        byArray8[14] = 79;
        byArray9[15] = 80;
        byArray8[16] = 81;
        byArray9[17] = 82;
        byArray8[18] = 83;
        byArray9[19] = 84;
        byArray8[20] = 85;
        byArray9[21] = 86;
        byArray8[22] = 87;
        byArray9[23] = 88;
        byArray8[24] = 89;
        byArray9[25] = 90;
        byArray8[26] = 97;
        byArray9[27] = 98;
        byArray8[28] = 99;
        byArray9[29] = 100;
        byArray8[30] = 101;
        byArray9[31] = 102;
        byArray8[32] = 103;
        byArray9[33] = 104;
        byArray8[34] = 105;
        byArray9[35] = 106;
        byArray8[36] = 107;
        byArray9[37] = 108;
        byArray8[38] = 109;
        byArray9[39] = 110;
        byArray8[40] = 111;
        byArray9[41] = 112;
        byArray8[42] = 113;
        byArray9[43] = 114;
        byArray8[44] = 115;
        byArray9[45] = 116;
        byArray8[46] = 117;
        byArray9[47] = 118;
        byArray8[48] = 119;
        byArray9[49] = 120;
        byArray8[50] = 121;
        byArray9[51] = 122;
        byArray8[52] = 48;
        byArray9[53] = 49;
        byArray8[54] = 50;
        byArray9[55] = 51;
        byArray8[56] = 52;
        byArray9[57] = 53;
        byArray8[58] = 54;
        byArray9[59] = 55;
        byArray8[60] = 56;
        byArray9[61] = 57;
        byArray8[62] = 45;
        byArray9[63] = 95;
        n = byArray2;
        byte[] byArray10 = byArray3 = new byte[n11];
        byte[] byArray11 = byArray3;
        byArray10[0] = -9;
        byArray11[1] = -9;
        byArray10[2] = -9;
        byArray11[3] = -9;
        byArray10[4] = -9;
        byArray11[5] = -9;
        byArray10[6] = -9;
        byArray11[7] = -9;
        byArray10[8] = -9;
        byArray11[9] = -5;
        byArray10[10] = -5;
        byArray11[11] = -9;
        byArray10[12] = -9;
        byArray11[13] = -5;
        byArray10[14] = -9;
        byArray11[15] = -9;
        byArray10[16] = -9;
        byArray11[17] = -9;
        byArray10[18] = -9;
        byArray11[19] = -9;
        byArray10[20] = -9;
        byArray11[21] = -9;
        byArray10[22] = -9;
        byArray11[23] = -9;
        byArray10[24] = -9;
        byArray11[25] = -9;
        byArray10[26] = -9;
        byArray11[27] = -9;
        byArray10[28] = -9;
        byArray11[29] = -9;
        byArray10[30] = -9;
        byArray11[31] = -9;
        byArray10[32] = -5;
        byArray11[33] = -9;
        byArray10[34] = -9;
        byArray11[35] = -9;
        byArray10[36] = -9;
        byArray11[37] = -9;
        byArray10[38] = -9;
        byArray11[39] = -9;
        byArray10[40] = -9;
        byArray11[41] = -9;
        byArray10[42] = -9;
        byArray11[43] = -9;
        byArray10[44] = -9;
        byArray11[45] = 62;
        byArray10[46] = -9;
        byArray11[47] = -9;
        byArray10[48] = 52;
        byArray11[49] = 53;
        byArray10[50] = 54;
        byArray11[51] = 55;
        byArray10[52] = 56;
        byArray11[53] = 57;
        byArray10[54] = 58;
        byArray11[55] = 59;
        byArray10[56] = 60;
        byArray11[57] = 61;
        byArray10[58] = -9;
        byArray11[59] = -9;
        byArray10[60] = -9;
        byArray11[61] = -1;
        byArray10[62] = -9;
        byArray11[63] = -9;
        byArray10[64] = -9;
        byArray11[65] = 0;
        byArray10[66] = 1;
        byArray11[67] = 2;
        byArray10[68] = 3;
        byArray11[69] = 4;
        byArray10[70] = 5;
        byArray11[71] = 6;
        byArray10[72] = 7;
        byArray11[73] = 8;
        byArray10[74] = 9;
        byArray11[75] = 10;
        byArray10[76] = 11;
        byArray11[77] = 12;
        byArray10[78] = 13;
        byArray11[79] = 14;
        byArray10[80] = 15;
        byArray11[81] = 16;
        byArray10[82] = 17;
        byArray11[83] = 18;
        byArray10[84] = 19;
        byArray11[85] = 20;
        byArray10[86] = 21;
        byArray11[87] = 22;
        byArray10[88] = 23;
        byArray11[89] = 24;
        byArray10[90] = 25;
        byArray11[91] = -9;
        byArray10[92] = -9;
        byArray11[93] = -9;
        byArray10[94] = -9;
        byArray11[95] = 63;
        byArray10[96] = -9;
        byArray11[97] = 26;
        byArray10[98] = 27;
        byArray11[99] = 28;
        byArray10[100] = 29;
        byArray11[101] = 30;
        byArray10[102] = 31;
        byArray11[103] = 32;
        byArray10[104] = 33;
        byArray11[105] = 34;
        byArray10[106] = 35;
        byArray11[107] = 36;
        byArray10[108] = 37;
        byArray11[109] = 38;
        byArray10[110] = 39;
        byArray11[111] = 40;
        byArray10[112] = 41;
        byArray11[113] = 42;
        byArray10[114] = 43;
        byArray11[115] = 44;
        byArray10[116] = 45;
        byArray11[117] = 46;
        byArray10[118] = 47;
        byArray11[119] = 48;
        byArray10[120] = 49;
        byArray11[121] = 50;
        byArray10[122] = 51;
        byArray11[123] = -9;
        byArray10[124] = -9;
        byArray11[125] = -9;
        byArray10[126] = -9;
        byArray11[127] = -9;
        byArray10[128] = -9;
        byArray11[129] = -9;
        byArray10[130] = -9;
        byArray11[131] = -9;
        byArray10[132] = -9;
        byArray11[133] = -9;
        byArray10[134] = -9;
        byArray11[135] = -9;
        byArray10[136] = -9;
        byArray11[137] = -9;
        byArray10[138] = -9;
        byArray11[139] = -9;
        byArray10[140] = -9;
        byArray11[141] = -9;
        byArray10[142] = -9;
        byArray11[143] = -9;
        byArray10[144] = -9;
        byArray11[145] = -9;
        byArray10[146] = -9;
        byArray11[147] = -9;
        byArray10[148] = -9;
        byArray11[149] = -9;
        byArray10[150] = -9;
        byArray11[151] = -9;
        byArray10[152] = -9;
        byArray11[153] = -9;
        byArray10[154] = -9;
        byArray11[155] = -9;
        byArray10[156] = -9;
        byArray11[157] = -9;
        byArray10[158] = -9;
        byArray11[159] = -9;
        byArray10[160] = -9;
        byArray11[161] = -9;
        byArray10[162] = -9;
        byArray11[163] = -9;
        byArray10[164] = -9;
        byArray11[165] = -9;
        byArray10[166] = -9;
        byArray11[167] = -9;
        byArray10[168] = -9;
        byArray11[169] = -9;
        byArray10[170] = -9;
        byArray11[171] = -9;
        byArray10[172] = -9;
        byArray11[173] = -9;
        byArray10[174] = -9;
        byArray11[175] = -9;
        byArray10[176] = -9;
        byArray11[177] = -9;
        byArray10[178] = -9;
        byArray11[179] = -9;
        byArray10[180] = -9;
        byArray11[181] = -9;
        byArray10[182] = -9;
        byArray11[183] = -9;
        byArray10[184] = -9;
        byArray11[185] = -9;
        byArray10[186] = -9;
        byArray11[187] = -9;
        byArray10[188] = -9;
        byArray11[189] = -9;
        byArray10[190] = -9;
        byArray11[191] = -9;
        byArray10[192] = -9;
        byArray11[193] = -9;
        byArray10[194] = -9;
        byArray11[195] = -9;
        byArray10[196] = -9;
        byArray11[197] = -9;
        byArray10[198] = -9;
        byArray11[199] = -9;
        byArray10[200] = -9;
        byArray11[201] = -9;
        byArray10[202] = -9;
        byArray11[203] = -9;
        byArray10[204] = -9;
        byArray11[205] = -9;
        byArray10[206] = -9;
        byArray11[207] = -9;
        byArray10[208] = -9;
        byArray11[209] = -9;
        byArray10[210] = -9;
        byArray11[211] = -9;
        byArray10[212] = -9;
        byArray11[213] = -9;
        byArray10[214] = -9;
        byArray11[215] = -9;
        byArray10[216] = -9;
        byArray11[217] = -9;
        byArray10[218] = -9;
        byArray11[219] = -9;
        byArray10[220] = -9;
        byArray11[221] = -9;
        byArray10[222] = -9;
        byArray11[223] = -9;
        byArray10[224] = -9;
        byArray11[225] = -9;
        byArray10[226] = -9;
        byArray11[227] = -9;
        byArray10[228] = -9;
        byArray11[229] = -9;
        byArray10[230] = -9;
        byArray11[231] = -9;
        byArray10[232] = -9;
        byArray11[233] = -9;
        byArray10[234] = -9;
        byArray11[235] = -9;
        byArray10[236] = -9;
        byArray11[237] = -9;
        byArray10[238] = -9;
        byArray11[239] = -9;
        byArray10[240] = -9;
        byArray11[241] = -9;
        byArray10[242] = -9;
        byArray11[243] = -9;
        byArray10[244] = -9;
        byArray11[245] = -9;
        byArray10[246] = -9;
        byArray11[247] = -9;
        byArray10[248] = -9;
        byArray11[249] = -9;
        byArray10[250] = -9;
        byArray11[251] = -9;
        byArray10[252] = -9;
        byArray11[253] = -9;
        byArray10[254] = -9;
        byArray11[255] = -9;
        o = byArray3;
        byte[] byArray12 = byArray = new byte[n10];
        byte[] byArray13 = byArray;
        byArray12[0] = 45;
        byArray13[1] = 48;
        byArray12[2] = 49;
        byArray13[3] = 50;
        byArray12[4] = 51;
        byArray13[5] = 52;
        byArray12[6] = 53;
        byArray13[7] = 54;
        byArray12[8] = 55;
        byArray13[9] = 56;
        byArray12[10] = 57;
        byArray13[11] = 65;
        byArray12[12] = 66;
        byArray13[13] = 67;
        byArray12[14] = 68;
        byArray13[15] = 69;
        byArray12[16] = 70;
        byArray13[17] = 71;
        byArray12[18] = 72;
        byArray13[19] = 73;
        byArray12[20] = 74;
        byArray13[21] = 75;
        byArray12[22] = 76;
        byArray13[23] = 77;
        byArray12[24] = 78;
        byArray13[25] = 79;
        byArray12[26] = 80;
        byArray13[27] = 81;
        byArray12[28] = 82;
        byArray13[29] = 83;
        byArray12[30] = 84;
        byArray13[31] = 85;
        byArray12[32] = 86;
        byArray13[33] = 87;
        byArray12[34] = 88;
        byArray13[35] = 89;
        byArray12[36] = 90;
        byArray13[37] = 95;
        byArray12[38] = 97;
        byArray13[39] = 98;
        byArray12[40] = 99;
        byArray13[41] = 100;
        byArray12[42] = 101;
        byArray13[43] = 102;
        byArray12[44] = 103;
        byArray13[45] = 104;
        byArray12[46] = 105;
        byArray13[47] = 106;
        byArray12[48] = 107;
        byArray13[49] = 108;
        byArray12[50] = 109;
        byArray13[51] = 110;
        byArray12[52] = 111;
        byArray13[53] = 112;
        byArray12[54] = 113;
        byArray13[55] = 114;
        byArray12[56] = 115;
        byArray13[57] = 116;
        byArray12[58] = 117;
        byArray13[59] = 118;
        byArray12[60] = 119;
        byArray13[61] = 120;
        byArray12[62] = 121;
        byArray13[63] = 122;
        p = byArray;
        byte[] byArray14 = byArray = new byte[257];
        byte[] byArray15 = byArray;
        byArray14[0] = -9;
        byArray15[1] = -9;
        byArray14[2] = -9;
        byArray15[3] = -9;
        byArray14[4] = -9;
        byArray15[5] = -9;
        byArray14[6] = -9;
        byArray15[7] = -9;
        byArray14[8] = -9;
        byArray15[9] = -5;
        byArray14[10] = -5;
        byArray15[11] = -9;
        byArray14[12] = -9;
        byArray15[13] = -5;
        byArray14[14] = -9;
        byArray15[15] = -9;
        byArray14[16] = -9;
        byArray15[17] = -9;
        byArray14[18] = -9;
        byArray15[19] = -9;
        byArray14[20] = -9;
        byArray15[21] = -9;
        byArray14[22] = -9;
        byArray15[23] = -9;
        byArray14[24] = -9;
        byArray15[25] = -9;
        byArray14[26] = -9;
        byArray15[27] = -9;
        byArray14[28] = -9;
        byArray15[29] = -9;
        byArray14[30] = -9;
        byArray15[31] = -9;
        byArray14[32] = -5;
        byArray15[33] = -9;
        byArray14[34] = -9;
        byArray15[35] = -9;
        byArray14[36] = -9;
        byArray15[37] = -9;
        byArray14[38] = -9;
        byArray15[39] = -9;
        byArray14[40] = -9;
        byArray15[41] = -9;
        byArray14[42] = -9;
        byArray15[43] = -9;
        byArray14[44] = -9;
        byArray15[45] = 0;
        byArray14[46] = -9;
        byArray15[47] = -9;
        byArray14[48] = 1;
        byArray15[49] = 2;
        byArray14[50] = 3;
        byArray15[51] = 4;
        byArray14[52] = 5;
        byArray15[53] = 6;
        byArray14[54] = 7;
        byArray15[55] = 8;
        byArray14[56] = 9;
        byArray15[57] = 10;
        byArray14[58] = -9;
        byArray15[59] = -9;
        byArray14[60] = -9;
        byArray15[61] = -1;
        byArray14[62] = -9;
        byArray15[63] = -9;
        byArray14[64] = -9;
        byArray15[65] = 11;
        byArray14[66] = 12;
        byArray15[67] = 13;
        byArray14[68] = 14;
        byArray15[69] = 15;
        byArray14[70] = 16;
        byArray15[71] = 17;
        byArray14[72] = 18;
        byArray15[73] = 19;
        byArray14[74] = 20;
        byArray15[75] = 21;
        byArray14[76] = 22;
        byArray15[77] = 23;
        byArray14[78] = 24;
        byArray15[79] = 25;
        byArray14[80] = 26;
        byArray15[81] = 27;
        byArray14[82] = 28;
        byArray15[83] = 29;
        byArray14[84] = 30;
        byArray15[85] = 31;
        byArray14[86] = 32;
        byArray15[87] = 33;
        byArray14[88] = 34;
        byArray15[89] = 35;
        byArray14[90] = 36;
        byArray15[91] = -9;
        byArray14[92] = -9;
        byArray15[93] = -9;
        byArray14[94] = -9;
        byArray15[95] = 37;
        byArray14[96] = -9;
        byArray15[97] = 38;
        byArray14[98] = 39;
        byArray15[99] = 40;
        byArray14[100] = 41;
        byArray15[101] = 42;
        byArray14[102] = 43;
        byArray15[103] = 44;
        byArray14[104] = 45;
        byArray15[105] = 46;
        byArray14[106] = 47;
        byArray15[107] = 48;
        byArray14[108] = 49;
        byArray15[109] = 50;
        byArray14[110] = 51;
        byArray15[111] = 52;
        byArray14[112] = 53;
        byArray15[113] = 54;
        byArray14[114] = 55;
        byArray15[115] = 56;
        byArray14[116] = 57;
        byArray15[117] = 58;
        byArray14[118] = 59;
        byArray15[119] = 60;
        byArray14[120] = 61;
        byArray15[121] = 62;
        byArray14[122] = 63;
        byArray15[123] = -9;
        byArray14[124] = -9;
        byArray15[125] = -9;
        byArray14[126] = -9;
        byArray15[127] = -9;
        byArray14[128] = -9;
        byArray15[129] = -9;
        byArray14[130] = -9;
        byArray15[131] = -9;
        byArray14[132] = -9;
        byArray15[133] = -9;
        byArray14[134] = -9;
        byArray15[135] = -9;
        byArray14[136] = -9;
        byArray15[137] = -9;
        byArray14[138] = -9;
        byArray15[139] = -9;
        byArray14[140] = -9;
        byArray15[141] = -9;
        byArray14[142] = -9;
        byArray15[143] = -9;
        byArray14[144] = -9;
        byArray15[145] = -9;
        byArray14[146] = -9;
        byArray15[147] = -9;
        byArray14[148] = -9;
        byArray15[149] = -9;
        byArray14[150] = -9;
        byArray15[151] = -9;
        byArray14[152] = -9;
        byArray15[153] = -9;
        byArray14[154] = -9;
        byArray15[155] = -9;
        byArray14[156] = -9;
        byArray15[157] = -9;
        byArray14[158] = -9;
        byArray15[159] = -9;
        byArray14[160] = -9;
        byArray15[161] = -9;
        byArray14[162] = -9;
        byArray15[163] = -9;
        byArray14[164] = -9;
        byArray15[165] = -9;
        byArray14[166] = -9;
        byArray15[167] = -9;
        byArray14[168] = -9;
        byArray15[169] = -9;
        byArray14[170] = -9;
        byArray15[171] = -9;
        byArray14[172] = -9;
        byArray15[173] = -9;
        byArray14[174] = -9;
        byArray15[175] = -9;
        byArray14[176] = -9;
        byArray15[177] = -9;
        byArray14[178] = -9;
        byArray15[179] = -9;
        byArray14[180] = -9;
        byArray15[181] = -9;
        byArray14[182] = -9;
        byArray15[183] = -9;
        byArray14[184] = -9;
        byArray15[185] = -9;
        byArray14[186] = -9;
        byArray15[187] = -9;
        byArray14[188] = -9;
        byArray15[189] = -9;
        byArray14[190] = -9;
        byArray15[191] = -9;
        byArray14[192] = -9;
        byArray15[193] = -9;
        byArray14[194] = -9;
        byArray15[195] = -9;
        byArray14[196] = -9;
        byArray15[197] = -9;
        byArray14[198] = -9;
        byArray15[199] = -9;
        byArray14[200] = -9;
        byArray15[201] = -9;
        byArray14[202] = -9;
        byArray15[203] = -9;
        byArray14[204] = -9;
        byArray15[205] = -9;
        byArray14[206] = -9;
        byArray15[207] = -9;
        byArray14[208] = -9;
        byArray15[209] = -9;
        byArray14[210] = -9;
        byArray15[211] = -9;
        byArray14[212] = -9;
        byArray15[213] = -9;
        byArray14[214] = -9;
        byArray15[215] = -9;
        byArray14[216] = -9;
        byArray15[217] = -9;
        byArray14[218] = -9;
        byArray15[219] = -9;
        byArray14[220] = -9;
        byArray15[221] = -9;
        byArray14[222] = -9;
        byArray15[223] = -9;
        byArray14[224] = -9;
        byArray15[225] = -9;
        byArray14[226] = -9;
        byArray15[227] = -9;
        byArray14[228] = -9;
        byArray15[229] = -9;
        byArray14[230] = -9;
        byArray15[231] = -9;
        byArray14[232] = -9;
        byArray15[233] = -9;
        byArray14[234] = -9;
        byArray15[235] = -9;
        byArray14[236] = -9;
        byArray15[237] = -9;
        byArray14[238] = -9;
        byArray15[239] = -9;
        byArray14[240] = -9;
        byArray15[241] = -9;
        byArray14[242] = -9;
        byArray15[243] = -9;
        byArray14[244] = -9;
        byArray15[245] = -9;
        byArray14[246] = -9;
        byArray15[247] = -9;
        byArray14[248] = -9;
        byArray15[249] = -9;
        byArray14[250] = -9;
        byArray15[251] = -9;
        byArray14[252] = -9;
        byArray15[253] = -9;
        byArray14[254] = -9;
        byArray15[255] = -9;
        byArray15[256] = -9;
        q = byArray;
    }

    private a() {
    }

    public static /* synthetic */ byte[] a(int n10) {
        return i.d.u.a.k(n10);
    }

    public static /* synthetic */ byte[] b(byte[] byArray, byte[] byArray2, int n10, int n11) {
        return i.d.u.a.f(byArray, byArray2, n10, n11);
    }

    public static /* synthetic */ int c(byte[] byArray, int n10, byte[] byArray2, int n11, int n12) {
        return i.d.u.a.d(byArray, n10, byArray2, n11, n12);
    }

    private static int d(byte[] object, int n10, byte[] object2, int n11, int n12) {
        if (object != null) {
            if (object2 != null) {
                int n13;
                int n14;
                int n15 = 0;
                int n16 = 2;
                int n17 = 1;
                if (n10 >= 0 && (n14 = n10 + 3) < (n13 = ((byte[])object).length)) {
                    int n18;
                    if (n11 >= 0 && (n13 = n11 + 2) < (n18 = ((byte[])object2).length)) {
                        byte[] byArray = i.d.u.a.k(n12);
                        n15 = n10 + 2;
                        n18 = object[n15];
                        int n19 = 61;
                        if (n18 == n19) {
                            n15 = object[n10];
                            n15 = (byArray[n15] & 0xFF) << 18;
                            byte by2 = object[n10 += n17];
                            object2[n11] = by2 = (byte)(((byArray[by2] & 0xFF) << 12 | n15) >>> 16);
                            return n17;
                        }
                        n18 = object[n14];
                        if (n18 == n19) {
                            n14 = object[n10];
                            n14 = (byArray[n14] & 0xFF) << 18;
                            n10 += n17;
                            n10 = object[n10];
                            n10 = (byArray[n10] & 0xFF) << 12 | n14;
                            int n20 = object[n15];
                            n20 = (byArray[n20] & 0xFF) << 6 | n10;
                            object2[n11] = n10 = (int)((byte)(n20 >>> 16));
                            object2[n11 += n17] = n20 = (int)((byte)(n20 >>> 8));
                            return n16;
                        }
                        n16 = object[n10];
                        n16 = (byArray[n16] & 0xFF) << 18;
                        n10 += n17;
                        n10 = object[n10];
                        n10 = (byArray[n10] & 0xFF) << 12 | n16;
                        n15 = object[n15];
                        n15 = (byArray[n15] & 0xFF) << 6;
                        int n21 = object[n14];
                        n21 = byArray[n21] & 0xFF | (n10 |= n15);
                        object2[n11] = n10 = (int)((byte)(n21 >> 16));
                        object2[n11 += n17] = n10 = (int)((byte)(n21 >> 8));
                        object2[n13] = n21 = (int)((byte)n21);
                        return 3;
                    }
                    object = new IllegalArgumentException;
                    Object object3 = new Object[n16];
                    object2 = ((byte[])object2).length;
                    object3[0] = object2;
                    object2 = n11;
                    object3[n17] = object2;
                    object3 = String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", object3);
                    object((String)object3);
                    throw object;
                }
                object2 = new IllegalArgumentException;
                Object[] objectArray = new Object[n16];
                object = ((byte[])object).length;
                objectArray[0] = object;
                object = n10;
                objectArray[n17] = object;
                object = String.format("Source array with length %d cannot have offset of %d and still process four bytes.", objectArray);
                object2((String)object);
                throw object2;
            }
            object = new IllegalArgumentException;
            object("Destination array was null.");
            throw object;
        }
        object = new IllegalArgumentException;
        object("Source array was null.");
        throw object;
    }

    private static byte[] e(byte[] byArray, int n10, int n11, byte[] byArray2, int n12, int n13) {
        int n14;
        int n15;
        byte[] byArray3 = i.d.u.a.j(n13);
        int n16 = 0;
        int n17 = n11 > 0 ? byArray[n10] << 24 >>> 8 : 0;
        int n18 = 1;
        if (n11 > n18) {
            n15 = n10 + 1;
            n15 = byArray[n15] << 24 >>> 16;
        } else {
            n15 = 0;
        }
        n17 |= n15;
        n15 = 2;
        if (n11 > n15) {
            n14 = byArray[n10 += n15] << 24;
            n16 = n14 >>> 24;
        }
        n14 = n17 | n16;
        n10 = 61;
        n16 = 3;
        if (n11 != n18) {
            if (n11 != n15) {
                if (n11 != n16) {
                    return byArray2;
                }
                n10 = n14 >>> 18;
                byArray2[n12] = n10 = byArray3[n10];
                n10 = n12 + 1;
                n11 = n14 >>> 12 & 0x3F;
                byArray2[n10] = n11 = byArray3[n11];
                n10 = n12 + 2;
                n11 = n14 >>> 6 & 0x3F;
                byArray2[n10] = n11 = byArray3[n11];
                n14 &= 0x3F;
                byArray2[n12 += n16] = n14 = byArray3[n14];
                return byArray2;
            }
            n11 = n14 >>> 18;
            byArray2[n12] = n11 = byArray3[n11];
            n11 = n12 + 1;
            n17 = n14 >>> 12 & 0x3F;
            byArray2[n11] = n17 = byArray3[n17];
            n11 = n12 + 2;
            n14 = n14 >>> 6 & 0x3F;
            byArray2[n11] = n14 = byArray3[n14];
            byArray2[n12 += n16] = n10;
            return byArray2;
        }
        n11 = n14 >>> 18;
        byArray2[n12] = n11 = byArray3[n11];
        n11 = n12 + 1;
        n14 = n14 >>> 12 & 0x3F;
        byArray2[n11] = n14 = byArray3[n14];
        n14 = n12 + 2;
        byArray2[n14] = n10;
        byArray2[n12 += n16] = n10;
        return byArray2;
    }

    private static byte[] f(byte[] byArray, byte[] byArray2, int n10, int n11) {
        i.d.u.a.e(byArray2, 0, n10, byArray, 0, n11);
        return byArray;
    }

    public static String g(byte[] object) {
        int n10 = ((byte[])object).length;
        try {
            object = i.d.u.a.h(object, 0, n10, 0);
        }
        catch (IOException iOException) {
            object = null;
        }
        return object;
    }

    public static String h(byte[] byArray, int n10, int n11, int n12) {
        String string2;
        byArray = i.d.u.a.i(byArray, n10, n11, n12);
        String string3 = j;
        try {
            string2 = new String(byArray, string3);
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string2 = new String(byArray);
            return string2;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] i(byte[] byArray, int n10, int n11, int n12) {
        int n13;
        byte[] byArray2;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        byte[] byArray3;
        int n19;
        int n20;
        int n21;
        int n22;
        int n23;
        int n24;
        block47: {
            void var4_17;
            a$a a$a;
            ByteArrayOutputStream byteArrayOutputStream;
            block42: {
                block38: {
                    block45: {
                        void var10_32;
                        block41: {
                            GZIPOutputStream gZIPOutputStream;
                            block39: {
                                block46: {
                                    block40: {
                                        byte[] byArray4 = byArray;
                                        n24 = n10;
                                        n23 = n11;
                                        if (byArray == null) {
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot serialize a null array.");
                                            throw illegalArgumentException;
                                        }
                                        if (n10 < 0) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Cannot have negative offset: ");
                                            stringBuilder.append(n10);
                                            String string2 = stringBuilder.toString();
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                                            throw illegalArgumentException;
                                        }
                                        if (n11 < 0) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Cannot have length offset: ");
                                            stringBuilder.append(n11);
                                            String string3 = stringBuilder.toString();
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                                            throw illegalArgumentException;
                                        }
                                        n22 = n10 + n11;
                                        n21 = byArray.length;
                                        n20 = 1;
                                        if (n22 > n21) {
                                            Object[] objectArray = new Object[3];
                                            Integer n25 = n10;
                                            objectArray[0] = n25;
                                            Integer n26 = n11;
                                            objectArray[n20] = n26;
                                            Integer n27 = byArray.length;
                                            objectArray[2] = n27;
                                            String string4 = String.format("Cannot have offset of %d and length of %d with array of length %d", objectArray);
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
                                            throw illegalArgumentException;
                                        }
                                        n22 = n12 & 2;
                                        if (n22 == 0) break block45;
                                        n22 = 0;
                                        Object var10_28 = null;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        int n28 = n12 | 1;
                                        a$a = new a$a(byteArrayOutputStream, n28);
                                        gZIPOutputStream = new GZIPOutputStream(a$a);
                                        gZIPOutputStream.write(byArray, n10, n11);
                                        gZIPOutputStream.close();
                                        try {
                                            gZIPOutputStream.close();
                                            break block38;
                                        }
                                        catch (Exception exception) {}
                                        catch (Throwable throwable) {
                                            break block39;
                                        }
                                        catch (IOException iOException) {
                                            break block40;
                                        }
                                        catch (Throwable throwable) {
                                            break block41;
                                        }
                                        catch (IOException iOException) {
                                            n28 = 0;
                                            gZIPOutputStream = null;
                                            break block40;
                                        }
                                        catch (Throwable throwable) {
                                            boolean bl2 = false;
                                            a$a = null;
                                            break block41;
                                        }
                                        catch (IOException iOException) {
                                            boolean bl3 = false;
                                            a$a = null;
                                            boolean bl4 = false;
                                            gZIPOutputStream = null;
                                        }
                                    }
                                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                                    break block46;
                                    catch (Throwable throwable) {
                                        n21 = 0;
                                        byteArrayOutputStream = null;
                                        boolean bl5 = false;
                                        a$a = null;
                                        break block41;
                                    }
                                    catch (IOException iOException) {
                                        boolean bl6 = false;
                                        a$a = null;
                                        boolean bl7 = false;
                                        gZIPOutputStream = null;
                                    }
                                }
                                try {
                                    void var4_14;
                                    throw var4_14;
                                }
                                catch (Throwable throwable) {
                                    void var10_30;
                                    byteArrayOutputStream = var10_30;
                                }
                            }
                            GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream;
                        }
                        if (var10_32 == null) break block42;
                        try {
                            var10_32.close();
                            break block42;
                        }
                        catch (Exception exception) {}
                    }
                    n22 = n12 & 8;
                    n19 = n22 != 0 ? n20 : 0;
                    n22 = n23 / 3;
                    int n29 = 4;
                    n22 *= n29;
                    n21 = n23 % 3;
                    if (n21 > 0) {
                        n21 = n29;
                    } else {
                        n21 = 0;
                        Object var11_43 = null;
                    }
                    n22 += n21;
                    if (n19 != 0) {
                        n21 = n22 / 76;
                        n22 += n21;
                    }
                    int n30 = n22;
                    byArray3 = new byte[n22];
                    n18 = n23 + -2;
                    n17 = 0;
                    n16 = 0;
                    n15 = 0;
                    break block47;
                }
                try {
                    a$a.close();
                }
                catch (Exception exception) {}
                try {
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                catch (Exception exception) {
                    return byteArrayOutputStream.toByteArray();
                }
            }
            if (a$a != null) {
                try {
                    a$a.close();
                }
                catch (Exception exception) {}
            }
            if (byteArrayOutputStream == null) throw var4_17;
            try {
                byteArrayOutputStream.close();
            }
            catch (Exception exception) {
                throw var4_17;
            }
            throw var4_17;
        }
        while (n17 < n18) {
            n21 = n17 + n24;
            n14 = 3;
            byte[] byArray5 = byArray;
            byArray2 = byArray3;
            n13 = n17;
            n17 = n12;
            i.d.u.a.e(byArray, n21, n14, byArray3, n16, n12);
            n22 = n15 + 4;
            if (n19 != 0 && n22 >= (n21 = 76)) {
                n22 = n16 + 4;
                byArray3[n22] = n21 = 10;
                ++n16;
                n15 = 0;
            } else {
                n15 = n22;
            }
            n17 = n13 + 3;
            n16 += 4;
        }
        n13 = n17;
        if (n17 < n23) {
            n21 = n17 + n24;
            n14 = n23 - n17;
            byte[] byArray6 = byArray;
            byArray2 = byArray3;
            n17 = n12;
            i.d.u.a.e(byArray, n21, n14, byArray3, n16, n12);
            n16 += 4;
        }
        if (n16 > (n30 -= n20)) return byArray3;
        byte[] byArray7 = new byte[n16];
        System.arraycopy(byArray3, 0, byArray7, 0, n16);
        return byArray7;
    }

    private static final byte[] j(int n10) {
        int n11 = n10 & 0x10;
        int n12 = 16;
        if (n11 == n12) {
            return n;
        }
        n11 = 32;
        if ((n10 &= n11) == n11) {
            return p;
        }
        return l;
    }

    private static final byte[] k(int n10) {
        int n11 = n10 & 0x10;
        int n12 = 16;
        if (n11 == n12) {
            return o;
        }
        n11 = 32;
        if ((n10 &= n11) == n11) {
            return q;
        }
        return m;
    }
}


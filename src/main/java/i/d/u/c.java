/*
 * Decompiled with CFR 0.151.
 */
package i.d.u;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidEncodingException;

public class c {
    private static final CodingErrorAction a;
    private static final int[] b;

    static {
        int[] nArray;
        a = CodingErrorAction.REPORT;
        int[] nArray2 = nArray = new int[400];
        int[] nArray3 = nArray;
        nArray2[0] = 0;
        nArray3[1] = 0;
        nArray2[2] = 0;
        nArray3[3] = 0;
        nArray2[4] = 0;
        nArray3[5] = 0;
        nArray2[6] = 0;
        nArray3[7] = 0;
        nArray2[8] = 0;
        nArray3[9] = 0;
        nArray2[10] = 0;
        nArray3[11] = 0;
        nArray2[12] = 0;
        nArray3[13] = 0;
        nArray2[14] = 0;
        nArray3[15] = 0;
        nArray2[16] = 0;
        nArray3[17] = 0;
        nArray2[18] = 0;
        nArray3[19] = 0;
        nArray2[20] = 0;
        nArray3[21] = 0;
        nArray2[22] = 0;
        nArray3[23] = 0;
        nArray2[24] = 0;
        nArray3[25] = 0;
        nArray2[26] = 0;
        nArray3[27] = 0;
        nArray2[28] = 0;
        nArray3[29] = 0;
        nArray2[30] = 0;
        nArray3[31] = 0;
        nArray2[32] = 0;
        nArray3[33] = 0;
        nArray2[34] = 0;
        nArray3[35] = 0;
        nArray2[36] = 0;
        nArray3[37] = 0;
        nArray2[38] = 0;
        nArray3[39] = 0;
        nArray2[40] = 0;
        nArray3[41] = 0;
        nArray2[42] = 0;
        nArray3[43] = 0;
        nArray2[44] = 0;
        nArray3[45] = 0;
        nArray2[46] = 0;
        nArray3[47] = 0;
        nArray2[48] = 0;
        nArray3[49] = 0;
        nArray2[50] = 0;
        nArray3[51] = 0;
        nArray2[52] = 0;
        nArray3[53] = 0;
        nArray2[54] = 0;
        nArray3[55] = 0;
        nArray2[56] = 0;
        nArray3[57] = 0;
        nArray2[58] = 0;
        nArray3[59] = 0;
        nArray2[60] = 0;
        nArray3[61] = 0;
        nArray2[62] = 0;
        nArray3[63] = 0;
        nArray2[64] = 0;
        nArray3[65] = 0;
        nArray2[66] = 0;
        nArray3[67] = 0;
        nArray2[68] = 0;
        nArray3[69] = 0;
        nArray2[70] = 0;
        nArray3[71] = 0;
        nArray2[72] = 0;
        nArray3[73] = 0;
        nArray2[74] = 0;
        nArray3[75] = 0;
        nArray2[76] = 0;
        nArray3[77] = 0;
        nArray2[78] = 0;
        nArray3[79] = 0;
        nArray2[80] = 0;
        nArray3[81] = 0;
        nArray2[82] = 0;
        nArray3[83] = 0;
        nArray2[84] = 0;
        nArray3[85] = 0;
        nArray2[86] = 0;
        nArray3[87] = 0;
        nArray2[88] = 0;
        nArray3[89] = 0;
        nArray2[90] = 0;
        nArray3[91] = 0;
        nArray2[92] = 0;
        nArray3[93] = 0;
        nArray2[94] = 0;
        nArray3[95] = 0;
        nArray2[96] = 0;
        nArray3[97] = 0;
        nArray2[98] = 0;
        nArray3[99] = 0;
        nArray2[100] = 0;
        nArray3[101] = 0;
        nArray2[102] = 0;
        nArray3[103] = 0;
        nArray2[104] = 0;
        nArray3[105] = 0;
        nArray2[106] = 0;
        nArray3[107] = 0;
        nArray2[108] = 0;
        nArray3[109] = 0;
        nArray2[110] = 0;
        nArray3[111] = 0;
        nArray2[112] = 0;
        nArray3[113] = 0;
        nArray2[114] = 0;
        nArray3[115] = 0;
        nArray2[116] = 0;
        nArray3[117] = 0;
        nArray2[118] = 0;
        nArray3[119] = 0;
        nArray2[120] = 0;
        nArray3[121] = 0;
        nArray2[122] = 0;
        nArray3[123] = 0;
        nArray2[124] = 0;
        nArray3[125] = 0;
        nArray2[126] = 0;
        nArray3[127] = 0;
        nArray2[128] = 1;
        nArray3[129] = 1;
        nArray2[130] = 1;
        nArray3[131] = 1;
        nArray2[132] = 1;
        nArray3[133] = 1;
        nArray2[134] = 1;
        nArray3[135] = 1;
        nArray2[136] = 1;
        nArray3[137] = 1;
        nArray2[138] = 1;
        nArray3[139] = 1;
        nArray2[140] = 1;
        nArray3[141] = 1;
        nArray2[142] = 1;
        nArray3[143] = 1;
        nArray2[144] = 9;
        nArray3[145] = 9;
        nArray2[146] = 9;
        nArray3[147] = 9;
        nArray2[148] = 9;
        nArray3[149] = 9;
        nArray2[150] = 9;
        nArray3[151] = 9;
        nArray2[152] = 9;
        nArray3[153] = 9;
        nArray2[154] = 9;
        nArray3[155] = 9;
        nArray2[156] = 9;
        nArray3[157] = 9;
        nArray2[158] = 9;
        nArray3[159] = 9;
        nArray2[160] = 7;
        nArray3[161] = 7;
        nArray2[162] = 7;
        nArray3[163] = 7;
        nArray2[164] = 7;
        nArray3[165] = 7;
        nArray2[166] = 7;
        nArray3[167] = 7;
        nArray2[168] = 7;
        nArray3[169] = 7;
        nArray2[170] = 7;
        nArray3[171] = 7;
        nArray2[172] = 7;
        nArray3[173] = 7;
        nArray2[174] = 7;
        nArray3[175] = 7;
        nArray2[176] = 7;
        nArray3[177] = 7;
        nArray2[178] = 7;
        nArray3[179] = 7;
        nArray2[180] = 7;
        nArray3[181] = 7;
        nArray2[182] = 7;
        nArray3[183] = 7;
        nArray2[184] = 7;
        nArray3[185] = 7;
        nArray2[186] = 7;
        nArray3[187] = 7;
        nArray2[188] = 7;
        nArray3[189] = 7;
        nArray2[190] = 7;
        nArray3[191] = 7;
        nArray2[192] = 8;
        nArray3[193] = 8;
        nArray2[194] = 2;
        nArray3[195] = 2;
        nArray2[196] = 2;
        nArray3[197] = 2;
        nArray2[198] = 2;
        nArray3[199] = 2;
        nArray2[200] = 2;
        nArray3[201] = 2;
        nArray2[202] = 2;
        nArray3[203] = 2;
        nArray2[204] = 2;
        nArray3[205] = 2;
        nArray2[206] = 2;
        nArray3[207] = 2;
        nArray2[208] = 2;
        nArray3[209] = 2;
        nArray2[210] = 2;
        nArray3[211] = 2;
        nArray2[212] = 2;
        nArray3[213] = 2;
        nArray2[214] = 2;
        nArray3[215] = 2;
        nArray2[216] = 2;
        nArray3[217] = 2;
        nArray2[218] = 2;
        nArray3[219] = 2;
        nArray2[220] = 2;
        nArray3[221] = 2;
        nArray2[222] = 2;
        nArray3[223] = 2;
        nArray2[224] = 10;
        nArray3[225] = 3;
        nArray2[226] = 3;
        nArray3[227] = 3;
        nArray2[228] = 3;
        nArray3[229] = 3;
        nArray2[230] = 3;
        nArray3[231] = 3;
        nArray2[232] = 3;
        nArray3[233] = 3;
        nArray2[234] = 3;
        nArray3[235] = 3;
        nArray2[236] = 3;
        nArray3[237] = 4;
        nArray2[238] = 3;
        nArray3[239] = 3;
        nArray2[240] = 11;
        nArray3[241] = 6;
        nArray2[242] = 6;
        nArray3[243] = 6;
        nArray2[244] = 5;
        nArray3[245] = 8;
        nArray2[246] = 8;
        nArray3[247] = 8;
        nArray2[248] = 8;
        nArray3[249] = 8;
        nArray2[250] = 8;
        nArray3[251] = 8;
        nArray2[252] = 8;
        nArray3[253] = 8;
        nArray2[254] = 8;
        nArray3[255] = 8;
        nArray2[256] = 0;
        nArray3[257] = 1;
        nArray2[258] = 2;
        nArray3[259] = 3;
        nArray2[260] = 5;
        nArray3[261] = 8;
        nArray2[262] = 7;
        nArray3[263] = 1;
        nArray2[264] = 1;
        nArray3[265] = 1;
        nArray2[266] = 4;
        nArray3[267] = 6;
        nArray2[268] = 1;
        nArray3[269] = 1;
        nArray2[270] = 1;
        nArray3[271] = 1;
        nArray2[272] = 1;
        nArray3[273] = 1;
        nArray2[274] = 1;
        nArray3[275] = 1;
        nArray2[276] = 1;
        nArray3[277] = 1;
        nArray2[278] = 1;
        nArray3[279] = 1;
        nArray2[280] = 1;
        nArray3[281] = 1;
        nArray2[282] = 1;
        nArray3[283] = 1;
        nArray2[284] = 1;
        nArray3[285] = 1;
        nArray2[286] = 1;
        nArray3[287] = 1;
        nArray2[288] = 1;
        nArray3[289] = 0;
        nArray2[290] = 1;
        nArray3[291] = 1;
        nArray2[292] = 1;
        nArray3[293] = 1;
        nArray2[294] = 1;
        nArray3[295] = 0;
        nArray2[296] = 1;
        nArray3[297] = 0;
        nArray2[298] = 1;
        nArray3[299] = 1;
        nArray2[300] = 1;
        nArray3[301] = 1;
        nArray2[302] = 1;
        nArray3[303] = 1;
        nArray2[304] = 1;
        nArray3[305] = 2;
        nArray2[306] = 1;
        nArray3[307] = 1;
        nArray2[308] = 1;
        nArray3[309] = 1;
        nArray2[310] = 1;
        nArray3[311] = 2;
        nArray2[312] = 1;
        nArray3[313] = 2;
        nArray2[314] = 1;
        nArray3[315] = 1;
        nArray2[316] = 1;
        nArray3[317] = 1;
        nArray2[318] = 1;
        nArray3[319] = 1;
        nArray2[320] = 1;
        nArray3[321] = 1;
        nArray2[322] = 1;
        nArray3[323] = 1;
        nArray2[324] = 1;
        nArray3[325] = 1;
        nArray2[326] = 1;
        nArray3[327] = 2;
        nArray2[328] = 1;
        nArray3[329] = 1;
        nArray2[330] = 1;
        nArray3[331] = 1;
        nArray2[332] = 1;
        nArray3[333] = 1;
        nArray2[334] = 1;
        nArray3[335] = 1;
        nArray2[336] = 1;
        nArray3[337] = 2;
        nArray2[338] = 1;
        nArray3[339] = 1;
        nArray2[340] = 1;
        nArray3[341] = 1;
        nArray2[342] = 1;
        nArray3[343] = 1;
        nArray2[344] = 1;
        nArray3[345] = 2;
        nArray2[346] = 1;
        nArray3[347] = 1;
        nArray2[348] = 1;
        nArray3[349] = 1;
        nArray2[350] = 1;
        nArray3[351] = 1;
        nArray2[352] = 1;
        nArray3[353] = 1;
        nArray2[354] = 1;
        nArray3[355] = 1;
        nArray2[356] = 1;
        nArray3[357] = 1;
        nArray2[358] = 1;
        nArray3[359] = 3;
        nArray2[360] = 1;
        nArray3[361] = 3;
        nArray2[362] = 1;
        nArray3[363] = 1;
        nArray2[364] = 1;
        nArray3[365] = 1;
        nArray2[366] = 1;
        nArray3[367] = 1;
        nArray2[368] = 1;
        nArray3[369] = 3;
        nArray2[370] = 1;
        nArray3[371] = 1;
        nArray2[372] = 1;
        nArray3[373] = 1;
        nArray2[374] = 1;
        nArray3[375] = 3;
        nArray2[376] = 1;
        nArray3[377] = 3;
        nArray2[378] = 1;
        nArray3[379] = 1;
        nArray2[380] = 1;
        nArray3[381] = 1;
        nArray2[382] = 1;
        nArray3[383] = 1;
        nArray2[384] = 1;
        nArray3[385] = 3;
        nArray2[386] = 1;
        nArray3[387] = 1;
        nArray2[388] = 1;
        nArray3[389] = 1;
        nArray2[390] = 1;
        nArray3[391] = 1;
        nArray2[392] = 1;
        nArray3[393] = 1;
        nArray2[394] = 1;
        nArray3[395] = 1;
        nArray2[396] = 1;
        nArray3[397] = 1;
        nArray2[398] = 1;
        nArray3[399] = 1;
        b = nArray;
    }

    private c() {
    }

    public static byte[] a(String string2) {
        Object object = "ASCII";
        try {
            return string2.getBytes((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new InvalidEncodingException(unsupportedEncodingException);
            throw object;
        }
    }

    public static boolean b(ByteBuffer byteBuffer) {
        return c.c(byteBuffer, 0);
    }

    public static boolean c(ByteBuffer byteBuffer, int n10) {
        int n11;
        int n12 = byteBuffer.remaining();
        if (n12 < n10) {
            return false;
        }
        int n13 = 0;
        while (true) {
            n11 = 1;
            if (n10 >= n12) break;
            int[] nArray = b;
            n13 = (n13 << 4) + 256;
            int n14 = byteBuffer.get(n10) & 0xFF;
            n14 = nArray[n14];
            n13 += n14;
            if ((n13 = nArray[n13]) == n11) {
                return false;
            }
            ++n10;
        }
        return n11 != 0;
    }

    public static String d(byte[] byArray) {
        int n10 = byArray.length;
        return c.e(byArray, 0, n10);
    }

    public static String e(byte[] byArray, int n10, int n11) {
        String string2 = "ASCII";
        try {
            String string3 = new String(byArray, n10, n11, string2);
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            InvalidEncodingException invalidEncodingException = new InvalidEncodingException(unsupportedEncodingException);
            throw invalidEncodingException;
        }
    }

    public static String f(ByteBuffer byteBuffer) {
        Object object = Charset.forName("UTF8").newDecoder();
        CodingErrorAction codingErrorAction = a;
        ((CharsetDecoder)object).onMalformedInput(codingErrorAction);
        ((CharsetDecoder)object).onUnmappableCharacter(codingErrorAction);
        try {
            byteBuffer.mark();
        }
        catch (CharacterCodingException characterCodingException) {
            object = new InvalidDataException(1007, (Throwable)characterCodingException);
            throw object;
        }
        object = ((CharsetDecoder)object).decode(byteBuffer);
        object = ((CharBuffer)object).toString();
        byteBuffer.reset();
        return object;
    }

    public static String g(byte[] byArray) {
        return c.f(ByteBuffer.wrap(byArray));
    }

    public static byte[] h(String string2) {
        Object object = "UTF8";
        try {
            return string2.getBytes((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new InvalidEncodingException(unsupportedEncodingException);
            throw object;
        }
    }
}


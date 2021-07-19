/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder;
import com.google.android.exoplayer2.text.cea.CeaDecoder;
import com.google.android.exoplayer2.text.cea.CeaSubtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea608Decoder
extends CeaDecoder {
    private static final int[] BASIC_CHARACTER_SET;
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_FLAG = 4;
    private static final int[] COLUMN_INDICES;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_RESUME_TEXT_DISPLAY = 43;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final byte CTRL_TEXT_RESTART = 42;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000L;
    private static final int NTSC_CC_CHANNEL_1 = 0;
    private static final int NTSC_CC_CHANNEL_2 = 1;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final boolean[] ODD_PARITY_BYTE_TABLE;
    private static final int[] ROW_INDICES;
    private static final int[] SPECIAL_CHARACTER_SET;
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET;
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET;
    private static final int[] STYLE_COLORS;
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private static final String TAG = "Cea608Decoder";
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData;
    private final ArrayList cueBuilders;
    private List cues;
    private int currentChannel;
    private Cea608Decoder$CueBuilder currentCueBuilder;
    private boolean isCaptionValid;
    private boolean isInCaptionService;
    private long lastCueUpdateUs;
    private List lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedChannel;
    private final int selectedField;
    private final long validDataChannelTimeoutUs;

    static {
        Object[] objectArray;
        int[] nArray;
        int n10 = 8;
        int[] nArray2 = nArray = new int[n10];
        int[] nArray3 = nArray;
        nArray2[0] = 11;
        nArray3[1] = 1;
        nArray2[2] = 3;
        nArray3[3] = 12;
        nArray2[4] = 14;
        nArray3[5] = 5;
        nArray2[6] = 7;
        nArray3[7] = 9;
        ROW_INDICES = nArray;
        int[] nArray4 = objectArray = new int[n10];
        int[] nArray5 = objectArray;
        nArray4[0] = 0;
        nArray5[1] = 4;
        nArray4[2] = 8;
        nArray5[3] = 12;
        nArray4[4] = 16;
        nArray5[5] = 20;
        nArray4[6] = 24;
        nArray5[7] = 28;
        COLUMN_INDICES = objectArray;
        int[] nArray6 = objectArray = new int[7];
        int[] nArray7 = objectArray;
        nArray6[0] = -1;
        nArray7[1] = -16711936;
        nArray6[2] = -16776961;
        nArray7[3] = -16711681;
        nArray6[4] = -65536;
        nArray7[5] = -256;
        nArray7[6] = -65281;
        STYLE_COLORS = objectArray;
        int[] nArray8 = objectArray = new int[96];
        int[] nArray9 = objectArray;
        nArray8[0] = 32;
        nArray9[1] = 33;
        nArray8[2] = 34;
        nArray9[3] = 35;
        nArray8[4] = 36;
        nArray9[5] = 37;
        nArray8[6] = 38;
        nArray9[7] = 39;
        nArray8[8] = 40;
        nArray9[9] = 41;
        nArray8[10] = 225;
        nArray9[11] = 43;
        nArray8[12] = 44;
        nArray9[13] = 45;
        nArray8[14] = 46;
        nArray9[15] = 47;
        nArray8[16] = 48;
        nArray9[17] = 49;
        nArray8[18] = 50;
        nArray9[19] = 51;
        nArray8[20] = 52;
        nArray9[21] = 53;
        nArray8[22] = 54;
        nArray9[23] = 55;
        nArray8[24] = 56;
        nArray9[25] = 57;
        nArray8[26] = 58;
        nArray9[27] = 59;
        nArray8[28] = 60;
        nArray9[29] = 61;
        nArray8[30] = 62;
        nArray9[31] = 63;
        nArray8[32] = 64;
        nArray9[33] = 65;
        nArray8[34] = 66;
        nArray9[35] = 67;
        nArray8[36] = 68;
        nArray9[37] = 69;
        nArray8[38] = 70;
        nArray9[39] = 71;
        nArray8[40] = 72;
        nArray9[41] = 73;
        nArray8[42] = 74;
        nArray9[43] = 75;
        nArray8[44] = 76;
        nArray9[45] = 77;
        nArray8[46] = 78;
        nArray9[47] = 79;
        nArray8[48] = 80;
        nArray9[49] = 81;
        nArray8[50] = 82;
        nArray9[51] = 83;
        nArray8[52] = 84;
        nArray9[53] = 85;
        nArray8[54] = 86;
        nArray9[55] = 87;
        nArray8[56] = 88;
        nArray9[57] = 89;
        nArray8[58] = 90;
        nArray9[59] = 91;
        nArray8[60] = 233;
        nArray9[61] = 93;
        nArray8[62] = 237;
        nArray9[63] = 243;
        nArray8[64] = 250;
        nArray9[65] = 97;
        nArray8[66] = 98;
        nArray9[67] = 99;
        nArray8[68] = 100;
        nArray9[69] = 101;
        nArray8[70] = 102;
        nArray9[71] = 103;
        nArray8[72] = 104;
        nArray9[73] = 105;
        nArray8[74] = 106;
        nArray9[75] = 107;
        nArray8[76] = 108;
        nArray9[77] = 109;
        nArray8[78] = 110;
        nArray9[79] = 111;
        nArray8[80] = 112;
        nArray9[81] = 113;
        nArray8[82] = 114;
        nArray9[83] = 115;
        nArray8[84] = 116;
        nArray9[85] = 117;
        nArray8[86] = 118;
        nArray9[87] = 119;
        nArray8[88] = 120;
        nArray9[89] = 121;
        nArray8[90] = 122;
        nArray9[91] = 231;
        nArray8[92] = 247;
        nArray9[93] = 209;
        nArray8[94] = 241;
        nArray9[95] = 9632;
        BASIC_CHARACTER_SET = objectArray;
        int[] nArray10 = objectArray = new int[16];
        int[] nArray11 = objectArray;
        nArray10[0] = 174;
        nArray11[1] = 176;
        nArray10[2] = 189;
        nArray11[3] = 191;
        nArray10[4] = 8482;
        nArray11[5] = 162;
        nArray10[6] = 163;
        nArray11[7] = 9834;
        nArray10[8] = 224;
        nArray11[9] = 32;
        nArray10[10] = 232;
        nArray11[11] = 226;
        nArray10[12] = 234;
        nArray11[13] = 238;
        nArray10[14] = 244;
        nArray11[15] = 251;
        SPECIAL_CHARACTER_SET = objectArray;
        n10 = 32;
        int[] nArray12 = nArray = new int[n10];
        int[] nArray13 = nArray;
        nArray12[0] = 193;
        nArray13[1] = 201;
        nArray12[2] = 211;
        nArray13[3] = 218;
        nArray12[4] = 220;
        nArray13[5] = 252;
        nArray12[6] = 8216;
        nArray13[7] = 161;
        nArray12[8] = 42;
        nArray13[9] = 39;
        nArray12[10] = 8212;
        nArray13[11] = 169;
        nArray12[12] = 8480;
        nArray13[13] = 8226;
        nArray12[14] = 8220;
        nArray13[15] = 8221;
        nArray12[16] = 192;
        nArray13[17] = 194;
        nArray12[18] = 199;
        nArray13[19] = 200;
        nArray12[20] = 202;
        nArray13[21] = 203;
        nArray12[22] = 235;
        nArray13[23] = 206;
        nArray12[24] = 207;
        nArray13[25] = 239;
        nArray12[26] = 212;
        nArray13[27] = 217;
        nArray12[28] = 249;
        nArray13[29] = 219;
        nArray12[30] = 171;
        nArray13[31] = 187;
        SPECIAL_ES_FR_CHARACTER_SET = nArray;
        int[] nArray14 = objectArray = new int[n10];
        int[] nArray15 = objectArray;
        nArray14[0] = 195;
        nArray15[1] = 227;
        nArray14[2] = 205;
        nArray15[3] = 204;
        nArray14[4] = 236;
        nArray15[5] = 210;
        nArray14[6] = 242;
        nArray15[7] = 213;
        nArray14[8] = 245;
        nArray15[9] = 123;
        nArray14[10] = 125;
        nArray15[11] = 92;
        nArray14[12] = 94;
        nArray15[13] = 95;
        nArray14[14] = 124;
        nArray15[15] = 126;
        nArray14[16] = 196;
        nArray15[17] = 228;
        nArray14[18] = 214;
        nArray15[19] = 246;
        nArray14[20] = 223;
        nArray15[21] = 165;
        nArray14[22] = 164;
        nArray15[23] = 9474;
        nArray14[24] = 197;
        nArray15[25] = 229;
        nArray14[26] = 216;
        nArray15[27] = 248;
        nArray14[28] = 9484;
        nArray15[29] = 9488;
        nArray14[30] = 9492;
        nArray15[31] = 9496;
        SPECIAL_PT_DE_CHARACTER_SET = objectArray;
        Object[] objectArray2 = objectArray = (Object[])new boolean[256];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = 0;
        objectArray3[1] = 1;
        objectArray2[2] = 1;
        objectArray3[3] = 0;
        objectArray2[4] = 1;
        objectArray3[5] = 0;
        objectArray2[6] = 0;
        objectArray3[7] = 1;
        objectArray2[8] = 1;
        objectArray3[9] = 0;
        objectArray2[10] = 0;
        objectArray3[11] = 1;
        objectArray2[12] = 0;
        objectArray3[13] = 1;
        objectArray2[14] = 1;
        objectArray3[15] = 0;
        objectArray2[16] = 1;
        objectArray3[17] = 0;
        objectArray2[18] = 0;
        objectArray3[19] = 1;
        objectArray2[20] = 0;
        objectArray3[21] = 1;
        objectArray2[22] = 1;
        objectArray3[23] = 0;
        objectArray2[24] = 0;
        objectArray3[25] = 1;
        objectArray2[26] = 1;
        objectArray3[27] = 0;
        objectArray2[28] = 1;
        objectArray3[29] = 0;
        objectArray2[30] = 0;
        objectArray3[31] = 1;
        objectArray2[32] = 1;
        objectArray3[33] = 0;
        objectArray2[34] = 0;
        objectArray3[35] = 1;
        objectArray2[36] = 0;
        objectArray3[37] = 1;
        objectArray2[38] = 1;
        objectArray3[39] = 0;
        objectArray2[40] = 0;
        objectArray3[41] = 1;
        objectArray2[42] = 1;
        objectArray3[43] = 0;
        objectArray2[44] = 1;
        objectArray3[45] = 0;
        objectArray2[46] = 0;
        objectArray3[47] = 1;
        objectArray2[48] = 0;
        objectArray3[49] = 1;
        objectArray2[50] = 1;
        objectArray3[51] = 0;
        objectArray2[52] = 1;
        objectArray3[53] = 0;
        objectArray2[54] = 0;
        objectArray3[55] = 1;
        objectArray2[56] = 1;
        objectArray3[57] = 0;
        objectArray2[58] = 0;
        objectArray3[59] = 1;
        objectArray2[60] = 0;
        objectArray3[61] = 1;
        objectArray2[62] = 1;
        objectArray3[63] = 0;
        objectArray2[64] = 1;
        objectArray3[65] = 0;
        objectArray2[66] = 0;
        objectArray3[67] = 1;
        objectArray2[68] = 0;
        objectArray3[69] = 1;
        objectArray2[70] = 1;
        objectArray3[71] = 0;
        objectArray2[72] = 0;
        objectArray3[73] = 1;
        objectArray2[74] = 1;
        objectArray3[75] = 0;
        objectArray2[76] = 1;
        objectArray3[77] = 0;
        objectArray2[78] = 0;
        objectArray3[79] = 1;
        objectArray2[80] = 0;
        objectArray3[81] = 1;
        objectArray2[82] = 1;
        objectArray3[83] = 0;
        objectArray2[84] = 1;
        objectArray3[85] = 0;
        objectArray2[86] = 0;
        objectArray3[87] = 1;
        objectArray2[88] = 1;
        objectArray3[89] = 0;
        objectArray2[90] = 0;
        objectArray3[91] = 1;
        objectArray2[92] = 0;
        objectArray3[93] = 1;
        objectArray2[94] = 1;
        objectArray3[95] = 0;
        objectArray2[96] = 0;
        objectArray3[97] = 1;
        objectArray2[98] = 1;
        objectArray3[99] = 0;
        objectArray2[100] = 1;
        objectArray3[101] = 0;
        objectArray2[102] = 0;
        objectArray3[103] = 1;
        objectArray2[104] = 1;
        objectArray3[105] = 0;
        objectArray2[106] = 0;
        objectArray3[107] = 1;
        objectArray2[108] = 0;
        objectArray3[109] = 1;
        objectArray2[110] = 1;
        objectArray3[111] = 0;
        objectArray2[112] = 1;
        objectArray3[113] = 0;
        objectArray2[114] = 0;
        objectArray3[115] = 1;
        objectArray2[116] = 0;
        objectArray3[117] = 1;
        objectArray2[118] = 1;
        objectArray3[119] = 0;
        objectArray2[120] = 0;
        objectArray3[121] = 1;
        objectArray2[122] = 1;
        objectArray3[123] = 0;
        objectArray2[124] = 1;
        objectArray3[125] = 0;
        objectArray2[126] = 0;
        objectArray3[127] = 1;
        objectArray2[128] = 1;
        objectArray3[129] = 0;
        objectArray2[130] = 0;
        objectArray3[131] = 1;
        objectArray2[132] = 0;
        objectArray3[133] = 1;
        objectArray2[134] = 1;
        objectArray3[135] = 0;
        objectArray2[136] = 0;
        objectArray3[137] = 1;
        objectArray2[138] = 1;
        objectArray3[139] = 0;
        objectArray2[140] = 1;
        objectArray3[141] = 0;
        objectArray2[142] = 0;
        objectArray3[143] = 1;
        objectArray2[144] = 0;
        objectArray3[145] = 1;
        objectArray2[146] = 1;
        objectArray3[147] = 0;
        objectArray2[148] = 1;
        objectArray3[149] = 0;
        objectArray2[150] = 0;
        objectArray3[151] = 1;
        objectArray2[152] = 1;
        objectArray3[153] = 0;
        objectArray2[154] = 0;
        objectArray3[155] = 1;
        objectArray2[156] = 0;
        objectArray3[157] = 1;
        objectArray2[158] = 1;
        objectArray3[159] = 0;
        objectArray2[160] = 0;
        objectArray3[161] = 1;
        objectArray2[162] = 1;
        objectArray3[163] = 0;
        objectArray2[164] = 1;
        objectArray3[165] = 0;
        objectArray2[166] = 0;
        objectArray3[167] = 1;
        objectArray2[168] = 1;
        objectArray3[169] = 0;
        objectArray2[170] = 0;
        objectArray3[171] = 1;
        objectArray2[172] = 0;
        objectArray3[173] = 1;
        objectArray2[174] = 1;
        objectArray3[175] = 0;
        objectArray2[176] = 1;
        objectArray3[177] = 0;
        objectArray2[178] = 0;
        objectArray3[179] = 1;
        objectArray2[180] = 0;
        objectArray3[181] = 1;
        objectArray2[182] = 1;
        objectArray3[183] = 0;
        objectArray2[184] = 0;
        objectArray3[185] = 1;
        objectArray2[186] = 1;
        objectArray3[187] = 0;
        objectArray2[188] = 1;
        objectArray3[189] = 0;
        objectArray2[190] = 0;
        objectArray3[191] = 1;
        objectArray2[192] = 0;
        objectArray3[193] = 1;
        objectArray2[194] = 1;
        objectArray3[195] = 0;
        objectArray2[196] = 1;
        objectArray3[197] = 0;
        objectArray2[198] = 0;
        objectArray3[199] = 1;
        objectArray2[200] = 1;
        objectArray3[201] = 0;
        objectArray2[202] = 0;
        objectArray3[203] = 1;
        objectArray2[204] = 0;
        objectArray3[205] = 1;
        objectArray2[206] = 1;
        objectArray3[207] = 0;
        objectArray2[208] = 1;
        objectArray3[209] = 0;
        objectArray2[210] = 0;
        objectArray3[211] = 1;
        objectArray2[212] = 0;
        objectArray3[213] = 1;
        objectArray2[214] = 1;
        objectArray3[215] = 0;
        objectArray2[216] = 0;
        objectArray3[217] = 1;
        objectArray2[218] = 1;
        objectArray3[219] = 0;
        objectArray2[220] = 1;
        objectArray3[221] = 0;
        objectArray2[222] = 0;
        objectArray3[223] = 1;
        objectArray2[224] = 1;
        objectArray3[225] = 0;
        objectArray2[226] = 0;
        objectArray3[227] = 1;
        objectArray2[228] = 0;
        objectArray3[229] = 1;
        objectArray2[230] = 1;
        objectArray3[231] = 0;
        objectArray2[232] = 0;
        objectArray3[233] = 1;
        objectArray2[234] = 1;
        objectArray3[235] = 0;
        objectArray2[236] = 1;
        objectArray3[237] = 0;
        objectArray2[238] = 0;
        objectArray3[239] = 1;
        objectArray2[240] = 0;
        objectArray3[241] = 1;
        objectArray2[242] = 1;
        objectArray3[243] = 0;
        objectArray2[244] = 1;
        objectArray3[245] = 0;
        objectArray2[246] = 0;
        objectArray3[247] = 1;
        objectArray2[248] = 1;
        objectArray3[249] = 0;
        objectArray2[250] = 0;
        objectArray3[251] = 1;
        objectArray2[252] = 0;
        objectArray3[253] = 1;
        objectArray2[254] = 1;
        objectArray3[255] = 0;
        ODD_PARITY_BYTE_TABLE = (boolean[])objectArray;
    }

    public Cea608Decoder(String string2, int n10, long l10) {
        Object object = new ParsableByteArray();
        this.ccData = object;
        object = new ArrayList();
        this.cueBuilders = object;
        int n11 = 4;
        this.currentCueBuilder = object = new Cea608Decoder$CueBuilder(0, n11);
        this.currentChannel = 0;
        long l11 = l10 - 0L;
        long l12 = l11 == 0L ? 0 : (l11 < 0L ? -1 : 1);
        long l13 = -9223372036854775807L;
        if (l12 > 0) {
            long l14 = 1000L;
            l10 *= l14;
        } else {
            l10 = l13;
        }
        this.validDataChannelTimeoutUs = l10;
        String string3 = "application/x-mp4-cea-608";
        int n12 = string3.equals(string2);
        int n13 = 2;
        int n14 = 3;
        n12 = n12 != 0 ? n13 : n14;
        this.packetLength = n12;
        n12 = 1;
        if (n10 != n12) {
            if (n10 != n13) {
                if (n10 != n14) {
                    if (n10 != n11) {
                        String string4 = TAG;
                        string3 = "Invalid channel. Defaulting to CC1.";
                        Log.w(string4, string3);
                        this.selectedChannel = 0;
                        this.selectedField = 0;
                    } else {
                        this.selectedChannel = n12;
                        this.selectedField = n12;
                    }
                } else {
                    this.selectedChannel = 0;
                    this.selectedField = n12;
                }
            } else {
                this.selectedChannel = n12;
                this.selectedField = 0;
            }
        } else {
            this.selectedChannel = 0;
            this.selectedField = 0;
        }
        this.setCaptionMode(0);
        this.resetCueBuilders();
        this.isInCaptionService = n12;
        this.lastCueUpdateUs = l13;
    }

    public static /* synthetic */ int[] access$300() {
        return STYLE_COLORS;
    }

    private static char getBasicChar(byte by2) {
        by2 = (byte)((by2 & 0x7F) + -32);
        return (char)BASIC_CHARACTER_SET[by2];
    }

    private static int getChannel(byte by2) {
        return by2 >> 3 & 1;
    }

    private List getDisplayCues() {
        int n10;
        Object object;
        ArrayList arrayList = this.cueBuilders;
        int n11 = arrayList.size();
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n11);
        int n12 = 0;
        int n13 = 2;
        ArrayList<Object> arrayList3 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            object = (Cea608Decoder$CueBuilder)this.cueBuilders.get(i10);
            n10 = -1 << -1;
            object = ((Cea608Decoder$CueBuilder)object).build(n10);
            arrayList2.add(object);
            if (object == null) continue;
            int n14 = ((Cue)object).positionAnchor;
            n13 = Math.min(n13, n14);
        }
        arrayList3 = new ArrayList<Object>(n11);
        while (n12 < n11) {
            object = (Cue)arrayList2.get(n12);
            if (object != null) {
                n10 = ((Cue)object).positionAnchor;
                if (n10 != n13) {
                    object = (Cue)Assertions.checkNotNull(((Cea608Decoder$CueBuilder)this.cueBuilders.get(n12)).build(n13));
                }
                arrayList3.add(object);
            }
            ++n12;
        }
        return arrayList3;
    }

    private static char getExtendedEsFrChar(byte by2) {
        by2 = (byte)(by2 & 0x1F);
        return (char)SPECIAL_ES_FR_CHARACTER_SET[by2];
    }

    private static char getExtendedPtDeChar(byte by2) {
        by2 = (byte)(by2 & 0x1F);
        return (char)SPECIAL_PT_DE_CHARACTER_SET[by2];
    }

    private static char getExtendedWestEuropeanChar(byte by2, byte by3) {
        if ((by2 = (byte)(by2 & 1)) == 0) {
            return Cea608Decoder.getExtendedEsFrChar(by3);
        }
        return Cea608Decoder.getExtendedPtDeChar(by3);
    }

    private static char getSpecialNorthAmericanChar(byte by2) {
        by2 = (byte)(by2 & 0xF);
        return (char)SPECIAL_CHARACTER_SET[by2];
    }

    private void handleMidrowCtrl(byte by2) {
        Cea608Decoder$CueBuilder cea608Decoder$CueBuilder = this.currentCueBuilder;
        cea608Decoder$CueBuilder.append(' ');
        int n10 = by2 & 1;
        int n11 = 1;
        if (n10 == n11) {
            n10 = n11;
        } else {
            n10 = 0;
            cea608Decoder$CueBuilder = null;
        }
        by2 = (byte)(by2 >> n11 & 7);
        this.currentCueBuilder.setStyle(by2, n10 != 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void handleMiscCode(byte n10) {
        int n11 = 32;
        int n12 = 2;
        if (n10 != n11) {
            n11 = 41;
            int n13 = 3;
            if (n10 != n11) {
                n11 = 1;
                switch (n10) {
                    default: {
                        n12 = this.captionMode;
                        if (n12 == 0) {
                            return;
                        }
                        int n14 = 33;
                        if (n10 != n14) {
                            switch (n10) {
                                default: {
                                    return;
                                }
                                case 47: {
                                    List list;
                                    this.cues = list = this.getDisplayCues();
                                    this.resetCueBuilders();
                                    return;
                                }
                                case 46: {
                                    this.resetCueBuilders();
                                    return;
                                }
                                case 45: {
                                    Cea608Decoder$CueBuilder cea608Decoder$CueBuilder;
                                    if (n12 != n11 || (n10 = (int)((cea608Decoder$CueBuilder = this.currentCueBuilder).isEmpty() ? 1 : 0)) != 0) return;
                                    cea608Decoder$CueBuilder = this.currentCueBuilder;
                                    cea608Decoder$CueBuilder.rollUp();
                                    return;
                                }
                                case 44: {
                                    List list;
                                    this.cues = list = Collections.emptyList();
                                    n10 = this.captionMode;
                                    if (n10 != n11 && n10 != n13) return;
                                    this.resetCueBuilders();
                                    return;
                                }
                            }
                        } else {
                            Cea608Decoder$CueBuilder cea608Decoder$CueBuilder = this.currentCueBuilder;
                            cea608Decoder$CueBuilder.backspace();
                        }
                        return;
                    }
                    case 39: {
                        this.setCaptionMode(n11);
                        this.setCaptionRowCount(4);
                        return;
                    }
                    case 38: {
                        this.setCaptionMode(n11);
                        this.setCaptionRowCount(n13);
                        return;
                    }
                    case 37: 
                }
                this.setCaptionMode(n11);
                this.setCaptionRowCount(n12);
                return;
            }
            this.setCaptionMode(n13);
            return;
        }
        this.setCaptionMode(n12);
    }

    private void handlePreambleAddressCode(byte by2, byte by3) {
        Cea608Decoder$CueBuilder cea608Decoder$CueBuilder;
        Object object = ROW_INDICES;
        by2 = (byte)(by2 & 7);
        by2 = (byte)object[by2];
        int n10 = by3 & 0x20;
        int n11 = 0;
        int n12 = 1;
        if (n10 != 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            by2 = (byte)(by2 + 1);
        }
        if (by2 != (n10 = Cea608Decoder$CueBuilder.access$100((Cea608Decoder$CueBuilder)(object = (Object)this.currentCueBuilder)))) {
            n10 = this.captionMode;
            if (n10 != n12 && (n10 = (int)((object = (Object)this.currentCueBuilder).isEmpty() ? 1 : 0)) == 0) {
                int n13 = this.captionMode;
                int n14 = this.captionRowCount;
                object = new Cea608Decoder$CueBuilder(n13, n14);
                this.currentCueBuilder = object;
                ArrayList arrayList = this.cueBuilders;
                arrayList.add(object);
            }
            object = this.currentCueBuilder;
            Cea608Decoder$CueBuilder.access$102((Cea608Decoder$CueBuilder)object, by2);
        }
        if ((by2 = (byte)(by3 & 0x10)) == (n10 = 16)) {
            by2 = (byte)n12;
        } else {
            by2 = 0;
            cea608Decoder$CueBuilder = null;
        }
        n10 = by3 & 1;
        if (n10 == n12) {
            n11 = n12;
        }
        by3 = (byte)(by3 >> n12 & 7);
        object = this.currentCueBuilder;
        n12 = by2 != 0 ? 8 : (int)by3;
        object.setStyle(n12, n11 != 0);
        if (by2 != 0) {
            cea608Decoder$CueBuilder = this.currentCueBuilder;
            object = COLUMN_INDICES;
            by3 = (byte)object[by3];
            Cea608Decoder$CueBuilder.access$202(cea608Decoder$CueBuilder, by3);
        }
    }

    private static boolean isCtrlCode(byte by2) {
        by2 = (by2 = (byte)(by2 & 0xE0)) == 0 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isExtendedWestEuropeanChar(byte by2, byte by3) {
        byte by4 = 18;
        by2 = (by2 = (byte)(by2 & 0xF6)) == by4 && (by2 = (byte)(by3 & 0xE0)) == (by3 = (byte)32) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isMidrowCtrlCode(byte by2, byte by3) {
        byte by4 = 17;
        by2 = (by2 = (byte)(by2 & 0xF7)) == by4 && (by2 = (byte)(by3 & 0xF0)) == (by3 = (byte)32) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isMiscCode(byte by2, byte by3) {
        byte by4 = 20;
        by2 = (by2 = (byte)(by2 & 0xF6)) == by4 && (by2 = (byte)(by3 & 0xF0)) == (by3 = (byte)32) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isPreambleAddressCode(byte by2, byte by3) {
        byte by4 = 16;
        by2 = (by2 = (byte)(by2 & 0xF0)) == by4 && (by2 = (byte)(by3 & 0xC0)) == (by3 = (byte)64) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isRepeatable(byte by2) {
        byte by3 = 16;
        by2 = (by2 = (byte)(by2 & 0xF0)) == by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    private boolean isRepeatedCommand(boolean by2, byte by3, byte by4) {
        if (by2 != 0 && (by2 = Cea608Decoder.isRepeatable(by3)) != 0) {
            by2 = this.repeatableControlSet;
            boolean bl2 = true;
            if (by2 != 0 && (by2 = this.repeatableControlCc1) == by3 && (by2 = this.repeatableControlCc2) == by4) {
                this.repeatableControlSet = false;
                return bl2;
            }
            this.repeatableControlSet = bl2;
            this.repeatableControlCc1 = by3;
            this.repeatableControlCc2 = by4;
        } else {
            this.repeatableControlSet = false;
        }
        return false;
    }

    private static boolean isServiceSwitchCommand(byte by2) {
        byte by3 = 20;
        by2 = (by2 = (byte)(by2 & 0xF7)) == by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isSpecialNorthAmericanChar(byte by2, byte by3) {
        byte by4 = 17;
        by2 = (by2 = (byte)(by2 & 0xF7)) == by4 && (by2 = (byte)(by3 & 0xF0)) == (by3 = (byte)48) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isTabCtrlCode(byte by2, byte by3) {
        byte by4 = 23;
        by2 = (by2 = (byte)(by2 & 0xF7)) == by4 && by3 >= (by2 = (byte)33) && by3 <= (by2 = (byte)35) ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isXdsControlCode(byte by2) {
        byte by3;
        byte by4 = 1;
        if (by4 > by2 || by2 > (by3 = 15)) {
            by4 = 0;
        }
        return by4 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void maybeUpdateIsInCaptionService(byte by2, byte by3) {
        boolean bl2 = Cea608Decoder.isXdsControlCode(by2);
        if (bl2) {
            this.isInCaptionService = false;
            return;
        }
        if ((by2 = (byte)(Cea608Decoder.isServiceSwitchCommand(by2) ? 1 : 0)) == 0) return;
        by2 = (byte)32;
        if (by3 != by2 && by3 != (by2 = (byte)47)) {
            switch (by3) {
                default: {
                    switch (by3) {
                        default: {
                            return;
                        }
                        case 42: 
                        case 43: {
                            this.isInCaptionService = false;
                            return;
                        }
                        case 41: 
                    }
                }
                case 37: 
                case 38: 
                case 39: 
            }
        }
        by2 = 1;
        this.isInCaptionService = by2;
    }

    private void resetCueBuilders() {
        Object object = this.currentCueBuilder;
        int n10 = this.captionMode;
        ((Cea608Decoder$CueBuilder)object).reset(n10);
        this.cueBuilders.clear();
        object = this.cueBuilders;
        Cea608Decoder$CueBuilder cea608Decoder$CueBuilder = this.currentCueBuilder;
        ((ArrayList)object).add(cea608Decoder$CueBuilder);
    }

    private void setCaptionMode(int n10) {
        int n11 = this.captionMode;
        if (n11 == n10) {
            return;
        }
        this.captionMode = n10;
        int n12 = 3;
        if (n10 == n12) {
            Object object;
            for (n11 = 0; n11 < (n12 = ((ArrayList)(object = this.cueBuilders)).size()); ++n11) {
                object = (Cea608Decoder$CueBuilder)this.cueBuilders.get(n11);
                ((Cea608Decoder$CueBuilder)object).setCaptionMode(n10);
            }
            return;
        }
        this.resetCueBuilders();
        if (n11 == n12 || n10 == (n11 = 1) || n10 == 0) {
            List list;
            this.cues = list = Collections.emptyList();
        }
    }

    private void setCaptionRowCount(int n10) {
        this.captionRowCount = n10;
        this.currentCueBuilder.setCaptionRowCount(n10);
    }

    private boolean shouldClearStuckCaptions() {
        long l10;
        long l11;
        long l12 = this.validDataChannelTimeoutUs;
        long l13 = -9223372036854775807L;
        Object object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        boolean bl2 = false;
        if (object != false && (object = (l11 = (l10 = this.lastCueUpdateUs) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l13 = this.getPositionUs();
            l10 = this.lastCueUpdateUs;
            long l14 = (l13 -= l10) - (l10 = this.validDataChannelTimeoutUs);
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object >= 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private boolean updateAndVerifyCurrentChannel(byte by2) {
        int n10 = Cea608Decoder.isCtrlCode(by2);
        if (n10 != 0) {
            by2 = (byte)Cea608Decoder.getChannel(by2);
            this.currentChannel = by2;
        }
        by2 = (by2 = (byte)this.currentChannel) == (n10 = this.selectedChannel) ? (byte)1 : 0;
        return by2 != 0;
    }

    public Subtitle createSubtitle() {
        List list;
        this.lastCues = list = this.cues;
        list = (List)Assertions.checkNotNull(list);
        CeaSubtitle ceaSubtitle = new CeaSubtitle(list);
        return ceaSubtitle;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void decode(SubtitleInputBuffer object) {
        Object object2;
        Object object3;
        int n10;
        object = (ByteBuffer)Assertions.checkNotNull(((DecoderInputBuffer)object).data);
        ParsableByteArray parsableByteArray = this.ccData;
        Object object4 = ((ByteBuffer)object).array();
        int n11 = ((Buffer)object).limit();
        parsableByteArray.reset((byte[])object4, n11);
        n11 = 0;
        object = null;
        int n12 = 1;
        int n13 = 0;
        object4 = null;
        while ((n10 = ((ParsableByteArray)(object3 = this.ccData)).bytesLeft()) >= (object2 = this.packetLength)) {
            block11: {
                byte by2;
                int n14;
                block12: {
                    block16: {
                        block15: {
                            block14: {
                                block13: {
                                    block10: {
                                        n10 = 2;
                                        if (object2 == n10) {
                                            n10 = -4;
                                        } else {
                                            object3 = this.ccData;
                                            n10 = (byte)((ParsableByteArray)object3).readUnsignedByte();
                                        }
                                        ParsableByteArray parsableByteArray2 = this.ccData;
                                        object2 = parsableByteArray2.readUnsignedByte();
                                        ParsableByteArray parsableByteArray3 = this.ccData;
                                        int n15 = parsableByteArray3.readUnsignedByte();
                                        n14 = n10 & 2;
                                        if (n14 != 0 || (n14 = n10 & 1) != (by2 = this.selectedField)) continue;
                                        n14 = (byte)(object2 & 0x7F);
                                        by2 = (byte)(n15 & 0x7F);
                                        if (n14 == 0 && by2 == 0) continue;
                                        boolean bl2 = this.isCaptionValid;
                                        int n16 = 4;
                                        if ((n10 &= 4) == n16 && (object2 = (Object)(object3 = (Object)ODD_PARITY_BYTE_TABLE)[object2]) != 0 && (n10 = (int)object3[n15]) != 0) {
                                            n10 = n12;
                                        } else {
                                            n10 = 0;
                                            object3 = null;
                                        }
                                        this.isCaptionValid = n10;
                                        if ((n10 = this.isRepeatedCommand(n10 != 0, (byte)n14, by2)) != 0) continue;
                                        n10 = (int)(this.isCaptionValid ? 1 : 0);
                                        if (n10 != 0) break block10;
                                        if (!bl2) continue;
                                        this.resetCueBuilders();
                                        break block11;
                                    }
                                    this.maybeUpdateIsInCaptionService((byte)n14, by2);
                                    n10 = (int)(this.isInCaptionService ? 1 : 0);
                                    if (n10 == 0 || (n10 = (int)(this.updateAndVerifyCurrentChannel((byte)n14) ? 1 : 0)) == 0) continue;
                                    n13 = (int)(Cea608Decoder.isCtrlCode((byte)n14) ? 1 : 0);
                                    if (n13 == 0) break block12;
                                    n13 = (int)(Cea608Decoder.isSpecialNorthAmericanChar((byte)n14, by2) ? 1 : 0);
                                    if (n13 == 0) break block13;
                                    object4 = this.currentCueBuilder;
                                    n10 = Cea608Decoder.getSpecialNorthAmericanChar(by2);
                                    ((Cea608Decoder$CueBuilder)object4).append((char)n10);
                                    break block11;
                                }
                                n13 = (int)(Cea608Decoder.isExtendedWestEuropeanChar((byte)n14, by2) ? 1 : 0);
                                if (n13 == 0) break block14;
                                this.currentCueBuilder.backspace();
                                object4 = this.currentCueBuilder;
                                n10 = Cea608Decoder.getExtendedWestEuropeanChar((byte)n14, by2);
                                ((Cea608Decoder$CueBuilder)object4).append((char)n10);
                                break block11;
                            }
                            n13 = (int)(Cea608Decoder.isMidrowCtrlCode((byte)n14, by2) ? 1 : 0);
                            if (n13 == 0) break block15;
                            this.handleMidrowCtrl(by2);
                            break block11;
                        }
                        n13 = (int)(Cea608Decoder.isPreambleAddressCode((byte)n14, by2) ? 1 : 0);
                        if (n13 == 0) break block16;
                        this.handlePreambleAddressCode((byte)n14, by2);
                        break block11;
                    }
                    n13 = (int)(Cea608Decoder.isTabCtrlCode((byte)n14, by2) ? 1 : 0);
                    if (n13 != 0) {
                        object4 = this.currentCueBuilder;
                        Cea608Decoder$CueBuilder.access$002((Cea608Decoder$CueBuilder)object4, by2 += -32);
                        break block11;
                    } else {
                        n13 = (int)(Cea608Decoder.isMiscCode((byte)n14, by2) ? 1 : 0);
                        if (n13 != 0) {
                            this.handleMiscCode(by2);
                        }
                    }
                    break block11;
                }
                object4 = this.currentCueBuilder;
                n10 = Cea608Decoder.getBasicChar((byte)n14);
                ((Cea608Decoder$CueBuilder)object4).append((char)n10);
                n13 = by2 & 0xE0;
                if (n13 != 0) {
                    object4 = this.currentCueBuilder;
                    n10 = Cea608Decoder.getBasicChar(by2);
                    ((Cea608Decoder$CueBuilder)object4).append((char)n10);
                }
            }
            n13 = n12;
        }
        if (n13 != 0 && ((n11 = this.captionMode) == n12 || n11 == (n12 = 3))) {
            long l10;
            this.cues = object = this.getDisplayCues();
            this.lastCueUpdateUs = l10 = this.getPositionUs();
        }
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() {
        SubtitleOutputBuffer subtitleOutputBuffer = super.dequeueOutputBuffer();
        if (subtitleOutputBuffer != null) {
            return subtitleOutputBuffer;
        }
        boolean bl2 = this.shouldClearStuckCaptions();
        if (bl2 && (subtitleOutputBuffer = this.getAvailableOutputBuffer()) != null) {
            Object object = Collections.emptyList();
            this.cues = object;
            this.lastCueUpdateUs = -9223372036854775807L;
            Subtitle subtitle = this.createSubtitle();
            long l10 = this.getPositionUs();
            object = subtitleOutputBuffer;
            subtitleOutputBuffer.setContent(l10, subtitle, Long.MAX_VALUE);
            return subtitleOutputBuffer;
        }
        return null;
    }

    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.setCaptionMode(0);
        this.setCaptionRowCount(4);
        this.resetCueBuilders();
        this.isCaptionValid = false;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
        this.currentChannel = 0;
        this.isInCaptionService = true;
        this.lastCueUpdateUs = -9223372036854775807L;
    }

    public String getName() {
        return TAG;
    }

    public boolean isNewSubtitleDataAvailable() {
        boolean bl2;
        List list = this.cues;
        List list2 = this.lastCues;
        if (list != list2) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }

    public void release() {
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo;
import com.google.android.exoplayer2.text.cea.Cea708Decoder$CueInfoBuilder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder$DtvCcPacket;
import com.google.android.exoplayer2.text.cea.CeaDecoder;
import com.google.android.exoplayer2.text.cea.CeaSubtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d.h.a.a.n0.b.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea708Decoder
extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final ParsableByteArray ccData;
    private final Cea708Decoder$CueInfoBuilder[] cueInfoBuilders;
    private List cues;
    private Cea708Decoder$CueInfoBuilder currentCueInfoBuilder;
    private Cea708Decoder$DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private final boolean isWideAspectRatio;
    private List lastCues;
    private int previousSequenceNumber;
    private final int selectedServiceNumber;
    private final ParsableBitArray serviceBlockPacket;

    public Cea708Decoder(int n10, List list) {
        Cea708Decoder$CueInfoBuilder[] cea708Decoder$CueInfoBuilderArray;
        int n11;
        int n12;
        Cea708Decoder$CueInfoBuilder[] cea708Decoder$CueInfoBuilderArray2 = new ParsableByteArray();
        this.ccData = cea708Decoder$CueInfoBuilderArray2;
        cea708Decoder$CueInfoBuilderArray2 = new ParsableBitArray();
        this.serviceBlockPacket = cea708Decoder$CueInfoBuilderArray2;
        this.previousSequenceNumber = n12 = -1;
        int n13 = 1;
        if (n10 == n12) {
            n10 = n13;
        }
        this.selectedServiceNumber = n10;
        n10 = 0;
        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = null;
        if (list == null || (n11 = CodecSpecificDataUtil.parseCea708InitializationData(list)) == 0) {
            n13 = 0;
            cea708Decoder$CueInfoBuilderArray = null;
        }
        this.isWideAspectRatio = n13;
        n11 = 8;
        cea708Decoder$CueInfoBuilderArray2 = new Cea708Decoder$CueInfoBuilder[n11];
        this.cueInfoBuilders = cea708Decoder$CueInfoBuilderArray2;
        cea708Decoder$CueInfoBuilderArray2 = null;
        for (n12 = 0; n12 < n11; ++n12) {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder2;
            cea708Decoder$CueInfoBuilderArray = this.cueInfoBuilders;
            cea708Decoder$CueInfoBuilderArray[n12] = cea708Decoder$CueInfoBuilder2 = new Cea708Decoder$CueInfoBuilder();
        }
        this.currentCueInfoBuilder = cea708Decoder$CueInfoBuilder = this.cueInfoBuilders[0];
    }

    public static /* synthetic */ int a(Cea708Decoder$Cea708CueInfo cea708Decoder$Cea708CueInfo, Cea708Decoder$Cea708CueInfo cea708Decoder$Cea708CueInfo2) {
        int n10 = cea708Decoder$Cea708CueInfo.priority;
        int n11 = cea708Decoder$Cea708CueInfo2.priority;
        return Integer.compare(n10, n11);
    }

    private void finalizeCurrentPacket() {
        Cea708Decoder$DtvCcPacket cea708Decoder$DtvCcPacket = this.currentDtvCcPacket;
        if (cea708Decoder$DtvCcPacket == null) {
            return;
        }
        this.processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    private List getDisplayCues() {
        Object object;
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n11 = 0;
        ArrayList<Object> arrayList2 = null;
        for (int i10 = 0; i10 < (n10 = 8); ++i10) {
            object = this.cueInfoBuilders[i10];
            n10 = (int)(((Cea708Decoder$CueInfoBuilder)object).isEmpty() ? 1 : 0);
            if (n10 != 0 || (n10 = (int)(((Cea708Decoder$CueInfoBuilder)(object = this.cueInfoBuilders[i10])).isVisible() ? 1 : 0)) == 0 || (object = this.cueInfoBuilders[i10].build()) == null) continue;
            arrayList.add(object);
        }
        arrayList2 = a.a;
        Collections.sort(arrayList, arrayList2);
        n10 = arrayList.size();
        arrayList2 = new ArrayList<Object>(n10);
        while (n11 < (n10 = arrayList.size())) {
            object = ((Cea708Decoder$Cea708CueInfo)arrayList.get((int)n11)).cue;
            arrayList2.add(object);
            ++n11;
        }
        return Collections.unmodifiableList(arrayList2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void handleC0Command(int n10) {
        List list;
        if (n10 == 0) return;
        int n11 = 3;
        if (n10 != n11) {
            n11 = 8;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        int n12 = 17;
                        String string2 = TAG;
                        if (n10 >= n12 && n10 <= (n12 = 23)) {
                            n12 = 55;
                            StringBuilder stringBuilder = new StringBuilder(n12);
                            String string3 = "Currently unsupported COMMAND_EXT1 Command: ";
                            stringBuilder.append(string3);
                            stringBuilder.append(n10);
                            Object object = stringBuilder.toString();
                            Log.w(string2, (String)object);
                            object = this.serviceBlockPacket;
                            ((ParsableBitArray)object).skipBits(n11);
                            return;
                        } else {
                            n11 = 24;
                            n12 = 31;
                            if (n10 >= n11 && n10 <= n12) {
                                StringBuilder stringBuilder = new StringBuilder(54);
                                String string4 = "Currently unsupported COMMAND_P16 Command: ";
                                stringBuilder.append(string4);
                                stringBuilder.append(n10);
                                Object object = stringBuilder.toString();
                                Log.w(string2, (String)object);
                                object = this.serviceBlockPacket;
                                n11 = 16;
                                ((ParsableBitArray)object).skipBits(n11);
                                return;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder(n12);
                                String string5 = "Invalid C0 command: ";
                                stringBuilder.append(string5);
                                stringBuilder.append(n10);
                                String string6 = stringBuilder.toString();
                                Log.w(string2, string6);
                            }
                        }
                        return;
                    }
                    case 13: {
                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                        n11 = 10;
                        cea708Decoder$CueInfoBuilder.append((char)n11);
                        return;
                    }
                    case 12: {
                        this.resetCueBuilders();
                        return;
                    }
                    case 14: {
                        return;
                    }
                }
            }
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
            cea708Decoder$CueInfoBuilder.backspace();
            return;
        }
        this.cues = list = this.getDisplayCues();
    }

    private void handleC1Command(int n10) {
        int n11 = 16;
        int n12 = 8;
        switch (n10) {
            default: {
                n11 = 31;
                StringBuilder stringBuilder = new StringBuilder(n11);
                stringBuilder.append("Invalid C1 command: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                String string3 = TAG;
                Log.w(string3, string2);
                break;
            }
            case 152: 
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: 
            case 159: {
                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder;
                this.handleDefineWindow(n10 += -152);
                n11 = this.currentWindow;
                if (n11 == n10) break;
                this.currentWindow = n10;
                Cea708Decoder$CueInfoBuilder[] cea708Decoder$CueInfoBuilderArray = this.cueInfoBuilders;
                this.currentCueInfoBuilder = cea708Decoder$CueInfoBuilder = cea708Decoder$CueInfoBuilderArray[n10];
                break;
            }
            case 151: {
                Object object = this.currentCueInfoBuilder;
                n10 = (int)(((Cea708Decoder$CueInfoBuilder)object).isDefined() ? 1 : 0);
                if (n10 == 0) {
                    object = this.serviceBlockPacket;
                    n11 = 32;
                    ((ParsableBitArray)object).skipBits(n11);
                    break;
                }
                this.handleSetWindowAttributes();
                break;
            }
            case 146: {
                Object object = this.currentCueInfoBuilder;
                n10 = (int)(((Cea708Decoder$CueInfoBuilder)object).isDefined() ? 1 : 0);
                if (n10 == 0) {
                    object = this.serviceBlockPacket;
                    ((ParsableBitArray)object).skipBits(n11);
                    break;
                }
                this.handleSetPenLocation();
                break;
            }
            case 145: {
                Object object = this.currentCueInfoBuilder;
                n10 = (int)(((Cea708Decoder$CueInfoBuilder)object).isDefined() ? 1 : 0);
                if (n10 == 0) {
                    object = this.serviceBlockPacket;
                    n11 = 24;
                    ((ParsableBitArray)object).skipBits(n11);
                    break;
                }
                this.handleSetPenColor();
                break;
            }
            case 144: {
                Object object = this.currentCueInfoBuilder;
                n10 = (int)(((Cea708Decoder$CueInfoBuilder)object).isDefined() ? 1 : 0);
                if (n10 == 0) {
                    object = this.serviceBlockPacket;
                    ((ParsableBitArray)object).skipBits(n11);
                    break;
                }
                this.handleSetPenAttributes();
                break;
            }
            case 143: {
                this.resetCueBuilders();
                break;
            }
            case 141: {
                ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                parsableBitArray.skipBits(n12);
                break;
            }
            case 140: {
                int n13;
                for (n13 = 1; n13 <= n12; ++n13) {
                    Object object = this.serviceBlockPacket;
                    n10 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    if (n10 == 0) continue;
                    object = this.cueInfoBuilders;
                    n11 = 8 - n13;
                    object = object[n11];
                    ((Cea708Decoder$CueInfoBuilder)object).reset();
                }
                break;
            }
            case 139: {
                int n13;
                for (n10 = n13; n10 <= n12; ++n10) {
                    Object object = this.serviceBlockPacket;
                    n11 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    if (n11 == 0) continue;
                    object = this.cueInfoBuilders;
                    boolean bl2 = 8 - n10;
                    object = object[bl2];
                    bl2 = ((Cea708Decoder$CueInfoBuilder)object).isVisible() ^ n13;
                    ((Cea708Decoder$CueInfoBuilder)object).setVisibility(bl2);
                }
                break;
            }
            case 138: {
                int n13;
                while (n13 <= n12) {
                    Object object = this.serviceBlockPacket;
                    n10 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    if (n10 != 0) {
                        object = this.cueInfoBuilders;
                        n11 = 8 - n13;
                        object = object[n11];
                        n11 = 0;
                        Object var7_20 = null;
                        ((Cea708Decoder$CueInfoBuilder)object).setVisibility(false);
                    }
                    ++n13;
                }
                break;
            }
            case 137: {
                int n13;
                for (n10 = n13; n10 <= n12; ++n10) {
                    Object object = this.serviceBlockPacket;
                    n11 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    if (n11 == 0) continue;
                    object = this.cueInfoBuilders;
                    int n14 = 8 - n10;
                    object = object[n14];
                    ((Cea708Decoder$CueInfoBuilder)object).setVisibility(n13 != 0);
                }
                break;
            }
            case 136: {
                int n13;
                while (n13 <= n12) {
                    Object object = this.serviceBlockPacket;
                    n10 = (int)(((ParsableBitArray)object).readBit() ? 1 : 0);
                    if (n10 != 0) {
                        object = this.cueInfoBuilders;
                        n11 = 8 - n13;
                        object = object[n11];
                        ((Cea708Decoder$CueInfoBuilder)object).clear();
                    }
                    ++n13;
                }
                break;
            }
            case 128: 
            case 129: 
            case 130: 
            case 131: 
            case 132: 
            case 133: 
            case 134: 
            case 135: {
                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder;
                n11 = this.currentWindow;
                if (n11 == (n10 += -128)) break;
                this.currentWindow = n10;
                Cea708Decoder$CueInfoBuilder[] cea708Decoder$CueInfoBuilderArray = this.cueInfoBuilders;
                this.currentCueInfoBuilder = cea708Decoder$CueInfoBuilder = cea708Decoder$CueInfoBuilderArray[n10];
            }
            case 142: 
        }
    }

    private void handleC2Command(int n10) {
        int n11 = 7;
        if (n10 > n11) {
            n11 = 15;
            if (n10 <= n11) {
                ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                n11 = 8;
                parsableBitArray.skipBits(n11);
            } else {
                n11 = 23;
                if (n10 <= n11) {
                    ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                    n11 = 16;
                    parsableBitArray.skipBits(n11);
                } else {
                    n11 = 31;
                    if (n10 <= n11) {
                        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                        n11 = 24;
                        parsableBitArray.skipBits(n11);
                    }
                }
            }
        }
    }

    private void handleC3Command(int n10) {
        int n11 = 135;
        if (n10 <= n11) {
            ParsableBitArray parsableBitArray = this.serviceBlockPacket;
            n11 = 32;
            parsableBitArray.skipBits(n11);
        } else {
            n11 = 143;
            if (n10 <= n11) {
                ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                n11 = 40;
                parsableBitArray.skipBits(n11);
            } else {
                n11 = 159;
                if (n10 <= n11) {
                    this.serviceBlockPacket.skipBits(2);
                    ParsableBitArray parsableBitArray = this.serviceBlockPacket;
                    n11 = 6;
                    n10 = parsableBitArray.readBits(n11);
                    ParsableBitArray parsableBitArray2 = this.serviceBlockPacket;
                    parsableBitArray2.skipBits(n10 *= 8);
                }
            }
        }
    }

    private void handleDefineWindow(int n10) {
        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.cueInfoBuilders[n10];
        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
        int n11 = 2;
        parsableBitArray.skipBits(n11);
        boolean bl2 = this.serviceBlockPacket.readBit();
        boolean bl3 = this.serviceBlockPacket.readBit();
        boolean bl4 = this.serviceBlockPacket.readBit();
        parsableBitArray = this.serviceBlockPacket;
        int n12 = 3;
        n10 = parsableBitArray.readBits(n12);
        boolean bl5 = this.serviceBlockPacket.readBit();
        int n13 = this.serviceBlockPacket.readBits(7);
        int n14 = this.serviceBlockPacket.readBits(8);
        ParsableBitArray parsableBitArray2 = this.serviceBlockPacket;
        int n15 = 4;
        int n16 = parsableBitArray2.readBits(n15);
        int n17 = this.serviceBlockPacket.readBits(n15);
        this.serviceBlockPacket.skipBits(n11);
        n15 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(n11);
        int n18 = this.serviceBlockPacket.readBits(n12);
        int n19 = this.serviceBlockPacket.readBits(n12);
        n12 = n10;
        cea708Decoder$CueInfoBuilder.defineWindow(bl2, bl3, bl4, n10, bl5, n13, n14, n17, n15, n16, n18, n19);
    }

    private void handleG0Character(int n10) {
        char c10 = '\u007f';
        if (n10 == c10) {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
            c10 = '\u266b';
            cea708Decoder$CueInfoBuilder.append(c10);
        } else {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
            n10 = (char)(n10 & 0xFF);
            cea708Decoder$CueInfoBuilder.append((char)n10);
        }
    }

    private void handleG1Character(int n10) {
        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
        n10 = (char)(n10 & 0xFF);
        cea708Decoder$CueInfoBuilder.append((char)n10);
    }

    private void handleG2Character(int n10) {
        int n11 = 32;
        if (n10 != n11) {
            n11 = 33;
            if (n10 != n11) {
                int n12 = 37;
                if (n10 != n12) {
                    n12 = 42;
                    if (n10 != n12) {
                        n12 = 44;
                        if (n10 != n12) {
                            n12 = 63;
                            if (n10 != n12) {
                                n12 = 57;
                                if (n10 != n12) {
                                    n12 = 58;
                                    if (n10 != n12) {
                                        n12 = 60;
                                        if (n10 != n12) {
                                            n12 = 61;
                                            if (n10 != n12) {
                                                block0 : switch (n10) {
                                                    default: {
                                                        switch (n10) {
                                                            default: {
                                                                StringBuilder stringBuilder = new StringBuilder(n11);
                                                                stringBuilder.append("Invalid G2 character: ");
                                                                stringBuilder.append(n10);
                                                                String string2 = stringBuilder.toString();
                                                                String string3 = TAG;
                                                                Log.w(string3, string2);
                                                                break block0;
                                                            }
                                                            case 127: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9484;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 126: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9496;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 125: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9472;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 124: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9492;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 123: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9488;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 122: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 9474;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 121: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 8542;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 120: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 8541;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 119: {
                                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                                n11 = 8540;
                                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                                                break block0;
                                                            }
                                                            case 118: 
                                                        }
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8539;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 53: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8226;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 52: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8221;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 51: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8220;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 50: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8217;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 49: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 8216;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                    case 48: {
                                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                        n11 = 9608;
                                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                                        break;
                                                    }
                                                }
                                            } else {
                                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                                n11 = 8480;
                                                cea708Decoder$CueInfoBuilder.append((char)n11);
                                            }
                                        } else {
                                            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                            n11 = 339;
                                            cea708Decoder$CueInfoBuilder.append((char)n11);
                                        }
                                    } else {
                                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                        n11 = 353;
                                        cea708Decoder$CueInfoBuilder.append((char)n11);
                                    }
                                } else {
                                    Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                    n11 = 8482;
                                    cea708Decoder$CueInfoBuilder.append((char)n11);
                                }
                            } else {
                                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                                n11 = 376;
                                cea708Decoder$CueInfoBuilder.append((char)n11);
                            }
                        } else {
                            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                            n11 = 338;
                            cea708Decoder$CueInfoBuilder.append((char)n11);
                        }
                    } else {
                        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                        n11 = 352;
                        cea708Decoder$CueInfoBuilder.append((char)n11);
                    }
                } else {
                    Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                    n11 = 8230;
                    cea708Decoder$CueInfoBuilder.append((char)n11);
                }
            } else {
                Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
                n11 = 160;
                cea708Decoder$CueInfoBuilder.append((char)n11);
            }
        } else {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
            cea708Decoder$CueInfoBuilder.append((char)n11);
        }
    }

    private void handleG3Character(int n10) {
        int n11 = 160;
        if (n10 == n11) {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.currentCueInfoBuilder;
            n11 = 13252;
            cea708Decoder$CueInfoBuilder.append((char)n11);
        } else {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Invalid G3 character: ");
            stringBuilder.append(n10);
            Object object = stringBuilder.toString();
            String string2 = TAG;
            Log.w(string2, (String)object);
            object = this.currentCueInfoBuilder;
            n11 = 95;
            ((Cea708Decoder$CueInfoBuilder)object).append((char)n11);
        }
    }

    private void handleSetPenAttributes() {
        int n10 = this.serviceBlockPacket.readBits(4);
        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
        int n11 = 2;
        int n12 = parsableBitArray.readBits(n11);
        int n13 = this.serviceBlockPacket.readBits(n11);
        boolean bl2 = this.serviceBlockPacket.readBit();
        boolean bl3 = this.serviceBlockPacket.readBit();
        parsableBitArray = this.serviceBlockPacket;
        n11 = 3;
        int n14 = parsableBitArray.readBits(n11);
        int n15 = this.serviceBlockPacket.readBits(n11);
        this.currentCueInfoBuilder.setPenAttributes(n10, n12, n13, bl2, bl3, n14, n15);
    }

    private void handleSetPenColor() {
        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
        int n10 = 2;
        int n11 = parsableBitArray.readBits(n10);
        int n12 = this.serviceBlockPacket.readBits(n10);
        int n13 = this.serviceBlockPacket.readBits(n10);
        int n14 = this.serviceBlockPacket.readBits(n10);
        n11 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n12, n13, n14, n11);
        n12 = this.serviceBlockPacket.readBits(n10);
        n13 = this.serviceBlockPacket.readBits(n10);
        n14 = this.serviceBlockPacket.readBits(n10);
        int n15 = this.serviceBlockPacket.readBits(n10);
        n12 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n13, n14, n15, n12);
        this.serviceBlockPacket.skipBits(n10);
        n13 = this.serviceBlockPacket.readBits(n10);
        n14 = this.serviceBlockPacket.readBits(n10);
        n10 = this.serviceBlockPacket.readBits(n10);
        n10 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n13, n14, n10);
        this.currentCueInfoBuilder.setPenColor(n11, n12, n10);
    }

    private void handleSetPenLocation() {
        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
        int n10 = 4;
        parsableBitArray.skipBits(n10);
        int n11 = this.serviceBlockPacket.readBits(n10);
        this.serviceBlockPacket.skipBits(2);
        n10 = this.serviceBlockPacket.readBits(6);
        this.currentCueInfoBuilder.setPenLocation(n11, n10);
    }

    private void handleSetWindowAttributes() {
        ParsableBitArray parsableBitArray = this.serviceBlockPacket;
        int n10 = 2;
        int n11 = parsableBitArray.readBits(n10);
        int n12 = this.serviceBlockPacket.readBits(n10);
        int n13 = this.serviceBlockPacket.readBits(n10);
        int n14 = this.serviceBlockPacket.readBits(n10);
        int n15 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n12, n13, n14, n11);
        parsableBitArray = this.serviceBlockPacket;
        n11 = parsableBitArray.readBits(n10);
        n12 = this.serviceBlockPacket.readBits(n10);
        ParsableBitArray parsableBitArray2 = this.serviceBlockPacket;
        n13 = parsableBitArray2.readBits(n10);
        ParsableBitArray parsableBitArray3 = this.serviceBlockPacket;
        n14 = parsableBitArray3.readBits(n10);
        int n16 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n12, n13, n14);
        ParsableBitArray parsableBitArray4 = this.serviceBlockPacket;
        n12 = (int)(parsableBitArray4.readBit() ? 1 : 0);
        if (n12 != 0) {
            n11 |= 4;
        }
        boolean bl2 = this.serviceBlockPacket.readBit();
        int n17 = this.serviceBlockPacket.readBits(n10);
        int n18 = this.serviceBlockPacket.readBits(n10);
        int n19 = this.serviceBlockPacket.readBits(n10);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueInfoBuilder.setWindowAttributes(n15, n16, bl2, n11, n17, n18, n19);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void processCurrentPacket() {
        Object object;
        Object object2;
        CharSequence charSequence;
        int n10;
        Object object3 = this.currentDtvCcPacket;
        int n11 = ((Cea708Decoder$DtvCcPacket)object3).currentIndex;
        int n12 = ((Cea708Decoder$DtvCcPacket)object3).packetSize;
        int n13 = n12 * 2;
        int n14 = 1;
        int n15 = 2;
        String string2 = TAG;
        if (n11 != (n13 -= n14)) {
            n12 = n12 * n15 - n14;
            n10 = ((Cea708Decoder$DtvCcPacket)object3).sequenceNumber;
            n13 = 115;
            StringBuilder stringBuilder = new StringBuilder(n13);
            charSequence = "DtvCcPacket ended prematurely; size is ";
            stringBuilder.append((String)charSequence);
            stringBuilder.append(n12);
            object2 = ", but current index is ";
            stringBuilder.append((String)object2);
            stringBuilder.append(n11);
            object = " (sequence number ";
            stringBuilder.append((String)object);
            stringBuilder.append(n10);
            stringBuilder.append(");");
            object3 = stringBuilder.toString();
            Log.d(string2, (String)object3);
        }
        object3 = this.serviceBlockPacket;
        object = this.currentDtvCcPacket;
        object2 = ((Cea708Decoder$DtvCcPacket)object).packetData;
        n11 = ((Cea708Decoder$DtvCcPacket)object).currentIndex;
        ((ParsableBitArray)object3).reset((byte[])object2, n11);
        object3 = this.serviceBlockPacket;
        n10 = ((ParsableBitArray)object3).readBits(3);
        object = this.serviceBlockPacket;
        n11 = ((ParsableBitArray)object).readBits(5);
        n12 = 7;
        if (n10 == n12) {
            this.serviceBlockPacket.skipBits(n15);
            object3 = this.serviceBlockPacket;
            n13 = 6;
            n10 = ((ParsableBitArray)object3).readBits(n13);
            if (n10 < n12) {
                n12 = 44;
                charSequence = new StringBuilder(n12);
                ((StringBuilder)charSequence).append("Invalid extended service number: ");
                ((StringBuilder)charSequence).append(n10);
                object2 = ((StringBuilder)charSequence).toString();
                Log.w(string2, (String)object2);
            }
        }
        if (n11 == 0) {
            if (n10 != 0) {
                n11 = 59;
                object2 = new StringBuilder;
                ((StringBuilder)object2)(n11);
                object = "serviceNumber is non-zero (";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append(") when blockSize is 0");
                object3 = ((StringBuilder)object2).toString();
                Log.w(string2, (String)object3);
            }
            return;
        }
        n11 = this.selectedServiceNumber;
        if (n10 != n11) {
            return;
        }
        n10 = 0;
        object3 = null;
        while ((n11 = ((ParsableBitArray)(object = this.serviceBlockPacket)).bitsLeft()) > 0) {
            block23: {
                block19: {
                    int n16;
                    block22: {
                        int n17;
                        int n18;
                        block20: {
                            block21: {
                                object = this.serviceBlockPacket;
                                n12 = 8;
                                n11 = ((ParsableBitArray)object).readBits(n12);
                                n13 = 16;
                                n15 = 255;
                                n16 = 159;
                                n18 = 127;
                                n17 = 31;
                                if (n11 == n13) break block20;
                                if (n11 <= n17) {
                                    this.handleC0Command(n11);
                                    continue;
                                }
                                if (n11 > n18) break block21;
                                this.handleG0Character(n11);
                                break block19;
                            }
                            if (n11 <= n16) {
                                this.handleC1Command(n11);
                                break block19;
                            } else if (n11 <= n15) {
                                this.handleG1Character(n11);
                                break block19;
                            } else {
                                n12 = 33;
                                charSequence = new StringBuilder(n12);
                                object2 = "Invalid base command: ";
                                ((StringBuilder)charSequence).append((String)object2);
                                ((StringBuilder)charSequence).append(n11);
                                object = ((StringBuilder)charSequence).toString();
                                Log.w(string2, (String)object);
                                continue;
                            }
                        }
                        object = this.serviceBlockPacket;
                        n11 = ((ParsableBitArray)object).readBits(n12);
                        if (n11 <= n17) {
                            this.handleC2Command(n11);
                            continue;
                        }
                        if (n11 > n18) break block22;
                        this.handleG2Character(n11);
                        break block19;
                    }
                    if (n11 <= n16) {
                        this.handleC3Command(n11);
                        continue;
                    }
                    if (n11 > n15) break block23;
                    this.handleG3Character(n11);
                }
                n10 = n14;
                continue;
            }
            n12 = 37;
            charSequence = new StringBuilder(n12);
            object2 = "Invalid extended command: ";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(n11);
            object = ((StringBuilder)charSequence).toString();
            Log.w(string2, (String)object);
        }
        if (n10 != 0) {
            this.cues = object3 = this.getDisplayCues();
        }
    }

    private void resetCueBuilders() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 8); ++i10) {
            Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this.cueInfoBuilders[i10];
            cea708Decoder$CueInfoBuilder.reset();
        }
    }

    public Subtitle createSubtitle() {
        List list;
        this.lastCues = list = this.cues;
        list = (List)Assertions.checkNotNull(list);
        CeaSubtitle ceaSubtitle = new CeaSubtitle(list);
        return ceaSubtitle;
    }

    public void decode(SubtitleInputBuffer object) {
        int n10;
        object = (ByteBuffer)Assertions.checkNotNull(((DecoderInputBuffer)object).data);
        Object object2 = ((ByteBuffer)object).array();
        Object object3 = this.ccData;
        int n11 = ((Buffer)object).limit();
        ((ParsableByteArray)object3).reset((byte[])object2, n11);
        while ((n11 = ((ParsableByteArray)(object = this.ccData)).bytesLeft()) >= (n10 = 3)) {
            object = this.ccData;
            n11 = ((ParsableByteArray)object).readUnsignedByte() & 7;
            int n12 = n11 & 3;
            int n13 = 4;
            int n14 = 0;
            StringBuilder stringBuilder = null;
            int n15 = 1;
            if ((n11 &= n13) == n13) {
                n11 = n15;
            } else {
                n11 = 0;
                object = null;
            }
            ParsableByteArray parsableByteArray = this.ccData;
            byte by2 = (byte)parsableByteArray.readUnsignedByte();
            ParsableByteArray parsableByteArray2 = this.ccData;
            byte by3 = (byte)parsableByteArray2.readUnsignedByte();
            int n16 = 2;
            if (n12 != n16 && n12 != n10 || n11 == 0) continue;
            object = TAG;
            if (n12 == n10) {
                this.finalizeCurrentPacket();
                n10 = (by2 & 0xC0) >> 6;
                n12 = this.previousSequenceNumber;
                n14 = -1;
                if (n12 != n14 && n10 != (n12 = (n12 + 1) % n13)) {
                    this.resetCueBuilders();
                    n12 = this.previousSequenceNumber;
                    n13 = 71;
                    stringBuilder = new StringBuilder(n13);
                    String string2 = "Sequence number discontinuity. previous=";
                    stringBuilder.append(string2);
                    stringBuilder.append(n12);
                    stringBuilder.append(" current=");
                    stringBuilder.append(n10);
                    object3 = stringBuilder.toString();
                    Log.w((String)object, (String)object3);
                }
                this.previousSequenceNumber = n10;
                n11 = by2 & 0x3F;
                if (n11 == 0) {
                    n11 = 64;
                }
                this.currentDtvCcPacket = object3 = new Cea708Decoder$DtvCcPacket(n10, n11);
                object = ((Cea708Decoder$DtvCcPacket)object3).packetData;
                n10 = ((Cea708Decoder$DtvCcPacket)object3).currentIndex;
                ((Cea708Decoder$DtvCcPacket)object3).currentIndex = n13 = n10 + 1;
                object[n10] = by3;
            } else {
                if (n12 == n16) {
                    n14 = n15;
                }
                Assertions.checkArgument(n14 != 0);
                object2 = this.currentDtvCcPacket;
                if (object2 == null) {
                    object2 = "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START";
                    Log.e((String)object, (String)object2);
                    continue;
                }
                object = object2.packetData;
                n12 = object2.currentIndex;
                object2.currentIndex = n13 = n12 + 1;
                object[n12] = by2;
                object2.currentIndex = n12 = n13 + 1;
                object[n13] = by3;
            }
            object = this.currentDtvCcPacket;
            n10 = ((Cea708Decoder$DtvCcPacket)object).currentIndex;
            n11 = ((Cea708Decoder$DtvCcPacket)object).packetSize * n16 - n15;
            if (n10 != n11) continue;
            this.finalizeCurrentPacket();
        }
    }

    public void flush() {
        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder;
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueInfoBuilder = cea708Decoder$CueInfoBuilder = this.cueInfoBuilders[0];
        this.resetCueBuilders();
        this.currentDtvCcPacket = null;
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
}


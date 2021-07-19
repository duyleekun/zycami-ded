/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil$Config;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class AacUtil {
    public static final int AAC_ELD_MAX_RATE_BYTES_PER_SECOND = 8000;
    public static final int AAC_HE_AUDIO_SAMPLE_COUNT = 2048;
    public static final int AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND = 16000;
    public static final int AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND = 7000;
    public static final int AAC_LC_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_LC_MAX_RATE_BYTES_PER_SECOND = 100000;
    public static final int AAC_LD_AUDIO_SAMPLE_COUNT = 512;
    public static final int AAC_XHE_AUDIO_SAMPLE_COUNT = 1024;
    public static final int AAC_XHE_MAX_RATE_BYTES_PER_SECOND = 256000;
    public static final int AUDIO_OBJECT_TYPE_AAC_ELD = 23;
    public static final int AUDIO_OBJECT_TYPE_AAC_ER_BSAC = 22;
    public static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    public static final int AUDIO_OBJECT_TYPE_AAC_PS = 29;
    public static final int AUDIO_OBJECT_TYPE_AAC_SBR = 5;
    public static final int AUDIO_OBJECT_TYPE_AAC_XHE = 42;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = 255;
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
    private static final String CODECS_STRING_PREFIX = "mp4a.40.";
    private static final String TAG = "AacUtil";

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[13];
        int[] nArray3 = nArray;
        nArray2[0] = 96000;
        nArray3[1] = 88200;
        nArray2[2] = 64000;
        nArray3[3] = 48000;
        nArray2[4] = 44100;
        nArray3[5] = 32000;
        nArray2[6] = 24000;
        nArray3[7] = 22050;
        nArray2[8] = 16000;
        nArray3[9] = 12000;
        nArray2[10] = 11025;
        nArray3[11] = 8000;
        nArray3[12] = 7350;
        AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = nArray;
        int[] nArray4 = nArray = new int[16];
        int[] nArray5 = nArray;
        nArray4[0] = 0;
        nArray5[1] = 1;
        nArray4[2] = 2;
        nArray5[3] = 3;
        nArray4[4] = 4;
        nArray5[5] = 5;
        nArray4[6] = 6;
        nArray5[7] = 8;
        nArray4[8] = -1;
        nArray5[9] = -1;
        nArray4[10] = -1;
        nArray5[11] = 7;
        nArray4[12] = 8;
        nArray5[13] = -1;
        nArray4[14] = 8;
        nArray5[15] = -1;
        AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = nArray;
    }

    private AacUtil() {
    }

    public static byte[] buildAacLcAudioSpecificConfig(int n10, int n11) {
        int n12;
        int[] nArray;
        int n13;
        int n14;
        int n15 = 0;
        IllegalArgumentException illegalArgumentException = null;
        int n16 = -1;
        StringBuilder stringBuilder = null;
        int n17 = n16;
        for (n14 = 0; n14 < (n13 = (nArray = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE).length); ++n14) {
            n12 = nArray[n14];
            if (n10 != n12) continue;
            n17 = n14;
        }
        n14 = n16;
        while (n15 < (n13 = (nArray = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE).length)) {
            n12 = nArray[n15];
            if (n11 == n12) {
                n14 = n15;
            }
            ++n15;
        }
        if (n10 != n16 && n14 != n16) {
            return AacUtil.buildAudioSpecificConfig(2, n17, n14);
        }
        stringBuilder = new StringBuilder(67);
        stringBuilder.append("Invalid sample rate or number of channels: ");
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static byte[] buildAudioSpecificConfig(int n10, int n11, int n12) {
        byte[] byArray = new byte[2];
        n10 = n10 << 3 & 0xF8;
        int n13 = n11 >> 1 & 7;
        byArray[0] = n10 = (int)((byte)(n10 | n13));
        n10 = n11 << 7 & 0x80;
        n11 = n12 << 3 & 0x78;
        byArray[1] = n10 = (int)((byte)(n10 | n11));
        return byArray;
    }

    private static int getAudioObjectType(ParsableBitArray parsableBitArray) {
        int n10;
        int n11 = parsableBitArray.readBits(5);
        if (n11 == (n10 = 31)) {
            int n12 = parsableBitArray.readBits(6);
            n11 = n12 + 32;
        }
        return n11;
    }

    public static int getEncodingForAudioObjectType(int n10) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 29;
                if (n10 != n11) {
                    n11 = 42;
                    if (n10 != n11) {
                        n11 = 22;
                        if (n10 != n11) {
                            n11 = 23;
                            if (n10 != n11) {
                                return 0;
                            }
                            return 15;
                        }
                        return 0x40000000;
                    }
                    return 16;
                }
                return 12;
            }
            return 11;
        }
        return 10;
    }

    private static int getSamplingFrequency(ParsableBitArray object) {
        block4: {
            Object object2;
            block3: {
                int n10;
                block2: {
                    int n11;
                    n10 = ((ParsableBitArray)object).readBits(4);
                    if (n10 != (n11 = 15)) break block2;
                    n10 = 24;
                    object2 = ((ParsableBitArray)object).readBits(n10);
                    break block3;
                }
                object2 = 13;
                if (n10 >= object2) break block4;
                object = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
                object2 = object[n10];
            }
            return object2;
        }
        object = new ParserException();
        throw object;
    }

    public static AacUtil$Config parseAudioSpecificConfig(ParsableBitArray object, boolean n10) {
        Object object2;
        int n11 = AacUtil.getAudioObjectType((ParsableBitArray)object);
        int n12 = AacUtil.getSamplingFrequency((ParsableBitArray)object);
        int n13 = 4;
        int n14 = ((ParsableBitArray)object).readBits(n13);
        CharSequence charSequence = new StringBuilder(19);
        String string2 = CODECS_STRING_PREFIX;
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        int n15 = 5;
        if (n11 == n15 || n11 == (n15 = 29)) {
            n12 = AacUtil.getSamplingFrequency((ParsableBitArray)object);
            n11 = AacUtil.getAudioObjectType((ParsableBitArray)object);
            if (n11 == (n15 = 22)) {
                n14 = ((ParsableBitArray)object).readBits(n13);
            }
        }
        if (n10 != 0) {
            n10 = 1;
            n15 = 3;
            int n16 = 2;
            if (n11 != n10 && n11 != n16 && n11 != n15 && n11 != n13 && n11 != (n10 = 6) && n11 != (n10 = 7) && n11 != (n10 = 17)) {
                switch (n11) {
                    default: {
                        StringBuilder stringBuilder = new StringBuilder(42);
                        stringBuilder.append("Unsupported audio object type: ");
                        stringBuilder.append(n11);
                        String string3 = stringBuilder.toString();
                        object = new ParserException(string3);
                        throw object;
                    }
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                }
            }
            AacUtil.parseGaSpecificConfig((ParsableBitArray)object, n11, n14);
            switch (n11) {
                default: {
                    break;
                }
                case 17: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: {
                    object2 = ((ParsableBitArray)object).readBits(n16);
                    if (object2 != n16 && object2 != n15) break;
                    StringBuilder stringBuilder = new StringBuilder(33);
                    stringBuilder.append("Unsupported epConfig: ");
                    stringBuilder.append((int)object2);
                    object = stringBuilder.toString();
                    ParserException parserException = new ParserException((String)object);
                    throw parserException;
                }
            }
        }
        if ((object2 = (object = (Object)AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE)[n14]) != (n10 = -1)) {
            AacUtil$Config aacUtil$Config = new AacUtil$Config(n12, (int)object2, (String)charSequence, null);
            return aacUtil$Config;
        }
        object = new ParserException();
        throw object;
    }

    public static AacUtil$Config parseAudioSpecificConfig(byte[] byArray) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(byArray);
        return AacUtil.parseAudioSpecificConfig(parsableBitArray, false);
    }

    private static void parseGaSpecificConfig(ParsableBitArray object, int n10, int n11) {
        boolean bl2;
        boolean n12 = ((ParsableBitArray)object).readBit();
        if (n12) {
            String string2 = TAG;
            String string3 = "Unexpected frameLengthFlag = 1";
            Log.w(string2, string3);
        }
        if (bl2 = ((ParsableBitArray)object).readBit()) {
            int n13 = 14;
            ((ParsableBitArray)object).skipBits(n13);
        }
        boolean bl3 = ((ParsableBitArray)object).readBit();
        if (n11 != 0) {
            n11 = 6;
            int n14 = 20;
            int n15 = 3;
            if (n10 == n11 || n10 == n14) {
                ((ParsableBitArray)object).skipBits(n15);
            }
            if (bl3) {
                n11 = 22;
                if (n10 == n11) {
                    n11 = 16;
                    ((ParsableBitArray)object).skipBits(n11);
                }
                if (n10 == (n11 = 17) || n10 == (n11 = 19) || n10 == n14 || n10 == (n11 = 23)) {
                    ((ParsableBitArray)object).skipBits(n15);
                }
                n10 = 1;
                ((ParsableBitArray)object).skipBits(n10);
            }
            return;
        }
        object = new UnsupportedOperationException();
        throw object;
    }
}


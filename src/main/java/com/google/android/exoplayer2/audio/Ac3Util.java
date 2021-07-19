/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.Ac3Util$SyncFrameInfo;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class Ac3Util {
    public static final int AC3_MAX_RATE_BYTES_PER_SECOND = 80000;
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD;
    private static final int[] CHANNEL_COUNT_BY_ACMOD;
    public static final int E_AC3_MAX_RATE_BYTES_PER_SECOND = 768000;
    private static final int[] SAMPLE_RATE_BY_FSCOD;
    private static final int[] SAMPLE_RATE_BY_FSCOD2;
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
    public static final int TRUEHD_MAX_RATE_BYTES_PER_SECOND = 3062500;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    static {
        int[] nArray;
        int[] nArray2;
        int[] nArray3 = nArray2 = new int[4];
        int[] nArray4 = nArray2;
        nArray3[0] = 1;
        nArray4[1] = 2;
        nArray3[2] = 3;
        nArray4[3] = 6;
        BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = nArray2;
        int n10 = 3;
        int[] nArray5 = nArray = new int[n10];
        nArray[0] = 48000;
        nArray5[1] = 44100;
        nArray5[2] = 32000;
        SAMPLE_RATE_BY_FSCOD = nArray;
        int[] nArray6 = nArray2 = new int[n10];
        nArray2[0] = 24000;
        nArray6[1] = 22050;
        nArray6[2] = 16000;
        SAMPLE_RATE_BY_FSCOD2 = nArray2;
        int[] nArray7 = nArray2 = new int[8];
        int[] nArray8 = nArray2;
        nArray7[0] = 2;
        nArray8[1] = 1;
        nArray7[2] = 2;
        nArray8[3] = 3;
        nArray7[4] = 3;
        nArray8[5] = 4;
        nArray7[6] = 4;
        nArray8[7] = 5;
        CHANNEL_COUNT_BY_ACMOD = nArray2;
        n10 = 19;
        int[] nArray9 = nArray = new int[n10];
        int[] nArray10 = nArray;
        nArray9[0] = 32;
        nArray10[1] = 40;
        nArray9[2] = 48;
        nArray10[3] = 56;
        nArray9[4] = 64;
        nArray10[5] = 80;
        nArray9[6] = 96;
        nArray10[7] = 112;
        nArray9[8] = 128;
        nArray10[9] = 160;
        nArray9[10] = 192;
        nArray10[11] = 224;
        nArray9[12] = 256;
        nArray10[13] = 320;
        nArray9[14] = 384;
        nArray10[15] = 448;
        nArray9[16] = 512;
        nArray10[17] = 576;
        nArray10[18] = 640;
        BITRATE_BY_HALF_FRMSIZECOD = nArray;
        int[] nArray11 = nArray2 = new int[n10];
        int[] nArray12 = nArray2;
        nArray11[0] = 69;
        nArray12[1] = 87;
        nArray11[2] = 104;
        nArray12[3] = 121;
        nArray11[4] = 139;
        nArray12[5] = 174;
        nArray11[6] = 208;
        nArray12[7] = 243;
        nArray11[8] = 278;
        nArray12[9] = 348;
        nArray11[10] = 417;
        nArray12[11] = 487;
        nArray11[12] = 557;
        nArray12[13] = 696;
        nArray11[14] = 835;
        nArray12[15] = 975;
        nArray11[16] = 1114;
        nArray12[17] = 1253;
        nArray12[18] = 1393;
        SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = nArray2;
    }

    private Ac3Util() {
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.position();
        int n11 = byteBuffer.limit() + -10;
        for (int i10 = n10; i10 <= n11; ++i10) {
            int n12;
            int n13 = i10 + 4;
            if ((n13 = Util.getBigEndianInt(byteBuffer, n13) & 0xFFFFFFFE) != (n12 = -126718022)) continue;
            return i10 - n10;
        }
        return -1;
    }

    private static int getAc3SyncframeSize(int n10, int n11) {
        int[] nArray;
        int n12;
        int[] nArray2;
        int n13;
        int n14 = n11 / 2;
        if (n10 >= 0 && n10 < (n13 = (nArray2 = SAMPLE_RATE_BY_FSCOD).length) && n11 >= 0 && n14 < (n12 = (nArray = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1).length)) {
            int n15 = 44100;
            if ((n10 = nArray2[n10]) == n15) {
                n10 = nArray[n14];
                return (n10 + (n11 %= 2)) * 2;
            }
            int[] nArray3 = BITRATE_BY_HALF_FRMSIZECOD;
            n11 = nArray3[n14];
            n14 = 32000;
            if (n10 == n14) {
                return n11 * 6;
            }
            return n11 * 4;
        }
        return -1;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray object, String string2, String string3, DrmInitData drmInitData) {
        int n10 = (((ParsableByteArray)object).readUnsignedByte() & 0xC0) >> 6;
        n10 = SAMPLE_RATE_BY_FSCOD[n10];
        int n11 = ((ParsableByteArray)object).readUnsignedByte();
        int[] nArray = CHANNEL_COUNT_BY_ACMOD;
        int n12 = (n11 & 0x38) >> 3;
        int n13 = nArray[n12];
        if ((n11 &= 4) != 0) {
            ++n13;
        }
        object = new Format$Builder();
        return ((Format$Builder)object).setId(string2).setSampleMimeType("audio/ac3").setChannelCount(n13).setSampleRate(n10).setDrmInitData(drmInitData).setLanguage(string3).build();
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.position() + 5;
        n10 = byteBuffer.get(n10) & 0xF8;
        int n11 = 3;
        int n12 = 10;
        if ((n10 = (n10 >>= n11) > n12 ? 1 : 0) != 0) {
            n10 = byteBuffer.position() + 4;
            if ((n10 = (byteBuffer.get(n10) & 0xC0) >> 6) != n11) {
                n10 = byteBuffer.position() + 4;
                int n13 = byteBuffer.get(n10) & 0x30;
                n11 = n13 >> 4;
            }
            return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[n11] * 256;
        }
        return 1536;
    }

    public static Ac3Util$SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        int n10;
        Object object;
        int n11;
        int n12;
        int n13;
        int n14;
        String string2;
        Object object2 = parsableBitArray;
        int n15 = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        int n16 = 5;
        int n17 = parsableBitArray.readBits(n16);
        int n18 = 10;
        int n19 = 1;
        float f10 = Float.MIN_VALUE;
        if (n17 > n18) {
            n17 = n19;
        } else {
            n17 = 0;
            string2 = null;
        }
        ((ParsableBitArray)object2).setPosition(n15);
        n15 = -1;
        int n20 = 8;
        int n21 = 3;
        int n22 = 2;
        float f11 = 2.8E-45f;
        if (n17 != 0) {
            int n23;
            int n24;
            int n25;
            n17 = 16;
            ((ParsableBitArray)object2).skipBits(n17);
            n14 = ((ParsableBitArray)object2).readBits(n22);
            if (n14 != 0) {
                if (n14 != n19) {
                    if (n14 == n22) {
                        n15 = n22;
                    }
                } else {
                    n15 = n19;
                }
            } else {
                n15 = 0;
            }
            ((ParsableBitArray)object2).skipBits(n21);
            n14 = (((ParsableBitArray)object2).readBits(11) + n19) * n22;
            int n26 = ((ParsableBitArray)object2).readBits(n22);
            if (n26 == n21) {
                int[] nArray = SAMPLE_RATE_BY_FSCOD2;
                n25 = ((ParsableBitArray)object2).readBits(n22);
                n13 = nArray[n25];
                n25 = 6;
                n24 = n21;
            } else {
                n24 = ((ParsableBitArray)object2).readBits(n22);
                int[] nArray = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD;
                n25 = nArray[n24];
                int[] nArray2 = SAMPLE_RATE_BY_FSCOD;
                n13 = nArray2[n26];
            }
            n12 = n25 * 256;
            int n27 = ((ParsableBitArray)object2).readBits(n21);
            int n28 = parsableBitArray.readBit();
            int[] nArray = CHANNEL_COUNT_BY_ACMOD;
            n11 = nArray[n27] + n28;
            ((ParsableBitArray)object2).skipBits(n18);
            n18 = (int)(parsableBitArray.readBit() ? 1 : 0);
            if (n18 != 0) {
                ((ParsableBitArray)object2).skipBits(n20);
            }
            if (n27 == 0) {
                ((ParsableBitArray)object2).skipBits(n16);
                n18 = (int)(parsableBitArray.readBit() ? 1 : 0);
                if (n18 != 0) {
                    ((ParsableBitArray)object2).skipBits(n20);
                }
            }
            if (n15 == n19 && (n18 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                ((ParsableBitArray)object2).skipBits(n17);
            }
            n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
            n18 = 4;
            if (n17 != 0) {
                if (n27 > n22) {
                    ((ParsableBitArray)object2).skipBits(n22);
                }
                if ((n17 = n27 & 1) != 0 && n27 > n22) {
                    n17 = 6;
                    ((ParsableBitArray)object2).skipBits(n17);
                } else {
                    n17 = 6;
                }
                int n29 = n27 & 4;
                if (n29 != 0) {
                    ((ParsableBitArray)object2).skipBits(n17);
                }
                if (n28 != 0 && (n17 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                    ((ParsableBitArray)object2).skipBits(n16);
                }
                if (n15 == 0) {
                    n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                    if (n17 != 0) {
                        n17 = 6;
                        ((ParsableBitArray)object2).skipBits(n17);
                    } else {
                        n17 = 6;
                    }
                    if (n27 == 0 && (n29 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                        ((ParsableBitArray)object2).skipBits(n17);
                    }
                    if ((n29 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                        ((ParsableBitArray)object2).skipBits(n17);
                    }
                    if ((n17 = ((ParsableBitArray)object2).readBits(n22)) == n19) {
                        ((ParsableBitArray)object2).skipBits(n16);
                    } else if (n17 == n22) {
                        n17 = 12;
                        ((ParsableBitArray)object2).skipBits(n17);
                    } else if (n17 == n21) {
                        boolean bl2;
                        n17 = ((ParsableBitArray)object2).readBits(n16);
                        boolean bl3 = parsableBitArray.readBit();
                        if (bl3) {
                            boolean bl4;
                            boolean bl5;
                            boolean bl6;
                            boolean bl7;
                            boolean bl8;
                            boolean bl9;
                            boolean bl10;
                            ((ParsableBitArray)object2).skipBits(n16);
                            boolean bl11 = parsableBitArray.readBit();
                            if (bl11) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl10 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl9 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl8 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl7 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl6 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl5 = parsableBitArray.readBit()) {
                                ((ParsableBitArray)object2).skipBits(n18);
                            }
                            if (bl4 = parsableBitArray.readBit()) {
                                boolean bl12;
                                boolean bl13 = parsableBitArray.readBit();
                                if (bl13) {
                                    ((ParsableBitArray)object2).skipBits(n18);
                                }
                                if (bl12 = parsableBitArray.readBit()) {
                                    ((ParsableBitArray)object2).skipBits(n18);
                                }
                            }
                        }
                        if (bl2 = parsableBitArray.readBit()) {
                            ((ParsableBitArray)object2).skipBits(n16);
                            boolean bl14 = parsableBitArray.readBit();
                            if (bl14) {
                                f10 = 9.8E-45f;
                                ((ParsableBitArray)object2).skipBits(7);
                                n19 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                if (n19 != 0) {
                                    ((ParsableBitArray)object2).skipBits(n20);
                                }
                            }
                        }
                        n17 = (n17 + n22) * n20;
                        ((ParsableBitArray)object2).skipBits(n17);
                        parsableBitArray.byteAlign();
                    }
                    if (n27 < n22) {
                        n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
                        n19 = 14;
                        f10 = 2.0E-44f;
                        if (n17 != 0) {
                            ((ParsableBitArray)object2).skipBits(n19);
                        }
                        if (n27 == 0 && (n17 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                            ((ParsableBitArray)object2).skipBits(n19);
                        }
                    }
                    if ((n17 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                        if (n24 == 0) {
                            ((ParsableBitArray)object2).skipBits(n16);
                        } else {
                            string2 = null;
                            for (n17 = 0; n17 < n25; ++n17) {
                                n19 = (int)(parsableBitArray.readBit() ? 1 : 0);
                                if (n19 == 0) continue;
                                ((ParsableBitArray)object2).skipBits(n16);
                            }
                        }
                    }
                }
            }
            if ((n17 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                ((ParsableBitArray)object2).skipBits(n16);
                if (n27 == n22) {
                    ((ParsableBitArray)object2).skipBits(n18);
                }
                if (n27 >= (n16 = 6)) {
                    ((ParsableBitArray)object2).skipBits(n22);
                }
                if ((n16 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                    ((ParsableBitArray)object2).skipBits(n20);
                }
                if (n27 == 0 && (n16 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0) {
                    ((ParsableBitArray)object2).skipBits(n20);
                }
                if (n26 < n21) {
                    parsableBitArray.skipBit();
                }
            }
            if (n15 == 0 && n24 != n21) {
                parsableBitArray.skipBit();
            }
            if (n15 == n22 && (n24 == n21 || (n16 = (int)(parsableBitArray.readBit() ? 1 : 0)) != 0)) {
                n16 = 6;
                ((ParsableBitArray)object2).skipBits(n16);
            } else {
                n16 = 6;
            }
            n17 = (int)(parsableBitArray.readBit() ? 1 : 0);
            object2 = n17 != 0 && (n16 = ((ParsableBitArray)object2).readBits(n16)) == (n17 = 1) && (n23 = ((ParsableBitArray)object2).readBits(n20)) == n17 ? "audio/eac3-joc" : "audio/eac3";
            object = object2;
            n10 = n15;
        } else {
            int[] nArray;
            ((ParsableBitArray)object2).skipBits(32);
            n16 = ((ParsableBitArray)object2).readBits(n22);
            if (n16 == n21) {
                n17 = 0;
                string2 = null;
            } else {
                string2 = "audio/ac3";
            }
            n18 = ((ParsableBitArray)object2).readBits(6);
            n14 = Ac3Util.getAc3SyncframeSize(n16, n18);
            ((ParsableBitArray)object2).skipBits(n20);
            n18 = ((ParsableBitArray)object2).readBits(n21);
            n12 = n18 & 1;
            if (n12 != 0 && n18 != (n12 = 1)) {
                ((ParsableBitArray)object2).skipBits(n22);
            }
            if ((n12 = n18 & 4) != 0) {
                ((ParsableBitArray)object2).skipBits(n22);
            }
            if (n18 == n22) {
                ((ParsableBitArray)object2).skipBits(n22);
            }
            n13 = n16 < (n19 = (nArray = SAMPLE_RATE_BY_FSCOD).length) ? (n16 = nArray[n16]) : n15;
            n12 = 1536;
            int n30 = parsableBitArray.readBit();
            int[] nArray2 = CHANNEL_COUNT_BY_ACMOD;
            n16 = nArray2[n18];
            n11 = n16 + n30;
            n10 = n15;
            object = string2;
        }
        object2 = new Ac3Util$SyncFrameInfo((String)object, n10, n11, n13, n14, n12, null);
        return object2;
    }

    public static int parseAc3SyncframeSize(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 6;
        if (n10 < n11) {
            return -1;
        }
        n10 = byArray[5] & 0xF8;
        int n12 = 3;
        int n13 = 10;
        int n14 = 1;
        n10 = (n10 >>= n12) > n13 ? n14 : 0;
        if (n10 != 0) {
            n10 = 2;
            n11 = (byArray[n10] & 7) << 8;
            return ((byArray[n12] & 0xFF | n11) + n14) * n10;
        }
        n10 = 4;
        n11 = (byArray[n10] & 0xC0) >> 6;
        int n15 = byArray[n10] & 0x3F;
        return Ac3Util.getAc3SyncframeSize(n11, n15);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray object, String string2, String string3, DrmInitData drmInitData) {
        int n10;
        int n11 = 2;
        ((ParsableByteArray)object).skipBytes(n11);
        int n12 = (((ParsableByteArray)object).readUnsignedByte() & 0xC0) >> 6;
        int[] nArray = SAMPLE_RATE_BY_FSCOD;
        n12 = nArray[n12];
        int n13 = ((ParsableByteArray)object).readUnsignedByte();
        int[] nArray2 = CHANNEL_COUNT_BY_ACMOD;
        int n14 = (n13 & 0xE) >> 1;
        int n15 = nArray2[n14];
        if ((n13 &= 1) != 0) {
            ++n15;
        }
        if ((n13 = (((ParsableByteArray)object).readUnsignedByte() & 0x1E) >> 1) > 0 && (n11 &= (n13 = ((ParsableByteArray)object).readUnsignedByte())) != 0) {
            n15 += 2;
        }
        object = (n11 = ((ParsableByteArray)object).bytesLeft()) > 0 && (n10 = ((ParsableByteArray)object).readUnsignedByte() & 1) != 0 ? "audio/eac3-joc" : "audio/eac3";
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setSampleMimeType((String)object).setChannelCount(n15).setSampleRate(n12).setDrmInitData(drmInitData).setLanguage(string3).build();
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int n10) {
        int n11;
        int n12 = byteBuffer.position() + n10 + 7;
        n12 = (n12 = byteBuffer.get(n12) & 0xFF) == (n11 = 187) ? 1 : 0;
        n11 = 40;
        int n13 = byteBuffer.position() + n10;
        n10 = n12 != 0 ? 9 : 8;
        int n14 = byteBuffer.get(n13 += n10) >> 4 & 7;
        return n11 << n14;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] byArray) {
        int n10;
        int n11 = 4;
        int n12 = byArray[n11];
        int n13 = 0;
        int n14 = -8;
        if (n12 == n14 && (n12 = byArray[5]) == (n14 = 114) && (n12 = byArray[6]) == (n14 = 111) && (n14 = byArray[n12 = 7] & 0xFE) == (n10 = 186)) {
            n14 = byArray[n12] & 0xFF;
            n10 = 187;
            if (n14 == n10) {
                n13 = 1;
            }
            n14 = 40;
            n13 = n13 != 0 ? 9 : 8;
            int n15 = byArray[n13] >> n11 & n12;
            return n14 << n15;
        }
        return 0;
    }
}


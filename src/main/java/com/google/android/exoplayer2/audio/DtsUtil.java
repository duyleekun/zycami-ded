/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE;
    public static final int DTS_HD_MAX_RATE_BYTES_PER_SECOND = 2250000;
    public static final int DTS_MAX_RATE_BYTES_PER_SECOND = 192000;
    private static final byte FIRST_BYTE_14B_BE = 31;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = 127;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int[] SAMPLE_RATE_BY_SFREQ;
    private static final int SYNC_VALUE_14B_BE = 536864768;
    private static final int SYNC_VALUE_14B_LE = -14745368;
    private static final int SYNC_VALUE_BE = 2147385345;
    private static final int SYNC_VALUE_LE = -25230976;
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE;

    static {
        int[] nArray;
        int[] nArray2;
        int n10 = 16;
        int[] nArray3 = nArray2 = new int[n10];
        int[] nArray4 = nArray2;
        nArray3[0] = 1;
        nArray4[1] = 2;
        nArray3[2] = 2;
        nArray4[3] = 2;
        nArray3[4] = 2;
        nArray4[5] = 3;
        nArray3[6] = 3;
        nArray4[7] = 4;
        nArray3[8] = 4;
        nArray4[9] = 5;
        nArray3[10] = 6;
        nArray4[11] = 6;
        nArray3[12] = 6;
        nArray4[13] = 7;
        nArray3[14] = 8;
        nArray4[15] = 8;
        CHANNELS_BY_AMODE = nArray2;
        int[] nArray5 = nArray = new int[n10];
        int[] nArray6 = nArray;
        nArray5[0] = -1;
        nArray6[1] = 8000;
        nArray5[2] = 16000;
        nArray6[3] = 32000;
        nArray5[4] = -1;
        nArray6[5] = -1;
        nArray5[6] = 11025;
        nArray6[7] = 22050;
        nArray5[8] = 44100;
        nArray6[9] = -1;
        nArray5[10] = -1;
        nArray6[11] = 12000;
        nArray5[12] = 24000;
        nArray6[13] = 48000;
        nArray5[14] = -1;
        nArray6[15] = -1;
        SAMPLE_RATE_BY_SFREQ = nArray;
        int[] nArray7 = nArray = new int[29];
        int[] nArray8 = nArray;
        nArray7[0] = 64;
        nArray8[1] = 112;
        nArray7[2] = 128;
        nArray8[3] = 192;
        nArray7[4] = 224;
        nArray8[5] = 256;
        nArray7[6] = 384;
        nArray8[7] = 448;
        nArray7[8] = 512;
        nArray8[9] = 640;
        nArray7[10] = 768;
        nArray8[11] = 896;
        nArray7[12] = 1024;
        nArray8[13] = 1152;
        nArray7[14] = 1280;
        nArray8[15] = 1536;
        nArray7[16] = 1920;
        nArray8[17] = 2048;
        nArray7[18] = 2304;
        nArray8[19] = 2560;
        nArray7[20] = 2688;
        nArray8[21] = 2816;
        nArray7[22] = 2823;
        nArray8[23] = 2944;
        nArray7[24] = 3072;
        nArray8[25] = 3840;
        nArray7[26] = 4096;
        nArray8[27] = 6144;
        nArray8[28] = 7680;
        TWICE_BITRATE_KBPS_BY_RATE = nArray;
    }

    private DtsUtil() {
    }

    public static int getDtsFrameSize(byte[] byArray) {
        int n10;
        int n11;
        block6: {
            int n12;
            int n13;
            int n14;
            block4: {
                int n15;
                int n16;
                int n17;
                block1: {
                    block5: {
                        block2: {
                            block3: {
                                n11 = 0;
                                n14 = byArray[0];
                                n17 = -2;
                                n16 = 6;
                                n15 = 7;
                                n13 = 1;
                                n12 = 4;
                                if (n14 == n17) break block1;
                                n17 = -1;
                                if (n14 == n17) break block2;
                                n17 = 31;
                                if (n14 == n17) break block3;
                                n14 = (byArray[5] & 3) << 12;
                                n17 = (byArray[n16] & 0xFF) << n12;
                                n14 |= n17;
                                n10 = byArray[n15];
                                break block4;
                            }
                            n11 = (byArray[n16] & 3) << 12;
                            n14 = (byArray[n15] & 0xFF) << n12;
                            n11 |= n14;
                            n14 = 8;
                            n10 = byArray[n14];
                            break block5;
                        }
                        n11 = (byArray[n15] & 3) << 12;
                        n14 = (byArray[n16] & 0xFF) << n12;
                        n11 |= n14;
                        n14 = 9;
                        n10 = byArray[n14];
                    }
                    n10 = ((n10 & 0x3C) >> 2 | n11) + n13;
                    n11 = n13;
                    break block6;
                }
                n14 = (byArray[n12] & 3) << 12;
                n17 = (byArray[n15] & 0xFF) << n12;
                n14 |= n17;
                n10 = byArray[n16];
            }
            n10 = ((n10 & 0xF0) >> n12 | n14) + n13;
        }
        if (n11 != 0) {
            n10 = n10 * 16 / 14;
        }
        return n10;
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] byArray) {
        int n10;
        ParsableBitArray parsableBitArray;
        byte by2 = 0;
        ParsableBitArray parsableBitArray2 = null;
        int n11 = byArray[0];
        int n12 = 127;
        if (n11 == n12) {
            parsableBitArray2 = new ParsableBitArray(byArray);
            return parsableBitArray2;
        }
        n11 = byArray.length;
        if ((n11 = (int)(DtsUtil.isLittleEndianFrameHeader(byArray = Arrays.copyOf(byArray, n11)) ? 1 : 0)) != 0) {
            parsableBitArray = null;
            for (n11 = 0; n11 < (n12 = byArray.length + -1); n11 += 2) {
                byte by3;
                n12 = byArray[n11];
                n10 = n11 + 1;
                byArray[n11] = by3 = byArray[n10];
                byArray[n10] = n12;
            }
        }
        parsableBitArray = new ParsableBitArray(byArray);
        by2 = byArray[0];
        n12 = 31;
        if (by2 == n12) {
            parsableBitArray2 = new ParsableBitArray(byArray);
            while ((n12 = parsableBitArray2.bitsLeft()) >= (n10 = 16)) {
                parsableBitArray2.skipBits(2);
                n12 = 14;
                n10 = parsableBitArray2.readBits(n12);
                parsableBitArray.putInt(n10, n12);
            }
        }
        parsableBitArray.reset(byArray);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] byArray) {
        byte by2;
        boolean bl2 = false;
        byte by3 = byArray[0];
        byte by4 = -2;
        if (by3 == by4 || (by2 = byArray[0]) == (by3 = -1)) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isSyncWord(int n10) {
        int n11 = 2147385345;
        n10 = n10 != n11 && n10 != (n11 = -25230976) && n10 != (n11 = 536864768) && n10 != (n11 = -14745368) ? 0 : 1;
        return n10 != 0;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int n10;
        int n11;
        block5: {
            block3: {
                int n12;
                block0: {
                    block4: {
                        block1: {
                            block2: {
                                int n13;
                                n12 = byteBuffer.position();
                                n11 = byteBuffer.get(n12);
                                if (n11 == (n13 = -2)) break block0;
                                n13 = -1;
                                if (n11 == n13) break block1;
                                n13 = 31;
                                if (n11 == n13) break block2;
                                n11 = n12 + 4;
                                n11 = (byteBuffer.get(n11) & 1) << 6;
                                n10 = byteBuffer.get(n12 += 5);
                                break block3;
                            }
                            n11 = n12 + 5;
                            n11 = (byteBuffer.get(n11) & 7) << 4;
                            n10 = byteBuffer.get(n12 += 6);
                            break block4;
                        }
                        n11 = n12 + 4;
                        n11 = (byteBuffer.get(n11) & 7) << 4;
                        n10 = byteBuffer.get(n12 += 7);
                    }
                    n10 &= 0x3C;
                    break block5;
                }
                n11 = n12 + 5;
                n11 = (byteBuffer.get(n11) & 1) << 6;
                n10 = byteBuffer.get(n12 += 4);
            }
            n10 &= 0xFC;
        }
        return ((n10 >> 2 | n11) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(byte[] byArray) {
        int n10;
        int n11;
        block5: {
            block3: {
                int n12;
                int n13;
                int n14;
                block0: {
                    block4: {
                        int n15;
                        block1: {
                            block2: {
                                n11 = byArray[0];
                                int n16 = -2;
                                n14 = 6;
                                n13 = 5;
                                n12 = 4;
                                if (n11 == n16) break block0;
                                n16 = -1;
                                n15 = 7;
                                if (n11 == n16) break block1;
                                n16 = 31;
                                if (n11 == n16) break block2;
                                n11 = (byArray[n12] & 1) << n14;
                                n10 = byArray[n13];
                                break block3;
                            }
                            n11 = (byArray[n13] & n15) << n12;
                            n10 = byArray[n14];
                            break block4;
                        }
                        n11 = (byArray[n12] & n15) << n12;
                        n10 = byArray[n15];
                    }
                    n10 &= 0x3C;
                    break block5;
                }
                n11 = (byArray[n13] & 1) << n14;
                n10 = byArray[n12];
            }
            n10 &= 0xFC;
        }
        return ((n10 >> 2 | n11) + 1) * 32;
    }

    public static Format parseDtsFormat(byte[] object, String string2, String string3, DrmInitData drmInitData) {
        object = DtsUtil.getNormalizedFrameHeader((byte[])object);
        ((ParsableBitArray)object).skipBits(60);
        int n10 = ((ParsableBitArray)object).readBits(6);
        int[] nArray = CHANNELS_BY_AMODE;
        n10 = nArray[n10];
        int n11 = ((ParsableBitArray)object).readBits(4);
        int[] nArray2 = SAMPLE_RATE_BY_SFREQ;
        n11 = nArray2[n11];
        int n12 = ((ParsableBitArray)object).readBits(5);
        int[] nArray3 = TWICE_BITRATE_KBPS_BY_RATE;
        int n13 = nArray3.length;
        int n14 = 2;
        n12 = n12 >= n13 ? -1 : nArray3[n12] * 1000 / n14;
        int n15 = 10;
        ((ParsableBitArray)object).skipBits(n15);
        int n16 = ((ParsableBitArray)object).readBits(n14);
        if (n16 > 0) {
            n16 = 1;
        } else {
            n16 = 0;
            object = null;
        }
        object = new Format$Builder();
        return ((Format$Builder)object).setId(string2).setSampleMimeType("audio/vnd.dts").setAverageBitrate(n12).setChannelCount(n10 += n16).setSampleRate(n11).setDrmInitData(drmInitData).setLanguage(string3).build();
    }
}


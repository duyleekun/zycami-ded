/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class Ac4Util {
    public static final int AC40_SYNCWORD = 44096;
    public static final int AC41_SYNCWORD = 44097;
    private static final int CHANNEL_COUNT_2 = 2;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    public static final int MAX_RATE_BYTES_PER_SECOND = 336000;
    private static final int[] SAMPLE_COUNT;
    public static final int SAMPLE_HEADER_SIZE = 7;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[14];
        int[] nArray3 = nArray;
        nArray2[0] = 2002;
        nArray3[1] = 2000;
        nArray2[2] = 1920;
        nArray3[3] = 1601;
        nArray2[4] = 1600;
        nArray3[5] = 1001;
        nArray2[6] = 1000;
        nArray3[7] = 960;
        nArray2[8] = 800;
        nArray3[9] = 800;
        nArray2[10] = 480;
        nArray3[11] = 400;
        nArray2[12] = 400;
        nArray3[13] = 2048;
        SAMPLE_COUNT = nArray;
    }

    private Ac4Util() {
    }

    public static void getAc4SampleHeader(int n10, ParsableByteArray object) {
        ((ParsableByteArray)object).reset(7);
        object = ((ParsableByteArray)object).getData();
        object[0] = -84;
        object[1] = 64;
        int n11 = -1;
        object[2] = n11;
        object[3] = n11;
        byte by2 = (byte)(n10 >> 16 & 0xFF);
        object[4] = by2;
        by2 = (byte)(n10 >> 8 & 0xFF);
        object[5] = by2;
        n10 = (byte)(n10 & 0xFF);
        object[6] = n10;
    }

    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray, String string2, String string3, DrmInitData drmInitData) {
        int n10 = 1;
        parsableByteArray.skipBytes(n10);
        int n11 = (parsableByteArray.readUnsignedByte() & 0x20) >> 5;
        n11 = n11 == n10 ? 48000 : 44100;
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setSampleMimeType("audio/ac4").setChannelCount(2).setSampleRate(n11).setDrmInitData(drmInitData).setLanguage(string3).build();
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer object) {
        byte[] byArray = new byte[16];
        int n10 = ((Buffer)object).position();
        ((ByteBuffer)object).get(byArray);
        ((ByteBuffer)object).position(n10);
        object = new ParsableBitArray(byArray);
        return Ac4Util.parseAc4SyncframeInfo((ParsableBitArray)object).sampleCount;
    }

    public static Ac4Util$SyncFrameInfo parseAc4SyncframeInfo(ParsableBitArray object) {
        float f10;
        int n10;
        int n11;
        float f11;
        int n12;
        int n13;
        int n14;
        block11: {
            int n15;
            block12: {
                int n16;
                block15: {
                    int n17;
                    int n172;
                    block13: {
                        block14: {
                            int[] nArray;
                            float f12;
                            int n18;
                            int n19;
                            int n20;
                            block10: {
                                int n21;
                                n20 = 16;
                                n19 = ((ParsableBitArray)object).readBits(n20);
                                n20 = ((ParsableBitArray)object).readBits(n20);
                                n18 = 4;
                                n172 = -1;
                                if (n20 == n172) {
                                    n20 = ((ParsableBitArray)object).readBits(24);
                                    n172 = 7;
                                } else {
                                    n172 = n18;
                                }
                                n20 += n172;
                                n172 = 44097;
                                if (n19 == n172) {
                                    n20 += 2;
                                }
                                n14 = n20;
                                n20 = 2;
                                n19 = ((ParsableBitArray)object).readBits(n20);
                                if (n19 == (n172 = 3)) {
                                    n13 = Ac4Util.readVariableBits((ParsableBitArray)object, n20);
                                    n19 += n13;
                                }
                                n13 = n19;
                                n19 = ((ParsableBitArray)object).readBits(10);
                                boolean n152 = ((ParsableBitArray)object).readBit();
                                if (n152 && (n21 = ((ParsableBitArray)object).readBits(n172)) > 0) {
                                    ((ParsableBitArray)object).skipBits(n20);
                                }
                                boolean bl2 = ((ParsableBitArray)object).readBit();
                                n12 = 48000;
                                f11 = 6.7262E-41f;
                                n11 = 44100;
                                f12 = 6.1797E-41f;
                                if (bl2) {
                                    n10 = n12;
                                    f10 = f11;
                                } else {
                                    n10 = n11;
                                    f10 = f12;
                                }
                                n17 = ((ParsableBitArray)object).readBits(n18);
                                boolean bl3 = false;
                                if (n10 != n11) break block10;
                                n11 = 13;
                                f12 = 1.8E-44f;
                                if (n17 != n11) break block10;
                                int[] nArray2 = SAMPLE_COUNT;
                                n11 = n17 = nArray2[n17];
                                break block11;
                            }
                            if (n10 != n12 || n17 >= (n11 = (nArray = SAMPLE_COUNT).length)) break block12;
                            n16 = nArray[n17];
                            n12 = 8;
                            f11 = 1.1E-44f;
                            n11 = 1;
                            f12 = Float.MIN_VALUE;
                            if ((n19 %= 5) == n11) break block13;
                            n11 = 11;
                            f12 = 1.5E-44f;
                            if (n19 == n20) break block14;
                            if (n19 == n172) break block13;
                            if (n19 != n18 || n17 != n172 && n17 != n12 && n17 != n11) break block12;
                            break block15;
                        }
                        if (n17 != n12 && n17 != n11) break block12;
                        break block15;
                    }
                    if (n17 != n172 && n17 != n12) break block12;
                }
                n15 = n16 + 1;
            }
            n11 = n15;
        }
        n12 = n10;
        f11 = f10;
        object = new Ac4Util$SyncFrameInfo(n13, 2, n10, n14, n11, null);
        return object;
    }

    public static int parseAc4SyncframeSize(byte[] byArray, int n10) {
        int n11;
        int n12 = byArray.length;
        int n13 = 7;
        if (n12 < n13) {
            return -1;
        }
        n12 = (byArray[2] & 0xFF) << 8;
        int n14 = byArray[3] & 0xFF;
        n12 |= n14;
        n14 = (char)-1;
        int n15 = 4;
        if (n12 == n14) {
            n12 = (byArray[n15] & 0xFF) << 16;
            n14 = (byArray[5] & 0xFF) << 8;
            n12 |= n14;
            n14 = 6;
            n11 = byArray[n14] & 0xFF;
            n12 |= n11;
        } else {
            n13 = n15;
        }
        n11 = 44097;
        if (n10 == n11) {
            n13 += 2;
        }
        return n12 + n13;
    }

    private static int readVariableBits(ParsableBitArray parsableBitArray, int n10) {
        int n11 = 0;
        while (true) {
            int n12 = parsableBitArray.readBits(n10);
            n11 += n12;
            n12 = (int)(parsableBitArray.readBit() ? 1 : 0);
            if (n12 == 0) {
                return n11;
            }
            n11 = n11 + 1 << n10;
        }
    }
}


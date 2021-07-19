/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter;
import com.google.android.exoplayer2.extractor.wav.WavHeader;
import com.google.android.exoplayer2.extractor.wav.WavSeekMap;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class WavExtractor$ImaAdPcmOutputWriter
implements WavExtractor$OutputWriter {
    private static final int[] INDEX_TABLE;
    private static final int[] STEP_TABLE;
    private final ParsableByteArray decodedData;
    private final ExtractorOutput extractorOutput;
    private final Format format;
    private final int framesPerBlock;
    private final WavHeader header;
    private final byte[] inputData;
    private long outputFrameCount;
    private int pendingInputBytes;
    private int pendingOutputBytes;
    private long startTimeUs;
    private final int targetSampleSizeFrames;
    private final TrackOutput trackOutput;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[16];
        int[] nArray3 = nArray;
        nArray2[0] = -1;
        nArray3[1] = -1;
        nArray2[2] = -1;
        nArray3[3] = -1;
        nArray2[4] = 2;
        nArray3[5] = 4;
        nArray2[6] = 6;
        nArray3[7] = 8;
        nArray2[8] = -1;
        nArray3[9] = -1;
        nArray2[10] = -1;
        nArray3[11] = -1;
        nArray2[12] = 2;
        nArray3[13] = 4;
        nArray2[14] = 6;
        nArray3[15] = 8;
        INDEX_TABLE = nArray;
        int[] nArray4 = nArray = new int[89];
        int[] nArray5 = nArray;
        nArray4[0] = 7;
        nArray5[1] = 8;
        nArray4[2] = 9;
        nArray5[3] = 10;
        nArray4[4] = 11;
        nArray5[5] = 12;
        nArray4[6] = 13;
        nArray5[7] = 14;
        nArray4[8] = 16;
        nArray5[9] = 17;
        nArray4[10] = 19;
        nArray5[11] = 21;
        nArray4[12] = 23;
        nArray5[13] = 25;
        nArray4[14] = 28;
        nArray5[15] = 31;
        nArray4[16] = 34;
        nArray5[17] = 37;
        nArray4[18] = 41;
        nArray5[19] = 45;
        nArray4[20] = 50;
        nArray5[21] = 55;
        nArray4[22] = 60;
        nArray5[23] = 66;
        nArray4[24] = 73;
        nArray5[25] = 80;
        nArray4[26] = 88;
        nArray5[27] = 97;
        nArray4[28] = 107;
        nArray5[29] = 118;
        nArray4[30] = 130;
        nArray5[31] = 143;
        nArray4[32] = 157;
        nArray5[33] = 173;
        nArray4[34] = 190;
        nArray5[35] = 209;
        nArray4[36] = 230;
        nArray5[37] = 253;
        nArray4[38] = 279;
        nArray5[39] = 307;
        nArray4[40] = 337;
        nArray5[41] = 371;
        nArray4[42] = 408;
        nArray5[43] = 449;
        nArray4[44] = 494;
        nArray5[45] = 544;
        nArray4[46] = 598;
        nArray5[47] = 658;
        nArray4[48] = 724;
        nArray5[49] = 796;
        nArray4[50] = 876;
        nArray5[51] = 963;
        nArray4[52] = 1060;
        nArray5[53] = 1166;
        nArray4[54] = 1282;
        nArray5[55] = 1411;
        nArray4[56] = 1552;
        nArray5[57] = 1707;
        nArray4[58] = 1878;
        nArray5[59] = 2066;
        nArray4[60] = 2272;
        nArray5[61] = 2499;
        nArray4[62] = 2749;
        nArray5[63] = 3024;
        nArray4[64] = 3327;
        nArray5[65] = 3660;
        nArray4[66] = 4026;
        nArray5[67] = 4428;
        nArray4[68] = 4871;
        nArray5[69] = 5358;
        nArray4[70] = 5894;
        nArray5[71] = 6484;
        nArray4[72] = 7132;
        nArray5[73] = 7845;
        nArray4[74] = 8630;
        nArray5[75] = 9493;
        nArray4[76] = 10442;
        nArray5[77] = 11487;
        nArray4[78] = 12635;
        nArray5[79] = 13899;
        nArray4[80] = 15289;
        nArray5[81] = 16818;
        nArray4[82] = 18500;
        nArray5[83] = 20350;
        nArray4[84] = 22385;
        nArray5[85] = 24623;
        nArray4[86] = 27086;
        nArray5[87] = 29794;
        nArray5[88] = Short.MAX_VALUE;
        STEP_TABLE = nArray;
    }

    public WavExtractor$ImaAdPcmOutputWriter(ExtractorOutput object, TrackOutput object2, WavHeader object3) {
        int n10;
        this.extractorOutput = object;
        this.trackOutput = object2;
        this.header = object3;
        int n11 = ((WavHeader)object3).frameRateHz / 10;
        int n12 = 1;
        this.targetSampleSizeFrames = n11 = Math.max(n12, n11);
        byte[] byArray = ((WavHeader)object3).extraData;
        Object object4 = new ParsableByteArray(byArray);
        ((ParsableByteArray)object4).readLittleEndianUnsignedShort();
        this.framesPerBlock = n10 = ((ParsableByteArray)object4).readLittleEndianUnsignedShort();
        int n13 = ((WavHeader)object3).numChannels;
        int n14 = ((WavHeader)object3).blockSize;
        int n15 = n13 * 4;
        n14 = (n14 - n15) * 8;
        n15 = ((WavHeader)object3).bitsPerSample * n13;
        n14 = n14 / n15 + n12;
        if (n10 == n14) {
            n12 = Util.ceilDivide(n11, n10);
            Object object5 = new byte[((WavHeader)object3).blockSize * n12];
            this.inputData = object5;
            object5 = new ParsableByteArray;
            n15 = WavExtractor$ImaAdPcmOutputWriter.numOutputFramesToBytes(n10, n13);
            super(n12 *= n15);
            this.decodedData = object5;
            n12 = ((WavHeader)object3).frameRateHz;
            n14 = ((WavHeader)object3).blockSize;
            n12 = n12 * n14 * 8 / n10;
            object4 = new Format$Builder();
            object2 = ((Format$Builder)object4).setSampleMimeType("audio/raw").setAverageBitrate(n12).setPeakBitrate(n12);
            n11 = WavExtractor$ImaAdPcmOutputWriter.numOutputFramesToBytes(n11, n13);
            object = ((Format$Builder)object2).setMaxInputSize(n11);
            n12 = ((WavHeader)object3).numChannels;
            object = ((Format$Builder)object).setChannelCount(n12);
            n12 = ((WavHeader)object3).frameRateHz;
            this.format = object = ((Format$Builder)object).setSampleRate(n12).setPcmEncoding(2).build();
            return;
        }
        object3 = new StringBuilder(56);
        ((StringBuilder)object3).append("Expected frames per block: ");
        ((StringBuilder)object3).append(n14);
        ((StringBuilder)object3).append("; got: ");
        ((StringBuilder)object3).append(n10);
        object2 = ((StringBuilder)object3).toString();
        object = new ParserException((String)object2);
        throw object;
    }

    private void decode(byte[] byArray, int n10, ParsableByteArray parsableByteArray) {
        block0: for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = 0;
            while (true) {
                Object object = this.header;
                int n12 = ((WavHeader)object).numChannels;
                if (n11 >= n12) continue block0;
                object = parsableByteArray.getData();
                this.decodeBlockForChannel(byArray, i10, n11, (byte[])object);
                ++n11;
            }
        }
        int n13 = this.framesPerBlock * n10;
        n13 = this.numOutputFramesToBytes(n13);
        parsableByteArray.setPosition(0);
        parsableByteArray.setLimit(n13);
    }

    private void decodeBlockForChannel(byte[] byArray, int n10, int n11, byte[] byArray2) {
        int n12;
        WavHeader wavHeader = this.header;
        int n13 = wavHeader.blockSize;
        int n14 = wavHeader.numChannels;
        int n15 = n10 * n13;
        int n16 = n11 * 4;
        n15 += n16;
        n16 = n14 * 4 + n15;
        n13 = n13 / n14 + -4;
        int n17 = n15 + 1;
        n17 = (byArray[n17] & 0xFF) << 8;
        int n18 = byArray[n15] & 0xFF;
        n17 = (short)(n17 | n18);
        n15 += 2;
        n15 = Math.min(byArray[n15] & 0xFF, 88);
        int[] nArray = STEP_TABLE;
        n18 = nArray[n15];
        int n19 = this.framesPerBlock;
        n10 = (n10 * n19 * n14 + n11) * 2;
        byArray2[n10] = n11 = (int)((byte)(n17 & 0xFF));
        n11 = n10 + 1;
        byArray2[n11] = n19 = (int)((byte)(n17 >> 8));
        n11 = 0;
        for (n19 = 0; n19 < (n12 = n13 * 2); ++n19) {
            n12 = n19 / 8;
            int n20 = n19 / 2 % 4;
            n12 = n12 * n14 * 4 + n16 + n20;
            n12 = byArray[n12] & 0xFF;
            n20 = n19 % 2;
            n12 = n20 == 0 ? (n12 &= 0xF) : (n12 >>= 4);
            n18 = ((n12 & 7) * 2 + 1) * n18 >> 3;
            n20 = n12 & 8;
            if (n20 != 0) {
                n18 = -n18;
            }
            n17 = Util.constrainValue(n17 + n18, Short.MIN_VALUE, Short.MAX_VALUE);
            n18 = n14 * 2;
            n10 += n18;
            byArray2[n10] = n18 = (int)((byte)(n17 & 0xFF));
            n18 = n10 + 1;
            byArray2[n18] = n20 = (int)((byte)(n17 >> 8));
            n18 = INDEX_TABLE[n12];
            n15 += n18;
            nArray = STEP_TABLE;
            n12 = nArray.length + -1;
            n15 = Util.constrainValue(n15, 0, n12);
            n18 = nArray[n15];
        }
    }

    private int numOutputBytesToFrames(int n10) {
        int n11 = this.header.numChannels * 2;
        return n10 / n11;
    }

    private int numOutputFramesToBytes(int n10) {
        int n11 = this.header.numChannels;
        return WavExtractor$ImaAdPcmOutputWriter.numOutputFramesToBytes(n10, n11);
    }

    private static int numOutputFramesToBytes(int n10, int n11) {
        return n10 * 2 * n11;
    }

    private void writeSampleMetadata(int n10) {
        long l10 = this.startTimeUs;
        long l11 = this.outputFrameCount;
        long l12 = this.header.frameRateHz;
        l11 = Util.scaleLargeTimestamp(l11, 1000000L, l12);
        long l13 = l10 + l11;
        int n11 = this.numOutputFramesToBytes(n10);
        int n12 = this.pendingOutputBytes - n11;
        this.trackOutput.sampleMetadata(l13, 1, n11, n12, null);
        long l14 = this.outputFrameCount;
        long l15 = n10;
        this.outputFrameCount = l14 += l15;
        this.pendingOutputBytes = n10 = this.pendingOutputBytes - n11;
    }

    public void init(int n10, long l10) {
        ExtractorOutput extractorOutput = this.extractorOutput;
        WavHeader wavHeader = this.header;
        int n11 = this.framesPerBlock;
        long l11 = n10;
        WavSeekMap wavSeekMap = new WavSeekMap(wavHeader, n11, l11, l10);
        extractorOutput.seekMap(wavSeekMap);
        TrackOutput trackOutput = this.trackOutput;
        Format format = this.format;
        trackOutput.format(format);
    }

    public void reset(long l10) {
        this.pendingInputBytes = 0;
        this.startTimeUs = l10;
        this.pendingOutputBytes = 0;
        this.outputFrameCount = 0L;
    }

    /*
     * Unable to fully structure code
     */
    public boolean sampleData(ExtractorInput var1_1, long var2_2) {
        var4_3 = this.targetSampleSizeFrames;
        var5_4 = this.pendingOutputBytes;
        var5_4 = this.numOutputBytesToFrames(var5_4);
        var4_3 -= var5_4;
        var5_4 = this.framesPerBlock;
        var4_3 = Util.ceilDivide(var4_3, var5_4);
        var6_5 = this.header;
        var5_4 = var6_5.blockSize;
        var4_3 *= var5_4;
        var7_6 = 0L;
        var5_4 = (int)(var2_2 == var7_6 ? 0 : (var2_2 < var7_6 ? -1 : 1));
        var9_7 = 1;
        if (var5_4 == 0) {
            while (true) {
                var5_4 = var9_7;
                break;
            }
        } else {
            var5_4 = 0;
            var6_5 = null;
        }
        while (var5_4 == 0 && (var10_8 = this.pendingInputBytes) < var4_3) {
            var11_9 = Math.min((long)(var4_3 - var10_8), var2_2);
            var10_8 = (int)var11_9;
            if ((var10_8 = var1_1.read(var13_10 = this.inputData, var14_11 = this.pendingInputBytes, var10_8)) == (var15_12 = -1)) ** continue;
            this.pendingInputBytes = var15_12 = this.pendingInputBytes + var10_8;
        }
        var16_13 = this.pendingInputBytes;
        var17_14 = this.header;
        var18_15 = var17_14.blockSize;
        if ((var16_13 /= var18_15) > 0) {
            var17_14 = this.inputData;
            var19_16 = this.decodedData;
            this.decode((byte[])var17_14, var16_13, var19_16);
            var18_15 = this.pendingInputBytes;
            var20_17 = this.header.blockSize;
            this.pendingInputBytes = var18_15 -= (var16_13 *= var20_17);
            var1_1 = this.decodedData;
            var16_13 = var1_1.limit();
            var17_14 = this.trackOutput;
            var19_16 = this.decodedData;
            var17_14.sampleData(var19_16, var16_13);
            this.pendingOutputBytes = var18_15 = this.pendingOutputBytes + var16_13;
            var16_13 = this.numOutputBytesToFrames(var18_15);
            var18_15 = this.targetSampleSizeFrames;
            if (var16_13 >= var18_15) {
                this.writeSampleMetadata(var18_15);
            }
        }
        if (var5_4 != 0) {
            var16_13 = this.pendingOutputBytes;
            if ((var16_13 = this.numOutputBytesToFrames(var16_13)) > 0) {
                this.writeSampleMetadata(var16_13);
            }
        }
        return (boolean)var5_4;
    }
}


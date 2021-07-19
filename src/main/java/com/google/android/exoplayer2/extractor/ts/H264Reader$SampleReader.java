/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData;
import com.google.android.exoplayer2.util.NalUnitUtil$PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil$SpsData;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Arrays;

public final class H264Reader$SampleReader {
    private static final int DEFAULT_BUFFER_SIZE = 128;
    private static final int NAL_UNIT_TYPE_AUD = 9;
    private static final int NAL_UNIT_TYPE_IDR = 5;
    private static final int NAL_UNIT_TYPE_NON_IDR = 1;
    private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
    private final boolean allowNonIdrKeyframes;
    private final ParsableNalUnitBitArray bitArray;
    private byte[] buffer;
    private int bufferLength;
    private final boolean detectAccessUnits;
    private boolean isFilling;
    private long nalUnitStartPosition;
    private long nalUnitTimeUs;
    private int nalUnitType;
    private final TrackOutput output;
    private final SparseArray pps;
    private H264Reader$SampleReader$SliceHeaderData previousSliceHeader;
    private boolean readingSample;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private H264Reader$SampleReader$SliceHeaderData sliceHeader;
    private final SparseArray sps;

    public H264Reader$SampleReader(TrackOutput object, boolean bl2, boolean bl3) {
        ParsableNalUnitBitArray parsableNalUnitBitArray;
        this.output = object;
        this.allowNonIdrKeyframes = bl2;
        this.detectAccessUnits = bl3;
        this.sps = object;
        super();
        this.pps = object;
        this.previousSliceHeader = object = new H264Reader$SampleReader$SliceHeaderData(null);
        this.sliceHeader = object = new H264Reader$SampleReader$SliceHeaderData(null);
        object = new byte[128];
        this.buffer = (byte[])object;
        this.bitArray = parsableNalUnitBitArray = new ParsableNalUnitBitArray((byte[])object, 0, 0);
        this.reset();
    }

    private void outputSample(int n10) {
        int n11 = this.sampleIsKeyframe;
        long l10 = this.nalUnitStartPosition;
        long l11 = this.samplePosition;
        int n12 = (int)(l10 - l11);
        TrackOutput trackOutput = this.output;
        long l12 = this.sampleTimeUs;
        trackOutput.sampleMetadata(l12, n11, n12, n10, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void appendToNalUnit(byte[] var1_1, int var2_2, int var3_3) {
        block28: {
            block29: {
                block26: {
                    block27: {
                        block24: {
                            block25: {
                                var4_4 = this;
                                var5_5 = var2_2;
                                var6_6 = this.isFilling;
                                if (var6_6 == 0) {
                                    return;
                                }
                                var6_6 = var3_3 - var2_2;
                                var7_7 = this.buffer;
                                var8_8 = ((byte[])var7_7).length;
                                var9_9 = this.bufferLength;
                                var10_10 = var9_9 + var6_6;
                                var11_11 = 2;
                                if (var8_8 < var10_10) {
                                    var9_9 = (var9_9 + var6_6) * var11_11;
                                    var7_7 = Arrays.copyOf((byte[])var7_7, var9_9);
                                    this.buffer = var7_7;
                                }
                                var7_7 = var4_4.buffer;
                                var8_8 = var4_4.bufferLength;
                                System.arraycopy(var1_1, var5_5, var7_7, var8_8, var6_6);
                                var4_4.bufferLength = var5_5 = var4_4.bufferLength + var6_6;
                                var12_12 = var4_4.bitArray;
                                var7_7 = var4_4.buffer;
                                var8_8 = 0;
                                var12_12.reset((byte[])var7_7, 0, var5_5);
                                var13_13 = var4_4.bitArray;
                                var6_6 = 8;
                                var5_5 = (int)var13_13.canReadBits(var6_6);
                                if (var5_5 == 0) {
                                    return;
                                }
                                var4_4.bitArray.skipBit();
                                var14_14 = var4_4.bitArray.readBits(var11_11);
                                var13_13 = var4_4.bitArray;
                                var6_6 = 5;
                                var13_13.skipBits(var6_6);
                                var13_13 = var4_4.bitArray;
                                var5_5 = (int)var13_13.canReadExpGolombCodedNum();
                                if (var5_5 == 0) {
                                    return;
                                }
                                var4_4.bitArray.readUnsignedExpGolombCodedInt();
                                var13_13 = var4_4.bitArray;
                                var5_5 = (int)var13_13.canReadExpGolombCodedNum();
                                if (var5_5 == 0) {
                                    return;
                                }
                                var13_13 = var4_4.bitArray;
                                var15_15 = var13_13.readUnsignedExpGolombCodedInt();
                                var5_5 = (int)var4_4.detectAccessUnits;
                                if (var5_5 == 0) {
                                    var4_4.isFilling = false;
                                    var4_4.sliceHeader.setSliceType(var15_15);
                                    return;
                                }
                                var13_13 = var4_4.bitArray;
                                var5_5 = (int)var13_13.canReadExpGolombCodedNum();
                                if (var5_5 == 0) {
                                    return;
                                }
                                var13_13 = var4_4.pps;
                                var16_16 = var4_4.bitArray.readUnsignedExpGolombCodedInt();
                                var5_5 = var13_13.indexOfKey(var16_16);
                                if (var5_5 < 0) {
                                    var4_4.isFilling = false;
                                    return;
                                }
                                var13_13 = (NalUnitUtil$PpsData)var4_4.pps.get(var16_16);
                                var7_7 = var4_4.sps;
                                var9_9 = var13_13.seqParameterSetId;
                                var7_7 = var7_7.get(var9_9);
                                var17_17 /* !! */  = var7_7;
                                var17_17 /* !! */  = (byte[])((NalUnitUtil$SpsData)var7_7);
                                var18_18 = var17_17 /* !! */ .separateColorPlaneFlag;
                                if (var18_18 != 0) {
                                    var7_7 = var4_4.bitArray;
                                    var18_18 = var7_7.canReadBits(var11_11);
                                    if (var18_18 == 0) {
                                        return;
                                    }
                                    var7_7 = var4_4.bitArray;
                                    var7_7.skipBits(var11_11);
                                }
                                if ((var18_18 = (var7_7 = (Object)var4_4.bitArray).canReadBits(var9_9 = var17_17 /* !! */ .frameNumLength)) == 0) {
                                    return;
                                }
                                var7_7 = var4_4.bitArray;
                                var9_9 = var17_17 /* !! */ .frameNumLength;
                                var19_19 = var7_7.readBits(var9_9);
                                var18_18 = var17_17 /* !! */ .frameMbsOnlyFlag;
                                var9_9 = 1;
                                if (var18_18 != 0) break block24;
                                var7_7 = var4_4.bitArray;
                                var18_18 = var7_7.canReadBits(var9_9);
                                if (var18_18 == 0) {
                                    return;
                                }
                                var7_7 = var4_4.bitArray;
                                var18_18 = (int)var7_7.readBit();
                                if (var18_18 == 0) break block25;
                                var20_20 = var4_4.bitArray;
                                var10_10 = (int)var20_20.canReadBits(var9_9);
                                if (!var10_10) {
                                    return;
                                }
                                var20_20 = var4_4.bitArray;
                                var10_10 = (int)var20_20.readBit();
                                var21_21 = var18_18;
                                var22_22 = var9_9;
                                var23_23 = var10_10;
                                break block26;
                            }
                            var21_21 = var18_18;
                            var22_22 = 0;
                            break block27;
                        }
                        var21_21 = 0;
                        var22_22 = 0;
                    }
                    var23_23 = 0;
                }
                var18_18 = var4_4.nalUnitType;
                var24_24 = var18_18 == var6_6 ? var9_9 : 0;
                if (var24_24 != 0) {
                    var12_12 = var4_4.bitArray;
                    var6_6 = (int)var12_12.canReadExpGolombCodedNum();
                    if (var6_6 == 0) {
                        return;
                    }
                    var12_12 = var4_4.bitArray;
                    var25_25 = var6_6 = var12_12.readUnsignedExpGolombCodedInt();
                } else {
                    var25_25 = 0;
                }
                var6_6 = var17_17 /* !! */ .picOrderCountType;
                if (var6_6 != 0) break block28;
                var12_12 = var4_4.bitArray;
                var18_18 = var17_17 /* !! */ .picOrderCntLsbLength;
                var6_6 = (int)var12_12.canReadBits(var18_18);
                if (var6_6 == 0) {
                    return;
                }
                var12_12 = var4_4.bitArray;
                var18_18 = var17_17 /* !! */ .picOrderCntLsbLength;
                var6_6 = var12_12.readBits(var18_18);
                var5_5 = (int)var13_13.bottomFieldPicOrderInFramePresentFlag;
                if (var5_5 == 0 || var21_21 != 0) break block29;
                var13_13 = var4_4.bitArray;
                var5_5 = (int)var13_13.canReadExpGolombCodedNum();
                if (var5_5 == 0) {
                    return;
                }
                var13_13 = var4_4.bitArray;
                var26_26 = var5_5 = var13_13.readSignedExpGolombCodedInt();
                var27_27 = var6_6;
                var28_28 = 0;
                ** GOTO lbl174
            }
            var27_27 = var6_6;
            var26_26 = 0;
            ** GOTO lbl173
        }
        if (var6_6 == var9_9 && (var6_6 = (int)var17_17 /* !! */ .deltaPicOrderAlwaysZeroFlag) == 0) {
            var12_12 = var4_4.bitArray;
            var6_6 = (int)var12_12.canReadExpGolombCodedNum();
            if (var6_6 == 0) {
                return;
            }
            var12_12 = var4_4.bitArray;
            var6_6 = var12_12.readSignedExpGolombCodedInt();
            var5_5 = (int)var13_13.bottomFieldPicOrderInFramePresentFlag;
            if (var5_5 != 0 && var21_21 == 0) {
                var13_13 = var4_4.bitArray;
                var5_5 = (int)var13_13.canReadExpGolombCodedNum();
                if (var5_5 == 0) {
                    return;
                }
                var13_13 = var4_4.bitArray;
                var29_29 = var5_5 = var13_13.readSignedExpGolombCodedInt();
                var28_28 = var6_6;
                var27_27 = 0;
                var26_26 = 0;
            } else {
                var28_28 = var6_6;
                var27_27 = 0;
                var26_26 = 0;
                var29_29 = 0;
            }
        } else {
            var27_27 = 0;
            var26_26 = 0;
lbl173:
            // 2 sources

            var28_28 = 0;
lbl174:
            // 2 sources

            var29_29 = 0;
        }
        var4_4.sliceHeader.setAll((NalUnitUtil$SpsData)var17_17 /* !! */ , var14_14, var15_15, var19_19, var16_16, (boolean)var21_21, (boolean)var22_22, (boolean)var23_23, (boolean)var24_24, var25_25, var27_27, var26_26, var28_28, var29_29);
        var4_4.isFilling = false;
    }

    public boolean endNalUnit(long l10, int n10, boolean bl2, boolean bl3) {
        int n11;
        H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData;
        H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData2;
        int n12 = this.nalUnitType;
        int n13 = 0;
        int n14 = 1;
        int n15 = 9;
        if (n12 == n15 || (n12 = (int)(this.detectAccessUnits ? 1 : 0)) != 0 && (n12 = (int)(H264Reader$SampleReader$SliceHeaderData.access$100(h264Reader$SampleReader$SliceHeaderData2 = this.sliceHeader, h264Reader$SampleReader$SliceHeaderData = this.previousSliceHeader) ? 1 : 0)) != 0) {
            if (bl2 && (bl2 = this.readingSample)) {
                long l11 = this.nalUnitStartPosition;
                n11 = (int)(l10 -= l11);
                this.outputSample(n10 += n11);
            }
            this.samplePosition = l10 = this.nalUnitStartPosition;
            this.sampleTimeUs = l10 = this.nalUnitTimeUs;
            this.sampleIsKeyframe = false;
            this.readingSample = n14;
        }
        if ((n11 = this.allowNonIdrKeyframes) != 0) {
            H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData3 = this.sliceHeader;
            bl3 = h264Reader$SampleReader$SliceHeaderData3.isISlice();
        }
        n11 = this.sampleIsKeyframe;
        int n16 = this.nalUnitType;
        n10 = 5;
        if (n16 == n10 || bl3 && n16 == n14) {
            n13 = n14;
        }
        this.sampleIsKeyframe = n11 |= n13;
        return n11 != 0;
    }

    public boolean needsSpsPps() {
        return this.detectAccessUnits;
    }

    public void putPps(NalUnitUtil$PpsData nalUnitUtil$PpsData) {
        SparseArray sparseArray = this.pps;
        int n10 = nalUnitUtil$PpsData.picParameterSetId;
        sparseArray.append(n10, (Object)nalUnitUtil$PpsData);
    }

    public void putSps(NalUnitUtil$SpsData nalUnitUtil$SpsData) {
        SparseArray sparseArray = this.sps;
        int n10 = nalUnitUtil$SpsData.seqParameterSetId;
        sparseArray.append(n10, (Object)nalUnitUtil$SpsData);
    }

    public void reset() {
        this.isFilling = false;
        this.readingSample = false;
        this.sliceHeader.clear();
    }

    public void startNalUnit(long l10, int n10, long l11) {
        this.nalUnitType = n10;
        this.nalUnitTimeUs = l11;
        this.nalUnitStartPosition = l10;
        int n11 = this.allowNonIdrKeyframes;
        int n12 = 1;
        if (n11 != 0 && n10 == n12 || (n11 = this.detectAccessUnits) != 0 && (n10 == (n11 = 5) || n10 == n12 || n10 == (n11 = 2))) {
            H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData;
            H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData2 = this.previousSliceHeader;
            this.previousSliceHeader = h264Reader$SampleReader$SliceHeaderData = this.sliceHeader;
            this.sliceHeader = h264Reader$SampleReader$SliceHeaderData2;
            h264Reader$SampleReader$SliceHeaderData2.clear();
            n11 = 0;
            h264Reader$SampleReader$SliceHeaderData2 = null;
            this.bufferLength = 0;
            this.isFilling = n12;
        }
    }
}


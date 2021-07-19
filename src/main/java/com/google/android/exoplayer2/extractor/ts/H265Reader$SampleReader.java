/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.TrackOutput;

public final class H265Reader$SampleReader {
    private static final int FIRST_SLICE_FLAG_OFFSET = 2;
    private boolean isFirstPrefixNalUnit;
    private boolean isFirstSlice;
    private boolean lookingForFirstSliceFlag;
    private int nalUnitBytesRead;
    private boolean nalUnitHasKeyframeData;
    private long nalUnitPosition;
    private long nalUnitTimeUs;
    private final TrackOutput output;
    private boolean readingPrefix;
    private boolean readingSample;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;

    public H265Reader$SampleReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    private static boolean isPrefixNalUnit(int n10) {
        int n11 = 32;
        n10 = n11 <= n10 && n10 <= (n11 = 35) || n10 == (n11 = 39) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean isVclBodyNalUnit(int n10) {
        int n11 = 32;
        n10 = n10 >= n11 && n10 != (n11 = 40) ? 0 : 1;
        return n10 != 0;
    }

    private void outputSample(int n10) {
        int n11 = this.sampleIsKeyframe;
        long l10 = this.nalUnitPosition;
        long l11 = this.samplePosition;
        int n12 = (int)(l10 - l11);
        TrackOutput trackOutput = this.output;
        long l12 = this.sampleTimeUs;
        trackOutput.sampleMetadata(l12, n11, n12, n10, null);
    }

    public void endNalUnit(long l10, int n10, boolean bl2) {
        boolean bl3 = this.readingPrefix;
        if (bl3 && (bl3 = this.isFirstSlice)) {
            boolean bl4;
            this.sampleIsKeyframe = bl4 = this.nalUnitHasKeyframeData;
            bl4 = false;
            this.readingPrefix = false;
        } else {
            bl3 = this.isFirstPrefixNalUnit;
            if (bl3 || (bl3 = this.isFirstSlice)) {
                int n11;
                if (bl2 && (bl2 = this.readingSample)) {
                    long l11 = this.nalUnitPosition;
                    n11 = (int)(l10 -= l11);
                    this.outputSample(n10 += n11);
                }
                this.samplePosition = l10 = this.nalUnitPosition;
                this.sampleTimeUs = l10 = this.nalUnitTimeUs;
                n11 = (int)(this.nalUnitHasKeyframeData ? 1 : 0);
                this.sampleIsKeyframe = n11;
                n11 = 1;
                this.readingSample = n11;
            }
        }
    }

    public void readNalUnitData(byte[] byArray, int n10, int n11) {
        int n12 = this.lookingForFirstSliceFlag;
        if (n12 != 0) {
            n12 = n10 + 2;
            int n13 = this.nalUnitBytesRead;
            if ((n12 -= n13) < n11) {
                int n14 = byArray[n12] & 0x80;
                n10 = 0;
                if (n14 != 0) {
                    n14 = 1;
                } else {
                    n14 = 0;
                    byArray = null;
                }
                this.isFirstSlice = n14;
                this.lookingForFirstSliceFlag = false;
            } else {
                this.nalUnitBytesRead = n13 += (n11 -= n10);
            }
        }
    }

    public void reset() {
        this.lookingForFirstSliceFlag = false;
        this.isFirstSlice = false;
        this.isFirstPrefixNalUnit = false;
        this.readingSample = false;
        this.readingPrefix = false;
    }

    public void startNalUnit(long l10, int n10, int n11, long l11, boolean bl2) {
        int n12 = 0;
        this.isFirstSlice = false;
        this.isFirstPrefixNalUnit = false;
        this.nalUnitTimeUs = l11;
        this.nalUnitBytesRead = 0;
        this.nalUnitPosition = l10;
        int n13 = H265Reader$SampleReader.isVclBodyNalUnit(n11);
        int n14 = 1;
        if (n13 == 0) {
            n13 = (int)(this.readingSample ? 1 : 0);
            if (n13 != 0 && (n13 = (int)(this.readingPrefix ? 1 : 0)) == 0) {
                if (bl2) {
                    this.outputSample(n10);
                }
                this.readingSample = false;
            }
            if ((n13 = (int)(H265Reader$SampleReader.isPrefixNalUnit(n11) ? 1 : 0)) != 0) {
                n13 = this.readingPrefix ^ n14;
                this.isFirstPrefixNalUnit = n13;
                this.readingPrefix = n14;
            }
        }
        n13 = n11 >= (n13 = 16) && n11 <= (n13 = 21) ? n14 : 0;
        this.nalUnitHasKeyframeData = n13;
        if (n13 != 0 || n11 <= (n13 = 9)) {
            n12 = n14;
        }
        this.lookingForFirstSliceFlag = n12;
    }
}


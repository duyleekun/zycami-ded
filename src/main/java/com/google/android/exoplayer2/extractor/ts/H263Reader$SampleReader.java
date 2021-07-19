/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.TrackOutput;

public final class H263Reader$SampleReader {
    private static final int OFFSET_VOP_CODING_TYPE = 1;
    private static final int VOP_CODING_TYPE_INTRA;
    private boolean lookingForVopCodingType;
    private final TrackOutput output;
    private boolean readingSample;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private int startCodeValue;
    private int vopBytesRead;

    public H263Reader$SampleReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public void onData(byte[] byArray, int n10, int n11) {
        int n12 = this.lookingForVopCodingType;
        if (n12 != 0) {
            n12 = n10 + 1;
            int n13 = this.vopBytesRead;
            if ((n12 -= n13) < n11) {
                int n14 = (byArray[n12] & 0xC0) >> 6;
                n10 = 0;
                if (n14 == 0) {
                    n14 = 1;
                } else {
                    n14 = 0;
                    byArray = null;
                }
                this.sampleIsKeyframe = n14;
                this.lookingForVopCodingType = false;
            } else {
                this.vopBytesRead = n13 += (n11 -= n10);
            }
        }
    }

    public void onDataEnd(long l10, int n10, boolean n11) {
        int n12 = this.startCodeValue;
        int n13 = 182;
        if (n12 == n13 && n11 != 0 && (n11 = (int)(this.readingSample ? 1 : 0)) != 0) {
            long l11 = this.samplePosition;
            l11 = l10 - l11;
            int n14 = (int)l11;
            int n15 = this.sampleIsKeyframe;
            TrackOutput trackOutput = this.output;
            long l12 = this.sampleTimeUs;
            trackOutput.sampleMetadata(l12, n15, n14, n10, null);
        }
        if ((n10 = this.startCodeValue) != (n11 = 179)) {
            this.samplePosition = l10;
        }
    }

    public void onStartCode(int n10, long l10) {
        int n11;
        this.startCodeValue = n10;
        this.sampleIsKeyframe = false;
        int n12 = 1;
        int n13 = 182;
        n11 = n10 != n13 && n10 != (n11 = 179) ? 0 : n12;
        this.readingSample = n11;
        if (n10 != n13) {
            n12 = 0;
        }
        this.lookingForVopCodingType = n12;
        this.vopBytesRead = 0;
        this.sampleTimeUs = l10;
    }

    public void reset() {
        this.readingSample = false;
        this.lookingForVopCodingType = false;
        this.sampleIsKeyframe = false;
        this.startCodeValue = -1;
    }
}


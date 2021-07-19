/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata$SeekTable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class FlacSeekTableSeekMap
implements SeekMap {
    private final long firstFrameOffset;
    private final FlacStreamMetadata flacStreamMetadata;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long l10) {
        this.flacStreamMetadata = flacStreamMetadata;
        this.firstFrameOffset = l10;
    }

    private SeekPoint getSeekPoint(long l10, long l11) {
        l10 *= 1000000L;
        long l12 = this.flacStreamMetadata.sampleRate;
        l10 /= l12;
        l12 = this.firstFrameOffset + l11;
        SeekPoint seekPoint = new SeekPoint(l10, l12);
        return seekPoint;
    }

    public long getDurationUs() {
        return this.flacStreamMetadata.getDurationUs();
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Assertions.checkStateNotNull(this.flacStreamMetadata.seekTable);
        FlacStreamMetadata flacStreamMetadata = this.flacStreamMetadata;
        Object object = flacStreamMetadata.seekTable;
        long[] lArray = ((FlacStreamMetadata$SeekTable)object).pointSampleNumbers;
        object = ((FlacStreamMetadata$SeekTable)object).pointOffsets;
        long l11 = flacStreamMetadata.getSampleNumber(l10);
        int n10 = 1;
        int n11 = Util.binarySearchFloor(lArray, l11, n10 != 0, false);
        long l12 = 0L;
        int n12 = -1;
        long l13 = n11 == n12 ? l12 : lArray[n11];
        if (n11 != n12) {
            l12 = (long)object[n11];
        }
        SeekPoint seekPoint = this.getSeekPoint(l13, l12);
        long l14 = seekPoint.timeUs;
        long l15 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1);
        if (l15 != false && n11 != (l15 = (long)(lArray.length - n10))) {
            l10 = lArray[n11 += n10];
            Object object2 = object[n11];
            SeekPoint seekPoint2 = this.getSeekPoint(l10, (long)object2);
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint, seekPoint2);
            return seekMap$SeekPoints;
        }
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public boolean isSeekable() {
        return true;
    }
}


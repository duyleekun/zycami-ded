/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.wav.WavHeader;
import com.google.android.exoplayer2.util.Util;

public final class WavSeekMap
implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavHeader wavHeader;

    public WavSeekMap(WavHeader wavHeader, int n10, long l10, long l11) {
        this.wavHeader = wavHeader;
        this.framesPerBlock = n10;
        this.firstBlockPosition = l10;
        l11 -= l10;
        long l12 = wavHeader.blockSize;
        this.blockCount = l11 /= l12;
        this.durationUs = l12 = this.blockIndexToTimeUs(l11);
    }

    private long blockIndexToTimeUs(long l10) {
        long l11 = this.framesPerBlock;
        long l12 = l10 * l11;
        long l13 = this.wavHeader.frameRateHz;
        return Util.scaleLargeTimestamp(l12, 1000000L, l13);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        long l11;
        WavHeader wavHeader = this.wavHeader;
        int n10 = wavHeader.frameRateHz;
        long l12 = (long)n10 * l10;
        int n11 = this.framesPerBlock;
        long l13 = (long)n11 * 1000000L;
        long l14 = l12 / l13;
        l12 = this.blockCount;
        l13 = 1L;
        long l15 = l12 - l13;
        l12 = Util.constrainValue(l14, 0L, l15);
        l14 = this.firstBlockPosition;
        WavHeader wavHeader2 = this.wavHeader;
        int n12 = wavHeader2.blockSize;
        long l16 = (long)n12 * l12;
        l14 += l16;
        l16 = this.blockIndexToTimeUs(l12);
        SeekPoint seekPoint = new SeekPoint(l16, l14);
        Object object = l16 == l10 ? 0 : (l16 < l10 ? -1 : 1);
        if (object < 0 && (object = (l11 = l12 - (l10 = this.blockCount - l13)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l12 += l13;
            l10 = this.firstBlockPosition;
            l13 = (long)this.wavHeader.blockSize * l12;
            l12 = this.blockIndexToTimeUs(l12);
            SeekPoint seekPoint2 = new SeekPoint(l12, l10 += l13);
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


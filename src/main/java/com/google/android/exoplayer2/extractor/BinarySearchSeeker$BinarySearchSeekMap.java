/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekOperationParams;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;

public class BinarySearchSeeker$BinarySearchSeekMap
implements SeekMap {
    private final long approxBytesPerFrame;
    private final long ceilingBytePosition;
    private final long ceilingTimePosition;
    private final long durationUs;
    private final long floorBytePosition;
    private final long floorTimePosition;
    private final BinarySearchSeeker$SeekTimestampConverter seekTimestampConverter;

    public BinarySearchSeeker$BinarySearchSeekMap(BinarySearchSeeker$SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter, long l10, long l11, long l12, long l13, long l14, long l15) {
        this.seekTimestampConverter = binarySearchSeeker$SeekTimestampConverter;
        this.durationUs = l10;
        this.floorTimePosition = l11;
        this.ceilingTimePosition = l12;
        this.floorBytePosition = l13;
        this.ceilingBytePosition = l14;
        this.approxBytesPerFrame = l15;
    }

    public static /* synthetic */ long access$1000(BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap) {
        return binarySearchSeeker$BinarySearchSeekMap.floorTimePosition;
    }

    public static /* synthetic */ long access$1100(BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap) {
        return binarySearchSeeker$BinarySearchSeekMap.ceilingTimePosition;
    }

    public static /* synthetic */ long access$1200(BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap) {
        return binarySearchSeeker$BinarySearchSeekMap.floorBytePosition;
    }

    public static /* synthetic */ long access$1300(BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap) {
        return binarySearchSeeker$BinarySearchSeekMap.ceilingBytePosition;
    }

    public static /* synthetic */ long access$1400(BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap) {
        return binarySearchSeeker$BinarySearchSeekMap.approxBytesPerFrame;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        long l11 = this.seekTimestampConverter.timeUsToTargetTime(l10);
        long l12 = this.floorTimePosition;
        long l13 = this.ceilingTimePosition;
        long l14 = this.floorBytePosition;
        long l15 = this.ceilingBytePosition;
        long l16 = this.approxBytesPerFrame;
        long l17 = BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(l11, l12, l13, l14, l15, l16);
        SeekPoint seekPoint = new SeekPoint(l10, l17);
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public boolean isSeekable() {
        return true;
    }

    public long timeUsToTargetTime(long l10) {
        return this.seekTimestampConverter.timeUsToTargetTime(l10);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;

public class BinarySearchSeeker$SeekOperationParams {
    private final long approxBytesPerFrame;
    private long ceilingBytePosition;
    private long ceilingTimePosition;
    private long floorBytePosition;
    private long floorTimePosition;
    private long nextSearchBytePosition;
    private final long seekTimeUs;
    private final long targetTimePosition;

    public BinarySearchSeeker$SeekOperationParams(long l10, long l11, long l12, long l13, long l14, long l15, long l16) {
        this.seekTimeUs = l10;
        this.targetTimePosition = l11;
        this.floorTimePosition = l12;
        this.ceilingTimePosition = l13;
        this.floorBytePosition = l14;
        this.ceilingBytePosition = l15;
        this.approxBytesPerFrame = l16;
        this.nextSearchBytePosition = l10 = BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(l11, l12, l13, l14, l15, l16);
    }

    public static /* synthetic */ long access$000(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams) {
        return binarySearchSeeker$SeekOperationParams.getSeekTimeUs();
    }

    public static /* synthetic */ long access$100(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams) {
        return binarySearchSeeker$SeekOperationParams.getFloorBytePosition();
    }

    public static /* synthetic */ long access$200(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams) {
        return binarySearchSeeker$SeekOperationParams.getCeilingBytePosition();
    }

    public static /* synthetic */ long access$300(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams) {
        return binarySearchSeeker$SeekOperationParams.getNextSearchBytePosition();
    }

    public static /* synthetic */ long access$400(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams) {
        return binarySearchSeeker$SeekOperationParams.getTargetTimePosition();
    }

    public static /* synthetic */ void access$800(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams, long l10, long l11) {
        binarySearchSeeker$SeekOperationParams.updateSeekCeiling(l10, l11);
    }

    public static /* synthetic */ void access$900(BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams, long l10, long l11) {
        binarySearchSeeker$SeekOperationParams.updateSeekFloor(l10, l11);
    }

    public static long calculateNextSearchBytePosition(long l10, long l11, long l12, long l13, long l14, long l15) {
        long l16;
        long l17 = 1L;
        long l18 = l13 + l17;
        long l19 = l18 - l14;
        Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object < 0 && (object = (l16 = (l18 = l11 + l17) - l12) == 0L ? 0 : (l16 < 0L ? -1 : 1)) < 0) {
            l18 = l10 - l11;
            float f10 = l14 - l13;
            float f11 = l12 - l11;
            l18 = (long)((float)l18 * (f10 /= f11));
            long l20 = l18 / (long)20;
            l18 = l18 + l13 - l15 - l20;
            l17 = l14 - l17;
            l10 = l18;
            l11 = l13;
            l12 = l17;
            return Util.constrainValue(l18, l13, l17);
        }
        return l13;
    }

    private long getCeilingBytePosition() {
        return this.ceilingBytePosition;
    }

    private long getFloorBytePosition() {
        return this.floorBytePosition;
    }

    private long getNextSearchBytePosition() {
        return this.nextSearchBytePosition;
    }

    private long getSeekTimeUs() {
        return this.seekTimeUs;
    }

    private long getTargetTimePosition() {
        return this.targetTimePosition;
    }

    private void updateNextSearchBytePosition() {
        long l10 = this.targetTimePosition;
        long l11 = this.floorTimePosition;
        long l12 = this.ceilingTimePosition;
        long l13 = this.floorBytePosition;
        long l14 = this.ceilingBytePosition;
        long l15 = this.approxBytesPerFrame;
        this.nextSearchBytePosition = l10 = BinarySearchSeeker$SeekOperationParams.calculateNextSearchBytePosition(l10, l11, l12, l13, l14, l15);
    }

    private void updateSeekCeiling(long l10, long l11) {
        this.ceilingTimePosition = l10;
        this.ceilingBytePosition = l11;
        this.updateNextSearchBytePosition();
    }

    private void updateSeekFloor(long l10, long l11) {
        this.floorTimePosition = l10;
        this.floorBytePosition = l11;
        this.updateNextSearchBytePosition();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$BinarySearchSeekMap;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekOperationParams;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;

public abstract class BinarySearchSeeker {
    private static final long MAX_SKIP_BYTES = 262144L;
    private final int minimumSearchRange;
    public final BinarySearchSeeker$BinarySearchSeekMap seekMap;
    public BinarySearchSeeker$SeekOperationParams seekOperationParams;
    public final BinarySearchSeeker$TimestampSeeker timestampSeeker;

    public BinarySearchSeeker(BinarySearchSeeker$SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter, BinarySearchSeeker$TimestampSeeker binarySearchSeeker$TimestampSeeker, long l10, long l11, long l12, long l13, long l14, long l15, int n10) {
        BinarySearchSeeker$BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap;
        this.timestampSeeker = binarySearchSeeker$TimestampSeeker;
        this.minimumSearchRange = n10;
        this.seekMap = binarySearchSeeker$BinarySearchSeekMap = new BinarySearchSeeker$BinarySearchSeekMap(binarySearchSeeker$SeekTimestampConverter, l10, l11, l12, l13, l14, l15);
    }

    public BinarySearchSeeker$SeekOperationParams createSeekParamsForTargetTimeUs(long l10) {
        long l11 = this.seekMap.timeUsToTargetTime(l10);
        long l12 = BinarySearchSeeker$BinarySearchSeekMap.access$1000(this.seekMap);
        long l13 = BinarySearchSeeker$BinarySearchSeekMap.access$1100(this.seekMap);
        long l14 = BinarySearchSeeker$BinarySearchSeekMap.access$1200(this.seekMap);
        long l15 = BinarySearchSeeker$BinarySearchSeekMap.access$1300(this.seekMap);
        long l16 = BinarySearchSeeker$BinarySearchSeekMap.access$1400(this.seekMap);
        BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams = new BinarySearchSeeker$SeekOperationParams(l10, l11, l12, l13, l14, l15, l16);
        return binarySearchSeeker$SeekOperationParams;
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(ExtractorInput object, PositionHolder positionHolder) {
        long l10;
        while (true) {
            long l11;
            BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams = (BinarySearchSeeker$SeekOperationParams)Assertions.checkStateNotNull(this.seekOperationParams);
            long l12 = BinarySearchSeeker$SeekOperationParams.access$100(binarySearchSeeker$SeekOperationParams);
            long l13 = BinarySearchSeeker$SeekOperationParams.access$200(binarySearchSeeker$SeekOperationParams);
            l10 = BinarySearchSeeker$SeekOperationParams.access$300(binarySearchSeeker$SeekOperationParams);
            int n10 = this.minimumSearchRange;
            long l14 = n10;
            long l15 = (l13 -= l12) - l14;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 <= 0) {
                this.markSeekOperationFinished(false, l12);
                return this.seekToPosition((ExtractorInput)object, l12, positionHolder);
            }
            boolean bl2 = this.skipInputUntilPosition((ExtractorInput)object, l10);
            if (!bl2) {
                return this.seekToPosition((ExtractorInput)object, l10, positionHolder);
            }
            object.resetPeekPosition();
            Object object3 = this.timestampSeeker;
            long l16 = BinarySearchSeeker$SeekOperationParams.access$400(binarySearchSeeker$SeekOperationParams);
            object3 = object3.searchForTimestamp((ExtractorInput)object, l16);
            int n11 = BinarySearchSeeker$TimestampSearchResult.access$500((BinarySearchSeeker$TimestampSearchResult)object3);
            object2 = -3;
            if (n11 == object2) break;
            object2 = -2;
            if (n11 != object2) {
                object2 = -1;
                if (n11 != object2) {
                    if (n11 == 0) {
                        l16 = BinarySearchSeeker$TimestampSearchResult.access$700((BinarySearchSeeker$TimestampSearchResult)object3);
                        this.skipInputUntilPosition((ExtractorInput)object, l16);
                        l16 = BinarySearchSeeker$TimestampSearchResult.access$700((BinarySearchSeeker$TimestampSearchResult)object3);
                        this.markSeekOperationFinished(true, l16);
                        long l17 = BinarySearchSeeker$TimestampSearchResult.access$700((BinarySearchSeeker$TimestampSearchResult)object3);
                        return this.seekToPosition((ExtractorInput)object, l17, positionHolder);
                    }
                    object = new IllegalStateException("Invalid case");
                    throw object;
                }
                l16 = BinarySearchSeeker$TimestampSearchResult.access$600((BinarySearchSeeker$TimestampSearchResult)object3);
                l11 = BinarySearchSeeker$TimestampSearchResult.access$700((BinarySearchSeeker$TimestampSearchResult)object3);
                BinarySearchSeeker$SeekOperationParams.access$800(binarySearchSeeker$SeekOperationParams, l16, l11);
                continue;
            }
            l16 = BinarySearchSeeker$TimestampSearchResult.access$600((BinarySearchSeeker$TimestampSearchResult)object3);
            l11 = BinarySearchSeeker$TimestampSearchResult.access$700((BinarySearchSeeker$TimestampSearchResult)object3);
            BinarySearchSeeker$SeekOperationParams.access$900(binarySearchSeeker$SeekOperationParams, l16, l11);
        }
        this.markSeekOperationFinished(false, l10);
        return this.seekToPosition((ExtractorInput)object, l10, positionHolder);
    }

    public final boolean isSeeking() {
        boolean bl2;
        BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams = this.seekOperationParams;
        if (binarySearchSeeker$SeekOperationParams != null) {
            bl2 = true;
        } else {
            bl2 = false;
            binarySearchSeeker$SeekOperationParams = null;
        }
        return bl2;
    }

    public final void markSeekOperationFinished(boolean bl2, long l10) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        this.onSeekOperationFinished(bl2, l10);
    }

    public void onSeekOperationFinished(boolean bl2, long l10) {
    }

    public final int seekToPosition(ExtractorInput extractorInput, long l10, PositionHolder positionHolder) {
        long l11 = extractorInput.getPosition();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return 0;
        }
        positionHolder.position = l10;
        return 1;
    }

    public final void setSeekTargetUs(long l10) {
        BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams;
        long l11;
        long l12;
        long l13;
        BinarySearchSeeker$SeekOperationParams binarySearchSeeker$SeekOperationParams2 = this.seekOperationParams;
        if (binarySearchSeeker$SeekOperationParams2 != null && (l13 = (l12 = (l11 = BinarySearchSeeker$SeekOperationParams.access$000(binarySearchSeeker$SeekOperationParams2)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            return;
        }
        this.seekOperationParams = binarySearchSeeker$SeekOperationParams = this.createSeekParamsForTargetTimeUs(l10);
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long l10) {
        long l11;
        long l12 = extractorInput.getPosition();
        long l13 = (l10 -= l12) - (l12 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = 262144L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            int n10 = (int)l10;
            extractorInput.skipFully(n10);
            return true;
        }
        return false;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacFrameReader$SampleNumberHolder;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$1;

public final class FlacBinarySearchSeeker$FlacTimestampSeeker
implements BinarySearchSeeker$TimestampSeeker {
    private final FlacStreamMetadata flacStreamMetadata;
    private final int frameStartMarker;
    private final FlacFrameReader$SampleNumberHolder sampleNumberHolder;

    private FlacBinarySearchSeeker$FlacTimestampSeeker(FlacStreamMetadata object, int n10) {
        this.flacStreamMetadata = object;
        this.frameStartMarker = n10;
        this.sampleNumberHolder = object = new FlacFrameReader$SampleNumberHolder();
    }

    public /* synthetic */ FlacBinarySearchSeeker$FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int n10, FlacBinarySearchSeeker$1 flacBinarySearchSeeker$1) {
        this(flacStreamMetadata, n10);
    }

    private long findNextFrame(ExtractorInput extractorInput) {
        Object object;
        long l10;
        long l11;
        long l12;
        while (true) {
            FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder;
            int n10;
            FlacStreamMetadata flacStreamMetadata;
            l12 = extractorInput.getPeekPosition();
            l11 = extractorInput.getLength();
            l10 = 6;
            long l13 = l12 - (l11 -= l10);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0 || (object = (Object)FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, flacStreamMetadata = this.flacStreamMetadata, n10 = this.frameStartMarker, flacFrameReader$SampleNumberHolder = this.sampleNumberHolder)) != false) break;
            object = 1;
            extractorInput.advancePeekPosition((int)object);
        }
        l12 = extractorInput.getPeekPosition();
        long l14 = l12 - (l11 = extractorInput.getLength() - l10);
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0) {
            l12 = extractorInput.getLength();
            l11 = extractorInput.getPeekPosition();
            object = (int)(l12 - l11);
            extractorInput.advancePeekPosition((int)object);
            return this.flacStreamMetadata.totalSamples;
        }
        return this.sampleNumberHolder.sampleNumber;
    }

    public BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long l10) {
        long l11 = extractorInput.getPosition();
        long l12 = this.findNextFrame(extractorInput);
        long l13 = extractorInput.getPeekPosition();
        FlacStreamMetadata flacStreamMetadata = this.flacStreamMetadata;
        int n10 = flacStreamMetadata.minFrameSize;
        int n11 = 6;
        n10 = Math.max(n11, n10);
        extractorInput.advancePeekPosition(n10);
        long l14 = this.findNextFrame(extractorInput);
        long l15 = extractorInput.getPeekPosition();
        Object object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (object <= 0 && (object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) > 0) {
            return BinarySearchSeeker$TimestampSearchResult.targetFoundResult(l13);
        }
        object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1);
        if (object <= 0) {
            return BinarySearchSeeker$TimestampSearchResult.underestimatedResult(l14, l15);
        }
        return BinarySearchSeeker$TimestampSearchResult.overestimatedResult(l12, l11);
    }
}


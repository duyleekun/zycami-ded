/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker;
import d.h.a.a.h0.c.b;
import java.util.Objects;

public final class FlacBinarySearchSeeker
extends BinarySearchSeeker {
    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata, int n10, long l10, long l11) {
        Objects.requireNonNull(flacStreamMetadata);
        b b10 = new b(flacStreamMetadata);
        FlacBinarySearchSeeker$FlacTimestampSeeker flacBinarySearchSeeker$FlacTimestampSeeker = new FlacBinarySearchSeeker$FlacTimestampSeeker(flacStreamMetadata, n10, null);
        long l12 = flacStreamMetadata.getDurationUs();
        long l13 = flacStreamMetadata.totalSamples;
        long l14 = flacStreamMetadata.getApproxBytesPerFrame();
        int n11 = flacStreamMetadata.minFrameSize;
        int n12 = Math.max(6, n11);
        super(b10, flacBinarySearchSeeker$FlacTimestampSeeker, l12, 0L, l13, l10, l11, l14, n12);
    }
}


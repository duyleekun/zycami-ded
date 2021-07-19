/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter;
import com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TsBinarySearchSeeker
extends BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 940;
    private static final long SEEK_TOLERANCE_US = 100000L;

    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long l10, long l11, int n10, int n11) {
        BinarySearchSeeker$DefaultSeekTimestampConverter binarySearchSeeker$DefaultSeekTimestampConverter = new BinarySearchSeeker$DefaultSeekTimestampConverter();
        TsBinarySearchSeeker$TsPcrSeeker tsBinarySearchSeeker$TsPcrSeeker = new TsBinarySearchSeeker$TsPcrSeeker(n10, timestampAdjuster, n11);
        long l12 = l10 + 1L;
        super(binarySearchSeeker$DefaultSeekTimestampConverter, tsBinarySearchSeeker$TsPcrSeeker, l10, 0L, l12, 0L, l11, 188L, 940);
    }
}


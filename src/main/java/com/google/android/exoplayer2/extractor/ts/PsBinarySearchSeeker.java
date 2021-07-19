/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter;
import com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker$PsScrSeeker;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PsBinarySearchSeeker
extends BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 1000;
    private static final long SEEK_TOLERANCE_US = 100000L;
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long l10, long l11) {
        BinarySearchSeeker$DefaultSeekTimestampConverter binarySearchSeeker$DefaultSeekTimestampConverter = new BinarySearchSeeker$DefaultSeekTimestampConverter();
        PsBinarySearchSeeker$PsScrSeeker psBinarySearchSeeker$PsScrSeeker = new PsBinarySearchSeeker$PsScrSeeker(timestampAdjuster, null);
        long l12 = l10 + 1L;
        super(binarySearchSeeker$DefaultSeekTimestampConverter, psBinarySearchSeeker$PsScrSeeker, l10, 0L, l12, 0L, l11, 188L, 1000);
    }

    public static /* synthetic */ int access$100(byte[] byArray, int n10) {
        return PsBinarySearchSeeker.peekIntAtPosition(byArray, n10);
    }

    private static int peekIntAtPosition(byte[] byArray, int n10) {
        int n11 = (byArray[n10] & 0xFF) << 24;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 8;
        return byArray[n10 += 3] & 0xFF | (n11 |= n12);
    }
}


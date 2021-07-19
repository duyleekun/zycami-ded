/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$1;

public final class FixedSampleSizeRechunker$Results {
    public final long duration;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timestamps;

    private FixedSampleSizeRechunker$Results(long[] lArray, int[] nArray, int n10, long[] lArray2, int[] nArray2, long l10) {
        this.offsets = lArray;
        this.sizes = nArray;
        this.maximumSize = n10;
        this.timestamps = lArray2;
        this.flags = nArray2;
        this.duration = l10;
    }

    public /* synthetic */ FixedSampleSizeRechunker$Results(long[] lArray, int[] nArray, int n10, long[] lArray2, int[] nArray2, long l10, FixedSampleSizeRechunker$1 fixedSampleSizeRechunker$1) {
        this(lArray, nArray, n10, lArray2, nArray2, l10);
    }
}


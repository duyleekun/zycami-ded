/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

public class FlacStreamMetadata$SeekTable {
    public final long[] pointOffsets;
    public final long[] pointSampleNumbers;

    public FlacStreamMetadata$SeekTable(long[] lArray, long[] lArray2) {
        this.pointSampleNumbers = lArray;
        this.pointOffsets = lArray2;
    }
}


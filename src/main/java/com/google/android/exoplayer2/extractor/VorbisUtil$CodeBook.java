/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

public final class VorbisUtil$CodeBook {
    public final int dimensions;
    public final int entries;
    public final boolean isOrdered;
    public final long[] lengthMap;
    public final int lookupType;

    public VorbisUtil$CodeBook(int n10, int n11, long[] lArray, int n12, boolean bl2) {
        this.dimensions = n10;
        this.entries = n11;
        this.lengthMap = lArray;
        this.lookupType = n12;
        this.isOrdered = bl2;
    }
}


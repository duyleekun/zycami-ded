/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Util;

public class CachedRegionTracker$Region
implements Comparable {
    public long endOffset;
    public int endOffsetIndex;
    public long startOffset;

    public CachedRegionTracker$Region(long l10, long l11) {
        this.startOffset = l10;
        this.endOffset = l11;
    }

    public int compareTo(CachedRegionTracker$Region cachedRegionTracker$Region) {
        long l10 = this.startOffset;
        long l11 = cachedRegionTracker$Region.startOffset;
        return Util.compareLong(l10, l11);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public final class DashWrappingSegmentIndex
implements DashSegmentIndex {
    private final ChunkIndex chunkIndex;
    private final long timeOffsetUs;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long l10) {
        this.chunkIndex = chunkIndex;
        this.timeOffsetUs = l10;
    }

    public int getAvailableSegmentCount(long l10, long l11) {
        return this.chunkIndex.length;
    }

    public long getDurationUs(long l10, long l11) {
        long[] lArray = this.chunkIndex.durationsUs;
        int n10 = (int)l10;
        return lArray[n10];
    }

    public long getFirstAvailableSegmentNum(long l10, long l11) {
        return 0L;
    }

    public long getFirstSegmentNum() {
        return 0L;
    }

    public long getNextSegmentAvailableTimeUs(long l10, long l11) {
        return -9223372036854775807L;
    }

    public int getSegmentCount(long l10) {
        return this.chunkIndex.length;
    }

    public long getSegmentNum(long l10, long l11) {
        ChunkIndex chunkIndex = this.chunkIndex;
        long l12 = this.timeOffsetUs;
        return chunkIndex.getChunkIndex(l10 += l12);
    }

    public RangedUri getSegmentUrl(long l10) {
        RangedUri rangedUri;
        Object object = this.chunkIndex;
        long[] lArray = ((ChunkIndex)object).offsets;
        int n10 = (int)l10;
        long l11 = lArray[n10];
        long l12 = ((ChunkIndex)object).sizes[n10];
        object = rangedUri;
        rangedUri = new RangedUri(null, l11, l12);
        return rangedUri;
    }

    public long getTimeUs(long l10) {
        long[] lArray = this.chunkIndex.timesUs;
        int n10 = (int)l10;
        l10 = lArray[n10];
        long l11 = this.timeOffsetUs;
        return l10 - l11;
    }

    public boolean isExplicit() {
        return true;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;

public class SegmentDownloader$Segment
implements Comparable {
    public final DataSpec dataSpec;
    public final long startTimeUs;

    public SegmentDownloader$Segment(long l10, DataSpec dataSpec) {
        this.startTimeUs = l10;
        this.dataSpec = dataSpec;
    }

    public int compareTo(SegmentDownloader$Segment segmentDownloader$Segment) {
        long l10 = this.startTimeUs;
        long l11 = segmentDownloader$Segment.startTimeUs;
        return Util.compareLong(l10, l11);
    }
}


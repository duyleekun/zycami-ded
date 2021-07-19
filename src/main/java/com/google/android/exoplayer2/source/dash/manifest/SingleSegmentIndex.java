/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public final class SingleSegmentIndex
implements DashSegmentIndex {
    private final RangedUri uri;

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.uri = rangedUri;
    }

    public int getAvailableSegmentCount(long l10, long l11) {
        return 1;
    }

    public long getDurationUs(long l10, long l11) {
        return l11;
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
        return 1;
    }

    public long getSegmentNum(long l10, long l11) {
        return 0L;
    }

    public RangedUri getSegmentUrl(long l10) {
        return this.uri;
    }

    public long getTimeUs(long l10) {
        return 0L;
    }

    public boolean isExplicit() {
        return true;
    }
}


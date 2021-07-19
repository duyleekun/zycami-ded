/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public interface DashSegmentIndex {
    public static final int INDEX_UNBOUNDED = 255;

    public int getAvailableSegmentCount(long var1, long var3);

    public long getDurationUs(long var1, long var3);

    public long getFirstAvailableSegmentNum(long var1, long var3);

    public long getFirstSegmentNum();

    public long getNextSegmentAvailableTimeUs(long var1, long var3);

    public int getSegmentCount(long var1);

    public long getSegmentNum(long var1, long var3);

    public RangedUri getSegmentUrl(long var1);

    public long getTimeUs(long var1);

    public boolean isExplicit();
}


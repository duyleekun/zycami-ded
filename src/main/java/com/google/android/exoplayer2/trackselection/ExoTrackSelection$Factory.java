/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

public interface ExoTrackSelection$Factory {
    public ExoTrackSelection[] createTrackSelections(ExoTrackSelection$Definition[] var1, BandwidthMeter var2, MediaSource$MediaPeriodId var3, Timeline var4);
}


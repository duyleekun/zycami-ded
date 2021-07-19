/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelector$InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;

public abstract class TrackSelector {
    private BandwidthMeter bandwidthMeter;
    private TrackSelector$InvalidationListener listener;

    public final BandwidthMeter getBandwidthMeter() {
        return (BandwidthMeter)Assertions.checkNotNull(this.bandwidthMeter);
    }

    public final void init(TrackSelector$InvalidationListener trackSelector$InvalidationListener, BandwidthMeter bandwidthMeter) {
        this.listener = trackSelector$InvalidationListener;
        this.bandwidthMeter = bandwidthMeter;
    }

    public final void invalidate() {
        TrackSelector$InvalidationListener trackSelector$InvalidationListener = this.listener;
        if (trackSelector$InvalidationListener != null) {
            trackSelector$InvalidationListener.onTrackSelectionsInvalidated();
        }
    }

    public abstract void onSelectionActivated(Object var1);

    public abstract TrackSelectorResult selectTracks(RendererCapabilities[] var1, TrackGroupArray var2, MediaSource$MediaPeriodId var3, Timeline var4);
}


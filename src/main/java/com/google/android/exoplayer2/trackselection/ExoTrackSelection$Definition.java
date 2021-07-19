/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;

public final class ExoTrackSelection$Definition {
    public final Object data;
    public final TrackGroup group;
    public final int reason;
    public final int[] tracks;

    public ExoTrackSelection$Definition(TrackGroup trackGroup, int ... nArray) {
        this(trackGroup, nArray, 0, null);
    }

    public ExoTrackSelection$Definition(TrackGroup trackGroup, int[] nArray, int n10, Object object) {
        this.group = trackGroup;
        this.tracks = nArray;
        this.reason = n10;
        this.data = object;
    }
}


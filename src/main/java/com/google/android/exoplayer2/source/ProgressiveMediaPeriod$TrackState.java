/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.TrackGroupArray;

public final class ProgressiveMediaPeriod$TrackState {
    public final boolean[] trackEnabledStates;
    public final boolean[] trackIsAudioVideoFlags;
    public final boolean[] trackNotifiedDownstreamFormats;
    public final TrackGroupArray tracks;

    public ProgressiveMediaPeriod$TrackState(TrackGroupArray object, boolean[] blArray) {
        this.tracks = object;
        this.trackIsAudioVideoFlags = blArray;
        int n10 = ((TrackGroupArray)object).length;
        blArray = new boolean[n10];
        this.trackEnabledStates = blArray;
        object = new boolean[n10];
        this.trackNotifiedDownstreamFormats = (boolean[])object;
    }
}


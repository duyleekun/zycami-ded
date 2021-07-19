/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackSampleTable;

public final class Mp4Extractor$Mp4Track {
    public int sampleIndex;
    public final TrackSampleTable sampleTable;
    public final Track track;
    public final TrackOutput trackOutput;

    public Mp4Extractor$Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
        this.track = track;
        this.sampleTable = trackSampleTable;
        this.trackOutput = trackOutput;
    }
}


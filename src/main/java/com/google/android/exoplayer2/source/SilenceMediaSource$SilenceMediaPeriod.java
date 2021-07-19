/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SilenceMediaSource;
import com.google.android.exoplayer2.source.SilenceMediaSource$SilenceSampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

public final class SilenceMediaSource$SilenceMediaPeriod
implements MediaPeriod {
    private static final TrackGroupArray TRACKS;
    private final long durationUs;
    private final ArrayList sampleStreams;

    static {
        TrackGroupArray trackGroupArray;
        TrackGroup trackGroup;
        Format format;
        int n10 = 1;
        TrackGroup[] trackGroupArray2 = new TrackGroup[n10];
        Format[] formatArray = new Format[n10];
        formatArray[0] = format = SilenceMediaSource.access$200();
        trackGroupArray2[0] = trackGroup = new TrackGroup(formatArray);
        TRACKS = trackGroupArray = new TrackGroupArray(trackGroupArray2);
    }

    public SilenceMediaSource$SilenceMediaPeriod(long l10) {
        ArrayList arrayList;
        this.durationUs = l10;
        this.sampleStreams = arrayList = new ArrayList();
    }

    private long constrainSeekPosition(long l10) {
        long l11 = this.durationUs;
        return Util.constrainValue(l10, 0L, l11);
    }

    public boolean continueLoading(long l10) {
        return false;
    }

    public void discardBuffer(long l10, boolean bl2) {
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        return this.constrainSeekPosition(l10);
    }

    public long getBufferedPositionUs() {
        return Long.MIN_VALUE;
    }

    public long getNextLoadPositionUs() {
        return Long.MIN_VALUE;
    }

    public TrackGroupArray getTrackGroups() {
        return TRACKS;
    }

    public boolean isLoading() {
        return false;
    }

    public void maybeThrowPrepareError() {
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        mediaPeriod$Callback.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
    }

    public long seekToUs(long l10) {
        Object object;
        int n10;
        l10 = this.constrainSeekPosition(l10);
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.sampleStreams)).size()); ++i10) {
            object = (SilenceMediaSource$SilenceSampleStream)this.sampleStreams.get(i10);
            ((SilenceMediaSource$SilenceSampleStream)object).seekTo(l10);
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        int n10;
        l10 = this.constrainSeekPosition(l10);
        for (int i10 = 0; i10 < (n10 = exoTrackSelectionArray.length); ++i10) {
            Object object;
            Object object2 = sampleStreamArray[i10];
            if (object2 != null && ((object2 = exoTrackSelectionArray[i10]) == null || (n10 = blArray[i10]) == 0)) {
                object2 = this.sampleStreams;
                object = sampleStreamArray[i10];
                ((ArrayList)object2).remove(object);
                n10 = 0;
                object2 = null;
                sampleStreamArray[i10] = null;
            }
            if ((object2 = sampleStreamArray[i10]) != null || (object2 = exoTrackSelectionArray[i10]) == null) continue;
            long l11 = this.durationUs;
            object2 = new SilenceMediaSource$SilenceSampleStream(l11);
            ((SilenceMediaSource$SilenceSampleStream)object2).seekTo(l10);
            object = this.sampleStreams;
            ((ArrayList)object).add(object2);
            sampleStreamArray[i10] = object2;
            blArray2[i10] = n10 = 1;
        }
        return l10;
    }
}


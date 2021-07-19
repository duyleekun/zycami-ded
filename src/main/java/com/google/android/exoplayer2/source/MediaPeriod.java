/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.util.Collections;
import java.util.List;

public interface MediaPeriod
extends SequenceableLoader {
    public boolean continueLoading(long var1);

    public void discardBuffer(long var1, boolean var3);

    public long getAdjustedSeekPositionUs(long var1, SeekParameters var3);

    public long getBufferedPositionUs();

    public long getNextLoadPositionUs();

    default public List getStreamKeys(List list) {
        return Collections.emptyList();
    }

    public TrackGroupArray getTrackGroups();

    public boolean isLoading();

    public void maybeThrowPrepareError();

    public void prepare(MediaPeriod$Callback var1, long var2);

    public long readDiscontinuity();

    public void reevaluateBuffer(long var1);

    public long seekToUs(long var1);

    public long selectTracks(ExoTrackSelection[] var1, boolean[] var2, SampleStream[] var3, boolean[] var4, long var5);
}


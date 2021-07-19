/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MergingMediaPeriod$TimeOffsetSampleStream;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public final class MergingMediaPeriod$TimeOffsetMediaPeriod
implements MediaPeriod,
MediaPeriod$Callback {
    private MediaPeriod$Callback callback;
    private final MediaPeriod mediaPeriod;
    private final long timeOffsetUs;

    public MergingMediaPeriod$TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long l10) {
        this.mediaPeriod = mediaPeriod;
        this.timeOffsetUs = l10;
    }

    public static /* synthetic */ MediaPeriod access$000(MergingMediaPeriod$TimeOffsetMediaPeriod mergingMediaPeriod$TimeOffsetMediaPeriod) {
        return mergingMediaPeriod$TimeOffsetMediaPeriod.mediaPeriod;
    }

    public boolean continueLoading(long l10) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        return mediaPeriod.continueLoading(l10 -= l11);
    }

    public void discardBuffer(long l10, boolean bl2) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        mediaPeriod.discardBuffer(l10 -= l11, bl2);
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        l10 -= l11;
        l10 = mediaPeriod.getAdjustedSeekPositionUs(l10, seekParameters);
        long l12 = this.timeOffsetUs;
        return l10 + l12;
    }

    public long getBufferedPositionUs() {
        long l10;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = mediaPeriod.getBufferedPositionUs();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = this.timeOffsetUs + l11;
        }
        return l10;
    }

    public long getNextLoadPositionUs() {
        long l10;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = mediaPeriod.getNextLoadPositionUs();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = this.timeOffsetUs + l11;
        }
        return l10;
    }

    public List getStreamKeys(List list) {
        return this.mediaPeriod.getStreamKeys(list);
    }

    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    public void maybeThrowPrepareError() {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public void prepare(MediaPeriod$Callback object, long l10) {
        this.callback = object;
        object = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        object.prepare(this, l10 -= l11);
    }

    public long readDiscontinuity() {
        long l10;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = mediaPeriod.readDiscontinuity();
        long l12 = l11 - (l10 = -9223372036854775807L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = this.timeOffsetUs + l11;
        }
        return l10;
    }

    public void reevaluateBuffer(long l10) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        mediaPeriod.reevaluateBuffer(l10 -= l11);
    }

    public long seekToUs(long l10) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l11 = this.timeOffsetUs;
        l10 -= l11;
        l10 = mediaPeriod.seekToUs(l10);
        long l12 = this.timeOffsetUs;
        return l10 + l12;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        int n10;
        ExoTrackSelection[] exoTrackSelectionArray2;
        MergingMediaPeriod$TimeOffsetMediaPeriod mergingMediaPeriod$TimeOffsetMediaPeriod = this;
        SampleStream[] sampleStreamArray2 = sampleStreamArray;
        int n11 = sampleStreamArray.length;
        SampleStream[] sampleStreamArray3 = new SampleStream[n11];
        int n12 = 0;
        int n13 = 0;
        MediaPeriod mediaPeriod = null;
        while (true) {
            int n14 = sampleStreamArray2.length;
            SampleStream sampleStream = null;
            if (n13 >= n14) break;
            exoTrackSelectionArray2 = (ExoTrackSelection[])sampleStreamArray2[n13];
            if (exoTrackSelectionArray2 != null) {
                sampleStream = exoTrackSelectionArray2.getChildStream();
            }
            sampleStreamArray3[n13] = sampleStream;
            ++n13;
        }
        mediaPeriod = mergingMediaPeriod$TimeOffsetMediaPeriod.mediaPeriod;
        long l11 = mergingMediaPeriod$TimeOffsetMediaPeriod.timeOffsetUs;
        long l12 = l10 - l11;
        exoTrackSelectionArray2 = exoTrackSelectionArray;
        Object object = blArray;
        Object object2 = sampleStreamArray3;
        long l13 = mediaPeriod.selectTracks(exoTrackSelectionArray, blArray, sampleStreamArray3, blArray2, l12);
        while (n12 < (n10 = sampleStreamArray2.length)) {
            object = sampleStreamArray3[n12];
            if (object == null) {
                sampleStreamArray2[n12] = null;
            } else {
                object2 = sampleStreamArray2[n12];
                if (object2 == null || (object2 = ((MergingMediaPeriod$TimeOffsetSampleStream)sampleStreamArray2[n12]).getChildStream()) != object) {
                    long l14 = mergingMediaPeriod$TimeOffsetMediaPeriod.timeOffsetUs;
                    sampleStreamArray2[n12] = object2 = new MergingMediaPeriod$TimeOffsetSampleStream((SampleStream)object, l14);
                }
            }
            ++n12;
        }
        long l15 = mergingMediaPeriod$TimeOffsetMediaPeriod.timeOffsetUs;
        return l13 + l15;
    }
}


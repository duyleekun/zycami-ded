/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MaskingMediaPeriod$PrepareListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class MaskingMediaPeriod
implements MediaPeriod,
MediaPeriod$Callback {
    private final Allocator allocator;
    private MediaPeriod$Callback callback;
    public final MediaSource$MediaPeriodId id;
    private MaskingMediaPeriod$PrepareListener listener;
    private MediaPeriod mediaPeriod;
    private MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs;
    private final long preparePositionUs;

    public MaskingMediaPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        this.id = mediaSource$MediaPeriodId;
        this.allocator = allocator;
        this.preparePositionUs = l10;
        this.preparePositionOverrideUs = -9223372036854775807L;
    }

    private long getPreparePositionWithOverride(long l10) {
        long l11 = this.preparePositionOverrideUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l10 = l11;
        }
        return l10;
    }

    public boolean continueLoading(long l10) {
        boolean bl2;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        bl2 = mediaPeriod != null && (bl2 = mediaPeriod.continueLoading(l10));
        return bl2;
    }

    public void createPeriod(MediaSource$MediaPeriodId object) {
        long l10 = this.preparePositionUs;
        l10 = this.getPreparePositionWithOverride(l10);
        Object object2 = (MediaSource)Assertions.checkNotNull(this.mediaSource);
        Allocator allocator = this.allocator;
        this.mediaPeriod = object = object2.createPeriod((MediaSource$MediaPeriodId)object, allocator, l10);
        object2 = this.callback;
        if (object2 != null) {
            object.prepare(this, l10);
        }
    }

    public void discardBuffer(long l10, boolean bl2) {
        ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).discardBuffer(l10, bl2);
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).getAdjustedSeekPositionUs(l10, seekParameters);
    }

    public long getBufferedPositionUs() {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).getNextLoadPositionUs();
    }

    public long getPreparePositionOverrideUs() {
        return this.preparePositionOverrideUs;
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public TrackGroupArray getTrackGroups() {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).getTrackGroups();
    }

    public boolean isLoading() {
        boolean bl2;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null && (bl2 = mediaPeriod.isLoading())) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPeriod = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void maybeThrowPrepareError() {
        try {
            Object object = this.mediaPeriod;
            if (object != null) {
                object.maybeThrowPrepareError();
                return;
            }
            object = this.mediaSource;
            if (object == null) return;
            object.maybeThrowSourceInfoRefreshError();
            return;
        }
        catch (IOException iOException) {
            MaskingMediaPeriod$PrepareListener maskingMediaPeriod$PrepareListener = this.listener;
            if (maskingMediaPeriod$PrepareListener == null) throw iOException;
            boolean bl2 = this.notifiedPrepareError;
            if (bl2) return;
            this.notifiedPrepareError = bl2 = true;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.id;
            maskingMediaPeriod$PrepareListener.onPrepareError(mediaSource$MediaPeriodId, iOException);
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Util.castNonNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod object) {
        ((MediaPeriod$Callback)Util.castNonNull(this.callback)).onPrepared(this);
        object = this.listener;
        if (object != null) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.id;
            object.onPrepareComplete(mediaSource$MediaPeriodId);
        }
    }

    public void overridePreparePositionUs(long l10) {
        this.preparePositionOverrideUs = l10;
    }

    public void prepare(MediaPeriod$Callback object, long l10) {
        this.callback = object;
        object = this.mediaPeriod;
        if (object != null) {
            l10 = this.preparePositionUs;
            l10 = this.getPreparePositionWithOverride(l10);
            object.prepare(this, l10);
        }
    }

    public long readDiscontinuity() {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).readDiscontinuity();
    }

    public void reevaluateBuffer(long l10) {
        ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).reevaluateBuffer(l10);
    }

    public void releasePeriod() {
        Object object = this.mediaPeriod;
        if (object != null) {
            object = (MediaSource)Assertions.checkNotNull(this.mediaSource);
            MediaPeriod mediaPeriod = this.mediaPeriod;
            object.releasePeriod(mediaPeriod);
        }
    }

    public long seekToUs(long l10) {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).seekToUs(l10);
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        long l11;
        long l12;
        long l13;
        MaskingMediaPeriod maskingMediaPeriod = this;
        long l14 = this.preparePositionOverrideUs;
        long l15 = -9223372036854775807L;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false && (object = (l13 = l10 - (l12 = this.preparePositionUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
            this.preparePositionOverrideUs = l15;
            l11 = l14;
        } else {
            l11 = l10;
        }
        Object object2 = Util.castNonNull(maskingMediaPeriod.mediaPeriod);
        return ((MediaPeriod)object2).selectTracks(exoTrackSelectionArray, blArray, sampleStreamArray, blArray2, l11);
    }

    public void setMediaSource(MediaSource mediaSource) {
        boolean bl2;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaSource2 = null;
        }
        Assertions.checkState(bl2);
        this.mediaSource = mediaSource;
    }

    public void setPrepareListener(MaskingMediaPeriod$PrepareListener maskingMediaPeriod$PrepareListener) {
        this.listener = maskingMediaPeriod$PrepareListener;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaPeriodInfo;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

public final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean allRenderersEnabled;
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSourceList mediaSourceList;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] object, long l10, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.rendererCapabilities = object;
        this.rendererPositionOffsetUs = l10;
        this.trackSelector = trackSelector;
        this.mediaSourceList = mediaSourceList;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        SampleStream[] sampleStreamArray = mediaSource$MediaPeriodId.periodUid;
        this.uid = sampleStreamArray;
        this.info = mediaPeriodInfo;
        sampleStreamArray = TrackGroupArray.EMPTY;
        this.trackGroups = sampleStreamArray;
        this.trackSelectorResult = trackSelectorResult;
        sampleStreamArray = new SampleStream[((RendererCapabilities[])object).length];
        this.sampleStreams = sampleStreamArray;
        object = new boolean[((RendererCapabilities[])object).length];
        this.mayRetainStreamFlags = (boolean[])object;
        long l11 = mediaPeriodInfo.startPositionUs;
        long l12 = mediaPeriodInfo.endPositionUs;
        this.mediaPeriod = object = MediaPeriodHolder.createMediaPeriod(mediaSource$MediaPeriodId, mediaSourceList, allocator, l11, l12);
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArray) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((RendererCapabilities[])(object = this.rendererCapabilities)).length); ++i10) {
            int n11 = (object = object[i10]).getTrackType();
            if (n11 != (n10 = 7) || (n11 = (int)(((TrackSelectorResult)(object = this.trackSelectorResult)).isRendererEnabled(i10) ? 1 : 0)) == 0) continue;
            sampleStreamArray[i10] = object = new EmptySampleStream();
        }
    }

    private static MediaPeriod createMediaPeriod(MediaSource$MediaPeriodId object, MediaSourceList mediaSourceList, Allocator allocator, long l10, long l11) {
        long l12;
        Object object2 = mediaSourceList.createPeriod((MediaSource$MediaPeriodId)object, allocator, l10);
        long l13 = -9223372036854775807L;
        long l14 = l11 - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 != false && (object3 = (l12 = l11 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            boolean bl2 = true;
            long l15 = 0L;
            object2 = object = new ClippingMediaPeriod((MediaPeriod)object2, bl2, l15, l11);
        }
        return object2;
    }

    private void disableTrackSelectionsInResult() {
        int n10 = this.isLoadingMediaPeriod();
        if (n10 == 0) {
            return;
        }
        n10 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            int n11 = trackSelectorResult.length;
            if (n10 >= n11) break;
            boolean bl2 = trackSelectorResult.isRendererEnabled(n10);
            ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[n10];
            if (bl2 && exoTrackSelection != null) {
                exoTrackSelection.disable();
            }
            ++n10;
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArray) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((RendererCapabilities[])(object = this.rendererCapabilities)).length); ++i10) {
            int n11 = (object = object[i10]).getTrackType();
            if (n11 != (n10 = 7)) continue;
            n11 = 0;
            object = null;
            sampleStreamArray[i10] = null;
        }
    }

    private void enableTrackSelectionsInResult() {
        int n10 = this.isLoadingMediaPeriod();
        if (n10 == 0) {
            return;
        }
        n10 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
            int n11 = trackSelectorResult.length;
            if (n10 >= n11) break;
            boolean bl2 = trackSelectorResult.isRendererEnabled(n10);
            ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[n10];
            if (bl2 && exoTrackSelection != null) {
                exoTrackSelection.enable();
            }
            ++n10;
        }
    }

    private boolean isLoadingMediaPeriod() {
        boolean bl2;
        MediaPeriodHolder mediaPeriodHolder = this.next;
        if (mediaPeriodHolder == null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPeriodHolder = null;
        }
        return bl2;
    }

    private static void releaseMediaPeriod(long l10, MediaSourceList object, MediaPeriod mediaPeriod) {
        long l11;
        long l12;
        long l13 = -9223372036854775807L;
        long l14 = l10 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false && (l12 = (l11 = l10 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            mediaPeriod = (ClippingMediaPeriod)mediaPeriod;
            MediaPeriod mediaPeriod2 = ((ClippingMediaPeriod)mediaPeriod).mediaPeriod;
            ((MediaSourceList)object).releasePeriod(mediaPeriod2);
        }
        try {
            ((MediaSourceList)object).releasePeriod(mediaPeriod);
        }
        catch (RuntimeException runtimeException) {
            String string2 = TAG;
            object = "Period release failed.";
            Log.e(string2, (String)object, runtimeException);
        }
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult, long l10, boolean bl2) {
        boolean[] blArray = new boolean[this.rendererCapabilities.length];
        return this.applyTrackSelection(trackSelectorResult, l10, bl2, blArray);
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult, long l10, boolean bl2, boolean[] blArray) {
        int n10;
        SampleStream[] sampleStreamArray;
        int n11;
        int n12;
        MediaPeriodHolder mediaPeriodHolder = this;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        int n13 = 0;
        SampleStream[] sampleStreamArray2 = null;
        while (true) {
            int n14 = trackSelectorResult2.length;
            n12 = 1;
            if (n13 >= n14) break;
            boolean[] blArray2 = mediaPeriodHolder.mayRetainStreamFlags;
            if (bl2 || (n11 = trackSelectorResult.isEquivalent((TrackSelectorResult)(sampleStreamArray = mediaPeriodHolder.trackSelectorResult), n13)) == 0) {
                n12 = 0;
            }
            blArray2[n13] = n12;
            ++n13;
        }
        sampleStreamArray2 = mediaPeriodHolder.sampleStreams;
        this.disassociateNoSampleRenderersWithEmptySampleStream(sampleStreamArray2);
        this.disableTrackSelectionsInResult();
        mediaPeriodHolder.trackSelectorResult = trackSelectorResult2;
        this.enableTrackSelectionsInResult();
        sampleStreamArray = mediaPeriodHolder.mediaPeriod;
        Object object = trackSelectorResult2.selections;
        boolean[] blArray3 = mediaPeriodHolder.mayRetainStreamFlags;
        SampleStream[] sampleStreamArray3 = mediaPeriodHolder.sampleStreams;
        long l11 = sampleStreamArray.selectTracks((ExoTrackSelection[])object, blArray3, sampleStreamArray3, blArray, l10);
        sampleStreamArray = mediaPeriodHolder.sampleStreams;
        this.associateNoSampleRenderersWithEmptySampleStream(sampleStreamArray);
        mediaPeriodHolder.hasEnabledTracks = false;
        sampleStreamArray = null;
        for (n11 = 0; n11 < (n10 = ((Object[])(object = mediaPeriodHolder.sampleStreams)).length); ++n11) {
            int n15;
            if ((object = object[n11]) != null) {
                Assertions.checkState(trackSelectorResult.isRendererEnabled(n11));
                object = mediaPeriodHolder.rendererCapabilities[n11];
                n15 = object.getTrackType();
                n10 = 7;
                if (n15 == n10) continue;
                mediaPeriodHolder.hasEnabledTracks = n12;
                continue;
            }
            object = trackSelectorResult2.selections[n11];
            if (object == null) {
                n15 = n12;
            } else {
                n15 = 0;
                object = null;
            }
            Assertions.checkState(n15 != 0);
        }
        return l11;
    }

    public void continueLoading(long l10) {
        Assertions.checkState(this.isLoadingMediaPeriod());
        l10 = this.toPeriodTime(l10);
        this.mediaPeriod.continueLoading(l10);
    }

    public long getBufferedPositionUs() {
        long l10;
        Object object;
        boolean bl2 = this.prepared;
        if (!bl2) {
            return this.info.startPositionUs;
        }
        bl2 = this.hasEnabledTracks;
        long l11 = Long.MIN_VALUE;
        if (bl2) {
            object = this.mediaPeriod;
            l10 = object.getBufferedPositionUs();
        } else {
            l10 = l11;
        }
        bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (!bl2) {
            object = this.info;
            l10 = ((MediaPeriodInfo)object).durationUs;
        }
        return l10;
    }

    public MediaPeriodHolder getNext() {
        return this.next;
    }

    public long getNextLoadPositionUs() {
        long l10;
        boolean bl2 = this.prepared;
        if (!bl2) {
            l10 = 0L;
        } else {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            l10 = mediaPeriod.getNextLoadPositionUs();
        }
        return l10;
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        long l10 = this.info.startPositionUs;
        long l11 = this.rendererPositionOffsetUs;
        return l10 + l11;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public TrackSelectorResult getTrackSelectorResult() {
        return this.trackSelectorResult;
    }

    public void handlePrepared(float f10, Timeline object) {
        TrackGroupArray trackGroupArray;
        boolean bl2;
        this.prepared = bl2 = true;
        this.trackGroups = trackGroupArray = this.mediaPeriod.getTrackGroups();
        Object object2 = this.selectTracks(f10, (Timeline)object);
        object = this.info;
        long l10 = ((MediaPeriodInfo)object).startPositionUs;
        long l11 = ((MediaPeriodInfo)object).durationUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false && (object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) >= 0) {
            l12 = 1L;
            l10 = Math.max(0L, l11 -= l12);
        }
        long l14 = this.applyTrackSelection((TrackSelectorResult)object2, l10, false);
        l10 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo = this.info;
        long l15 = mediaPeriodInfo.startPositionUs - l14;
        this.rendererPositionOffsetUs = l10 += l15;
        this.info = object2 = mediaPeriodInfo.copyWithStartPositionUs(l14);
    }

    public boolean isFullyBuffered() {
        long l10;
        MediaPeriod mediaPeriod;
        long l11;
        long l12;
        boolean bl2 = this.prepared;
        if (!(!bl2 || (bl2 = this.hasEnabledTracks) && (bl2 = (l12 = (l11 = (mediaPeriod = this.mediaPeriod).getBufferedPositionUs()) - (l10 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPeriod = null;
        }
        return bl2;
    }

    public void reevaluateBuffer(long l10) {
        Assertions.checkState(this.isLoadingMediaPeriod());
        boolean bl2 = this.prepared;
        if (bl2) {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            l10 = this.toPeriodTime(l10);
            mediaPeriod.reevaluateBuffer(l10);
        }
    }

    public void release() {
        this.disableTrackSelectionsInResult();
        long l10 = this.info.endPositionUs;
        MediaSourceList mediaSourceList = this.mediaSourceList;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        MediaPeriodHolder.releaseMediaPeriod(l10, mediaSourceList, mediaPeriod);
    }

    public TrackSelectorResult selectTracks(float f10, Timeline object) {
        ExoTrackSelection[] exoTrackSelectionArray = this.trackSelector;
        RendererCapabilities[] rendererCapabilitiesArray = this.rendererCapabilities;
        TrackGroupArray trackGroupArray = this.getTrackGroups();
        Object object2 = this.info.id;
        object = exoTrackSelectionArray.selectTracks(rendererCapabilitiesArray, trackGroupArray, (MediaSource$MediaPeriodId)object2, (Timeline)object);
        exoTrackSelectionArray = ((TrackSelectorResult)object).selections;
        int n10 = exoTrackSelectionArray.length;
        trackGroupArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = exoTrackSelectionArray[i10];
            if (object2 == null) continue;
            object2.onPlaybackSpeed(f10);
        }
        return object;
    }

    public void setNext(MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder mediaPeriodHolder2 = this.next;
        if (mediaPeriodHolder == mediaPeriodHolder2) {
            return;
        }
        this.disableTrackSelectionsInResult();
        this.next = mediaPeriodHolder;
        this.enableTrackSelectionsInResult();
    }

    public void setRendererOffset(long l10) {
        this.rendererPositionOffsetUs = l10;
    }

    public long toPeriodTime(long l10) {
        long l11 = this.getRendererOffset();
        return l10 - l11;
    }

    public long toRendererTime(long l10) {
        long l11 = this.getRendererOffset();
        return l10 + l11;
    }
}


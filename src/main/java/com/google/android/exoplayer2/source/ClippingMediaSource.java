/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.ClippingMediaSource$ClippingTimeline;
import com.google.android.exoplayer2.source.ClippingMediaSource$IllegalClippingException;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;

public final class ClippingMediaSource
extends CompositeMediaSource {
    private final boolean allowDynamicClippingUpdates;
    private ClippingMediaSource$IllegalClippingException clippingError;
    private ClippingMediaSource$ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline$Window window;

    public ClippingMediaSource(MediaSource mediaSource, long l10) {
        this(mediaSource, 0L, l10, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource, long l10, long l11) {
        this(mediaSource, l10, l11, true, false, false);
    }

    public ClippingMediaSource(MediaSource object, long l10, long l11, boolean bl2, boolean bl3, boolean bl4) {
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        l13 = l13 >= 0 ? (long)1 : (long)0;
        Assertions.checkArgument((boolean)l13);
        object = (MediaSource)Assertions.checkNotNull(object);
        this.mediaSource = object;
        this.startUs = l10;
        this.endUs = l11;
        this.enableInitialDiscontinuity = bl2;
        this.allowDynamicClippingUpdates = bl3;
        this.relativeToDefaultPosition = bl4;
        object = new ArrayList();
        this.mediaPeriods = object;
        this.window = object = new Timeline$Window();
    }

    private void refreshClippedTimeline(Timeline timeline) {
        Object object;
        Object object2;
        ClippingMediaSource clippingMediaSource = this;
        Object object3 = this.window;
        int n10 = 0;
        timeline.getWindow(0, (Timeline$Window)object3);
        long l10 = this.window.getPositionInFirstPeriodUs();
        object3 = this.clippingTimeline;
        long l11 = Long.MIN_VALUE;
        if (object3 != null && (object2 = ((ArrayList)(object3 = this.mediaPeriods)).isEmpty()) == 0 && (object2 = this.allowDynamicClippingUpdates) == 0) {
            long l12 = this.periodStartUs - l10;
            long l13 = this.endUs;
            long l14 = l13 - l11;
            object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != 0) {
                l11 = this.periodEndUs - l10;
            }
            l10 = l12;
        } else {
            long l15;
            long l16 = clippingMediaSource.startUs;
            long l17 = clippingMediaSource.endUs;
            object2 = clippingMediaSource.relativeToDefaultPosition;
            if (object2 != 0) {
                object3 = clippingMediaSource.window;
                l15 = ((Timeline$Window)object3).getDefaultPositionUs();
                l16 += l15;
                l17 += l15;
            }
            clippingMediaSource.periodStartUs = l15 = l10 + l16;
            l15 = clippingMediaSource.endUs;
            long l18 = l15 - l11;
            object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 != 0) {
                l11 = l10 + l17;
            }
            clippingMediaSource.periodEndUs = l11;
            object3 = clippingMediaSource.mediaPeriods;
            object2 = ((ArrayList)object3).size();
            while (n10 < object2) {
                object = (ClippingMediaPeriod)clippingMediaSource.mediaPeriods.get(n10);
                l10 = clippingMediaSource.periodStartUs;
                l11 = clippingMediaSource.periodEndUs;
                ((ClippingMediaPeriod)object).updateClipping(l10, l11);
                ++n10;
            }
            l10 = l16;
            l11 = l17;
        }
        object = object3;
        try {
            object3 = new ClippingMediaSource$ClippingTimeline(timeline, l10, l11);
        }
        catch (ClippingMediaSource$IllegalClippingException clippingMediaSource$IllegalClippingException) {
            clippingMediaSource.clippingError = clippingMediaSource$IllegalClippingException;
            return;
        }
        clippingMediaSource.clippingTimeline = object3;
        this.refreshSourceInfo((Timeline)object3);
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        MediaPeriod mediaPeriod = this.mediaSource.createPeriod(mediaSource$MediaPeriodId, allocator, l10);
        boolean bl2 = this.enableInitialDiscontinuity;
        long l11 = this.periodStartUs;
        long l12 = this.periodEndUs;
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mediaPeriod, bl2, l11, l12);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    public long getMediaTimeForChildMediaTime(Void void_, long l10) {
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        l11 = C.usToMs(this.startUs);
        long l13 = Math.max(0L, l10 -= l11);
        long l14 = this.endUs;
        long l15 = Long.MIN_VALUE;
        long l16 = l14 - l15;
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 != false) {
            l14 = C.usToMs(l14) - l11;
            l13 = Math.min(l14, l13);
        }
        return l13;
    }

    public Object getTag() {
        return this.mediaSource.getTag();
    }

    public void maybeThrowSourceInfoRefreshError() {
        ClippingMediaSource$IllegalClippingException clippingMediaSource$IllegalClippingException = this.clippingError;
        if (clippingMediaSource$IllegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw clippingMediaSource$IllegalClippingException;
    }

    public void onChildSourceInfoRefreshed(Void object, MediaSource mediaSource, Timeline timeline) {
        object = this.clippingError;
        if (object != null) {
            return;
        }
        this.refreshClippedTimeline(timeline);
    }

    public void prepareSourceInternal(TransferListener object) {
        super.prepareSourceInternal((TransferListener)object);
        object = this.mediaSource;
        this.prepareChildSource(null, (MediaSource)object);
    }

    public void releasePeriod(MediaPeriod object) {
        boolean bl2 = this.mediaPeriods.remove(object);
        Assertions.checkState(bl2);
        MediaSource mediaSource = this.mediaSource;
        object = ((ClippingMediaPeriod)object).mediaPeriod;
        mediaSource.releasePeriod((MediaPeriod)object);
        object = this.mediaPeriods;
        boolean bl3 = ((ArrayList)object).isEmpty();
        if (bl3 && !(bl3 = this.allowDynamicClippingUpdates)) {
            object = ((ClippingMediaSource$ClippingTimeline)Assertions.checkNotNull((Object)this.clippingTimeline)).timeline;
            this.refreshClippedTimeline((Timeline)object);
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }
}


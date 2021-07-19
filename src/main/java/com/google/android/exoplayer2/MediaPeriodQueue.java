/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.util.Pair
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.MediaPeriodHolder;
import com.google.android.exoplayer2.MediaPeriodInfo;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import d.h.a.a.z;
import java.util.List;

public final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private final AnalyticsCollector analyticsCollector;
    private final Handler analyticsCollectorHandler;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Timeline$Period period;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline$Window window;

    public MediaPeriodQueue(AnalyticsCollector object, Handler handler) {
        this.analyticsCollector = object;
        this.analyticsCollectorHandler = handler;
        this.period = object = new Timeline$Period();
        this.window = object = new Timeline$Window();
    }

    private /* synthetic */ void a(ImmutableList$Builder object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        AnalyticsCollector analyticsCollector = this.analyticsCollector;
        object = ((ImmutableList$Builder)object).build();
        analyticsCollector.updateMediaPeriodQueueInfo((List)object, mediaSource$MediaPeriodId);
    }

    private boolean areDurationsCompatible(long l10, long l11) {
        boolean bl2;
        long l12 = -9223372036854775807L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        bl2 = object == false || !(bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        return bl2;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo object, MediaPeriodInfo object2) {
        boolean bl2;
        long l10 = ((MediaPeriodInfo)object).startPositionUs;
        long l11 = ((MediaPeriodInfo)object2).startPositionUs;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false && (bl2 = ((MediaPeriodId)(object = ((MediaPeriodInfo)object).id)).equals(object2 = ((MediaPeriodInfo)object2).id))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        Timeline timeline = playbackInfo.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo.periodId;
        long l10 = playbackInfo.requestedContentPositionUs;
        long l11 = playbackInfo.positionUs;
        return this.getMediaPeriodInfo(timeline, mediaSource$MediaPeriodId, l10, l11);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long l10) {
        MediaPeriodQueue mediaPeriodQueue = this;
        Object object = mediaPeriodHolder;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long l11 = mediaPeriodHolder.getRendererOffset();
        long l12 = mediaPeriodInfo.durationUs;
        long l13 = (l11 += l12) - l10;
        int n10 = mediaPeriodInfo.isLastInTimelinePeriod;
        int n11 = -1;
        if (n10 != 0) {
            long l14;
            Object object2 = mediaPeriodInfo.id.periodUid;
            int n12 = timeline.getIndexOfPeriod(object2);
            Object object3 = this.period;
            Timeline$Window timeline$Window = this.window;
            n10 = this.repeatMode;
            boolean bl2 = this.shuffleModeEnabled;
            int n13 = n10;
            object2 = timeline;
            long l15 = 0L;
            if ((n10 = timeline.getNextPeriodIndex(n12, (Timeline$Period)object3, timeline$Window, n10, bl2)) == n11) {
                return null;
            }
            Object object4 = this.period;
            int n14 = timeline.getPeriod((int)n10, (Timeline$Period)object4, (boolean)true).windowIndex;
            object4 = this.period.uid;
            long l16 = mediaPeriodInfo.id.windowSequenceNumber;
            object3 = this.window;
            object3 = timeline.getWindow(n14, (Timeline$Window)object3);
            int n15 = ((Timeline$Window)object3).firstPeriodIndex;
            if (n15 == n10) {
                Object object5;
                object4 = this.window;
                object3 = this.period;
                l16 = -9223372036854775807L;
                object2 = timeline.getPeriodPosition((Timeline$Window)object4, (Timeline$Period)object3, n14, l16, l13 = Math.max(l15, l13));
                if (object2 == null) {
                    return null;
                }
                object4 = ((Pair)object2).first;
                l12 = (Long)((Pair)object2).second;
                object2 = mediaPeriodHolder.getNext();
                if (object2 != null && (n13 = (int)((object5 = ((MediaPeriodHolder)object2).uid).equals(object4) ? 1 : 0)) != 0) {
                    object2 = object2.info.id;
                    l16 = ((MediaPeriodId)object2).windowSequenceNumber;
                } else {
                    l16 = mediaPeriodQueue.nextWindowSequenceNumber;
                    mediaPeriodQueue.nextWindowSequenceNumber = l13 = 1L + l16;
                }
                l14 = l12;
                l15 = -9223372036854775807L;
            } else {
                l14 = l15;
            }
            Timeline$Period timeline$Period = mediaPeriodQueue.period;
            object2 = timeline;
            l12 = l14;
            object3 = MediaPeriodQueue.resolveMediaPeriodIdForAds(timeline, object4, l14, l16, timeline$Period);
            object2 = this;
            object4 = timeline;
            long l17 = l14;
            return this.getMediaPeriodInfo(timeline, (MediaSource$MediaPeriodId)object3, l15, l14);
        }
        long l18 = 0L;
        object = mediaPeriodInfo.id;
        Object object6 = ((MediaPeriodId)object).periodUid;
        Object object7 = this.period;
        timeline.getPeriodByUid(object6, (Timeline$Period)object7);
        n10 = (int)(((MediaPeriodId)object).isAd() ? 1 : 0);
        if (n10 != 0) {
            Object object8;
            object6 = this.period;
            int n16 = ((MediaPeriodId)object).adGroupIndex;
            n10 = ((Timeline$Period)object6).getAdCountInAdGroup(n16);
            if (n10 == n11) {
                return null;
            }
            object7 = this.period;
            int n17 = ((MediaPeriodId)object).adIndexInAdGroup;
            int n18 = ((Timeline$Period)object7).getNextAdIndexToPlay(n16, n17);
            if (n18 < n10) {
                Object object9 = ((MediaPeriodId)object).periodUid;
                long l19 = mediaPeriodInfo.requestedContentPositionUs;
                long l20 = ((MediaPeriodId)object).windowSequenceNumber;
                object6 = this;
                object7 = timeline;
                return this.getMediaPeriodInfoForAd(timeline, object9, n16, n18, l19, l20);
            }
            l11 = mediaPeriodInfo.requestedContentPositionUs;
            l12 = -9223372036854775807L;
            long l21 = l11 - l12;
            n17 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
            if (n17 == 0) {
                object7 = this.window;
                object8 = this.period;
                n16 = ((Timeline$Period)object8).windowIndex;
                long l22 = -9223372036854775807L;
                l13 = Math.max(l18, l13);
                object6 = timeline;
                object6 = timeline.getPeriodPosition((Timeline$Window)object7, (Timeline$Period)object8, n16, l22, l13);
                if (object6 == null) {
                    return null;
                }
                object6 = (Long)((Pair)object6).second;
                l11 = (Long)object6;
            }
            object8 = ((MediaPeriodId)object).periodUid;
            long l23 = mediaPeriodInfo.requestedContentPositionUs;
            long l24 = ((MediaPeriodId)object).windowSequenceNumber;
            object6 = this;
            object7 = timeline;
            return this.getMediaPeriodInfoForContent(timeline, object8, l11, l23, l24);
        }
        object6 = this.period;
        long l25 = mediaPeriodInfo.endPositionUs;
        int n19 = ((Timeline$Period)object6).getAdGroupIndexForPositionUs(l25);
        if (n19 == n11) {
            Object object10 = ((MediaPeriodId)object).periodUid;
            long l26 = mediaPeriodInfo.durationUs;
            long l27 = ((MediaPeriodId)object).windowSequenceNumber;
            object6 = this;
            object7 = timeline;
            return this.getMediaPeriodInfoForContent(timeline, object10, l26, l26, l27);
        }
        int n20 = this.period.getFirstAdIndexToPlay(n19);
        Object object11 = ((MediaPeriodId)object).periodUid;
        long l28 = mediaPeriodInfo.durationUs;
        long l29 = ((MediaPeriodId)object).windowSequenceNumber;
        object6 = this;
        object7 = timeline;
        return this.getMediaPeriodInfoForAd(timeline, object11, n19, n20, l28, l29);
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10, long l11) {
        Object object = mediaSource$MediaPeriodId.periodUid;
        Object object2 = this.period;
        timeline.getPeriodByUid(object, (Timeline$Period)object2);
        boolean bl2 = mediaSource$MediaPeriodId.isAd();
        if (bl2) {
            Object object3 = mediaSource$MediaPeriodId.periodUid;
            int n10 = mediaSource$MediaPeriodId.adGroupIndex;
            int n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            long l12 = mediaSource$MediaPeriodId.windowSequenceNumber;
            object2 = this;
            return this.getMediaPeriodInfoForAd(timeline, object3, n10, n11, l10, l12);
        }
        Object object4 = mediaSource$MediaPeriodId.periodUid;
        long l13 = mediaSource$MediaPeriodId.windowSequenceNumber;
        object2 = this;
        return this.getMediaPeriodInfoForContent(timeline, object4, l11, l10, l13);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object object, int n10, int n11, long l10, long l11) {
        MediaPeriodInfo mediaPeriodInfo;
        long l12;
        long l13;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        Object object2 = mediaSource$MediaPeriodId;
        Object object3 = object;
        int n12 = n10;
        mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object, n10, n11, l11);
        object2 = mediaSource$MediaPeriodId.periodUid;
        object3 = this.period;
        object2 = timeline.getPeriodByUid(object2, (Timeline$Period)object3);
        int n13 = mediaSource$MediaPeriodId.adGroupIndex;
        n12 = mediaSource$MediaPeriodId.adIndexInAdGroup;
        long l14 = ((Timeline$Period)object2).getAdDurationUs(n13, n12);
        object2 = this.period;
        n13 = n10;
        int n14 = ((Timeline$Period)object2).getFirstAdIndexToPlay(n10);
        long l15 = 0L;
        if (n11 == n14) {
            object2 = this.period;
            l13 = ((Timeline$Period)object2).getAdResumePositionUs();
        } else {
            l13 = l15;
        }
        long l16 = -9223372036854775807L;
        n14 = (int)(l14 == l16 ? 0 : (l14 < l16 ? -1 : 1));
        if (n14 != 0 && (n14 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1))) >= 0) {
            long l17;
            l13 = l14 - 1L;
            l12 = l17 = Math.max(l15, l13);
        } else {
            l12 = l13;
        }
        object2 = mediaPeriodInfo;
        object3 = mediaSource$MediaPeriodId;
        long l18 = -9223372036854775807L;
        mediaPeriodInfo = new MediaPeriodInfo(mediaSource$MediaPeriodId, l12, l10, l18, l14, false, false, false);
        return mediaPeriodInfo;
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object object, long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        long l16;
        MediaPeriodQueue mediaPeriodQueue = this;
        Object object2 = timeline;
        long l17 = l10;
        Timeline$Period timeline$Period = this.period;
        timeline.getPeriodByUid(object, timeline$Period);
        timeline$Period = this.period;
        int n10 = timeline$Period.getAdGroupIndexAfterPositionUs(l10);
        long l18 = l12;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object, l12, n10);
        boolean bl2 = this.isLastInPeriod(mediaSource$MediaPeriodId);
        boolean bl3 = this.isLastInWindow(timeline, mediaSource$MediaPeriodId);
        boolean bl4 = this.isLastInTimeline(timeline, mediaSource$MediaPeriodId, bl2);
        l18 = -9223372036854775807L;
        int n11 = -1;
        if (n10 != n11) {
            object2 = this.period;
            l15 = l16 = ((Timeline$Period)object2).getAdGroupTimeUs(n10);
        } else {
            l15 = l18;
        }
        n11 = (int)(l15 == l18 ? 0 : (l15 < l18 ? -1 : 1));
        if (n11 != 0 && (n11 = (int)((l14 = l15 - (l16 = Long.MIN_VALUE)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
            l13 = l15;
        } else {
            object2 = mediaPeriodQueue.period;
            l13 = l16 = ((Timeline$Period)object2).durationUs;
        }
        n11 = (int)(l13 == l18 ? 0 : (l13 < l18 ? -1 : 1));
        if (n11 != 0 && (n11 = (int)(l17 == l13 ? 0 : (l17 < l13 ? -1 : 1))) >= 0) {
            l16 = l13 - 1L;
            l17 = Math.max(0L, l16);
        }
        l18 = l17;
        object2 = new MediaPeriodInfo(mediaSource$MediaPeriodId, l17, l11, l15, l13, bl2, bl3, bl4);
        return object2;
    }

    private boolean isLastInPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        int n10;
        int n11 = mediaSource$MediaPeriodId.isAd();
        if (n11 == 0 && (n10 = mediaSource$MediaPeriodId.nextAdGroupIndex) == (n11 = -1)) {
            n10 = 1;
        } else {
            n10 = 0;
            mediaSource$MediaPeriodId = null;
        }
        return n10 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isLastInTimeline(Timeline timeline, MediaSource$MediaPeriodId object, boolean bl2) {
        object = ((MediaPeriodId)object).periodUid;
        int n10 = timeline.getIndexOfPeriod(object);
        object = this.period;
        int n11 = timeline.getPeriod((int)n10, (Timeline$Period)object).windowIndex;
        Object object2 = this.window;
        object = timeline.getWindow(n11, (Timeline$Window)object2);
        n11 = (int)(((Timeline$Window)object).isDynamic ? 1 : 0);
        if (n11 != 0) return false;
        Timeline$Period timeline$Period = this.period;
        Timeline$Window timeline$Window = this.window;
        int n12 = this.repeatMode;
        boolean bl3 = this.shuffleModeEnabled;
        object2 = timeline;
        boolean bl4 = timeline.isLastPeriod(n10, timeline$Period, timeline$Window, n12, bl3);
        if (!bl4) return false;
        if (!bl2) return false;
        return true;
    }

    private boolean isLastInWindow(Timeline object, MediaSource$MediaPeriodId object2) {
        int n10 = this.isLastInPeriod((MediaSource$MediaPeriodId)object2);
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        Object object3 = ((MediaPeriodId)object2).periodUid;
        Object object4 = this.period;
        object3 = ((Timeline)object).getPeriodByUid(object3, (Timeline$Period)object4);
        n10 = ((Timeline$Period)object3).windowIndex;
        object2 = ((MediaPeriodId)object2).periodUid;
        int n11 = ((Timeline)object).getIndexOfPeriod(object2);
        object4 = this.window;
        object = ((Timeline)object).getWindow(n10, (Timeline$Window)object4);
        int n12 = ((Timeline$Window)object).lastPeriodIndex;
        if (n12 == n11) {
            bl2 = true;
        }
        return bl2;
    }

    private void notifyQueueUpdate() {
        Object object = this.analyticsCollector;
        if (object != null) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
            Object object2;
            object = ImmutableList.builder();
            for (object2 = this.playing; object2 != null; object2 = ((MediaPeriodHolder)object2).getNext()) {
                mediaSource$MediaPeriodId = object2.info.id;
                ((ImmutableList$Builder)object).add(mediaSource$MediaPeriodId);
            }
            object2 = this.reading;
            object2 = object2 == null ? null : object2.info.id;
            mediaSource$MediaPeriodId = this.analyticsCollectorHandler;
            z z10 = new z(this, (ImmutableList$Builder)object, (MediaSource$MediaPeriodId)object2);
            mediaSource$MediaPeriodId.post(z10);
        }
    }

    private static MediaSource$MediaPeriodId resolveMediaPeriodIdForAds(Timeline object, Object object2, long l10, long l11, Timeline$Period timeline$Period) {
        ((Timeline)object).getPeriodByUid(object2, timeline$Period);
        int n10 = timeline$Period.getAdGroupIndexForPositionUs(l10);
        int n11 = -1;
        if (n10 == n11) {
            n11 = timeline$Period.getAdGroupIndexAfterPositionUs(l10);
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object2, l11, n11);
            return mediaSource$MediaPeriodId;
        }
        int n12 = timeline$Period.getFirstAdIndexToPlay(n10);
        object = new MediaSource$MediaPeriodId(object2, n10, n12, l11);
        return object;
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline object, Object object2) {
        long l10;
        int n10;
        Object object3;
        int n11;
        Timeline$Period timeline$Period = this.period;
        timeline$Period = ((Timeline)object).getPeriodByUid(object2, timeline$Period);
        int n12 = timeline$Period.windowIndex;
        Object object4 = this.oldFrontPeriodUid;
        int n13 = -1;
        if (object4 != null && (n11 = ((Timeline)object).getIndexOfPeriod(object4)) != n13) {
            object3 = this.period;
            object4 = ((Timeline)object).getPeriod(n11, (Timeline$Period)object3);
            n11 = ((Timeline$Period)object4).windowIndex;
            if (n11 == n12) {
                return this.oldFrontPeriodWindowSequenceNumber;
            }
        }
        for (object4 = this.playing; object4 != null; object4 = ((MediaPeriodHolder)object4).getNext()) {
            object3 = ((MediaPeriodHolder)object4).uid;
            n10 = object3.equals(object2);
            if (n10 == 0) continue;
            return object4.info.id.windowSequenceNumber;
        }
        for (object4 = this.playing; object4 != null; object4 = ((MediaPeriodHolder)object4).getNext()) {
            object3 = ((MediaPeriodHolder)object4).uid;
            n10 = ((Timeline)object).getIndexOfPeriod(object3);
            if (n10 == n13) continue;
            Timeline$Period timeline$Period2 = this.period;
            object3 = ((Timeline)object).getPeriod(n10, timeline$Period2);
            n10 = ((Timeline$Period)object3).windowIndex;
            if (n10 != n12) continue;
            return object4.info.id.windowSequenceNumber;
        }
        long l11 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = l10 = 1L + l11;
        object = this.playing;
        if (object == null) {
            this.oldFrontPeriodUid = object2;
            this.oldFrontPeriodWindowSequenceNumber = l11;
        }
        return l11;
    }

    private boolean updateForPlaybackModeChange(Timeline object) {
        int n10;
        Object object2 = this.playing;
        boolean bl2 = true;
        if (object2 == null) {
            return bl2;
        }
        Object object3 = ((MediaPeriodHolder)object2).uid;
        int n11 = n10 = ((Timeline)object).getIndexOfPeriod(object3);
        while (true) {
            Object object4 = this.period;
            Timeline$Window timeline$Window = this.window;
            int n12 = this.repeatMode;
            boolean bl3 = this.shuffleModeEnabled;
            object3 = object;
            n11 = ((Timeline)object).getNextPeriodIndex(n11, (Timeline$Period)object4, timeline$Window, n12, bl3);
            while ((object3 = ((MediaPeriodHolder)object2).getNext()) != null) {
                object3 = ((MediaPeriodHolder)object2).info;
                n10 = (int)(((MediaPeriodInfo)object3).isLastInTimelinePeriod ? 1 : 0);
                if (n10 != 0) break;
                object2 = ((MediaPeriodHolder)object2).getNext();
            }
            object3 = ((MediaPeriodHolder)object2).getNext();
            int n13 = -1;
            if (n11 == n13 || object3 == null || (n13 = ((Timeline)object).getIndexOfPeriod(object4 = ((MediaPeriodHolder)object3).uid)) != n11) break;
            object2 = object3;
        }
        n10 = (int)(this.removeAfter((MediaPeriodHolder)object2) ? 1 : 0);
        MediaPeriodInfo mediaPeriodInfo = ((MediaPeriodHolder)object2).info;
        ((MediaPeriodHolder)object2).info = object = this.getUpdatedMediaPeriodInfo((Timeline)object, mediaPeriodInfo);
        return (n10 ^ 1) != 0;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        int n10;
        Object object = this.playing;
        Object object2 = null;
        if (object == null) {
            return null;
        }
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        if (object == mediaPeriodHolder) {
            object = ((MediaPeriodHolder)object).getNext();
            this.reading = object;
        }
        object = this.playing;
        ((MediaPeriodHolder)object).release();
        this.length = n10 = this.length + -1;
        if (n10 == 0) {
            long l10;
            this.loading = null;
            object = this.playing;
            this.oldFrontPeriodUid = object2 = ((MediaPeriodHolder)object).uid;
            object = object.info.id;
            this.oldFrontPeriodWindowSequenceNumber = l10 = ((MediaPeriodId)object).windowSequenceNumber;
        }
        object = this.playing.getNext();
        this.playing = object;
        this.notifyQueueUpdate();
        return this.playing;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        boolean bl2;
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        if (mediaPeriodHolder != null && (mediaPeriodHolder = mediaPeriodHolder.getNext()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPeriodHolder = null;
        }
        Assertions.checkState(bl2);
        this.reading = mediaPeriodHolder = this.reading.getNext();
        this.notifyQueueUpdate();
        return this.reading;
    }

    public /* synthetic */ void b(ImmutableList$Builder immutableList$Builder, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.a(immutableList$Builder, mediaSource$MediaPeriodId);
    }

    public void clear() {
        long l10;
        MediaPeriodHolder mediaPeriodHolder;
        Object object;
        int n10 = this.length;
        if (n10 == 0) {
            return;
        }
        this.oldFrontPeriodUid = object = mediaPeriodHolder.uid;
        object = mediaPeriodHolder.info.id;
        this.oldFrontPeriodWindowSequenceNumber = l10 = ((MediaPeriodId)object).windowSequenceNumber;
        for (mediaPeriodHolder = (MediaPeriodHolder)Assertions.checkStateNotNull(this.playing); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            mediaPeriodHolder.release();
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
        this.notifyQueueUpdate();
    }

    public MediaPeriodHolder enqueueNextMediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArray, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        int n10;
        MediaPeriodHolder mediaPeriodHolder;
        long l10;
        long l11;
        MediaPeriodQueue mediaPeriodQueue = this;
        Object object = this.loading;
        if (object == null) {
            long l12;
            long l13;
            object = mediaPeriodInfo.id;
            boolean n102 = ((MediaPeriodId)object).isAd();
            if (!n102 || (l13 = (l12 = (l11 = mediaPeriodInfo.requestedContentPositionUs) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                l11 = 0L;
            }
        } else {
            l11 = ((MediaPeriodHolder)object).getRendererOffset();
            MediaPeriodInfo mediaPeriodInfo2 = this.loading.info;
            l10 = mediaPeriodInfo2.durationUs;
            l11 += l10;
            l10 = mediaPeriodInfo.startPositionUs;
            l11 -= l10;
        }
        l10 = l11;
        object = mediaPeriodHolder;
        mediaPeriodHolder = new MediaPeriodHolder(rendererCapabilitiesArray, l11, trackSelector, allocator, mediaSourceList, mediaPeriodInfo, trackSelectorResult);
        object = mediaPeriodQueue.loading;
        if (object != null) {
            ((MediaPeriodHolder)object).setNext(mediaPeriodHolder);
        } else {
            mediaPeriodQueue.playing = mediaPeriodHolder;
            mediaPeriodQueue.reading = mediaPeriodHolder;
        }
        mediaPeriodQueue.oldFrontPeriodUid = null;
        mediaPeriodQueue.loading = mediaPeriodHolder;
        mediaPeriodQueue.length = n10 = mediaPeriodQueue.length + 1;
        this.notifyQueueUpdate();
        return mediaPeriodHolder;
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long l10, PlaybackInfo object) {
        MediaPeriodInfo mediaPeriodInfo;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            mediaPeriodInfo = this.getFirstMediaPeriodInfo((PlaybackInfo)object);
        } else {
            object = ((PlaybackInfo)object).timeline;
            mediaPeriodInfo = this.getFollowingMediaPeriodInfo((Timeline)object, mediaPeriodHolder, l10);
        }
        return mediaPeriodInfo;
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    /*
     * Enabled aggressive block sorting
     */
    public MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline object, MediaPeriodInfo mediaPeriodInfo) {
        long l10;
        long l11;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        boolean bl2 = this.isLastInPeriod(mediaSource$MediaPeriodId);
        boolean bl3 = this.isLastInWindow((Timeline)object, mediaSource$MediaPeriodId);
        boolean bl4 = this.isLastInTimeline((Timeline)object, mediaSource$MediaPeriodId, bl2);
        Object object2 = mediaPeriodInfo.id.periodUid;
        Timeline$Period timeline$Period = this.period;
        ((Timeline)object).getPeriodByUid(object2, timeline$Period);
        boolean bl5 = mediaSource$MediaPeriodId.isAd();
        if (bl5) {
            object = this.period;
            int n10 = mediaSource$MediaPeriodId.adGroupIndex;
            int n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            l11 = ((Timeline$Period)object).getAdDurationUs(n10, n11);
        } else {
            long l12;
            long l13;
            l11 = mediaPeriodInfo.endPositionUs;
            l10 = -9223372036854775807L;
            long l14 = l11 - l10;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 == false || (l13 = (l12 = l11 - (l10 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                object = this.period;
                l11 = ((Timeline$Period)object).getDurationUs();
            }
        }
        long l15 = l11;
        l11 = mediaPeriodInfo.startPositionUs;
        l10 = mediaPeriodInfo.requestedContentPositionUs;
        long l16 = mediaPeriodInfo.endPositionUs;
        object2 = object;
        return new MediaPeriodInfo(mediaSource$MediaPeriodId, l11, l10, l16, l15, bl2, bl3, bl4);
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        boolean bl2;
        Object object = this.loading;
        if (object != null && (object = ((MediaPeriodHolder)object).mediaPeriod) == mediaPeriod) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPeriod = null;
        }
        return bl2;
    }

    public void reevaluateBuffer(long l10) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(l10);
        }
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder mediaPeriodHolder2;
        int n10;
        int n11 = 1;
        int n12 = 0;
        MediaPeriodHolder mediaPeriodHolder3 = null;
        if (mediaPeriodHolder != null) {
            n10 = n11;
        } else {
            n10 = 0;
            mediaPeriodHolder2 = null;
        }
        Assertions.checkState(n10 != 0);
        mediaPeriodHolder2 = this.loading;
        n10 = mediaPeriodHolder.equals(mediaPeriodHolder2);
        if (n10 != 0) {
            return false;
        }
        this.loading = mediaPeriodHolder;
        while ((mediaPeriodHolder2 = mediaPeriodHolder.getNext()) != null) {
            if ((mediaPeriodHolder = mediaPeriodHolder.getNext()) == (mediaPeriodHolder2 = this.reading)) {
                this.reading = mediaPeriodHolder3 = this.playing;
                n12 = n11;
            }
            mediaPeriodHolder.release();
            this.length = n10 = this.length - n11;
        }
        this.loading.setNext(null);
        this.notifyQueueUpdate();
        return n12 != 0;
    }

    public MediaSource$MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object object, long l10) {
        long l11 = this.resolvePeriodIndexToWindowSequenceNumber(timeline, object);
        Timeline$Period timeline$Period = this.period;
        return MediaPeriodQueue.resolveMediaPeriodIdForAds(timeline, object, l10, l11, timeline$Period);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean shouldLoadNextMediaPeriod() {
        void var4_9;
        block2: {
            block3: {
                int n10;
                boolean bl2;
                Object object = this.loading;
                if (object == null) break block2;
                MediaPeriodInfo mediaPeriodInfo = ((MediaPeriodHolder)object).info;
                int n11 = mediaPeriodInfo.isFinal;
                if (n11 != 0 || !(bl2 = ((MediaPeriodHolder)object).isFullyBuffered())) break block3;
                object = this.loading.info;
                long l10 = ((MediaPeriodInfo)object).durationUs;
                long l11 = -9223372036854775807L;
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false && (n10 = this.length) < (n11 = 100)) break block2;
            }
            boolean bl3 = false;
            return (boolean)var4_9;
        }
        boolean bl4 = true;
        return (boolean)var4_9;
    }

    public boolean updateQueuedPeriods(Timeline timeline, long l10, long l11) {
        boolean bl2;
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        Object object = null;
        while (true) {
            MediaPeriodInfo mediaPeriodInfo;
            bl2 = true;
            if (mediaPeriodHolder == null) break;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.info;
            if (object == null) {
                object = this.getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo2);
            } else {
                mediaPeriodInfo = this.getFollowingMediaPeriodInfo(timeline, (MediaPeriodHolder)object, l10);
                if (mediaPeriodInfo == null) {
                    return this.removeAfter((MediaPeriodHolder)object) ^ bl2;
                }
                boolean bl3 = this.canKeepMediaPeriodHolder(mediaPeriodInfo2, mediaPeriodInfo);
                if (!bl3) {
                    return this.removeAfter((MediaPeriodHolder)object) ^ bl2;
                }
                object = mediaPeriodInfo;
            }
            long l12 = mediaPeriodInfo2.requestedContentPositionUs;
            mediaPeriodHolder.info = mediaPeriodInfo = ((MediaPeriodInfo)object).copyWithRequestedContentPositionUs(l12);
            long l13 = mediaPeriodInfo2.durationUs;
            long l14 = ((MediaPeriodInfo)object).durationUs;
            boolean bl4 = this.areDurationsCompatible(l13, l14);
            if (!bl4) {
                boolean bl5;
                long l15;
                long l16 = ((MediaPeriodInfo)object).durationUs;
                l13 = -9223372036854775807L;
                long l17 = l16 - l13;
                Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                l16 = object2 == false ? Long.MAX_VALUE : mediaPeriodHolder.toRendererTime(l16);
                MediaPeriodHolder mediaPeriodHolder2 = this.reading;
                object = null;
                if (mediaPeriodHolder == mediaPeriodHolder2 && ((object2 = (l15 = l11 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false || (bl5 = l11 == l16 ? 0 : (l11 < l16 ? -1 : 1)) >= false)) {
                    bl5 = bl2;
                } else {
                    bl5 = false;
                    timeline = null;
                }
                boolean bl6 = this.removeAfter(mediaPeriodHolder);
                if (bl6 || bl5) {
                    bl2 = false;
                }
                return bl2;
            }
            MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder.getNext();
            object = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder3;
        }
        return bl2;
    }

    public boolean updateRepeatMode(Timeline timeline, int n10) {
        this.repeatMode = n10;
        return this.updateForPlaybackModeChange(timeline);
    }

    public boolean updateShuffleModeEnabled(Timeline timeline, boolean bl2) {
        this.shuffleModeEnabled = bl2;
        return this.updateForPlaybackModeChange(timeline);
    }
}


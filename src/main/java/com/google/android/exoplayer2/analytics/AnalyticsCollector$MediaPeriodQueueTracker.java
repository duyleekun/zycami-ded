/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Iterables;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;

public final class AnalyticsCollector$MediaPeriodQueueTracker {
    private MediaSource$MediaPeriodId currentPlayerMediaPeriod;
    private ImmutableList mediaPeriodQueue;
    private ImmutableMap mediaPeriodTimelines;
    private final Timeline$Period period;
    private MediaSource$MediaPeriodId playingMediaPeriod;
    private MediaSource$MediaPeriodId readingMediaPeriod;

    public AnalyticsCollector$MediaPeriodQueueTracker(Timeline$Period object) {
        this.period = object;
        this.mediaPeriodQueue = object = ImmutableList.of();
        this.mediaPeriodTimelines = object = ImmutableMap.of();
    }

    public static /* synthetic */ ImmutableList access$000(AnalyticsCollector$MediaPeriodQueueTracker analyticsCollector$MediaPeriodQueueTracker) {
        return analyticsCollector$MediaPeriodQueueTracker.mediaPeriodQueue;
    }

    private void addTimelineForMediaPeriodId(ImmutableMap$Builder immutableMap$Builder, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline timeline) {
        int n10;
        if (mediaSource$MediaPeriodId == null) {
            return;
        }
        Object object = mediaSource$MediaPeriodId.periodUid;
        int n11 = timeline.getIndexOfPeriod(object);
        if (n11 != (n10 = -1)) {
            immutableMap$Builder.put(mediaSource$MediaPeriodId, timeline);
        } else {
            timeline = (Timeline)this.mediaPeriodTimelines.get(mediaSource$MediaPeriodId);
            if (timeline != null) {
                immutableMap$Builder.put(mediaSource$MediaPeriodId, timeline);
            }
        }
    }

    private static MediaSource$MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList immutableList, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline$Period timeline$Period) {
        boolean bl2;
        int n10;
        int n11;
        boolean bl3;
        int n12;
        Object object;
        Object object2 = player.getCurrentTimeline();
        int n13 = player.getCurrentPeriodIndex();
        boolean bl4 = ((Timeline)object2).isEmpty();
        if (bl4) {
            bl4 = false;
            object = null;
        } else {
            object = ((Timeline)object2).getUidOfPeriod(n13);
        }
        boolean bl5 = player.isPlayingAd();
        if (!bl5 && !(bl5 = ((Timeline)object2).isEmpty())) {
            object2 = ((Timeline)object2).getPeriod(n13, timeline$Period);
            long l10 = C.msToUs(player.getCurrentPosition());
            long l11 = timeline$Period.getPositionInWindowUs();
            n12 = ((Timeline$Period)object2).getAdGroupIndexAfterPositionUs(l10 -= l11);
        } else {
            n12 = -1;
        }
        object2 = null;
        for (int i10 = 0; i10 < (n13 = immutableList.size()); ++i10) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = (MediaSource$MediaPeriodId)immutableList.get(i10);
            bl5 = AnalyticsCollector$MediaPeriodQueueTracker.isMatchingMediaPeriod(mediaSource$MediaPeriodId2, object, bl3 = player.isPlayingAd(), n11 = player.getCurrentAdGroupIndex(), n10 = player.getCurrentAdIndexInAdGroup(), n12);
            if (!bl5) continue;
            return mediaSource$MediaPeriodId2;
        }
        boolean bl6 = immutableList.isEmpty();
        if (bl6 && mediaSource$MediaPeriodId != null && (bl2 = AnalyticsCollector$MediaPeriodQueueTracker.isMatchingMediaPeriod(mediaSource$MediaPeriodId, object, bl3 = player.isPlayingAd(), n11 = player.getCurrentAdGroupIndex(), n10 = player.getCurrentAdIndexInAdGroup(), n12))) {
            return mediaSource$MediaPeriodId;
        }
        return null;
    }

    private static boolean isMatchingMediaPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Object object, boolean n10, int n11, int n12, int n13) {
        int n14;
        int n15 = mediaSource$MediaPeriodId.periodUid.equals(object);
        boolean bl2 = false;
        if (n15 == 0) {
            return false;
        }
        if (n10 != 0 && (n15 = mediaSource$MediaPeriodId.adGroupIndex) == n11 && (n15 = mediaSource$MediaPeriodId.adIndexInAdGroup) == n12 || n10 == 0 && (n15 = mediaSource$MediaPeriodId.adGroupIndex) == (n10 = -1) && (n14 = mediaSource$MediaPeriodId.nextAdGroupIndex) == n13) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private void updateMediaPeriodTimelines(Timeline object) {
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Object object2 = this.mediaPeriodQueue;
        boolean n10 = ((AbstractCollection)object2).isEmpty();
        if (n10) {
            boolean bl2;
            boolean bl3;
            object2 = this.playingMediaPeriod;
            this.addTimelineForMediaPeriodId(immutableMap$Builder, (MediaSource$MediaPeriodId)object2, (Timeline)object);
            object2 = this.readingMediaPeriod;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playingMediaPeriod;
            boolean bl4 = Objects.equal(object2, mediaSource$MediaPeriodId);
            if (!bl4) {
                object2 = this.readingMediaPeriod;
                this.addTimelineForMediaPeriodId(immutableMap$Builder, (MediaSource$MediaPeriodId)object2, (Timeline)object);
            }
            if (!(bl3 = Objects.equal(object2 = this.currentPlayerMediaPeriod, mediaSource$MediaPeriodId = this.playingMediaPeriod)) && !(bl2 = Objects.equal(object2 = this.currentPlayerMediaPeriod, mediaSource$MediaPeriodId = this.readingMediaPeriod))) {
                object2 = this.currentPlayerMediaPeriod;
                this.addTimelineForMediaPeriodId(immutableMap$Builder, (MediaSource$MediaPeriodId)object2, (Timeline)object);
            }
        } else {
            Object object3;
            int n11;
            void var4_9;
            boolean bl5 = false;
            object2 = null;
            while (++var4_9 < (n11 = ((AbstractCollection)(object3 = this.mediaPeriodQueue)).size())) {
                object3 = (MediaSource$MediaPeriodId)this.mediaPeriodQueue.get((int)var4_9);
                this.addTimelineForMediaPeriodId(immutableMap$Builder, (MediaSource$MediaPeriodId)object3, (Timeline)object);
            }
            object2 = this.mediaPeriodQueue;
            object3 = this.currentPlayerMediaPeriod;
            boolean bl6 = ((ImmutableList)object2).contains(object3);
            if (!bl6) {
                object2 = this.currentPlayerMediaPeriod;
                this.addTimelineForMediaPeriodId(immutableMap$Builder, (MediaSource$MediaPeriodId)object2, (Timeline)object);
            }
        }
        this.mediaPeriodTimelines = object = immutableMap$Builder.build();
    }

    public MediaSource$MediaPeriodId getCurrentPlayerMediaPeriod() {
        return this.currentPlayerMediaPeriod;
    }

    public MediaSource$MediaPeriodId getLoadingMediaPeriod() {
        Object object = this.mediaPeriodQueue;
        boolean bl2 = ((AbstractCollection)object).isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = (MediaSource$MediaPeriodId)Iterables.getLast(this.mediaPeriodQueue);
        }
        return object;
    }

    public Timeline getMediaPeriodIdTimeline(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return (Timeline)this.mediaPeriodTimelines.get(mediaSource$MediaPeriodId);
    }

    public MediaSource$MediaPeriodId getPlayingMediaPeriod() {
        return this.playingMediaPeriod;
    }

    public MediaSource$MediaPeriodId getReadingMediaPeriod() {
        return this.readingMediaPeriod;
    }

    public void onPositionDiscontinuity(Player object) {
        ImmutableList immutableList = this.mediaPeriodQueue;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playingMediaPeriod;
        Timeline$Period timeline$Period = this.period;
        this.currentPlayerMediaPeriod = object = AnalyticsCollector$MediaPeriodQueueTracker.findCurrentPlayerMediaPeriodInQueue((Player)object, immutableList, mediaSource$MediaPeriodId, timeline$Period);
    }

    public void onQueueUpdated(List object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Player player) {
        Object object2 = ImmutableList.copyOf((Collection)object);
        this.mediaPeriodQueue = object2;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            bl2 = false;
            object2 = null;
            this.playingMediaPeriod = object = (MediaSource$MediaPeriodId)object.get(0);
            this.readingMediaPeriod = object = (MediaSource$MediaPeriodId)Assertions.checkNotNull(mediaSource$MediaPeriodId);
        }
        if ((object = this.currentPlayerMediaPeriod) == null) {
            object = this.mediaPeriodQueue;
            mediaSource$MediaPeriodId = this.playingMediaPeriod;
            object2 = this.period;
            this.currentPlayerMediaPeriod = object = AnalyticsCollector$MediaPeriodQueueTracker.findCurrentPlayerMediaPeriodInQueue(player, (ImmutableList)object, mediaSource$MediaPeriodId, (Timeline$Period)object2);
        }
        object = player.getCurrentTimeline();
        this.updateMediaPeriodTimelines((Timeline)object);
    }

    public void onTimelineChanged(Player object) {
        Object object2 = this.mediaPeriodQueue;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playingMediaPeriod;
        Timeline$Period timeline$Period = this.period;
        this.currentPlayerMediaPeriod = object2 = AnalyticsCollector$MediaPeriodQueueTracker.findCurrentPlayerMediaPeriodInQueue((Player)object, (ImmutableList)object2, mediaSource$MediaPeriodId, timeline$Period);
        object = object.getCurrentTimeline();
        this.updateMediaPeriodTimelines((Timeline)object);
    }
}


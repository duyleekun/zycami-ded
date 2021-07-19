/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.analytics;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.AnalyticsListener$Events;
import com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.analytics.PlaybackStatsListener$Callback;
import com.google.android.exoplayer2.analytics.PlaybackStatsListener$PlaybackStatsTracker;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class PlaybackStatsListener
implements AnalyticsListener,
PlaybackSessionManager$Listener {
    private String activeAdPlayback;
    private String activeContentPlayback;
    public Format audioFormat;
    public long bandwidthBytes;
    public long bandwidthTimeMs;
    private final PlaybackStatsListener$Callback callback;
    public int discontinuityReason;
    public int droppedFrames;
    private PlaybackStats finishedPlaybackStats;
    private final boolean keepHistory;
    public Exception nonFatalException;
    private AnalyticsListener$EventTime onSeekStartedEventTime;
    private final Timeline$Period period;
    private final Map playbackStatsTrackers;
    private final PlaybackSessionManager sessionManager;
    private final Map sessionStartEventTimes;
    public Format videoFormat;
    public int videoHeight;
    public int videoWidth;

    public PlaybackStatsListener(boolean bl2, PlaybackStatsListener$Callback object) {
        this.callback = object;
        this.keepHistory = bl2;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        object = new HashMap();
        this.playbackStatsTrackers = object;
        object = new HashMap();
        this.sessionStartEventTimes = object;
        this.finishedPlaybackStats = object = PlaybackStats.EMPTY;
        this.period = object = new Timeline$Period();
        defaultPlaybackSessionManager.setListener(this);
    }

    private Pair findBestEventTime(AnalyticsListener$Events analyticsListener$Events, String string2) {
        Object object;
        Object object2;
        int n10;
        Object object3;
        boolean bl2;
        PlaybackStatsListener playbackStatsListener = this;
        Object object4 = analyticsListener$Events;
        Object object5 = string2;
        Object object6 = this.onSeekStartedEventTime;
        int n11 = 0;
        Object object7 = null;
        if (object6 != null && (bl2 = (object3 = this.sessionManager).belongsToSession((AnalyticsListener$EventTime)object6, string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object3 = null;
        }
        while (n11 < (n10 = analyticsListener$Events.size())) {
            long l10;
            long l11;
            long l12;
            long l13;
            n10 = ((AnalyticsListener$Events)object4).get(n11);
            object2 = ((AnalyticsListener$Events)object4).getEventTime(n10);
            PlaybackSessionManager playbackSessionManager = playbackStatsListener.sessionManager;
            boolean bl3 = playbackSessionManager.belongsToSession((AnalyticsListener$EventTime)object2, (String)object5);
            if (object6 == null || bl3 && !bl2 || bl3 == bl2 && (l13 = (l12 = (l11 = ((AnalyticsListener$EventTime)object2).realtimeMs) - (l10 = ((AnalyticsListener$EventTime)object6).realtimeMs)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                object6 = object2;
                bl2 = bl3;
            }
            ++n11;
        }
        Assertions.checkNotNull(object6);
        if (!bl2 && (object4 = ((AnalyticsListener$EventTime)object6).mediaPeriodId) != null && (object = ((MediaPeriodId)object4).isAd())) {
            long l14;
            object4 = ((AnalyticsListener$EventTime)object6).timeline;
            object7 = object6.mediaPeriodId.periodUid;
            object3 = playbackStatsListener.period;
            object4 = ((Timeline)object4).getPeriodByUid(object7, (Timeline$Period)object3);
            object7 = ((AnalyticsListener$EventTime)object6).mediaPeriodId;
            n11 = ((MediaPeriodId)object7).adGroupIndex;
            long l15 = ((Timeline$Period)object4).getAdGroupTimeUs(n11);
            long l16 = l15 - (l14 = Long.MIN_VALUE);
            object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (!object) {
                object4 = playbackStatsListener.period;
                l15 = ((Timeline$Period)object4).durationUs;
            }
            l14 = playbackStatsListener.period.getPositionInWindowUs();
            long l17 = ((AnalyticsListener$EventTime)object6).realtimeMs;
            Timeline timeline = ((AnalyticsListener$EventTime)object6).timeline;
            int n12 = ((AnalyticsListener$EventTime)object6).windowIndex;
            object2 = ((AnalyticsListener$EventTime)object6).mediaPeriodId;
            Object object8 = ((MediaPeriodId)object2).periodUid;
            long l18 = ((MediaPeriodId)object2).windowSequenceNumber;
            n10 = ((MediaPeriodId)object2).adGroupIndex;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object8, l18, n10);
            long l19 = C.usToMs(l15 += l14);
            Timeline timeline2 = ((AnalyticsListener$EventTime)object6).timeline;
            int n13 = ((AnalyticsListener$EventTime)object6).currentWindowIndex;
            object7 = ((AnalyticsListener$EventTime)object6).currentMediaPeriodId;
            long l20 = ((AnalyticsListener$EventTime)object6).currentPlaybackPositionMs;
            long l21 = ((AnalyticsListener$EventTime)object6).totalBufferedDurationMs;
            object2 = object4;
            object4 = new AnalyticsListener$EventTime(l17, timeline, n12, mediaSource$MediaPeriodId, l19, timeline2, n13, (MediaSource$MediaPeriodId)object7, l20, l21);
            object5 = playbackStatsListener.sessionManager;
            object6 = string2;
            bl2 = object5.belongsToSession((AnalyticsListener$EventTime)object4, string2);
            object6 = object4;
        }
        object4 = bl2;
        return Pair.create((Object)object6, (Object)object4);
    }

    private boolean hasEvent(AnalyticsListener$Events object, String string2, int n10) {
        PlaybackSessionManager playbackSessionManager;
        boolean bl2;
        boolean bl3 = ((AnalyticsListener$Events)object).contains(n10);
        if (bl3 && (bl2 = (playbackSessionManager = this.sessionManager).belongsToSession((AnalyticsListener$EventTime)(object = ((AnalyticsListener$Events)object).getEventTime(n10)), string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void maybeAddSessions(Player player, AnalyticsListener$Events analyticsListener$Events) {
        int n10;
        int n11;
        int n12;
        Object object = player.getCurrentTimeline();
        boolean n112 = ((Timeline)object).isEmpty();
        if (n112 && (n12 = player.getPlaybackState()) == (n11 = 1)) {
            return;
        }
        player = null;
        for (n12 = 0; n12 < (n10 = analyticsListener$Events.size()); ++n12) {
            n10 = analyticsListener$Events.get(n12);
            AnalyticsListener$EventTime analyticsListener$EventTime = analyticsListener$Events.getEventTime(n10);
            if (n10 == 0) {
                object = this.sessionManager;
                object.updateSessionsWithTimelineChange(analyticsListener$EventTime);
                continue;
            }
            int n13 = 12;
            if (n10 == n13) {
                object = this.sessionManager;
                n13 = this.discontinuityReason;
                object.updateSessionsWithDiscontinuity(analyticsListener$EventTime, n13);
                continue;
            }
            object = this.sessionManager;
            object.updateSessions(analyticsListener$EventTime);
        }
    }

    public PlaybackStats getCombinedPlaybackStats() {
        boolean bl2;
        int n10 = this.playbackStatsTrackers.size();
        int n11 = 1;
        PlaybackStats[] playbackStatsArray = new PlaybackStats[n10 += n11];
        Object object = this.finishedPlaybackStats;
        playbackStatsArray[0] = object;
        object = this.playbackStatsTrackers.values().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (PlaybackStatsListener$PlaybackStatsTracker)object.next();
            int n12 = n11 + 1;
            playbackStatsArray[n11] = object2 = ((PlaybackStatsListener$PlaybackStatsTracker)object2).build(false);
            n11 = n12;
        }
        return PlaybackStats.merge(playbackStatsArray);
    }

    public PlaybackStats getPlaybackStats() {
        Object object = this.activeAdPlayback;
        PlaybackStats playbackStats = null;
        if (object != null) {
            Map map = this.playbackStatsTrackers;
            object = (PlaybackStatsListener$PlaybackStatsTracker)map.get(object);
        } else {
            object = this.activeContentPlayback;
            if (object != null) {
                Map map = this.playbackStatsTrackers;
                object = (PlaybackStatsListener$PlaybackStatsTracker)map.get(object);
            } else {
                object = null;
            }
        }
        if (object != null) {
            playbackStats = ((PlaybackStatsListener$PlaybackStatsTracker)object).build(false);
        }
        return playbackStats;
    }

    public void onAdPlaybackStarted(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, String string3) {
        ((PlaybackStatsListener$PlaybackStatsTracker)Assertions.checkNotNull((PlaybackStatsListener$PlaybackStatsTracker)this.playbackStatsTrackers.get(string2))).onInterruptedByAd();
    }

    public void onBandwidthEstimate(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
        long l12;
        this.bandwidthTimeMs = l12 = (long)n10;
        this.bandwidthBytes = l10;
    }

    public void onDownstreamFormatChanged(AnalyticsListener$EventTime object, MediaLoadData mediaLoadData) {
        int n10 = mediaLoadData.trackType;
        int n11 = 2;
        if (n10 != n11 && n10 != 0) {
            n11 = 1;
            if (n10 == n11) {
                this.audioFormat = object = mediaLoadData.trackFormat;
            }
        } else {
            this.videoFormat = object = mediaLoadData.trackFormat;
        }
    }

    public void onDrmSessionManagerError(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
        this.nonFatalException = exception;
    }

    public void onDroppedVideoFrames(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10) {
        this.droppedFrames = n10;
    }

    public void onEvents(Player player, AnalyticsListener$Events analyticsListener$Events) {
        Object object;
        int n10;
        PlaybackStatsListener playbackStatsListener = this;
        Object object2 = analyticsListener$Events;
        int n11 = analyticsListener$Events.size();
        if (n11 == 0) {
            return;
        }
        this.maybeAddSessions(player, analyticsListener$Events);
        Iterator iterator2 = this.playbackStatsTrackers.keySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Format format;
            Object object3;
            Format format2;
            long l10;
            int n12;
            object = (String)iterator2.next();
            Object object4 = playbackStatsListener.findBestEventTime((AnalyticsListener$Events)object2, (String)object);
            Object object5 = playbackStatsListener.playbackStatsTrackers.get(object);
            Object object6 = object5;
            object6 = (PlaybackStatsListener$PlaybackStatsTracker)object5;
            boolean bl2 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 12);
            int n13 = 0;
            AnalyticsListener$EventTime analyticsListener$EventTime = null;
            boolean bl3 = bl2 || (bl2 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 0));
            bl2 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1023);
            boolean bl4 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1012);
            boolean bl5 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1000);
            int n14 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 11);
            boolean bl6 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1003);
            bl6 = bl6 || (bl6 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1032));
            int n15 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1006);
            int n16 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, 1004);
            n13 = 1028;
            n10 = playbackStatsListener.hasEvent((AnalyticsListener$Events)object2, (String)object, n13);
            analyticsListener$EventTime = (AnalyticsListener$EventTime)((Pair)object4).first;
            object4 = (Boolean)((Pair)object4).second;
            boolean bl7 = (Boolean)object4;
            Object object7 = playbackStatsListener.onSeekStartedEventTime;
            boolean bl8 = object7 != null;
            int n17 = bl2 ? (n12 = playbackStatsListener.droppedFrames) : 0;
            if (n14 != 0) {
                object7 = player.getPlayerError();
            } else {
                n12 = 0;
                object7 = null;
            }
            if (bl6) {
                object5 = playbackStatsListener.nonFatalException;
            } else {
                bl2 = false;
                object5 = null;
            }
            long l11 = n15 != 0 ? (l10 = playbackStatsListener.bandwidthTimeMs) : 0L;
            long l12 = n15 != 0 ? (l10 = playbackStatsListener.bandwidthBytes) : 0L;
            Format format3 = n16 != 0 ? (format2 = playbackStatsListener.videoFormat) : null;
            if (n16 != 0) {
                object3 = playbackStatsListener.audioFormat;
                format = object3;
            } else {
                format = null;
            }
            n16 = -1;
            int n18 = n10 != 0 ? (n14 = playbackStatsListener.videoHeight) : n16;
            n10 = n10 != 0 ? playbackStatsListener.videoWidth : n16;
            object3 = player;
            n14 = (int)(bl7 ? 1 : 0);
            bl6 = bl8;
            n15 = n17;
            ((PlaybackStatsListener$PlaybackStatsTracker)object6).onEvents(player, analyticsListener$EventTime, bl7, bl8, bl3, n17, bl4, bl5, (ExoPlaybackException)object7, (Exception)object5, l11, l12, format3, format, n18, n10);
        }
        object = null;
        playbackStatsListener.onSeekStartedEventTime = null;
        playbackStatsListener.videoFormat = null;
        playbackStatsListener.audioFormat = null;
        n11 = 1036;
        boolean bl9 = ((AnalyticsListener$Events)object2).contains(n11);
        if (bl9) {
            object = playbackStatsListener.sessionManager;
            object2 = ((AnalyticsListener$Events)object2).getEventTime(n11);
            object.finishAllSessions((AnalyticsListener$EventTime)object2);
        }
    }

    public void onLoadError(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.nonFatalException = iOException;
    }

    public void onPositionDiscontinuity(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        this.discontinuityReason = n10;
    }

    public void onSeekStarted(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.onSeekStartedEventTime = analyticsListener$EventTime;
    }

    public void onSessionActive(AnalyticsListener$EventTime object, String string2) {
        boolean bl2;
        PlaybackStatsListener$PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker = (PlaybackStatsListener$PlaybackStatsTracker)Assertions.checkNotNull((PlaybackStatsListener$PlaybackStatsTracker)this.playbackStatsTrackers.get(string2));
        playbackStatsListener$PlaybackStatsTracker.onForeground();
        object = ((AnalyticsListener$EventTime)object).mediaPeriodId;
        if (object != null && (bl2 = ((MediaPeriodId)object).isAd())) {
            this.activeAdPlayback = string2;
        } else {
            this.activeContentPlayback = string2;
        }
    }

    public void onSessionCreated(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
        boolean bl2 = this.keepHistory;
        PlaybackStatsListener$PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker = new PlaybackStatsListener$PlaybackStatsTracker(bl2, analyticsListener$EventTime);
        this.playbackStatsTrackers.put(string2, playbackStatsListener$PlaybackStatsTracker);
        this.sessionStartEventTimes.put(string2, analyticsListener$EventTime);
    }

    public void onSessionFinished(AnalyticsListener$EventTime object, String object2, boolean bl2) {
        PlaybackStats playbackStats;
        Object object3 = this.activeAdPlayback;
        boolean n10 = ((String)object2).equals(object3);
        if (n10) {
            this.activeAdPlayback = null;
        } else {
            object3 = this.activeContentPlayback;
            boolean bl3 = ((String)object2).equals(object3);
            if (bl3) {
                this.activeContentPlayback = null;
            }
        }
        object3 = (PlaybackStatsListener$PlaybackStatsTracker)Assertions.checkNotNull((PlaybackStatsListener$PlaybackStatsTracker)this.playbackStatsTrackers.remove(object2));
        object2 = (AnalyticsListener$EventTime)Assertions.checkNotNull((AnalyticsListener$EventTime)this.sessionStartEventTimes.remove(object2));
        object3.onFinished((AnalyticsListener$EventTime)object, bl2);
        int n11 = 1;
        PlaybackStats playbackStats2 = object3.build(n11 != 0);
        int n12 = 2;
        object3 = new PlaybackStats[n12];
        object3[0] = playbackStats = this.finishedPlaybackStats;
        object3[n11] = playbackStats2;
        this.finishedPlaybackStats = object = PlaybackStats.merge(object3);
        object = this.callback;
        if (object != null) {
            object.onPlaybackStatsReady((AnalyticsListener$EventTime)object2, playbackStats2);
        }
    }

    public void onVideoSizeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, int n12, float f10) {
        this.videoWidth = n10;
        this.videoHeight = n11;
    }
}


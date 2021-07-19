/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.analytics.PlaybackStats$EventTimeAndException;
import com.google.android.exoplayer2.analytics.PlaybackStats$EventTimeAndFormat;
import com.google.android.exoplayer2.analytics.PlaybackStats$EventTimeAndPlaybackState;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PlaybackStatsListener$PlaybackStatsTracker {
    private long audioFormatBitrateTimeProduct;
    private final List audioFormatHistory;
    private long audioFormatTimeMs;
    private long audioUnderruns;
    private long bandwidthBytes;
    private long bandwidthTimeMs;
    private Format currentAudioFormat;
    private float currentPlaybackSpeed;
    private int currentPlaybackState;
    private long currentPlaybackStateStartTimeMs;
    private Format currentVideoFormat;
    private long droppedFrames;
    private int fatalErrorCount;
    private final List fatalErrorHistory;
    private long firstReportedTimeMs;
    private boolean hasBeenReady;
    private boolean hasEnded;
    private boolean hasFatalError;
    private long initialAudioFormatBitrate;
    private long initialVideoFormatBitrate;
    private int initialVideoFormatHeight;
    private final boolean isAd;
    private boolean isForeground;
    private boolean isInterruptedByAd;
    private boolean isJoinTimeInvalid;
    private boolean isSeeking;
    private final boolean keepHistory;
    private long lastAudioFormatStartTimeMs;
    private long lastRebufferStartTimeMs;
    private long lastVideoFormatStartTimeMs;
    private long maxRebufferTimeMs;
    private final List mediaTimeHistory;
    private int nonFatalErrorCount;
    private final List nonFatalErrorHistory;
    private int pauseBufferCount;
    private int pauseCount;
    private final long[] playbackStateDurationsMs;
    private final List playbackStateHistory;
    private int rebufferCount;
    private int seekCount;
    private boolean startedLoading;
    private long videoFormatBitrateTimeMs;
    private long videoFormatBitrateTimeProduct;
    private long videoFormatHeightTimeMs;
    private long videoFormatHeightTimeProduct;
    private final List videoFormatHistory;

    public PlaybackStatsListener$PlaybackStatsTracker(boolean bl2, AnalyticsListener$EventTime object) {
        long l10;
        boolean bl3;
        long l11;
        this.keepHistory = bl2;
        int n10 = 16;
        Object object2 = new long[n10];
        this.playbackStateDurationsMs = object2;
        if (bl2) {
            object2 = new ArrayList;
        } else {
            object2 = Collections.emptyList();
        }
        this.playbackStateHistory = object2;
        if (bl2) {
            object2 = new ArrayList;
            super();
        } else {
            object2 = Collections.emptyList();
        }
        this.mediaTimeHistory = object2;
        if (bl2) {
            object2 = new ArrayList;
            super();
        } else {
            object2 = Collections.emptyList();
        }
        this.videoFormatHistory = object2;
        if (bl2) {
            object2 = new ArrayList;
            super();
        } else {
            object2 = Collections.emptyList();
        }
        this.audioFormatHistory = object2;
        if (bl2) {
            object2 = new ArrayList;
            super();
        } else {
            object2 = Collections.emptyList();
        }
        this.fatalErrorHistory = object2;
        List<Object> list = bl2 ? new ArrayList() : Collections.emptyList();
        this.nonFatalErrorHistory = list;
        bl2 = false;
        list = null;
        this.currentPlaybackState = 0;
        this.currentPlaybackStateStartTimeMs = l11 = ((AnalyticsListener$EventTime)object).realtimeMs;
        this.firstReportedTimeMs = l11 = -9223372036854775807L;
        this.maxRebufferTimeMs = l11;
        object = ((AnalyticsListener$EventTime)object).mediaPeriodId;
        if (object != null && (bl3 = ((MediaPeriodId)object).isAd())) {
            bl2 = true;
        }
        this.isAd = bl2;
        this.initialAudioFormatBitrate = l10 = (long)-1;
        this.initialVideoFormatBitrate = l10;
        this.initialVideoFormatHeight = -1;
        this.currentPlaybackSpeed = 1.0f;
    }

    private long[] guessMediaTimeBasedOnElapsedRealtime(long l10) {
        Object object = this.mediaTimeHistory;
        int n10 = object.size();
        int n11 = 1;
        object = (long[])object.get(n10 -= n11);
        Object object2 = object[0];
        reference var8_6 = object[n11];
        float f10 = l10 - object2;
        float f11 = this.currentPlaybackSpeed;
        object2 = (long)(f10 * f11);
        object = new long[2];
        object[0] = l10;
        object[n11] = var8_6 += object2;
        return object;
    }

    private static boolean isInvalidJoinTransition(int n10, int n11) {
        int n12 = 14;
        int n13 = 0;
        int n14 = 2;
        int n15 = 1;
        if (n10 != n15 && n10 != n14 && n10 != n12) {
            return false;
        }
        if (n11 != n15 && n11 != n14 && n11 != n12 && n11 != (n10 = 3) && n11 != (n10 = 4) && n11 != (n10 = 9) && n11 != (n10 = 11)) {
            n13 = n15;
        }
        return n13 != 0;
    }

    private static boolean isPausedState(int n10) {
        int n11 = 4;
        n10 = n10 != n11 && n10 != (n11 = 7) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean isReadyState(int n10) {
        int n11 = 3;
        n10 = n10 != n11 && n10 != (n11 = 4) && n10 != (n11 = 9) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean isRebufferingState(int n10) {
        int n11 = 6;
        n10 = n10 != n11 && n10 != (n11 = 7) && n10 != (n11 = 10) ? 0 : 1;
        return n10 != 0;
    }

    private void maybeRecordAudioFormatTime(long l10) {
        Format format;
        int n10 = this.currentPlaybackState;
        int n11 = 3;
        float f10 = 4.2E-45f;
        if (n10 == n11 && (format = this.currentAudioFormat) != null) {
            n10 = format.bitrate;
            n11 = -1;
            f10 = 0.0f / 0.0f;
            if (n10 != n11) {
                long l11;
                long l12 = this.lastAudioFormatStartTimeMs;
                f10 = l10 - l12;
                float f11 = this.currentPlaybackSpeed;
                l12 = (long)(f10 *= f11);
                this.audioFormatTimeMs = l11 = this.audioFormatTimeMs + l12;
                l11 = this.audioFormatBitrateTimeProduct;
                long l13 = n10;
                this.audioFormatBitrateTimeProduct = l11 += (l12 *= l13);
            }
        }
        this.lastAudioFormatStartTimeMs = l10;
    }

    private void maybeRecordVideoFormatTime(long l10) {
        Format format;
        int n10 = this.currentPlaybackState;
        int n11 = 3;
        float f10 = 4.2E-45f;
        if (n10 == n11 && (format = this.currentVideoFormat) != null) {
            long l11;
            long l12 = this.lastVideoFormatStartTimeMs;
            f10 = l10 - l12;
            float f11 = this.currentPlaybackSpeed;
            l12 = (long)(f10 *= f11);
            int n12 = format.height;
            int n13 = -1;
            if (n12 != n13) {
                this.videoFormatHeightTimeMs = l11 = this.videoFormatHeightTimeMs + l12;
                l11 = this.videoFormatHeightTimeProduct;
                long l13 = (long)n12 * l12;
                this.videoFormatHeightTimeProduct = l11 += l13;
            }
            if ((n10 = format.bitrate) != n13) {
                long l14;
                this.videoFormatBitrateTimeMs = l14 = this.videoFormatBitrateTimeMs + l12;
                l14 = this.videoFormatBitrateTimeProduct;
                l11 = n10;
                this.videoFormatBitrateTimeProduct = l14 += (l12 *= l11);
            }
        }
        this.lastVideoFormatStartTimeMs = l10;
    }

    private void maybeUpdateAudioFormat(AnalyticsListener$EventTime analyticsListener$EventTime, Format format) {
        int n10;
        long l10;
        long l11;
        Object object = this.currentAudioFormat;
        int n11 = Util.areEqual(object, format);
        if (n11 != 0) {
            return;
        }
        long l12 = analyticsListener$EventTime.realtimeMs;
        this.maybeRecordAudioFormatTime(l12);
        if (format != null && (n11 = (l11 = (l12 = this.initialAudioFormatBitrate) - (l10 = (long)-1)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == 0 && (n11 = format.bitrate) != (n10 = -1)) {
            this.initialAudioFormatBitrate = l12 = (long)n11;
        }
        this.currentAudioFormat = format;
        n11 = this.keepHistory;
        if (n11 != 0) {
            object = this.audioFormatHistory;
            PlaybackStats$EventTimeAndFormat playbackStats$EventTimeAndFormat = new PlaybackStats$EventTimeAndFormat(analyticsListener$EventTime, format);
            object.add(playbackStats$EventTimeAndFormat);
        }
    }

    private void maybeUpdateMaxRebufferTimeMs(long l10) {
        int n10 = PlaybackStatsListener$PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState);
        if (n10 != 0) {
            long l11 = this.lastRebufferStartTimeMs;
            l10 -= l11;
            l11 = this.maxRebufferTimeMs;
            long l12 = -9223372036854775807L;
            long l13 = l11 - l12;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object == false || (n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) > 0) {
                this.maxRebufferTimeMs = l10;
            }
        }
    }

    private void maybeUpdateMediaTimeHistory(long l10, long l11) {
        long[] lArray;
        long[] lArray2;
        Object object;
        Object object2 = this.keepHistory;
        if (object2 == 0) {
            return;
        }
        object2 = this.currentPlaybackState;
        int n10 = 3;
        int n11 = 2;
        long l12 = -9223372036854775807L;
        int n12 = 1;
        if (object2 != n10) {
            object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (object2 == 0) {
                return;
            }
            object = this.mediaTimeHistory;
            object2 = object.isEmpty();
            if (object2 == 0) {
                object = this.mediaTimeHistory;
                n10 = object.size() - n12;
                reference var12_9 = (object = (Object)((long[])object.get(n10)))[n12];
                reference cfr_temp_0 = var12_9 - l11;
                object2 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
                if (object2 != 0) {
                    object = this.mediaTimeHistory;
                    lArray2 = new long[n11];
                    lArray2[0] = l10;
                    lArray2[n12] = (long)var12_9;
                    object.add(lArray2);
                }
            }
        }
        object = this.mediaTimeHistory;
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        if (n10 == 0) {
            lArray = this.guessMediaTimeBasedOnElapsedRealtime(l10);
        } else {
            lArray2 = new long[n11];
            lArray2[0] = l10;
            lArray2[n12] = l11;
            lArray = lArray2;
        }
        object.add(lArray);
    }

    private void maybeUpdateVideoFormat(AnalyticsListener$EventTime analyticsListener$EventTime, Format format) {
        Object object = this.currentVideoFormat;
        int n10 = Util.areEqual(object, format);
        if (n10 != 0) {
            return;
        }
        long l10 = analyticsListener$EventTime.realtimeMs;
        this.maybeRecordVideoFormatTime(l10);
        if (format != null) {
            long l11;
            long l12;
            long l13;
            n10 = this.initialVideoFormatHeight;
            int n11 = -1;
            if (n10 == n11 && (n10 = format.height) != n11) {
                this.initialVideoFormatHeight = n10;
            }
            if ((n10 = (int)((l13 = (l12 = this.initialVideoFormatBitrate) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0 && (n10 = format.bitrate) != n11) {
                this.initialVideoFormatBitrate = l10 = (long)n10;
            }
        }
        this.currentVideoFormat = format;
        n10 = (int)(this.keepHistory ? 1 : 0);
        if (n10 != 0) {
            object = this.videoFormatHistory;
            PlaybackStats$EventTimeAndFormat playbackStats$EventTimeAndFormat = new PlaybackStats$EventTimeAndFormat(analyticsListener$EventTime, format);
            object.add(playbackStats$EventTimeAndFormat);
        }
    }

    private int resolveNewPlaybackState(Player player) {
        int n10;
        int n11 = player.getPlaybackState();
        int n12 = this.isSeeking;
        if (n12 != 0 && (n12 = this.isForeground) != 0) {
            return 5;
        }
        n12 = this.hasFatalError;
        if (n12 != 0) {
            return 13;
        }
        n12 = this.isForeground;
        if (n12 == 0) {
            return (int)(this.startedLoading ? 1 : 0);
        }
        n12 = this.isInterruptedByAd;
        int n13 = 14;
        if (n12 != 0) {
            return n13;
        }
        n12 = 4;
        if (n11 == n12) {
            return 11;
        }
        int n14 = 1;
        int n15 = 2;
        if (n11 == n15) {
            n11 = this.currentPlaybackState;
            if (n11 != 0 && n11 != n14 && n11 != n15 && n11 != n13) {
                n11 = (int)(player.getPlayWhenReady() ? 1 : 0);
                if (n11 == 0) {
                    return 7;
                }
                int n16 = player.getPlaybackSuppressionReason();
                n16 = n16 != 0 ? 10 : 6;
                return n16;
            }
            return n15;
        }
        n13 = 3;
        if (n11 == n13) {
            n11 = (int)(player.getPlayWhenReady() ? 1 : 0);
            if (n11 == 0) {
                return n12;
            }
            int n17 = player.getPlaybackSuppressionReason();
            if (n17 != 0) {
                n13 = 9;
            }
            return n13;
        }
        if (n11 == n14 && (n10 = this.currentPlaybackState) != 0) {
            return 12;
        }
        return this.currentPlaybackState;
    }

    private void updatePlaybackState(int n10, AnalyticsListener$EventTime analyticsListener$EventTime) {
        long l10;
        Object object;
        long l11 = analyticsListener$EventTime.realtimeMs;
        long l12 = this.currentPlaybackStateStartTimeMs;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        int n11 = 0;
        PlaybackStats$EventTimeAndPlaybackState playbackStats$EventTimeAndPlaybackState = null;
        int n12 = 1;
        if (l13 >= 0) {
            l13 = n12;
        } else {
            l13 = 0;
            object = null;
        }
        Assertions.checkArgument((boolean)l13);
        long l14 = analyticsListener$EventTime.realtimeMs;
        long l15 = this.currentPlaybackStateStartTimeMs;
        l15 = l14 - l15;
        object = this.playbackStateDurationsMs;
        int n13 = this.currentPlaybackState;
        object[n13] = l10 = object[n13] + l15;
        l15 = this.firstReportedTimeMs;
        l10 = -9223372036854775807L;
        l13 = l15 == l10 ? 0 : (l15 < l10 ? -1 : 1);
        if (l13 == false) {
            this.firstReportedTimeMs = l14;
        }
        l13 = (long)this.isJoinTimeInvalid;
        int n14 = PlaybackStatsListener$PlaybackStatsTracker.isInvalidJoinTransition(n13, n10);
        l13 = l13 | n14;
        this.isJoinTimeInvalid = l13;
        l13 = (long)this.hasBeenReady;
        n14 = PlaybackStatsListener$PlaybackStatsTracker.isReadyState(n10);
        l13 = l13 | n14;
        this.hasBeenReady = l13;
        l13 = (long)this.hasEnded;
        n14 = 11;
        if (n10 == n14) {
            n11 = n12;
        }
        l13 = l13 | n11;
        this.hasEnded = l13;
        l13 = (long)PlaybackStatsListener$PlaybackStatsTracker.isPausedState(this.currentPlaybackState);
        if (l13 == false && (l13 = (long)PlaybackStatsListener$PlaybackStatsTracker.isPausedState(n10)) != false) {
            l13 = this.pauseCount + n12;
            this.pauseCount = (int)l13;
        }
        if (n10 == (l13 = (long)5)) {
            l13 = this.seekCount + n12;
            this.seekCount = (int)l13;
        }
        if ((l13 = (long)PlaybackStatsListener$PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState)) == false && (l13 = (long)PlaybackStatsListener$PlaybackStatsTracker.isRebufferingState(n10)) != false) {
            l13 = this.rebufferCount + n12;
            this.rebufferCount = (int)l13;
            this.lastRebufferStartTimeMs = l11 = analyticsListener$EventTime.realtimeMs;
        }
        if ((l13 = (long)PlaybackStatsListener$PlaybackStatsTracker.isRebufferingState(this.currentPlaybackState)) != false && (l13 = (long)this.currentPlaybackState) != (n11 = 7) && n10 == n11) {
            l13 = this.pauseBufferCount + n12;
            this.pauseBufferCount = (int)l13;
        }
        l11 = analyticsListener$EventTime.realtimeMs;
        this.maybeUpdateMaxRebufferTimeMs(l11);
        this.currentPlaybackState = n10;
        this.currentPlaybackStateStartTimeMs = l11 = analyticsListener$EventTime.realtimeMs;
        l13 = (long)this.keepHistory;
        if (l13 != false) {
            object = this.playbackStateHistory;
            playbackStats$EventTimeAndPlaybackState = new PlaybackStats$EventTimeAndPlaybackState(analyticsListener$EventTime, n10);
            object.add(playbackStats$EventTimeAndPlaybackState);
        }
    }

    /*
     * WARNING - void declaration
     */
    public PlaybackStats build(boolean bl2) {
        long l10;
        ArrayList arrayList;
        Object object;
        void var21_21;
        boolean bl3;
        List<long[]> list;
        long[] lArray;
        int n10;
        List<long[]> list2;
        Object object2;
        int n11;
        long l11;
        int n12;
        PlaybackStatsListener$PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker = this;
        long[] lArray2 = this.playbackStateDurationsMs;
        List<long[]> list3 = this.mediaTimeHistory;
        long l12 = 0L;
        if (!bl2) {
            long l13;
            long l14 = SystemClock.elapsedRealtime();
            long[] lArray3 = this.playbackStateDurationsMs;
            n12 = 16;
            lArray3 = Arrays.copyOf(lArray3, n12);
            l11 = this.currentPlaybackStateStartTimeMs;
            l11 = l14 - l11;
            l11 = Math.max(l12, l11);
            n11 = this.currentPlaybackState;
            lArray3[n11] = l13 = lArray3[n11] + l11;
            this.maybeUpdateMaxRebufferTimeMs(l14);
            this.maybeRecordVideoFormatTime(l14);
            this.maybeRecordAudioFormatTime(l14);
            object2 = this.mediaTimeHistory;
            list2 = new List<long[]>((Collection<long[]>)object2);
            n10 = this.keepHistory;
            if (n10 != 0 && (n10 = this.currentPlaybackState) == (n11 = 3)) {
                lArray2 = this.guessMediaTimeBasedOnElapsedRealtime(l14);
                list2.add(lArray2);
            }
            lArray = lArray3;
            list = list2;
        } else {
            lArray = lArray2;
            list = list3;
        }
        boolean n13 = playbackStatsListener$PlaybackStatsTracker.isJoinTimeInvalid;
        int n14 = 1;
        if (!n13 && (bl3 = playbackStatsListener$PlaybackStatsTracker.hasBeenReady)) {
            boolean bl4 = false;
            lArray2 = null;
        } else {
            int n15 = n14;
        }
        if (var21_21 != false) {
            l11 = -9223372036854775807L;
        } else {
            n12 = 2;
            l11 = lArray[n12];
        }
        long l13 = l11;
        l11 = lArray[n14];
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        int n16 = l14 > 0 ? n14 : 0;
        if (bl2) {
            object = playbackStatsListener$PlaybackStatsTracker.videoFormatHistory;
        } else {
            arrayList = playbackStatsListener$PlaybackStatsTracker.videoFormatHistory;
            object = new ArrayList(arrayList);
        }
        List list4 = object;
        if (bl2) {
            object = playbackStatsListener$PlaybackStatsTracker.audioFormatHistory;
        } else {
            arrayList = playbackStatsListener$PlaybackStatsTracker.audioFormatHistory;
            object = new ArrayList(arrayList);
        }
        List list5 = object;
        if (bl2) {
            arrayList = playbackStatsListener$PlaybackStatsTracker.playbackStateHistory;
        } else {
            list2 = playbackStatsListener$PlaybackStatsTracker.playbackStateHistory;
            arrayList = new ArrayList(list2);
        }
        ArrayList arrayList2 = arrayList;
        long l15 = playbackStatsListener$PlaybackStatsTracker.firstReportedTimeMs;
        int n17 = playbackStatsListener$PlaybackStatsTracker.isForeground;
        int n18 = playbackStatsListener$PlaybackStatsTracker.hasBeenReady ^ 1;
        int n19 = playbackStatsListener$PlaybackStatsTracker.hasEnded;
        int n20 = var21_21 ^ 1;
        int n21 = playbackStatsListener$PlaybackStatsTracker.pauseCount;
        n12 = playbackStatsListener$PlaybackStatsTracker.pauseBufferCount;
        n10 = playbackStatsListener$PlaybackStatsTracker.seekCount;
        int n22 = playbackStatsListener$PlaybackStatsTracker.rebufferCount;
        int n23 = n12;
        long l16 = playbackStatsListener$PlaybackStatsTracker.maxRebufferTimeMs;
        int n24 = playbackStatsListener$PlaybackStatsTracker.isAd;
        long[] lArray3 = lArray;
        long l17 = playbackStatsListener$PlaybackStatsTracker.videoFormatHeightTimeMs;
        long l18 = playbackStatsListener$PlaybackStatsTracker.videoFormatHeightTimeProduct;
        long l19 = playbackStatsListener$PlaybackStatsTracker.videoFormatBitrateTimeMs;
        long l20 = playbackStatsListener$PlaybackStatsTracker.videoFormatBitrateTimeProduct;
        long l21 = playbackStatsListener$PlaybackStatsTracker.audioFormatTimeMs;
        long l22 = l10 = playbackStatsListener$PlaybackStatsTracker.audioFormatBitrateTimeProduct;
        n11 = playbackStatsListener$PlaybackStatsTracker.initialVideoFormatHeight;
        int n25 = -1;
        int n26 = n11;
        int n27 = n11 == n25 ? 0 : 1;
        l10 = playbackStatsListener$PlaybackStatsTracker.initialVideoFormatBitrate;
        long l23 = -1;
        long l24 = l10 == l23 ? 0 : (l10 < l23 ? -1 : 1);
        long l25 = l10;
        int n28 = l24 == false ? 0 : 1;
        l10 = playbackStatsListener$PlaybackStatsTracker.initialAudioFormatBitrate;
        l24 = l10 == l23 ? 0 : (l10 < l23 ? -1 : 1);
        l23 = l10;
        int n29 = l24 == false ? 0 : 1;
        long l26 = playbackStatsListener$PlaybackStatsTracker.bandwidthTimeMs;
        long l27 = playbackStatsListener$PlaybackStatsTracker.bandwidthBytes;
        long l28 = playbackStatsListener$PlaybackStatsTracker.droppedFrames;
        long l29 = l10 = playbackStatsListener$PlaybackStatsTracker.audioUnderruns;
        n11 = playbackStatsListener$PlaybackStatsTracker.fatalErrorCount;
        int n30 = n11 > 0 ? 1 : 0;
        n25 = playbackStatsListener$PlaybackStatsTracker.nonFatalErrorCount;
        List list6 = playbackStatsListener$PlaybackStatsTracker.fatalErrorHistory;
        List list7 = playbackStatsListener$PlaybackStatsTracker.nonFatalErrorHistory;
        l24 = n10;
        object2 = object;
        long l30 = l28;
        long l31 = l29;
        l28 = l26;
        l29 = l27;
        l27 = l23;
        l26 = l25;
        l23 = l22;
        l22 = l21;
        l21 = l20;
        l20 = l19;
        l19 = l18;
        l18 = l17;
        lArray = lArray3;
        object = new PlaybackStats(1, lArray3, arrayList2, list, l15, n17, n18, n19, n16, l13, n20, n21, n23, n10, n22, l16, n24, list4, list5, l17, l19, l20, l21, l22, l23, n27, n28, n26, l25, n29, l27, l28, l29, l30, l31, n30, n11, n25, list6, list7);
        return object;
    }

    public void onEvents(Player player, AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, boolean bl3, boolean bl4, int n10, boolean bl5, boolean bl6, ExoPlaybackException exoPlaybackException, Exception exception, long l10, long l11, Format format, Format format2, int n11, int n12) {
        float f10;
        float f11;
        long l12;
        long l13;
        int n13;
        int n14;
        int n15;
        PlaybackStats$EventTimeAndException playbackStats$EventTimeAndException;
        int n16;
        int n17;
        int n18;
        PlaybackStatsListener$PlaybackStatsTracker playbackStatsListener$PlaybackStatsTracker = this;
        AnalyticsListener$EventTime analyticsListener$EventTime2 = analyticsListener$EventTime;
        Object object = exoPlaybackException;
        Object object2 = exception;
        Object object3 = format;
        Format format3 = format2;
        int n19 = n11;
        int n20 = 1;
        if (bl3) {
            this.isSeeking = n20;
        }
        if ((n18 = player.getPlaybackState()) != (n17 = 2)) {
            playbackStatsListener$PlaybackStatsTracker.isSeeking = false;
        }
        if ((n18 = player.getPlaybackState()) == n20 || n18 == (n16 = 4) || bl4) {
            playbackStatsListener$PlaybackStatsTracker.isInterruptedByAd = false;
        }
        if (object != null) {
            playbackStatsListener$PlaybackStatsTracker.hasFatalError = n20;
            playbackStatsListener$PlaybackStatsTracker.fatalErrorCount = n18 = playbackStatsListener$PlaybackStatsTracker.fatalErrorCount + n20;
            n18 = (int)(playbackStatsListener$PlaybackStatsTracker.keepHistory ? 1 : 0);
            if (n18 != 0) {
                List list = playbackStatsListener$PlaybackStatsTracker.fatalErrorHistory;
                playbackStats$EventTimeAndException = new PlaybackStats$EventTimeAndException(analyticsListener$EventTime2, (Exception)object);
                list.add(playbackStats$EventTimeAndException);
            }
        } else {
            object = player.getPlayerError();
            if (object == null) {
                playbackStatsListener$PlaybackStatsTracker.hasFatalError = false;
            }
        }
        if ((n15 = playbackStatsListener$PlaybackStatsTracker.isForeground) != 0 && (n15 = playbackStatsListener$PlaybackStatsTracker.isInterruptedByAd) == 0) {
            object = player.getCurrentTrackSelections().getAll();
            n18 = ((TrackSelection[])object).length;
            playbackStats$EventTimeAndException = null;
            int n21 = 0;
            int n22 = 0;
            for (n16 = 0; n16 < n18; ++n16) {
                int n23;
                Object object4 = object[n16];
                if (object4 == null || (n23 = object4.length()) <= 0) continue;
                object4 = object4.getFormat((int)0).sampleMimeType;
                int n24 = MimeTypes.getTrackType((String)object4);
                if (n24 == n17) {
                    n21 = n20;
                    continue;
                }
                if (n24 != n20) continue;
                n22 = n20;
            }
            n15 = 0;
            object = null;
            if (n21 == 0) {
                playbackStatsListener$PlaybackStatsTracker.maybeUpdateVideoFormat(analyticsListener$EventTime2, null);
            }
            if (n22 == 0) {
                playbackStatsListener$PlaybackStatsTracker.maybeUpdateAudioFormat(analyticsListener$EventTime2, null);
            }
        }
        if (object3 != null) {
            playbackStatsListener$PlaybackStatsTracker.maybeUpdateVideoFormat(analyticsListener$EventTime2, (Format)object3);
        }
        if (format3 != null) {
            playbackStatsListener$PlaybackStatsTracker.maybeUpdateAudioFormat(analyticsListener$EventTime2, format3);
        }
        if ((object = playbackStatsListener$PlaybackStatsTracker.currentVideoFormat) != null && (n14 = ((Format)object).height) == (n13 = -1) && n19 != n13) {
            object = ((Format)object).buildUpon();
            n14 = n12;
            object = ((Format$Builder)object).setWidth(n12).setHeight(n19).build();
            playbackStatsListener$PlaybackStatsTracker.maybeUpdateVideoFormat(analyticsListener$EventTime2, (Format)object);
        }
        if (bl6) {
            playbackStatsListener$PlaybackStatsTracker.startedLoading = n20;
        }
        if (bl5) {
            l13 = playbackStatsListener$PlaybackStatsTracker.audioUnderruns;
            l12 = 1L;
            playbackStatsListener$PlaybackStatsTracker.audioUnderruns = l13 += l12;
        }
        l13 = playbackStatsListener$PlaybackStatsTracker.droppedFrames;
        n15 = n10;
        l12 = n10;
        playbackStatsListener$PlaybackStatsTracker.droppedFrames = l13 += l12;
        playbackStatsListener$PlaybackStatsTracker.bandwidthTimeMs = l13 = playbackStatsListener$PlaybackStatsTracker.bandwidthTimeMs + l10;
        playbackStatsListener$PlaybackStatsTracker.bandwidthBytes = l13 = playbackStatsListener$PlaybackStatsTracker.bandwidthBytes + l11;
        if (object2 != null) {
            playbackStatsListener$PlaybackStatsTracker.nonFatalErrorCount = n15 = playbackStatsListener$PlaybackStatsTracker.nonFatalErrorCount + n20;
            n15 = (int)(playbackStatsListener$PlaybackStatsTracker.keepHistory ? 1 : 0);
            if (n15 != 0) {
                object = playbackStatsListener$PlaybackStatsTracker.nonFatalErrorHistory;
                object3 = new PlaybackStats$EventTimeAndException(analyticsListener$EventTime2, (Exception)object2);
                object.add(object3);
            }
        }
        n15 = this.resolveNewPlaybackState(player);
        object2 = player.getPlaybackParameters();
        float f12 = ((PlaybackParameters)object2).speed;
        n14 = playbackStatsListener$PlaybackStatsTracker.currentPlaybackState;
        if (n14 != n15 || (n14 = (int)((f11 = (f10 = playbackStatsListener$PlaybackStatsTracker.currentPlaybackSpeed) - f12) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
            l13 = analyticsListener$EventTime2.realtimeMs;
            long l14 = bl2 ? analyticsListener$EventTime2.eventPlaybackPositionMs : -9223372036854775807L;
            playbackStatsListener$PlaybackStatsTracker.maybeUpdateMediaTimeHistory(l13, l14);
            l13 = analyticsListener$EventTime2.realtimeMs;
            playbackStatsListener$PlaybackStatsTracker.maybeRecordVideoFormatTime(l13);
            l13 = analyticsListener$EventTime2.realtimeMs;
            playbackStatsListener$PlaybackStatsTracker.maybeRecordAudioFormatTime(l13);
        }
        playbackStatsListener$PlaybackStatsTracker.currentPlaybackSpeed = f12;
        int n25 = playbackStatsListener$PlaybackStatsTracker.currentPlaybackState;
        if (n25 != n15) {
            playbackStatsListener$PlaybackStatsTracker.updatePlaybackState(n15, analyticsListener$EventTime2);
        }
    }

    public void onFinished(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        int n10 = this.currentPlaybackState;
        int n11 = 11;
        if (n10 != n11 && !bl2) {
            n11 = 15;
        }
        long l10 = analyticsListener$EventTime.realtimeMs;
        this.maybeUpdateMediaTimeHistory(l10, -9223372036854775807L);
        l10 = analyticsListener$EventTime.realtimeMs;
        this.maybeRecordVideoFormatTime(l10);
        l10 = analyticsListener$EventTime.realtimeMs;
        this.maybeRecordAudioFormatTime(l10);
        this.updatePlaybackState(n11, analyticsListener$EventTime);
    }

    public void onForeground() {
        this.isForeground = true;
    }

    public void onInterruptedByAd() {
        this.isInterruptedByAd = true;
        this.isSeeking = false;
    }
}


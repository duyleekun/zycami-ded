/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.PlaybackStats$EventTimeAndPlaybackState;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStats {
    public static final PlaybackStats EMPTY = PlaybackStats.merge(new PlaybackStats[0]);
    public static final int PLAYBACK_STATE_ABANDONED = 15;
    public static final int PLAYBACK_STATE_BUFFERING = 6;
    public static final int PLAYBACK_STATE_COUNT = 16;
    public static final int PLAYBACK_STATE_ENDED = 11;
    public static final int PLAYBACK_STATE_FAILED = 13;
    public static final int PLAYBACK_STATE_INTERRUPTED_BY_AD = 14;
    public static final int PLAYBACK_STATE_JOINING_BACKGROUND = 1;
    public static final int PLAYBACK_STATE_JOINING_FOREGROUND = 2;
    public static final int PLAYBACK_STATE_NOT_STARTED = 0;
    public static final int PLAYBACK_STATE_PAUSED = 4;
    public static final int PLAYBACK_STATE_PAUSED_BUFFERING = 7;
    public static final int PLAYBACK_STATE_PLAYING = 3;
    public static final int PLAYBACK_STATE_SEEKING = 5;
    public static final int PLAYBACK_STATE_STOPPED = 12;
    public static final int PLAYBACK_STATE_SUPPRESSED = 9;
    public static final int PLAYBACK_STATE_SUPPRESSED_BUFFERING = 10;
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final List audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final List fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final List mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final List nonFatalErrorHistory;
    public final int playbackCount;
    private final long[] playbackStateDurationsMs;
    public final List playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final List videoFormatHistory;

    public PlaybackStats(int n10, long[] lArray, List list, List list2, long l10, int n11, int n12, int n13, int n14, long l11, int n15, int n16, int n17, int n18, int n19, long l12, int n20, List list3, List list4, long l13, long l14, long l15, long l16, long l17, long l18, int n21, int n22, int n23, long l19, int n24, long l20, long l21, long l22, long l23, long l24, int n25, int n26, int n27, List list5, List list6) {
        this.playbackCount = n10;
        Object object = lArray;
        this.playbackStateDurationsMs = lArray;
        object = Collections.unmodifiableList(list);
        this.playbackStateHistory = object;
        object = Collections.unmodifiableList(list2);
        this.mediaTimeHistory = object;
        this.firstReportedTimeMs = l10;
        this.foregroundPlaybackCount = n11;
        this.abandonedBeforeReadyCount = n12;
        this.endedCount = n13;
        this.backgroundJoiningCount = n14;
        this.totalValidJoinTimeMs = l11;
        this.validJoinTimeCount = n15;
        this.totalPauseCount = n16;
        this.totalPauseBufferCount = n17;
        this.totalSeekCount = n18;
        this.totalRebufferCount = n19;
        this.maxRebufferTimeMs = l12;
        this.adPlaybackCount = n20;
        object = Collections.unmodifiableList(list3);
        this.videoFormatHistory = object;
        object = Collections.unmodifiableList(list4);
        this.audioFormatHistory = object;
        this.totalVideoFormatHeightTimeMs = l13;
        this.totalVideoFormatHeightTimeProduct = l14;
        this.totalVideoFormatBitrateTimeMs = l15;
        this.totalVideoFormatBitrateTimeProduct = l16;
        this.totalAudioFormatTimeMs = l17;
        this.totalAudioFormatBitrateTimeProduct = l18;
        this.initialVideoFormatHeightCount = n21;
        this.initialVideoFormatBitrateCount = n22;
        this.totalInitialVideoFormatHeight = n23;
        this.totalInitialVideoFormatBitrate = l19;
        this.initialAudioFormatBitrateCount = n24;
        this.totalInitialAudioFormatBitrate = l20;
        this.totalBandwidthTimeMs = l21;
        this.totalBandwidthBytes = l22;
        this.totalDroppedFrames = l23;
        this.totalAudioUnderruns = l24;
        this.fatalErrorPlaybackCount = n25;
        this.fatalErrorCount = n26;
        this.nonFatalErrorCount = n27;
        object = Collections.unmodifiableList(list5);
        this.fatalErrorHistory = object;
        object = Collections.unmodifiableList(list6);
        this.nonFatalErrorHistory = object;
    }

    public static PlaybackStats merge(PlaybackStats ... playbackStatsArray) {
        long l10;
        Object object;
        int n10;
        long l11;
        Object object2 = playbackStatsArray;
        int n11 = 16;
        long[] lArray = new long[n11];
        int n12 = playbackStatsArray.length;
        long l12 = l11 = 0L;
        long l13 = l11;
        long l14 = l11;
        long l15 = l11;
        long l16 = l11;
        long l17 = l11;
        long l18 = l11;
        long l19 = l11;
        long l20 = l11;
        long l21 = l11;
        int n13 = -1;
        long l22 = -9223372036854775807L;
        int n14 = 0;
        int n15 = 0;
        long l23 = -9223372036854775807L;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        long l24 = -9223372036854775807L;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        long l25 = -1;
        int n27 = 0;
        long l26 = -1;
        int n28 = 0;
        int n29 = 0;
        int n30 = 0;
        for (n10 = 0; n10 < n12; ++n10) {
            long l27;
            int n31;
            long l28;
            PlaybackStats playbackStats = object2[n10];
            int n32 = playbackStats.playbackCount;
            n14 += n32;
            for (n32 = 0; n32 < n11; ++n32) {
                long l29 = lArray[n32];
                object = playbackStats.playbackStateDurationsMs;
                Object object3 = object[n32];
                lArray[n32] = l29 += object3;
                n11 = 16;
            }
            l10 = -9223372036854775807L;
            long l30 = l23 - l10;
            n11 = (int)(l30 == 0L ? 0 : (l30 < 0L ? -1 : 1));
            if (n11 == 0) {
                l23 = playbackStats.firstReportedTimeMs;
            } else {
                l28 = playbackStats.firstReportedTimeMs;
                long l31 = l28 - l10;
                n32 = (int)(l31 == 0L ? 0 : (l31 < 0L ? -1 : 1));
                if (n32 != 0) {
                    l23 = Math.min(l23, l28);
                }
            }
            int n33 = playbackStats.foregroundPlaybackCount;
            n15 += n33;
            n33 = playbackStats.abandonedBeforeReadyCount;
            n16 += n33;
            n33 = playbackStats.endedCount;
            n17 += n33;
            n33 = playbackStats.backgroundJoiningCount;
            n18 += n33;
            l28 = -9223372036854775807L;
            n32 = (int)(l24 == l28 ? 0 : (l24 < l28 ? -1 : 1));
            if (n32 == 0) {
                l24 = l28 = playbackStats.totalValidJoinTimeMs;
            } else {
                l28 = playbackStats.totalValidJoinTimeMs;
                l10 = -9223372036854775807L;
                long l32 = l28 - l10;
                n32 = (int)(l32 == 0L ? 0 : (l32 < 0L ? -1 : 1));
                if (n32 != 0) {
                    l24 += l28;
                }
            }
            n33 = playbackStats.validJoinTimeCount;
            n19 += n33;
            n33 = playbackStats.totalPauseCount;
            n20 += n33;
            n33 = playbackStats.totalPauseBufferCount;
            n21 += n33;
            n33 = playbackStats.totalSeekCount;
            n22 += n33;
            n33 = playbackStats.totalRebufferCount;
            n23 += n33;
            l28 = -9223372036854775807L;
            n32 = (int)(l22 == l28 ? 0 : (l22 < l28 ? -1 : 1));
            if (n32 == 0) {
                l22 = playbackStats.maxRebufferTimeMs;
                n31 = n14;
            } else {
                n31 = n14;
                l27 = playbackStats.maxRebufferTimeMs;
                long l33 = l27 - l28;
                Object object4 = l33 == 0L ? 0 : (l33 < 0L ? -1 : 1);
                if (object4 != false) {
                    l22 = Math.max(l22, l27);
                }
            }
            n32 = playbackStats.adPlaybackCount;
            n24 += n32;
            l27 = playbackStats.totalVideoFormatHeightTimeMs;
            l12 += l27;
            l27 = playbackStats.totalVideoFormatHeightTimeProduct;
            l13 += l27;
            l27 = playbackStats.totalVideoFormatBitrateTimeMs;
            l14 += l27;
            l27 = playbackStats.totalVideoFormatBitrateTimeProduct;
            l15 += l27;
            l27 = playbackStats.totalAudioFormatTimeMs;
            l16 += l27;
            l27 = playbackStats.totalAudioFormatBitrateTimeProduct;
            l17 += l27;
            n32 = playbackStats.initialVideoFormatHeightCount;
            n25 += n32;
            n32 = playbackStats.initialVideoFormatBitrateCount;
            n26 += n32;
            n32 = -1;
            if (n13 == n32) {
                n13 = playbackStats.totalInitialVideoFormatHeight;
            } else {
                n14 = playbackStats.totalInitialVideoFormatHeight;
                if (n14 != n32) {
                    n13 += n14;
                }
            }
            long l34 = -1;
            n14 = (int)(l25 == l34 ? 0 : (l25 < l34 ? -1 : 1));
            if (n14 == 0) {
                l25 = l28 = playbackStats.totalInitialVideoFormatBitrate;
            } else {
                l28 = playbackStats.totalInitialVideoFormatBitrate;
                long l35 = l28 - l34;
                n14 = (int)(l35 == 0L ? 0 : (l35 < 0L ? -1 : 1));
                if (n14 != 0) {
                    l25 += l28;
                }
            }
            n33 = playbackStats.initialAudioFormatBitrateCount;
            n27 += n33;
            n33 = (int)(l26 == l34 ? 0 : (l26 < l34 ? -1 : 1));
            if (n33 == 0) {
                l26 = l28 = playbackStats.totalInitialAudioFormatBitrate;
            } else {
                l28 = playbackStats.totalInitialAudioFormatBitrate;
                long l36 = l28 - l34;
                n14 = (int)(l36 == 0L ? 0 : (l36 < 0L ? -1 : 1));
                if (n14 != 0) {
                    l26 += l28;
                }
            }
            l28 = playbackStats.totalBandwidthTimeMs;
            l18 += l28;
            l28 = playbackStats.totalBandwidthBytes;
            l19 += l28;
            l28 = playbackStats.totalDroppedFrames;
            l20 += l28;
            l28 = playbackStats.totalAudioUnderruns;
            l21 += l28;
            n33 = playbackStats.fatalErrorPlaybackCount;
            n28 += n33;
            n33 = playbackStats.fatalErrorCount;
            n29 += n33;
            n33 = playbackStats.nonFatalErrorCount;
            n30 += n33;
            object2 = playbackStatsArray;
            n14 = n31;
            n11 = 16;
        }
        object = Collections.emptyList();
        l10 = l22;
        List list = Collections.emptyList();
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        List list4 = Collections.emptyList();
        List list5 = Collections.emptyList();
        n11 = n13;
        n13 = n14;
        n14 = n15;
        n15 = n16;
        n10 = n17;
        int n34 = n18;
        n17 = n19;
        n18 = n20;
        int n35 = n22;
        n19 = n23;
        n22 = n24;
        long l37 = l12;
        l12 = l13;
        l13 = l14;
        l14 = l15;
        l15 = l16;
        l16 = l17;
        int n36 = n25;
        n25 = n11;
        long l38 = l26;
        l26 = l18;
        l18 = l19;
        l19 = l20;
        l20 = l21;
        int n37 = n28;
        n28 = n30;
        object2 = new PlaybackStats(n13, lArray, (List)object, list, l23, n14, n16, n10, n34, l24, n17, n20, n21, n35, n23, l22, n24, list2, list3, l37, l12, l13, l14, l15, l17, n36, n26, n11, l25, n27, l38, l26, l18, l19, l21, n37, n29, n30, list4, list5);
        return object2;
    }

    public float getAbandonedBeforeReadyRatio() {
        float f10;
        int n10 = this.abandonedBeforeReadyCount;
        int n11 = this.playbackCount;
        int n12 = this.foregroundPlaybackCount;
        n10 -= (n11 -= n12);
        if (n12 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            f10 = n10;
            float f11 = n12;
            f10 /= f11;
        }
        return f10;
    }

    public float getAudioUnderrunRate() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            object = 1148846080;
            float f11 = 1000.0f;
            long l13 = this.totalAudioUnderruns;
            float f12 = (float)l13 * f11;
            f10 = l11;
            f10 = f12 / f10;
        }
        return f10;
    }

    public float getDroppedFramesRate() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            object = 1148846080;
            float f11 = 1000.0f;
            long l13 = this.totalDroppedFrames;
            float f12 = (float)l13 * f11;
            f10 = l11;
            f10 = f12 / f10;
        }
        return f10;
    }

    public float getEndedRatio() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.endedCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public float getFatalErrorRate() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            object = 1148846080;
            float f11 = 1000.0f;
            int n10 = this.fatalErrorCount;
            float f12 = (float)n10 * f11;
            f10 = l11;
            f10 = f12 / f10;
        }
        return f10;
    }

    public float getFatalErrorRatio() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.fatalErrorPlaybackCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public float getJoinTimeRatio() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayAndWaitTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            l10 = this.getTotalJoinTimeMs();
            float f11 = l10;
            f10 = l11;
            f10 = f11 / f10;
        }
        return f10;
    }

    public int getMeanAudioFormatBitrate() {
        int n10;
        long l10 = this.totalAudioFormatTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            n10 = -1;
        } else {
            l11 = this.totalAudioFormatBitrateTimeProduct / l10;
            n10 = (int)l11;
        }
        return n10;
    }

    public int getMeanBandwidth() {
        int n10;
        long l10 = this.totalBandwidthTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            n10 = -1;
        } else {
            l11 = this.totalBandwidthBytes;
            long l13 = 8000L;
            l11 = l11 * l13 / l10;
            n10 = (int)l11;
        }
        return n10;
    }

    public long getMeanElapsedTimeMs() {
        long l10;
        int n10 = this.playbackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalElapsedTimeMs();
            int n11 = this.playbackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public int getMeanInitialAudioFormatBitrate() {
        int n10 = this.initialAudioFormatBitrateCount;
        if (n10 == 0) {
            n10 = -1;
        } else {
            long l10 = this.totalInitialAudioFormatBitrate;
            long l11 = n10;
            n10 = (int)(l10 /= l11);
        }
        return n10;
    }

    public int getMeanInitialVideoFormatBitrate() {
        int n10 = this.initialVideoFormatBitrateCount;
        if (n10 == 0) {
            n10 = -1;
        } else {
            long l10 = this.totalInitialVideoFormatBitrate;
            long l11 = n10;
            n10 = (int)(l10 /= l11);
        }
        return n10;
    }

    public int getMeanInitialVideoFormatHeight() {
        int n10 = this.initialVideoFormatHeightCount;
        if (n10 == 0) {
            n10 = -1;
        } else {
            int n11 = this.totalInitialVideoFormatHeight;
            n10 = n11 / n10;
        }
        return n10;
    }

    public long getMeanJoinTimeMs() {
        long l10;
        int n10 = this.validJoinTimeCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            long l11 = this.totalValidJoinTimeMs;
            long l12 = n10;
            l10 = l11 / l12;
        }
        return l10;
    }

    public float getMeanNonFatalErrorCount() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.nonFatalErrorCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public float getMeanPauseBufferCount() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.totalPauseBufferCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public float getMeanPauseCount() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.totalPauseCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public long getMeanPausedTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalPausedTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public long getMeanPlayAndWaitTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalPlayAndWaitTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public long getMeanPlayTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalPlayTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public float getMeanRebufferCount() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.totalRebufferCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public long getMeanRebufferTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalRebufferTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public float getMeanSeekCount() {
        float f10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            int n11 = this.totalSeekCount;
            float f11 = n11;
            f10 = n10;
            f10 = f11 / f10;
        }
        return f10;
    }

    public long getMeanSeekTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalSeekTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public long getMeanSingleRebufferTimeMs() {
        long l10;
        int n10 = this.totalRebufferCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            n10 = 6;
            l10 = this.getPlaybackStateDurationMs(n10);
            long l11 = this.getPlaybackStateDurationMs(7);
            l10 += l11;
            int n11 = this.totalRebufferCount;
            l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public long getMeanSingleSeekTimeMs() {
        long l10;
        int n10 = this.totalSeekCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalSeekTimeMs();
            int n11 = this.totalSeekCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public float getMeanTimeBetweenFatalErrors() {
        float f10 = this.getFatalErrorRate();
        return 1.0f / f10;
    }

    public float getMeanTimeBetweenNonFatalErrors() {
        float f10 = this.getNonFatalErrorRate();
        return 1.0f / f10;
    }

    public float getMeanTimeBetweenRebuffers() {
        float f10 = this.getRebufferRate();
        return 1.0f / f10;
    }

    public int getMeanVideoFormatBitrate() {
        int n10;
        long l10 = this.totalVideoFormatBitrateTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            n10 = -1;
        } else {
            l11 = this.totalVideoFormatBitrateTimeProduct / l10;
            n10 = (int)l11;
        }
        return n10;
    }

    public int getMeanVideoFormatHeight() {
        int n10;
        long l10 = this.totalVideoFormatHeightTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            n10 = -1;
        } else {
            l11 = this.totalVideoFormatHeightTimeProduct / l10;
            n10 = (int)l11;
        }
        return n10;
    }

    public long getMeanWaitTimeMs() {
        long l10;
        int n10 = this.foregroundPlaybackCount;
        if (n10 == 0) {
            l10 = -9223372036854775807L;
        } else {
            l10 = this.getTotalWaitTimeMs();
            int n11 = this.foregroundPlaybackCount;
            long l11 = n11;
            l10 /= l11;
        }
        return l10;
    }

    public long getMediaTimeMsAtRealtimeMs(long l10) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n10;
        Object object5 = this.mediaTimeHistory;
        Object object6 = object5.isEmpty();
        if (object6) {
            return -9223372036854775807L;
        }
        object6 = false;
        object5 = null;
        for (n10 = 0; n10 < (object4 = (object3 = this.mediaTimeHistory).size()) && (object4 = (Object)((object2 = (object = (object3 = (Object)((long[])this.mediaTimeHistory.get(n10)))[0]) - l10) == 0 ? 0 : (object2 < 0 ? -1 : 1))) <= 0; ++n10) {
        }
        object4 = 1;
        if (n10 == 0) {
            return ((long[])this.mediaTimeHistory.get(0))[object4];
        }
        Object object7 = this.mediaTimeHistory;
        int n11 = object7.size();
        if (n10 == n11) {
            List list = this.mediaTimeHistory;
            int n12 = list.size() - object4;
            return ((long[])list.get(n12))[object4];
        }
        object7 = this.mediaTimeHistory;
        int n13 = n10 + -1;
        long l11 = ((long[])object7.get(n13))[0];
        long l12 = ((long[])this.mediaTimeHistory.get(n13))[object4];
        object7 = (long[])this.mediaTimeHistory.get(n10);
        reference var19_15 = object7[0];
        object5 = (long[])this.mediaTimeHistory.get(n10);
        Object object8 = object5[object4];
        object = 0L;
        reference cfr_temp_1 = (var19_15 -= l11) - object;
        object6 = cfr_temp_1 == 0 ? 0 : (cfr_temp_1 < 0 ? -1 : 1);
        if (!object6) {
            return l12;
        }
        float f10 = l10 - l11;
        float f11 = (float)var19_15;
        l10 = (long)((float)(object8 - l12) * (f10 /= f11));
        return l12 + l10;
    }

    public float getNonFatalErrorRate() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            object = 1148846080;
            float f11 = 1000.0f;
            int n10 = this.nonFatalErrorCount;
            float f12 = (float)n10 * f11;
            f10 = l11;
            f10 = f12 / f10;
        }
        return f10;
    }

    public int getPlaybackStateAtTime(long l10) {
        boolean bl2;
        Iterator iterator2 = this.playbackStateHistory.iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            PlaybackStats$EventTimeAndPlaybackState playbackStats$EventTimeAndPlaybackState = (PlaybackStats$EventTimeAndPlaybackState)iterator2.next();
            AnalyticsListener$EventTime analyticsListener$EventTime = playbackStats$EventTimeAndPlaybackState.eventTime;
            long l11 = analyticsListener$EventTime.realtimeMs;
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) break;
            n10 = playbackStats$EventTimeAndPlaybackState.playbackState;
        }
        return n10;
    }

    public long getPlaybackStateDurationMs(int n10) {
        return this.playbackStateDurationsMs[n10];
    }

    public float getRebufferRate() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            object = 1148846080;
            float f11 = 1000.0f;
            int n10 = this.totalRebufferCount;
            float f12 = (float)n10 * f11;
            f10 = l11;
            f10 = f12 / f10;
        }
        return f10;
    }

    public float getRebufferTimeRatio() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayAndWaitTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            l10 = this.getTotalRebufferTimeMs();
            float f11 = l10;
            f10 = l11;
            f10 = f11 / f10;
        }
        return f10;
    }

    public float getSeekTimeRatio() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayAndWaitTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            l10 = this.getTotalSeekTimeMs();
            float f11 = l10;
            f10 = l11;
            f10 = f11 / f10;
        }
        return f10;
    }

    public long getTotalElapsedTimeMs() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 16); ++i10) {
            long[] lArray = this.playbackStateDurationsMs;
            long l11 = lArray[i10];
            l10 += l11;
        }
        return l10;
    }

    public long getTotalJoinTimeMs() {
        return this.getPlaybackStateDurationMs(2);
    }

    public long getTotalPausedTimeMs() {
        long l10 = this.getPlaybackStateDurationMs(4);
        long l11 = this.getPlaybackStateDurationMs(7);
        return l10 + l11;
    }

    public long getTotalPlayAndWaitTimeMs() {
        long l10 = this.getTotalPlayTimeMs();
        long l11 = this.getTotalWaitTimeMs();
        return l10 + l11;
    }

    public long getTotalPlayTimeMs() {
        return this.getPlaybackStateDurationMs(3);
    }

    public long getTotalRebufferTimeMs() {
        return this.getPlaybackStateDurationMs(6);
    }

    public long getTotalSeekTimeMs() {
        return this.getPlaybackStateDurationMs(5);
    }

    public long getTotalWaitTimeMs() {
        long l10 = this.getPlaybackStateDurationMs(2);
        long l11 = this.getPlaybackStateDurationMs(6);
        l10 += l11;
        l11 = this.getPlaybackStateDurationMs(5);
        return l10 + l11;
    }

    public float getWaitTimeRatio() {
        float f10;
        long l10;
        long l11 = this.getTotalPlayAndWaitTimeMs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            f10 = 0.0f;
        } else {
            l10 = this.getTotalWaitTimeMs();
            float f11 = l10;
            f10 = l11;
            f10 = f11 / f10;
        }
        return f10;
    }
}


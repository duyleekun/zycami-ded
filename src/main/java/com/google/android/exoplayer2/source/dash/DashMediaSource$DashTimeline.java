/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.util.Assertions;

public final class DashMediaSource$DashTimeline
extends Timeline {
    private final long elapsedRealtimeEpochOffsetMs;
    private final int firstPeriodId;
    private final MediaItem$LiveConfiguration liveConfiguration;
    private final DashManifest manifest;
    private final MediaItem mediaItem;
    private final long offsetInFirstPeriodUs;
    private final long presentationStartTimeMs;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowStartTimeMs;

    public DashMediaSource$DashTimeline(long l10, long l11, long l12, int n10, long l13, long l14, long l15, DashManifest dashManifest, MediaItem mediaItem, MediaItem$LiveConfiguration mediaItem$LiveConfiguration) {
        DashMediaSource$DashTimeline dashMediaSource$DashTimeline = this;
        Object object = dashManifest;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration2 = mediaItem$LiveConfiguration;
        int n11 = dashManifest.dynamic;
        int n12 = 1;
        int n13 = mediaItem$LiveConfiguration != null ? n12 : 0;
        if (n11 != n13) {
            n12 = 0;
        }
        Assertions.checkState(n12 != 0);
        dashMediaSource$DashTimeline.presentationStartTimeMs = l10;
        dashMediaSource$DashTimeline.windowStartTimeMs = l11;
        dashMediaSource$DashTimeline.elapsedRealtimeEpochOffsetMs = l12;
        n11 = n10;
        dashMediaSource$DashTimeline.firstPeriodId = n10;
        dashMediaSource$DashTimeline.offsetInFirstPeriodUs = l13;
        dashMediaSource$DashTimeline.windowDurationUs = l14;
        dashMediaSource$DashTimeline.windowDefaultStartPositionUs = l15;
        dashMediaSource$DashTimeline.manifest = object;
        object = mediaItem;
        dashMediaSource$DashTimeline.mediaItem = mediaItem;
        dashMediaSource$DashTimeline.liveConfiguration = mediaItem$LiveConfiguration2;
    }

    private long getAdjustedWindowDefaultStartPositionUs(long l10) {
        int n10;
        DashManifest dashManifest;
        int n11;
        long l11;
        long l12;
        long l13 = this.windowDefaultStartPositionUs;
        Object object = this.manifest;
        Object object2 = DashMediaSource$DashTimeline.isMovingLiveWindow((DashManifest)object);
        if (object2 == 0) {
            return l13;
        }
        long l14 = 0L;
        long l15 = l10 - l14;
        object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 > 0 && (l12 = (l11 = (l13 += l10) - (l10 = this.windowDurationUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            return -9223372036854775807L;
        }
        l10 = this.offsetInFirstPeriodUs + l13;
        object = this.manifest;
        int n12 = 0;
        long l16 = ((DashManifest)object).getPeriodDurationUs(0);
        object2 = 0;
        object = null;
        while (object2 < (n11 = (dashManifest = this.manifest).getPeriodCount() + -1) && (n11 = (int)(l10 == l16 ? 0 : (l10 < l16 ? -1 : 1))) >= 0) {
            l10 -= l16;
            DashManifest dashManifest2 = this.manifest;
            l16 = dashManifest2.getPeriodDurationUs((int)(++object2));
        }
        dashManifest = this.manifest;
        object = dashManifest.getPeriod((int)object2);
        n11 = ((Period)object).getAdaptationSetIndex(2);
        if (n11 == (n10 = -1)) {
            return l13;
        }
        object = ((Representation)((AdaptationSet)object.adaptationSets.get((int)n11)).representations.get(0)).getIndex();
        if (object != null && (n12 = object.getSegmentCount(l16)) != 0) {
            long l17 = object.getSegmentNum(l10, l16);
            l14 = object.getTimeUs(l17);
            l13 = l13 + l14 - l10;
        }
        return l13;
    }

    private static boolean isMovingLiveWindow(DashManifest dashManifest) {
        long l10;
        boolean bl2;
        long l11;
        long l12;
        long l13;
        boolean bl3 = dashManifest.dynamic;
        if (bl3 && (bl3 = (l13 = (l12 = dashManifest.minUpdatePeriodMs) - (l11 = -9223372036854775807L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) && !(bl2 = (l10 = (l12 = dashManifest.durationMs) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
            bl2 = true;
        } else {
            bl2 = false;
            dashManifest = null;
        }
        return bl2;
    }

    public int getIndexOfPeriod(Object object) {
        int n10 = object instanceof Integer;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        object = (Integer)object;
        int n12 = (Integer)object;
        n10 = this.firstPeriodId;
        if ((n12 -= n10) >= 0 && n12 < (n10 = this.getPeriodCount())) {
            n11 = n12;
        }
        return n11;
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        String string2;
        int n11 = this.getPeriodCount();
        Assertions.checkIndex(n10, 0, n11);
        n11 = 0;
        Integer n12 = null;
        String string3 = bl2 ? (string2 = this.manifest.getPeriod((int)n10).id) : null;
        if (bl2) {
            int n13 = this.firstPeriodId + n10;
            n12 = n13;
        }
        long l10 = this.manifest.getPeriodDurationUs(n10);
        long l11 = this.manifest.getPeriod((int)n10).startMs;
        long l12 = this.manifest.getPeriod((int)0).startMs;
        l12 = C.msToUs(l11 - l12);
        l11 = this.offsetInFirstPeriodUs;
        long l13 = l12 - l11;
        return timeline$Period.set(string3, n12, 0, l10, l13);
    }

    public int getPeriodCount() {
        return this.manifest.getPeriodCount();
    }

    public Object getUidOfPeriod(int n10) {
        int n11 = this.getPeriodCount();
        Assertions.checkIndex(n10, 0, n11);
        return this.firstPeriodId + n10;
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        Assertions.checkIndex(n10, 0, 1);
        long l11 = this.getAdjustedWindowDefaultStartPositionUs(l10);
        Object object = Timeline$Window.SINGLE_WINDOW_UID;
        MediaItem mediaItem = this.mediaItem;
        DashManifest dashManifest = this.manifest;
        long l12 = this.presentationStartTimeMs;
        long l13 = this.windowStartTimeMs;
        long l14 = this.elapsedRealtimeEpochOffsetMs;
        boolean bl2 = DashMediaSource$DashTimeline.isMovingLiveWindow(dashManifest);
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration = this.liveConfiguration;
        n10 = (int)(bl2 ? 1 : 0);
        long l15 = this.windowDurationUs;
        int n11 = this.getPeriodCount() + -1;
        long l16 = this.offsetInFirstPeriodUs;
        return timeline$Window.set(object, mediaItem, dashManifest, l12, l13, l14, true, bl2, mediaItem$LiveConfiguration, l11, l15, 0, n11, l16);
    }

    public int getWindowCount() {
        return 1;
    }
}


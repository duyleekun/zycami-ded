/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.common.base.Objects;

public final class AnalyticsListener$EventTime {
    public final MediaSource$MediaPeriodId currentMediaPeriodId;
    public final long currentPlaybackPositionMs;
    public final Timeline currentTimeline;
    public final int currentWindowIndex;
    public final long eventPlaybackPositionMs;
    public final MediaSource$MediaPeriodId mediaPeriodId;
    public final long realtimeMs;
    public final Timeline timeline;
    public final long totalBufferedDurationMs;
    public final int windowIndex;

    public AnalyticsListener$EventTime(long l10, Timeline timeline, int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l11, Timeline timeline2, int n11, MediaSource$MediaPeriodId mediaSource$MediaPeriodId2, long l12, long l13) {
        this.realtimeMs = l10;
        this.timeline = timeline;
        this.windowIndex = n10;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
        this.eventPlaybackPositionMs = l11;
        this.currentTimeline = timeline2;
        this.currentWindowIndex = n11;
        this.currentMediaPeriodId = mediaSource$MediaPeriodId2;
        this.currentPlaybackPositionMs = l12;
        this.totalBufferedDurationMs = l13;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = AnalyticsListener$EventTime.class) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            int n10;
            object = (AnalyticsListener$EventTime)object;
            long l13 = this.realtimeMs;
            long l14 = ((AnalyticsListener$EventTime)object).realtimeMs;
            long l15 = l13 - l14;
            Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (Object)this.windowIndex) != (n10 = ((AnalyticsListener$EventTime)object).windowIndex) || (object4 = (l12 = (l13 = this.eventPlaybackPositionMs) - (l14 = ((AnalyticsListener$EventTime)object).eventPlaybackPositionMs)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || (object4 = (Object)this.currentWindowIndex) != (n10 = ((AnalyticsListener$EventTime)object).currentWindowIndex) || (object4 = (l11 = (l13 = this.currentPlaybackPositionMs) - (l14 = ((AnalyticsListener$EventTime)object).currentPlaybackPositionMs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object4 = (l10 = (l13 = this.totalBufferedDurationMs) - (l14 = ((AnalyticsListener$EventTime)object).totalBufferedDurationMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)Objects.equal(object3 = this.timeline, object2 = ((AnalyticsListener$EventTime)object).timeline)) == false || (object4 = (Object)Objects.equal(object3 = this.mediaPeriodId, object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId)) == false || (object4 = (Object)Objects.equal(object3 = this.currentTimeline, object2 = ((AnalyticsListener$EventTime)object).currentTimeline)) == false || !(bl3 = Objects.equal(object3 = this.currentMediaPeriodId, object = ((AnalyticsListener$EventTime)object).currentMediaPeriodId))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.realtimeMs;
        Object[] objectArray = new Object[]{object, object = this.timeline, object = Integer.valueOf(this.windowIndex), object = this.mediaPeriodId, object = Long.valueOf(this.eventPlaybackPositionMs), object = this.currentTimeline, object = Integer.valueOf(this.currentWindowIndex), object = this.currentMediaPeriodId, object = Long.valueOf(this.currentPlaybackPositionMs), object = Long.valueOf(this.totalBufferedDurationMs)};
        return Objects.hashCode(objectArray);
    }
}


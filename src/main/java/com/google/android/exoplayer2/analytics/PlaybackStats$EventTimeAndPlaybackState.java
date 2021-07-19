/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;

public final class PlaybackStats$EventTimeAndPlaybackState {
    public final AnalyticsListener$EventTime eventTime;
    public final int playbackState;

    public PlaybackStats$EventTimeAndPlaybackState(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        this.eventTime = analyticsListener$EventTime;
        this.playbackState = n10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<PlaybackStats$EventTimeAndPlaybackState> clazz2;
        if (this == object) {
            return true;
        }
        AnalyticsListener$EventTime analyticsListener$EventTime = null;
        if (object != null && (clazz2 = PlaybackStats$EventTimeAndPlaybackState.class) == (clazz = object.getClass())) {
            object = (PlaybackStats$EventTimeAndPlaybackState)object;
            int n10 = this.playbackState;
            int n11 = ((PlaybackStats$EventTimeAndPlaybackState)object).playbackState;
            if (n10 != n11) {
                return false;
            }
            analyticsListener$EventTime = this.eventTime;
            object = ((PlaybackStats$EventTimeAndPlaybackState)object).eventTime;
            return analyticsListener$EventTime.equals(object);
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.eventTime.hashCode() * 31;
        int n11 = this.playbackState;
        return n10 + n11;
    }
}


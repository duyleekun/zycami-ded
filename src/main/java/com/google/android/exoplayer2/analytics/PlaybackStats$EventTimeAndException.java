/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;

public final class PlaybackStats$EventTimeAndException {
    public final AnalyticsListener$EventTime eventTime;
    public final Exception exception;

    public PlaybackStats$EventTimeAndException(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
        this.eventTime = analyticsListener$EventTime;
        this.exception = exception;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        if (this == object) {
            return true;
        }
        Exception exception = null;
        if (object != null && (object3 = PlaybackStats$EventTimeAndException.class) == (object2 = object.getClass())) {
            object = (PlaybackStats$EventTimeAndException)object;
            object3 = this.eventTime;
            object2 = ((PlaybackStats$EventTimeAndException)object).eventTime;
            boolean bl2 = ((AnalyticsListener$EventTime)object3).equals(object2);
            if (!bl2) {
                return false;
            }
            exception = this.exception;
            object = ((PlaybackStats$EventTimeAndException)object).exception;
            return exception.equals(object);
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.eventTime.hashCode() * 31;
        int n11 = this.exception.hashCode();
        return n10 + n11;
    }
}


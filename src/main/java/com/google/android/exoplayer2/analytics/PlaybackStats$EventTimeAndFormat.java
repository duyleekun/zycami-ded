/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;

public final class PlaybackStats$EventTimeAndFormat {
    public final AnalyticsListener$EventTime eventTime;
    public final Format format;

    public PlaybackStats$EventTimeAndFormat(AnalyticsListener$EventTime analyticsListener$EventTime, Format format) {
        this.eventTime = analyticsListener$EventTime;
        this.format = format;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = PlaybackStats$EventTimeAndFormat.class) == (object2 = object.getClass())) {
            object = (PlaybackStats$EventTimeAndFormat)object;
            object3 = this.eventTime;
            object2 = ((PlaybackStats$EventTimeAndFormat)object).eventTime;
            boolean bl3 = ((AnalyticsListener$EventTime)object3).equals(object2);
            if (!bl3) {
                return false;
            }
            object3 = this.format;
            object = ((PlaybackStats$EventTimeAndFormat)object).format;
            if (object3 != null) {
                bl2 = ((Format)object3).equals(object);
            } else if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        AnalyticsListener$EventTime analyticsListener$EventTime = this.eventTime;
        int n11 = analyticsListener$EventTime.hashCode() * 31;
        Format format = this.format;
        if (format != null) {
            n10 = format.hashCode();
        } else {
            n10 = 0;
            format = null;
        }
        return n11 + n10;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.analytics;

import android.util.SparseArray;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MutableFlags;

public final class AnalyticsListener$Events
extends MutableFlags {
    private final SparseArray eventTimes;

    public AnalyticsListener$Events() {
        SparseArray sparseArray;
        this.eventTimes = sparseArray = new SparseArray(0);
    }

    public boolean contains(int n10) {
        return super.contains(n10);
    }

    public boolean containsAny(int ... nArray) {
        return super.containsAny(nArray);
    }

    public int get(int n10) {
        return super.get(n10);
    }

    public AnalyticsListener$EventTime getEventTime(int n10) {
        return (AnalyticsListener$EventTime)Assertions.checkNotNull((AnalyticsListener$EventTime)this.eventTimes.get(n10));
    }

    public void setEventTimes(SparseArray sparseArray) {
        int n10;
        this.eventTimes.clear();
        for (int i10 = 0; i10 < (n10 = this.size()); ++i10) {
            n10 = this.get(i10);
            SparseArray sparseArray2 = this.eventTimes;
            AnalyticsListener$EventTime analyticsListener$EventTime = (AnalyticsListener$EventTime)Assertions.checkNotNull((AnalyticsListener$EventTime)sparseArray.get(n10));
            sparseArray2.append(n10, (Object)analyticsListener$EventTime);
        }
    }
}


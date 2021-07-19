/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;

public abstract class ForwardingTimeline
extends Timeline {
    public final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public int getFirstWindowIndex(boolean bl2) {
        return this.timeline.getFirstWindowIndex(bl2);
    }

    public int getIndexOfPeriod(Object object) {
        return this.timeline.getIndexOfPeriod(object);
    }

    public int getLastWindowIndex(boolean bl2) {
        return this.timeline.getLastWindowIndex(bl2);
    }

    public int getNextWindowIndex(int n10, int n11, boolean bl2) {
        return this.timeline.getNextWindowIndex(n10, n11, bl2);
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        return this.timeline.getPeriod(n10, timeline$Period, bl2);
    }

    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    public int getPreviousWindowIndex(int n10, int n11, boolean bl2) {
        return this.timeline.getPreviousWindowIndex(n10, n11, bl2);
    }

    public Object getUidOfPeriod(int n10) {
        return this.timeline.getUidOfPeriod(n10);
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        return this.timeline.getWindow(n10, timeline$Window, l10);
    }

    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}


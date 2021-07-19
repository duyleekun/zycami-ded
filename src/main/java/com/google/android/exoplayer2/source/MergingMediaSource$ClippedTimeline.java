/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class MergingMediaSource$ClippedTimeline
extends ForwardingTimeline {
    private final long[] periodDurationsUs;
    private final long[] windowDurationsUs;

    public MergingMediaSource$ClippedTimeline(Timeline timeline, Map map) {
        super(timeline);
        Object object;
        int n10;
        int n11 = timeline.getWindowCount();
        int n12 = timeline.getWindowCount();
        Object object2 = new long[n12];
        this.windowDurationsUs = object2;
        object2 = new Timeline$Window;
        super();
        int n13 = 0;
        Object object3 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            long l10;
            long[] lArray = this.windowDurationsUs;
            object = timeline.getWindow(n10, (Timeline$Window)object2);
            lArray[n10] = l10 = ((Timeline$Window)object).durationUs;
        }
        n11 = timeline.getPeriodCount();
        object2 = new long[n11];
        this.periodDurationsUs = object2;
        object2 = new Timeline$Period;
        super();
        while (n13 < n11) {
            n10 = 1;
            timeline.getPeriod(n13, (Timeline$Period)object2, n10 != 0);
            object3 = object2.uid;
            object3 = (Long)Assertions.checkNotNull((Long)map.get(object3));
            long l11 = (Long)object3;
            object = this.periodDurationsUs;
            long l12 = Long.MIN_VALUE;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 == false) {
                l11 = object2.durationUs;
            }
            object[n13] = l11;
            l11 = object2.durationUs;
            l12 = -9223372036854775807L;
            l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 != false) {
                long[] lArray = this.windowDurationsUs;
                int n14 = object2.windowIndex;
                long l14 = lArray[n14];
                Object object4 = object[n13];
                lArray[n14] = l14 -= (l11 -= object4);
            }
            ++n13;
        }
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        long l10;
        super.getPeriod(n10, timeline$Period, bl2);
        timeline$Period.durationUs = l10 = this.periodDurationsUs[n10];
        return timeline$Period;
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        long l11;
        long l12;
        long l13;
        super.getWindow(n10, timeline$Window, l10);
        long[] lArray = this.windowDurationsUs;
        timeline$Window.durationUs = l13 = lArray[n10];
        l10 = -9223372036854775807L;
        n10 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
        l10 = n10 != 0 && (n10 = (int)((l12 = (l11 = timeline$Window.defaultPositionUs) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 ? Math.min(l11, l13) : timeline$Window.defaultPositionUs;
        timeline$Window.defaultPositionUs = l10;
        return timeline$Window;
    }
}


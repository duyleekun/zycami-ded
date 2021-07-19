/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodAdTimeline
extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    /*
     * WARNING - void declaration
     */
    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        void var3_6;
        int bl2 = timeline.getPeriodCount();
        int n10 = 0;
        int n11 = 1;
        if (bl2 == n11) {
            int n12 = n11;
        } else {
            boolean bl3 = false;
        }
        Assertions.checkState((boolean)var3_6);
        int n13 = timeline.getWindowCount();
        if (n13 == n11) {
            n10 = n11;
        }
        Assertions.checkState(n10 != 0);
        this.adPlaybackState = adPlaybackState;
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        Timeline timeline = this.timeline;
        timeline.getPeriod(n10, timeline$Period, bl2);
        long l10 = timeline$Period.durationUs;
        long l11 = -9223372036854775807L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 == 0) {
            AdPlaybackState adPlaybackState = this.adPlaybackState;
            l10 = adPlaybackState.contentDurationUs;
        }
        Object object = timeline$Period.id;
        Object object2 = timeline$Period.uid;
        int n11 = timeline$Period.windowIndex;
        long l12 = timeline$Period.getPositionInWindowUs();
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        timeline$Period.set(object, object2, n11, l10, l12, adPlaybackState);
        return timeline$Period;
    }
}


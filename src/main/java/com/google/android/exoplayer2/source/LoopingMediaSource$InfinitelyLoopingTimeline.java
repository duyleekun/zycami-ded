/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;

public final class LoopingMediaSource$InfinitelyLoopingTimeline
extends ForwardingTimeline {
    public LoopingMediaSource$InfinitelyLoopingTimeline(Timeline timeline) {
        super(timeline);
    }

    public int getNextWindowIndex(int n10, int n11, boolean bl2) {
        Timeline timeline = this.timeline;
        if ((n10 = timeline.getNextWindowIndex(n10, n11, bl2)) == (n11 = -1)) {
            n10 = this.getFirstWindowIndex(bl2);
        }
        return n10;
    }

    public int getPreviousWindowIndex(int n10, int n11, boolean bl2) {
        Timeline timeline = this.timeline;
        if ((n10 = timeline.getPreviousWindowIndex(n10, n11, bl2)) == (n11 = -1)) {
            n10 = this.getLastWindowIndex(bl2);
        }
        return n10;
    }
}


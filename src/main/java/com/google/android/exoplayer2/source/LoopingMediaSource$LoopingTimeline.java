/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder$UnshuffledShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

public final class LoopingMediaSource$LoopingTimeline
extends AbstractConcatenatedTimeline {
    private final int childPeriodCount;
    private final Timeline childTimeline;
    private final int childWindowCount;
    private final int loopCount;

    public LoopingMediaSource$LoopingTimeline(Timeline object, int n10) {
        int n11;
        int n12;
        ShuffleOrder$UnshuffledShuffleOrder shuffleOrder$UnshuffledShuffleOrder = new ShuffleOrder$UnshuffledShuffleOrder(n10);
        boolean bl2 = false;
        super(false, shuffleOrder$UnshuffledShuffleOrder);
        this.childTimeline = object;
        this.childPeriodCount = n12 = ((Timeline)object).getPeriodCount();
        this.childWindowCount = n11 = ((Timeline)object).getWindowCount();
        this.loopCount = n10;
        if (n12 > 0) {
            n11 = (-1 >>> 1) / n12;
            if (n10 <= n11) {
                bl2 = true;
            }
            object = "LoopingMediaSource contains too many periods";
            Assertions.checkState(bl2, object);
        }
    }

    public int getChildIndexByChildUid(Object object) {
        boolean bl2 = object instanceof Integer;
        if (!bl2) {
            return -1;
        }
        return (Integer)object;
    }

    public int getChildIndexByPeriodIndex(int n10) {
        int n11 = this.childPeriodCount;
        return n10 / n11;
    }

    public int getChildIndexByWindowIndex(int n10) {
        int n11 = this.childWindowCount;
        return n10 / n11;
    }

    public Object getChildUidByChildIndex(int n10) {
        return n10;
    }

    public int getFirstPeriodIndexByChildIndex(int n10) {
        int n11 = this.childPeriodCount;
        return n10 * n11;
    }

    public int getFirstWindowIndexByChildIndex(int n10) {
        int n11 = this.childWindowCount;
        return n10 * n11;
    }

    public int getPeriodCount() {
        int n10 = this.childPeriodCount;
        int n11 = this.loopCount;
        return n10 * n11;
    }

    public Timeline getTimelineByChildIndex(int n10) {
        return this.childTimeline;
    }

    public int getWindowCount() {
        int n10 = this.childWindowCount;
        int n11 = this.loopCount;
        return n10 * n11;
    }
}


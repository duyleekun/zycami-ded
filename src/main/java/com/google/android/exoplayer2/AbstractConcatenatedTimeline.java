/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

public abstract class AbstractConcatenatedTimeline
extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    /*
     * WARNING - void declaration
     */
    public AbstractConcatenatedTimeline(boolean bl2, ShuffleOrder shuffleOrder) {
        int n10;
        void var2_3;
        this.isAtomic = bl2;
        this.shuffleOrder = var2_3;
        this.childCount = n10 = var2_3.getLength();
    }

    public static Object getChildPeriodUidFromConcatenatedUid(Object object) {
        return ((Pair)object).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object object) {
        return ((Pair)object).first;
    }

    public static Object getConcatenatedUid(Object object, Object object2) {
        return Pair.create((Object)object, (Object)object2);
    }

    private int getNextChildIndex(int n10, boolean n11) {
        if (n11 != 0) {
            ShuffleOrder shuffleOrder = this.shuffleOrder;
            n10 = shuffleOrder.getNextIndex(n10);
        } else {
            n11 = this.childCount + -1;
            n10 = n10 < n11 ? ++n10 : -1;
        }
        return n10;
    }

    private int getPreviousChildIndex(int n10, boolean bl2) {
        if (bl2) {
            ShuffleOrder shuffleOrder = this.shuffleOrder;
            n10 = shuffleOrder.getPreviousIndex(n10);
        } else {
            n10 = n10 > 0 ? (n10 += -1) : -1;
        }
        return n10;
    }

    public abstract int getChildIndexByChildUid(Object var1);

    public abstract int getChildIndexByPeriodIndex(int var1);

    public abstract int getChildIndexByWindowIndex(int var1);

    public abstract Object getChildUidByChildIndex(int var1);

    public abstract int getFirstPeriodIndexByChildIndex(int var1);

    public int getFirstWindowIndex(boolean bl2) {
        Object object;
        boolean bl3;
        int n10 = this.childCount;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        n10 = (int)(this.isAtomic ? 1 : 0);
        int n12 = 0;
        if (n10 != 0) {
            bl3 = false;
        }
        if (bl3) {
            object = this.shuffleOrder;
            n12 = object.getFirstIndex();
        }
        while ((n10 = (int)(((Timeline)(object = this.getTimelineByChildIndex(n12))).isEmpty() ? 1 : 0)) != 0) {
            if ((n12 = this.getNextChildIndex(n12, bl3)) != n11) continue;
            return n11;
        }
        n10 = this.getFirstWindowIndexByChildIndex(n12);
        int n13 = this.getTimelineByChildIndex(n12).getFirstWindowIndex(bl3);
        return n10 + n13;
    }

    public abstract int getFirstWindowIndexByChildIndex(int var1);

    public final int getIndexOfPeriod(Object object) {
        int n10 = object instanceof Pair;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        Object object2 = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object);
        object = AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object);
        n10 = this.getChildIndexByChildUid(object2);
        if (n10 == n11) {
            return n11;
        }
        Timeline timeline = this.getTimelineByChildIndex(n10);
        int n12 = timeline.getIndexOfPeriod(object);
        if (n12 != n11) {
            n10 = this.getFirstPeriodIndexByChildIndex(n10);
            n11 = n10 + n12;
        }
        return n11;
    }

    public int getLastWindowIndex(boolean bl2) {
        Timeline timeline;
        boolean bl3;
        int n10 = this.childCount;
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        boolean bl4 = this.isAtomic;
        if (bl4) {
            bl3 = false;
        }
        if (bl3) {
            ShuffleOrder shuffleOrder = this.shuffleOrder;
            n10 = shuffleOrder.getLastIndex();
        } else {
            n10 += -1;
        }
        while (bl4 = (timeline = this.getTimelineByChildIndex(n10)).isEmpty()) {
            if ((n10 = this.getPreviousChildIndex(n10, bl3)) != n11) continue;
            return n11;
        }
        n11 = this.getFirstWindowIndexByChildIndex(n10);
        int n12 = this.getTimelineByChildIndex(n10).getLastWindowIndex(bl3);
        return n11 + n12;
    }

    public int getNextWindowIndex(int n10, int n11, boolean n12) {
        Timeline timeline;
        int n13 = this.isAtomic;
        int n14 = 0;
        int n15 = 2;
        if (n13 != 0) {
            n12 = 1;
            if (n11 == n12) {
                n11 = n15;
            }
            n12 = 0;
        }
        n13 = this.getChildIndexByWindowIndex(n10);
        int n16 = this.getFirstWindowIndexByChildIndex(n13);
        Timeline timeline2 = this.getTimelineByChildIndex(n13);
        n10 -= n16;
        if (n11 != n15) {
            n14 = n11;
        }
        n10 = timeline2.getNextWindowIndex(n10, n14, n12 != 0);
        n14 = -1;
        if (n10 != n14) {
            return n16 + n10;
        }
        n10 = this.getNextChildIndex(n13, n12 != 0);
        while (n10 != n14 && (n13 = (int)((timeline = this.getTimelineByChildIndex(n10)).isEmpty() ? 1 : 0)) != 0) {
            n10 = this.getNextChildIndex(n10, n12 != 0);
        }
        if (n10 != n14) {
            n11 = this.getFirstWindowIndexByChildIndex(n10);
            n10 = this.getTimelineByChildIndex(n10).getFirstWindowIndex(n12 != 0);
            return n11 + n10;
        }
        if (n11 == n15) {
            return this.getFirstWindowIndex(n12 != 0);
        }
        return n14;
    }

    public final Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        int n11 = this.getChildIndexByPeriodIndex(n10);
        int n12 = this.getFirstWindowIndexByChildIndex(n11);
        int n13 = this.getFirstPeriodIndexByChildIndex(n11);
        Timeline timeline = this.getTimelineByChildIndex(n11);
        timeline.getPeriod(n10 -= n13, timeline$Period, bl2);
        timeline$Period.windowIndex = n10 = timeline$Period.windowIndex + n12;
        if (bl2) {
            Object object = this.getChildUidByChildIndex(n11);
            Object object2 = Assertions.checkNotNull(timeline$Period.uid);
            timeline$Period.uid = object = AbstractConcatenatedTimeline.getConcatenatedUid(object, object2);
        }
        return timeline$Period;
    }

    public final Timeline$Period getPeriodByUid(Object object, Timeline$Period timeline$Period) {
        Object object2 = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object);
        Object object3 = AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object);
        int n10 = this.getChildIndexByChildUid(object2);
        int n11 = this.getFirstWindowIndexByChildIndex(n10);
        this.getTimelineByChildIndex(n10).getPeriodByUid(object3, timeline$Period);
        timeline$Period.windowIndex = n10 = timeline$Period.windowIndex + n11;
        timeline$Period.uid = object;
        return timeline$Period;
    }

    public int getPreviousWindowIndex(int n10, int n11, boolean n12) {
        Timeline timeline;
        int n13 = this.isAtomic;
        int n14 = 0;
        int n15 = 2;
        if (n13 != 0) {
            n12 = 1;
            if (n11 == n12) {
                n11 = n15;
            }
            n12 = 0;
        }
        n13 = this.getChildIndexByWindowIndex(n10);
        int n16 = this.getFirstWindowIndexByChildIndex(n13);
        Timeline timeline2 = this.getTimelineByChildIndex(n13);
        n10 -= n16;
        if (n11 != n15) {
            n14 = n11;
        }
        n10 = timeline2.getPreviousWindowIndex(n10, n14, n12 != 0);
        n14 = -1;
        if (n10 != n14) {
            return n16 + n10;
        }
        n10 = this.getPreviousChildIndex(n13, n12 != 0);
        while (n10 != n14 && (n13 = (int)((timeline = this.getTimelineByChildIndex(n10)).isEmpty() ? 1 : 0)) != 0) {
            n10 = this.getPreviousChildIndex(n10, n12 != 0);
        }
        if (n10 != n14) {
            n11 = this.getFirstWindowIndexByChildIndex(n10);
            n10 = this.getTimelineByChildIndex(n10).getLastWindowIndex(n12 != 0);
            return n11 + n10;
        }
        if (n11 == n15) {
            return this.getLastWindowIndex(n12 != 0);
        }
        return n14;
    }

    public abstract Timeline getTimelineByChildIndex(int var1);

    public final Object getUidOfPeriod(int n10) {
        int n11 = this.getChildIndexByPeriodIndex(n10);
        int n12 = this.getFirstPeriodIndexByChildIndex(n11);
        Timeline timeline = this.getTimelineByChildIndex(n11);
        Object object = timeline.getUidOfPeriod(n10 -= n12);
        return AbstractConcatenatedTimeline.getConcatenatedUid(this.getChildUidByChildIndex(n11), object);
    }

    public final Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        int n11 = this.getChildIndexByWindowIndex(n10);
        int n12 = this.getFirstWindowIndexByChildIndex(n11);
        int n13 = this.getFirstPeriodIndexByChildIndex(n11);
        Timeline timeline = this.getTimelineByChildIndex(n11);
        timeline.getWindow(n10 -= n12, timeline$Window, l10);
        Object object = this.getChildUidByChildIndex(n11);
        Object object2 = Timeline$Window.SINGLE_WINDOW_UID;
        Object object3 = timeline$Window.uid;
        boolean bl2 = object2.equals(object3);
        if (!bl2) {
            object2 = timeline$Window.uid;
            object = AbstractConcatenatedTimeline.getConcatenatedUid(object, object2);
        }
        timeline$Window.uid = object;
        timeline$Window.firstPeriodIndex = n10 = timeline$Window.firstPeriodIndex + n13;
        timeline$Window.lastPeriodIndex = n10 = timeline$Window.lastPeriodIndex + n13;
        return timeline$Window;
    }
}


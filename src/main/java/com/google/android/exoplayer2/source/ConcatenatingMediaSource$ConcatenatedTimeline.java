/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$MediaSourceHolder;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import java.util.HashMap;

public final class ConcatenatingMediaSource$ConcatenatedTimeline
extends AbstractConcatenatedTimeline {
    private final HashMap childIndexByUid;
    private final int[] firstPeriodInChildIndices;
    private final int[] firstWindowInChildIndices;
    private final int periodCount;
    private final Timeline[] timelines;
    private final Object[] uids;
    private final int windowCount;

    public ConcatenatingMediaSource$ConcatenatedTimeline(Collection object, ShuffleOrder object2, boolean bl2) {
        super(bl2, (ShuffleOrder)object2);
        boolean bl3;
        int n10 = object.size();
        Object[] objectArray = new int[n10];
        this.firstPeriodInChildIndices = objectArray;
        objectArray = new int[n10];
        this.firstWindowInChildIndices = objectArray;
        objectArray = new Timeline[n10];
        this.timelines = (Timeline[])objectArray;
        object2 = new Object[n10];
        this.uids = object2;
        super();
        this.childIndexByUid = object2;
        object = object.iterator();
        n10 = 0;
        object2 = null;
        bl2 = false;
        objectArray = null;
        int n11 = 0;
        Integer n12 = null;
        while (bl3 = object.hasNext()) {
            Timeline timeline;
            Object object3 = (ConcatenatingMediaSource$MediaSourceHolder)object.next();
            Object object4 = this.timelines;
            object4[n11] = timeline = ((ConcatenatingMediaSource$MediaSourceHolder)object3).mediaSource.getTimeline();
            this.firstWindowInChildIndices[n11] = n10;
            this.firstPeriodInChildIndices[n11] = (int)(bl2 ? 1 : 0);
            int n13 = this.timelines[n11].getWindowCount();
            n10 += n13;
            n13 = this.timelines[n11].getPeriodCount();
            bl2 += n13;
            object4 = this.uids;
            object4[n11] = object3 = ((ConcatenatingMediaSource$MediaSourceHolder)object3).uid;
            object3 = this.childIndexByUid;
            object4 = object4[n11];
            int n14 = n11 + 1;
            n12 = n11;
            ((HashMap)object3).put(object4, n12);
            n11 = n14;
        }
        this.windowCount = n10;
        this.periodCount = (int)(bl2 ? 1 : 0);
    }

    public int getChildIndexByChildUid(Object object) {
        HashMap hashMap = this.childIndexByUid;
        int n10 = (object = (Integer)hashMap.get(object)) == null ? -1 : (Integer)object;
        return n10;
    }

    public int getChildIndexByPeriodIndex(int n10) {
        int[] nArray = this.firstPeriodInChildIndices;
        return Util.binarySearchFloor(nArray, ++n10, false, false);
    }

    public int getChildIndexByWindowIndex(int n10) {
        int[] nArray = this.firstWindowInChildIndices;
        return Util.binarySearchFloor(nArray, ++n10, false, false);
    }

    public Object getChildUidByChildIndex(int n10) {
        return this.uids[n10];
    }

    public int getFirstPeriodIndexByChildIndex(int n10) {
        return this.firstPeriodInChildIndices[n10];
    }

    public int getFirstWindowIndexByChildIndex(int n10) {
        return this.firstWindowInChildIndices[n10];
    }

    public int getPeriodCount() {
        return this.periodCount;
    }

    public Timeline getTimelineByChildIndex(int n10) {
        return this.timelines[n10];
    }

    public int getWindowCount() {
        return this.windowCount;
    }
}


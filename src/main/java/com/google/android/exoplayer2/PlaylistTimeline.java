/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaSourceInfoHolder;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class PlaylistTimeline
extends AbstractConcatenatedTimeline {
    private final HashMap childIndexByUid;
    private final int[] firstPeriodInChildIndices;
    private final int[] firstWindowInChildIndices;
    private final int periodCount;
    private final Timeline[] timelines;
    private final Object[] uids;
    private final int windowCount;

    public PlaylistTimeline(Collection object, ShuffleOrder object2) {
        boolean bl2;
        int n10 = 0;
        super(false, (ShuffleOrder)object2);
        int n11 = object.size();
        Object object3 = new int[n11];
        this.firstPeriodInChildIndices = object3;
        object3 = new int[n11];
        this.firstWindowInChildIndices = object3;
        object3 = new Timeline[n11];
        this.timelines = (Timeline[])object3;
        object2 = new Object[n11];
        this.uids = object2;
        super();
        this.childIndexByUid = object2;
        object = object.iterator();
        n11 = 0;
        object2 = null;
        int n12 = 0;
        object3 = null;
        while (bl2 = object.hasNext()) {
            Timeline timeline;
            Object object4 = (MediaSourceInfoHolder)object.next();
            Object object5 = this.timelines;
            object5[n12] = timeline = object4.getTimeline();
            this.firstWindowInChildIndices[n12] = n10;
            this.firstPeriodInChildIndices[n12] = n11;
            int n13 = this.timelines[n12].getWindowCount();
            n10 += n13;
            n13 = this.timelines[n12].getPeriodCount();
            n11 += n13;
            object5 = this.uids;
            object5[n12] = object4 = object4.getUid();
            object4 = this.childIndexByUid;
            object5 = this.uids[n12];
            int n14 = n12 + 1;
            object3 = n12;
            ((HashMap)object4).put(object5, object3);
            n12 = n14;
        }
        this.windowCount = n10;
        this.periodCount = n11;
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

    public List getChildTimelines() {
        return Arrays.asList(this.timelines);
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


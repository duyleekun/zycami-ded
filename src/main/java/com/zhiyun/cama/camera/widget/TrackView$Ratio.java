/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.widget;

public final class TrackView$Ratio
extends Enum {
    public static final /* enum */ TrackView$Ratio HEIGHT;
    public static final /* enum */ TrackView$Ratio WIDTH;
    private static final /* synthetic */ TrackView$Ratio[] a;

    static {
        TrackView$Ratio trackView$Ratio;
        TrackView$Ratio trackView$Ratio2;
        WIDTH = trackView$Ratio2 = new TrackView$Ratio("WIDTH", 0);
        int n10 = 1;
        HEIGHT = trackView$Ratio = new TrackView$Ratio("HEIGHT", n10);
        TrackView$Ratio[] trackView$RatioArray = new TrackView$Ratio[2];
        trackView$RatioArray[0] = trackView$Ratio2;
        trackView$RatioArray[n10] = trackView$Ratio;
        a = trackView$RatioArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TrackView$Ratio() {
        void var2_-1;
        void var1_-1;
    }

    public static TrackView$Ratio valueOf(String string2) {
        return Enum.valueOf(TrackView$Ratio.class, string2);
    }

    public static TrackView$Ratio[] values() {
        return (TrackView$Ratio[])a.clone();
    }
}


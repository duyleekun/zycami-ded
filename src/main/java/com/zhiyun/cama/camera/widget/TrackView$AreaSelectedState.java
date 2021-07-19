/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.widget;

public final class TrackView$AreaSelectedState
extends Enum {
    public static final /* enum */ TrackView$AreaSelectedState COMPLETED;
    public static final /* enum */ TrackView$AreaSelectedState INVALID;
    public static final /* enum */ TrackView$AreaSelectedState SELECTING;
    public static final /* enum */ TrackView$AreaSelectedState STARTED;
    private static final /* synthetic */ TrackView$AreaSelectedState[] a;

    static {
        TrackView$AreaSelectedState trackView$AreaSelectedState;
        TrackView$AreaSelectedState trackView$AreaSelectedState2;
        TrackView$AreaSelectedState trackView$AreaSelectedState3;
        TrackView$AreaSelectedState trackView$AreaSelectedState4;
        STARTED = trackView$AreaSelectedState4 = new TrackView$AreaSelectedState("STARTED", 0);
        int n10 = 1;
        SELECTING = trackView$AreaSelectedState3 = new TrackView$AreaSelectedState("SELECTING", n10);
        int n11 = 2;
        COMPLETED = trackView$AreaSelectedState2 = new TrackView$AreaSelectedState("COMPLETED", n11);
        int n12 = 3;
        INVALID = trackView$AreaSelectedState = new TrackView$AreaSelectedState("INVALID", n12);
        TrackView$AreaSelectedState[] trackView$AreaSelectedStateArray = new TrackView$AreaSelectedState[4];
        trackView$AreaSelectedStateArray[0] = trackView$AreaSelectedState4;
        trackView$AreaSelectedStateArray[n10] = trackView$AreaSelectedState3;
        trackView$AreaSelectedStateArray[n11] = trackView$AreaSelectedState2;
        trackView$AreaSelectedStateArray[n12] = trackView$AreaSelectedState;
        a = trackView$AreaSelectedStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TrackView$AreaSelectedState() {
        void var2_-1;
        void var1_-1;
    }

    public static TrackView$AreaSelectedState valueOf(String string2) {
        return Enum.valueOf(TrackView$AreaSelectedState.class, string2);
    }

    public static TrackView$AreaSelectedState[] values() {
        return (TrackView$AreaSelectedState[])a.clone();
    }
}


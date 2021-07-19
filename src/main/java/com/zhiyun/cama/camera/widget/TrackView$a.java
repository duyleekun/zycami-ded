/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.widget;

import com.zhiyun.cama.camera.widget.TrackView$AreaSelectedState;

public class TrackView$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        TrackView$AreaSelectedState trackView$AreaSelectedState;
        int n12 = TrackView$AreaSelectedState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            trackView$AreaSelectedState = TrackView$AreaSelectedState.STARTED;
            n11 = trackView$AreaSelectedState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            trackView$AreaSelectedState = TrackView$AreaSelectedState.SELECTING;
            n11 = trackView$AreaSelectedState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            trackView$AreaSelectedState = TrackView$AreaSelectedState.COMPLETED;
            n11 = trackView$AreaSelectedState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            trackView$AreaSelectedState = TrackView$AreaSelectedState.INVALID;
            n11 = trackView$AreaSelectedState.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}


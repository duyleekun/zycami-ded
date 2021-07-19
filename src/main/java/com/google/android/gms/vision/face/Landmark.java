/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.google.android.gms.vision.face;

import android.graphics.PointF;

public final class Landmark {
    public static final int BOTTOM_MOUTH = 0;
    public static final int LEFT_CHEEK = 1;
    public static final int LEFT_EAR = 3;
    public static final int LEFT_EAR_TIP = 2;
    public static final int LEFT_EYE = 4;
    public static final int LEFT_MOUTH = 5;
    public static final int NOSE_BASE = 6;
    public static final int RIGHT_CHEEK = 7;
    public static final int RIGHT_EAR = 9;
    public static final int RIGHT_EAR_TIP = 8;
    public static final int RIGHT_EYE = 10;
    public static final int RIGHT_MOUTH = 11;
    private final int type;
    private final PointF zzcg;

    public Landmark(PointF pointF, int n10) {
        this.zzcg = pointF;
        this.type = n10;
    }

    public final PointF getPosition() {
        return this.zzcg;
    }

    public final int getType() {
        return this.type;
    }
}


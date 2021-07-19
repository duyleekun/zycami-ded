/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.meicam.sdk;

import android.graphics.RectF;

public class NvsARSceneManipulate$NvsFaceBoundingRectInfo {
    public RectF faceBoundingRect;
    public int faceId;

    public NvsARSceneManipulate$NvsFaceBoundingRectInfo(int n10, float f10, float f11, float f12, float f13) {
        RectF rectF;
        this.faceId = n10;
        this.faceBoundingRect = rectF = new RectF(f10, f11, f12, f13);
    }
}


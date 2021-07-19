/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;

public class ImageViewState
implements Serializable {
    private float centerX;
    private float centerY;
    private int orientation;
    private float scale;

    public ImageViewState(float f10, PointF pointF, int n10) {
        this.scale = f10;
        this.centerX = f10 = pointF.x;
        this.centerY = f10 = pointF.y;
        this.orientation = n10;
    }

    public PointF getCenter() {
        float f10 = this.centerX;
        float f11 = this.centerY;
        PointF pointF = new PointF(f10, f11);
        return pointF;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}


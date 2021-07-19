/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$1;

public class SubsamplingScaleImageView$ScaleAndTranslate {
    private float scale;
    private PointF vTranslate;

    private SubsamplingScaleImageView$ScaleAndTranslate(float f10, PointF pointF) {
        this.scale = f10;
        this.vTranslate = pointF;
    }

    public /* synthetic */ SubsamplingScaleImageView$ScaleAndTranslate(float f10, PointF pointF, SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this(f10, pointF);
    }

    public static /* synthetic */ float access$4700(SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate) {
        return subsamplingScaleImageView$ScaleAndTranslate.scale;
    }

    public static /* synthetic */ float access$4702(SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate, float f10) {
        subsamplingScaleImageView$ScaleAndTranslate.scale = f10;
        return f10;
    }

    public static /* synthetic */ PointF access$4800(SubsamplingScaleImageView$ScaleAndTranslate subsamplingScaleImageView$ScaleAndTranslate) {
        return subsamplingScaleImageView$ScaleAndTranslate.vTranslate;
    }
}


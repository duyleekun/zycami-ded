/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 */
package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieInterpolatedValue;

public class LottieInterpolatedPointValue
extends LottieInterpolatedValue {
    private final PointF point;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.point = pointF = new PointF();
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator2) {
        super(pointF, pointF2, interpolator2);
        this.point = pointF = new PointF();
    }

    public PointF interpolateValue(PointF pointF, PointF pointF2, float f10) {
        PointF pointF3 = this.point;
        float f11 = pointF.x;
        float f12 = pointF2.x;
        f11 = MiscUtils.lerp(f11, f12, f10);
        float f13 = pointF.y;
        float f14 = pointF2.y;
        f13 = MiscUtils.lerp(f13, f14, f10);
        pointF3.set(f11, f13);
        return this.point;
    }
}


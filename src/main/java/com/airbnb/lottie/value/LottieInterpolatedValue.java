/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 */
package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public abstract class LottieInterpolatedValue
extends LottieValueCallback {
    private final Object endValue;
    private final Interpolator interpolator;
    private final Object startValue;

    public LottieInterpolatedValue(Object object, Object object2) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this(object, object2, (Interpolator)linearInterpolator);
    }

    public LottieInterpolatedValue(Object object, Object object2, Interpolator interpolator2) {
        this.startValue = object;
        this.endValue = object2;
        this.interpolator = interpolator2;
    }

    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        Object object = this.interpolator;
        float f10 = lottieFrameInfo.getOverallProgress();
        f10 = object.getInterpolation(f10);
        object = this.startValue;
        Object object2 = this.endValue;
        return this.interpolateValue(object, object2, f10);
    }

    public abstract Object interpolateValue(Object var1, Object var2, float var3);
}


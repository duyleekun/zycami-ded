/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieInterpolatedValue;

public class LottieInterpolatedFloatValue
extends LottieInterpolatedValue {
    public LottieInterpolatedFloatValue(Float f10, Float f11) {
        super(f10, f11);
    }

    public LottieInterpolatedFloatValue(Float f10, Float f11, Interpolator interpolator2) {
        super(f10, f11, interpolator2);
    }

    public Float interpolateValue(Float f10, Float f11, float f12) {
        float f13 = f10.floatValue();
        float f14 = f11.floatValue();
        return Float.valueOf(MiscUtils.lerp(f13, f14, f12));
    }
}


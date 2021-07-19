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

public class LottieInterpolatedIntegerValue
extends LottieInterpolatedValue {
    public LottieInterpolatedIntegerValue(Integer n10, Integer n11) {
        super(n10, n11);
    }

    public LottieInterpolatedIntegerValue(Integer n10, Integer n11, Interpolator interpolator2) {
        super(n10, n11, interpolator2);
    }

    public Integer interpolateValue(Integer n10, Integer n11, float f10) {
        int n12 = n10;
        int n13 = n11;
        return MiscUtils.lerp(n12, n13, f10);
    }
}


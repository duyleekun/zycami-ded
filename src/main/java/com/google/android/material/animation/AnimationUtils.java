/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.LinearInterpolator
 */
package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;

    static {
        Object object = new LinearInterpolator();
        LINEAR_INTERPOLATOR = object;
        object = new FastOutSlowInInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = object;
        object = new FastOutLinearInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = object;
        object = new LinearOutSlowInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = object;
        object = new DecelerateInterpolator();
        DECELERATE_INTERPOLATOR = object;
    }

    public static float lerp(float f10, float f11, float f12) {
        return f10 + (f12 *= (f11 -= f10));
    }

    public static int lerp(int n10, int n11, float f10) {
        float f11 = n11 - n10;
        n11 = Math.round(f10 * f11);
        return n10 + n11;
    }
}


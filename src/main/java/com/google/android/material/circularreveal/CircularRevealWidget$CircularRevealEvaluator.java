/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;
import com.google.android.material.math.MathUtils;

public class CircularRevealWidget$CircularRevealEvaluator
implements TypeEvaluator {
    public static final TypeEvaluator CIRCULAR_REVEAL;
    private final CircularRevealWidget$RevealInfo revealInfo;

    static {
        CircularRevealWidget$CircularRevealEvaluator circularRevealWidget$CircularRevealEvaluator = new CircularRevealWidget$CircularRevealEvaluator();
        CIRCULAR_REVEAL = circularRevealWidget$CircularRevealEvaluator;
    }

    public CircularRevealWidget$CircularRevealEvaluator() {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo;
        this.revealInfo = circularRevealWidget$RevealInfo = new CircularRevealWidget$RevealInfo(null);
    }

    public CircularRevealWidget$RevealInfo evaluate(float f10, CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo, CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2) {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo3 = this.revealInfo;
        float f11 = circularRevealWidget$RevealInfo.centerX;
        float f12 = circularRevealWidget$RevealInfo2.centerX;
        f11 = MathUtils.lerp(f11, f12, f10);
        f12 = circularRevealWidget$RevealInfo.centerY;
        float f13 = circularRevealWidget$RevealInfo2.centerY;
        f12 = MathUtils.lerp(f12, f13, f10);
        float f14 = circularRevealWidget$RevealInfo.radius;
        float f15 = circularRevealWidget$RevealInfo2.radius;
        f10 = MathUtils.lerp(f14, f15, f10);
        circularRevealWidget$RevealInfo3.set(f11, f12, f10);
        return this.revealInfo;
    }
}


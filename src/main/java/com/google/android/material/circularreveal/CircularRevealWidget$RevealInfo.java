/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.circularreveal;

import com.google.android.material.circularreveal.CircularRevealWidget$1;

public class CircularRevealWidget$RevealInfo {
    public static final float INVALID_RADIUS = Float.MAX_VALUE;
    public float centerX;
    public float centerY;
    public float radius;

    private CircularRevealWidget$RevealInfo() {
    }

    public CircularRevealWidget$RevealInfo(float f10, float f11, float f12) {
        this.centerX = f10;
        this.centerY = f11;
        this.radius = f12;
    }

    public /* synthetic */ CircularRevealWidget$RevealInfo(CircularRevealWidget$1 circularRevealWidget$1) {
        this();
    }

    public CircularRevealWidget$RevealInfo(CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        float f10 = circularRevealWidget$RevealInfo.centerX;
        float f11 = circularRevealWidget$RevealInfo.centerY;
        float f12 = circularRevealWidget$RevealInfo.radius;
        this(f10, f11, f12);
    }

    public boolean isInvalid() {
        float f10 = this.radius;
        float f11 = Float.MAX_VALUE;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public void set(float f10, float f11, float f12) {
        this.centerX = f10;
        this.centerY = f11;
        this.radius = f12;
    }

    public void set(CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        float f10 = circularRevealWidget$RevealInfo.centerX;
        float f11 = circularRevealWidget$RevealInfo.centerY;
        float f12 = circularRevealWidget$RevealInfo.radius;
        this.set(f10, f11, f12);
    }
}


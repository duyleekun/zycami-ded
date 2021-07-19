/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.value;

public class LottieFrameInfo {
    private float endFrame;
    private Object endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private Object startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public Object getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public Object getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo set(float f10, float f11, Object object, Object object2, float f12, float f13, float f14) {
        this.startFrame = f10;
        this.endFrame = f11;
        this.startValue = object;
        this.endValue = object2;
        this.linearKeyframeProgress = f12;
        this.interpolatedKeyframeProgress = f13;
        this.overallProgress = f14;
        return this;
    }
}


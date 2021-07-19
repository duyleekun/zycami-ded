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
import com.airbnb.lottie.LottieComposition;

public class Keyframe {
    private static final float UNSET_FLOAT = -3987645.8f;
    private static final int UNSET_INT = 784923401;
    private final LottieComposition composition;
    public Float endFrame;
    private float endProgress;
    public Object endValue;
    private float endValueFloat;
    private int endValueInt;
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    private float startProgress;
    public final Object startValue;
    private float startValueFloat;
    private int startValueInt;

    public Keyframe(LottieComposition lottieComposition, Object object, Object object2, Interpolator interpolator2, float f10, Float f11) {
        int n10;
        float f12;
        this.startValueFloat = f12 = -3987645.8f;
        this.endValueFloat = f12;
        this.startValueInt = n10 = 784923401;
        this.endValueInt = n10;
        this.startProgress = f12 = Float.MIN_VALUE;
        this.endProgress = f12;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = lottieComposition;
        this.startValue = object;
        this.endValue = object2;
        this.interpolator = interpolator2;
        this.startFrame = f10;
        this.endFrame = f11;
    }

    public Keyframe(Object object) {
        int n10;
        float f10;
        this.startValueFloat = f10 = -3987645.8f;
        this.endValueFloat = f10;
        this.startValueInt = n10 = 784923401;
        this.endValueInt = n10;
        this.startProgress = f10 = Float.MIN_VALUE;
        this.endProgress = f10;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = null;
        this.startValue = object;
        this.endValue = object;
        this.interpolator = null;
        this.startFrame = f10;
        this.endFrame = object = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean containsProgress(float f10) {
        float f11;
        int n10;
        float f12 = this.getStartProgress();
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (n10 = (f11 = f10 - (f12 = this.getEndProgress())) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public float getEndProgress() {
        Object object = this.composition;
        float f10 = 1.0f;
        if (object == null) {
            return f10;
        }
        float f11 = this.endProgress;
        float f12 = Float.MIN_VALUE;
        float f13 = f11 - f12;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 == false) {
            object = this.endFrame;
            if (object == null) {
                this.endProgress = f10;
            } else {
                f11 = this.getStartProgress();
                Float f14 = this.endFrame;
                f10 = f14.floatValue();
                f12 = this.startFrame;
                f10 -= f12;
                LottieComposition lottieComposition = this.composition;
                f12 = lottieComposition.getDurationFrames();
                this.endProgress = f11 += (f10 /= f12);
            }
        }
        return this.endProgress;
    }

    public float getEndValueFloat() {
        float f10 = this.endValueFloat;
        float f11 = -3987645.8f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            Float f13 = (Float)this.endValue;
            this.endValueFloat = f10 = f13.floatValue();
        }
        return this.endValueFloat;
    }

    public int getEndValueInt() {
        int n10 = this.endValueInt;
        int n11 = 784923401;
        if (n10 == n11) {
            Integer n12 = (Integer)this.endValue;
            this.endValueInt = n10 = n12.intValue();
        }
        return this.endValueInt;
    }

    public float getStartProgress() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.startProgress;
        float f11 = Float.MIN_VALUE;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = this.startFrame;
            float f13 = lottieComposition.getStartFrame();
            f10 -= f13;
            lottieComposition = this.composition;
            f13 = lottieComposition.getDurationFrames();
            this.startProgress = f10 /= f13;
        }
        return this.startProgress;
    }

    public float getStartValueFloat() {
        float f10 = this.startValueFloat;
        float f11 = -3987645.8f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            Float f13 = (Float)this.startValue;
            this.startValueFloat = f10 = f13.floatValue();
        }
        return this.startValueFloat;
    }

    public int getStartValueInt() {
        int n10 = this.startValueInt;
        int n11 = 784923401;
        if (n10 == n11) {
            Integer n12 = (Integer)this.startValue;
            this.startValueInt = n10 = n12.intValue();
        }
        return this.startValueInt;
    }

    public boolean isStatic() {
        boolean bl2;
        Interpolator interpolator2 = this.interpolator;
        if (interpolator2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            interpolator2 = null;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keyframe{startValue=");
        Object object = this.startValue;
        stringBuilder.append(object);
        stringBuilder.append(", endValue=");
        object = this.endValue;
        stringBuilder.append(object);
        stringBuilder.append(", startFrame=");
        float f10 = this.startFrame;
        stringBuilder.append(f10);
        stringBuilder.append(", endFrame=");
        object = this.endFrame;
        stringBuilder.append(object);
        stringBuilder.append(", interpolator=");
        object = this.interpolator;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}


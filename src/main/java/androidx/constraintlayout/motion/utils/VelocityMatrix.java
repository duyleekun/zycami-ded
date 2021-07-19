/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    public float mDRotate;
    public float mDScaleX;
    public float mDScaleY;
    public float mDTranslateX;
    public float mDTranslateY;
    public float mRotate;

    public void applyTransform(float f10, float f11, int n10, int n11, float[] fArray) {
        float f12 = fArray[0];
        int n12 = 1;
        float f13 = fArray[n12];
        float f14 = 0.5f;
        float f15 = f10 - f14;
        float f16 = 2.0f;
        f15 *= f16;
        f14 = (f11 - f14) * f16;
        f16 = this.mDTranslateX;
        f12 += f16;
        f16 = this.mDTranslateY;
        f13 += f16;
        f16 = this.mDScaleX * f15;
        f12 += f16;
        f16 = this.mDScaleY * f14;
        f13 += f16;
        f16 = (float)Math.toRadians(this.mRotate);
        float f17 = (float)Math.toRadians(this.mDRotate);
        double d10 = (float)(-n10) * f15;
        double d11 = f16;
        double d12 = Math.sin(d11);
        d10 *= d12;
        d12 = (float)n11 * f14;
        double d13 = Math.cos(d11) * d12;
        f14 = (float)(d10 - d13) * f17;
        double d14 = (float)n10 * f15;
        d10 = Math.cos(d11);
        d14 *= d10;
        d10 = Math.sin(d11);
        float f18 = (float)(d14 - (d12 *= d10));
        fArray[0] = f12 += f14;
        fArray[n12] = f13 += (f17 *= f18);
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f10) {
        if (keyCycleOscillator != null) {
            float f11;
            this.mDRotate = f11 = keyCycleOscillator.getSlope(f10);
        }
    }

    public void setRotationVelocity(SplineSet splineSet, float f10) {
        if (splineSet != null) {
            float f11;
            float f12;
            this.mDRotate = f12 = splineSet.getSlope(f10);
            this.mRotate = f11 = splineSet.get(f10);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        float f11;
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = f11 = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 == null) {
            this.mDScaleY = f11 = keyCycleOscillator2.getSlope(f10);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        float f11;
        if (splineSet != null) {
            this.mDScaleX = f11 = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDScaleY = f11 = splineSet2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        float f11;
        if (keyCycleOscillator != null) {
            this.mDTranslateX = f11 = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = f11 = keyCycleOscillator2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        float f11;
        if (splineSet != null) {
            this.mDTranslateX = f11 = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = f11 = splineSet2.getSlope(f10);
        }
    }
}


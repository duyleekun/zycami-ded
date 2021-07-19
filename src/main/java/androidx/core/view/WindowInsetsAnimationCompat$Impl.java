/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.view.animation.Interpolator;

public class WindowInsetsAnimationCompat$Impl {
    private float mAlpha;
    private final long mDurationMillis;
    private float mFraction;
    private final Interpolator mInterpolator;
    private final int mTypeMask;

    public WindowInsetsAnimationCompat$Impl(int n10, Interpolator interpolator2, long l10) {
        this.mTypeMask = n10;
        this.mInterpolator = interpolator2;
        this.mDurationMillis = l10;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public float getFraction() {
        return this.mFraction;
    }

    public float getInterpolatedFraction() {
        Interpolator interpolator2 = this.mInterpolator;
        if (interpolator2 != null) {
            float f10 = this.mFraction;
            return interpolator2.getInterpolation(f10);
        }
        return this.mFraction;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getTypeMask() {
        return this.mTypeMask;
    }

    public void setAlpha(float f10) {
        this.mAlpha = f10;
    }

    public void setFraction(float f10) {
        this.mFraction = f10;
    }
}


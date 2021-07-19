/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

public abstract class LookupTableInterpolator
implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArray) {
        float f10;
        this.mValues = fArray;
        float f11 = fArray.length + -1;
        this.mStepSize = f10 = 1.0f / f11;
    }

    public float getInterpolation(float f10) {
        int n10 = 1065353216;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object >= 0) {
            return f11;
        }
        n10 = 0;
        f11 = 0.0f;
        float[] fArray = null;
        float f13 = f10 - 0.0f;
        object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object <= 0) {
            return 0.0f;
        }
        fArray = this.mValues;
        object = (int)((float)(fArray.length + -1) * f10);
        n10 = fArray.length + -2;
        n10 = Math.min((int)object, n10);
        float f14 = n10;
        float f15 = this.mStepSize;
        f10 = (f10 - (f14 *= f15)) / f15;
        float[] fArray2 = this.mValues;
        f15 = fArray2[n10];
        int n11 = n10 + 1;
        float f16 = fArray2[n11];
        f11 = fArray2[n10];
        return f15 + (f10 *= (f16 -= f11));
    }
}


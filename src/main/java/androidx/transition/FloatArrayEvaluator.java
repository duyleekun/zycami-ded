/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package androidx.transition;

import android.animation.TypeEvaluator;

public class FloatArrayEvaluator
implements TypeEvaluator {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArray) {
        this.mArray = fArray;
    }

    public float[] evaluate(float f10, float[] fArray, float[] fArray2) {
        int n10;
        float[] fArray3 = this.mArray;
        if (fArray3 == null) {
            int n11 = fArray.length;
            fArray3 = new float[n11];
        }
        for (int i10 = 0; i10 < (n10 = fArray3.length); ++i10) {
            float f11 = fArray[i10];
            float f12 = (fArray2[i10] - f11) * f10;
            fArray3[i10] = f11 += f12;
        }
        return fArray3;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Matrix
 */
package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class TransitionUtils$MatrixEvaluator
implements TypeEvaluator {
    public final float[] mTempEndValues;
    public final Matrix mTempMatrix;
    public final float[] mTempStartValues;

    public TransitionUtils$MatrixEvaluator() {
        int n10 = 9;
        float[] fArray = new float[n10];
        this.mTempStartValues = fArray;
        Object object = new float[n10];
        this.mTempEndValues = object;
        object = new Matrix;
        this.mTempMatrix = (Matrix)object;
    }

    public Matrix evaluate(float f10, Matrix object, Matrix object2) {
        int n10;
        float[] fArray = this.mTempStartValues;
        object.getValues(fArray);
        object = this.mTempEndValues;
        object2.getValues((float[])object);
        object = null;
        for (int i10 = 0; i10 < (n10 = 9); ++i10) {
            object2 = this.mTempEndValues;
            reference var7_7 = object2[i10];
            float[] fArray2 = this.mTempStartValues;
            float f11 = fArray2[i10];
            var7_7 -= f11;
            float f12 = fArray2[i10];
            object2[i10] = (Matrix)(f12 += (var7_7 *= f10));
        }
        Matrix matrix = this.mTempMatrix;
        object = this.mTempEndValues;
        matrix.setValues((float[])object);
        return this.mTempMatrix;
    }
}


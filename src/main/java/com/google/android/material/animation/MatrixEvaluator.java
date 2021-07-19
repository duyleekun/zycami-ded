/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Matrix
 */
package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator
implements TypeEvaluator {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        int n10 = 9;
        float[] fArray = new float[n10];
        this.tempStartValues = fArray;
        Object object = new float[n10];
        this.tempEndValues = object;
        object = new Matrix;
        this.tempMatrix = (Matrix)object;
    }

    public Matrix evaluate(float f10, Matrix object, Matrix object2) {
        int n10;
        float[] fArray = this.tempStartValues;
        object.getValues(fArray);
        object = this.tempEndValues;
        object2.getValues((float[])object);
        object = null;
        for (int i10 = 0; i10 < (n10 = 9); ++i10) {
            object2 = this.tempEndValues;
            reference var7_7 = object2[i10];
            float[] fArray2 = this.tempStartValues;
            float f11 = fArray2[i10];
            var7_7 -= f11;
            float f12 = fArray2[i10];
            object2[i10] = (Matrix)(f12 += (var7_7 *= f10));
        }
        Matrix matrix = this.tempMatrix;
        object = this.tempEndValues;
        matrix.setValues((float[])object);
        return this.tempMatrix;
    }
}


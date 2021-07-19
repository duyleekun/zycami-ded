/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapePath$PathOperation;

public class ShapePath$PathArcOperation
extends ShapePath$PathOperation {
    private static final RectF rectF;
    public float bottom;
    public float left;
    public float right;
    public float startAngle;
    public float sweepAngle;
    public float top;

    static {
        RectF rectF;
        ShapePath$PathArcOperation.rectF = rectF = new RectF();
    }

    public ShapePath$PathArcOperation(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        matrix2 = rectF;
        float f10 = this.left;
        float f11 = this.top;
        float f12 = this.right;
        float f13 = this.bottom;
        matrix2.set(f10, f11, f12, f13);
        f10 = this.startAngle;
        f11 = this.sweepAngle;
        path.arcTo((RectF)matrix2, f10, f11, false);
        path.transform(matrix);
    }
}


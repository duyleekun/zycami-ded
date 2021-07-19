/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import com.google.android.material.shape.ShapePath$PathOperation;

public class ShapePath$PathQuadOperation
extends ShapePath$PathOperation {
    public float controlX;
    public float controlY;
    public float endX;
    public float endY;

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f10 = this.controlX;
        float f11 = this.controlY;
        float f12 = this.endX;
        float f13 = this.endY;
        path.quadTo(f10, f11, f12, f13);
        path.transform(matrix);
    }
}


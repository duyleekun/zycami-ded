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

public class ShapePath$PathLineOperation
extends ShapePath$PathOperation {
    private float x;
    private float y;

    public static /* synthetic */ float access$002(ShapePath$PathLineOperation shapePath$PathLineOperation, float f10) {
        shapePath$PathLineOperation.x = f10;
        return f10;
    }

    public static /* synthetic */ float access$102(ShapePath$PathLineOperation shapePath$PathLineOperation, float f10) {
        shapePath$PathLineOperation.y = f10;
        return f10;
    }

    public void applyToPath(Matrix matrix, Path path) {
        Matrix matrix2 = this.matrix;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f10 = this.x;
        float f11 = this.y;
        path.lineTo(f10, f11);
        path.transform(matrix);
    }
}


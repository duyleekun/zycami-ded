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

public abstract class ShapePath$PathOperation {
    public final Matrix matrix;

    public ShapePath$PathOperation() {
        Matrix matrix;
        this.matrix = matrix = new Matrix();
    }

    public abstract void applyToPath(Matrix var1, Path var2);
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Property
 *  android.widget.ImageView
 */
package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty
extends Property {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        Matrix matrix;
        this.matrix = matrix = new Matrix();
    }

    public Matrix get(ImageView imageView) {
        Matrix matrix = this.matrix;
        imageView = imageView.getImageMatrix();
        matrix.set((Matrix)imageView);
        return this.matrix;
    }

    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}


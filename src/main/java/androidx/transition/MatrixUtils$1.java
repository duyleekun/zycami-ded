/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

public final class MatrixUtils$1
extends Matrix {
    public void oops() {
        IllegalStateException illegalStateException = new IllegalStateException("Matrix can not be modified");
        throw illegalStateException;
    }

    public boolean postConcat(Matrix matrix) {
        this.oops();
        return false;
    }

    public boolean postRotate(float f10) {
        this.oops();
        return false;
    }

    public boolean postRotate(float f10, float f11, float f12) {
        this.oops();
        return false;
    }

    public boolean postScale(float f10, float f11) {
        this.oops();
        return false;
    }

    public boolean postScale(float f10, float f11, float f12, float f13) {
        this.oops();
        return false;
    }

    public boolean postSkew(float f10, float f11) {
        this.oops();
        return false;
    }

    public boolean postSkew(float f10, float f11, float f12, float f13) {
        this.oops();
        return false;
    }

    public boolean postTranslate(float f10, float f11) {
        this.oops();
        return false;
    }

    public boolean preConcat(Matrix matrix) {
        this.oops();
        return false;
    }

    public boolean preRotate(float f10) {
        this.oops();
        return false;
    }

    public boolean preRotate(float f10, float f11, float f12) {
        this.oops();
        return false;
    }

    public boolean preScale(float f10, float f11) {
        this.oops();
        return false;
    }

    public boolean preScale(float f10, float f11, float f12, float f13) {
        this.oops();
        return false;
    }

    public boolean preSkew(float f10, float f11) {
        this.oops();
        return false;
    }

    public boolean preSkew(float f10, float f11, float f12, float f13) {
        this.oops();
        return false;
    }

    public boolean preTranslate(float f10, float f11) {
        this.oops();
        return false;
    }

    public void reset() {
        this.oops();
    }

    public void set(Matrix matrix) {
        this.oops();
    }

    public boolean setConcat(Matrix matrix, Matrix matrix2) {
        this.oops();
        return false;
    }

    public boolean setPolyToPoly(float[] fArray, int n10, float[] fArray2, int n11, int n12) {
        this.oops();
        return false;
    }

    public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
        this.oops();
        return false;
    }

    public void setRotate(float f10) {
        this.oops();
    }

    public void setRotate(float f10, float f11, float f12) {
        this.oops();
    }

    public void setScale(float f10, float f11) {
        this.oops();
    }

    public void setScale(float f10, float f11, float f12, float f13) {
        this.oops();
    }

    public void setSinCos(float f10, float f11) {
        this.oops();
    }

    public void setSinCos(float f10, float f11, float f12, float f13) {
        this.oops();
    }

    public void setSkew(float f10, float f11) {
        this.oops();
    }

    public void setSkew(float f10, float f11, float f12, float f13) {
        this.oops();
    }

    public void setTranslate(float f10, float f11) {
        this.oops();
    }

    public void setValues(float[] fArray) {
        this.oops();
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.view.View
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import androidx.transition.ViewUtils;

public class ChangeTransform$PathAnimatorMatrix {
    private final Matrix mMatrix;
    private float mTranslationX;
    private float mTranslationY;
    private final float[] mValues;
    private final View mView;

    public ChangeTransform$PathAnimatorMatrix(View object, float[] fArray) {
        Matrix matrix;
        this.mMatrix = matrix = new Matrix();
        this.mView = object;
        object = (float[])fArray.clone();
        this.mValues = (float[])object;
        View view = object[2];
        this.mTranslationX = (float)view;
        View view2 = object[5];
        this.mTranslationY = (float)view2;
        this.setAnimationMatrix();
    }

    private void setAnimationMatrix() {
        float f10;
        Object object = this.mValues;
        object[2] = f10 = this.mTranslationX;
        object[5] = f10 = this.mTranslationY;
        this.mMatrix.setValues(object);
        object = this.mView;
        Matrix matrix = this.mMatrix;
        ViewUtils.setAnimationMatrix((View)object, matrix);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setTranslation(PointF pointF) {
        float f10;
        float f11;
        this.mTranslationX = f11 = pointF.x;
        this.mTranslationY = f10 = pointF.y;
        this.setAnimationMatrix();
    }

    public void setValues(float[] fArray) {
        float[] fArray2 = this.mValues;
        int n10 = fArray.length;
        System.arraycopy(fArray, 0, fArray2, 0, n10);
        this.setAnimationMatrix();
    }
}


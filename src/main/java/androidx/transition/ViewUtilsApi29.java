/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 */
package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ViewUtilsApi23;

public class ViewUtilsApi29
extends ViewUtilsApi23 {
    public float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void setLeftTopRightBottom(View view, int n10, int n11, int n12, int n13) {
        view.setLeftTopRightBottom(n10, n11, n12, n13);
    }

    public void setTransitionAlpha(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    public void setTransitionVisibility(View view, int n10) {
        view.setTransitionVisibility(n10);
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}


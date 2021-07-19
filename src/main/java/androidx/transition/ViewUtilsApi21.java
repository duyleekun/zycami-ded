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
import androidx.transition.ViewUtilsApi19;

public class ViewUtilsApi21
extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    public void setAnimationMatrix(View view, Matrix matrix) {
        boolean bl2 = sTryHiddenSetAnimationMatrix;
        if (bl2) {
            try {
                view.setAnimationMatrix(matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                view = null;
                sTryHiddenSetAnimationMatrix = false;
            }
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        boolean bl2 = sTryHiddenTransformMatrixToGlobal;
        if (bl2) {
            try {
                view.transformMatrixToGlobal(matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                view = null;
                sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        boolean bl2 = sTryHiddenTransformMatrixToLocal;
        if (bl2) {
            try {
                view.transformMatrixToLocal(matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                view = null;
                sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }
}


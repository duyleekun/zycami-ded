/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.ViewUtilsBase;

public class ViewUtilsApi19
extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    public void clearNonTransitionAlpha(View view) {
    }

    public float getTransitionAlpha(View view) {
        boolean bl2 = sTryHiddenTransitionAlpha;
        if (bl2) {
            try {
                return view.getTransitionAlpha();
            }
            catch (NoSuchMethodError noSuchMethodError) {
                bl2 = false;
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(View view) {
    }

    public void setTransitionAlpha(View view, float f10) {
        boolean bl2 = sTryHiddenTransitionAlpha;
        if (bl2) {
            try {
                view.setTransitionAlpha(f10);
                return;
            }
            catch (NoSuchMethodError noSuchMethodError) {
                bl2 = false;
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f10);
    }
}


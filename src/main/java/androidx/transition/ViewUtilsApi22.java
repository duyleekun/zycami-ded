/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.ViewUtilsApi21;

public class ViewUtilsApi22
extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    public void setLeftTopRightBottom(View view, int n10, int n11, int n12, int n13) {
        boolean bl2 = sTryHiddenSetLeftTopRightBottom;
        if (bl2) {
            try {
                view.setLeftTopRightBottom(n10, n11, n12, n13);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                view = null;
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}


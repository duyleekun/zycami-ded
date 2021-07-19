/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.transition;

import android.os.Build;
import android.view.View;
import androidx.transition.ViewUtilsApi22;

public class ViewUtilsApi23
extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    public void setTransitionVisibility(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 == n12) {
            super.setTransitionVisibility(view, n10);
        } else {
            n11 = (int)(sTryHiddenSetTransitionVisibility ? 1 : 0);
            if (n11 != 0) {
                try {
                    view.setTransitionVisibility(n10);
                }
                catch (NoSuchMethodError noSuchMethodError) {
                    view = null;
                    sTryHiddenSetTransitionVisibility = false;
                }
            }
        }
    }
}


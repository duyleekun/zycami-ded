/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.view.View
 */
package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewUtils {
    public static boolean isLayoutRtl(View view) {
        int n10;
        int n11 = ViewCompat.getLayoutDirection(view);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public static PorterDuff.Mode parseTintMode(int n10, PorterDuff.Mode mode) {
        int n11 = 3;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 9;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}


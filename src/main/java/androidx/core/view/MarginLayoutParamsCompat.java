/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 0;
        int n13 = 17;
        if (n11 >= n13) {
            n10 = marginLayoutParams.getLayoutDirection();
        } else {
            n10 = 0;
            marginLayoutParams = null;
        }
        if (n10 == 0 || n10 == (n11 = 1)) {
            n12 = n10;
        }
        return n12;
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return marginLayoutParams.isMarginRelative();
        }
        return false;
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            marginLayoutParams.resolveLayoutDirection(n10);
        }
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            marginLayoutParams.setLayoutDirection(n10);
        }
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            marginLayoutParams.setMarginEnd(n10);
        } else {
            marginLayoutParams.rightMargin = n10;
        }
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            marginLayoutParams.setMarginStart(n10);
        } else {
            marginLayoutParams.leftMargin = n10;
        }
    }
}


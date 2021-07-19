/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.Gravity
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class GravityCompat {
    public static final int END = 0x800005;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int START = 0x800003;

    private GravityCompat() {
    }

    public static void apply(int n10, int n11, int n12, Rect rect, int n13, int n14, Rect rect2, int n15) {
        int n16 = Build.VERSION.SDK_INT;
        int n17 = 17;
        if (n16 >= n17) {
            Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (int)n13, (int)n14, (Rect)rect2, (int)n15);
        } else {
            Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (int)n13, (int)n14, (Rect)rect2);
        }
    }

    public static void apply(int n10, int n11, int n12, Rect rect, Rect rect2, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 17;
        if (n14 >= n15) {
            Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (Rect)rect2, (int)n13);
        } else {
            Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (Rect)rect2);
        }
    }

    public static void applyDisplay(int n10, Rect rect, Rect rect2, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 17;
        if (n12 >= n13) {
            Gravity.applyDisplay((int)n10, (Rect)rect, (Rect)rect2, (int)n11);
        } else {
            Gravity.applyDisplay((int)n10, (Rect)rect, (Rect)rect2);
        }
    }

    public static int getAbsoluteGravity(int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 17;
        if (n12 >= n13) {
            return Gravity.getAbsoluteGravity((int)n10, (int)n11);
        }
        return n10 & 0xFF7FFFFF;
    }
}


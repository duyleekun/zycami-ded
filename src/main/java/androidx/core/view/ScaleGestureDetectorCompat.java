/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ScaleGestureDetector
 */
package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }
        return false;
    }

    public static boolean isQuickScaleEnabled(Object object) {
        return ScaleGestureDetectorCompat.isQuickScaleEnabled((ScaleGestureDetector)object);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            scaleGestureDetector.setQuickScaleEnabled(bl2);
        }
    }

    public static void setQuickScaleEnabled(Object object, boolean bl2) {
        ScaleGestureDetectorCompat.setQuickScaleEnabled((ScaleGestureDetector)object, bl2);
    }
}


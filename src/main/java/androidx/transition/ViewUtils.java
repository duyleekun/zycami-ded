/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.Property
 *  android.view.View
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.Property;
import android.view.View;
import androidx.transition.ViewOverlayApi14;
import androidx.transition.ViewOverlayApi18;
import androidx.transition.ViewOverlayImpl;
import androidx.transition.ViewUtils$1;
import androidx.transition.ViewUtils$2;
import androidx.transition.ViewUtilsApi19;
import androidx.transition.ViewUtilsApi21;
import androidx.transition.ViewUtilsApi22;
import androidx.transition.ViewUtilsApi23;
import androidx.transition.ViewUtilsApi29;
import androidx.transition.ViewUtilsBase;
import androidx.transition.WindowIdApi14;
import androidx.transition.WindowIdApi18;
import androidx.transition.WindowIdImpl;

public class ViewUtils {
    public static final Property CLIP_BOUNDS;
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    public static final Property TRANSITION_ALPHA;

    static {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            object = new ViewUtilsApi29();
            IMPL = object;
        } else {
            n11 = 23;
            if (n10 >= n11) {
                object = new ViewUtilsApi23();
                IMPL = object;
            } else {
                n11 = 22;
                if (n10 >= n11) {
                    object = new ViewUtilsApi22();
                    IMPL = object;
                } else {
                    n11 = 21;
                    if (n10 >= n11) {
                        object = new ViewUtilsApi21();
                        IMPL = object;
                    } else {
                        n11 = 19;
                        if (n10 >= n11) {
                            object = new ViewUtilsApi19();
                            IMPL = object;
                        } else {
                            object = new ViewUtilsBase();
                            IMPL = object;
                        }
                    }
                }
            }
        }
        object = new ViewUtils$1(Float.class, "translationAlpha");
        TRANSITION_ALPHA = object;
        object = new ViewUtils$2(Rect.class, "clipBounds");
        CLIP_BOUNDS = object;
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    public static ViewOverlayImpl getOverlay(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            ViewOverlayApi18 viewOverlayApi18 = new ViewOverlayApi18(view);
            return viewOverlayApi18;
        }
        return ViewOverlayApi14.createFrom(view);
    }

    public static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static WindowIdImpl getWindowId(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            WindowIdApi18 windowIdApi18 = new WindowIdApi18(view);
            return windowIdApi18;
        }
        view = view.getWindowToken();
        WindowIdApi14 windowIdApi14 = new WindowIdApi14((IBinder)view);
        return windowIdApi14;
    }

    public static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    public static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    public static void setLeftTopRightBottom(View view, int n10, int n11, int n12, int n13) {
        IMPL.setLeftTopRightBottom(view, n10, n11, n12, n13);
    }

    public static void setTransitionAlpha(View view, float f10) {
        IMPL.setTransitionAlpha(view, f10);
    }

    public static void setTransitionVisibility(View view, int n10) {
        IMPL.setTransitionVisibility(view, n10);
    }

    public static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    public static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}


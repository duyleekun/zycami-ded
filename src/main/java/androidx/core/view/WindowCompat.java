/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat$Impl16;
import androidx.core.view.WindowCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat;

public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return WindowCompat$Impl30.getInsetsController(window);
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
        return windowInsetsControllerCompat;
    }

    public static View requireViewById(Window object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            return object.requireViewById(n10);
        }
        if ((object = object.findViewById(n10)) != null) {
            return object;
        }
        object = new IllegalArgumentException("ID does not reference a View inside this Window");
        throw object;
    }

    public static void setDecorFitsSystemWindows(Window window, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowCompat$Impl30.setDecorFitsSystemWindows(window, bl2);
        } else {
            n11 = 16;
            if (n10 >= n11) {
                WindowCompat$Impl16.setDecorFitsSystemWindows(window, bl2);
            }
        }
    }
}


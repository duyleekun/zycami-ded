/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Window
 *  android.view.WindowInsetsController
 */
package androidx.core.view;

import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public class WindowCompat$Impl30 {
    private WindowCompat$Impl30() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window) {
        if ((window = window.getInsetsController()) != null) {
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat((WindowInsetsController)window);
        }
        return null;
    }

    public static void setDecorFitsSystemWindows(Window window, boolean bl2) {
        window.setDecorFitsSystemWindows(bl2);
    }
}


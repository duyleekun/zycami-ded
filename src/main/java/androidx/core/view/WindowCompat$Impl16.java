/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Window
 */
package androidx.core.view;

import android.view.Window;

public class WindowCompat$Impl16 {
    private WindowCompat$Impl16() {
    }

    /*
     * WARNING - void declaration
     */
    public static void setDecorFitsSystemWindows(Window window, boolean bl2) {
        void var1_4;
        window = window.getDecorView();
        int n10 = window.getSystemUiVisibility();
        if (bl2) {
            int n11 = n10 & 0xFFFFF8FF;
        } else {
            int n12 = n10 | 0x700;
        }
        window.setSystemUiVisibility((int)var1_4);
    }
}


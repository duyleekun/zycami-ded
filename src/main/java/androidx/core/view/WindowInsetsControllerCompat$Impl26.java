/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.Window
 */
package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;

public class WindowInsetsControllerCompat$Impl26
extends WindowInsetsControllerCompat$Impl23 {
    public WindowInsetsControllerCompat$Impl26(Window window, View view) {
        super(window, view);
    }

    public boolean isAppearanceLightNavigationBars() {
        View view = this.mWindow.getDecorView();
        int n10 = view.getSystemUiVisibility() & 0x10;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    public void setAppearanceLightNavigationBars(boolean bl2) {
        int n10 = 16;
        if (bl2) {
            this.unsetWindowFlag(0x8000000);
            int n11 = -1 << -1;
            this.setWindowFlag(n11);
            this.setSystemUiFlag(n10);
        } else {
            this.unsetSystemUiFlag(n10);
        }
    }
}


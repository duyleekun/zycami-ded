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
import androidx.core.view.WindowInsetsControllerCompat$Impl20;

public class WindowInsetsControllerCompat$Impl23
extends WindowInsetsControllerCompat$Impl20 {
    public WindowInsetsControllerCompat$Impl23(Window window, View view) {
        super(window, view);
    }

    public boolean isAppearanceLightStatusBars() {
        View view = this.mWindow.getDecorView();
        int n10 = view.getSystemUiVisibility() & 0x2000;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    public void setAppearanceLightStatusBars(boolean bl2) {
        int n10 = 8192;
        if (bl2) {
            this.unsetWindowFlag(0x4000000);
            int n11 = -1 << -1;
            this.setWindowFlag(n11);
            this.setSystemUiFlag(n10);
        } else {
            this.unsetSystemUiFlag(n10);
        }
    }
}


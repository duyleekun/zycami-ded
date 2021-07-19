/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Impl20;

public class WindowInsetsCompat$Impl21
extends WindowInsetsCompat$Impl20 {
    private Insets mStableInsets = null;

    public WindowInsetsCompat$Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    public WindowInsetsCompat$Impl21(WindowInsetsCompat object, WindowInsetsCompat$Impl21 windowInsetsCompat$Impl21) {
        super((WindowInsetsCompat)object, windowInsetsCompat$Impl21);
        this.mStableInsets = object = windowInsetsCompat$Impl21.mStableInsets;
    }

    public WindowInsetsCompat consumeStableInsets() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
    }

    public final Insets getStableInsets() {
        Insets insets = this.mStableInsets;
        if (insets == null) {
            int n10 = this.mPlatformInsets.getStableInsetLeft();
            WindowInsets windowInsets = this.mPlatformInsets;
            int n11 = windowInsets.getStableInsetTop();
            WindowInsets windowInsets2 = this.mPlatformInsets;
            int n12 = windowInsets2.getStableInsetRight();
            WindowInsets windowInsets3 = this.mPlatformInsets;
            int n13 = windowInsets3.getStableInsetBottom();
            this.mStableInsets = insets = Insets.of(n10, n11, n12, n13);
        }
        return this.mStableInsets;
    }

    public boolean isConsumed() {
        return this.mPlatformInsets.isConsumed();
    }

    public void setStableInsets(Insets insets) {
        this.mStableInsets = insets;
    }
}


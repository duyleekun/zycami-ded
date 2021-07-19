/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Impl29;
import androidx.core.view.WindowInsetsCompat$TypeImpl30;

public class WindowInsetsCompat$Impl30
extends WindowInsetsCompat$Impl29 {
    public static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

    public WindowInsetsCompat$Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    public WindowInsetsCompat$Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat$Impl30 windowInsetsCompat$Impl30) {
        super(windowInsetsCompat, windowInsetsCompat$Impl30);
    }

    public final void copyRootViewBounds(View view) {
    }

    public Insets getInsets(int n10) {
        WindowInsets windowInsets = this.mPlatformInsets;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        return Insets.toCompatInsets(windowInsets.getInsets(n10));
    }

    public Insets getInsetsIgnoringVisibility(int n10) {
        WindowInsets windowInsets = this.mPlatformInsets;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        return Insets.toCompatInsets(windowInsets.getInsetsIgnoringVisibility(n10));
    }

    public boolean isVisible(int n10) {
        WindowInsets windowInsets = this.mPlatformInsets;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        return windowInsets.isVisible(n10);
    }
}


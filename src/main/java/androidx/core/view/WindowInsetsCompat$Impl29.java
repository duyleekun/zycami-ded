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
import androidx.core.view.WindowInsetsCompat$Impl28;

public class WindowInsetsCompat$Impl29
extends WindowInsetsCompat$Impl28 {
    private Insets mMandatorySystemGestureInsets = null;
    private Insets mSystemGestureInsets = null;
    private Insets mTappableElementInsets = null;

    public WindowInsetsCompat$Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    public WindowInsetsCompat$Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat$Impl29 windowInsetsCompat$Impl29) {
        super(windowInsetsCompat, windowInsetsCompat$Impl29);
    }

    public Insets getMandatorySystemGestureInsets() {
        Insets insets = this.mMandatorySystemGestureInsets;
        if (insets == null) {
            this.mMandatorySystemGestureInsets = insets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        }
        return this.mMandatorySystemGestureInsets;
    }

    public Insets getSystemGestureInsets() {
        Insets insets = this.mSystemGestureInsets;
        if (insets == null) {
            this.mSystemGestureInsets = insets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        }
        return this.mSystemGestureInsets;
    }

    public Insets getTappableElementInsets() {
        Insets insets = this.mTappableElementInsets;
        if (insets == null) {
            this.mTappableElementInsets = insets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        }
        return this.mTappableElementInsets;
    }

    public WindowInsetsCompat inset(int n10, int n11, int n12, int n13) {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(n10, n11, n12, n13));
    }

    public void setStableInsets(Insets insets) {
    }
}


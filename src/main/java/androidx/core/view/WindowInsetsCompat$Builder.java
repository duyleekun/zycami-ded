/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.view;

import android.os.Build;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$BuilderImpl;
import androidx.core.view.WindowInsetsCompat$BuilderImpl20;
import androidx.core.view.WindowInsetsCompat$BuilderImpl29;
import androidx.core.view.WindowInsetsCompat$BuilderImpl30;

public final class WindowInsetsCompat$Builder {
    private final WindowInsetsCompat$BuilderImpl mImpl;

    public WindowInsetsCompat$Builder() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowInsetsCompat$BuilderImpl30 windowInsetsCompat$BuilderImpl30 = new WindowInsetsCompat$BuilderImpl30();
            this.mImpl = windowInsetsCompat$BuilderImpl30;
        } else {
            n11 = 29;
            if (n10 >= n11) {
                WindowInsetsCompat$BuilderImpl29 windowInsetsCompat$BuilderImpl29 = new WindowInsetsCompat$BuilderImpl29();
                this.mImpl = windowInsetsCompat$BuilderImpl29;
            } else {
                n11 = 20;
                if (n10 >= n11) {
                    WindowInsetsCompat$BuilderImpl20 windowInsetsCompat$BuilderImpl20 = new WindowInsetsCompat$BuilderImpl20();
                    this.mImpl = windowInsetsCompat$BuilderImpl20;
                } else {
                    WindowInsetsCompat$BuilderImpl windowInsetsCompat$BuilderImpl;
                    this.mImpl = windowInsetsCompat$BuilderImpl = new WindowInsetsCompat$BuilderImpl();
                }
            }
        }
    }

    public WindowInsetsCompat$Builder(WindowInsetsCompat windowInsetsCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowInsetsCompat$BuilderImpl30 windowInsetsCompat$BuilderImpl30 = new WindowInsetsCompat$BuilderImpl30(windowInsetsCompat);
            this.mImpl = windowInsetsCompat$BuilderImpl30;
        } else {
            n11 = 29;
            if (n10 >= n11) {
                WindowInsetsCompat$BuilderImpl29 windowInsetsCompat$BuilderImpl29 = new WindowInsetsCompat$BuilderImpl29(windowInsetsCompat);
                this.mImpl = windowInsetsCompat$BuilderImpl29;
            } else {
                n11 = 20;
                if (n10 >= n11) {
                    WindowInsetsCompat$BuilderImpl20 windowInsetsCompat$BuilderImpl20 = new WindowInsetsCompat$BuilderImpl20(windowInsetsCompat);
                    this.mImpl = windowInsetsCompat$BuilderImpl20;
                } else {
                    WindowInsetsCompat$BuilderImpl windowInsetsCompat$BuilderImpl;
                    this.mImpl = windowInsetsCompat$BuilderImpl = new WindowInsetsCompat$BuilderImpl(windowInsetsCompat);
                }
            }
        }
    }

    public WindowInsetsCompat build() {
        return this.mImpl.build();
    }

    public WindowInsetsCompat$Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
        this.mImpl.setDisplayCutout(displayCutoutCompat);
        return this;
    }

    public WindowInsetsCompat$Builder setInsets(int n10, Insets insets) {
        this.mImpl.setInsets(n10, insets);
        return this;
    }

    public WindowInsetsCompat$Builder setInsetsIgnoringVisibility(int n10, Insets insets) {
        this.mImpl.setInsetsIgnoringVisibility(n10, insets);
        return this;
    }

    public WindowInsetsCompat$Builder setMandatorySystemGestureInsets(Insets insets) {
        this.mImpl.setMandatorySystemGestureInsets(insets);
        return this;
    }

    public WindowInsetsCompat$Builder setStableInsets(Insets insets) {
        this.mImpl.setStableInsets(insets);
        return this;
    }

    public WindowInsetsCompat$Builder setSystemGestureInsets(Insets insets) {
        this.mImpl.setSystemGestureInsets(insets);
        return this;
    }

    public WindowInsetsCompat$Builder setSystemWindowInsets(Insets insets) {
        this.mImpl.setSystemWindowInsets(insets);
        return this;
    }

    public WindowInsetsCompat$Builder setTappableElementInsets(Insets insets) {
        this.mImpl.setTappableElementInsets(insets);
        return this;
    }

    public WindowInsetsCompat$Builder setVisible(int n10, boolean bl2) {
        this.mImpl.setVisible(n10, bl2);
        return this;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowInsetsAnimation
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat$Impl;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21;
import androidx.core.view.WindowInsetsAnimationCompat$Impl30;

public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private WindowInsetsAnimationCompat$Impl mImpl;

    public WindowInsetsAnimationCompat(int n10, Interpolator interpolator2, long l10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            WindowInsetsAnimationCompat$Impl30 windowInsetsAnimationCompat$Impl30 = new WindowInsetsAnimationCompat$Impl30(n10, interpolator2, l10);
            this.mImpl = windowInsetsAnimationCompat$Impl30;
        } else {
            n12 = 21;
            if (n11 >= n12) {
                WindowInsetsAnimationCompat$Impl21 windowInsetsAnimationCompat$Impl21 = new WindowInsetsAnimationCompat$Impl21(n10, interpolator2, l10);
                this.mImpl = windowInsetsAnimationCompat$Impl21;
            } else {
                WindowInsetsAnimationCompat$Impl windowInsetsAnimationCompat$Impl;
                n11 = 0;
                Object var7_8 = null;
                this.mImpl = windowInsetsAnimationCompat$Impl = new WindowInsetsAnimationCompat$Impl(0, interpolator2, l10);
            }
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat$Impl30 windowInsetsAnimationCompat$Impl30 = null;
        long l10 = 0L;
        this(0, null, l10);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            windowInsetsAnimationCompat$Impl30 = new WindowInsetsAnimationCompat$Impl30(windowInsetsAnimation);
            this.mImpl = windowInsetsAnimationCompat$Impl30;
        }
    }

    public static void setCallback(View view, WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowInsetsAnimationCompat$Impl30.setCallback(view, windowInsetsAnimationCompat$Callback);
        } else {
            n11 = 21;
            if (n10 >= n11) {
                WindowInsetsAnimationCompat$Impl21.setCallback(view, windowInsetsAnimationCompat$Callback);
            }
        }
    }

    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(windowInsetsAnimation);
        return windowInsetsAnimationCompat;
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(float f10) {
        this.mImpl.setAlpha(f10);
    }

    public void setFraction(float f10) {
        this.mImpl.setFraction(f10);
    }
}


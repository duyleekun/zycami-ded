/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowInsetsController
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl20;
import androidx.core.view.WindowInsetsControllerCompat$Impl23;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final WindowInsetsControllerCompat$Impl mImpl;

    public WindowInsetsControllerCompat(Window object, View object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            super((Window)object, this);
            this.mImpl = object2;
        } else {
            n11 = 26;
            if (n10 >= n11) {
                WindowInsetsControllerCompat$Impl26 windowInsetsControllerCompat$Impl26 = new WindowInsetsControllerCompat$Impl26((Window)object, (View)object2);
                this.mImpl = windowInsetsControllerCompat$Impl26;
            } else {
                n11 = 23;
                if (n10 >= n11) {
                    WindowInsetsControllerCompat$Impl23 windowInsetsControllerCompat$Impl23 = new WindowInsetsControllerCompat$Impl23((Window)object, (View)object2);
                    this.mImpl = windowInsetsControllerCompat$Impl23;
                } else {
                    n11 = 20;
                    if (n10 >= n11) {
                        WindowInsetsControllerCompat$Impl20 windowInsetsControllerCompat$Impl20 = new WindowInsetsControllerCompat$Impl20((Window)object, (View)object2);
                        this.mImpl = windowInsetsControllerCompat$Impl20;
                    } else {
                        super();
                        this.mImpl = object;
                    }
                }
            }
        }
    }

    private WindowInsetsControllerCompat(WindowInsetsController object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowInsetsControllerCompat$Impl30 windowInsetsControllerCompat$Impl30 = new WindowInsetsControllerCompat$Impl30((WindowInsetsController)object, this);
            this.mImpl = windowInsetsControllerCompat$Impl30;
        } else {
            this.mImpl = object;
        }
    }

    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(windowInsetsController);
        return windowInsetsControllerCompat;
    }

    public void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(windowInsetsControllerCompat$OnControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int n10, long l10, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(n10, l10, interpolator2, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int n10) {
        this.mImpl.hide(n10);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(windowInsetsControllerCompat$OnControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean bl2) {
        this.mImpl.setAppearanceLightNavigationBars(bl2);
    }

    public void setAppearanceLightStatusBars(boolean bl2) {
        this.mImpl.setAppearanceLightStatusBars(bl2);
    }

    public void setSystemBarsBehavior(int n10) {
        this.mImpl.setSystemBarsBehavior(n10);
    }

    public void show(int n10) {
        this.mImpl.show(n10);
    }
}


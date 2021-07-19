/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  android.view.Window
 *  android.view.WindowInsetsAnimationControlListener
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.os.CancellationSignal;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl30$1;
import androidx.core.view.WindowInsetsControllerCompat$Impl30$2;
import androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener;

public class WindowInsetsControllerCompat$Impl30
extends WindowInsetsControllerCompat$Impl {
    public final WindowInsetsControllerCompat mCompatController;
    public final WindowInsetsController mInsetsController;
    private final SimpleArrayMap mListeners;

    public WindowInsetsControllerCompat$Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        window = window.getInsetsController();
        this((WindowInsetsController)window, windowInsetsControllerCompat);
    }

    public WindowInsetsControllerCompat$Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        SimpleArrayMap simpleArrayMap;
        this.mListeners = simpleArrayMap = new SimpleArrayMap();
        this.mInsetsController = windowInsetsController;
        this.mCompatController = windowInsetsControllerCompat;
    }

    public void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        Object object = this.mListeners;
        boolean bl2 = ((SimpleArrayMap)object).containsKey(windowInsetsControllerCompat$OnControllableInsetsChangedListener);
        if (bl2) {
            return;
        }
        object = new WindowInsetsControllerCompat$Impl30$2(this, windowInsetsControllerCompat$OnControllableInsetsChangedListener);
        this.mListeners.put(windowInsetsControllerCompat$OnControllableInsetsChangedListener, object);
        this.mInsetsController.addOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)object);
    }

    public void controlWindowInsetsAnimation(int n10, long l10, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        WindowInsetsControllerCompat$Impl30$1 windowInsetsControllerCompat$Impl30$1 = new WindowInsetsControllerCompat$Impl30$1(this, windowInsetsAnimationControlListenerCompat);
        this.mInsetsController.controlWindowInsetsAnimation(n10, l10, interpolator2, cancellationSignal, (WindowInsetsAnimationControlListener)windowInsetsControllerCompat$Impl30$1);
    }

    public int getSystemBarsBehavior() {
        return this.mInsetsController.getSystemBarsBehavior();
    }

    public void hide(int n10) {
        this.mInsetsController.hide(n10);
    }

    public boolean isAppearanceLightNavigationBars() {
        WindowInsetsController windowInsetsController = this.mInsetsController;
        int n10 = windowInsetsController.getSystemBarsAppearance() & 0x10;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            windowInsetsController = null;
        }
        return n10 != 0;
    }

    public boolean isAppearanceLightStatusBars() {
        WindowInsetsController windowInsetsController = this.mInsetsController;
        int n10 = windowInsetsController.getSystemBarsAppearance() & 8;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            windowInsetsController = null;
        }
        return n10 != 0;
    }

    public void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        SimpleArrayMap simpleArrayMap = this.mListeners;
        if ((windowInsetsControllerCompat$OnControllableInsetsChangedListener = (WindowInsetsController.OnControllableInsetsChangedListener)simpleArrayMap.remove(windowInsetsControllerCompat$OnControllableInsetsChangedListener)) != null) {
            simpleArrayMap = this.mInsetsController;
            simpleArrayMap.removeOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)windowInsetsControllerCompat$OnControllableInsetsChangedListener);
        }
    }

    public void setAppearanceLightNavigationBars(boolean bl2) {
        int n10 = 16;
        if (bl2) {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            windowInsetsController.setSystemBarsAppearance(n10, n10);
        } else {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            windowInsetsController.setSystemBarsAppearance(0, n10);
        }
    }

    public void setAppearanceLightStatusBars(boolean bl2) {
        int n10 = 8;
        if (bl2) {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            windowInsetsController.setSystemBarsAppearance(n10, n10);
        } else {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            windowInsetsController.setSystemBarsAppearance(0, n10);
        }
    }

    public void setSystemBarsBehavior(int n10) {
        this.mInsetsController.setSystemBarsBehavior(n10);
    }

    public void show(int n10) {
        this.mInsetsController.show(n10);
    }
}


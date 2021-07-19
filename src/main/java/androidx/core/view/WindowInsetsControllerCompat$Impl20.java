/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  android.os.IBinder
 *  android.view.View
 *  android.view.Window
 *  android.view.animation.Interpolator
 *  android.view.inputmethod.InputMethodManager
 */
package androidx.core.view;

import android.os.CancellationSignal;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl;
import androidx.core.view.WindowInsetsControllerCompat$Impl20$1;
import androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener;

public class WindowInsetsControllerCompat$Impl20
extends WindowInsetsControllerCompat$Impl {
    private final View mView;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl20(Window window, View view) {
        this.mWindow = window;
        this.mView = view;
    }

    private void hideForType(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 8;
                if (n10 == n11) {
                    InputMethodManager inputMethodManager = (InputMethodManager)this.mWindow.getContext().getSystemService("input_method");
                    IBinder iBinder = this.mWindow.getDecorView().getWindowToken();
                    inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                }
                return;
            }
            this.setSystemUiFlag(n11);
            return;
        }
        this.setSystemUiFlag(4);
    }

    private void showForType(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 8;
                if (n10 == n11) {
                    View view = this.mView;
                    if (view != null && ((n11 = (int)(view.isInEditMode() ? 1 : 0)) != 0 || (n11 = (int)(view.onCheckIsTextEditor() ? 1 : 0)) != 0)) {
                        view.requestFocus();
                    } else {
                        view = this.mWindow.getCurrentFocus();
                    }
                    if (view == null) {
                        view = this.mWindow;
                        n11 = 0x1020002;
                        view = view.findViewById(n11);
                    }
                    if (view != null && (n11 = (int)(view.hasWindowFocus() ? 1 : 0)) != 0) {
                        WindowInsetsControllerCompat$Impl20$1 windowInsetsControllerCompat$Impl20$1 = new WindowInsetsControllerCompat$Impl20$1(this, view);
                        view.post((Runnable)windowInsetsControllerCompat$Impl20$1);
                    }
                }
                return;
            }
            this.unsetSystemUiFlag(n11);
            return;
        }
        this.unsetSystemUiFlag(4);
        this.unsetWindowFlag(1024);
    }

    public void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
    }

    public void controlWindowInsetsAnimation(int n10, long l10, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
    }

    public int getSystemBarsBehavior() {
        return 0;
    }

    public void hide(int n10) {
        int n11;
        for (int i10 = 1; i10 <= (n11 = 256); i10 <<= 1) {
            n11 = n10 & i10;
            if (n11 == 0) continue;
            this.hideForType(i10);
        }
    }

    public void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
    }

    public void setSystemBarsBehavior(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            int n12 = 2048;
            int n13 = 4096;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    this.unsetSystemUiFlag(n12);
                    this.setSystemUiFlag(n13);
                }
            } else {
                this.unsetSystemUiFlag(n13);
                this.setSystemUiFlag(n12);
            }
        } else {
            n10 = 6144;
            this.unsetSystemUiFlag(n10);
        }
    }

    public void setSystemUiFlag(int n10) {
        View view = this.mWindow.getDecorView();
        int n11 = view.getSystemUiVisibility();
        view.setSystemUiVisibility(n10 |= n11);
    }

    public void setWindowFlag(int n10) {
        this.mWindow.addFlags(n10);
    }

    public void show(int n10) {
        int n11;
        for (int i10 = 1; i10 <= (n11 = 256); i10 <<= 1) {
            n11 = n10 & i10;
            if (n11 == 0) continue;
            this.showForType(i10);
        }
    }

    public void unsetSystemUiFlag(int n10) {
        View view = this.mWindow.getDecorView();
        int n11 = view.getSystemUiVisibility();
        n10 = ~n10 & n11;
        view.setSystemUiVisibility(n10);
    }

    public void unsetWindowFlag(int n10) {
        this.mWindow.clearFlags(n10);
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import androidx.core.view.WindowInsetsCompat$Impl;
import androidx.core.view.WindowInsetsCompat$Impl20;
import androidx.core.view.WindowInsetsCompat$Impl21;
import androidx.core.view.WindowInsetsCompat$Impl28;
import androidx.core.view.WindowInsetsCompat$Impl29;
import androidx.core.view.WindowInsetsCompat$Impl30;
import androidx.core.view.WindowInsetsCompat$Type;

public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final WindowInsetsCompat$Impl mImpl;

    static {
        WindowInsetsCompat windowInsetsCompat;
        WindowInsetsCompat windowInsetsCompat2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        CONSUMED = n10 >= n11 ? (windowInsetsCompat2 = WindowInsetsCompat$Impl30.CONSUMED) : (windowInsetsCompat = WindowInsetsCompat$Impl.CONSUMED);
    }

    private WindowInsetsCompat(WindowInsets object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            WindowInsetsCompat$Impl30 windowInsetsCompat$Impl30 = new WindowInsetsCompat$Impl30(this, (WindowInsets)object);
            this.mImpl = windowInsetsCompat$Impl30;
        } else {
            n11 = 29;
            if (n10 >= n11) {
                WindowInsetsCompat$Impl29 windowInsetsCompat$Impl29 = new WindowInsetsCompat$Impl29(this, (WindowInsets)object);
                this.mImpl = windowInsetsCompat$Impl29;
            } else {
                n11 = 28;
                if (n10 >= n11) {
                    WindowInsetsCompat$Impl28 windowInsetsCompat$Impl28 = new WindowInsetsCompat$Impl28(this, (WindowInsets)object);
                    this.mImpl = windowInsetsCompat$Impl28;
                } else {
                    n11 = 21;
                    if (n10 >= n11) {
                        WindowInsetsCompat$Impl21 windowInsetsCompat$Impl21 = new WindowInsetsCompat$Impl21(this, (WindowInsets)object);
                        this.mImpl = windowInsetsCompat$Impl21;
                    } else {
                        n11 = 20;
                        if (n10 >= n11) {
                            WindowInsetsCompat$Impl20 windowInsetsCompat$Impl20 = new WindowInsetsCompat$Impl20(this, (WindowInsets)object);
                            this.mImpl = windowInsetsCompat$Impl20;
                        } else {
                            super(this);
                            this.mImpl = object;
                        }
                    }
                }
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat object) {
        if (object != null) {
            object = ((WindowInsetsCompat)object).mImpl;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 30;
            if (n10 >= n11 && (n11 = object instanceof WindowInsetsCompat$Impl30) != 0) {
                Object object2 = object;
                object2 = (WindowInsetsCompat$Impl30)object;
                WindowInsetsCompat$Impl30 windowInsetsCompat$Impl30 = new WindowInsetsCompat$Impl30(this, (WindowInsetsCompat$Impl30)object2);
                this.mImpl = windowInsetsCompat$Impl30;
            } else {
                n11 = 29;
                if (n10 >= n11 && (n11 = object instanceof WindowInsetsCompat$Impl29) != 0) {
                    Object object3 = object;
                    object3 = (WindowInsetsCompat$Impl29)object;
                    WindowInsetsCompat$Impl29 windowInsetsCompat$Impl29 = new WindowInsetsCompat$Impl29(this, (WindowInsetsCompat$Impl29)object3);
                    this.mImpl = windowInsetsCompat$Impl29;
                } else {
                    n11 = 28;
                    if (n10 >= n11 && (n11 = object instanceof WindowInsetsCompat$Impl28) != 0) {
                        Object object4 = object;
                        object4 = (WindowInsetsCompat$Impl28)object;
                        WindowInsetsCompat$Impl28 windowInsetsCompat$Impl28 = new WindowInsetsCompat$Impl28(this, (WindowInsetsCompat$Impl28)object4);
                        this.mImpl = windowInsetsCompat$Impl28;
                    } else {
                        n11 = 21;
                        if (n10 >= n11 && (n11 = object instanceof WindowInsetsCompat$Impl21) != 0) {
                            Object object5 = object;
                            object5 = (WindowInsetsCompat$Impl21)object;
                            WindowInsetsCompat$Impl21 windowInsetsCompat$Impl21 = new WindowInsetsCompat$Impl21(this, (WindowInsetsCompat$Impl21)object5);
                            this.mImpl = windowInsetsCompat$Impl21;
                        } else {
                            n11 = 20;
                            if (n10 >= n11 && (n10 = object instanceof WindowInsetsCompat$Impl20) != 0) {
                                Object object6 = object;
                                object6 = (WindowInsetsCompat$Impl20)object;
                                WindowInsetsCompat$Impl20 windowInsetsCompat$Impl20 = new WindowInsetsCompat$Impl20(this, (WindowInsetsCompat$Impl20)object6);
                                this.mImpl = windowInsetsCompat$Impl20;
                            } else {
                                WindowInsetsCompat$Impl windowInsetsCompat$Impl;
                                this.mImpl = windowInsetsCompat$Impl = new WindowInsetsCompat$Impl(this);
                            }
                        }
                    }
                }
            }
            ((WindowInsetsCompat$Impl)object).copyWindowDataInto(this);
        } else {
            this.mImpl = object = new WindowInsetsCompat$Impl(this);
        }
    }

    public static Insets insetInsets(Insets insets, int n10, int n11, int n12, int n13) {
        int n14 = insets.left - n10;
        n14 = Math.max(0, n14);
        int n15 = insets.top - n11;
        n15 = Math.max(0, n15);
        int n16 = insets.right - n12;
        n16 = Math.max(0, n16);
        int n17 = insets.bottom - n13;
        int n18 = Math.max(0, n17);
        if (n14 == n10 && n15 == n11 && n16 == n12 && n18 == n13) {
            return insets;
        }
        return Insets.of(n14, n15, n16, n18);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets object, View view) {
        boolean bl2;
        object = (WindowInsets)Preconditions.checkNotNull(object);
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets)object);
        if (view != null && (bl2 = view.isAttachedToWindow())) {
            object = ViewCompat.getRootWindowInsets(view);
            windowInsetsCompat.setRootWindowInsets((WindowInsetsCompat)object);
            object = view.getRootView();
            windowInsetsCompat.copyRootViewBounds((View)object);
        }
        return windowInsetsCompat;
    }

    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof WindowInsetsCompat;
        if (!bl2) {
            return false;
        }
        object = (WindowInsetsCompat)object;
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = this.mImpl;
        object = ((WindowInsetsCompat)object).mImpl;
        return ObjectsCompat.equals(windowInsetsCompat$Impl, object);
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public Insets getInsets(int n10) {
        return this.mImpl.getInsets(n10);
    }

    public Insets getInsetsIgnoringVisibility(int n10) {
        return this.mImpl.getInsetsIgnoringVisibility(n10);
    }

    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean hasInsets() {
        Insets insets;
        int n10 = WindowInsetsCompat$Type.all();
        Object object = this.getInsets(n10);
        if ((n10 = (int)(((Insets)object).equals(insets = Insets.NONE) ? 1 : 0)) == 0) return 1 != 0;
        n10 = WindowInsetsCompat$Type.all();
        int n11 = WindowInsetsCompat$Type.ime();
        n10 ^= n11;
        object = this.getInsetsIgnoringVisibility(n10);
        if ((n10 = (int)(((Insets)object).equals(insets) ? 1 : 0)) == 0) return 1 != 0;
        object = this.getDisplayCutout();
        if (object == null) return 0 != 0;
        return 1 != 0;
    }

    public boolean hasStableInsets() {
        Insets insets = this.mImpl.getStableInsets();
        Insets insets2 = Insets.NONE;
        return insets.equals(insets2) ^ true;
    }

    public boolean hasSystemWindowInsets() {
        Insets insets = this.mImpl.getSystemWindowInsets();
        Insets insets2 = Insets.NONE;
        return insets.equals(insets2) ^ true;
    }

    public int hashCode() {
        int n10;
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = this.mImpl;
        if (windowInsetsCompat$Impl == null) {
            n10 = 0;
            windowInsetsCompat$Impl = null;
        } else {
            n10 = windowInsetsCompat$Impl.hashCode();
        }
        return n10;
    }

    public WindowInsetsCompat inset(int n10, int n11, int n12, int n13) {
        return this.mImpl.inset(n10, n11, n12, n13);
    }

    public WindowInsetsCompat inset(Insets insets) {
        int n10 = insets.left;
        int n11 = insets.top;
        int n12 = insets.right;
        int n13 = insets.bottom;
        return this.inset(n10, n11, n12, n13);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int n10) {
        return this.mImpl.isVisible(n10);
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int n10, int n11, int n12, int n13) {
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder(this);
        Insets insets = Insets.of(n10, n11, n12, n13);
        return windowInsetsCompat$Builder.setSystemWindowInsets(insets).build();
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect object) {
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder(this);
        object = Insets.of(object);
        return windowInsetsCompat$Builder.setSystemWindowInsets((Insets)object).build();
    }

    public void setOverriddenInsets(Insets[] insetsArray) {
        this.mImpl.setOverriddenInsets(insetsArray);
    }

    public void setRootViewData(Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    public void setStableInsets(Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    public WindowInsets toWindowInsets() {
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = this.mImpl;
        boolean bl2 = windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl20;
        windowInsetsCompat$Impl = bl2 ? ((WindowInsetsCompat$Impl20)windowInsetsCompat$Impl).mPlatformInsets : null;
        return windowInsetsCompat$Impl;
    }
}


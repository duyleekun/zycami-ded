/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.core.view;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;

public class WindowInsetsCompat$Impl {
    public static final WindowInsetsCompat CONSUMED;
    public final WindowInsetsCompat mHost;

    static {
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder();
        CONSUMED = windowInsetsCompat$Builder.build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    }

    public WindowInsetsCompat$Impl(WindowInsetsCompat windowInsetsCompat) {
        this.mHost = windowInsetsCompat;
    }

    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mHost;
    }

    public WindowInsetsCompat consumeStableInsets() {
        return this.mHost;
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mHost;
    }

    public void copyRootViewBounds(View view) {
    }

    public void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
    }

    public boolean equals(Object object) {
        boolean bl2;
        Insets insets;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (this == object) {
            return bl4;
        }
        boolean bl5 = object instanceof WindowInsetsCompat$Impl;
        if (!bl5) {
            return false;
        }
        object = (WindowInsetsCompat$Impl)object;
        bl5 = this.isRound();
        if (!(bl5 == (bl3 = ((WindowInsetsCompat$Impl)object).isRound()) && (bl5 = this.isConsumed()) == (bl3 = ((WindowInsetsCompat$Impl)object).isConsumed()) && (bl5 = ObjectsCompat.equals(object2 = this.getSystemWindowInsets(), insets = ((WindowInsetsCompat$Impl)object).getSystemWindowInsets())) && (bl5 = ObjectsCompat.equals(object2 = this.getStableInsets(), insets = ((WindowInsetsCompat$Impl)object).getStableInsets())) && (bl2 = ObjectsCompat.equals(object2 = this.getDisplayCutout(), object = ((WindowInsetsCompat$Impl)object).getDisplayCutout())))) {
            bl4 = false;
        }
        return bl4;
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return null;
    }

    public Insets getInsets(int n10) {
        return Insets.NONE;
    }

    public Insets getInsetsIgnoringVisibility(int n10) {
        if ((n10 &= 8) == 0) {
            return Insets.NONE;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to query the maximum insets for IME");
        throw illegalArgumentException;
    }

    public Insets getMandatorySystemGestureInsets() {
        return this.getSystemWindowInsets();
    }

    public Insets getStableInsets() {
        return Insets.NONE;
    }

    public Insets getSystemGestureInsets() {
        return this.getSystemWindowInsets();
    }

    public Insets getSystemWindowInsets() {
        return Insets.NONE;
    }

    public Insets getTappableElementInsets() {
        return this.getSystemWindowInsets();
    }

    public int hashCode() {
        Object object = this.isRound();
        Object[] objectArray = new Object[]{object, object = Boolean.valueOf(this.isConsumed()), object = this.getSystemWindowInsets(), object = this.getStableInsets(), object = this.getDisplayCutout()};
        return ObjectsCompat.hash(objectArray);
    }

    public WindowInsetsCompat inset(int n10, int n11, int n12, int n13) {
        return CONSUMED;
    }

    public boolean isConsumed() {
        return false;
    }

    public boolean isRound() {
        return false;
    }

    public boolean isVisible(int n10) {
        return true;
    }

    public void setOverriddenInsets(Insets[] insetsArray) {
    }

    public void setRootViewData(Insets insets) {
    }

    public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
    }

    public void setStableInsets(Insets insets) {
    }
}


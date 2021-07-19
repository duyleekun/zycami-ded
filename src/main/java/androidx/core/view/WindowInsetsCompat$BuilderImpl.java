/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view;

import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Type;

public class WindowInsetsCompat$BuilderImpl {
    private final WindowInsetsCompat mInsets;
    public Insets[] mInsetsTypeMask;

    public WindowInsetsCompat$BuilderImpl() {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(null);
        this(windowInsetsCompat);
    }

    public WindowInsetsCompat$BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
        this.mInsets = windowInsetsCompat;
    }

    public final void applyInsetTypes() {
        Object object = this.mInsetsTypeMask;
        if (object != null) {
            int n10 = WindowInsetsCompat$Type.indexOf(1);
            object = object[n10];
            Object object2 = this.mInsetsTypeMask;
            int n11 = WindowInsetsCompat$Type.indexOf(2);
            object2 = object2[n11];
            if (object != null && object2 != null) {
                object = Insets.max((Insets)object, (Insets)object2);
                this.setSystemWindowInsets((Insets)object);
            } else if (object != null) {
                this.setSystemWindowInsets((Insets)object);
            } else if (object2 != null) {
                this.setSystemWindowInsets((Insets)object2);
            }
            object = this.mInsetsTypeMask;
            n10 = WindowInsetsCompat$Type.indexOf(16);
            object = object[n10];
            if (object != null) {
                this.setSystemGestureInsets((Insets)object);
            }
            object = this.mInsetsTypeMask;
            n10 = WindowInsetsCompat$Type.indexOf(32);
            if ((object = object[n10]) != null) {
                this.setMandatorySystemGestureInsets((Insets)object);
            }
            object = this.mInsetsTypeMask;
            n10 = WindowInsetsCompat$Type.indexOf(64);
            if ((object = object[n10]) != null) {
                this.setTappableElementInsets((Insets)object);
            }
        }
    }

    public WindowInsetsCompat build() {
        this.applyInsetTypes();
        return this.mInsets;
    }

    public void setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
    }

    public void setInsets(int n10, Insets insets) {
        int n11;
        int n12;
        Insets[] insetsArray = this.mInsetsTypeMask;
        if (insetsArray == null) {
            n12 = 9;
            this.mInsetsTypeMask = insetsArray = new Insets[n12];
        }
        for (n12 = 1; n12 <= (n11 = 256); n12 <<= 1) {
            n11 = n10 & n12;
            if (n11 == 0) continue;
            Insets[] insetsArray2 = this.mInsetsTypeMask;
            int n13 = WindowInsetsCompat$Type.indexOf(n12);
            insetsArray2[n13] = insets;
        }
    }

    public void setInsetsIgnoringVisibility(int n10, Insets insets) {
        int n11 = 8;
        if (n10 != n11) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Ignoring visibility inset not available for IME");
        throw illegalArgumentException;
    }

    public void setMandatorySystemGestureInsets(Insets insets) {
    }

    public void setStableInsets(Insets insets) {
    }

    public void setSystemGestureInsets(Insets insets) {
    }

    public void setSystemWindowInsets(Insets insets) {
    }

    public void setTappableElementInsets(Insets insets) {
    }

    public void setVisible(int n10, boolean bl2) {
    }
}


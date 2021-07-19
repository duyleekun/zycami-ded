/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.WindowInsetsAnimationController
 */
package androidx.core.view;

import android.os.Build;
import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationControllerCompat$Impl;
import androidx.core.view.WindowInsetsAnimationControllerCompat$Impl30;

public final class WindowInsetsAnimationControllerCompat {
    private final WindowInsetsAnimationControllerCompat$Impl mImpl;

    public WindowInsetsAnimationControllerCompat() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            WindowInsetsAnimationControllerCompat$Impl windowInsetsAnimationControllerCompat$Impl;
            this.mImpl = windowInsetsAnimationControllerCompat$Impl = new WindowInsetsAnimationControllerCompat$Impl();
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("On API 30+, the constructor taking a ");
        String string2 = WindowInsetsAnimationController.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" as parameter");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        WindowInsetsAnimationControllerCompat$Impl30 windowInsetsAnimationControllerCompat$Impl30 = new WindowInsetsAnimationControllerCompat$Impl30(windowInsetsAnimationController);
        this.mImpl = windowInsetsAnimationControllerCompat$Impl30;
    }

    public void finish(boolean bl2) {
        this.mImpl.finish(bl2);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        boolean bl2 = this.isFinished();
        bl2 = !bl2 && !(bl2 = this.isCancelled());
        return bl2;
    }

    public void setInsetsAndAlpha(Insets insets, float f10, float f11) {
        this.mImpl.setInsetsAndAlpha(insets, f10, f11);
    }
}


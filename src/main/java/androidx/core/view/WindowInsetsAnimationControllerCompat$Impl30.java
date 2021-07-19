/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.WindowInsetsAnimationController
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;
import androidx.core.view.WindowInsetsAnimationControllerCompat$Impl;

public class WindowInsetsAnimationControllerCompat$Impl30
extends WindowInsetsAnimationControllerCompat$Impl {
    private final WindowInsetsAnimationController mController;

    public WindowInsetsAnimationControllerCompat$Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mController = windowInsetsAnimationController;
    }

    public void finish(boolean bl2) {
        this.mController.finish(bl2);
    }

    public float getCurrentAlpha() {
        return this.mController.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mController.getCurrentFraction();
    }

    public androidx.core.graphics.Insets getCurrentInsets() {
        return androidx.core.graphics.Insets.toCompatInsets(this.mController.getCurrentInsets());
    }

    public androidx.core.graphics.Insets getHiddenStateInsets() {
        return androidx.core.graphics.Insets.toCompatInsets(this.mController.getHiddenStateInsets());
    }

    public androidx.core.graphics.Insets getShownStateInsets() {
        return androidx.core.graphics.Insets.toCompatInsets(this.mController.getShownStateInsets());
    }

    public int getTypes() {
        return this.mController.getTypes();
    }

    public boolean isCancelled() {
        return this.mController.isCancelled();
    }

    public boolean isFinished() {
        return this.mController.isFinished();
    }

    public boolean isReady() {
        return this.mController.isReady();
    }

    public void setInsetsAndAlpha(androidx.core.graphics.Insets insets, float f10, float f11) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.mController;
        insets = insets == null ? null : insets.toPlatformInsets();
        windowInsetsAnimationController.setInsetsAndAlpha((Insets)insets, f10, f11);
    }
}


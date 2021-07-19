/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.DisplayCutout
 *  android.view.WindowInsets
 *  android.view.WindowInsets$Builder
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$BuilderImpl;

public class WindowInsetsCompat$BuilderImpl29
extends WindowInsetsCompat$BuilderImpl {
    public final WindowInsets.Builder mPlatBuilder;

    public WindowInsetsCompat$BuilderImpl29() {
        WindowInsets.Builder builder;
        this.mPlatBuilder = builder = new WindowInsets.Builder();
    }

    public WindowInsetsCompat$BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
        windowInsetsCompat = windowInsetsCompat.toWindowInsets();
        WindowInsets.Builder builder = windowInsetsCompat != null ? new WindowInsets.Builder((WindowInsets)windowInsetsCompat) : new WindowInsets.Builder();
        this.mPlatBuilder = builder;
    }

    public WindowInsetsCompat build() {
        this.applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
        androidx.core.graphics.Insets[] insetsArray = this.mInsetsTypeMask;
        windowInsetsCompat.setOverriddenInsets(insetsArray);
        return windowInsetsCompat;
    }

    public void setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        displayCutoutCompat = displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null;
        builder.setDisplayCutout((DisplayCutout)displayCutoutCompat);
    }

    public void setMandatorySystemGestureInsets(androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        insets = insets.toPlatformInsets();
        builder.setMandatorySystemGestureInsets((Insets)insets);
    }

    public void setStableInsets(androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        insets = insets.toPlatformInsets();
        builder.setStableInsets((Insets)insets);
    }

    public void setSystemGestureInsets(androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        insets = insets.toPlatformInsets();
        builder.setSystemGestureInsets((Insets)insets);
    }

    public void setSystemWindowInsets(androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        insets = insets.toPlatformInsets();
        builder.setSystemWindowInsets((Insets)insets);
    }

    public void setTappableElementInsets(androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        insets = insets.toPlatformInsets();
        builder.setTappableElementInsets((Insets)insets);
    }
}


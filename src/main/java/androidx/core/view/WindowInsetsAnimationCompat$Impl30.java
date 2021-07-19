/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.View
 *  android.view.WindowInsetsAnimation
 *  android.view.WindowInsetsAnimation$Bounds
 *  android.view.WindowInsetsAnimation$Callback
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat$Impl;
import androidx.core.view.WindowInsetsAnimationCompat$Impl30$ProxyCallback;

public class WindowInsetsAnimationCompat$Impl30
extends WindowInsetsAnimationCompat$Impl {
    private final WindowInsetsAnimation mWrapped;

    public WindowInsetsAnimationCompat$Impl30(int n10, Interpolator interpolator2, long l10) {
        WindowInsetsAnimation windowInsetsAnimation = new WindowInsetsAnimation(n10, interpolator2, l10);
        this(windowInsetsAnimation);
    }

    public WindowInsetsAnimationCompat$Impl30(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.mWrapped = windowInsetsAnimation;
    }

    public static WindowInsetsAnimation.Bounds createPlatformBounds(WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        Insets insets = windowInsetsAnimationCompat$BoundsCompat.getLowerBound().toPlatformInsets();
        windowInsetsAnimationCompat$BoundsCompat = windowInsetsAnimationCompat$BoundsCompat.getUpperBound().toPlatformInsets();
        WindowInsetsAnimation.Bounds bounds = new WindowInsetsAnimation.Bounds(insets, (Insets)windowInsetsAnimationCompat$BoundsCompat);
        return bounds;
    }

    public static androidx.core.graphics.Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
        return androidx.core.graphics.Insets.toCompatInsets(bounds.getUpperBound());
    }

    public static androidx.core.graphics.Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
        return androidx.core.graphics.Insets.toCompatInsets(bounds.getLowerBound());
    }

    public static void setCallback(View view, WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        WindowInsetsAnimationCompat$Impl30$ProxyCallback windowInsetsAnimationCompat$Impl30$ProxyCallback = windowInsetsAnimationCompat$Callback != null ? new WindowInsetsAnimationCompat$Impl30$ProxyCallback(windowInsetsAnimationCompat$Callback) : null;
        view.setWindowInsetsAnimationCallback((WindowInsetsAnimation.Callback)windowInsetsAnimationCompat$Impl30$ProxyCallback);
    }

    public long getDurationMillis() {
        return this.mWrapped.getDurationMillis();
    }

    public float getFraction() {
        return this.mWrapped.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mWrapped.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mWrapped.getInterpolator();
    }

    public int getTypeMask() {
        return this.mWrapped.getTypeMask();
    }

    public void setFraction(float f10) {
        this.mWrapped.setFraction(f10);
    }
}


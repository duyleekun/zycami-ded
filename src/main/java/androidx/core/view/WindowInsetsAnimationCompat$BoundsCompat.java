/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsAnimation$Bounds
 */
package androidx.core.view;

import android.view.WindowInsetsAnimation;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat$Impl30;
import androidx.core.view.WindowInsetsCompat;

public final class WindowInsetsAnimationCompat$BoundsCompat {
    private final Insets mLowerBound;
    private final Insets mUpperBound;

    private WindowInsetsAnimationCompat$BoundsCompat(WindowInsetsAnimation.Bounds object) {
        Insets insets;
        this.mLowerBound = insets = WindowInsetsAnimationCompat$Impl30.getLowerBounds(object);
        object = WindowInsetsAnimationCompat$Impl30.getHigherBounds(object);
        this.mUpperBound = object;
    }

    public WindowInsetsAnimationCompat$BoundsCompat(Insets insets, Insets insets2) {
        this.mLowerBound = insets;
        this.mUpperBound = insets2;
    }

    public static WindowInsetsAnimationCompat$BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
        WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat = new WindowInsetsAnimationCompat$BoundsCompat(bounds);
        return windowInsetsAnimationCompat$BoundsCompat;
    }

    public Insets getLowerBound() {
        return this.mLowerBound;
    }

    public Insets getUpperBound() {
        return this.mUpperBound;
    }

    public WindowInsetsAnimationCompat$BoundsCompat inset(Insets insets) {
        Insets insets2 = this.mLowerBound;
        int n10 = insets.left;
        int n11 = insets.top;
        int n12 = insets.right;
        int n13 = insets.bottom;
        insets2 = WindowInsetsCompat.insetInsets(insets2, n10, n11, n12, n13);
        Insets insets3 = this.mUpperBound;
        n11 = insets.left;
        n12 = insets.top;
        n13 = insets.right;
        int n14 = insets.bottom;
        insets = WindowInsetsCompat.insetInsets(insets3, n11, n12, n13, n14);
        WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat = new WindowInsetsAnimationCompat$BoundsCompat(insets2, insets);
        return windowInsetsAnimationCompat$BoundsCompat;
    }

    public WindowInsetsAnimation.Bounds toBounds() {
        return WindowInsetsAnimationCompat$Impl30.createPlatformBounds(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bounds{lower=");
        Insets insets = this.mLowerBound;
        stringBuilder.append(insets);
        stringBuilder.append(" upper=");
        insets = this.mUpperBound;
        stringBuilder.append(insets);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 */
package androidx.camera.core;

import android.util.Rational;
import androidx.camera.core.ViewPort;
import androidx.core.util.Preconditions;

public final class ViewPort$Builder {
    private static final int DEFAULT_LAYOUT_DIRECTION = 0;
    private static final int DEFAULT_SCALE_TYPE = 1;
    private final Rational mAspectRatio;
    private int mLayoutDirection = 0;
    private final int mRotation;
    private int mScaleType = 1;

    public ViewPort$Builder(Rational rational, int n10) {
        this.mAspectRatio = rational;
        this.mRotation = n10;
    }

    public ViewPort build() {
        Preconditions.checkNotNull(this.mAspectRatio, "The crop aspect ratio must be set.");
        int n10 = this.mScaleType;
        Rational rational = this.mAspectRatio;
        int n11 = this.mRotation;
        int n12 = this.mLayoutDirection;
        ViewPort viewPort = new ViewPort(n10, rational, n11, n12);
        return viewPort;
    }

    public ViewPort$Builder setLayoutDirection(int n10) {
        this.mLayoutDirection = n10;
        return this;
    }

    public ViewPort$Builder setScaleType(int n10) {
        this.mScaleType = n10;
        return this;
    }
}


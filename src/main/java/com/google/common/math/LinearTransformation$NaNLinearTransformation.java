/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LinearTransformation;

public final class LinearTransformation$NaNLinearTransformation
extends LinearTransformation {
    public static final LinearTransformation$NaNLinearTransformation INSTANCE;

    static {
        LinearTransformation$NaNLinearTransformation linearTransformation$NaNLinearTransformation;
        INSTANCE = linearTransformation$NaNLinearTransformation = new LinearTransformation$NaNLinearTransformation();
    }

    private LinearTransformation$NaNLinearTransformation() {
    }

    public LinearTransformation inverse() {
        return this;
    }

    public boolean isHorizontal() {
        return false;
    }

    public boolean isVertical() {
        return false;
    }

    public double slope() {
        return 0.0 / 0.0;
    }

    public String toString() {
        return "NaN";
    }

    public double transform(double d10) {
        return 0.0 / 0.0;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask$MaskMode;

public class Mask {
    private final boolean inverted;
    private final Mask$MaskMode maskMode;
    private final AnimatableShapeValue maskPath;
    private final AnimatableIntegerValue opacity;

    public Mask(Mask$MaskMode mask$MaskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean bl2) {
        this.maskMode = mask$MaskMode;
        this.maskPath = animatableShapeValue;
        this.opacity = animatableIntegerValue;
        this.inverted = bl2;
    }

    public Mask$MaskMode getMaskMode() {
        return this.maskMode;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.maskPath;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public boolean isInverted() {
        return this.inverted;
    }
}


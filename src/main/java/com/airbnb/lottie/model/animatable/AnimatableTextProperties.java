/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;

public class AnimatableTextProperties {
    public final AnimatableColorValue color;
    public final AnimatableColorValue stroke;
    public final AnimatableFloatValue strokeWidth;
    public final AnimatableFloatValue tracking;

    public AnimatableTextProperties(AnimatableColorValue animatableColorValue, AnimatableColorValue animatableColorValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
    }
}


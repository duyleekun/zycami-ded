/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape
implements ContentModel {
    private final boolean hidden;
    private final boolean isReversed;
    private final String name;
    private final AnimatableValue position;
    private final AnimatablePointValue size;

    public CircleShape(String string2, AnimatableValue animatableValue, AnimatablePointValue animatablePointValue, boolean bl2, boolean bl3) {
        this.name = string2;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.isReversed = bl2;
        this.hidden = bl3;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableValue getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isReversed() {
        return this.isReversed;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        EllipseContent ellipseContent = new EllipseContent(lottieDrawable, baseLayer, this);
        return ellipseContent;
    }
}


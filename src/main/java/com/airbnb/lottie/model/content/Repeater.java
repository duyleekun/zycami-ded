/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class Repeater
implements ContentModel {
    private final AnimatableFloatValue copies;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableTransform transform;

    public Repeater(String string2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean bl2) {
        this.name = string2;
        this.copies = animatableFloatValue;
        this.offset = animatableFloatValue2;
        this.transform = animatableTransform;
        this.hidden = bl2;
    }

    public AnimatableFloatValue getCopies() {
        return this.copies;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        RepeaterContent repeaterContent = new RepeaterContent(lottieDrawable, baseLayer, this);
        return repeaterContent;
    }
}


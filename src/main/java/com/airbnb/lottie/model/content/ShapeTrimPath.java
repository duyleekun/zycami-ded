/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath
implements ContentModel {
    private final AnimatableFloatValue end;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableFloatValue start;
    private final ShapeTrimPath$Type type;

    public ShapeTrimPath(String string2, ShapeTrimPath$Type shapeTrimPath$Type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean bl2) {
        this.name = string2;
        this.type = shapeTrimPath$Type;
        this.start = animatableFloatValue;
        this.end = animatableFloatValue2;
        this.offset = animatableFloatValue3;
        this.hidden = bl2;
    }

    public AnimatableFloatValue getEnd() {
        return this.end;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public AnimatableFloatValue getStart() {
        return this.start;
    }

    public ShapeTrimPath$Type getType() {
        return this.type;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable object, BaseLayer baseLayer) {
        object = new TrimPathContent(baseLayer, this);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trim Path: {start: ");
        AnimatableFloatValue animatableFloatValue = this.start;
        stringBuilder.append(animatableFloatValue);
        stringBuilder.append(", end: ");
        animatableFloatValue = this.end;
        stringBuilder.append(animatableFloatValue);
        stringBuilder.append(", offset: ");
        animatableFloatValue = this.offset;
        stringBuilder.append(animatableFloatValue);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableTextFrame
extends BaseAnimatableValue {
    public AnimatableTextFrame(List list) {
        super(list);
    }

    public TextKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(list);
        return textKeyframeAnimation;
    }
}


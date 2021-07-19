/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableGradientColorValue
extends BaseAnimatableValue {
    public AnimatableGradientColorValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = new GradientColorKeyframeAnimation(list);
        return gradientColorKeyframeAnimation;
    }
}


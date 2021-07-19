/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableColorValue
extends BaseAnimatableValue {
    public AnimatableColorValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        ColorKeyframeAnimation colorKeyframeAnimation = new ColorKeyframeAnimation(list);
        return colorKeyframeAnimation;
    }
}


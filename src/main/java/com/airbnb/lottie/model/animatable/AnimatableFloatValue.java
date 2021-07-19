/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableFloatValue
extends BaseAnimatableValue {
    public AnimatableFloatValue() {
        Float f10 = Float.valueOf(0.0f);
        super(f10);
    }

    public AnimatableFloatValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(list);
        return floatKeyframeAnimation;
    }
}


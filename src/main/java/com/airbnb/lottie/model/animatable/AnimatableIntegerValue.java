/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableIntegerValue
extends BaseAnimatableValue {
    public AnimatableIntegerValue() {
        Integer n10 = 100;
        super(n10);
    }

    public AnimatableIntegerValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        IntegerKeyframeAnimation integerKeyframeAnimation = new IntegerKeyframeAnimation(list);
        return integerKeyframeAnimation;
    }
}


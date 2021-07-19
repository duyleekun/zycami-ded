/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatablePointValue
extends BaseAnimatableValue {
    public AnimatablePointValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        PointKeyframeAnimation pointKeyframeAnimation = new PointKeyframeAnimation(list);
        return pointKeyframeAnimation;
    }
}


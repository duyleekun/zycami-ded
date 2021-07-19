/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import java.util.List;

public class AnimatableShapeValue
extends BaseAnimatableValue {
    public AnimatableShapeValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        ShapeKeyframeAnimation shapeKeyframeAnimation = new ShapeKeyframeAnimation(list);
        return shapeKeyframeAnimation;
    }
}


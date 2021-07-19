/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.airbnb.lottie.model.animatable.BaseAnimatableValue;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class AnimatableScaleValue
extends BaseAnimatableValue {
    public AnimatableScaleValue() {
        float f10 = 1.0f;
        ScaleXY scaleXY = new ScaleXY(f10, f10);
        this(scaleXY);
    }

    public AnimatableScaleValue(ScaleXY scaleXY) {
        super(scaleXY);
    }

    public AnimatableScaleValue(List list) {
        super(list);
    }

    public BaseKeyframeAnimation createAnimation() {
        List list = this.keyframes;
        ScaleKeyframeAnimation scaleKeyframeAnimation = new ScaleKeyframeAnimation(list);
        return scaleKeyframeAnimation;
    }
}


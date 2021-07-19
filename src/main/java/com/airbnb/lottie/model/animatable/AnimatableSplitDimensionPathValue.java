/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

public class AnimatableSplitDimensionPathValue
implements AnimatableValue {
    private final AnimatableFloatValue animatableXDimension;
    private final AnimatableFloatValue animatableYDimension;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.animatableXDimension = animatableFloatValue;
        this.animatableYDimension = animatableFloatValue2;
    }

    public BaseKeyframeAnimation createAnimation() {
        BaseKeyframeAnimation baseKeyframeAnimation = this.animatableXDimension.createAnimation();
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.animatableYDimension.createAnimation();
        SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation = new SplitDimensionPathKeyframeAnimation(baseKeyframeAnimation, baseKeyframeAnimation2);
        return splitDimensionPathKeyframeAnimation;
    }

    public List getKeyframes() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
        throw unsupportedOperationException;
    }

    public boolean isStatic() {
        AnimatableFloatValue animatableFloatValue = this.animatableXDimension;
        boolean bl2 = animatableFloatValue.isStatic();
        if (bl2 && (bl2 = (animatableFloatValue = this.animatableYDimension).isStatic())) {
            bl2 = true;
        } else {
            bl2 = false;
            animatableFloatValue = null;
        }
        return bl2;
    }
}


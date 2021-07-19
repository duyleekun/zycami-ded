/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

public interface AnimatableValue {
    public BaseKeyframeAnimation createAnimation();

    public List getKeyframes();

    public boolean isStatic();
}


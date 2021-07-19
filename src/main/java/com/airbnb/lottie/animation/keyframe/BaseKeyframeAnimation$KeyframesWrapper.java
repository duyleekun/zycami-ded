/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;

public interface BaseKeyframeAnimation$KeyframesWrapper {
    public Keyframe getCurrentKeyframe();

    public float getEndProgress();

    public float getStartDelayProgress();

    public boolean isCachedValueEnabled(float var1);

    public boolean isEmpty();

    public boolean isValueChanged(float var1);
}


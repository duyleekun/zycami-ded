/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public final class BaseKeyframeAnimation$SingleKeyframeWrapper
implements BaseKeyframeAnimation$KeyframesWrapper {
    private float cachedInterpolatedProgress = -1.0f;
    private final Keyframe keyframe;

    public BaseKeyframeAnimation$SingleKeyframeWrapper(List object) {
        this.keyframe = object = (Keyframe)object.get(0);
    }

    public Keyframe getCurrentKeyframe() {
        return this.keyframe;
    }

    public float getEndProgress() {
        return this.keyframe.getEndProgress();
    }

    public float getStartDelayProgress() {
        return this.keyframe.getStartProgress();
    }

    public boolean isCachedValueEnabled(float f10) {
        float f11 = this.cachedInterpolatedProgress;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return true;
        }
        this.cachedInterpolatedProgress = f10;
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isValueChanged(float f10) {
        return this.keyframe.isStatic() ^ true;
    }
}


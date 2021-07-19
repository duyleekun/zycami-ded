/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$1;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper;
import com.airbnb.lottie.value.Keyframe;

public final class BaseKeyframeAnimation$EmptyKeyframeWrapper
implements BaseKeyframeAnimation$KeyframesWrapper {
    private BaseKeyframeAnimation$EmptyKeyframeWrapper() {
    }

    public /* synthetic */ BaseKeyframeAnimation$EmptyKeyframeWrapper(BaseKeyframeAnimation$1 baseKeyframeAnimation$1) {
        this();
    }

    public Keyframe getCurrentKeyframe() {
        IllegalStateException illegalStateException = new IllegalStateException("not implemented");
        throw illegalStateException;
    }

    public float getEndProgress() {
        return 1.0f;
    }

    public float getStartDelayProgress() {
        return 0.0f;
    }

    public boolean isCachedValueEnabled(float f10) {
        IllegalStateException illegalStateException = new IllegalStateException("not implemented");
        throw illegalStateException;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isValueChanged(float f10) {
        return false;
    }
}


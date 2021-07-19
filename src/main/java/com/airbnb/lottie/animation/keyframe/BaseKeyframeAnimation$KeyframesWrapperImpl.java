/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public final class BaseKeyframeAnimation$KeyframesWrapperImpl
implements BaseKeyframeAnimation$KeyframesWrapper {
    private Keyframe cachedCurrentKeyframe = null;
    private float cachedInterpolatedProgress = -1.0f;
    private Keyframe currentKeyframe;
    private final List keyframes;

    public BaseKeyframeAnimation$KeyframesWrapperImpl(List object) {
        this.keyframes = object;
        this.currentKeyframe = object = this.findKeyframe(0.0f);
    }

    private Keyframe findKeyframe(float f10) {
        Object object = this.keyframes;
        int n10 = object.size();
        int n11 = 1;
        n10 -= n11;
        float f11 = ((Keyframe)(object = (Keyframe)object.get(n10))).getStartProgress();
        float f12 = f10 - f11;
        if ((n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) >= 0) {
            return object;
        }
        object = this.keyframes;
        for (int i10 = object.size() + -2; i10 >= n11; i10 += -1) {
            boolean bl2;
            Keyframe keyframe = this.currentKeyframe;
            Keyframe keyframe2 = (Keyframe)this.keyframes.get(i10);
            if (keyframe == keyframe2 || !(bl2 = keyframe2.containsProgress(f10))) continue;
            return keyframe2;
        }
        return (Keyframe)this.keyframes.get(0);
    }

    public Keyframe getCurrentKeyframe() {
        return this.currentKeyframe;
    }

    public float getEndProgress() {
        List list = this.keyframes;
        int n10 = list.size() + -1;
        return ((Keyframe)list.get(n10)).getEndProgress();
    }

    public float getStartDelayProgress() {
        return ((Keyframe)this.keyframes.get(0)).getStartProgress();
    }

    public boolean isCachedValueEnabled(float f10) {
        float f11;
        float f12;
        float f13;
        Keyframe keyframe = this.cachedCurrentKeyframe;
        Keyframe keyframe2 = this.currentKeyframe;
        if (keyframe == keyframe2 && (f13 = (f12 = (f11 = this.cachedInterpolatedProgress) - f10) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) == false) {
            return true;
        }
        this.cachedCurrentKeyframe = keyframe2;
        this.cachedInterpolatedProgress = f10;
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isValueChanged(float f10) {
        Keyframe keyframe;
        Keyframe keyframe2 = this.currentKeyframe;
        boolean bl2 = keyframe2.containsProgress(f10);
        boolean bl3 = true;
        if (bl2) {
            return this.currentKeyframe.isStatic() ^ bl3;
        }
        this.currentKeyframe = keyframe = this.findKeyframe(f10);
        return bl3;
    }
}


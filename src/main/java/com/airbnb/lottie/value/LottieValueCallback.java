/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.LottieFrameInfo;

public class LottieValueCallback {
    private BaseKeyframeAnimation animation;
    private final LottieFrameInfo frameInfo;
    public Object value;

    public LottieValueCallback() {
        LottieFrameInfo lottieFrameInfo;
        this.frameInfo = lottieFrameInfo = new LottieFrameInfo();
        this.value = null;
    }

    public LottieValueCallback(Object object) {
        LottieFrameInfo lottieFrameInfo;
        this.frameInfo = lottieFrameInfo = new LottieFrameInfo();
        this.value = null;
        this.value = object;
    }

    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return this.value;
    }

    public final Object getValueInternal(float f10, float f11, Object object, Object object2, float f12, float f13, float f14) {
        LottieFrameInfo lottieFrameInfo = this.frameInfo.set(f10, f11, object, object2, f12, f13, f14);
        return this.getValue(lottieFrameInfo);
    }

    public final void setAnimation(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }

    public final void setValue(Object object) {
        this.value = object;
        object = this.animation;
        if (object != null) {
            ((BaseKeyframeAnimation)object).notifyListeners();
        }
    }
}


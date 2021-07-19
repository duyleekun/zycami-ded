/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;
import java.util.List;

public class ValueCallbackKeyframeAnimation
extends BaseKeyframeAnimation {
    private final LottieFrameInfo frameInfo;
    private final Object valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback, Object object) {
        Object object2 = Collections.emptyList();
        super((List)object2);
        this.frameInfo = object2 = new LottieFrameInfo();
        this.setValueCallback(lottieValueCallback);
        this.valueCallbackValue = object;
    }

    public float getEndProgress() {
        return 1.0f;
    }

    public Object getValue() {
        LottieValueCallback lottieValueCallback = this.valueCallback;
        Object object = this.valueCallbackValue;
        float f10 = this.getProgress();
        float f11 = this.getProgress();
        float f12 = this.getProgress();
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, object, object, f10, f11, f12);
    }

    public Object getValue(Keyframe keyframe, float f10) {
        return this.getValue();
    }

    public void notifyListeners() {
        LottieValueCallback lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            super.notifyListeners();
        }
    }

    public void setProgress(float f10) {
        this.progress = f10;
    }
}


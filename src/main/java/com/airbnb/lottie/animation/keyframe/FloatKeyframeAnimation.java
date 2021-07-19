/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation
extends KeyframeAnimation {
    public FloatKeyframeAnimation(List list) {
        super(list);
    }

    public float getFloatValue() {
        Keyframe keyframe = this.getCurrentKeyframe();
        float f10 = this.getInterpolatedCurrentKeyframeProgress();
        return this.getFloatValue(keyframe, f10);
    }

    public float getFloatValue(Keyframe object, float f10) {
        Object object2 = ((Keyframe)object).startValue;
        if (object2 != null && (object2 = ((Keyframe)object).endValue) != null) {
            float f11;
            float f12;
            Object object3;
            Object object4;
            float f13;
            float f14;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (object2 = (Float)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object).startFrame, f13 = ((Keyframe)object).endFrame.floatValue(), object4 = ((Keyframe)object).startValue, object3 = ((Keyframe)object).endValue, f10, f12 = this.getLinearCurrentKeyframeProgress(), f11 = this.getProgress())) != null) {
                return ((Float)object2).floatValue();
            }
            float f15 = ((Keyframe)object).getStartValueFloat();
            float f16 = ((Keyframe)object).getEndValueFloat();
            return MiscUtils.lerp(f15, f16, f10);
        }
        object = new IllegalStateException("Missing values for keyframe.");
        throw object;
    }

    public Float getValue(Keyframe keyframe, float f10) {
        return Float.valueOf(this.getFloatValue(keyframe, f10));
    }
}


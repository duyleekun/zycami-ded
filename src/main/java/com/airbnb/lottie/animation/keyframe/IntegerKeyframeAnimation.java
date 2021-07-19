/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation
extends KeyframeAnimation {
    public IntegerKeyframeAnimation(List list) {
        super(list);
    }

    public int getIntValue() {
        Keyframe keyframe = this.getCurrentKeyframe();
        float f10 = this.getInterpolatedCurrentKeyframeProgress();
        return this.getIntValue(keyframe, f10);
    }

    public int getIntValue(Keyframe object, float f10) {
        Object object2 = ((Keyframe)object).startValue;
        if (object2 != null && (object2 = ((Keyframe)object).endValue) != null) {
            float f11;
            float f12;
            Object object3;
            Object object4;
            float f13;
            float f14;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (object2 = (Integer)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object).startFrame, f13 = ((Keyframe)object).endFrame.floatValue(), object4 = ((Keyframe)object).startValue, object3 = ((Keyframe)object).endValue, f10, f12 = this.getLinearCurrentKeyframeProgress(), f11 = this.getProgress())) != null) {
                return (Integer)object2;
            }
            int n10 = ((Keyframe)object).getStartValueInt();
            int n11 = ((Keyframe)object).getEndValueInt();
            return MiscUtils.lerp(n10, n11, f10);
        }
        object = new IllegalStateException("Missing values for keyframe.");
        throw object;
    }

    public Integer getValue(Keyframe keyframe, float f10) {
        return this.getIntValue(keyframe, f10);
    }
}


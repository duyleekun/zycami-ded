/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class ColorKeyframeAnimation
extends KeyframeAnimation {
    public ColorKeyframeAnimation(List list) {
        super(list);
    }

    public int getIntValue() {
        Keyframe keyframe = this.getCurrentKeyframe();
        float f10 = this.getInterpolatedCurrentKeyframeProgress();
        return this.getIntValue(keyframe, f10);
    }

    public int getIntValue(Keyframe object, float f10) {
        Object object2;
        Object object3 = ((Keyframe)object).startValue;
        if (object3 != null && (object2 = ((Keyframe)object).endValue) != null) {
            float f11;
            float f12;
            Integer n10;
            Integer n11;
            float f13;
            float f14;
            object3 = (Integer)object3;
            int n12 = (Integer)object3;
            object2 = (Integer)((Keyframe)object).endValue;
            int n13 = (Integer)object2;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (object = (Integer)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object).startFrame, f13 = ((Keyframe)object).endFrame.floatValue(), n11 = Integer.valueOf(n12), n10 = Integer.valueOf(n13), f10, f12 = this.getLinearCurrentKeyframeProgress(), f11 = this.getProgress())) != null) {
                return (Integer)object;
            }
            return GammaEvaluator.evaluate(MiscUtils.clamp(f10, 0.0f, 1.0f), n12, n13);
        }
        object = new IllegalStateException("Missing values for keyframe.");
        throw object;
    }

    public Integer getValue(Keyframe keyframe, float f10) {
        return this.getIntValue(keyframe, f10);
    }
}


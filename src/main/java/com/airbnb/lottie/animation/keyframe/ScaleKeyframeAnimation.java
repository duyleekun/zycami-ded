/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation
extends KeyframeAnimation {
    private final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List object) {
        super((List)object);
        this.scaleXY = object = new ScaleXY();
    }

    public ScaleXY getValue(Keyframe object, float f10) {
        Object object2;
        Object object3 = ((Keyframe)object).startValue;
        if (object3 != null && (object2 = ((Keyframe)object).endValue) != null) {
            float f11;
            float f12;
            float f13;
            float f14;
            object3 = (ScaleXY)object3;
            object2 = (ScaleXY)object2;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (object = (ScaleXY)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object).startFrame, f13 = ((Keyframe)object).endFrame.floatValue(), object3, object2, f10, f12 = this.getLinearCurrentKeyframeProgress(), f11 = this.getProgress())) != null) {
                return object;
            }
            object = this.scaleXY;
            float f15 = ((ScaleXY)object3).getScaleX();
            f14 = ((ScaleXY)object2).getScaleX();
            f15 = MiscUtils.lerp(f15, f14, f10);
            float f16 = ((ScaleXY)object3).getScaleY();
            float f17 = ((ScaleXY)object2).getScaleY();
            f10 = MiscUtils.lerp(f16, f17, f10);
            ((ScaleXY)object).set(f15, f10);
            return this.scaleXY;
        }
        object = new IllegalStateException("Missing values for keyframe.");
        throw object;
    }
}


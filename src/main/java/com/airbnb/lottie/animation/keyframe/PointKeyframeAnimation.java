/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PointKeyframeAnimation
extends KeyframeAnimation {
    private final PointF point;

    public PointKeyframeAnimation(List list) {
        super(list);
        super();
        this.point = list;
    }

    public PointF getValue(Keyframe object, float f10) {
        Object object2;
        Object object3 = ((Keyframe)object).startValue;
        if (object3 != null && (object2 = ((Keyframe)object).endValue) != null) {
            float f11;
            float f12;
            float f13;
            float f14;
            object3 = (PointF)object3;
            object2 = (PointF)object2;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (object = (PointF)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object).startFrame, f13 = ((Keyframe)object).endFrame.floatValue(), object3, object2, f10, f12 = this.getLinearCurrentKeyframeProgress(), f11 = this.getProgress())) != null) {
                return object;
            }
            object = this.point;
            float f15 = ((PointF)object3).x;
            f14 = (((PointF)object2).x - f15) * f10;
            float f16 = ((PointF)object3).y;
            float f17 = ((PointF)object2).y - f16;
            object.set(f15 += f14, f16 += (f10 *= f17));
            return this.point;
        }
        object = new IllegalStateException("Missing values for keyframe.");
        throw object;
    }
}


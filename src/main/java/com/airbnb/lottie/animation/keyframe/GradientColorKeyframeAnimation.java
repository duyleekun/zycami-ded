/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation
extends KeyframeAnimation {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List object) {
        super((List)object);
        int n10 = 0;
        int[] nArray = null;
        object = (GradientColor)((Keyframe)object.get((int)0)).startValue;
        if (object != null) {
            n10 = ((GradientColor)object).getSize();
        }
        float[] fArray = new float[n10];
        nArray = new int[n10];
        this.gradientColor = object = new GradientColor(fArray, nArray);
    }

    public GradientColor getValue(Keyframe object, float f10) {
        GradientColor gradientColor = this.gradientColor;
        GradientColor gradientColor2 = (GradientColor)((Keyframe)object).startValue;
        object = (GradientColor)((Keyframe)object).endValue;
        gradientColor.lerp(gradientColor2, (GradientColor)object, f10);
        return this.gradientColor;
    }
}


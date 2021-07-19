/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation
extends KeyframeAnimation {
    public TextKeyframeAnimation(List list) {
        super(list);
    }

    public DocumentData getValue(Keyframe keyframe, float f10) {
        return (DocumentData)keyframe.startValue;
    }
}


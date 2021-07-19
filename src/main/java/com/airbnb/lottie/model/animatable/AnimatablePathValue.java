/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue
implements AnimatableValue {
    private final List keyframes;

    public AnimatablePathValue() {
        PointF pointF = new PointF(0.0f, 0.0f);
        Object object = new Keyframe(pointF);
        this.keyframes = object = Collections.singletonList(object);
    }

    public AnimatablePathValue(List list) {
        this.keyframes = list;
    }

    public BaseKeyframeAnimation createAnimation() {
        Object object = this.keyframes;
        List list = null;
        boolean bl2 = ((Keyframe)(object = (Keyframe)object.get(0))).isStatic();
        if (bl2) {
            list = this.keyframes;
            object = new PointKeyframeAnimation(list);
            return object;
        }
        list = this.keyframes;
        object = new PathKeyframeAnimation(list);
        return object;
    }

    public List getKeyframes() {
        return this.keyframes;
    }

    public boolean isStatic() {
        Object object = this.keyframes;
        int n10 = object.size();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12 && (n10 = (int)(((Keyframe)(object = (Keyframe)this.keyframes.get(0))).isStatic() ? 1 : 0)) != 0) {
            n11 = n12;
        }
        return n11 != 0;
    }
}


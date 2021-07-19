/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;

public class BaseLayer$1
implements BaseKeyframeAnimation$AnimationListener {
    public final /* synthetic */ BaseLayer this$0;

    public BaseLayer$1(BaseLayer baseLayer) {
        this.this$0 = baseLayer;
    }

    public void onValueChanged() {
        float f10;
        BaseLayer baseLayer = this.this$0;
        FloatKeyframeAnimation floatKeyframeAnimation = BaseLayer.access$000(baseLayer);
        float f11 = floatKeyframeAnimation.getFloatValue();
        float f12 = f11 - (f10 = 1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
            floatKeyframeAnimation = null;
        }
        BaseLayer.access$100(baseLayer, (boolean)object);
    }
}


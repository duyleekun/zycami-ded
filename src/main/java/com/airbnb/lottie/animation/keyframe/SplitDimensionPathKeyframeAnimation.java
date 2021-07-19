/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class SplitDimensionPathKeyframeAnimation
extends BaseKeyframeAnimation {
    private final PointF point;
    private final BaseKeyframeAnimation xAnimation;
    private final BaseKeyframeAnimation yAnimation;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        PointF pointF = Collections.emptyList();
        super((List)pointF);
        this.point = pointF = new PointF();
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        float f10 = this.getProgress();
        this.setProgress(f10);
    }

    public PointF getValue() {
        return this.getValue(null, 0.0f);
    }

    public PointF getValue(Keyframe keyframe, float f10) {
        return this.point;
    }

    public void setProgress(float f10) {
        int n10;
        this.xAnimation.setProgress(f10);
        this.yAnimation.setProgress(f10);
        PointF pointF = this.point;
        Object object = (Float)this.xAnimation.getValue();
        float f11 = ((Float)object).floatValue();
        Float f12 = (Float)this.yAnimation.getValue();
        float f13 = f12.floatValue();
        pointF.set(f11, f13);
        f10 = 0.0f;
        pointF = null;
        for (int i10 = 0; i10 < (n10 = (object = this.listeners).size()); ++i10) {
            object = (BaseKeyframeAnimation$AnimationListener)this.listeners.get(i10);
            object.onValueChanged();
        }
    }
}


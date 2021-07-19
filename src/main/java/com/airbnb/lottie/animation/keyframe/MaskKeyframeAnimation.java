/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {
    private final List maskAnimations;
    private final List masks;
    private final List opacityAnimations;

    public MaskKeyframeAnimation(List list) {
        ArrayList arrayList;
        this.masks = list;
        int n10 = list.size();
        this.maskAnimations = arrayList = new ArrayList(n10);
        n10 = list.size();
        this.opacityAnimations = arrayList = new ArrayList(n10);
        arrayList = null;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = this.maskAnimations;
            Object object2 = ((Mask)list.get(i10)).getMaskPath().createAnimation();
            object.add(object2);
            object = ((Mask)list.get(i10)).getOpacity();
            object2 = this.opacityAnimations;
            object = ((AnimatableIntegerValue)object).createAnimation();
            object2.add(object);
        }
    }

    public List getMaskAnimations() {
        return this.maskAnimations;
    }

    public List getMasks() {
        return this.masks;
    }

    public List getOpacityAnimations() {
        return this.opacityAnimations;
    }
}


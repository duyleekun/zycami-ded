/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class BaseAnimatableValue
implements AnimatableValue {
    public final List keyframes;

    public BaseAnimatableValue(Object list) {
        Keyframe keyframe = new Keyframe(list);
        list = Collections.singletonList(keyframe);
        this(list);
    }

    public BaseAnimatableValue(List list) {
        this.keyframes = list;
    }

    public List getKeyframes() {
        return this.keyframes;
    }

    public boolean isStatic() {
        Object object = this.keyframes;
        int n10 = object.isEmpty();
        int n11 = 0;
        int n12 = 1;
        if (n10 != 0 || (n10 = (object = this.keyframes).size()) == n12 && (n10 = (int)(((Keyframe)(object = (Keyframe)this.keyframes.get(0))).isStatic() ? 1 : 0)) != 0) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.keyframes;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            stringBuilder.append("values=");
            object = Arrays.toString(this.keyframes.toArray());
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }
}


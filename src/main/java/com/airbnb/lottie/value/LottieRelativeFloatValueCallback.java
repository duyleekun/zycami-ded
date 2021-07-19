/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public class LottieRelativeFloatValueCallback
extends LottieValueCallback {
    public LottieRelativeFloatValueCallback() {
    }

    public LottieRelativeFloatValueCallback(Float f10) {
        super(f10);
    }

    public Float getOffset(LottieFrameInfo object) {
        object = this.value;
        if (object != null) {
            return (Float)object;
        }
        object = new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw object;
    }

    public Float getValue(LottieFrameInfo lottieFrameInfo) {
        float f10 = ((Float)lottieFrameInfo.getStartValue()).floatValue();
        float f11 = ((Float)lottieFrameInfo.getEndValue()).floatValue();
        float f12 = lottieFrameInfo.getInterpolatedKeyframeProgress();
        f10 = MiscUtils.lerp(f10, f11, f12);
        float f13 = this.getOffset(lottieFrameInfo).floatValue();
        return Float.valueOf(f10 + f13);
    }
}


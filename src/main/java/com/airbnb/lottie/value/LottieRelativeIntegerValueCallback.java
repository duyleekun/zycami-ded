/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public class LottieRelativeIntegerValueCallback
extends LottieValueCallback {
    public Integer getOffset(LottieFrameInfo object) {
        object = this.value;
        if (object != null) {
            return (Integer)object;
        }
        object = new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw object;
    }

    public Integer getValue(LottieFrameInfo lottieFrameInfo) {
        int n10 = (Integer)lottieFrameInfo.getStartValue();
        int n11 = (Integer)lottieFrameInfo.getEndValue();
        float f10 = lottieFrameInfo.getInterpolatedKeyframeProgress();
        n10 = MiscUtils.lerp(n10, n11, f10);
        int n12 = this.getOffset(lottieFrameInfo);
        return n10 + n12;
    }
}


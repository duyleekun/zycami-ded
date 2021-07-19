/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

public class LottieRelativePointValueCallback
extends LottieValueCallback {
    private final PointF point;

    public LottieRelativePointValueCallback() {
        PointF pointF;
        this.point = pointF = new PointF();
    }

    public LottieRelativePointValueCallback(PointF pointF) {
        super(pointF);
        this.point = pointF = new PointF();
    }

    public PointF getOffset(LottieFrameInfo object) {
        object = this.value;
        if (object != null) {
            return (PointF)object;
        }
        object = new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw object;
    }

    public final PointF getValue(LottieFrameInfo lottieFrameInfo) {
        PointF pointF = this.point;
        float f10 = ((PointF)lottieFrameInfo.getStartValue()).x;
        float f11 = ((PointF)lottieFrameInfo.getEndValue()).x;
        float f12 = lottieFrameInfo.getInterpolatedKeyframeProgress();
        f10 = MiscUtils.lerp(f10, f11, f12);
        f11 = ((PointF)lottieFrameInfo.getStartValue()).y;
        f12 = ((PointF)lottieFrameInfo.getEndValue()).y;
        float f13 = lottieFrameInfo.getInterpolatedKeyframeProgress();
        f11 = MiscUtils.lerp(f11, f12, f13);
        pointF.set(f10, f11);
        lottieFrameInfo = this.getOffset(lottieFrameInfo);
        pointF = this.point;
        f10 = ((PointF)lottieFrameInfo).x;
        float f14 = ((PointF)lottieFrameInfo).y;
        pointF.offset(f10, f14);
        return this.point;
    }
}


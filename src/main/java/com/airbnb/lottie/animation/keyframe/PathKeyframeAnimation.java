/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation
extends KeyframeAnimation {
    private PathMeasure pathMeasure;
    private PathKeyframe pathMeasureKeyframe;
    private final PointF point;
    private final float[] pos;

    public PathKeyframeAnimation(List object) {
        super((List)object);
        super();
        this.point = object;
        object = new float[2];
        this.pos = (float[])object;
        object = new PathMeasure();
        this.pathMeasure = object;
    }

    public PointF getValue(Keyframe keyframe, float f10) {
        float f11;
        float f12;
        Object object;
        Object object2;
        float f13;
        float f14;
        Object object3 = keyframe;
        object3 = (PathKeyframe)keyframe;
        Path path = ((PathKeyframe)object3).getPath();
        if (path == null) {
            return (PointF)keyframe.startValue;
        }
        LottieValueCallback lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null && (keyframe = (PointF)lottieValueCallback.getValueInternal(f14 = ((Keyframe)object3).startFrame, f13 = ((Keyframe)object3).endFrame.floatValue(), object2 = ((Keyframe)object3).startValue, object = ((Keyframe)object3).endValue, f12 = this.getLinearCurrentKeyframeProgress(), f10, f11 = this.getProgress())) != null) {
            return keyframe;
        }
        keyframe = this.pathMeasureKeyframe;
        lottieValueCallback = null;
        if (keyframe != object3) {
            keyframe = this.pathMeasure;
            keyframe.setPath(path, false);
            this.pathMeasureKeyframe = object3;
        }
        keyframe = this.pathMeasure;
        float f15 = keyframe.getLength();
        object3 = this.pos;
        keyframe.getPosTan(f10 *= f15, (float[])object3, null);
        keyframe = this.point;
        float[] fArray = this.pos;
        f15 = fArray[0];
        f10 = fArray[1];
        keyframe.set(f15, f10);
        return this.point;
    }
}


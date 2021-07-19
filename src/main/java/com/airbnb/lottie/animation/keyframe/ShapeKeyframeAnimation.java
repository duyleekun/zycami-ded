/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation
extends BaseKeyframeAnimation {
    private final Path tempPath;
    private final ShapeData tempShapeData;

    public ShapeKeyframeAnimation(List object) {
        super((List)object);
        this.tempShapeData = object = new ShapeData();
        object = new Path();
        this.tempPath = object;
    }

    public Path getValue(Keyframe object, float f10) {
        ShapeData shapeData = (ShapeData)((Keyframe)object).startValue;
        object = (ShapeData)((Keyframe)object).endValue;
        this.tempShapeData.interpolateBetween(shapeData, (ShapeData)object, f10);
        object = this.tempShapeData;
        Path path = this.tempPath;
        MiscUtils.getPathFromData((ShapeData)object, path);
        return this.tempPath;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class StrokeContent
extends BaseStrokeContent {
    private final BaseKeyframeAnimation colorAnimation;
    private BaseKeyframeAnimation colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable object, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        boolean bl2;
        Paint.Cap cap = shapeStroke.getCapType().toPaintCap();
        Paint.Join join = shapeStroke.getJoinType().toPaintJoin();
        float f10 = shapeStroke.getMiterLimit();
        AnimatableIntegerValue animatableIntegerValue = shapeStroke.getOpacity();
        AnimatableFloatValue animatableFloatValue = shapeStroke.getWidth();
        List list = shapeStroke.getLineDashPattern();
        AnimatableFloatValue animatableFloatValue2 = shapeStroke.getDashOffset();
        super((LottieDrawable)((Object)object), baseLayer, cap, join, f10, animatableIntegerValue, animatableFloatValue, list, animatableFloatValue2);
        this.layer = baseLayer;
        object = shapeStroke.getName();
        this.name = object;
        this.hidden = bl2 = shapeStroke.isHidden();
        object = shapeStroke.getColor().createAnimation();
        this.colorAnimation = object;
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
    }

    public void addValueCallback(Object object, LottieValueCallback object2) {
        super.addValueCallback(object, (LottieValueCallback)object2);
        Object object3 = LottieProperty.STROKE_COLOR;
        if (object == object3) {
            object = this.colorAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback((LottieValueCallback)object2);
        } else {
            object3 = LottieProperty.COLOR_FILTER;
            if (object == object3) {
                object = this.colorFilterAnimation;
                if (object != null) {
                    object3 = this.layer;
                    ((BaseLayer)object3).removeAnimation((BaseKeyframeAnimation)object);
                }
                if (object2 == null) {
                    object = null;
                    this.colorFilterAnimation = null;
                } else {
                    this.colorFilterAnimation = object = new ValueCallbackKeyframeAnimation((LottieValueCallback)object2);
                    ((BaseKeyframeAnimation)object).addUpdateListener(this);
                    object = this.layer;
                    object2 = this.colorAnimation;
                    ((BaseLayer)object).addAnimation((BaseKeyframeAnimation)object2);
                }
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n10) {
        boolean bl2 = this.hidden;
        if (bl2) {
            return;
        }
        Object object = this.paint;
        ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation)this.colorAnimation;
        int n11 = colorKeyframeAnimation.getIntValue();
        object.setColor(n11);
        object = this.colorFilterAnimation;
        if (object != null) {
            colorKeyframeAnimation = this.paint;
            object = (ColorFilter)((BaseKeyframeAnimation)object).getValue();
            colorKeyframeAnimation.setColorFilter((ColorFilter)object);
        }
        super.draw(canvas, matrix, n10);
    }

    public String getName() {
        return this.name;
    }
}


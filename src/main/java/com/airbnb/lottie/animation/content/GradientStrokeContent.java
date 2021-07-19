/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.PointF
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class GradientStrokeContent
extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private final BaseKeyframeAnimation endPointAnimation;
    private final boolean hidden;
    private final LongSparseArray linearGradientCache;
    private final String name;
    private final LongSparseArray radialGradientCache;
    private final BaseKeyframeAnimation startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable object, BaseLayer baseLayer, GradientStroke gradientStroke) {
        int n10;
        boolean bl2;
        Paint.Cap cap = gradientStroke.getCapType().toPaintCap();
        Paint.Join join = gradientStroke.getJoinType().toPaintJoin();
        float f10 = gradientStroke.getMiterLimit();
        AnimatableIntegerValue animatableIntegerValue = gradientStroke.getOpacity();
        AnimatableFloatValue animatableFloatValue = gradientStroke.getWidth();
        List list = gradientStroke.getLineDashPattern();
        AnimatableFloatValue animatableFloatValue2 = gradientStroke.getDashOffset();
        super((LottieDrawable)((Object)object), baseLayer, cap, join, f10, animatableIntegerValue, animatableFloatValue, list, animatableFloatValue2);
        Object object2 = new LongSparseArray();
        this.linearGradientCache = object2;
        object2 = new LongSparseArray();
        this.radialGradientCache = object2;
        super();
        this.boundsRect = object2;
        this.name = object2 = gradientStroke.getName();
        object2 = gradientStroke.getGradientType();
        this.type = object2;
        this.hidden = bl2 = gradientStroke.isHidden();
        this.cacheSteps = n10 = (int)(((LottieDrawable)((Object)object)).getComposition().getDuration() / 32.0f);
        object = gradientStroke.getGradientColor().createAnimation();
        this.colorAnimation = object;
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        this.startPointAnimation = object = gradientStroke.getStartPoint().createAnimation();
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        this.endPointAnimation = object = gradientStroke.getEndPoint().createAnimation();
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
    }

    private int[] applyDynamicColorsIfNeeded(int[] nArray) {
        block4: {
            int n10;
            Integer[] integerArray = this.colorCallbackAnimation;
            if (integerArray == null) break block4;
            integerArray = (Integer[])integerArray.getValue();
            int n11 = nArray.length;
            int n12 = integerArray.length;
            if (n11 == n12) {
                for (n10 = 0; n10 < (n11 = nArray.length); ++n10) {
                    Integer n13 = integerArray[n10];
                    nArray[n10] = n11 = n13.intValue();
                }
            } else {
                int n14 = integerArray.length;
                nArray = new int[n14];
                while (n10 < (n11 = integerArray.length)) {
                    Integer n15 = integerArray[n10];
                    nArray[n10] = n11 = n15.intValue();
                    ++n10;
                }
            }
        }
        return nArray;
    }

    private int getGradientHash() {
        BaseKeyframeAnimation baseKeyframeAnimation = this.startPointAnimation;
        float f10 = baseKeyframeAnimation.getProgress();
        float f11 = this.cacheSteps;
        int n10 = Math.round(f10 *= f11);
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.endPointAnimation;
        f11 = baseKeyframeAnimation2.getProgress();
        float f12 = this.cacheSteps;
        int n11 = Math.round(f11 *= f12);
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.colorAnimation;
        f12 = baseKeyframeAnimation3.getProgress();
        int n12 = this.cacheSteps;
        float f13 = n12;
        int n13 = Math.round(f12 *= f13);
        if (n10 != 0) {
            f13 = 7.38E-43f;
            n12 = 527 * n10;
        } else {
            n12 = 17;
            f13 = 2.4E-44f;
        }
        if (n11 != 0) {
            n12 = n12 * 31 * n11;
        }
        if (n13 != 0) {
            n12 = n12 * 31 * n13;
        }
        return n12;
    }

    private LinearGradient getLinearGradient() {
        LongSparseArray longSparseArray = this.linearGradientCache;
        int n10 = this.getGradientHash();
        long l10 = n10;
        LinearGradient linearGradient = (LinearGradient)longSparseArray.get(l10);
        if (linearGradient != null) {
            return linearGradient;
        }
        linearGradient = (PointF)this.startPointAnimation.getValue();
        longSparseArray = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor = (GradientColor)this.colorAnimation.getValue();
        int[] nArray = gradientColor.getColors();
        int[] nArray2 = this.applyDynamicColorsIfNeeded(nArray);
        float[] fArray = gradientColor.getPositions();
        float f10 = linearGradient.x;
        float f11 = linearGradient.y;
        float f12 = ((PointF)longSparseArray).x;
        float f13 = ((PointF)longSparseArray).y;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        linearGradient = new LinearGradient(f10, f11, f12, f13, nArray2, fArray, tileMode);
        this.linearGradientCache.put(l10, linearGradient);
        return linearGradient;
    }

    private RadialGradient getRadialGradient() {
        LongSparseArray longSparseArray = this.radialGradientCache;
        int n10 = this.getGradientHash();
        long l10 = n10;
        RadialGradient radialGradient = (RadialGradient)longSparseArray.get(l10);
        if (radialGradient != null) {
            return radialGradient;
        }
        radialGradient = (PointF)this.startPointAnimation.getValue();
        longSparseArray = (PointF)this.endPointAnimation.getValue();
        GradientColor gradientColor = (GradientColor)this.colorAnimation.getValue();
        int[] nArray = gradientColor.getColors();
        int[] nArray2 = this.applyDynamicColorsIfNeeded(nArray);
        float[] fArray = gradientColor.getPositions();
        float f10 = radialGradient.x;
        float f11 = radialGradient.y;
        float f12 = ((PointF)longSparseArray).x;
        float f13 = ((PointF)longSparseArray).y;
        double d10 = f12 - f10;
        double d11 = f13 - f11;
        float f14 = (float)Math.hypot(d10, d11);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        radialGradient = new RadialGradient(f10, f11, f14, nArray2, fArray, tileMode);
        this.radialGradientCache.put(l10, radialGradient);
        return radialGradient;
    }

    public void addValueCallback(Object object, LottieValueCallback object2) {
        super.addValueCallback(object, (LottieValueCallback)object2);
        Object object3 = LottieProperty.GRADIENT_COLOR;
        if (object == object3) {
            object = this.colorCallbackAnimation;
            if (object != null) {
                object3 = this.layer;
                ((BaseLayer)object3).removeAnimation((BaseKeyframeAnimation)object);
            }
            if (object2 == null) {
                object = null;
                this.colorCallbackAnimation = null;
            } else {
                this.colorCallbackAnimation = object = new ValueCallbackKeyframeAnimation((LottieValueCallback)object2);
                ((BaseKeyframeAnimation)object).addUpdateListener(this);
                object = this.layer;
                object2 = this.colorCallbackAnimation;
                ((BaseLayer)object).addAnimation((BaseKeyframeAnimation)object2);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n10) {
        boolean bl2 = this.hidden;
        if (bl2) {
            return;
        }
        Object object = this.boundsRect;
        this.getBounds((RectF)object, matrix, false);
        object = this.type;
        GradientType gradientType = GradientType.LINEAR;
        object = object == gradientType ? this.getLinearGradient() : this.getRadialGradient();
        object.setLocalMatrix(matrix);
        this.paint.setShader((Shader)object);
        super.draw(canvas, matrix, n10);
    }

    public String getName() {
        return this.name;
    }
}


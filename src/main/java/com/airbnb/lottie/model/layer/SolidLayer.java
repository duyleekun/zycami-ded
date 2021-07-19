/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer
extends BaseLayer {
    private BaseKeyframeAnimation colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    public SolidLayer(LottieDrawable object, Layer layer) {
        super((LottieDrawable)((Object)object), layer);
        super();
        this.rect = object;
        super();
        this.paint = object;
        Object object2 = new float[8];
        this.points = object2;
        object2 = new Path;
        super();
        this.path = (Path)object2;
        this.layerModel = layer;
        object.setAlpha(0);
        object2 = Paint.Style.FILL;
        object.setStyle((Paint.Style)object2);
        int n10 = layer.getSolidColor();
        object.setColor(n10);
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        super.addValueCallback(object, lottieValueCallback);
        ColorFilter colorFilter = LottieProperty.COLOR_FILTER;
        if (object == colorFilter) {
            if (lottieValueCallback == null) {
                object = null;
                this.colorFilterAnimation = null;
            } else {
                this.colorFilterAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int n10) {
        float f10;
        int n11;
        Object object = this.layerModel;
        int n12 = Color.alpha((int)((Layer)object).getSolidColor());
        if (n12 == 0) {
            return;
        }
        Object object2 = this.transform.getOpacity();
        if (object2 == null) {
            n11 = 100;
            f10 = 1.4E-43f;
        } else {
            object2 = (Integer)this.transform.getOpacity().getValue();
            n11 = (Integer)object2;
        }
        float f11 = n10;
        int n13 = 1132396544;
        float f12 = 255.0f;
        f11 /= f12;
        float f13 = (float)n12 / f12;
        f10 = n11;
        f13 *= f10;
        n11 = 1120403456;
        f10 = 100.0f;
        f11 = f11 * (f13 /= f10) * f12;
        n10 = (int)f11;
        this.paint.setAlpha(n10);
        object = this.colorFilterAnimation;
        if (object != null) {
            object2 = this.paint;
            object = (ColorFilter)((BaseKeyframeAnimation)object).getValue();
            object2.setColorFilter((ColorFilter)object);
        }
        if (n10 > 0) {
            Object object3 = this.points;
            n12 = 0;
            object = null;
            object3[0] = 0.0f;
            n13 = 1;
            f12 = Float.MIN_VALUE;
            object3[n13] = 0.0f;
            Layer layer = this.layerModel;
            float f14 = layer.getSolidWidth();
            int n14 = 2;
            object3[n14] = f14;
            object3 = this.points;
            int n15 = 3;
            f14 = 4.2E-45f;
            object3[n15] = 0.0f;
            float f15 = this.layerModel.getSolidWidth();
            int n16 = 4;
            object3[n16] = f15;
            object3 = this.points;
            Layer layer2 = this.layerModel;
            f15 = layer2.getSolidHeight();
            int n17 = 5;
            object3[n17] = f15;
            object3 = this.points;
            int n18 = 6;
            f15 = 8.4E-45f;
            object3[n18] = 0.0f;
            object2 = this.layerModel;
            n11 = ((Layer)object2).getSolidHeight();
            f10 = n11;
            int n19 = 7;
            object3[n19] = f10;
            object3 = this.points;
            matrix.mapPoints(object3);
            this.path.reset();
            matrix = this.path;
            object3 = this.points;
            f10 = object3[0];
            f11 = object3[n13];
            matrix.moveTo(f10, f11);
            matrix = this.path;
            object3 = this.points;
            f10 = object3[n14];
            f11 = object3[n15];
            matrix.lineTo(f10, f11);
            matrix = this.path;
            object3 = this.points;
            f10 = object3[n16];
            f11 = object3[n17];
            matrix.lineTo(f10, f11);
            matrix = this.path;
            object3 = this.points;
            f10 = object3[n18];
            f11 = object3[n19];
            matrix.lineTo(f10, f11);
            matrix = this.path;
            object3 = this.points;
            f13 = object3[0];
            f11 = object3[n13];
            matrix.lineTo(f13, f11);
            this.path.close();
            matrix = this.path;
            object3 = this.paint;
            canvas.drawPath((Path)matrix, (Paint)object3);
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        super.getBounds(rectF, matrix, bl2);
        matrix = this.rect;
        float f10 = this.layerModel.getSolidWidth();
        float f11 = this.layerModel.getSolidHeight();
        matrix.set(0.0f, 0.0f, f10, f11);
        matrix = this.boundsMatrix;
        RectF rectF2 = this.rect;
        matrix.mapRect(rectF2);
        matrix = this.rect;
        rectF.set((RectF)matrix);
    }
}


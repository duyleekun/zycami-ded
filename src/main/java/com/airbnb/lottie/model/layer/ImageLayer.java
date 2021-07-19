/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer
extends BaseLayer {
    private BaseKeyframeAnimation colorFilterAnimation;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    public ImageLayer(LottieDrawable object, Layer layer) {
        super((LottieDrawable)((Object)object), layer);
        super(3);
        this.paint = object;
        super();
        this.src = object;
        super();
        this.dst = object;
    }

    private Bitmap getBitmap() {
        String string2 = this.layerModel.getRefId();
        return this.lottieDrawable.getImageAsset(string2);
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
        int n11;
        Bitmap bitmap = this.getBitmap();
        if (bitmap != null && (n11 = bitmap.isRecycled()) == 0) {
            float f10 = Utils.dpScale();
            Paint paint = this.paint;
            paint.setAlpha(n10);
            BaseKeyframeAnimation baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                paint = this.paint;
                baseKeyframeAnimation = (ColorFilter)baseKeyframeAnimation.getValue();
                paint.setColorFilter((ColorFilter)baseKeyframeAnimation);
            }
            canvas.save();
            canvas.concat(matrix);
            matrix = this.src;
            n10 = bitmap.getWidth();
            int n12 = bitmap.getHeight();
            matrix.set(0, 0, n10, n12);
            matrix = this.dst;
            float f11 = (float)bitmap.getWidth() * f10;
            n10 = (int)f11;
            n12 = bitmap.getHeight();
            float f12 = (float)n12 * f10;
            n11 = (int)f12;
            matrix.set(0, 0, n10, n11);
            matrix = this.src;
            baseKeyframeAnimation = this.dst;
            Paint paint2 = this.paint;
            canvas.drawBitmap(bitmap, (Rect)matrix, (Rect)baseKeyframeAnimation, paint2);
            canvas.restore();
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        super.getBounds(rectF, matrix, bl2);
        matrix = this.getBitmap();
        if (matrix != null) {
            int n10 = matrix.getWidth();
            float f10 = n10;
            float f11 = Utils.dpScale();
            f10 *= f11;
            int n11 = matrix.getHeight();
            float f12 = n11;
            f11 = Utils.dpScale();
            f12 *= f11;
            f11 = 0.0f;
            rectF.set(0.0f, 0.0f, f10, f12);
            matrix = this.boundsMatrix;
            matrix.mapRect(rectF);
        }
    }
}


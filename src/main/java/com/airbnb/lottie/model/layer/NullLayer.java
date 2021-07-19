/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.RectF
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;

public class NullLayer
extends BaseLayer {
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int n10) {
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        super.getBounds(rectF, matrix, bl2);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}


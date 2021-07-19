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
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;

public class ShapeLayer
extends BaseLayer {
    private final ContentGroup contentGroup;

    public ShapeLayer(LottieDrawable object, Layer object2) {
        super((LottieDrawable)((Object)object), (Layer)object2);
        object2 = ((Layer)object2).getShapes();
        Object object3 = new ShapeGroup("__container", (List)object2, false);
        this.contentGroup = object2 = new ContentGroup((LottieDrawable)((Object)object), this, (ShapeGroup)object3);
        object = Collections.emptyList();
        object3 = Collections.emptyList();
        ((ContentGroup)object2).setContents((List)object, (List)object3);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int n10) {
        this.contentGroup.draw(canvas, matrix, n10);
    }

    public void getBounds(RectF rectF, Matrix object, boolean bl2) {
        super.getBounds(rectF, (Matrix)object, bl2);
        object = this.contentGroup;
        Matrix matrix = this.boundsMatrix;
        ((ContentGroup)object).getBounds(rectF, matrix, bl2);
    }

    public void resolveChildKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, n10, list, keyPath2);
    }
}


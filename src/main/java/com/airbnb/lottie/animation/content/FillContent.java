/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FillContent
implements DrawingContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent {
    private final BaseKeyframeAnimation colorAnimation;
    private BaseKeyframeAnimation colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List paths;

    public FillContent(LottieDrawable object, BaseLayer baseLayer, ShapeFill shapeFill) {
        boolean bl2;
        Path path;
        this.path = path = new Path();
        int n10 = 1;
        Object object2 = new LPaint(n10);
        this.paint = object2;
        this.paths = object2;
        this.layer = baseLayer;
        object2 = shapeFill.getName();
        this.name = object2;
        this.hidden = bl2 = shapeFill.isHidden();
        this.lottieDrawable = object;
        object = shapeFill.getColor();
        if (object != null && (object = shapeFill.getOpacity()) != null) {
            object = shapeFill.getFillType();
            path.setFillType((Path.FillType)object);
            object = shapeFill.getColor().createAnimation();
            this.colorAnimation = object;
            ((BaseKeyframeAnimation)object).addUpdateListener(this);
            baseLayer.addAnimation((BaseKeyframeAnimation)object);
            this.opacityAnimation = object = shapeFill.getOpacity().createAnimation();
            ((BaseKeyframeAnimation)object).addUpdateListener(this);
            baseLayer.addAnimation((BaseKeyframeAnimation)object);
            return;
        }
        this.colorAnimation = null;
        this.opacityAnimation = null;
    }

    public void addValueCallback(Object object, LottieValueCallback object2) {
        Object object3 = LottieProperty.COLOR;
        if (object == object3) {
            object = this.colorAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback((LottieValueCallback)object2);
        } else {
            object3 = LottieProperty.OPACITY;
            if (object == object3) {
                object = this.opacityAnimation;
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
                        object2 = this.colorFilterAnimation;
                        ((BaseLayer)object).addAnimation((BaseKeyframeAnimation)object2);
                    }
                }
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n10) {
        boolean bl2 = this.hidden;
        if (bl2) {
            return;
        }
        String string2 = "FillContent#draw";
        L.beginSection(string2);
        Paint paint = this.paint;
        int n11 = ((ColorKeyframeAnimation)this.colorAnimation).getIntValue();
        paint.setColor(n11);
        float f10 = n10;
        float f11 = 255.0f;
        f10 /= f11;
        Integer n12 = (Integer)this.opacityAnimation.getValue();
        float f12 = n12.intValue();
        f10 = f10 * f12 / 100.0f * f11;
        n10 = (int)f10;
        paint = this.paint;
        n11 = 255;
        f12 = 3.57E-43f;
        int n13 = 0;
        n10 = MiscUtils.clamp(n10, 0, n11);
        paint.setAlpha(n10);
        Object object = this.colorFilterAnimation;
        if (object != null) {
            paint = this.paint;
            object = (ColorFilter)((BaseKeyframeAnimation)object).getValue();
            paint.setColorFilter((ColorFilter)object);
        }
        object = this.path;
        object.reset();
        while (n13 < (n10 = (object = this.paths).size())) {
            object = this.path;
            paint = ((PathContent)this.paths.get(n13)).getPath();
            object.addPath((Path)paint, matrix);
            ++n13;
        }
        matrix = this.path;
        object = this.paint;
        canvas.drawPath((Path)matrix, (Paint)object);
        L.endSection(string2);
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        List list;
        int n10;
        this.path.reset();
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < (n10 = (list = this.paths).size()); ++i10) {
            list = this.path;
            Path path = ((PathContent)this.paths.get(i10)).getPath();
            list.addPath(path, matrix);
        }
        this.path.computeBounds(rectF, false);
        float f12 = rectF.left;
        f10 = 1.0f;
        f11 = rectF.top - f10;
        float f13 = rectF.right + f10;
        float f14 = rectF.bottom + f10;
        rectF.set(f12 -= f10, f11, f13, f14);
    }

    public String getName() {
        return this.name;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n10, list, keyPath2, this);
    }

    public void setContents(List list, List list2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list2.size()); ++i10) {
            Content content = (Content)list2.get(i10);
            boolean bl2 = content instanceof PathContent;
            if (!bl2) continue;
            List list3 = this.paths;
            content = (PathContent)content;
            list3.add(content);
        }
    }
}


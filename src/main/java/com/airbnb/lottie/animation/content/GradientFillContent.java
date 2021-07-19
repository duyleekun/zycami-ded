/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PointF
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
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
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class GradientFillContent
implements DrawingContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private BaseKeyframeAnimation colorFilterAnimation;
    private final BaseKeyframeAnimation endPointAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LongSparseArray linearGradientCache;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List paths;
    private final LongSparseArray radialGradientCache;
    private final BaseKeyframeAnimation startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable object, BaseLayer baseLayer, GradientFill gradientFill) {
        int n10;
        boolean bl2;
        LongSparseArray longSparseArray;
        this.linearGradientCache = longSparseArray = new LongSparseArray();
        this.radialGradientCache = longSparseArray = new LongSparseArray();
        this.path = longSparseArray;
        Object object2 = new LPaint(1);
        this.paint = object2;
        super();
        this.boundsRect = object2;
        super();
        this.paths = object2;
        this.layer = baseLayer;
        object2 = gradientFill.getName();
        this.name = object2;
        this.hidden = bl2 = gradientFill.isHidden();
        this.lottieDrawable = object;
        object2 = gradientFill.getGradientType();
        this.type = object2;
        object2 = gradientFill.getFillType();
        longSparseArray.setFillType((Path.FillType)object2);
        this.cacheSteps = n10 = (int)(((LottieDrawable)((Object)object)).getComposition().getDuration() / 32.0f);
        object = gradientFill.getGradientColor().createAnimation();
        this.colorAnimation = object;
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        this.opacityAnimation = object = gradientFill.getOpacity().createAnimation();
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        this.startPointAnimation = object = gradientFill.getStartPoint().createAnimation();
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        this.endPointAnimation = object = gradientFill.getEndPoint().createAnimation();
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
        gradientColor = new LinearGradient(f10, f11, f12, f13, nArray2, fArray, tileMode);
        this.linearGradientCache.put(l10, gradientColor);
        return gradientColor;
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
        d11 = Math.hypot(d10, d11);
        f12 = (float)d11;
        f13 = 0.0f;
        longSparseArray = null;
        float f14 = f12 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object <= 0) {
            n10 = 981668463;
            f12 = 0.001f;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        radialGradient = new RadialGradient(f10, f11, f12, nArray2, fArray, tileMode);
        this.radialGradientCache.put(l10, radialGradient);
        return radialGradient;
    }

    public void addValueCallback(Object object, LottieValueCallback object2) {
        Object object3 = LottieProperty.OPACITY;
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
                    this.colorFilterAnimation = null;
                } else {
                    this.colorFilterAnimation = object = new ValueCallbackKeyframeAnimation((LottieValueCallback)object2);
                    ((BaseKeyframeAnimation)object).addUpdateListener(this);
                    object = this.layer;
                    object2 = this.colorFilterAnimation;
                    ((BaseLayer)object).addAnimation((BaseKeyframeAnimation)object2);
                }
            } else {
                object3 = LottieProperty.GRADIENT_COLOR;
                if (object == object3) {
                    object = this.colorCallbackAnimation;
                    if (object != null) {
                        object3 = this.layer;
                        ((BaseLayer)object3).removeAnimation((BaseKeyframeAnimation)object);
                    }
                    if (object2 == null) {
                        this.colorCallbackAnimation = null;
                    } else {
                        this.linearGradientCache.clear();
                        this.radialGradientCache.clear();
                        this.colorCallbackAnimation = object = new ValueCallbackKeyframeAnimation((LottieValueCallback)object2);
                        ((BaseKeyframeAnimation)object).addUpdateListener(this);
                        object = this.layer;
                        object2 = this.colorCallbackAnimation;
                        ((BaseLayer)object).addAnimation((BaseKeyframeAnimation)object2);
                    }
                }
            }
        }
    }

    public void draw(Canvas canvas, Matrix object, int n10) {
        Object object2;
        int n11;
        boolean bl2 = this.hidden;
        if (bl2) {
            return;
        }
        String string2 = "GradientFillContent#draw";
        L.beginSection(string2);
        this.path.reset();
        Object object3 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < (n11 = (object2 = this.paths).size()); ++i10) {
            object2 = this.path;
            Path path = ((PathContent)this.paths.get(i10)).getPath();
            object2.addPath(path, (Matrix)object);
        }
        object3 = this.path;
        object2 = this.boundsRect;
        object3.computeBounds((RectF)object2, false);
        object3 = this.type;
        object2 = GradientType.LINEAR;
        object3 = object3 == object2 ? this.getLinearGradient() : this.getRadialGradient();
        object3.setLocalMatrix((Matrix)object);
        this.paint.setShader((Shader)object3);
        object = this.colorFilterAnimation;
        if (object != null) {
            object3 = this.paint;
            object = (ColorFilter)((BaseKeyframeAnimation)object).getValue();
            object3.setColorFilter((ColorFilter)object);
        }
        float f11 = n10;
        float f12 = 255.0f;
        f10 = ((Integer)this.opacityAnimation.getValue()).intValue();
        int n12 = (int)((f11 /= f12) * f10 / 100.0f * f12);
        Paint paint = this.paint;
        n12 = MiscUtils.clamp(n12, 0, 255);
        paint.setAlpha(n12);
        object = this.path;
        paint = this.paint;
        canvas.drawPath((Path)object, paint);
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


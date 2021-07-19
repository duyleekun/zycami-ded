/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.DashPathEffect
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.PathMeasure
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public abstract class BaseStrokeContent
implements BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent,
DrawingContent {
    private BaseKeyframeAnimation colorFilterAnimation;
    private final List dashPatternAnimations;
    private final BaseKeyframeAnimation dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    public final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation opacityAnimation;
    public final Paint paint;
    private final Path path;
    private final List pathGroups;
    private final PathMeasure pm;
    private final RectF rect;
    private final Path trimPathPath;
    private final BaseKeyframeAnimation widthAnimation;

    public BaseStrokeContent(LottieDrawable object, BaseLayer object2, Paint.Cap object3, Paint.Join object4, float f10, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List list, AnimatableFloatValue animatableFloatValue2) {
        int n10;
        int n11;
        int n12;
        Object object5;
        this.pm = object5 = new PathMeasure();
        this.path = object5;
        super();
        this.trimPathPath = object5;
        super();
        this.rect = object5;
        super();
        this.pathGroups = object5;
        int n13 = 1;
        super(n13);
        this.paint = object5;
        this.lottieDrawable = object;
        this.layer = object2;
        object = Paint.Style.STROKE;
        object5.setStyle((Paint.Style)object);
        object5.setStrokeCap(object3);
        object5.setStrokeJoin((Paint.Join)object4);
        object5.setStrokeMiter(f10);
        object = animatableIntegerValue.createAnimation();
        this.opacityAnimation = object;
        object = animatableFloatValue.createAnimation();
        this.widthAnimation = object;
        if (animatableFloatValue2 == null) {
            n12 = 0;
            object = null;
            this.dashPatternOffsetAnimation = null;
        } else {
            object = animatableFloatValue2.createAnimation();
            this.dashPatternOffsetAnimation = object;
        }
        int n14 = list.size();
        super(n14);
        this.dashPatternAnimations = object;
        object = new float[list.size()];
        this.dashPatternValues = (float[])object;
        n12 = 0;
        object = null;
        object3 = null;
        for (n14 = 0; n14 < (n11 = list.size()); ++n14) {
            object4 = this.dashPatternAnimations;
            BaseKeyframeAnimation baseKeyframeAnimation = ((AnimatableFloatValue)list.get(n14)).createAnimation();
            object4.add(baseKeyframeAnimation);
        }
        object3 = this.opacityAnimation;
        ((BaseLayer)object2).addAnimation((BaseKeyframeAnimation)object3);
        object3 = this.widthAnimation;
        ((BaseLayer)object2).addAnimation((BaseKeyframeAnimation)object3);
        object3 = null;
        for (n14 = 0; n14 < (n11 = (object4 = this.dashPatternAnimations).size()); ++n14) {
            object4 = (BaseKeyframeAnimation)this.dashPatternAnimations.get(n14);
            ((BaseLayer)object2).addAnimation((BaseKeyframeAnimation)object4);
        }
        object3 = this.dashPatternOffsetAnimation;
        if (object3 != null) {
            ((BaseLayer)object2).addAnimation((BaseKeyframeAnimation)object3);
        }
        this.opacityAnimation.addUpdateListener(this);
        object2 = this.widthAnimation;
        ((BaseKeyframeAnimation)object2).addUpdateListener(this);
        while (n12 < (n10 = list.size())) {
            object2 = (BaseKeyframeAnimation)this.dashPatternAnimations.get(n12);
            ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            ++n12;
        }
        object = this.dashPatternOffsetAnimation;
        if (object != null) {
            ((BaseKeyframeAnimation)object).addUpdateListener(this);
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        Object object;
        Object object2;
        int n10;
        String string2 = "StrokeContent#applyDashPattern";
        L.beginSection(string2);
        Object object3 = this.dashPatternAnimations;
        int n11 = object3.isEmpty();
        if (n11 != 0) {
            L.endSection(string2);
            return;
        }
        float f10 = Utils.getScale(matrix);
        float f11 = 0.0f;
        object3 = null;
        for (n11 = 0; n11 < (n10 = (object2 = this.dashPatternAnimations).size()); ++n11) {
            Object object4;
            float f12;
            object2 = this.dashPatternValues;
            object = (Float)((BaseKeyframeAnimation)this.dashPatternAnimations.get(n11)).getValue();
            float f13 = ((Float)object).floatValue();
            object2[n11] = f13;
            n10 = n11 % 2;
            if (n10 == 0) {
                object2 = this.dashPatternValues;
                f13 = (float)object2[n11];
                f12 = 1.0f;
                float f14 = f13 - f12;
                object4 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                if (object4 < 0) {
                    object2[n11] = f12;
                }
            } else {
                object2 = this.dashPatternValues;
                f13 = (float)object2[n11];
                f12 = 0.1f;
                float f15 = f13 - f12;
                object4 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                if (object4 < 0) {
                    object2[n11] = f12;
                }
            }
            object2 = this.dashPatternValues;
            f13 = (float)(object2[n11] * f10);
            object2[n11] = f13;
        }
        object3 = this.dashPatternOffsetAnimation;
        if (object3 == null) {
            f10 = 0.0f;
            matrix = null;
        } else {
            object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
            f11 = ((Float)object3).floatValue();
            f10 *= f11;
        }
        object3 = this.paint;
        object = this.dashPatternValues;
        object2 = new DashPathEffect((float[])object, f10);
        object3.setPathEffect((PathEffect)object2);
        L.endSection(string2);
    }

    private void applyTrimPath(Canvas canvas, BaseStrokeContent$PathGroup baseStrokeContent$PathGroup, Matrix matrix) {
        float f10;
        int n10;
        Path path;
        Object object;
        String string2 = "StrokeContent#applyTrimPath";
        L.beginSection(string2);
        Object object2 = BaseStrokeContent$PathGroup.access$200(baseStrokeContent$PathGroup);
        if (object2 == null) {
            L.endSection(string2);
            return;
        }
        this.path.reset();
        object2 = BaseStrokeContent$PathGroup.access$100(baseStrokeContent$PathGroup);
        for (int i10 = object2.size() + -1; i10 >= 0; i10 += -1) {
            object = this.path;
            path = ((PathContent)BaseStrokeContent$PathGroup.access$100(baseStrokeContent$PathGroup).get(i10)).getPath();
            object.addPath(path, matrix);
        }
        object2 = this.pm;
        object = this.path;
        path = null;
        object2.setPath((Path)object, false);
        object2 = this.pm;
        float f11 = object2.getLength();
        while ((n10 = (object = this.pm).nextContour()) != 0) {
            object = this.pm;
            f10 = object.getLength();
            f11 += f10;
        }
        f10 = ((Float)BaseStrokeContent$PathGroup.access$200(baseStrokeContent$PathGroup).getOffset().getValue()).floatValue() * f11 / 360.0f;
        Float f12 = (Float)BaseStrokeContent$PathGroup.access$200(baseStrokeContent$PathGroup).getStart().getValue();
        float f13 = f12.floatValue() * f11;
        float f14 = 100.0f;
        f13 = f13 / f14 + f10;
        Float f15 = (Float)BaseStrokeContent$PathGroup.access$200(baseStrokeContent$PathGroup).getEnd().getValue();
        float f16 = f15.floatValue() * f11 / f14 + f10;
        object = BaseStrokeContent$PathGroup.access$100(baseStrokeContent$PathGroup);
        f14 = 0.0f;
        float f17 = 0.0f;
        for (n10 = object.size() + -1; n10 >= 0; n10 += -1) {
            Paint paint;
            float f18;
            float f19;
            float f20;
            Object object3;
            Path path2 = this.trimPathPath;
            Path path3 = ((PathContent)BaseStrokeContent$PathGroup.access$100(baseStrokeContent$PathGroup).get(n10)).getPath();
            path2.set(path3);
            this.trimPathPath.transform(matrix);
            path2 = this.pm;
            path3 = this.trimPathPath;
            path2.setPath(path3, false);
            path2 = this.pm;
            float f21 = path2.getLength();
            float f22 = f16 == f11 ? 0 : (f16 > f11 ? 1 : -1);
            float f23 = 1.0f;
            if (f22 > 0 && (object3 = (f20 = (f19 = f16 - f11) - (f18 = f17 + f21)) == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1)) < 0 && (object3 = f17 == f19 ? 0 : (f17 < f19 ? -1 : 1)) < 0) {
                object3 = f13 == f11 ? 0 : (f13 > f11 ? 1 : -1);
                if (object3 > 0) {
                    f18 = (f13 - f11) / f21;
                } else {
                    object3 = false;
                    f18 = 0.0f;
                }
                f19 = Math.min(f19 / f21, f23);
                Utils.applyTrimPathIfNeeded(this.trimPathPath, f18, f19, 0.0f);
                path3 = this.trimPathPath;
                paint = this.paint;
                canvas.drawPath(path3, paint);
            } else {
                f19 = f17 + f21;
                float f24 = f19 - f13;
                object3 = f24 == 0.0f ? 0 : (f24 < 0.0f ? -1 : 1);
                if (object3 >= 0 && (object3 = f17 == f16 ? 0 : (f17 > f16 ? 1 : -1)) <= 0) {
                    object3 = f19 == f16 ? 0 : (f19 < f16 ? -1 : 1);
                    if (object3 <= 0 && (object3 = f13 == f17 ? 0 : (f13 < f17 ? -1 : 1)) < 0) {
                        path3 = this.trimPathPath;
                        paint = this.paint;
                        canvas.drawPath(path3, paint);
                    } else {
                        object3 = f13 == f17 ? 0 : (f13 < f17 ? -1 : 1);
                        if (object3 < 0) {
                            object3 = false;
                            f18 = 0.0f;
                        } else {
                            f18 = (f13 - f17) / f21;
                        }
                        f22 = f16 == f19 ? 0 : (f16 > f19 ? 1 : -1);
                        if (f22 <= 0) {
                            f19 = f16 - f17;
                            f23 = f19 / f21;
                        }
                        Utils.applyTrimPathIfNeeded(this.trimPathPath, f18, f23, 0.0f);
                        path3 = this.trimPathPath;
                        paint = this.paint;
                        canvas.drawPath(path3, paint);
                    }
                }
            }
            f17 += f21;
        }
        L.endSection(string2);
    }

    public void addValueCallback(Object object, LottieValueCallback object2) {
        Object object3 = LottieProperty.OPACITY;
        if (object == object3) {
            object = this.opacityAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback((LottieValueCallback)object2);
        } else {
            object3 = LottieProperty.STROKE_WIDTH;
            if (object == object3) {
                object = this.widthAnimation;
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
        String string2 = "StrokeContent#draw";
        L.beginSection(string2);
        boolean bl2 = Utils.hasZeroScaleAxis(matrix);
        if (bl2) {
            L.endSection(string2);
            return;
        }
        float f10 = n10;
        float f11 = 255.0f;
        Object object = (IntegerKeyframeAnimation)this.opacityAnimation;
        float f12 = ((IntegerKeyframeAnimation)object).getIntValue();
        n10 = (int)((f10 /= f11) * f12 / 100.0f * f11);
        Object object2 = this.paint;
        int n11 = 255;
        int n12 = 0;
        n10 = MiscUtils.clamp(n10, 0, n11);
        object2.setAlpha(n10);
        Object object3 = this.paint;
        f11 = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
        f12 = Utils.getScale(matrix);
        object3.setStrokeWidth(f11 *= f12);
        object3 = this.paint;
        f10 = object3.getStrokeWidth();
        bl2 = false;
        f11 = 0.0f;
        object2 = null;
        float f13 = f10 - 0.0f;
        n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
        if (n10 <= 0) {
            L.endSection(string2);
            return;
        }
        this.applyDashPatternIfNeeded(matrix);
        object3 = this.colorFilterAnimation;
        if (object3 != null) {
            object2 = this.paint;
            object3 = (ColorFilter)((BaseKeyframeAnimation)object3).getValue();
            object2.setColorFilter((ColorFilter)object3);
        }
        while (n12 < (n10 = (object3 = this.pathGroups).size())) {
            object3 = (BaseStrokeContent$PathGroup)this.pathGroups.get(n12);
            object2 = BaseStrokeContent$PathGroup.access$200((BaseStrokeContent$PathGroup)object3);
            if (object2 != null) {
                this.applyTrimPath(canvas, (BaseStrokeContent$PathGroup)object3, matrix);
            } else {
                object2 = "StrokeContent#buildPath";
                L.beginSection((String)object2);
                this.path.reset();
                object = BaseStrokeContent$PathGroup.access$100((BaseStrokeContent$PathGroup)object3);
                for (n11 = object.size() + -1; n11 >= 0; n11 += -1) {
                    Path path = this.path;
                    Path path2 = ((PathContent)BaseStrokeContent$PathGroup.access$100((BaseStrokeContent$PathGroup)object3).get(n11)).getPath();
                    path.addPath(path2, matrix);
                }
                L.endSection((String)object2);
                object3 = "StrokeContent#drawPath";
                L.beginSection((String)object3);
                object2 = this.path;
                object = this.paint;
                canvas.drawPath((Path)object2, (Paint)object);
                L.endSection((String)object3);
            }
            ++n12;
        }
        L.endSection(string2);
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        float f10;
        Object object;
        int n10;
        String string2 = "StrokeContent#getBounds";
        L.beginSection(string2);
        this.path.reset();
        float f11 = 0.0f;
        RectF rectF2 = null;
        RectF rectF3 = null;
        float f12 = 0.0f;
        for (int i10 = 0; i10 < (n10 = (object = this.pathGroups).size()); ++i10) {
            List list;
            int n11;
            object = (BaseStrokeContent$PathGroup)this.pathGroups.get(i10);
            f10 = 0.0f;
            for (int i11 = 0; i11 < (n11 = (list = BaseStrokeContent$PathGroup.access$100((BaseStrokeContent$PathGroup)object)).size()); ++i11) {
                list = this.path;
                Path path = ((PathContent)BaseStrokeContent$PathGroup.access$100((BaseStrokeContent$PathGroup)object).get(i11)).getPath();
                list.addPath(path, matrix);
            }
        }
        matrix = this.path;
        rectF3 = this.rect;
        matrix.computeBounds(rectF3, false);
        float f13 = ((FloatKeyframeAnimation)this.widthAnimation).getFloatValue();
        rectF2 = this.rect;
        f12 = rectF2.left;
        float f14 = rectF2.top - f13;
        f10 = rectF2.right + f13;
        float f15 = rectF2.bottom + f13;
        rectF2.set(f12 -= (f13 /= 2.0f), f14, f10, f15);
        matrix = this.rect;
        rectF.set((RectF)matrix);
        f13 = rectF.left;
        f11 = 1.0f;
        f12 = rectF.top - f11;
        f14 = rectF.right + f11;
        f10 = rectF.bottom + f11;
        rectF.set(f13 -= f11, f12, f14, f10);
        L.endSection(string2);
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n10, list, keyPath2, this);
    }

    public void setContents(List list, List list2) {
        ShapeTrimPath$Type shapeTrimPath$Type;
        Object object;
        boolean bl2;
        Object object2;
        int n10;
        Content content = null;
        for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
            object2 = (Content)list.get(n10);
            bl2 = object2 instanceof TrimPathContent;
            if (!bl2 || (object = ((TrimPathContent)(object2 = (TrimPathContent)object2)).getType()) != (shapeTrimPath$Type = ShapeTrimPath$Type.INDIVIDUALLY)) continue;
            content = object2;
        }
        if (content != null) {
            content.addListener(this);
        }
        n10 = 0;
        BaseStrokeContent$PathGroup baseStrokeContent$PathGroup = null;
        for (int i10 = list2.size() + -1; i10 >= 0; i10 += -1) {
            object2 = (Content)list2.get(i10);
            bl2 = object2 instanceof TrimPathContent;
            if (bl2) {
                ShapeTrimPath$Type shapeTrimPath$Type2;
                object = object2;
                object = (TrimPathContent)object2;
                shapeTrimPath$Type = ((TrimPathContent)object).getType();
                if (shapeTrimPath$Type == (shapeTrimPath$Type2 = ShapeTrimPath$Type.INDIVIDUALLY)) {
                    if (baseStrokeContent$PathGroup != null) {
                        object2 = this.pathGroups;
                        object2.add(baseStrokeContent$PathGroup);
                    }
                    baseStrokeContent$PathGroup = new BaseStrokeContent$PathGroup((TrimPathContent)object, null);
                    ((TrimPathContent)object).addListener(this);
                    continue;
                }
            }
            if (!(bl2 = object2 instanceof PathContent)) continue;
            if (baseStrokeContent$PathGroup == null) {
                baseStrokeContent$PathGroup = new BaseStrokeContent$PathGroup((TrimPathContent)content, null);
            }
            object = BaseStrokeContent$PathGroup.access$100(baseStrokeContent$PathGroup);
            object2 = (PathContent)object2;
            object.add(object2);
        }
        if (baseStrokeContent$PathGroup != null) {
            list = this.pathGroups;
            list.add(baseStrokeContent$PathGroup);
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.CompoundTrimPathContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent
implements BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent,
PathContent {
    private final BaseKeyframeAnimation cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation positionAnimation;
    private final RectF rect;
    private final BaseKeyframeAnimation sizeAnimation;
    private CompoundTrimPathContent trimPaths;

    public RectangleContent(LottieDrawable object, BaseLayer baseLayer, RectangleShape object2) {
        boolean bl2;
        Object object3 = new Path();
        this.path = object3;
        this.rect = object3;
        super();
        this.trimPaths = object3;
        object3 = ((RectangleShape)object2).getName();
        this.name = object3;
        this.hidden = bl2 = ((RectangleShape)object2).isHidden();
        this.lottieDrawable = object;
        object = ((RectangleShape)object2).getPosition().createAnimation();
        this.positionAnimation = object;
        object3 = ((RectangleShape)object2).getSize().createAnimation();
        this.sizeAnimation = object3;
        this.cornerRadiusAnimation = object2 = ((RectangleShape)object2).getCornerRadius().createAnimation();
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        baseLayer.addAnimation((BaseKeyframeAnimation)object3);
        baseLayer.addAnimation((BaseKeyframeAnimation)object2);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        ((BaseKeyframeAnimation)object3).addUpdateListener(this);
        ((BaseKeyframeAnimation)object2).addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        Object object2 = LottieProperty.RECTANGLE_SIZE;
        if (object == object2) {
            object = this.sizeAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
        } else {
            object2 = LottieProperty.POSITION;
            if (object == object2) {
                object = this.positionAnimation;
                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
            } else {
                object2 = LottieProperty.CORNER_RADIUS;
                if (object == object2) {
                    object = this.cornerRadiusAnimation;
                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        Path path;
        float f10;
        float f11;
        float f12;
        float f13;
        RectF rectF;
        float f14;
        RectangleContent rectangleContent = this;
        boolean bl2 = this.isPathValid;
        if (bl2) {
            return this.path;
        }
        Object object = this.path;
        object.reset();
        bl2 = this.hidden;
        boolean bl3 = true;
        if (bl2) {
            this.isPathValid = bl3;
            return this.path;
        }
        object = (PointF)this.sizeAnimation.getValue();
        float f15 = ((PointF)object).x;
        float f16 = 2.0f;
        f15 /= f16;
        float f17 = ((PointF)object).y / f16;
        BaseKeyframeAnimation baseKeyframeAnimation = this.cornerRadiusAnimation;
        Path path2 = null;
        if (baseKeyframeAnimation == null) {
            baseKeyframeAnimation = null;
            f14 = 0.0f;
        } else {
            baseKeyframeAnimation = (FloatKeyframeAnimation)baseKeyframeAnimation;
            f14 = ((FloatKeyframeAnimation)baseKeyframeAnimation).getFloatValue();
        }
        float f18 = Math.min(f15, f17);
        float f19 = f14 == f18 ? 0 : (f14 > f18 ? 1 : -1);
        if (f19 > 0) {
            f14 = f18;
        }
        PointF pointF = (PointF)rectangleContent.positionAnimation.getValue();
        Path path3 = rectangleContent.path;
        float f20 = pointF.x + f15;
        float f21 = pointF.y - f17 + f14;
        path3.moveTo(f20, f21);
        path3 = rectangleContent.path;
        f20 = pointF.x + f15;
        f21 = pointF.y + f17 - f14;
        path3.lineTo(f20, f21);
        float f22 = f14 - 0.0f;
        f19 = f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1);
        f20 = 0.0f;
        f21 = 90.0f;
        if (f19 > 0) {
            rectF = rectangleContent.rect;
            f13 = pointF.x;
            f12 = f13 + f15;
            f11 = f14 * f16;
            f12 -= f11;
            f10 = pointF.y;
            float f23 = f10 + f17;
            f11 = f23 - f11;
            rectF.set(f12, f11, f13 += f15, f10 += f17);
            rectF = rectangleContent.path;
            RectF rectF2 = rectangleContent.rect;
            rectF.arcTo(rectF2, 0.0f, f21, false);
        }
        path2 = rectangleContent.path;
        float f24 = pointF.x - f15 + f14;
        f13 = pointF.y + f17;
        path2.lineTo(f24, f13);
        if (f19 > 0) {
            path2 = rectangleContent.rect;
            f24 = pointF.x;
            f13 = f24 - f15;
            f12 = pointF.y;
            f11 = f12 + f17;
            f10 = f14 * f16;
            f24 = f24 - f15 + f10;
            path2.set(f13, f11 -= f10, f24, f12 += f17);
            path2 = rectangleContent.path;
            rectF = rectangleContent.rect;
            path2.arcTo(rectF, f21, f21, false);
        }
        path2 = rectangleContent.path;
        f24 = pointF.x - f15;
        f13 = pointF.y - f17 + f14;
        path2.lineTo(f24, f13);
        if (f19 > 0) {
            path2 = rectangleContent.rect;
            f24 = pointF.x;
            f13 = f24 - f15;
            f12 = pointF.y;
            f11 = f12 - f17;
            f24 -= f15;
            f10 = f14 * f16;
            f12 = f12 - f17 + f10;
            path2.set(f13, f11, f24 += f10, f12);
            path2 = rectangleContent.path;
            rectF = rectangleContent.rect;
            f13 = 180.0f;
            path2.arcTo(rectF, f13, f21, false);
        }
        path2 = rectangleContent.path;
        f24 = pointF.x + f15 - f14;
        f13 = pointF.y - f17;
        path2.lineTo(f24, f13);
        if (f19 > 0) {
            path2 = rectangleContent.rect;
            float f25 = pointF.x;
            f24 = f25 + f15;
            f24 -= (f14 *= f16);
            f16 = pointF.y;
            f18 = f16 - f17;
            f16 = f16 - f17 + f14;
            path2.set(f24, f18, f25 += f15, f16);
            object = rectangleContent.path;
            path = rectangleContent.rect;
            f16 = 270.0f;
            object.arcTo((RectF)path, f16, f21, false);
        }
        rectangleContent.path.close();
        object = rectangleContent.trimPaths;
        path = rectangleContent.path;
        ((CompoundTrimPathContent)object).apply(path);
        rectangleContent.isPathValid = bl3;
        return rectangleContent.path;
    }

    public void onValueChanged() {
        this.invalidate();
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n10, list, keyPath2, this);
    }

    public void setContents(List list, List list2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            ShapeTrimPath$Type shapeTrimPath$Type;
            Object object;
            Content content = (Content)list.get(i10);
            boolean bl2 = content instanceof TrimPathContent;
            if (!bl2 || (object = ((TrimPathContent)(content = (TrimPathContent)content)).getType()) != (shapeTrimPath$Type = ShapeTrimPath$Type.SIMULTANEOUSLY)) continue;
            object = this.trimPaths;
            ((CompoundTrimPathContent)object).addTrimPath((TrimPathContent)content);
            ((TrimPathContent)content).addListener(this);
        }
    }
}

